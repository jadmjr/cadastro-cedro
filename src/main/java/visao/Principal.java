package visao;

import java.util.Scanner;

import controle.ScriptCadastro;

public class Principal {

	public static void main(String[] args) {

		boolean MENOR_DE_IDADE = false;
		boolean EMANCIPADO = true;
		boolean BRASILEIRO = false;
		boolean GESTOR = false;

		// int procuradores = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("*BEM VINDO AO CROONER*");
		System.out.println("Digite (S) para Sim e (N) para Não.");

		System.out.println("Deseja um cliente menor de idade? ");
		String menorDeIdade = sc.nextLine();

		String emancipado = sc.nextLine();
		if (menorDeIdade.toUpperCase().contains("S")) {
			System.out.println("Deseja um menor emancipado ?");
			emancipado = sc.nextLine();
		}

		System.out.println("Deseja um cliente Brasileiro?");
		String brasileio = sc.nextLine();

		System.out.println("Deseja um Assessor Gestor de Contas?");
		String gestor = sc.nextLine();

		System.out.println("*Agora irei criar o cliente para você utilizando a interface gráfica ...*");

		if (menorDeIdade.toUpperCase().contains("S"))
			MENOR_DE_IDADE = true;
		if (emancipado.toUpperCase().contains("S"))
			EMANCIPADO = true;
		if (brasileio.toUpperCase().contains("S"))
			BRASILEIRO = true;
		if (gestor.toUpperCase().contains("S"))
			GESTOR = true;

		System.out.println("MENOR_DE_IDADE: " + MENOR_DE_IDADE + "EMANCIPADO: " + EMANCIPADO + "BRASILEIRO: "
				+ BRASILEIRO + "GESTOR: " + GESTOR + "");

		ScriptCadastro script = new ScriptCadastro();
		script.executar(MENOR_DE_IDADE, EMANCIPADO, BRASILEIRO, GESTOR);

	}

}
