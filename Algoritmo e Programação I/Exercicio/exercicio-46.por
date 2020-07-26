programa
{
	funcao inicio()
	{
		
		inteiro codigo[5],qtd[5],aux,aux2
		
		para(inteiro i = 0; i < 5; i++){
			escreva("Informe uo codigo do produto: ")
			leia(codigo[i])
			escreva("Informe a qtd de produtos: ")
			leia(qtd[i])
		}

		para(inteiro c = 0; c < 5; c++){
			para(inteiro i = 0; i < 5; i++){
				se(qtd[c] < qtd[i]){
					
					aux = qtd[c]
					qtd[c] = qtd[i]
					qtd[i] = aux

					aux2 = codigo[c]
					codigo[c] = codigo[i]
					codigo[i] = aux2
					
				}	
			}
		}

		para(inteiro i = 0; i < 5; i++){
			escreva(codigo[i],"  e ", qtd[i],"\n")
		}

	
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 564; 
 */