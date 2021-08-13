package Aplication;
import java.util.Calendar;
import java.util.Scanner;

import modelo.ContaComum;
import modelo.Movimento;
import modelo.Pessoa;
import repositorio.ContaComumRepository;
import repositorio.PessoaRepository;

public class CadastrarPessoa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		try {
		Pessoa p1 = new Pessoa("Mariah dos Santos","maria_santospg@yahoo.com.br", "Av. Brasil, 1262", 1430001l, "(99) 99999-9999", 2500.55, 1);
		
		System.out.println("Digite um 1 para cadastrar uma pessoa: ");
		int a = sc.nextInt();
		if(a == 1) {
			
			Thread t1 = new Thread(p1);
	        t1.start();
	        
	        System.out.println("\n********** Exemplo de Inserção de Pessoa vinculada Conta: **********\n");
	        ContaComum cc1 = new ContaComum(8l, Calendar.getInstance(), null, 1, 123456, 5000.00);
			cc1.getPessoas().add(p1);
			}
		}catch(Exception e){
			
			System.out.println("erro:"+ e.getMessage());
		}
   }	
}
