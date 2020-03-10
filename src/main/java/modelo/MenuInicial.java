package modelo;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import controle.Selenium;

public class MenuInicial extends Selenium {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;

	@FindBy(css = "button.navbar-menu-button.mat-button")
	@CacheLookup
	private WebElement apps;

	private WebElement dashboard;

	private WebElement paginaInicial;

	@FindAll({ @FindBy(className = "list-options") })
	@CacheLookup
	private List<WebElement> listaDeOpcoes;

	@FindBy(css = "a.navbar-brand")
	@CacheLookup
	private WebElement logowhite;

	@FindBy(id = "Cadastro de cliente")
	@CacheLookup
	private WebElement cadastroDeClientes;

	private final String pageLoadedText = "Usuários e permissões";

	private final String pageUrl = "/cockpit/modules";

	public MenuInicial() {
	}

	public MenuInicial(WebDriver driver) {
		this();
		this.driver = driver;
	}

	public MenuInicial(WebDriver driver, Map<String, String> data) {
		this(driver);
		this.data = data;
	}

	public MenuInicial(WebDriver driver, Map<String, String> data, int timeout) {
		this(driver, data);
		this.timeout = timeout;
	}

	/**
	 * Click on Apps Button.
	 *
	 * @return the MenuInicial class instance.
	 */
	public MenuInicial clickAppsButton() {
		apps.click();
		return this;
	}

	/**
	 * Click on Dashboard Link.
	 *
	 * @return the MenuInicial class instance.
	 */
	public MenuInicial clickDashboardLink() {
		esperar(1000);

		dashboard = listaDeOpcoes.get(0).findElement(By.id("Dashboard")).findElement(By.tagName("div"));
		dashboard.click();
		return this;

	}

	public MenuInicial clickDashboardPaginaInicialLink() {
		esperar(1000);

		paginaInicial = listaDeOpcoes.get(1).findElements(By.tagName("a")).get(0);
		paginaInicial.click();
		return this;

	}

	public MenuInicial clickCadastroCliente() {
		cadastroDeClientes.click();
		return this;
	}

	/**
	 * Click on Logowhite Link.
	 *
	 * @return the MenuInicial class instance.
	 */
	public MenuInicial clickLogowhiteLink() {
		logowhite.click();
		return this;
	}

	/**
	 * Submit the form to target page.
	 *
	 * @return the MenuInicial class instance.
	 */
	public MenuInicial submit() {
		clickAppsButton();
		return this;
	}

	/**
	 * Verify that the page loaded completely.
	 *
	 * @return the MenuInicial class instance.
	 */
	public MenuInicial verifyPageLoaded() {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getPageSource().contains(pageLoadedText);
			}
		});
		return this;
	}

	/**
	 * Verify that current page URL matches the expected URL.
	 *
	 * @return the MenuInicial class instance.
	 */
	public MenuInicial verifyPageUrl() {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getCurrentUrl().contains(pageUrl);
			}
		});
		return this;
	}
}
