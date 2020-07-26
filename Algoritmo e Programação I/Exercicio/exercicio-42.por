programa
{
	funcao inicio()
	{
		real valor[5] , soma = 0.0, media
		inteiro i
		para( i = 0; i < 5;i++){
			escreva("Informe um valor inteiro: ")
			leia(valor[i],"\n")
			soma = soma + valor[i]
		}

		media = soma / i

		escreva(media)
		
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 103; 
 */