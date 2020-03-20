package visao;

import java.util.Scanner;

import controle.ScriptCadastro;

public class Principal {

	static boolean MENOR_DE_IDADE = false;
	static boolean EMANCIPADO = false;
	static boolean ESTRANGEIRO = false;
	static boolean GESTOR = false;
	static int TIPO_DOCUMENTO = 1; // 1 PARA RG 2 PARA CNH 3 PARA RNE
	static String ambiente;

	public static void main(String[] args) {
		// \n int procuradores = 0;

		/*
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * System.out.println("Informe o ambiente em que deseja executar o automato: ");
		 * 
		 * System.out.println("\n 1 - Cedro QA \n 2 - Cedro DEV " +
		 * "\n 3 - UAT RB Investimentos \n 4 - Plataforma Lerosa \n 5 - Cadastro Trinus \n"
		 * ); int opcao = sc.nextInt();
		 * 
		 * switch (opcao) { case 1: ambiente =
		 * "https://qa.cedrotech.com/cadastro/pre-cadastro"; break; case 2: ambiente =
		 * "https://dev.cedrotech.com/cadastro/pre-cadastro"; break; case 3: ambiente =
		 * "https://uat.rbinvestimentos.com/cadastro/"; break; case 4: ambiente =
		 * "https://plataforma.lerosa.com.br/cadastro/"; break; case 5: ambiente =
		 * "http://cadastrodigital-trinus.cedrotech.com/cadastro/"; break; default:
		 * System.exit(0); break; }
		 * 
		 * System.out.
		 * println("\nCenários Automatizados:\n \n 1 - MENOR DE IDADE EMANIPADO\n 2 - "
		 * +
		 * "MENOR DE IDADE NÃO EMANCIPADO\n 3 - ESTRANGEIRO COM RNE\n 4 - MAIOR DE IDADE COM CNH	\n 5 - MAIOR DE IDADE COM RG \n 6 - CADASTRO COM GESTOR"
		 * );
		 * 
		 * System.out.
		 * println("\nInforme abaixo o número do cenário que deseja reproduzir e pressione enter: \n"
		 * ); int cenario = sc.nextInt();
		 * 
		 * sc.close();
		 * 
		 * switch (cenario) { case 1: MENOR_DE_IDADE = true; EMANCIPADO = true; break;
		 * case 2: MENOR_DE_IDADE = true; EMANCIPADO = false; break; case 3: ESTRANGEIRO
		 * = true; TIPO_DOCUMENTO = 3; break; case 4: TIPO_DOCUMENTO = 2; break; case 5:
		 * TIPO_DOCUMENTO = 1; break; case 6: GESTOR = true; TIPO_DOCUMENTO = 1; break;
		 * default: System.out.println("Você é um bricalhão mesmo! Adeus...");
		 * System.exit(0); break; }
		 */

		// JADMJR

		MENOR_DE_IDADE = false;
		EMANCIPADO = false;
		ESTRANGEIRO = false;
		GESTOR = false;
		TIPO_DOCUMENTO = 1;
		// ambiente = "https://plataforma.lerosa.com.br/cadastro/";

		// JADMJR
		ScriptCadastro script = new ScriptCadastro();
		ambiente = "https://uat.rbinvestimentos.com/cadastro/";
		script.executar(MENOR_DE_IDADE, EMANCIPADO, ESTRANGEIRO, GESTOR, TIPO_DOCUMENTO, ambiente);

	}

}
