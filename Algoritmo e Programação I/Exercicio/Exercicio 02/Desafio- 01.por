programa
{
	inclua biblioteca Graficos --> g
	inclua biblioteca Teclado --> t
	inclua biblioteca Texto --> f
	inclua biblioteca Util --> u

	
	
	funcao montaTela(){		
			g.iniciar_modo_grafico(verdadeiro)
			g.definir_dimensoes_janela(800, 600)
			g.definir_cor(g.COR_BRANCO)
			g.desenhar_retangulo(0, 0, 800, 600, falso, verdadeiro)
			g.renderizar()
		
	}
	
	funcao EscreveNaTela(cadeia frase){
			g.definir_cor(g.COR_PRETO)
			g.desenhar_texto(400, 300, frase)
			g.definir_tamanho_texto(50.0)
			g.renderizar()
			u.aguarde(10000)
			
	}
	funcao inicio()
	{
		cadeia frase
		escreva("Informe uma mensagem: ")
		leia(frase)
		montaTela()
		EscreveNaTela(frase)
		
		
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 494; 
 */