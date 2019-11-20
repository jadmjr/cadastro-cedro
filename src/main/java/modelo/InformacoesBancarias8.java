package modelo;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import controle.Funcoes;

public class InformacoesBancarias8 extends Funcoes {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;

	@FindBy(id = "agency")
	@CacheLookup
	private WebElement agncia;

	@FindBy(id = "mat-input-8")
	@CacheLookup
	private WebElement banco;

	@FindBy(id = "account")
	@CacheLookup
	private WebElement conta;

	@FindBy(id = "joint_account-input")
	@CacheLookup
	private WebElement contaConjunta;

	@FindBy(id = "digit")
	@CacheLookup
	private WebElement dgito;

	private final String pageLoadedText = "Essas informações são elementos essenciais e requeridos pela Legislação, tratadas de forma sigilosa e confidencial nos termos da lei";

	private final String pageUrl = "/cadastro/informacoes-bancarias";

	@FindBy(id = "save")
	@CacheLookup
	private WebElement salvar;

	@FindBy(id = "buttonNext")
	@CacheLookup
	private WebElement seguir;

	@FindBy(css = "button.block-plan.mx-auto.d-flex.justify-content-center.align-items-center.my-2.ng-star-inserted")
	@CacheLookup
	private WebElement standart;

	@FindBy(id = "account_type")
	@CacheLookup
	private WebElement tipoDeConta;

	@FindBy(id = "previous")
	@CacheLookup
	private WebElement voltar;

	public InformacoesBancarias8() {
	}

	public InformacoesBancarias8(WebDriver driver) {
		this();
		this.driver = driver;
	}

	public InformacoesBancarias8(WebDriver driver, Map<String, String> data) {
		this(driver);
		this.data = data;
	}

	public InformacoesBancarias8(WebDriver driver, Map<String, String> data, int timeout) {
		this(driver, data);
		this.timeout = timeout;
	}

	/**
	 * Click on Salvar Button.
	 *
	 * @return the Oitava class instance.
	 */
	public InformacoesBancarias8 clickSalvarButton() {
		salvar.click();
		esperar(1500);
		return this;
	}

	/**
	 * Click on Seguir Button.
	 *
	 * @return the Oitava class instance.
	 */
	public InformacoesBancarias8 clickSeguirButton() {		
		seguir.click();
		return this;
	}

	/**
	 * Click on Standart Button.
	 *
	 * @return the Oitava class instance.
	 */
	public InformacoesBancarias8 clickStandartButton() {
		standart.click();
		return this;
	}

	/**
	 * Click on Voltar Button.
	 *
	 * @return the Oitava class instance.
	 */
	public InformacoesBancarias8 clickVoltarButton() {
		voltar.click();
		return this;
	}

	/**
	 * Fill every fields in the page.
	 *
	 * @return the Oitava class instance.
	 */
	public InformacoesBancarias8 fill() {
		setTipoDeContaDropDownListField();
		setBancoSearchField();
		setAgnciaNumberField();
		setContaNumberField();
		setDgitoTextField();
		setContaConjuntaCheckboxField();
		return this;
	}

	/**
	 * Set default value to Agncia Number field.
	 *
	 * @return the Oitava class instance.
	 */
	public InformacoesBancarias8 setAgnciaNumberField() {
		return setAgnciaNumberField(data.get("AGNCIA"));
	}

	/**
	 * Set value to Agncia Number field.
	 *
	 * @return the Oitava class instance.
	 */
	public InformacoesBancarias8 setAgnciaNumberField(String agnciaValue) {
		agncia.sendKeys(agnciaValue);
		return this;
	}

	/**
	 * Set default value to Banco Search field.
	 *
	 * @return the Oitava class instance.
	 */
	public InformacoesBancarias8 setBancoSearchField() {
		return setBancoSearchField(data.get("BANCO"));
	}

	/**
	 * Set value to Banco Search field.
	 *
	 * @return the Oitava class instance.
	 */
	public InformacoesBancarias8 setBancoSearchField(String bancoValue) {
		selecionarPrimeiraOpcao(banco, bancoValue);
		return this;
	}

	/**
	 * Set Conta Conjunta Checkbox field.
	 *
	 * @return the Oitava class instance.
	 */
	public InformacoesBancarias8 setContaConjuntaCheckboxField() {
		if (!contaConjunta.isSelected()) {
			contaConjunta.click();
		}
		return this;
	}

	/**
	 * Set default value to Conta Number field.
	 *
	 * @return the Oitava class instance.
	 */
	public InformacoesBancarias8 setContaNumberField() {
		return setContaNumberField(data.get("CONTA"));
	}

	/**
	 * Set value to Conta Number field.
	 *
	 * @return the Oitava class instance.
	 */
	public InformacoesBancarias8 setContaNumberField(String contaValue) {
		conta.sendKeys(contaValue);
		return this;
	}

	/**
	 * Set default value to Dgito Text field.
	 *
	 * @return the Oitava class instance.
	 */
	public InformacoesBancarias8 setDgitoTextField() {
		return setDgitoTextField(data.get("DGITO"));
	}

	/**
	 * Set value to Dgito Text field.
	 *
	 * @return the Oitava class instance.
	 */
	public InformacoesBancarias8 setDgitoTextField(String dgitoValue) {
		dgito.sendKeys(dgitoValue);
		return this;
	}

	/**
	 * Set default value to Tipo De Conta Drop Down List field.
	 *
	 * @return the Oitava class instance.
	 */
	public InformacoesBancarias8 setTipoDeContaDropDownListField() {
		return setTipoDeContaDropDownListField(data.get("TIPO_DE_CONTA"));
	}

	/**
	 * Set value to Tipo De Conta Drop Down List field.
	 *
	 * @return the Oitava class instance.
	 */
	public InformacoesBancarias8 setTipoDeContaDropDownListField(String tipoDeContaValue) {
		new Select(tipoDeConta).selectByVisibleText(tipoDeContaValue);
		return this;
	}

	/**
	 * Unset Conta Conjunta Checkbox field.
	 *
	 * @return the Oitava class instance.
	 */
	public InformacoesBancarias8 unsetContaConjuntaCheckboxField() {
		if (contaConjunta.isSelected()) {
			contaConjunta.click();
		}
		return this;
	}

	/**
	 * Unset default value from Tipo De Conta Drop Down List field.
	 *
	 * @return the Oitava class instance.
	 */
	public InformacoesBancarias8 unsetTipoDeContaDropDownListField() {
		return unsetTipoDeContaDropDownListField(data.get("TIPO_DE_CONTA"));
	}

	/**
	 * Unset value from Tipo De Conta Drop Down List field.
	 *
	 * @return the Oitava class instance.
	 */
	public InformacoesBancarias8 unsetTipoDeContaDropDownListField(String tipoDeContaValue) {
		new Select(tipoDeConta).deselectByVisibleText(tipoDeContaValue);
		return this;
	}

	/**
	 * Verify that the page loaded completely.
	 *
	 * @return the Oitava class instance.
	 */
	public InformacoesBancarias8 verifyPageLoaded() {
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
	 * @return the Oitava class instance.
	 */
	public InformacoesBancarias8 verifyPageUrl() {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getCurrentUrl().contains(pageUrl);
			}
		});
		return this;
	}
}
