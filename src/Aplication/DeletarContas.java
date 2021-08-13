package Aplication;

import Excecao.ResultadoExcluirConta;
import modelo.ContaComum;
import repositorio.ContaComumRepository;
import repositorio.PersistenceConfig;

public class DeletarContas {

	
	/**
	 *  M�todo principal com exemplos de exclus�o de dados. 
	 * @param args
	 */
	public static void main(String[] args) {

		ContaComumRepository contaComumRepository = new ContaComumRepository();
		
		ContaComum cc1 = contaComumRepository.recuperarContaComumPorNumeroConta(1l);
		
		System.out.println("\n********** Exemplo de Exclus�o da Conta: ********** \n");
		
		System.out.println("Excuindo a Conta Comum com ID igual a 1:");
		
		if(contaComumRepository.excluirContaComum(cc1))throw new ResultadoExcluirConta();
		{
			System.out.println("Conta Comum #1 exclu�da com sucesso.");
		}
		
		PersistenceConfig.closeEntityManager();

	}

}
