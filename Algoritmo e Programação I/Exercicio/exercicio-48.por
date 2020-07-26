programa
{
	funcao inicio()
	{
		inteiro vetor[10],posicao=0,maiorValor=0

		para(inteiro i = 0;i < 10;i++){
			escreva("Informe o valor: ")
			leia(vetor[i])

			se(vetor[i] > maiorValor){
				posicao = i
				maiorValor = vetor[i]
			}
		}

		escreva("O maior valor digitado foi ",maiorValor, " e sua posição é ",posicao)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 322; 
 */