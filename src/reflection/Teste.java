package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;




import modelo.Pessoa;

public class Teste {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		/*Reflection re = new Reflection();

		System.out.println("\n--- Lista todos os metodos da classe pesquisada ---\n");
		re.listaNomeDosMetodos();
		System.out.println("\n--- Lista atributos da classe ---\n");
		re.atributos();
		System.out.println("\n--- Invoca metodos da classe Pessoa ---\n");
		re.invocaMetodos();*/
		Class minhaClasse2 = Class.forName("modelo.PessoaRepository");
		//Class minhaClasse = Class.forName("modelo.Pessoa");
		Object pessoaRepository = minhaClasse2.getConstructor().newInstance();
		//Object pessoa = minhaClasse.getConstructor().newInstance();
		
		Class[] parametros = new Class[1];
		parametros[0] = int.class;
		//Method M = pessoaRepository.getClass().getDeclaredMethod("atualizarPessoa", parametros);
		//M.invoke(pessoaRepository, Pessoa);
		Method M = pessoaRepository.getClass().getDeclaredMethod("recuperarPessoaPorId");
		M.invoke(pessoaRepository);
	}

}
