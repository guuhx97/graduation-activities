programa
{

	funcao logico parOuImpar(inteiro num){
		logico k
		se(num % 2 == 0){
			k = verdadeiro
		}senao{
			k = falso
		}
		retorne k
	}
	funcao inicio(){
		inteiro num
		logico x
		escreva("Informe um numero: ")
		leia(num)
		x = parOuImpar(num)

		escreva(x)
	
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 268; 
 */