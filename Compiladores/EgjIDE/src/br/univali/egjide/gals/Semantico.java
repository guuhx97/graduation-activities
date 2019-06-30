package br.univali.egjide.gals;

import br.univali.egjide.visao.EgjIDE;
import br.univali.egjide.exception.BusinessException;
import br.univali.egjide.exception.InfoException;
import br.univali.egjide.modelo.Operacao;
import br.univali.egjide.modelo.OperacaoRelacional;
import br.univali.egjide.modelo.Simbolo;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Semantico implements Constants {

    public static List<Simbolo> tabela;
    public static String msgTela="";
    private Stack<String> pilha;
    private Simbolo temp;
    private int contIF;
    private int contELSE;
    private int contWHILE;
    private int contDO;
    private int contFor;
    private Operacao finalFila;
    private OperacaoRelacional opRel;

    public Semantico() {

        tabela = new ArrayList();
        pilha = new Stack();
        temp = new Simbolo();
        contIF = 0;
        contELSE = 0;
        contWHILE = 0;
        contDO = 0;
        contFor = 0;
        pilha.push("Global");
        opRel = new OperacaoRelacional();
    }

    public void executeAction(int action, Token token) throws SemanticError, BusinessException, InfoException {

        switch (action) {
            case 1: // name
                if (!temp.isInicializado()) {
                    temp.setNome(token.getLexeme());
                }
                System.out.println("Ação nome #" + action + ", Token: " + token.getLexeme());
                break;
            case 2: // type
                temp.setTipo(token.getLexeme());
                System.out.println("Ação tipo #" + action + ", Token: " + token.getLexeme());
                break;
            case 3: // inicialized
                if (temp.getTipo() == null) {
                    verificaDeclaracao(temp.getNome());
                }
                temp.setInicializado(true);
                System.out.println("Ação inicializado #" + action + ", Token: " + token.getLexeme());
                break;
            case 4: // used
                temp.setUsada(true);
                System.out.println("Ação usado #" + action + ", Token: " + token.getLexeme());
                break;
            case 5: // scope
                inserePilha(token);
                if (token.getLexeme().equals("while")) {
                    opRel.setWhile(true);
                } else if (token.getLexeme().equals("for")) {
                    opRel.setFor(true);
                    temp.setOpRel(opRel);
                }
                System.out.println("Ação escopo #" + action + ", Token: " + token.getLexeme());
                break;
            case 6: // param
                temp.setParam(true);
                System.out.println("Ação parametro #" + action + ", Token: " + token.getLexeme());
                break;
            case 7: // position
                temp.setPos(token.getPosition());
                System.out.println("Ação posição #" + action + ", Token: " + token.getLexeme());
                break;
            case 8: // vector
                temp.setVet(true);
                System.out.println("Ação vetor #" + action + ", Token: " + token.getLexeme());
                break;
            case 9: // matrix
                //temp.setMatriz(true);
                System.out.println("Ação matrix #" + action + ", Token: " + token.getLexeme());
                break;
            case 10: // ref
                //temp.setRef(true);
                System.out.println("Ação referencia #" + action + ", Token: " + token.getLexeme());
                break;
            case 11: // func
                temp.setFunc(true);
                Simbolo retorno = buscaTabela(temp.getNome());
                if (temp.getTipo() != null && temp.isFunc()) {
                    insereTabela();
                } else if (retorno != null) {
                    temp.setTipo(retorno.getTipo());
                    temp.setUsada(true);
                    retorno.setUsada(true);
                } else {
                    throw new BusinessException("Função não declarada: " + temp.getNome());
                }
                temp = new Simbolo();
                System.out.println("Ação função #" + action + ", Token: " + token.getLexeme());
                break;
            case 12: // final line
                insereTabela();
                EgjIDE.gerador.novaLinha(temp);
                if (!temp.getOpRel().isFor()) {
                    temp = new Simbolo();
                }
                System.out.println("Ação ; #" + action + ", Token: " + token.getLexeme());
                break;
            case 13: // final scope
                System.out.println("Ação ; #" + action + ", Token: " + token.getLexeme());
                if (token.getLexeme().equals("else")) {
                    opRel.setElse(true);
                    opRel.setEscopo(pilha.peek());
                    temp.setOpRel(opRel);
                    EgjIDE.gerador.novaLinha(temp);
                } else /*if(!opRel.isIsWhile())*/ {
                    opRel.setFinalEscopo(token.getLexeme());
                    temp.setOpRel(opRel);
                    EgjIDE.gerador.novaLinha(temp);
                    opRel = new OperacaoRelacional();
                }
                temp = new Simbolo();

                System.out.println("Removido: " + pilha.pop());
                break;
            case 14: // final code
                System.out.println("Codigo chegou ao fim.");
                checarVariaveis();
                break;
            case 15: // assignment
                temp.addOperacao(token.getLexeme(), null); // adiciona uma operação de atribuiçao para ser checada Ex; a = b + c;
                finalFila = temp.getOperacoes().get(temp.getOperacoes().size() - 1);
                System.out.println("Atribuição.");
                break;
            case 16: // value
                temp.setValor(token.getLexeme());
                System.out.println("Ação ; #" + action + ", Token: " + token.getLexeme());
                if (finalFila != null && !finalFila.getOperacao().equals("+") && !finalFila.getOperacao().equals("-")) {
                    finalFila.setIndexVet(temp.getIndexVet());
                }
                break;
            case 17: // index vector
                temp.setIndexVet(token.getLexeme());
                if (finalFila != null && !finalFila.getOperacao().equals("+") && !finalFila.getOperacao().equals("-")) {
                    finalFila.setIndexVet(temp.getIndexVet());
                }
                break;
            case 18: // vector value
                temp.addValorVer(token.getLexeme());
                break;
            case 19:
                temp.setIo("read");
                verificaDeclaracao(temp.getNome());
                EgjIDE.gerador.novaLinha(temp);
                break;
            case 20:
                temp.setIo("write");
                verificaDeclaracao(temp.getNome());
                EgjIDE.gerador.novaLinha(temp);
                break;
            case 21:
                opRel.setOperando1(token.getLexeme());
                break;
            case 22:
                opRel.setOperacao(token.getLexeme());
                break;
            case 23:
                opRel.setOperando2(token.getLexeme());
                opRel.setEscopo(pilha.peek());
                temp.setOpRel(opRel);
                if (!pilha.get(pilha.size() - 1).contains("for")) {
                    EgjIDE.gerador.novaLinha(temp);
                    temp = new Simbolo();
                }
                break;
//            case 24:
//                System.out.println("Ação #" + action + ", Token: " + token.getLexeme());
                //temp.setIncrementType(token.getLexeme());
//                EgjIDE.gerador.novaLinha(temp);
//                temp = new Simbolo();
//                break;
        }
    }

    public void insereTabela() throws BusinessException {

        boolean podeInserir = true;

        temp.setEscopo(pilha.peek());
        if (temp.isFunc()) {
            pilha.push(temp.getNome());
        }
        //if (temp.getTipo() == null) {
        if (!temp.getOperacoes().isEmpty()) {
            Simbolo aux;
            if (!temp.getOperacoes().isEmpty()) {
                for (Operacao operacao : temp.getOperacoes()) {
                    if (!isDigit(operacao.getOperacao())) {
                        aux = verificaDeclaracao(operacao.getOperacao());
                        aux.setUsada(true);
                    }
                }
            }
        }
        if (tabela.size() != 0 && temp != null) {
            for (Simbolo t : tabela) {
                // 2. declaracao no mesmo escopo
                if (t.getNome().equals(temp.getNome()) && t.getEscopo().equals(temp.getEscopo())) {
                    if (!temp.isFunc()) {
                        if (temp.getTipo() != null) {
                            podeInserir = false;
                            throw new BusinessException("Nome de variavel já usado: " + t.getNome());
                        } else {
                            t.setInicializado(temp.isInicializado());
                            t.setUsada(temp.isUsada());
                            t.setParam(temp.isParam());
                            t.setPos(temp.getPos());                            
                            podeInserir = false;
                        }
                    } else {
                        throw new BusinessException("Nome de função já usado: " + t.getNome());
                    }
                }
            }
            if (podeInserir) {
                tabela.add(temp);
                System.out.println("INSERIU");
            }
        } else {
            tabela.add(temp);
            System.out.println("INSERIU");
        }

        imprimeTabela();
    }

    public void imprimeTabela() {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("NOME\tTIPO\tVALOR\tINIC\tUSADO\tESCOPO\tPARAM\tPOS\tVET\tFUNC");
        for (Simbolo t : tabela) {
            System.out.print(t.getNome() + "\t");
            System.out.print(t.getTipo() + "\t");
            System.out.print(t.getValor() + "\t");
            System.out.print(t.isInicializado() + "\t");
            System.out.print(t.isUsada() + "\t");
            System.out.print(t.getEscopo() + "\t");
            System.out.print(t.isParam() + "\t");
            System.out.print(t.getPos() + "\t");
            System.out.print(t.isVet() + "\t");
            //System.out.print(t.isMatriz() + "\t");
            //System.out.print(t.isRef() + "\t");
            System.out.print(t.isFunc() + "\n");
        }
    }

    public boolean isDigit(String s) { // checa se é numero ou operadores
        boolean retorno = false;
        retorno = s.matches("[0-9]*");
        if (s.equals("+") || s.equals("-") || s.equals("<<") || s.equals(">>")) {
            retorno = true;
        }
        return retorno;
    }

    private Simbolo buscaTabela(String nome) {
        for (Simbolo t : tabela) {
            if (t.getNome().equals(nome) && t.isFunc()) {
                return t;
            }
        }
        return null;
    }

    private void inserePilha(Token token) {
        switch (token.getLexeme()) {
            case "if":
                pilha.push("if" + contIF);
                contIF++;
                break;
            case "else":
                pilha.push("else" + contELSE);
                contELSE++;
                break;
            case "while":
                pilha.push("while" + contWHILE);
                contWHILE++;
                break;
            case "do":
                pilha.push("do" + contDO);
                contDO++;
                break;
            case "for":
                pilha.push("for" + contFor);
                contFor++;
                break;
            default:
                pilha.push(token.getLexeme());
                break;
        }
    }

    private void checarVariaveis() throws InfoException {
        String variaveis = "\n";
        for (Simbolo t : tabela) {
            if (!t.isUsada()) {
                variaveis += t.getNome() + "\n";
            }
        }
        if (!variaveis.equals("\n")) {
            throw new InfoException("identificadores nunca usados:" + variaveis);
        }
    }

    private Simbolo verificaDeclaracao(String nome) throws BusinessException {
        for (int i = (tabela.size() - 1); i >= 0; i--) {
            if (nome.equals(tabela.get(i).getNome())) {
                for (int j = (pilha.size() - 1); j >= 0; j--) {
                    if (tabela.get(i).getEscopo().equals(pilha.get(j))) {
                        if (temp.getIndexVet() != null && temp.getValor() != null && temp.getOperacoes() == null) { // Verificar se é uma atribuição de vetor vet[0] = 2;
                            if (tabela.get(i).isVet()) {
                                return tabela.get(i);
                            } else {
                                throw new BusinessException("identificador '" + nome + "' não foi declarado.");
                            }
                        } else {
                            return tabela.get(i);
                        }
                    }
                }
            }
        }
        throw new BusinessException("identificador '" + nome + "' não foi declarado.");
    }
}
