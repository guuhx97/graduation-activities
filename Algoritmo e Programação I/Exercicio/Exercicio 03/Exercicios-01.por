programa
{

	funcao calculaHora(inteiro minutosPassados, inteiro &horaCorrente, inteiro &minutoCorrente){

		horaCorrente = minutosPassados / 60
		minutoCorrente = minutosPassados % 60
		
	}
	funcao inicio(){
		inteiro minutosPassados, minutoCorrente = 0, horaCorrente = 0
		
		escreva("Informe quantos minutos se passaram desde a meia Noite: ")
		leia(minutosPassados)

		calculaHora(minutosPassados,horaCorrente,minutoCorrente)
			
		
		escreva("são ",horaCorrente,":",minutoCorrente)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 486; 
 */