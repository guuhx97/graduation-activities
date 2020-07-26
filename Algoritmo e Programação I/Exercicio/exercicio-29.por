programa
{
	funcao inicio()
	{
		inteiro numero1,numero2,operacao,result
		
		faca{
			escreva("Informe o primeiro numero: ")
			leia(numero1)
			escreva("Informe o segundo Numero: ")
			leia(numero2)
			escreva("Escolha a Operação :\n")
			escreva("[1] Soma\n")
			escreva("[2] Subtrair\n")
			escreva("[3] Multiplicação\n")
			escreva("[4] Divisão\n")
			leia(operacao)

			escolha (operacao){
				caso 1:
					result  = numero1 + numero2
					escreva(result,"\n")
					pare
				caso 2:
					result = numero1 - numero2
					escreva(result,"\n")
					pare
				caso 3:
					result = numero1 * numero2
					escreva(result,"\n")
					pare
				caso 4:
					result = numero1 / numero2
					escreva(result,"\n")
					pare
				caso contrario:
					escreva("Escolha a Operação novamente :\n")
						escreva("[1] Soma\n")
						escreva("[2] Subtrair\n")
						escreva("[3] Multiplicação\n")
						escreva("[4] Divisão\n")
						leia(operacao)
				
			}
					
		}enquanto(numero1 != 0 e numero2 != 0)
		
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 706; 
 */