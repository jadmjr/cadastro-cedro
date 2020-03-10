package visao;

import controle.BackOffice;

public class PrincipalBackOffice {

	public static void main(String[] args) {
		
		BackOffice bc = new BackOffice();
		bc.acessarAmbiente("https://qa.cedrotech.com/cockpit/login");
		bc.login("usr_dev_accounts", "Toor@2017");
		
		bc.acessarDashBoard();
		
		bc.acessarEsteiraPendetesDeAprovacao();
		bc.aprovarPendencias();
		
		//bc.fecharNavegador();

	}

}
