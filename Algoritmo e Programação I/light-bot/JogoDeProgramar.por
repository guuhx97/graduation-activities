programa
{
	inclua biblioteca Graficos -->g 
	inclua biblioteca Util --> u
	inclua biblioteca Mouse --> m
	inclua biblioteca Teclado -->  t
	inclua biblioteca Tipos --> ti
	
	inteiro injuredSoldier[10][15] = {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
								{1,0,0,0,0,0,1,0,0,0,2,1,1,1,1},
								{1,0,1,0,1,0,1,0,1,1,1,1,0,1,1},
								{1,0,1,0,1,0,1,0,1,0,0,1,0,1,1},
								{1,0,1,1,1,0,1,0,1,1,0,1,0,1,1},
								{1,0,0,0,0,0,1,0,0,0,0,1,0,0,1},
								{1,1,1,1,1,0,1,1,0,1,1,1,0,1,1},
								{1,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
								{1,0,1,0,1,0,0,0,1,0,1,0,3,1,1},
								{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
								}	
	inteiro Ammunition[10][15] = {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					    		{1,0,1,0,0,0,0,0,0,0,0,0,3,1,1},
					    		{1,0,1,1,1,1,1,1,1,0,0,0,1,0,1},
					    		{1,0,1,0,0,1,0,0,0,0,0,0,0,1,1},
					    		{1,0,0,0,0,1,1,0,0,0,1,1,1,1,1},
					   		{1,2,0,0,0,0,0,0,0,0,0,0,0,0,1},
					    		{1,1,1,1,0,0,0,1,1,1,1,0,1,0,1},
					   		{1,0,0,1,0,0,0,1,0,0,1,0,0,0,1},
					    		{1,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
					    		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}	
							}						
	inteiro theTank[10][15] = {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
						{1,3,0,0,0,1,0,1,0,0,0,0,0,1,1},
						{1,0,0,0,0,1,0,1,1,1,0,1,0,0,1},
						{1,1,1,1,0,1,0,0,0,1,0,1,1,1,1},
						{1,0,0,1,0,1,1,0,1,1,0,0,0,0,1},
						{1,0,0,1,0,0,0,0,0,0,0,1,0,0,1},
						{1,0,0,1,0,1,1,0,1,1,0,1,0,1,1},
						{1,0,0,1,0,0,0,0,0,1,0,0,0,0,1},
						{1,0,0,0,0,0,0,0,0,1,0,0,0,2,1},
						{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}						
						}
	inteiro matrizUtil[10][15]
	inteiro vetorCaminho[30] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
	
	/*Carregando Imagens-*/
	inteiro painelParado = g.carregar_imagem("C:\\Users\\Gustavo Souza\\Desktop\\Nova pasta\\Periodo 01\\Algoritmo e Programação I\\Projeto\\imagem\\painel.png")
	inteiro painelCheio = g.carregar_imagem("C:\\Users\\Gustavo Souza\\Desktop\\Nova pasta\\Periodo 01\\Algoritmo e Programação I\\Projeto\\imagem\\painelTodoPreenchido.png")
	inteiro painelExecutando= g.carregar_imagem("C:\\Users\\Gustavo Souza\\Desktop\\Nova pasta\\Periodo 01\\Algoritmo e Programação I\\Projeto\\imagem\\painelExecusao.png")
	inteiro personagem = g.carregar_imagem("C:\\Users\\Gustavo Souza\\Desktop\\Nova pasta\\Periodo 01\\Algoritmo e Programação I\\Projeto\\imagem\\personagem.png")
	inteiro chegada = g.carregar_imagem("C:\\Users\\Gustavo Souza\\Desktop\\Nova pasta\\Periodo 01\\Algoritmo e Programação I\\Projeto\\imagem\\primeiroSocorro.png")
	inteiro chegada2 = g.carregar_imagem("C:\\Users\\Gustavo Souza\\Desktop\\Nova pasta\\Periodo 01\\Algoritmo e Programação I\\Projeto\\imagem\\municao.png")
	inteiro chegada3 = g.carregar_imagem("C:\\Users\\Gustavo Souza\\Desktop\\Nova pasta\\Periodo 01\\Algoritmo e Programação I\\Projeto\\imagem\\anque.png")
	inteiro setas = g.carregar_imagem("C:\\Users\\Gustavo Souza\\Desktop\\Nova pasta\\Periodo 01\\Algoritmo e Programação I\\Projeto\\imagem\\cmd.png")
	inteiro cmdPlay = g.carregar_imagem("C:\\Users\\Gustavo Souza\\Desktop\\Nova pasta\\Periodo 01\\Algoritmo e Programação I\\Projeto\\imagem\\cmdPlay.png")
	inteiro cmdColisao = g.carregar_imagem("C:\\Users\\Gustavo Souza\\Desktop\\Nova pasta\\Periodo 01\\Algoritmo e Programação I\\Projeto\\imagem\\cmdColisao.png")
	inteiro cmdChegada = g.carregar_imagem("C:\\Users\\Gustavo Souza\\Desktop\\Nova pasta\\Periodo 01\\Algoritmo e Programação I\\Projeto\\imagem\\cmdChegada.png")
	inteiro sucessoImg = g.carregar_imagem("C:\\Users\\Gustavo Souza\\Desktop\\Nova pasta\\Periodo 01\\Algoritmo e Programação I\\Projeto\\imagem\\sucesso.png")
	inteiro menuImg = g.carregar_imagem("C:\\Users\\Gustavo Souza\\Desktop\\Nova pasta\\Periodo 01\\Algoritmo e Programação I\\Projeto\\imagem\\menu.png")
	inteiro Intrucoes = g.carregar_imagem("C:\\Users\\Gustavo Souza\\Desktop\\Nova pasta\\Periodo 01\\Algoritmo e Programação I\\Projeto\\imagem\\Instruções.png")
		
	
	
	/*Constantes para Movimento*/
	const inteiro CIMA = 10
	const inteiro DIREITA = 20 
	const inteiro BAIXO = 30
	const inteiro ESQUERDA = 40
	const inteiro PARADO = 100
	const inteiro EXECUTANDO = 200

	/*Variaveis de Controle*/
	inteiro contadorVetor =0, estadoAtual = PARADO, posicaoAtualX, posicaoAtualY,tempo = u.tempo_decorrido()
	inteiro contadorDePosicaoDesenho =6,contadorDePosicaoDesenhoColuna = 456,posicaoOrigemY,posicaoOrigemX
	inteiro contadoDeRepeat=0,contadorDePassadas=0,guarda=0,guardaFase
	logico PegaOuNao =verdadeiro,parado = falso,next = falso	
	
	/*-Cor---------------------------*/
	inteiro cinza = g.criar_cor(102, 102, 102)
	funcao inicializar(){
		g.iniciar_modo_grafico(verdadeiro)
		g.definir_dimensoes_janela(600, 600)
		g.definir_titulo_janela("Jogo de Programar")
	}		
	funcao menu(){
		
		g.desenhar_imagem(0, 0, menuImg)
		g.renderizar()
		enquanto(verdadeiro){
			m.ler_botao()
			inteiro x = m.posicao_x()
			inteiro y = m.posicao_y()
			se(x >= 349 e x <= 583 e y >= 118 e y <= 170){
				pare
			}senao se(x >= 355 e x<= 584 e y >= 201 e y <= 255){
				logico sair = verdadeiro
				g.desenhar_imagem(0, 0, Intrucoes)
				g.renderizar()
				enquanto(sair == verdadeiro){
					m.ler_botao()
					inteiro x1 = m.posicao_x()
					inteiro y1 = m.posicao_y()
					se(x1>=255 e x1<=345 e y1>=559 e y1<=587){
						sair = falso
						g.limpar()
						g.desenhar_imagem(0, 0, menuImg)
						g.renderizar()						
					}
					pare
				}				
			}senao se(x>=354 e x<= 582 e y >=286 e y<=340){
			
				g.iniciar_modo_grafico(falso)
				g.encerrar_modo_grafico()
				
			}						
		}		
	}
	funcao montaTelaJogo(inteiro fase){
		guardaFase = fase
		para(inteiro i = 0;i<10;i++){
			para(inteiro c = 0;c<15;c++){			
				se(fase == 1){
					matrizUtil[i][c] = 	injuredSoldier[i][c]
				}senao se(fase == 2){
					matrizUtil[i][c] = 	Ammunition[i][c]
				}senao se(fase == 3){
					matrizUtil[i][c] = 	theTank[i][c]
				}
			}
		}		
		g.definir_cor(g.COR_BRANCO)
		g.desenhar_retangulo(0, 0, 600, 600, falso, verdadeiro)	
		para(inteiro i = 0;i<10;i++){
			para(inteiro c = 0;c<15;c++){			
					escolha(matrizUtil[i][c]){	
					caso 0:
						g.definir_cor(g.COR_BRANCO)
						pare
					caso 1:
						g.definir_cor(cinza)
						pare
					caso 2:
						se(fase == 1){
							g.desenhar_porcao_imagem((c*40)+2, (i*40)+5, 1, 1, 50, 50, chegada)						
						}senao se(fase == 2){
							g.desenhar_porcao_imagem((c*40)+2, (i*40)+5, 1, 1, 50, 50, chegada2)
						}senao se(fase == 3){
							g.desenhar_porcao_imagem((c*40)+2, (i*40)+5, 1, 1, 50, 50, chegada3)
						}
						g.definir_opacidade(0)
						pare
					caso 3:					
						g.desenhar_porcao_imagem((c*40)+4, (i*40)+4, 1, 147, 40, 40, personagem)
						posicaoAtualX = c*40
						posicaoAtualY = i*40
						posicaoOrigemX = posicaoAtualX
						posicaoOrigemY = posicaoAtualY 
						g.definir_opacidade(0)
						pare
				}			
					g.desenhar_retangulo((c*40)+1, (i*40)+1, 40, 40, falso, verdadeiro)
					g.definir_cor(g.COR_PRETO)
					g.desenhar_retangulo((c*40)+1, (i*40)+1, 40, 40, falso, falso)
					g.definir_opacidade(255)
			}		
		}	
		g.desenhar_imagem(20, 420, painelParado)		
		para(inteiro i =13;i<16;i++){
			para(inteiro c=6;c<16;c++){
				g.definir_cor(g.COR_BRANCO)
				g.desenhar_retangulo((c*35),(i*35), 35, 35, falso, verdadeiro)
				g.definir_cor(g.COR_PRETO)
				g.desenhar_retangulo((c*35),(i*35), 35, 35, falso, falso)
			}
		}		
		g.renderizar()
	}


	
	funcao pegaClique(){
		inteiro x,y
		enquanto(PegaOuNao == verdadeiro){			
			se(m.algum_botao_pressionado()){
				se(m.botao_pressionado(m.BOTAO_ESQUERDO) ou m.botao_pressionado(m.BOTAO_DIREITO) ){ 
					m.ler_botao()
					x = m.posicao_x()
					y = m.posicao_y()
					
					se(x >= 135 e x <=180 e y >= 464 e y <= 507){
						//pega clique do mause na seta para direita		
						g.desenhar_porcao_imagem((contadorDePosicaoDesenho*35)+1,contadorDePosicaoDesenhoColuna, 80,2, 34, 34, setas)
						vetorCaminho[contadorVetor] = DIREITA
						contadorDePosicaoDesenho++
						contadorVetor++	
					}senao se(x >= 80 e x <=125 e y >= 433 e y <= 479){
						//pega clique do mause na seta para cima
						g.desenhar_porcao_imagem((contadorDePosicaoDesenho*35)+1,contadorDePosicaoDesenhoColuna, 42,2, 34, 34, setas)				
						vetorCaminho[contadorVetor] = CIMA
						contadorDePosicaoDesenho++
						contadorVetor++
					}senao se(x >= 81 e x <=126 e y >= 492 e y <= 536){		
						//pega clique do mause na seta para baixo	
						g.desenhar_porcao_imagem((contadorDePosicaoDesenho*35)+1,contadorDePosicaoDesenhoColuna, 115,2, 34, 34, setas)
						vetorCaminho[contadorVetor] = BAIXO
						contadorDePosicaoDesenho++
						contadorVetor++
					}senao se(x >= 25 e x <=69 e y >= 467 e y <= 510){			
						//pega clique do mause na seta para esquerda
						g.desenhar_porcao_imagem((contadorDePosicaoDesenho*35)+1,contadorDePosicaoDesenhoColuna, 3,2, 34, 34, setas)
						vetorCaminho[contadorVetor] = ESQUERDA
						contadorDePosicaoDesenho++
						contadorVetor++
					}senao se(x >= 134 e x <=182 e y >= 546 e y <= 596){					
						/*pega clique na tecla Play*/	
						estadoAtual = EXECUTANDO							
						play()						
						se(next == verdadeiro){
							pare
						}												
					}	
				}
			}senao se(t.alguma_tecla_pressionada()){
				inteiro tecla =t.ler_tecla()
				se(tecla == t.TECLA_BACKSPACE){
					g.definir_cor(g.COR_BRANCO)					
					se(contadorDePosicaoDesenho == 6 e contadorDePosicaoDesenhoColuna == 491){
						contadorDePosicaoDesenho = 16 contadorDePosicaoDesenhoColuna -= 35
					}
					se(contadorDePosicaoDesenho == 6 e contadorDePosicaoDesenhoColuna == 526){
						contadorDePosicaoDesenho = 16 contadorDePosicaoDesenhoColuna -= 35
					}
					se(contadorDePosicaoDesenho > 6){
						g.desenhar_retangulo((contadorDePosicaoDesenho*35)-34, contadorDePosicaoDesenhoColuna, 34, 34, falso, verdadeiro)
						contadorDePosicaoDesenho--
						contadorVetor--
					}			
				}senao se(tecla == t.TECLA_R){
					reseta()
				}
			}	
			g.renderizar()
			enquanto(contadorVetor == 30){
				g.desenhar_imagem(20, 420, painelCheio)
				g.renderizar()
				se(m.algum_botao_pressionado()){
					se(m.botao_pressionado(m.BOTAO_ESQUERDO) ou m.botao_pressionado(m.BOTAO_DIREITO) ){ 
						m.ler_botao()
						x = m.posicao_x()
						y = m.posicao_y()
						se(x >= 134 e x <=182 e y >= 546 e y <= 596){					
							/*pega clique na tecla Play*/	
							estadoAtual = EXECUTANDO	
							play()									
						}
					}
				}senao se(t.alguma_tecla_pressionada()){
					inteiro tecla =t.ler_tecla()
					se(tecla == t.TECLA_BACKSPACE){
						g.definir_cor(g.COR_BRANCO)					
						g.desenhar_retangulo((contadorDePosicaoDesenho*35)-34, contadorDePosicaoDesenhoColuna, 34, 34, falso, verdadeiro)
						contadorDePosicaoDesenho--
						contadorVetor--
						g.desenhar_imagem(20, 420, painelParado)
						g.renderizar()
					}			
				}
			}				
			se(contadorDePosicaoDesenho == 16 ){
				contadorDePosicaoDesenho = 6
				contadorDePosicaoDesenhoColuna += 35
			}		
		}		
	}
	funcao play(){
		
		g.desenhar_imagem(20, 420, painelExecutando)
		g.renderizar()
		inteiro personagemDireita = 100,personagemEsquerda = 50,personagemCima=147,personagemBaixo=3,posicaoDeImagem = personagemCima
		inteiro x,y,controlePosicaoDesenho=6,controlePosicaoDesenhoColuna = 456
		next = falso
				
		g.definir_cor(g.COR_BRANCO)		
		se(parado == verdadeiro){
			controlePosicaoDesenho+=guarda
			parado=falso
		}					
		enquanto(contadorDePassadas<contadorVetor e estadoAtual == EXECUTANDO){
			inteiro k = 0						
			se(vetorCaminho[contadorDePassadas] == CIMA){
				g.desenhar_porcao_imagem((controlePosicaoDesenho*35)+1,controlePosicaoDesenhoColuna, 42,2, 34, 34, cmdPlay)
				se(posicaoDeImagem == personagemCima){
					se(matrizUtil[(posicaoAtualY-40)/40][(posicaoAtualX)/40] == 1){
						g.desenhar_porcao_imagem((controlePosicaoDesenho*35)+1,controlePosicaoDesenhoColuna, 42,2, 34, 34, cmdColisao)
						aposColidir()						
						pare					
					}							
					g.desenhar_retangulo(posicaoAtualX+2, posicaoAtualY+2, 39, 39, falso, verdadeiro)
					posicaoAtualX  = posicaoAtualX
					posicaoAtualY = posicaoAtualY-40
					g.desenhar_porcao_imagem(posicaoAtualX+2, posicaoAtualY+2, 0, personagemCima, 39, 39, personagem)
					se(matrizUtil[(posicaoAtualY)/40][posicaoAtualX/40] == 2){
						g.desenhar_porcao_imagem((controlePosicaoDesenho*35)+1,controlePosicaoDesenhoColuna, 42,2, 34, 34, cmdChegada)
						g.renderizar()
						u.aguarde(500)
						sucesso()						 
						pare					
					}
						
				}senao se(posicaoDeImagem == personagemDireita){
					se(matrizUtil[posicaoAtualY/40][(posicaoAtualX+40)/40] == 1){
						g.desenhar_porcao_imagem((controlePosicaoDesenho*35)+1,controlePosicaoDesenhoColuna, 42,2, 34, 34, cmdColisao)
						aposColidir()						
						pare					
					}					
					g.desenhar_retangulo(posicaoAtualX+2, posicaoAtualY+2, 39, 39, falso, verdadeiro)
					posicaoAtualX  = posicaoAtualX+40
					posicaoAtualY = posicaoAtualY
					g.desenhar_porcao_imagem(posicaoAtualX+2, posicaoAtualY+2, 0, personagemDireita, 39, 39, personagem)
					
					se(matrizUtil[posicaoAtualY/40][(posicaoAtualX)/40] == 2){
						g.desenhar_porcao_imagem((controlePosicaoDesenho*35)+1,controlePosicaoDesenhoColuna, 42,2, 34, 34, cmdChegada)
						g.renderizar()
						u.aguarde(500)
						sucesso()
						estadoAtual= PARADO 
						pare					
					}
										
				}senao se(posicaoDeImagem == personagemBaixo){
					se(matrizUtil[(posicaoAtualY+40)/40][posicaoAtualX/40] == 1){
						g.desenhar_porcao_imagem((controlePosicaoDesenho*35)+1,controlePosicaoDesenhoColuna, 42,2, 34, 34, cmdColisao)
						aposColidir()							
						pare					
					}
					g.desenhar_retangulo(posicaoAtualX+2, posicaoAtualY+2, 39, 39, falso, verdadeiro)
					posicaoAtualX  = posicaoAtualX
					posicaoAtualY = posicaoAtualY+40
					g.desenhar_porcao_imagem(posicaoAtualX+2, posicaoAtualY+2, 0, personagemBaixo, 39, 39, personagem)	
					se(matrizUtil[posicaoAtualY/40][posicaoAtualX/40] == 2){
						g.desenhar_porcao_imagem((controlePosicaoDesenho*35)+1,controlePosicaoDesenhoColuna, 42,2, 34, 34, cmdChegada)
						g.renderizar()
						u.aguarde(500)
						sucesso()						 
						pare					
					}
			     }senao se(posicaoDeImagem == personagemEsquerda){
			     	se(matrizUtil[posicaoAtualY/40][(posicaoAtualX-40)/40] == 1){
						g.desenhar_porcao_imagem((controlePosicaoDesenho*35)+1,controlePosicaoDesenhoColuna, 42,2, 34, 34, cmdColisao)
						aposColidir()							
						pare					
					}
			     	g.desenhar_retangulo(posicaoAtualX+2, posicaoAtualY+2, 39, 39, falso, verdadeiro)
					posicaoAtualX  = posicaoAtualX-40
					posicaoAtualY = posicaoAtualY
					g.desenhar_porcao_imagem(posicaoAtualX+2, posicaoAtualY+2, 0, personagemEsquerda, 39, 39, personagem)
					se(matrizUtil[posicaoAtualY/40][(posicaoAtualX)/40] == 2){
						g.desenhar_porcao_imagem((controlePosicaoDesenho*35)+1,controlePosicaoDesenhoColuna, 42,2, 34, 34, cmdChegada)
						g.renderizar()
						u.aguarde(500)
						sucesso()
						pare					
					}	
				}				
			}
			senao se(vetorCaminho[contadorDePassadas] == DIREITA){
				g.desenhar_porcao_imagem((controlePosicaoDesenho*35)+1,controlePosicaoDesenhoColuna, 80,2, 34, 34, cmdPlay)
				se(posicaoDeImagem == personagemCima){
					g.desenhar_retangulo(posicaoAtualX+2, posicaoAtualY+2, 39, 39, falso, verdadeiro)
					g.desenhar_porcao_imagem(posicaoAtualX+2, posicaoAtualY+2, 0, personagemDireita, 39, 39, personagem)
					posicaoDeImagem = personagemDireita
				}senao se(posicaoDeImagem == personagemDireita){
					g.desenhar_retangulo(posicaoAtualX+2, posicaoAtualY+2, 39, 39, falso, verdadeiro)
					g.desenhar_porcao_imagem(posicaoAtualX+2, posicaoAtualY+2, 0, personagemBaixo, 39, 39, personagem)
					posicaoDeImagem = personagemBaixo					
				}senao se(posicaoDeImagem == personagemBaixo){
					g.desenhar_retangulo(posicaoAtualX+2, posicaoAtualY+2, 39, 39, falso, verdadeiro)
					g.desenhar_porcao_imagem(posicaoAtualX+2, posicaoAtualY+2, 0, personagemEsquerda, 39, 39, personagem)
					posicaoDeImagem = personagemEsquerda				
			     }senao se(posicaoDeImagem == personagemEsquerda){
			     	g.desenhar_retangulo(posicaoAtualX+2, posicaoAtualY+2, 39, 39, falso, verdadeiro)
					g.desenhar_porcao_imagem(posicaoAtualX+2, posicaoAtualY+2, 0, personagemCima, 39, 39, personagem)
					posicaoDeImagem = personagemCima			
				}
			}
			senao se(vetorCaminho[contadorDePassadas] == BAIXO){
				g.desenhar_porcao_imagem((controlePosicaoDesenho*35)+1,controlePosicaoDesenhoColuna, 42,2, 34, 34, cmdPlay)
				se(posicaoDeImagem == personagemCima){
					se(matrizUtil[(posicaoAtualY+40)/40][posicaoAtualX/40] == 1){
						g.desenhar_porcao_imagem((controlePosicaoDesenho*35)+1,controlePosicaoDesenhoColuna, 42,2, 34, 34, cmdColisao)
						aposColidir()						
						pare					
					}
					g.desenhar_retangulo(posicaoAtualX+2, posicaoAtualY+2, 39, 39, falso, verdadeiro)
					posicaoAtualX  = posicaoAtualX
					posicaoAtualY = posicaoAtualY+40
					g.desenhar_porcao_imagem(posicaoAtualX+2, posicaoAtualY+2, 0, personagemCima, 39, 39, personagem)
					se(matrizUtil[posicaoAtualY/40][posicaoAtualX/40] == 2){
						g.desenhar_porcao_imagem((controlePosicaoDesenho*35)+1,controlePosicaoDesenhoColuna, 42,2, 34, 34, cmdChegada)
						g.renderizar()
						u.aguarde(500)
						sucesso()					 
						pare					
					}				
				}senao se(posicaoDeImagem == personagemDireita){
					se(matrizUtil[posicaoAtualY/40][(posicaoAtualX-40)/40] == 1){
						g.desenhar_porcao_imagem((controlePosicaoDesenho*35)+1,controlePosicaoDesenhoColuna, 42,2, 34, 34, cmdColisao)
						aposColidir()						
						pare					
					}		
					g.desenhar_retangulo(posicaoAtualX+2, posicaoAtualY+2, 39, 39, falso, verdadeiro)
					posicaoAtualX  = posicaoAtualX-40
					posicaoAtualY = posicaoAtualY
					g.desenhar_porcao_imagem(posicaoAtualX+2, posicaoAtualY+2, 0, personagemDireita, 39, 39, personagem)
					se(matrizUtil[posicaoAtualY/40][posicaoAtualX/40] == 2){
						g.desenhar_porcao_imagem((controlePosicaoDesenho*35)+1,controlePosicaoDesenhoColuna, 42,2, 34, 34, cmdChegada)
						g.renderizar()
						u.aguarde(500)
						sucesso()
						estadoAtual= PARADO 
						pare					
					}			
				}senao se(posicaoDeImagem == personagemBaixo){
					se(matrizUtil[(posicaoAtualY-40)/40][posicaoAtualX/40] == 1){
						g.desenhar_porcao_imagem((controlePosicaoDesenho*35)+1,controlePosicaoDesenhoColuna, 42,2, 34, 34, cmdColisao)
						aposColidir()							
						pare					
					}
					g.desenhar_retangulo(posicaoAtualX+2, posicaoAtualY+2, 39, 39, falso, verdadeiro)
					posicaoAtualX  = posicaoAtualX
					posicaoAtualY = posicaoAtualY-40
					g.desenhar_porcao_imagem(posicaoAtualX+2, posicaoAtualY+2, 0, personagemBaixo, 39, 39, personagem)	
					se(matrizUtil[posicaoAtualY/40][posicaoAtualX/40] == 2){
						g.desenhar_porcao_imagem((controlePosicaoDesenho*35)+1,controlePosicaoDesenhoColuna, 42,2, 34, 34, cmdChegada)
						g.renderizar()
						u.aguarde(500)
						sucesso()						 
						pare					
					}
			     }senao se(posicaoDeImagem == personagemEsquerda){
			     	se(matrizUtil[posicaoAtualY/40][posicaoAtualX/40] == 1){
						g.desenhar_porcao_imagem((controlePosicaoDesenho*35)+1,controlePosicaoDesenhoColuna, 42,2, 34, 34, cmdColisao)
						aposColidir()							
						pare					
					}	     	
			     	g.desenhar_retangulo(posicaoAtualX+2, posicaoAtualY+2, 39, 39, falso, verdadeiro)
					posicaoAtualX  = posicaoAtualX+40
					posicaoAtualY = posicaoAtualY
					g.desenhar_porcao_imagem(posicaoAtualX+2, posicaoAtualY+2, 0, personagemEsquerda, 39, 39, personagem)	
					se(matrizUtil[posicaoAtualY/40][(posicaoAtualX+40)/40] == 2){
						g.desenhar_porcao_imagem((controlePosicaoDesenho*35)+1,controlePosicaoDesenhoColuna, 42,2, 34, 34, cmdChegada)
						g.renderizar()
						u.aguarde(500)
						sucesso()
						pare					
					}
				}
				
			}
			senao se(vetorCaminho[contadorDePassadas] == ESQUERDA){
				g.desenhar_porcao_imagem((controlePosicaoDesenho*35)+1,controlePosicaoDesenhoColuna, 3,2, 34, 34, cmdPlay)
				se(posicaoDeImagem == personagemCima){
					g.desenhar_retangulo(posicaoAtualX+2, posicaoAtualY+2, 39, 39, falso, verdadeiro)
					g.desenhar_porcao_imagem(posicaoAtualX+2, posicaoAtualY+2, 0, personagemEsquerda, 39, 39, personagem)
					posicaoDeImagem = personagemEsquerda
				}senao se(posicaoDeImagem == personagemDireita){
					g.desenhar_retangulo(posicaoAtualX+2, posicaoAtualY+2, 39, 39, falso, verdadeiro)
					g.desenhar_porcao_imagem(posicaoAtualX+2, posicaoAtualY+2, 0, personagemCima, 39, 39, personagem)
					posicaoDeImagem = personagemCima					
				}senao se(posicaoDeImagem == personagemBaixo){
					g.desenhar_retangulo(posicaoAtualX+2, posicaoAtualY+2, 39, 39, falso, verdadeiro)
					g.desenhar_porcao_imagem(posicaoAtualX+2, posicaoAtualY+2, 0, personagemDireita, 39, 39, personagem)
					posicaoDeImagem = personagemDireita				
			     }senao se(posicaoDeImagem == personagemEsquerda){
			     	g.desenhar_retangulo(posicaoAtualX+2, posicaoAtualY+2, 39, 39, falso, verdadeiro)
					g.desenhar_porcao_imagem(posicaoAtualX+2, posicaoAtualY+2, 0, personagemBaixo, 39, 39, personagem)
					posicaoDeImagem = personagemBaixo		
				}
			}
			se(contadorDePassadas == contadorVetor-1){
				estadoAtual = PARADO				
			}		
			g.renderizar()			
			contadorDePassadas++
			controlePosicaoDesenho++			
			enquanto(k < 4){
				se(u.tempo_decorrido() - tempo > 200){			
					tempo = u.tempo_decorrido()
					k++
				}								
				se(m.algum_botao_pressionado() == verdadeiro){				
					 se(m.botao_pressionado(m.BOTAO_ESQUERDO)){
					 	x = m.posicao_x()
					 	y =m.posicao_y()
					 	se(x >= 78 e x <= 125 e y >= 540 e y <= 581){
					 		parado = verdadeiro
					 		guarda = contadorDePassadas
					 		estadoAtual = PARADO
					 		g.desenhar_imagem(20, 420, painelParado)
					 		pare		 
					 	}senao se(x >= 29 e x <= 97 e y >= 540 e y <= 581){
					 		reseta()					 		
					 	}
					 }
				}
			}					
			g.renderizar()					
			se(controlePosicaoDesenho == 16){
				controlePosicaoDesenho = 6
				controlePosicaoDesenhoColuna += 35
			}
		}
		g.desenhar_imagem(20, 420, painelParado)
		g.renderizar()
	}
	funcao reseta(){
			estadoAtual = PARADO
			g.desenhar_imagem(20, 420, painelParado)
			g.definir_cor(g.COR_BRANCO)
			g.desenhar_retangulo(posicaoAtualX+2, posicaoAtualY+2, 39, 39, falso, verdadeiro)
			g.desenhar_porcao_imagem(posicaoOrigemX+2, posicaoOrigemY+2, 0, 147, 39, 39, personagem)
			posicaoAtualX = posicaoOrigemX
			posicaoAtualY = posicaoOrigemY
				para(inteiro j =13;j<16;j++){						
					para(inteiro c=6;c<16;c++){
						g.definir_cor(g.COR_BRANCO)
						g.desenhar_retangulo((c*35),(j*35), 35, 35, falso, verdadeiro)
						g.definir_cor(g.COR_PRETO)
						g.desenhar_retangulo((c*35),(j*35), 35, 35, falso, falso)							
					}
				}										
			contadorDePosicaoDesenho=6
			contadorDePosicaoDesenhoColuna = 456
			contadorVetor=0
			contadorDePassadas=0
			g.renderizar()				
	}
	funcao aposColidir(){
		
		inteiro imagem = g.carregar_imagem("C:\\Users\\Gustavo Souza\\Desktop\\Nova pasta\\Periodo 01\\Algoritmo e Programação I\\Projeto\\imagem\\Colisao.png")
		g.desenhar_imagem(0,0, imagem)	
	 	g.renderizar()
	 	u.aguarde(2000)
	 	g.limpar()
	 	reseta()
	 	montaTelaJogo(guardaFase)
	 		
	}		
	funcao sucesso(){
		g.limpar()
		g.desenhar_imagem(0, 0, sucessoImg)
		next = verdadeiro
		g.renderizar()
		u.aguarde(1000)
		g.limpar()
		contadorDePosicaoDesenho=6
			contadorDePosicaoDesenhoColuna = 456
			contadorVetor=0
			contadorDePassadas=0			
	}	
	funcao inicio(){	
		inicializar()	
		para(inteiro i = 1;i<4;i++){
			inteiro intro01 = g.carregar_imagem("C:\\Users\\Gustavo Souza\\Desktop\\Nova pasta\\Periodo 01\\Algoritmo e Programação I\\Projeto\\imagem\\introducaoFase0"+i+".png")
			g.desenhar_imagem(0, 0, intro01)
			g.renderizar()
			u.aguarde(3000)
			montaTelaJogo(i)
			pegaClique()	
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 7338; 
 * @DOBRAMENTO-CODIGO = [19, 30];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */