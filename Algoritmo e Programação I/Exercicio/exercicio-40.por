programa
{
	funcao inicio()
	{
		inteiro numeroAlunos, qtdProvas
		cadeia nomeAlunoMaiorMedia, nomeAluno
		real n1, soma = 0,md = 0,maiorMedia =0
		
		escreva("Informe o numero de alunos: ")
		leia(numeroAlunos)
		escreva("Informe a quantidade de provar que serão realizadas: ")
		leia(qtdProvas)

		para(inteiro i = 1;i<=numeroAlunos;i++){
			escreva("Nome do Aluno: ")
			leia(nomeAluno)
			para(inteiro c = 1;c <= qtdProvas;c++){
				escreva("Informe a nota da P",c,": ")
				leia(n1)
				soma = soma +n1
			}
			md = soma / qtdProvas
			
			se(md >= maiorMedia){
				nomeAlunoMaiorMedia = nomeAluno
				maiorMedia = md
			}
			soma = 0
					
		}

		escreva("A maior média foi ",maiorMedia," e foi do aluno ", nomeAlunoMaiorMedia)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 644; 
 */