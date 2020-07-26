programa
{
	funcao inicio()
	{
		inteiro matrizQuaPorSeis[4][6]={{1,2,3,4,5,6},
								 {1,2,3,4,5,6},
								 {1,2,3,4,5,6},
								 {1,2,3,4,5,6}
								 }
		inteiro matrizSeisPorQua[6][4]={{1,2,3,4},
 								{1,2,3,4},
								{1,2,3,4},
								{1,2,3,4},
								{1,2,3,4},
								{1,2,3,4}}
								
		inteiro matrizFinal[4][4] = 	{{0,0,0,0},
 								{0,0,0,0},
								{0,0,0,0},
								{0,0,0,0}
								}			
		inteiro s= 0
		inteiro j= 0
		para(inteiro i = 0; i<4;i++){
			enquanto(j<4){
				para(inteiro c = 0; c<6;c++){
					matrizFinal[i][s] += matrizQuaPorSeis[i][c] *  matrizSeisPorQua[c][j]	
				}
				j++
				s++
			}
			j=0
			s=0
		}
			
		

		para(inteiro i = 0; i<4;i++){
			para(inteiro c = 0; c<4;c++){
				escreva(matrizFinal[i][c],"   ")
			}
			escreva("\n")
		}
}}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 67; 
 */