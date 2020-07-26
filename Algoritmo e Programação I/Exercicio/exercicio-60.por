programa
{
	funcao inicio()
	{
	 inteiro vetor[4][4] = {{1,2,3,4}
	 				,{5,6,7,8},
	 				{9,10,11,12}
	 			   ,{13,14,15,16}}
	 inteiro maiorValor=0,menorValor=1000,PosicaoMaiorValor[2],PosicaoMenorValor[2]

		para(inteiro i =0;i<4;i++){
			para(inteiro c =0;c<4;c++){
				se(vetor[i][c] < menorValor){
					menorValor=vetor[i][c]
					PosicaoMenorValor[0] = i
					PosicaoMenorValor[1] = c 
				}senao se(vetor[i][c] > maiorValor){
					maiorValor = vetor[i][c]
					PosicaoMaiorValor[0]=i
					PosicaoMaiorValor[1]=c
				}
			}
		}

		escreva("O maior valor na matriz é ",maiorValor," e esta na linha ",PosicaoMaiorValor[0]+1," e na coluna ",PosicaoMaiorValor[1]+1)  
		escreva("\nO menor valor na matriz é ",menorValor," e esta na linha ",PosicaoMenorValor[0]+1," e na coluna ",PosicaoMenorValor[1]+1)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 804; 
 */