programa
{
	funcao inicio()
	{
		inteiro num, total=0
		
		escreva("Informe um numero: ")
		leia (num)
		
		para(inteiro i = 1; i <= num; i++){
			se(num % i == 0){
				total = total + 1
			}
		}
		se(total == 2 ou num == 1){
			escreva("Numero é Primo")
		}senao{
			escreva("Numero não é primo")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 218; 
 */