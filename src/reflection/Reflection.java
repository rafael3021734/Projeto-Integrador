package reflection;

import java.lang.reflect.*;

import modelo.Pessoa;

public class Reflection {
	public Reflection() {
	}

	public void listaNomeDosMetodos() {
		try {
			Class cl = Class.forName("modelo.Pessoa");
			Method[] metodos = cl.getDeclaredMethods();

			for (int i = 0; i < metodos.length; i++) {
				System.out.println(metodos[i].toString());
			}

		} catch (Throwable e) {
			System.err.print(e);
		}
	}

	public void atributos() {
		try {
			Class cl = Class.forName("modelo.Pessoa");
			Method metodos[] = cl.getDeclaredMethods();
			for (int i = 0; i < metodos.length; i++) {
				Method m = metodos[i];
				System.out.println("Nome do metodo: " + m.getName());
				System.out.println("Parametros:");

				for (int z = 0; z < m.getParameterTypes().length; z++) {
					System.out.println("        " + z + ": " + m.getParameterTypes()[z]);
				}

				System.out.println("Tipo de returno: " + m.getReturnType());
			}

		} catch (Throwable e) {
			System.err.print(e);
		}
	}

	public void invocaMetodos() {
		Pessoa p1 = new Pessoa("Mariah dos Santos","maria_santospg@yahoo.com.br", "Av. Brasil, 1262", 1430001l, "(99) 99999-9999", 2500.55, 1);
		try {

			Class cl = Class.forName("modelo.Pessoa");
			Field[] fi = cl.getDeclaredFields();
			Method[] met = cl.getDeclaredMethods();
			for (int g = 0; g < met.length; g++) {
				System.out.println(fi[g].getName() + ": " + met[g].invoke(p1));
			}

		} catch (Throwable e) {
			System.err.print(e);
		}
	}

}
