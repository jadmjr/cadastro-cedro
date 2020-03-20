package modelo;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import controle.Selenium;

public class Endereco5 extends Selenium {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;

	@FindBy(id = "postal_code")
	@CacheLookup
	private WebElement cep;

	@FindBy(css = "a.link-default.bold-text")
	@CacheLookup
	private WebElement noSeiMeuCep;

	private final String pageLoadedText = "Não sei meu CEP";

	private final String pageUrl = "/cadastro/endereco";

	@FindBy(id = "next")
	@CacheLookup
	private WebElement seguir;

	@FindBy(css = "button.block-plan.mx-auto.d-flex.justify-content-center.align-items-center.my-2.ng-star-inserted")
	@CacheLookup
	private WebElement standart;

	@FindBy(id = "previous")
	@CacheLookup
	private WebElement voltar;

	@FindBy(id = "number")
	@CacheLookup
	private WebElement numero;

	@FindBy(id = "address_line2")
	@CacheLookup
	private WebElement complemento;

	@FindBy(id = "mat-checkbox-2")
	@CacheLookup
	private WebElement declaracaoEndereco;

	public Endereco5() {
	}

	public Endereco5(WebDriver driver) {
		this();
		this.driver = driver;
	}

	public Endereco5(WebDriver driver, Map<String, String> data) {
		this(driver);
		this.data = data;
	}

	public Endereco5(WebDriver driver, Map<String, String> data, int timeout) {
		this(driver, data);
		this.timeout = timeout;
	}

	/**
	 * Click on No Sei Meu Cep Link.
	 *
	 * @return the Quinta class instance.
	 */
	public Endereco5 clickNoSeiMeuCepLink() {
		noSeiMeuCep.click();
		return this;
	}
	
	public Endereco5 cliqueDeclaracao() {
		declaracaoEndereco.click();
		return this;
	}


	/**
	 * Click on Seguir Button.
	 *
	 * @return the Quinta class instance.
	 */
	public Endereco5 clickSeguirButton() {
		esperar(500);
		seguir.click();
		return this;
	}

	/**
	 * Click on Standart Button.
	 *
	 * @return the Quinta class instance.
	 */
	public Endereco5 clickStandartButton() {
		standart.click();
		return this;
	}

	/**
	 * Click on Voltar Button.
	 *
	 * @return the Quinta class instance.
	 */
	public Endereco5 clickVoltarButton() {
		voltar.click();
		return this;
	}

	/**
	 * Fill every fields in the page.
	 *
	 * @return the Quinta class instance.
	 */
	public Endereco5 fill() {
		setCepTextField();
		return this;
	}

	/**
	 * Set default value to Cep Text field.
	 *
	 * @return the Quinta class instance.
	 */
	public Endereco5 setCepTextField() {
		return setCepTextField(data.get("CEP"));
	}

	/**
	 * Set value to Cep Text field.
	 *
	 * @return the Quinta class instance.
	 */
	public Endereco5 setCepTextField(String cepValue) {
		cep.sendKeys(cepValue);
		return this;
	}

	public Endereco5 setNumero(String textoNumero) {
		numero.sendKeys(textoNumero);
		return this;
	}

	public Endereco5 setComplemento(String textoComplemento) {
		complemento.sendKeys(textoComplemento);
		return this;
	}

	/**
	 * Verify that the page loaded completely.
	 *
	 * @return the Quinta class instance.
	 */
	public Endereco5 verifyPageLoaded() {
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
	 * @return the Quinta class instance.
	 */
	public Endereco5 verifyPageUrl() {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getCurrentUrl().contains(pageUrl);
			}
		});
		return this;
	}
}
