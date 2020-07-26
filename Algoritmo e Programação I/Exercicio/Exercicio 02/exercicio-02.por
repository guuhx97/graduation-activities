programa
{
	inclua biblioteca Matematica --> m
	
	
	funcao real calculaArea(real num){
		real k
		k = m.PI * num
		retorne k
	}
	funcao real calculaPerimetro(real num){
		real k 
		k = m.PI * 2 * num
		retorne k
	}
	funcao inicio(){
		real raio,x
		escreva("Informe o valor do raio: ")
		leia(raio)
		x = calculaArea(raio)
		escreva(x,"\n")
		x = calculaPerimetro(raio)
		escreva(x)
		
	
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 339; 
 */