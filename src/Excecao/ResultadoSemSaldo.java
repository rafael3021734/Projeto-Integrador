package Excecao;

public class ResultadoSemSaldo extends RuntimeException {	
		
	public ResultadoSemSaldo() {
		super("Erro: Despesa n�o p�de ser efetivado. Sem saldo!");
	}
}
