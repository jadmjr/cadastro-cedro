package controle;

import org.openqa.selenium.support.PageFactory;

import modelo.CockpitLogin;
import modelo.PendetesDeApovacao;

public class Dashboard extends Selenium {

	public Dashboard() {
		inicializar();
	}

	public void logar(String url, String usuario, String senha) {
		abrirURL(url+"/cockpit/login");
		CockpitLogin cockpit = new CockpitLogin();
		PageFactory.initElements(navegador, cockpit);
		cockpit.setUsurioTextField(usuario);
		cockpit.setSenhaPasswordField(senha);
		cockpit.clickEntrarButton();

	}

	public void esteiraPendentesDeAprovacao(String ambiente) {
		esperar(3000);
		abrirURL(ambiente + "/backoffice/panel/dashboard/pending-aproved/1");
	}
	
	public void aprovaClientes() {
		PendetesDeApovacao pendentes = new PendetesDeApovacao(navegador);
		PageFactory.initElements(navegador, pendentes);
		pendentes.aprovaClientes();

	}

}
