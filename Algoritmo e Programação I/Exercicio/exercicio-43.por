programa
{
	funcao inicio()
	{
		inteiro impar[30], par[30], i,valor,im = 0,p =0
		inteiro somapar = 0, somaimpar =0 

		para(i = 0; i < 30; i++){
			escreva("Informe os valores: ")
			leia(valor)

			se(valor % 2 == 0){
				par[p] = valor
				somapar = somapar + valor
				p++
			}senao{
				impar[im] = valor
				somaimpar = somaimpar + valor
				im++
			}
		}
		

			se(somapar > somaimpar){
				escreva(somapar)
			}senao{
				escreva(somaimpar)
			}
			
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 143; 
 */