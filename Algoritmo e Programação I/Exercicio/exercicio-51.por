programa
{
	funcao inicio()
	{
		inteiro vetorA[5],vetorB[5],vetorUniao[10]
		para(inteiro i = 0;i<5;i++){
			escreva("Informe o valor do Vetor A: ")
			leia(vetorA[i])
			escreva("Informe o valor do Vetor B: ")
			leia(vetorB[i])
		}

		para(inteiro c= 0;c<5;c++){
			vetorUniao[c]=vetorA[c]
			vetorUniao[c+5]=vetorB[c]		
		}

		para(inteiro c= 0;c<10;c++){
			para(inteiro d=0;d<10;d++){
					se(c!=d){
						se( vetorUniao[c]==vetorUniao[d]){
							vetorUniao[c] = 0
						}
					}
			}				
		}

		para(inteiro c= 0;c<10;c++){
			se(vetorUniao[c] == 0){
				
			}senao{
				escreva(vetorUniao[c])
			}
				
		}
		escreva("\n")
		para(inteiro c= 0;c<5;c++){
			escreva(vetorA[c])
		}
		escreva("\n")
		para(inteiro c= 0;c<5;c++){
			escreva(vetorB[c])
		}
	}
	
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 631; 
 */