programa
{
	funcao inicio()
	{
		inteiro numero,qtdNumeroPares =0, total = 0, result
		
		escreva("Informe o Numero real positivo:\n")
		leia(numero)
			se(numero <0){
				escreva("Numero invalido, tente novamente\n")
			}senao{
				escreva("Numero é valido")
			}
		
		enquanto(numero < 0){
			escreva("Informe o Numero real positivo:\n")
			leia(numero)

			se(numero < 0){
				escreva("Numero invalido, tente novamente\n")
			}senao{
				escreva("Numero é valido")
			}
		}
		
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 372; 
 */