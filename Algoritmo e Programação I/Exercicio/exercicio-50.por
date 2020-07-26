programa
{
	funcao inicio()
	{
		inteiro vetorA[10],vetorB[10],d=0,c=9

		para(inteiro i = 0;i<10;i++){
			escreva("Informe o valor do Vetor: ")
			leia(vetorA[i])
		}

		enquanto(d <10){
			vetorB[d] = vetorA[c]
			d++
			c--
		}

		para(inteiro i = 0;i<10;i++){
			escreva(vetorB[i])
		}



		
	
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 257; 
 */