package Excecao;

public class ResultadoExcluirConta extends RuntimeException {	
	
	public ResultadoExcluirConta() {
		super("Erro: N�o foi poss�vel excluir a conta");
		}

}
