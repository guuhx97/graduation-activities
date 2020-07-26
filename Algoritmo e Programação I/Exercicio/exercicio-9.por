programa
{
	funcao inicio()
	{
		inteiro numeroConta,centena,dezena,unidade
		escreva("Informe o numero : \n")
		leia(numeroConta)

			centena = (numeroConta % 1000) / 100
			dezena = (numeroConta % 100) / 10
			unidade = (numeroConta % 10)

			

			escreva ("O codigo Verificador é: ",unidade,dezena,centena)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 303; 
 */