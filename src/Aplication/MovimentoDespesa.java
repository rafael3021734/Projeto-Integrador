package Aplication;
import java.util.Calendar;
import java.util.stream.Stream;

import modelo.ContaComum;
import modelo.Movimento;
import modelo.Pessoa;
import repositorio.ContaComumRepository;
import repositorio.PersistenceConfig;
import repositorio.PessoaRepository;

public class MovimentoDespesa {

	public static void main(String[] args) {
		
		/*Pessoa p1 = new Pessoa("Maria dos Santos", "Av. Brasil, 1262", 1430001l, "(99) 99999-9999", 2500.55, 1);
		Pessoa p2 = new Pessoa("João dos Santos", "Av. Brasil, 1262", 1430001l, "(88) 88888-8888", 2300.25, 1);
		
		PessoaRepository pessoaRepository = new PessoaRepository();
		
		System.out.println("\n********** Exemplo de Inserção 1: **********\n");
		
		pessoaRepository.criarPessoa(p1);
		pessoaRepository.criarPessoa(p2);
		
		System.out.println("ID da Pessoa p1: " + p1.getIdPessoa());
		System.out.println("ID da Pessoa p2: " + p2.getIdPessoa());*/
		
		//ContaComum cc1 = new ContaComum(1l, Calendar.getInstance(), null, 1, 123456, 5000.00);
		
		System.out.println("\n********** Exemplo de Inserção 2: Despesa **********\n");
		
		ContaComumRepository contaComumRepository = new ContaComumRepository();
		
		ContaComum cc1 = contaComumRepository.recuperarContaComumPorNumeroConta(1);	
		ContaComum cc2 = contaComumRepository.recuperarContaComumPorNumeroConta(2);	
			
		//contaComumRepository.criarContaComum(cc1);
				
		Movimento m2 = new Movimento(2, 10.0, cc1); // Despesa de R$ 3.500,00
		Movimento m3 = new Movimento(2, 10.0, cc2);		
		m2.registrarMovimento();
		
		System.out.println("Saldo cc1: " + cc1.getSaldoConta());
		System.out.println("Saldo cc2: " + cc2.getSaldoConta());
		
		//System.out.println("Saldo cc1: " + cc1.getSaldoConta());
		//m2.registrarMovimento();
		//System.out.println("Saldo cc1: " + cc1.getSaldoConta());
		
		//System.out.println("\n********** Exemplo de Inserção 4: **********\n");
		
		//m2.registrarMovimento();
		
		//Movimento m3 = new Movimento(2, 10500.0, cc1); // Despesa de R$ 10.500,00 
		
		//System.out.println("Saldo cc1: " + cc1.getSaldoConta());
		
		System.out.println("\n********** Tentativa de Inserção com sucesso: **********\n");
		
		
		
		PersistenceConfig.closeEntityManager();

	}	

}
