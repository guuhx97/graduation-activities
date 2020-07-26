programa
{
	funcao inicio()
	{
		inteiro saque, qtdCedulas10, qtdCedulas5, qtdCedulas1, resto

		escreva("Informe o valor do Saque ")
		leia(saque)

		qtdCedulas10 = saque / 10
		resto = saque % 10
		qtdCedulas5 = resto / 5 
		qtdCedulas1 = resto % 5 

		escreva("Cedulas de 10 = ",qtdCedulas10,"\n")
		escreva("Cedulas de 5 = ",qtdCedulas5,"\n")
		escreva("Cedulas de 2 = ",qtdCedulas1)

		
		

		
		
	
		
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 345; 
 */