package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import modelo.Pessoa;
import repositorio.PessoaRepository;

public class Teste2 {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {
		
		Class minhaClasse = Class.forName("modelo.Pessoa");
		
				Object pessoa = minhaClasse.getConstructor().newInstance();
								
				Field F = pessoa.getClass().getDeclaredField("idPessoa");
				F.setAccessible(true);
				F.set(pessoa, 10);
				
				F = pessoa.getClass().getDeclaredField("nomePessoa");
				F.setAccessible(true);
				F.set(pessoa, "Vinicius");
				
				
				Reflexao.refletirObjeto(pessoa, pessoa.getClass());
			}
}
