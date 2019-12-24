package visao;

import java.util.Scanner;

import controle.ScriptCadastro;

public class Principal {

	public static void main(String[] args) {

		boolean MENOR_DE_IDADE = false;
		boolean EMANCIPADO = false;
		boolean BRASILEIRO = false;
		boolean GESTOR = false;

		// int procuradores = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("*BEM VINDO AO CROONER*");

		/*
		 * System.out.
		 * println("\n*DIGITE (S) PARA SIM E (N) PARA NÃO PARA NO QUESTIONÁRIO ABAIXO:*"
		 * );
		 * 
		 * System.out.println("\n*O NOVO CLIENTE PRECISA SER MENOR DE IDADE?*"); String
		 * menorDeIdade = sc.nextLine();
		 * 
		 * String emancipado = sc.nextLine(); if
		 * (menorDeIdade.toUpperCase().contains("S")) {
		 * System.out.println("\n*O NOVO CLIENTE PRECISA SER EMANCIPADO?*"); emancipado
		 * = sc.nextLine(); }
		 * 
		 * System.out.println("\n*O NOVO CLIENTE PRECISA SER BRASILEIRO?*"); String
		 * brasileio = sc.nextLine();
		 * 
		 * System.out.println("\n*QUER UM ASSESSOR GESTOR DE CONTAS?*"); String gestor =
		 * sc.nextLine();
		 * 
		 * System.out.
		 * println("\n*Vou criar o cliente utilizando a interface gráfica ...*\n");
		 * 
		 * if (menorDeIdade.toUpperCase().contains("S")) MENOR_DE_IDADE = true; if
		 * (emancipado.toUpperCase().contains("S")) EMANCIPADO = true; if
		 * (brasileio.toUpperCase().contains("S")) BRASILEIRO = true; if
		 * (gestor.toUpperCase().contains("S")) GESTOR = true;
		 */

		System.out.println("MENOR_DE_IDADE: " + MENOR_DE_IDADE + "\nEMANCIPADO: " + EMANCIPADO + "\nBRASILEIRO: "
				+ BRASILEIRO + "\nGESTOR: " + GESTOR + "");

		ScriptCadastro script = new ScriptCadastro();
		script.executar(MENOR_DE_IDADE, EMANCIPADO, BRASILEIRO, GESTOR);

	}

}
