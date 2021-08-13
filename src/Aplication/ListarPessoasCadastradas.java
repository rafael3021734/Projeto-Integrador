package Aplication;


import java.util.Optional;
import java.util.Set;



import modelo.Pessoa;
import repositorio.PessoaRepository;

public class ListarPessoasCadastradas {
	
	public static void main(String[] args) {
		
		PessoaRepository pessoaRepository = new PessoaRepository();
		
		System.out.println("\n*********Recuperação 1: Listar todas as pessoas cadastradas no banco de dados**********\n");
		
		Set<Pessoa> pessoasCadastradas = pessoaRepository.recuperarPessoas();
		
		System.out.println("Todas as pessoas cadastradas no BD:");
		
		
		pessoasCadastradas.stream()
				.forEach(p -> System.out.println(p.getIdPessoa() + " - " + p.getNomePessoa()));
				
		System.out.println("\n*********Recuperação 2: Recupera pessoa com ID **********\n");
		
		System.out.println("Recuperando a pessoa com ID igual a 1 e exibindo suas informações:");
		
		Pessoa p1 = pessoaRepository.recuperarPessoaPorId(1);
		
		
		Optional<String> recuperarPessoa = Optional.of( p1.getNomePessoa());
				
		recuperarPessoa.ifPresentOrElse((pessoa) ->
		 System.out.println(p1.getNomePessoa()), () -> System.out.println("Value is empty"));
		       
	}	
}
