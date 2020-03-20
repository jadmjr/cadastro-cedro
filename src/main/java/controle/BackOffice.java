package controle;

import org.openqa.selenium.support.PageFactory;

import modelo.DashBoardEsteiras;
import modelo.Login;
import modelo.MenuInicial;
import modelo.PendetesDeAprovacao;

public class BackOffice extends Selenium {

	public void login(String usuario, String senha) {

		Login login = new Login();

		PageFactory.initElements(navegador, login);

		login.setUsurioTextField(usuario);
		login.setSenhaPasswordField(senha);
		login.clickEntrarButton();
	}

	public void acessarAmbiente(String url) {

		inicializar();
		abrirURL(url+"/cockpit/login");

	}

	public void acessarDashBoard() {

		MenuInicial menu = new MenuInicial(navegador);
		PageFactory.initElements(navegador, menu);
		menu.clickCadastroCliente();
		menu.clickDashboardLink();
		PageFactory.initElements(navegador, menu);
		menu.clickDashboardPaginaInicialLink();

	}

	public void acessarEsteiraPendetesDeAprovacao(String ambiente) {

		/*
		 * DashBoardEsteiras esteiras = new DashBoardEsteiras(navegador);
		 * PageFactory.initElements(navegador, esteiras);
		 * esteiras.acessarEsteiraPendentesAprovacao();
		 */
		esperar(1500);
		navegador.get(ambiente+"/backoffice/panel/dashboard/pending-aproved/1");

	}

	public void aprovarPendencias() {

		PendetesDeAprovacao pend = new PendetesDeAprovacao(navegador);
		PageFactory.initElements(navegador, pend);
		pend.aprovarPendencias();

	}

	public void fecharNavegador() {

		navegador.close();
	}

}
