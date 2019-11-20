package modelo;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import controle.Funcoes;

public class Declaracoes11 extends Funcoes {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;

	private final String pageLoadedText = "Ele serve para identificarmos a sua tolerância em relação à exposição aos riscos, para que possamos oferecer produtos e serviços compatíveis ao seu perfil ou até mesmo alertá-lo em caso de desenquadramento";

	private final String pageUrl = "/cadastro/perfil-investidor";

	@FindBy(id = "next")
	@CacheLookup
	private WebElement seguir;

	@FindBy(id = "previous")
	@CacheLookup
	private WebElement voltar;

	@FindAll({ @FindBy(tagName = "mat-radio-group") })
	@CacheLookup
	private List<WebElement> botoes;

	public Declaracoes11() {
	}

	public Declaracoes11(WebDriver driver) {
		this();
		this.driver = driver;
	}

	public Declaracoes11(WebDriver driver, Map<String, String> data) {
		this(driver);
		this.data = data;
	}

	public Declaracoes11(WebDriver driver, Map<String, String> data, int timeout) {
		this(driver, data);
		this.timeout = timeout;
	}

	/**
	 * Click on Seguir Button.
	 *
	 * @return the Decima class instance.
	 */
	public Declaracoes11 clickSeguirButton() {
		seguir.click();
		return this;
	}

	/**
	 * Click on Voltar Button.
	 *
	 * @return the Decima class instance.
	 */
	public Declaracoes11 clickVoltarButton() {
		voltar.click();
		return this;
	}

	/**
	 * Verify that the page loaded completely.
	 *
	 * @return the Decima class instance.
	 */
	public Declaracoes11 verifyPageLoaded() {
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
	 * @return the Decima class instance.
	 */
	public Declaracoes11 verifyPageUrl() {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getCurrentUrl().contains(pageUrl);
			}
		});
		return this;
	}

	public Declaracoes11 negarTudoNasDeclaracoes() {

		for (WebElement botao : botoes) {
			botao.findElements(By.tagName("mat-radio-button")).get(1).click();
			esperar(500);
		}
		return this;
	}

}
