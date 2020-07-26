programa
{
	funcao inicio()
	{
		inteiro numero,menor,maior

		escreva("Informe um Peso: \n")
		leia (menor)
		maior = menor


		para(inteiro i = 1;i<=5;i++){
			escreva("Informe um Peso: \n")
			leia (numero)
			
			se(numero < menor){
				menor = numero		
			}senao se(numero > maior){
				maior = numero
				escreva(menor)
			}
	
		}
		escreva("O menor peso digitado foi: ",menor)
		escreva("O maior peso digitado foi: ",maior)
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 325; 
 */