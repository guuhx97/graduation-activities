programa
{	
	inclua biblioteca Util --> u
	inclua biblioteca Graficos --> g 
	inclua biblioteca Teclado --> t
	inclua biblioteca Sons --> s

	inteiro matriz[20][20] =		    {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
								{1,1,1,0,0,0,0,0,0,0,0,0,1,1,0,0,0,1,0,1},
								{1,0,0,0,1,1,1,0,1,1,1,0,0,0,0,0,0,0,0,1},
								{1,0,1,0,1,1,0,0,0,0,1,1,1,1,1,1,1,1,0,1},
								{1,0,1,0,0,1,0,1,1,0,1,1,0,0,0,0,0,0,0,1},
								{1,0,1,1,0,1,0,1,1,0,1,1,0,1,1,1,1,0,1,1},
								{1,0,1,1,0,0,0,1,1,0,0,0,0,1,0,0,0,0,1,1},
								{1,0,0,0,1,1,1,1,1,1,0,1,1,1,0,1,0,1,1,1},
								{1,0,1,0,0,0,0,0,0,0,0,1,1,1,0,0,1,0,1,1},
								{1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,0,0,0,1,1},
								{1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,1},
								{1,0,0,0,1,0,1,1,1,1,0,1,1,1,0,1,0,0,0,1},
								{1,1,0,1,1,0,0,0,0,0,0,0,1,1,0,0,1,1,0,1},
								{1,1,0,1,1,0,1,1,1,0,1,0,1,0,1,0,0,1,0,1},
								{1,1,0,0,0,0,0,1,1,0,1,0,0,1,1,1,0,0,0,1},
								{1,3,1,1,1,0,0,0,0,0,1,1,0,1,1,1,0,1,1,1},
								{1,0,1,1,1,0,1,0,1,1,1,1,0,0,0,1,0,0,0,1},
								{1,0,0,0,0,0,1,0,0,1,0,0,0,1,1,1,0,1,0,1},
								{1,1,1,1,1,1,1,1,0,1,0,1,1,0,0,0,0,1,0,1},
								{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}}

	inteiro matrizBranca[2][400],contador=0
	
	funcao montaMatrizBranca(){
		
			para(inteiro i =0;i<20;i++){
				para(inteiro c = 0;c<20;c++){
					se(matriz[i][c] == 0){
						matrizBranca[0][contador] = i
						matrizBranca[1][contador] = c	
						contador++	
					}
				}
			}
			escreva(contador,"\n")	
	}
	
	funcao criarTela(){
		
		g.iniciar_modo_grafico(verdadeiro)
		g.definir_dimensoes_janela(600, 600)
		g.definir_titulo_janela("Extriti")
		g.definir_cor(g.COR_BRANCO)

		inteiro f = g.criar_cor(168,168,168)

		para(inteiro i =0;i<20;i++){
			para(inteiro c = 0;c<20;c++){
				escolha(matriz[i][c]){
					caso 0:
						g.definir_cor(g.COR_BRANCO)
						pare
					caso 1:
						g.definir_cor(f)
						pare
					caso 3:
						g.definir_cor(g.COR_VERMELHO)
						pare
				}
					g.desenhar_retangulo((c*30)+1, (i*30)+1, 30, 30, falso, verdadeiro)
					g.definir_cor(g.COR_PRETO)
					g.desenhar_retangulo((c*30)+1, (i*30)+1, 30, 30, falso, falso)
						
				}
			}
		g.renderizar()
	}
	
	funcao sorteiaPosicao(){
		inteiro a = g.carregar_imagem("C:\\Users\\Gustavo Souza\\Desktop\\Nova pasta\\Periodo 01\\Algoritmo e Programação I\\Projeto\\imagem\\painel.png")
		inteiro num1,x,y,tecla

		num1 = u.sorteia(0, contador-1)
		x = matrizBranca[0][num1]
		y = matrizBranca[1][num1]
		matriz[x][y] = 2
		
		para(inteiro i=num1;i<=contador-2;i++){
			matrizBranca[0][i] = matrizBranca[0][i+1]
			matrizBranca[1][i] = matrizBranca[1][i+1]
		}
		contador-=1

		g.desenhar_imagem((y*30)+2, (x*30)+2, a)
		g.renderizar()	
		g.definir_cor(g.COR_AMARELO)
		g.desenhar_retangulo((y*30)+1, (x*30)+1, 30, 30, falso, verdadeiro)
		g.definir_cor(g.COR_PRETO)
		g.desenhar_retangulo((y*30)+1, (x*30)+1, 30, 30, falso, falso)

		enquanto(verdadeiro){
			tecla = t.ler_tecla()
				se(tecla == t.TECLA_F){
					g.fechar_janela()
					pare				
				}senao se(tecla == t.TECLA_ENTER){

				para(inteiro i = 0;i<173;i++){
					enquanto(contador >= -1){
						
						se(contador == 1){
							num1 = 0
						}senao se(contador-1 < 0){
							pare
						}
						senao{
							num1 = u.sorteia(0, contador-1)
						}
							x = matrizBranca[0][num1]
							y = matrizBranca[1][num1]
							matriz[x][y] = 2
							
							para(inteiro o=num1;o<=contador-1;o++){
								matrizBranca[0][o] = matrizBranca[0][o+1]
								matrizBranca[1][o] = matrizBranca[1][o+1]
							}
							contador-=1
							g.desenhar_imagem((y*30)+2, (x*30)+2, a)
							g.renderizar()	
							g.definir_cor(g.COR_AMARELO)
							g.desenhar_retangulo((y*30)+1, (x*30)+1, 30, 30, falso, verdadeiro)
							g.definir_cor(g.COR_PRETO)
							g.desenhar_retangulo((y*30)+1, (x*30)+1, 30, 30, falso, falso)
							pare
					}
				}
			}}
		}	
	
	funcao inicio(){
		criarTela()
		montaMatrizBranca()
		sorteiaPosicao()		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 69; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */