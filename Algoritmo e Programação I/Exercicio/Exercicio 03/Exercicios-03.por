programa
{
	funcao real media(real v[],inteiro n, inteiro &i){
		real m = 0.0 ,k = 0.0
		inteiro valorMais = 0
		
		para(inteiro j = 0; j < n;j++){
			m += v[j]
		}
		m = m/n

		para(inteiro j = 0; j < n;j++){
			 k = v[j] - m
			 se(k < 0){
			 	k *= ( -1)
			 }
			
			se(k-m <= v[0]-m){
		
				i = j		
			}
			 
		}
	
		
		retorne m
	}
	funcao inicio()
	{
		
		real medi, notas[5] = {1.0,2.0,2.0,4.0,5.0}
		inteiro i = 0
		medi = media(notas,5,i)
		escreva(medi)
		escreva("\n",i)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 402; 
 */