package visao;

import java.util.Scanner;

import controle.ScriptCadastro;
import net.bytebuddy.asm.Advice.Exit;

public class Principal {

	static boolean MENOR_DE_IDADE = false;
	static boolean EMANCIPADO = false;
	static boolean ESTRANGEIRO = false;
	static boolean GESTOR = false;
	static int TIPO_DOCUMENTO = 1; // 1 PARA RG 2 PARA CNH 3 PARA RNE

	public static void main(String[] args) {
		// \n int procuradores = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("\nCenários Automatizados:\n \n 1 - MENOR DE IDADE EMANIPADO\n 2 - "
				+ "MENOR DE IDADE NÃO EMANCIPADO\n 3 - ESTRANGEIRO COM RNE\n 4 - MAIOR DE IDADE COM CNH	\n 5 - MAIOR DE IDADE COM RG \n 6 - CADASTRO COM GESTOR");

		System.out.println("\nInforme abaixo o número do cenário que deseja reproduzir e pressione enter: ");
		int cenario = sc.nextInt();

		switch (cenario) {
		case 1:
			MENOR_DE_IDADE = true;
			EMANCIPADO = true;
			break;
		case 2:
			MENOR_DE_IDADE = true;
			EMANCIPADO = false;
			break;
		case 3:
			ESTRANGEIRO = true;
			TIPO_DOCUMENTO = 3;
			break;
		case 4:
			TIPO_DOCUMENTO = 2;
			break;
		case 5:
			TIPO_DOCUMENTO = 1;
			break;
		case 6:
			GESTOR = true;
			TIPO_DOCUMENTO = 1;
			break;
		default:
			System.out.println("Você é um bricalhão mesmo! Adeus...");
			System.exit(0);
			break;
		}

		ScriptCadastro script = new ScriptCadastro();
		script.executar(MENOR_DE_IDADE, EMANCIPADO, ESTRANGEIRO, GESTOR, TIPO_DOCUMENTO);

	}

}
