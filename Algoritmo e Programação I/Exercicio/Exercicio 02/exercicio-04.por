programa
{
	inclua biblioteca Matematica --> m
	
	
	funcao real  calculaPesoIdeal(real sexo, real altura){
		real pesoIdeal
		se(sexo == 1){
			 pesoIdeal = (72.7 * altura) - 58
		}senao se(sexo == 2){
			 pesoIdeal = (62.1 * altura) - 44.7
		}

		retorne pesoIdeal
	}
	
	funcao inicio(){
		inteiro sexo
		real altura
		escreva("-------INFORME O SEXO----------")
		escreva("-------------------------------\n")
		escreva("----INFORME 1 PARA MASCULINO---\n")
		escreva("----INFORME 2 PARA FEMININO----\n")
		escreva("-------------------------------\n")
		leia(sexo)
		escreva("Informe a altura")
		leia(altura)

		real peso = calculaPesoIdeal(sexo,altura)
		escreva(peso)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 669; 
 */