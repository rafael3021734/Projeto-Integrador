package Excecao;

public class ResultadoSemSaldo extends RuntimeException {	
		
	public ResultadoSemSaldo() {
		super("Erro: Despesa não pôde ser efetivado. Sem saldo!");
	}
}
