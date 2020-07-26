programa
{
	funcao inicio()
	{
		inteiro vetorUm[10] , vetorDois[10],vetorResposta[10]

		para(inteiro i = 0; i < 10;i++){
			escreva("Informe o ",i," numero do PRIMEIRO vetor: ")
			leia(vetorUm[i])
			escreva("informe o ",i," numero do SEGUNDO vetor: ")
			leia(vetorDois[i])

			vetorResposta[i] = vetorUm[i] * vetorDois[i]
		}


		para(inteiro c= 0; c <10;c++){
			escreva(vetorResposta[c],"\n")
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 359; 
 */