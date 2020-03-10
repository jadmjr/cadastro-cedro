package visao;

import controle.Dashboard;

public class TesteDashboard {

	public static void main(String[] args) {
		Dashboard dash = new Dashboard();
		String ambiente = "https://dev.cedrotech.com";
		dash.logar(ambiente, "usr_dev_accounts", "Toor@2017");
		dash.esteiraPendentesDeAprovacao(ambiente);
		dash.aprovaClientes();
		
	}

}
