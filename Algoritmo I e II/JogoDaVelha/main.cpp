#include <iostream>
#include <stdlib.h>
#include <windows.h>
#include <time.h>

using namespace std;

int TAM =3;

static int mostrarPlacar(int qualPlacar, bool somar=false,int ganhador=0){
    static int vitoriasX = 0,vitoriasO=0,vitoriasCpu=0,empates=0;
    if(somar == true){
        if(ganhador == 1){
            vitoriasX++;
        }else if(ganhador == 2){
            vitoriasO++;
        }else if(ganhador == 3){
            vitoriasCpu++;
        }else if(ganhador == 4){
            empates++;
        }
    }else{
        if(qualPlacar == 1){
            return vitoriasX;
        }else if(qualPlacar == 2){
            return vitoriasO;
        }if(qualPlacar == 3){
            return vitoriasCpu;
        }if(qualPlacar == 4){
            return empates;
        }
    }
}

void montaTela(int matrizTela[][TAM], bool quemjoga){
   system("cls");

    (quemjoga == true ? cout<<"Jogador X ["<<mostrarPlacar(1)<<"]\t\t\tEmpates ["<<mostrarPlacar(4)<<"]\t\t\tComputador ["<<mostrarPlacar(3)<<"]" : cout<<"Jogador X ["<<mostrarPlacar(1)<<"]\t\t\tEmpates ["<<mostrarPlacar(4)<<"]\t\t\tJogador O ["<<mostrarPlacar(2)<<"]");
    cout<<"\n================================================================================\n\n";
    cout<<"     \t\t\t\t\t\t\n\n";
    for(int i=0;i<TAM;i++){
        if(i == 0){cout<<"\t";}
        else if(i==1){cout<<"\t";}
        else{cout<<"\t";}
            for(int j=0;j<TAM;j++){
                //verifica se é 5 e coloca X se é 1 e coloca O
                cout<<"\t"<<(matrizTela[i][j] == 5 ? "  X": (matrizTela[i][j] == 1?"  O":""))<<(j < 2 ? "\t|" : "");
            }
        cout<<"\n";
        cout<<(i < 2 ? "\t\t-----------------------------------" : "");
        cout<<"\n";
    }
}
bool verificaPosicaoLivre(int jogada,int matrizTela[][TAM]){
    //retorna o valor verdadeiro se a posicao estiver livre e falso se estiver ocupado
    if(jogada == 7){
        return (matrizTela[0][0] == 0 ? true:false);
    }else if(jogada == 8){
        return (matrizTela[0][1] == 0 ? true:false);
    }else if(jogada == 9){
        return (matrizTela[0][2] == 0 ? true:false);
    }else if(jogada == 4){
        return (matrizTela[1][0] == 0 ? true:false);
    }else if(jogada == 5){
        return (matrizTela[1][1] == 0 ? true:false);
    }else if(jogada == 6){
        return (matrizTela[1][2] == 0 ? true:false);
    }else if(jogada == 1){
        return (matrizTela[2][0] == 0 ? true:false);
    }else if(jogada == 2){
        return (matrizTela[2][1] == 0 ? true:false);
    }else if(jogada == 3){
        return (matrizTela[2][2] == 0 ? true:false);
    }
}
int posicaoDeJogada(int matrizTela[][TAM]){
    int posicao;
    bool verificaPosicao = false;
    //pege a cordenada da jogada ao jogador
    do{
        cout<<"Informe a coordenada de sua jogada\n";
        cin>>posicao;
    //chama a funcao que verifica a posição
        verificaPosicao = verificaPosicaoLivre(posicao,matrizTela);
        if(verificaPosicao == false){
            cout<<"Posicao Invalida\n";
        }
    }while(posicao <= 0 and posicao >= 10 or verificaPosicao == false);
    return posicao;
}
/* Inteligencia   -*/
void ajustaPrioridadeLinha(int matrizTela[][TAM],double matrizPrioridade[][TAM]){
       int somaLinha=0;
         for(int i=0;i<TAM;i++){
            for(int j=0;j<TAM;j++){
                somaLinha += matrizTela[i][j];
            }
            for(int k=0;k<TAM;k++){
                if(matrizTela[i][k] != 0){
                    matrizPrioridade[i][k] = -1.0;
                }else if(matrizTela[i][k] == 0){
                    if(somaLinha == 10){
                        matrizPrioridade[i][k] = 0.99;
                    }else if(somaLinha == 5){
                        matrizPrioridade[i][k] = 0.66;
                    }else if(somaLinha == 6){
                        matrizPrioridade[i][k] = 0.33;
                    }else if(somaLinha == 2){
                        matrizPrioridade[i][k] = 1.0;
                    }
                }
            }
            somaLinha=0;
         }
}
void ajustaPrioridadeColuna(int matrizTela[][TAM],double matrizPrioridade[][TAM]){
    int somaColuna=0;
    for(int i=0;i<TAM;i++){
        for(int j=0;j<TAM;j++){
            somaColuna += matrizTela[j][i];
        }
        for(int k=0;k<TAM;k++){
            if(matrizTela[k][i] != 0){
                    matrizPrioridade[k][i] = -1.0;
            }else if(matrizTela[k][i] == 0){
                if(somaColuna == 10){
                    (matrizPrioridade[k][i] < 0.99 ? matrizPrioridade[k][i] = 0.99: 0);
                }else if(somaColuna == 5){
                    (matrizPrioridade[k][i] < 0.66 ? matrizPrioridade[k][i] = 0.66: 0);
                }else if(somaColuna == 6){
                    (matrizPrioridade[k][i] < 0.33 ? matrizPrioridade[k][i] = 0.33: 0);
                }else if(somaColuna == 2){
                        (matrizPrioridade[k][i] < 1.0? matrizPrioridade[k][i] = 1.00: 0);
                }
            }
        }
        somaColuna=0;
    }
}
void ajustaPrioridadeDiagonalPrincipal(int matrizTela[][TAM],double matrizPrioridade[][TAM]){
    int somaDiagonalPrincipal=0;
    for(int i=0;i<TAM;i++){
        for(int j=0;j<TAM;j++){
            if(i==j){
                somaDiagonalPrincipal += matrizTela[j][i];
            }
        }
    }
    for(int i=0;i<TAM;i++){
        for(int j=0;j<TAM;j++){
            if(matrizTela[i][j] != 0){
                    matrizPrioridade[i][j] = -1.0;
            }else if(i==j && matrizTela[i][j]==0){
                if(somaDiagonalPrincipal == 10){
                    (matrizPrioridade[i][j] < 0.99?matrizPrioridade[i][j] =0.99: 0);
                }else if(somaDiagonalPrincipal == 5){
                    (matrizPrioridade[i][j] < 0.66?matrizPrioridade[i][j] =0.66: 0);
                }else if(somaDiagonalPrincipal == 6){
                    (matrizPrioridade[i][j] < 0.33?matrizPrioridade[i][j] =0.33: 0);
                }else if(somaDiagonalPrincipal == 2){
                        (matrizPrioridade[i][j] < 1.0? matrizPrioridade[i][j] = 1.0: 0);
                }
            }
        }
    }
}
void ajustaPrioridadeDiagonalSecundaria(int matrizTela[][TAM],double matrizPrioridade[][TAM]){
    int somaDiagonalSecundaria=0;
     for(int i=0;i<TAM;i++){
        for(int j=0;j<TAM;j++){
            if(i+j == 2){
                somaDiagonalSecundaria += matrizTela[j][i];
            }
        }
    }
    for(int i=0;i<TAM;i++){
        for(int j=0;j<TAM;j++){
            if(matrizTela[i][j] != 0){
                    matrizPrioridade[i][j] = -1.0;
            }else if(i+j==2 && matrizTela[i][j]==0){
                if(somaDiagonalSecundaria == 10){
                    (matrizPrioridade[i][j] < 0.99? matrizPrioridade[i][j] = 0.99: 0);
                }else  if(somaDiagonalSecundaria == 5){
                    (matrizPrioridade[i][j] < 0.66? matrizPrioridade[i][j] = 0.66:0);
                }else  if(somaDiagonalSecundaria == 6){
                    (matrizPrioridade[i][j]  < 0.33? matrizPrioridade[i][j] = 0.33: 0);
                }else if(somaDiagonalSecundaria == 2){
                        (matrizPrioridade[i][j] < 1.0? matrizPrioridade[i][j] = 1.0: 0);
                }
            }
        }
    }
}
int JogadaComputador(int matrizTela[][TAM]){
    double matriPrioridade[TAM][TAM] = {{0.0,0.0,0.0},
                                        {0.0,0.0,0.0},
                                        {0.0,0.0,0.0}};

    /*--Chama Funções para Criar prioridade para as posições e jogadas do computadores--*/
    ajustaPrioridadeLinha(matrizTela,matriPrioridade);
    ajustaPrioridadeColuna(matrizTela,matriPrioridade);
    ajustaPrioridadeDiagonalPrincipal(matrizTela,matriPrioridade);
    ajustaPrioridadeDiagonalSecundaria(matrizTela,matriPrioridade);


    /*variaveis de Controle*/
    double maiorPri= 0.0;
    int contador=0,x,y,xPrimeiraJogada,yPrimeiraJogada;
    /*repetição que verifi as prioridade e armazena a localização*/
    for(int i=0;i<TAM;i++){
        for(int j=0;j<TAM;j++){
            if(matriPrioridade[i][j] >= maiorPri){
                maiorPri = matriPrioridade[i][j];
                x=i;
                y=j;
            }
            if(matrizTela[i][j] != 0){
                contador++;
                xPrimeiraJogada=i;
                yPrimeiraJogada=j;
            }
        }
    }


    /*for(int i=0;i<3;i++){
        for(int  j=0;j<3;j++){
             cout<<matriPrioridade[i][j]<<"\t";
        }
        cout<<"\n";
    }


    Sleep(2000)*/

/*--Verifica as Duas primeiras jogadas do usuario e não permite Triangulção--*/
        if(contador == 1){
        if(xPrimeiraJogada==0 and yPrimeiraJogada==0 or xPrimeiraJogada == 2 and yPrimeiraJogada==0){
            return 5;
        }else if(xPrimeiraJogada==0 and yPrimeiraJogada==2 or xPrimeiraJogada == 2 and yPrimeiraJogada==2){
            return 5;
        }
        contador++;
    }else if(contador == 3){

        if(matrizTela[0][0] == 5 and matrizTela[2][2]==5){
            return 4;
        }else if(matrizTela[0][2] == 5 and matrizTela[2][0]==5){
            return 4;
        }

    }

/*------------------------------------------------------------------------------*/
/*- Caso não caia nas condições acima ele pega a coordenadas da maior prioridade e manda uma um retorno*/
    if(x==0 and y==0){
        return 7;
    }else if(x==0 and y==1){
        return 8;
    }else if(x==0 and y==2){
        return 9;
    }else if(x==1 and y==0){
        return 4;
    }else if(x==1 and y==1){
        return 5;
    }else if(x==1 and y==2){
        return 6;
    }else if(x==2 and y==0){
        return 1;
    }else if(x==2 and y==1){
        return 2;
    }else if(x==2 and y==2){
        return 3;
    }

    maiorPri =0;
}
/*- Soma para Correção do jogo---*/
bool somaLinha(int matrizTela[][TAM]){
    /*-Soma As linhas e verifica se alguma esta fechado se sim retorna verdadeiro senão falso-*/
    int soma=0;
    for(int i=0;i<TAM;i++){
        for(int j=0;j<TAM;j++){
            soma += matrizTela[i][j];
        }
        if(soma == 15 or soma == 3){
            return true;
        }
        soma=0;
    }
    return false;
}
bool somaColuna(int matrizTela[][TAM]){
    /*-Soma As coluna e verifica se alguma esta fechado se sim retorna verdadeiro senão falso-*/
    int soma=0;
    for(int i=0;i<TAM;i++){
        for(int j=0;j<TAM;j++){
            soma += matrizTela[j][i];
        }
        if(soma == 15 or soma == 3){
            return true;
        }
        soma =0;
    }
    return false;
}
bool somaDiagonais(int matrizTela[][TAM]){
    /*-Soma a diagonal principal e secundaria e verifica se alguem venceu, se sim retorna verdadeiro-*/
    int somaPrincipal=0, somaSecundaria=0;
    for(int i=0;i<TAM;i++){
        for(int j=0;j<TAM;j++){
            if(i==j){
                somaPrincipal += matrizTela[i][j];
            }
            if(i+j == 2){
                somaSecundaria += matrizTela[i][j];
            }
        }
    }
        if(somaPrincipal ==15 or somaPrincipal == 3 or somaSecundaria == 3 or somaSecundaria == 15){
            return true;
        }else{
            return false;
        }

}
bool verificaResultado(int matrizTela[][TAM]){
       /*-Soma as funções de soma e caso alguma retorne verdadeiro ela tambem retorna verdadeiro-*/
        bool linha=false,coluna=false,diagonal=false;
        linha=somaLinha(matrizTela);
        coluna=somaColuna(matrizTela);
        diagonal=somaDiagonais(matrizTela);
        if(linha == true or coluna == true or diagonal == true){
            return true;
        }else{
            return false;
        }

}

void jogar(int matrizTela[][TAM], bool contraQuem){
    /*-Função aonde ocorre todas as jogadas-*/
    //variaveis de controle
    int contadorDeJogadas =0,jogada,jogadaPc;
    bool recebeVitoria=false;
    //while comecando de 0 ate 8 com um total de 9 jogadas
   while(contadorDeJogadas < 9){
    //se contador de jogadas for par chama a função que pega valor do usuario principal
        if(contadorDeJogadas%2==0){
            jogada = posicaoDeJogada(matrizTela);
        }else{
    //se jogaa nao for par e contra que for verdadeiro chama a função que pe posição do computador senao pega posição do usuario secundario
           jogada = (contraQuem == true ? JogadaComputador(matrizTela) : posicaoDeJogada(matrizTela));
        }
    //os retornos das funções que pegam posições de jogo são de 1 a 9, IFs feitos para ficar na ordem do teclado numerico
        if(jogada == 7){
            matrizTela[0][0] = (contadorDeJogadas%2==0 ? 5:1);
            contadorDeJogadas++;
        }else if(jogada == 8){
            matrizTela[0][1] = (contadorDeJogadas%2==0 ? 5:1);
            contadorDeJogadas++;
        }else if(jogada == 9){
            matrizTela[0][2] = (contadorDeJogadas%2==0 ? 5:1);
            contadorDeJogadas++;
        }else if(jogada == 4){
            matrizTela[1][0] = (contadorDeJogadas%2==0 ? 5:1);
            contadorDeJogadas++;
        }else if(jogada == 5){
            matrizTela[1][1] = (contadorDeJogadas%2==0 ? 5:1);
            contadorDeJogadas++;
        }else if(jogada == 6){
            matrizTela[1][2] = (contadorDeJogadas%2==0 ? 5:1);
            contadorDeJogadas++;
        }else if(jogada == 1){
            matrizTela[2][0] = (contadorDeJogadas%2==0 ? 5:1);
            contadorDeJogadas++;
        }else if(jogada == 2){
            matrizTela[2][1] = (contadorDeJogadas%2==0 ? 5:1);
            contadorDeJogadas++;
        }else if(jogada == 3){
            matrizTela[2][2] = (contadorDeJogadas%2==0 ? 5:1);
            contadorDeJogadas++;
        }
        montaTela(matrizTela,contraQuem);
        //a partir da 4 jogada começa a verificar se tem algum ganhador
        if(contadorDeJogadas >= 4 ){
        //varivel recebeVitoria recebe o resultado das funções de verificação se retorno for true entao alguem gannhou
            recebeVitoria = verificaResultado(matrizTela);

        }
        if(recebeVitoria == true){
        //se vitoria é verdadeiro ele verifica qual dos jogadores venceu
                if((contadorDeJogadas-1)%2==0){
        //Usuario primario
                    cout<<"Jogador X Venceu";
                    Sleep(2000);
                    mostrarPlacar(0,true,1);
                    break;
                }else if((contadorDeJogadas-1)%2!=0 and contraQuem == true){
        //CPU
                    cout<<"Jogador O Venceu";
                    Sleep(2000);
                    mostrarPlacar(0,true,3);
                    break;
                }else if((contadorDeJogadas-1)%2!=0 and contraQuem == false){
        //Usuario secundario
                    cout<<"Jogador O Venceu U";
                    Sleep(2000);
                    mostrarPlacar(0,true,2);
                    break;
                }
        }else if(contadorDeJogadas == 9  && recebeVitoria == false){
        //se ninguem ganhar e acabar jogadas deu velha
                cout<<"\nDeu Velha\n";
                Sleep(2000);
                mostrarPlacar(0,true,4);
                break;
            }
        }
}

/*-Interação com usuario-*/
bool JogarDeNovo(int matrizTela[][TAM],bool contraQuem){
       int valor;
        do{
        //desenha menu
            system("cls");
            cout<<"\t\t     Gostaria de Jogar Novamente?\n\n";
            cout<<"\t\t===============================\n\n";
            cout<<"\t\t\t[1] SIM\n";
            cout<<"\t\t\t[2] NAO";
            cout<<"\n\n\t\t===============================\n\n";
            cin>>valor;
    }while(valor != 1 and valor != 2);
        if(valor == 2){
            return false;
        }else{
            //zera a matriz
            for(int i=0;i<TAM;i++){for(int j=0;j<TAM;j++){matrizTela[i][j]= 0;}}
            montaTela(matrizTela,contraQuem);
            return true;
        }
}
bool menu(){
    int valor;
    do{
            cout<<"\t\t     Escolha modo de Jogo\n\n";
            cout<<"\t\t===============================\n\n";
            cout<<"\t\t\t[1] Singleplayer\n";
            cout<<"\t\t\t[2] Multiplayer";
            cout<<"\n\n\t\t===============================\n\n";
            cin>>valor;
    }while(valor != 1 and valor != 2);
    if(valor == 1){
        return true;
    }else{
        return false;
    }
}


int main(){
    //Matriz que define a os campos da Tela
    int matrizTela[TAM][TAM] = {0};
    //variaveis de controle
    bool jogarContraQuem;
    //variavel recebe o retorne da funçção contraQuem
    jogarContraQuem = menu();
    //chama a função que ira montar a Tela do jogo
    montaTela(matrizTela,jogarContraQuem);
    //variavel criada para pegar retorno da função Jogar de Novo
    bool jogarNovamente = true;
    //while que executa o jogo
    while(jogarNovamente){
        jogar(matrizTela,jogarContraQuem);
        jogarNovamente = JogarDeNovo(matrizTela,jogarContraQuem);
    }
}
