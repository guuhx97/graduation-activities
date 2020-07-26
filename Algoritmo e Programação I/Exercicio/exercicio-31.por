programa
{
	funcao inicio()
	{
		
		real soma = 0,numero

		escreva("Informe o de N: ")
		leia (numero)

		para(real i = 1; i <= numero; i++){

			soma = soma + (1/i)
			
			escreva("1/",i,"+")
			
		}
		escreva("\n",soma)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 116; 
 */