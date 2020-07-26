programa
{
	funcao inicio()
	{
		real numero1,numero2,numero3,media

		escreva("Informe o tamanho do lado 1")
		leia(numero1)
		escreva("Informe o tamanho do lado 2: ")
		leia(numero2)
		escreva("Informe o tamanho do lado 3:  ")
		leia(numero3)

		se(numero1 == numero2 e numero1 == numero3 e numero2 ==numero3){
			escreva("Triangulo Equilatero")
		}senao se(numero1 == numero2 ou  numero1 == numero3 ou numero2 == numero3 ){
			escreva("isoceles")
		}senao se(numero1 != numero2 e numero1 != numero3 e numero2 != numero3){
			escreva("Escaleno")
		}
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 547; 
 */