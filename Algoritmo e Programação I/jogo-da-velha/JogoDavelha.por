programa
{
	inclua biblioteca Graficos --> g
	inclua biblioteca Mouse --> m
	inclua biblioteca Util --> u 
	inclua biblioteca Texto --> t

	
	inteiro circulo = g.carregar_imagem("G:\\O.png")
	inteiro xis = g.carregar_imagem("G:\\X.png")
	inteiro matriz[3][3]={{0,0,0},{0,0,0},{0,0,0}}
	
	funcao inicializar(){
		g.iniciar_modo_grafico(verdadeiro)
		g.definir_dimensoes_janela(600,600)
		g.definir_cor(g.COR_BRANCO)
	}
	funcao montaTela(){
		para(inteiro i=0;i<3;i++){
			para(inteiro c=0;c<3;c++){
				g.definir_cor(g.COR_BRANCO)
				g.desenhar_retangulo((c*200), (i*200), 200, 200, falso, verdadeiro)
				g.definir_cor(g.COR_PRETO)
				g.desenhar_retangulo((c*200), (i*200)+2, 200, 200, falso, falso)
			}
		}
		g.renderizar()
	}
	funcao jogo(){
		inteiro x,j,y
		para(inteiro i=0;i<9;i++){
			 j = m.ler_botao()
			 x = m.posicao_x()
		 	 y = m.posicao_y()
		 	 escreva(x,"  ",y,"\n")
			se(i % 2 == 0){
				se(x >= 0 e x <= 200 e y > 0 e y <= 200){
					g.desenhar_imagem(2, 5, circulo)
					matriz[0][0] = 1
				}senao se(x >= 201 e x <= 400 e y > 0 e y <= 200){
					g.desenhar_imagem(201, 5, circulo)		
					matriz[0][1] = 1	
				}senao se(x >= 401 e x <= 600 e y > 0 e y <= 200){
					g.desenhar_imagem(401, 5, circulo)	
					matriz[0][2] = 1			
				}senao se(x >= 0 e x <= 200 e y > 201 e y <= 400){
					g.desenhar_imagem(2, 201+5, circulo)
					matriz[1][0] = 1
				}senao se(x >= 201 e x <= 400 e y > 201 e y <= 400){
					g.desenhar_imagem(201, 201+5, circulo)	
					matriz[1][1] = 1
				}senao se(x >= 401 e x <= 600 e y > 201 e y <= 400){
					g.desenhar_imagem(401, 201+5, circulo)
					matriz[1][2] = 1
				}senao se(x >= 0 e x <= 200 e y > 400 e y <= 600){
					g.desenhar_imagem(2, 400+5, circulo)	
					matriz[2][0] = 1
				}senao se(x >= 201 e x <= 400 e y > 401 e y <= 600){
					g.desenhar_imagem(201, 401+5, circulo)
					matriz[2][1] = 1
				}senao se(x >= 401 e x <= 600 e y > 400 e y <= 600){
					g.desenhar_imagem(401, 401+5, circulo)
					matriz[2][2] = 1
				}			
				g.renderizar()
				
			}senao{
				se(x >= 0 e x <= 200 e y > 0 e y <= 200){
					g.desenhar_imagem(2, 5, xis)
					matriz[0][0] = 5
				}senao se(x >= 201 e x <= 400 e y > 0 e y <= 200){
					g.desenhar_imagem(201, 5, xis)		
					matriz[0][1] = 5	
				}senao se(x >= 401 e x <= 600 e y > 0 e y <= 200){
					g.desenhar_imagem(401, 5, xis)	
					matriz[0][2] = 5			
				}senao se(x >= 0 e x <= 200 e y > 201 e y <= 400){
					g.desenhar_imagem(2, 201+5, xis)
					matriz[1][0] = 5
				}senao se(x >= 201 e x <= 400 e y > 201 e y <= 400){
					g.desenhar_imagem(201, 201+5, xis)	
					matriz[1][1] = 5
				}senao se(x >= 401 e x <= 600 e y > 201 e y <= 400){
					g.desenhar_imagem(401, 201+5, xis)
					matriz[1][2] = 5
				}senao se(x >= 0 e x <= 200 e y > 400 e y <= 600){
					g.desenhar_imagem(2, 400+5, xis)	
					matriz[2][0] = 5
				}senao se(x >= 201 e x <= 400 e y > 401 e y <= 600){
					g.desenhar_imagem(201, 401+5, xis)
					matriz[2][1] = 5
				}senao se(x >= 401 e x <= 600 e y > 400 e y <= 600){
					g.desenhar_imagem(401, 401+5, xis)
					matriz[2][2] = 5
				}			
				g.renderizar()

				
			}
			vencedor()
			
		}
		
	}
	funcao vencedor(){
		se(matriz[0][0]+matriz[0][1]+matriz[0][2] == 3 ou matriz[1][0]+matriz[1][1]+matriz[1][2] == 3 ou matriz[2][0]+matriz[2][1]+matriz[2][2] ==3 ou matriz[0][0]+matriz[1][0]+matriz[2][0] == 3 ou matriz[0][1]+matriz[1][1]+matriz[2][1] == 3 ou matriz[0][2]+matriz[1][2]+matriz[2][2] == 3 ou matriz[0][0]+matriz[1][1]+matriz[2][2] ==3 ou matriz[2][0]+matriz[1][1]+matriz[0][2] == 3){
			escreva("Bolinha Venceu")
			
		}senao se(matriz[0][0]+matriz[0][1]+matriz[0][2] == 15 ou matriz[1][0]+matriz[1][1]+matriz[1][2] == 15 ou matriz[2][0]+matriz[2][1]+matriz[2][2] ==15 ou matriz[0][0]+matriz[1][0]+matriz[2][0] == 15 ou matriz[0][1]+matriz[1][1]+matriz[2][1] == 15 ou matriz[0][2]+matriz[1][2]+matriz[2][2] == 15 ou matriz[0][0]+matriz[1][1]+matriz[2][2] ==15 ou matriz[2][0]+matriz[1][1]+matriz[0][2] == 15){
			 escreva("Xis Venceu")
			 
		}
	}
	funcao inicio(){	
		inicializar()
		montaTela()
		jogo()

			
			
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 379; 
 * @DOBRAMENTO-CODIGO = [28];
 */