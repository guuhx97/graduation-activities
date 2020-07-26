programa
{
	inclua biblioteca Matematica --> m
	
	
	funcao  calculaMedia(real nota1, real nota2){
		real media = (nota1 + nota2) / 2
		se(media >= 6.0){
			escreva("Parabéns Voce foi APROVADO")
		}senao{
			escreva("Infelizmente voce foi REPROVADO")
		}
	}
	
	funcao inicio(){
		real nota1,nota2
		escreva("Informe a primeira nota ")
		leia(nota1)
		escreva("informe a segunda nota ")
		leia(nota2)

		calculaMedia(nota1,nota2)
		
	
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 426; 
 */