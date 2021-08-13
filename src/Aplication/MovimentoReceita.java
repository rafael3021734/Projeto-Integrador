package Aplication;
import java.util.Calendar;

import modelo.ContaComum;
import modelo.Movimento;
import modelo.Pessoa;
import repositorio.ContaComumRepository;
import repositorio.PersistenceConfig;
import repositorio.PessoaRepository;

public class MovimentoReceita {

	public static void main(String[] args) {
		
		/*Pessoa p1 = new Pessoa("Mariah dos Santos","maria_santospg@yahoo.com.br", "Av. Brasil, 1262", 1430001l, "(99) 99999-9999", 2500.55, 1);
		//Pessoa p2 = new Pessoa("João dos Santos", "Av. Brasil, 1262", 1430001l, "(88) 88888-8888", 2300.25, 1);
		
		PessoaRepository pessoaRepository = new PessoaRepository();
		
		System.out.println("\n********** Exemplo de Inserção 1: **********\n");
		
		pessoaRepository.criarPessoa(p1);
		//pessoaRepository.criarPessoa(p2);
		
		System.out.println("ID da Pessoa p1: " + p1.getIdPessoa());
		//System.out.println("ID da Pessoa p2: " + p2.getIdPessoa());*/
		
		//ContaComum cc1 = new ContaComum(1l, Calendar.getInstance(), null, 1, 123456, 5000.00);
				
		//cc1.getPessoas().add(p1);
		//cc1.getPessoas().add(p2); 
		System.out.println("\n********** Exemplo de Inserção 2: **********\n");
		
		ContaComumRepository contaComumRepository = new ContaComumRepository();
		
		ContaComum cc1 = contaComumRepository.recuperarContaComumPorNumeroConta(1);		
		
		Movimento m1 = new Movimento(1, 8000.0, cc1); // Receita de R$ 3.500,00
		
		System.out.println("Saldo cc1: " + cc1.getSaldoConta());
		
		m1.registrarMovimento();
	
		System.out.println("Saldo cc1: " + cc1.getSaldoConta());
		
		System.out.println("\n********** Exemplo de Inserção 2: **********\n");
		
		//contaComumRepository.criarContaComum(cc1);
		
		//Movimento m1 = new Movimento(1, 1250.0, cc1); // Receita de R$ 1.250,00
		
		//System.out.println("\n********** Exemplo de Inserção 3: **********\n");
		
		//m1.registrarMovimento();
		//System.out.println("Saldo cc1: " + cc1.getSaldoConta());
		
		//Movimento m2 = new Movimento(2, 3500.0, cc1); // Despesa de R$ 3.500,00
		
		//System.out.println("\n********** Exemplo de Inserção 4: **********\n");
		//System.out.println("Saldo cc1: " + cc1.getSaldoConta());
		
		//m2.registrarMovimento();
		//System.out.println("Saldo cc1: " + cc1.getSaldoConta());
		
		//Movimento m3 = new Movimento(2, 10500.0, cc1); // Despesa de R$ 10.500,00 
		
		//System.out.println("\n********** Tentativa de Inserção sem sucesso: **********\n");
		
		//m3.registrarMovimento();
		//System.out.println("Saldo cc1: " + cc1.getSaldoConta());
		
		PersistenceConfig.closeEntityManager();

	}	

}
