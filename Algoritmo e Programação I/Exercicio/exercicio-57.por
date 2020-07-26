programa
{
	funcao inicio()
	{
		inteiro vetor[5][5],soma=0

		para(inteiro i=0;i<5;i++){
			para(inteiro c = 0;c<5;c++){
				escreva("Informe o valor da posição: ",i+1," x ",c+1)
				leia(vetor[i][c])
			}
		}
		
		
		para(inteiro i=0;i<5;i++){
			para(inteiro c = 0;c<5;c++){
				se(c != i e i+c !=4){
					soma += vetor[i][c]
				}
			}
		}

		escreva(soma)
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 301; 
 */