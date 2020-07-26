programa
{
	funcao inicio()
	{
		real numero1,numero2,numero3

		escreva("Informe um numero: ")
		leia(numero1)
		escreva("Informe um numero: ")
		leia(numero2)
		escreva("Informe um numero: ")
		leia(numero3)

		se(numero1 < numero2 e numero1 < numero3){
			escreva(numero1)
		}senao se(numero2 < numero1 e numero2 < numero3){
			escreva(numero2)		
		}senao se(numero3 < numero1 e numero3 < numero2){
			escreva(numero3)
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 421; 
 */