programa
{
	funcao inicio()
	{
		inteiro exp,base,base2,result =0,ola=0
		
		escreva("Informe o valor da Base: ")
		leia(base)
		escreva("informe o valor do Expoente: ")
		leia (exp)

		se(exp == 0) {	
			escreva("1")
		}senao se(exp == 1){
			escreva(base)
		}senao{
		
		base2 = base
		
		para(inteiro i = 1; i < exp; i++){
			escreva(base," X ")
			
			result = base * base2
			base2 = result

			
				
		}escreva(base)
		escreva("\n",result)
	}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 260; 
 */