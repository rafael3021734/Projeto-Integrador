package Aplication;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Optional;


import modelo.Pessoa;
import repositorio.PersistenceConfig;
import repositorio.PessoaRepository;

public abstract class AtualizarCadastroPessoa {
		
	private static final Locale locale = new Locale("pt", "BR");      
	private static final NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
	
	/**
	 * Método principal com exemplos de atualização de dados. 
	 * @param args
	 */

	public static void main(String[] args) {
		
		PessoaRepository pessoaRepository = new PessoaRepository();
		
		System.out.println("\n********** Exemplo de Atualização 1: ********** \n");
		
		System.out.println("Recuperando a pessoa com ID igual a 2 e exibindo suas informações:");
		
		Pessoa p1 = pessoaRepository.recuperarPessoaPorId(49);
		
		Optional<Pessoa> pessoaOptional = Optional.ofNullable(p1);
		
		if(pessoaOptional.isPresent())
		{	
			System.out.println("Dados atuais da Pessoa p1: ");
			System.out.println("  Id: " + p1.getIdPessoa());
			System.out.println("  Nome: " + p1.getNomePessoa());
			System.out.println("  Renda: " + currencyFormatter.format(p1.getRendaPessoa()));
			System.out.println("  Telefone: " + p1.getTelefonePessoa());
			System.out.println("  Endereço: " + p1.getEnderecoPessoa() + ", CEP: " + p1.getCepPessoa());
			System.out.println("  Situação: " +
				(p1.getSituacaoPessoa() == 1 ? "Ativo" : "Inativo"));
			
			System.out.println("Atualizando a renda e o telefone da Pessoa p1:");

			p1.setRendaPessoa(2450.25);
			p1.setTelefonePessoa("(88) 7777-7777");
			
			// Atualização no banco de dados
			pessoaRepository.atualizarPessoa(p1);
			
			// Atualiza p1 com os dados cadastrados no banco de dados
			pessoaRepository.recuperarPessoaPorId(p1.getIdPessoa());			
			
			System.out.println("Dados da Pessoa p1 pós atualização do banco: ");
			System.out.println("  Id: " + p1.getIdPessoa());
			System.out.println("  Nome: " + p1.getNomePessoa());
			System.out.println("  Renda: " + currencyFormatter.format(p1.getRendaPessoa()));
			System.out.println("  Telefone: " + p1.getTelefonePessoa());
			System.out.println("  Endereço: " + p1.getEnderecoPessoa() + ", CEP: " + p1.getCepPessoa());
			System.out.println("  Situação: " +
				(p1.getSituacaoPessoa() == 1 ? "Ativo" : "Inativo"));
		}//*/
						
		PersistenceConfig.closeEntityManager();

	}

}
