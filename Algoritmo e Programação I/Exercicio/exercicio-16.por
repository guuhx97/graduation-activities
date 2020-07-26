programa
{
	funcao inicio()
	{
		real numero1,numero2

		escreva("Informe um numero: ")
		leia(numero1)
		escreva("Informe outro numero:")
		leia(numero2)

		se(numero1 > numero2){
			escreva(numero1 ," é maior")
		}senao se(numero2 > numero1){
			escreva(numero2," é maior")		
		}senao{
			escreva("os numeros informados são iguais")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 224; 
 */