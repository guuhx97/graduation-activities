programa
{
	funcao inicio()
	{
			inteiro posicao=0,vetor[10],sete=0,posicaofinal=0
		para(inteiro i = 0;i <10;i++){
			escreva("Informe os numeros: ")
			leia(vetor[i])	
		}

		para(inteiro i = 0;i <10;i++){
			se(vetor[i] == 7){
				sete++
				se(posicao==0){
					posicao= i
				}
					
			}
		}
			
		se(sete > 0){
			escreva("O numero 7 foi encontrado  na posicao ",posicao," e foi encontrado ",sete," vezez")
		}senao{
			escreva("O valor nao foi Encontrado")
		}
			
		
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 259; 
 */