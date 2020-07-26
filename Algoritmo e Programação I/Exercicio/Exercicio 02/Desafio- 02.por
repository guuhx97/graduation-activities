programa
{
	funcao  realizaTest(inteiro A,inteiro B,inteiro C){
		se((B*B) + (C*C) == (A*A)){
			escreva("Igualdade Existe")
		}senao{
			escreva("Igualdade não existe")
		}
	}

	
	funcao inicio()
	{
		inteiro A,B,C
		escreva("Informe o valor de A : ")
		leia(A)
		escreva("Informe o valor de B : ")
		leia(B)
		escreva("Informe o valor de C : ")
		leia(C)

		realizaTest(A,B,C)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 8; 
 */