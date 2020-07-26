programa
{
	funcao inicio()
	{
		inteiro vetorA[5],vetorB[5],vetorInter[5],total=0
		para(inteiro c= 0;c<5;c++){
			escreva("Vetor A:")
			leia(vetorA[c])
			escreva("Vetor B:")
			leia(vetorB[c])
		}

		para(inteiro c= 0;c<5;c++){
			para(inteiro i= 0;i<5;i++){
				se(vetorA[c] == vetorB[i]){
					vetorInter[total] = vetorB[i]
					total++
				}
			}
		}
		
		para(inteiro c= 0;c<total;c++){
			escreva(vetorInter[c])
		}
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 360; 
 */