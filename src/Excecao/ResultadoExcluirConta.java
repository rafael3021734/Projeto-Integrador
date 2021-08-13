package Excecao;

public class ResultadoExcluirConta extends RuntimeException {	
	
	public ResultadoExcluirConta() {
		super("Erro: Não foi possível excluir a conta");
		}

}
