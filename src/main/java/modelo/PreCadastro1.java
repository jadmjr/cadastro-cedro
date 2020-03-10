package modelo;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import controle.Selenium;

public class PreCadastro1 extends Selenium {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;

	@FindBy(id = "mat-checkbox-3-input")
	@CacheLookup
	private WebElement boletimDeTaxasDeCmbio;

	@FindBy(id = "phone1")
	@CacheLookup
	private WebElement celular;

	@FindBy(id = "cpf")
	@CacheLookup
	private WebElement cpf;

	@FindBy(id = "primary_email")
	@CacheLookup
	private WebElement email;

	@FindBy(css = "a.cursor-pointer.already_client")
	@CacheLookup
	private WebElement entrar;

	@FindBy(id = "full_name")
	@CacheLookup
	private WebElement nomeCompleto;

	@FindBy(id = "mat-checkbox-1-input")
	@CacheLookup
	private WebElement novidadespromoes;

	@FindBy(id = "mat-checkbox-2-input")
	@CacheLookup
	private WebElement ofertasPblicas;

	private final String pageLoadedText = "Investimentos: transações em bolsa, fundos, renda fixa, renda variável e tesouro direto, inclusive operações de câmbio";

	private final String pageUrl = "/cadastro/pre-cadastro";

	@FindBy(id = "buttonNext")
	@CacheLookup
	private WebElement seguir;

	@FindBy(id = "toggle_advisor-input")
	@CacheLookup
	private WebElement toggle;

	@FindBy(id = "advisor")
	@CacheLookup
	private WebElement assessor;

	@FindBy(id = "reason2")
	@CacheLookup
	private WebElement somenteCmbio;

	@FindBy(id = "reason1")
	@CacheLookup
	private WebElement todosOsTiposDeInvestimento;

	@FindAll({ @FindBy(className = "select-error-msg") })
	@CacheLookup
	private List<WebElement> msgsErro;

	public PreCadastro1() {

	}

	public PreCadastro1(WebDriver driver) {
		this();
		this.driver = driver;
	}

	public PreCadastro1(WebDriver driver, Map<String, String> data) {
		this(driver);
		this.data = data;
	}

	public PreCadastro1(WebDriver driver, Map<String, String> data, int timeout) {
		this(driver, data);
		this.timeout = timeout;
	}

	/**
	 * Click on Entrar Link.
	 *
	 * @return the Primeira class instance.
	 */
	public PreCadastro1 clickEntrarLink() {
		entrar.click();
		return this;
	}

	public WebElement getBtnSeguir() {
		return seguir;
	}
	public List<WebElement> getMsgsErros() {
		return msgsErro;
	}

	/**
	 * Click on Seguir Button.
	 *
	 * @return the Primeira class instance.
	 */
	public PreCadastro1 clickSeguirButton() {
		seguir.click();
		return this;
	}

	public PreCadastro1 setAssessor(String texto) {
		new Select(assessor).selectByVisibleText(texto);
		return this;
	}

	public PreCadastro1 clickToggle() {
		JavascriptExecutor JSexecutor = (JavascriptExecutor) driver;
		JSexecutor.executeScript("arguments[0].click();", toggle);
		return this;
	}

	/**
	 * Click on Somente Cmbio Button.
	 *
	 * @return the Primeira class instance.
	 */
	public PreCadastro1 clickSomenteCmbioButton() {
		somenteCmbio.click();
		return this;
	}

	/**
	 * Click on Todos Os Tipos De Investimento Button.
	 *
	 * @return the Primeira class instance.
	 */
	public PreCadastro1 clickTodosOsTiposDeInvestimentoButton() {
		todosOsTiposDeInvestimento.click();
		return this;
	}

	/**
	 * Fill every fields in the page.
	 *
	 * @return the Primeira class instance.
	 */
	public PreCadastro1 fill() {
		setNomeCompletoTextField();
		setCpfTextField();
		setEmailTextField();
		setCelularTextField();
		setNovidadespromoesCheckboxField();
		setOfertasPblicasCheckboxField();
		setBoletimDeTaxasDeCmbioCheckboxField();
		return this;
	}

	/**
	 * Set Boletim De Taxas De Cmbio Checkbox field.
	 *
	 * @return the Primeira class instance.
	 */
	public PreCadastro1 setBoletimDeTaxasDeCmbioCheckboxField() {
		if (!boletimDeTaxasDeCmbio.isSelected()) {
			boletimDeTaxasDeCmbio.click();
		}
		return this;
	}

	/**
	 * Set default value to Celular Text field.
	 *
	 * @return the Primeira class instance.
	 */
	public PreCadastro1 setCelularTextField() {
		return setCelularTextField(data.get("CELULAR"));
	}

	/**
	 * Set value to Celular Text field.
	 *
	 * @return the Primeira class instance.
	 */
	public PreCadastro1 setCelularTextField(String celularValue) {
		celular.clear();
		celular.sendKeys(celularValue);
		return this;
	}

	/**
	 * Set default value to Cpf Text field.
	 *
	 * @return the Primeira class instance.
	 */
	public PreCadastro1 setCpfTextField() {
		return setCpfTextField(data.get("CPF"));
	}

	/**
	 * Set value to Cpf Text field.
	 *
	 * @return the Primeira class instance.
	 */
	public PreCadastro1 setCpfTextField(String cpfValue) {
		cpf.clear();
		cpf.sendKeys(cpfValue);
		return this;
	}

	public WebElement getNomeCompleto() {
		return nomeCompleto;
	}

	/**
	 * Set default value to Email Text field.
	 *
	 * @return the Primeira class instance.
	 */
	public PreCadastro1 setEmailTextField() {
		return setEmailTextField(data.get("EMAIL"));
	}

	/**
	 * Set value to Email Text field.
	 *
	 * @return the Primeira class instance.
	 */
	public PreCadastro1 setEmailTextField(String emailValue) {
		email.clear();
		email.sendKeys(emailValue);
		return this;
	}

	/**
	 * Set default value to Nome Completo Text field.
	 *
	 * @return the Primeira class instance.
	 */
	public PreCadastro1 setNomeCompletoTextField() {
		return setNomeCompletoTextField(data.get("NOME_COMPLETO"));
	}

	/**
	 * Set value to Nome Completo Text field.
	 *
	 * @return the Primeira class instance.
	 */
	public PreCadastro1 setNomeCompletoTextField(String nomeCompletoValue) {
		nomeCompleto.clear();
		nomeCompleto.sendKeys(nomeCompletoValue);
		return this;
	}

	/**
	 * Set Novidadespromoes Checkbox field.
	 *
	 * @return the Primeira class instance.
	 */
	public PreCadastro1 setNovidadespromoesCheckboxField() {
		if (!novidadespromoes.isSelected()) {
			novidadespromoes.click();
		}
		return this;
	}

	/**
	 * Set Ofertas Pblicas Checkbox field.
	 *
	 * @return the Primeira class instance.
	 */
	public PreCadastro1 setOfertasPblicasCheckboxField() {
		if (!ofertasPblicas.isSelected()) {
			ofertasPblicas.click();
		}
		return this;
	}

	/**
	 * Unset Boletim De Taxas De Cmbio Checkbox field.
	 *
	 * @return the Primeira class instance.
	 */
	public PreCadastro1 unsetBoletimDeTaxasDeCmbioCheckboxField() {
		if (boletimDeTaxasDeCmbio.isSelected()) {
			boletimDeTaxasDeCmbio.click();
		}
		return this;
	}

	/**
	 * Unset Novidadespromoes Checkbox field.
	 *
	 * @return the Primeira class instance.
	 */
	public PreCadastro1 unsetNovidadespromoesCheckboxField() {
		if (novidadespromoes.isSelected()) {
			novidadespromoes.click();
		}
		return this;
	}

	/**
	 * Unset Ofertas Pblicas Checkbox field.
	 *
	 * @return the Primeira class instance.
	 */
	public PreCadastro1 unsetOfertasPblicasCheckboxField() {
		if (ofertasPblicas.isSelected()) {
			ofertasPblicas.click();
		}
		return this;
	}

	/**
	 * Verify that the page loaded completely.
	 *
	 * @return the Primeira class instance.
	 */
	public PreCadastro1 verifyPageLoaded() {
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
	 * @return the Primeira class instance.
	 */
	public PreCadastro1 verifyPageUrl() {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getCurrentUrl().contains(pageUrl);
			}
		});
		return this;
	}
}
