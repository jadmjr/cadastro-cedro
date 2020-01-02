package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import controle.Selenium;

public class Proton extends Selenium {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;

	@FindBy(css = "a.appVersion-container")
	@CacheLookup
	private WebElement _31619;

	@FindBy(css = "button.loginForm-btn-help")
	@CacheLookup
	private WebElement ajuda;

	@FindBy(css = "a[href='https://beta.protonmail.com/']")
	@CacheLookup
	private WebElement beta;

	@FindBy(css = "a.loginForm-link-signup-button.loginForm-actions-right.margin-bottom")
	@CacheLookup
	private WebElement criarConta;

	@FindBy(css = "a.headerNoAuth-item-logout-button.pm_button.primary")
	@CacheLookup
	private WebElement encerrarSesso;

	@FindBy(id = "login_btn")
	@CacheLookup
	private WebElement entrar;

	@FindBy(css = "button.togglePassword-btn-toggle")
	@CacheLookup
	private WebElement exibirSenhaOcultarSenha;

	@FindBy(id = "username")
	@CacheLookup
	private WebElement loginDeAcesso;

	private final String pageLoadedText = "Início de sessão do usuário";

	private final String pageUrl = "/login";

	@FindBy(css = "a.headerNoAuth-item-signup-button.pm_button.primary")
	@CacheLookup
	private WebElement registreseGratuitamente;

	@FindBy(css = "button.headerNoAuth-item-report-button.newBugReport-container")
	@CacheLookup
	private WebElement reportarErro;

	@FindBy(id = "password")
	@CacheLookup
	private WebElement senha;

	@FindBy(css = "a.link.loginForm-btn-oldversion")
	@CacheLookup
	private WebElement versoAntiga;

	@FindBy(css = "a.headerNoAuth-item-auth")
	@CacheLookup
	private WebElement voltarParaOIncioDe;

	@FindBy(css = "a.headerNoAuth-item-noAuth")
	@CacheLookup
	private WebElement voltarParaProtonmailCom;

	@FindAll({ @FindBy(className = "conversation") })
	@CacheLookup
	private List<WebElement> conversas;

	public Proton() {
	}

	public Proton(WebDriver driver) {
		this();
		this.driver = driver;
	}

	public Proton(WebDriver driver, Map<String, String> data) {
		this(driver);
		this.data = data;
	}

	public Proton(WebDriver driver, Map<String, String> data, int timeout) {
		this(driver, data);
		this.timeout = timeout;
	}

	/**
	 * Click on Ajuda Button.
	 *
	 * @return the Proton class instance.
	 */
	public Proton clickAjudaButton() {
		ajuda.click();
		return this;
	}

	/**
	 * Click on Beta Link.
	 *
	 * @return the Proton class instance.
	 */
	public Proton clickBetaLink() {
		beta.click();
		return this;
	}

	/**
	 * Click on Criar Conta Link.
	 *
	 * @return the Proton class instance.
	 */
	public Proton clickCriarContaLink() {
		criarConta.click();
		return this;
	}

	/**
	 * Click on Encerrar Sesso Link.
	 *
	 * @return the Proton class instance.
	 */
	public Proton clickEncerrarSessoLink() {
		encerrarSesso.click();
		return this;
	}

	/**
	 * Click on Entrar Button.
	 *
	 * @return the Proton class instance.
	 */
	public Proton clickEntrarButton() {
		entrar.click();
		return this;
	}

	/**
	 * Click on Exibir Senha Ocultar Senha Button.
	 *
	 * @return the Proton class instance.
	 */
	public Proton clickExibirSenhaOcultarSenhaButton() {
		exibirSenhaOcultarSenha.click();
		return this;
	}

	/**
	 * Click on 3.16.19 Link.
	 *
	 * @return the Proton class instance.
	 */
	public Proton clickLink31619() {
		_31619.click();
		return this;
	}

	/**
	 * Click on Registrese Gratuitamente Link.
	 *
	 * @return the Proton class instance.
	 */
	public Proton clickRegistreseGratuitamenteLink() {
		registreseGratuitamente.click();
		return this;
	}

	/**
	 * Click on Reportar Erro Button.
	 *
	 * @return the Proton class instance.
	 */
	public Proton clickReportarErroButton() {
		reportarErro.click();
		return this;
	}

	/**
	 * Click on Verso Antiga Link.
	 *
	 * @return the Proton class instance.
	 */
	public Proton clickVersoAntigaLink() {
		versoAntiga.click();
		return this;
	}

	/**
	 * Click on Voltar Para O Incio De Sesso Link.
	 *
	 * @return the Proton class instance.
	 */
	public Proton clickVoltarParaOIncioDeLink() {
		voltarParaOIncioDe.click();
		return this;
	}

	/**
	 * Click on Voltar Para Protonmail.com Link.
	 *
	 * @return the Proton class instance.
	 */
	public Proton clickVoltarParaProtonmailComLink() {
		voltarParaProtonmailCom.click();
		return this;
	}

	/**
	 * Fill every fields in the page.
	 *
	 * @return the Proton class instance.
	 */
	public Proton fill() {
		setLoginDeAcessoTextField();
		setSenhaPasswordField();
		return this;
	}

	/**
	 * Fill every fields in the page and submit it to target page.
	 *
	 * @return the Proton class instance.
	 */
	public Proton fillAndSubmit() {
		fill();
		return submit();
	}

	/**
	 * Set default value to Login De Acesso Text field.
	 *
	 * @return the Proton class instance.
	 */
	public Proton setLoginDeAcessoTextField() {
		return setLoginDeAcessoTextField(data.get("LOGIN_DE_ACESSO"));
	}

	/**
	 * Set value to Login De Acesso Text field.
	 *
	 * @return the Proton class instance.
	 */
	public Proton setLoginDeAcessoTextField(String loginDeAcessoValue) {
		loginDeAcesso.sendKeys(loginDeAcessoValue);
		return this;
	}

	/**
	 * Set default value to Senha Password field.
	 *
	 * @return the Proton class instance.
	 */
	public Proton setSenhaPasswordField() {
		return setSenhaPasswordField(data.get("SENHA"));
	}

	/**
	 * Set value to Senha Password field.
	 *
	 * @return the Proton class instance.
	 */
	public Proton setSenhaPasswordField(String senhaValue) {
		senha.sendKeys(senhaValue);
		return this;
	}

	public String buscarToken(String dataHora) {
		
		
		for (WebElement conversa : conversas) {
			//dataHora = "17:17";
			String horas = conversa.findElement(By.className("time")).getText();

			if (horas.length() <= 5) {
				if (dataHora.contains(horas)) {

					conversa.click();

					// This will scroll the web page till end.
					JSexecutor = (JavascriptExecutor) this.driver;
					JSexecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

					WebElement box = this.driver.findElement(By.id("pm_thread"));
					List<WebElement> mensagens = box.findElements(By.tagName("article"));
					mensagens.get(mensagens.size() - 1).click();
					String token = mensagens.get(mensagens.size() - 1).findElement(By.tagName("h1")).getText();
					return token;

				} else {
					//this.driver.navigate().refresh();
					buscarToken(dataHora);
				}

			}
		}

		return null;
	}

	/**
	 * Submit the form to target page.
	 *
	 * @return the Proton class instance.
	 */
	public Proton submit() {
		clickEntrarButton();
		return this;
	}

	/**
	 * Verify that the page loaded completely.
	 *
	 * @return the Proton class instance.
	 */
	public Proton verifyPageLoaded() {
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
	 * @return the Proton class instance.
	 */
	public Proton verifyPageUrl() {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getCurrentUrl().contains(pageUrl);
			}
		});
		return this;
	}
}
