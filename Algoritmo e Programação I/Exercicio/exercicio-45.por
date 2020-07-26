programa
{
	funcao inicio(){
		inteiro vetor[100] , aux
		
		para(inteiro i = 0; i<100;i++){
			escreva("Informe o numero: \n")
			leia(vetor[i])
		}

		para(inteiro j = 0; j < 100; j++){
			para(inteiro c = 0;c < 5 ;c++){
				se(vetor[j] < vetor[c]){
					aux = vetor[j]
					vetor[j] = vetor[c]
					vetor[c] = aux
					
				}
				
			}
		}

		para(inteiro i = 0; i<100;i++){
			escreva(vetor[i],"\n")
			
		}

		
	}	
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 371; 
 */