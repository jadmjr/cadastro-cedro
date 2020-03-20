package visao;

import controle.BackOffice;

public class PrincipalBackOffice {

	public static void main(String[] args) {
		
		String ambiente  = "https://uat.rbinvestimentos.com";
		
		BackOffice bc = new BackOffice();
		bc.acessarAmbiente(ambiente);
		bc.login("usr_cedro_accounts", "Toor@2017");
		
		//bc.acessarDashBoard();
		
		bc.acessarEsteiraPendetesDeAprovacao(ambiente);
		bc.aprovarPendencias();
		
		//bc.fecharNavegador();

	}

}
