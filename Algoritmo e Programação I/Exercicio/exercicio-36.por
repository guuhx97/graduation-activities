programa
{
	funcao inicio()
	{
		inteiro numero,fator = 0

		escreva("Informe um numero :")
		leia(numero)
		fator = numero
		
		para(inteiro i = numero;i > 1;i--){
			escreva(i," X ")
			fator = (fator * (i-1))
	
		}
		escreva("1")

		escreva("\n o fatorial é : ",fator)


		
	
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 213; 
 */