programa
{
	funcao inicio()
	{
		inteiro numero,qtdNumeroPares =0, total = 0, result
		
		escreva("Informe o Numero:")
		leia(numero)
		se(numero % 2 == 0){
				total = total + numero
				qtdNumeroPares = qtdNumeroPares +1
			}
		enquanto(numero !=0){
			escreva("Informe o Numero:")
			leia(numero)

			se(numero % 2 == 0){
				total = total + numero
				qtdNumeroPares = qtdNumeroPares +1
			}
		}
		escreva(total)
		result = total / (qtdNumeroPares-1)

		escreva("A soma de todos os numeros pares digitados é :",result)
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 227; 
 */