programa
{
	inclua biblioteca Matematica --> m
	
	
	funcao   informaTipo(inteiro lados, real tamanho){
		real resp
		se(lados == 3){
			resp = tamanho + tamanho + tamanho
			escreva("O triangulo tem perimetro de ",resp," cm") 
		}senao se(lados == 4){
			resp = tamanho+tamanho+tamanho+tamanho
			escreva("O quadrado tem perimetro de ", resp," cm")
		}senao{
			resp = tamanho+tamanho+tamanho+tamanho+tamanho
			escreva("O pentagono tem perimetro de ", resp," cm")
		}
	}
	
	funcao inicio(){
		
		inteiro lados
		real tamanho
		faca{
			escreva("Informe o numero de lados (3,4,5)")
			leia(lados)
		}enquanto(lados != 4 e lados != 5 e lados != 3)

		escreva("Informe o tamanho do lado em cm ")
		leia(tamanho)

		informaTipo(lados,tamanho)
	
	
	
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 221; 
 */