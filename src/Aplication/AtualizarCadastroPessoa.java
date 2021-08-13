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
	 * M�todo principal com exemplos de atualiza��o de dados. 
	 * @param args
	 */

	public static void main(String[] args) {
		
		PessoaRepository pessoaRepository = new PessoaRepository();
		
		System.out.println("\n********** Exemplo de Atualiza��o 1: ********** \n");
		
		System.out.println("Recuperando a pessoa com ID igual a 2 e exibindo suas informa��es:");
		
		Pessoa p1 = pessoaRepository.recuperarPessoaPorId(49);
		
		Optional<Pessoa> pessoaOptional = Optional.ofNullable(p1);
		
		if(pessoaOptional.isPresent())
		{	
			System.out.println("Dados atuais da Pessoa p1: ");
			System.out.println("  Id: " + p1.getIdPessoa());
			System.out.println("  Nome: " + p1.getNomePessoa());
			System.out.println("  Renda: " + currencyFormatter.format(p1.getRendaPessoa()));
			System.out.println("  Telefone: " + p1.getTelefonePessoa());
			System.out.println("  Endere�o: " + p1.getEnderecoPessoa() + ", CEP: " + p1.getCepPessoa());
			System.out.println("  Situa��o: " +
				(p1.getSituacaoPessoa() == 1 ? "Ativo" : "Inativo"));
			
			System.out.println("Atualizando a renda e o telefone da Pessoa p1:");

			p1.setRendaPessoa(2450.25);
			p1.setTelefonePessoa("(88) 7777-7777");
			
			// Atualiza��o no banco de dados
			pessoaRepository.atualizarPessoa(p1);
			
			// Atualiza p1 com os dados cadastrados no banco de dados
			pessoaRepository.recuperarPessoaPorId(p1.getIdPessoa());			
			
			System.out.println("Dados da Pessoa p1 p�s atualiza��o do banco: ");
			System.out.println("  Id: " + p1.getIdPessoa());
			System.out.println("  Nome: " + p1.getNomePessoa());
			System.out.println("  Renda: " + currencyFormatter.format(p1.getRendaPessoa()));
			System.out.println("  Telefone: " + p1.getTelefonePessoa());
			System.out.println("  Endere�o: " + p1.getEnderecoPessoa() + ", CEP: " + p1.getCepPessoa());
			System.out.println("  Situa��o: " +
				(p1.getSituacaoPessoa() == 1 ? "Ativo" : "Inativo"));
		}//*/
						
		PersistenceConfig.closeEntityManager();

	}

}
