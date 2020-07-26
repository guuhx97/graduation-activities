programa
{
	funcao inicio()
	{
		inteiro num, total=0,vinte=0

		enquanto(vinte <20 ){
			para(num = 100; num <=200;num++){	
				se(num == 1){
					escreva(1,"\n")
					vinte = vinte +1
				}
				para(inteiro i = 1; i <= num; i++){
					se(num % i == 0){
						total = total + 1	
					}
				}
				se(total == 2 e vinte < 20){
					escreva(num,"\n")
					vinte = vinte +1
				}	
				total = 0
				
			}
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 115; 
 */