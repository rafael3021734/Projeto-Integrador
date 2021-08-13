package Aplication;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;

import modelo.ContaComum;
import modelo.Movimento;
import repositorio.ContaComumRepository;
import repositorio.MovimentoRepository;
import repositorio.PersistenceConfig;

public class HistoricoReceitasDespesas {
	
	private static final DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	private static final Locale locale = new Locale("pt", "BR");      
	private static final NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

	public static void main(String[] args) {		
		
		ContaComumRepository contaComumRepository = new ContaComumRepository();
		
		System.out.println("\n*********Recuperação 3: Recupera conta com ID **********\n");
		
		System.out.println("Recuperando a ContaComum com número igual a 1 e exibindo suas informações:");
		
		ContaComum cc1 = contaComumRepository.recuperarContaComumPorNumeroConta(1l);
		
				
		Optional<Long> recuperarConta = Optional.of( cc1.getNumeroConta());
		
		recuperarConta.ifPresentOrElse((cc) ->
		 System.out.println("Conta #" +
					cc1.getNumeroConta() + 
					", Saldo: " + 
					currencyFormatter.format(cc1.getSaldoConta())),
		 			() -> System.out.println("Value is empty"));
		
		Optional<ContaComum> CC1 = Optional.ofNullable(cc1);
		
		if(CC1.isPresent())
		{
		System.out.println("Titulares: ");
		cc1.getPessoas().forEach(p -> System.out.println("  " + p.getNomePessoa()));
		}
		else {
        	Long orElseThrow = recuperarConta.orElseThrow(() -> new NullPointerException());
		    System.out.println(orElseThrow);
        }
			
		MovimentoRepository movimentoRepository = new MovimentoRepository();
		
		System.out.println("\n*********Recuperação 4: Listar histórico de Receitas e Despesas **********\n");
		
		System.out.println("Movimentos na Conta Comum #" + cc1.getNumeroConta());
		
		Set<Movimento> movimentosCc1 =
				movimentoRepository.recuperarMovimentosPorNumeroConta(cc1.getNumeroConta());
		
		movimentosCc1.forEach(m -> System.out.println("  " +
					dateFormatter.format(m.getDataHoraMovimento().getTime()) +
					(m.getTipoMovimento() == 1 ? " Receitas" : " Despesas") +
					" no valor de " +
					currencyFormatter.format(m.getValorMovimento())
				));
		
		PersistenceConfig.closeEntityManager();
		
	}

}
