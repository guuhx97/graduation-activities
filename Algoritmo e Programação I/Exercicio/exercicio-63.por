programa
{
	funcao inteiro potencia(inteiro base, inteiro expoente){
		inteiro result = 0, base2
		se(expoente == 0) {	
			retorne 1
		}senao se(expoente == 1){
			retorne base
		}senao{
			base2 = base
			para(inteiro i = 1; i < expoente; i++){		
				result = base * base2
				base2 = result
			}
		}
		retorne result
	}
	funcao inteiro fatoral(inteiro numero){
		para(inteiro i = numero;i > 1;i--){
			numero = (numero * (i-1))
		}

		retorne numero
	}

	
	funcao inicio()
	{
		inteiro x,termos,contador=0
		real S = 0.0
		escreva("Informe o numero de termos: ")
		leia(termos)
		escreva("Informe o valor de X: ")
		leia(x)

		para(inteiro i = 0; i < termos ; i++){
			se(contador % 2 ==0){
				S += potencia(x,i+2)/fatoral(i+3)
				
			}senao{
				S -= potencia(x,i+2)/fatoral(i+3)
				
			}
			contador++
		}
		escreva(S+1)
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 710; 
 */