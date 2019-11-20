package modelo;

import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import controle.Funcoes;

public class InformacoesPessoais3 extends Funcoes {
	private Map<String, String> data;
	private WebDriver driver;
	private WebDriverWait wait;
	private int timeout = 15;

	@FindBy(id = "city")
	@CacheLookup
	private WebElement cidadeDeNascimento;

	@FindBy(id = "birth_date")
	@CacheLookup
	private WebElement dataDeNascimento;

	@FindBy(id = "marital_status")
	@CacheLookup
	private WebElement estadoCivil;

	@FindBy(id = "mat-input-1")
	@CacheLookup
	private WebElement estadoDeNascimento;

	@FindBy(id = "female")
	@CacheLookup
	private WebElement feminino;

	@FindBy(id = "male")
	@CacheLookup
	private WebElement masculino;

	@FindBy(id = "mother_name")
	@CacheLookup
	private WebElement nomeCompletoDaMe;

	@FindBy(id = "father_name")
	@CacheLookup
	private WebElement nomeCompletoDoPai;

	@FindBy(id = "second_email")
	@CacheLookup
	private WebElement opcional;

	private final String pageLoadedText = "Para sua identificação e segurança, essas informações são necessárias para a criação e validação do seu cadastro";

	private final String pageUrl = "/cadastro/informacoes-pessoais";

	@FindBy(id = "country")
	@CacheLookup
	private WebElement pasDeNascimento;

	@FindBy(id = "buttonNext")
	@CacheLookup
	private WebElement seguir;

	@FindBy(css = "button.block-plan.mx-auto.d-flex.justify-content-center.align-items-center.my-2.ng-star-inserted")
	@CacheLookup
	private WebElement standart;

	@FindBy(id = "home_phone")
	@CacheLookup
	private WebElement telefoneFixo;

	@FindBy(id = "buttonPrevious")
	@CacheLookup
	private WebElement voltar;

	public InformacoesPessoais3() {
	}

	public InformacoesPessoais3(WebDriver driver) {
		this();
		this.driver = driver;
	}

	public InformacoesPessoais3(WebDriver driver, Map<String, String> data) {
		this(driver);
		this.data = data;
	}

	public InformacoesPessoais3(WebDriver driver, Map<String, String> data, int timeout) {
		this(driver, data);
		this.timeout = timeout;
	}

	/**
	 * Click on Feminino Button.
	 *
	 * @return the Terceira class instance.
	 */
	public InformacoesPessoais3 clickFemininoButton() {
		feminino.click();
		return this;
	}

	/**
	 * Click on Masculino Button.
	 *
	 * @return the Terceira class instance.
	 */
	public InformacoesPessoais3 clickMasculinoButton() {
		masculino.click();
		return this;
	}

	/**
	 * Click on Seguir Button.
	 *
	 * @return the Terceira class instance.
	 */
	public InformacoesPessoais3 clickSeguirButton() {
		seguir.click();
		return this;
	}

	/**
	 * Click on Standart Button.
	 *
	 * @return the Terceira class instance.
	 */
	public InformacoesPessoais3 clickStandartButton() {
		standart.click();
		return this;
	}

	/**
	 * Click on Voltar Button.
	 *
	 * @return the Terceira class instance.
	 */
	public InformacoesPessoais3 clickVoltarButton() {
		voltar.click();
		return this;
	}

	/**
	 * Fill every fields in the page.
	 *
	 * @return the Terceira class instance.
	 */
	public InformacoesPessoais3 fill() {
		setDataDeNascimentoTextField();
		setOpcionalTextField();
		setTelefoneFixoTextField();
		setPasDeNascimentoSearchField();
		setEstadoDeNascimentoSearchField();
		setCidadeDeNascimentoSearchField();
		setEstadoCivilDropDownListField();
		setNomeCompletoDoPaiTextField();
		setNomeCompletoDaMeTextField();
		return this;
	}

	/**
	 * Set default value to Cidade De Nascimento Search field.
	 *
	 * @return the Terceira class instance.
	 */
	public InformacoesPessoais3 setCidadeDeNascimentoSearchField() {
		return setCidadeDeNascimentoSearchField(data.get("CIDADE_DE_NASCIMENTO"));
	}

	/**
	 * Set value to Cidade De Nascimento Search field.
	 *
	 * @return the Terceira class instance.
	 */
	public InformacoesPessoais3 setCidadeDeNascimentoSearchField(String cidadeDeNascimentoValue) {
		esperar(1000);
		selecionarPrimeiraOpcao(cidadeDeNascimento, cidadeDeNascimentoValue);
		return this;
	}

	/**
	 * Set default value to Data De Nascimento Text field.
	 *
	 * @return the Terceira class instance.
	 */
	public InformacoesPessoais3 setDataDeNascimentoTextField() {
		return setDataDeNascimentoTextField(data.get("DATA_DE_NASCIMENTO"));
	}

	/**
	 * Set value to Data De Nascimento Text field.
	 *
	 * @return the Terceira class instance.
	 */
	public InformacoesPessoais3 setDataDeNascimentoTextField(String dataDeNascimentoValue) {
		dataDeNascimento.sendKeys(dataDeNascimentoValue);
		return this;
	}

	/**
	 * Set default value to Estado Civil Drop Down List field.
	 *
	 * @return the Terceira class instance.
	 */
	public InformacoesPessoais3 setEstadoCivilDropDownListField() {
		return setEstadoCivilDropDownListField(data.get("ESTADO_CIVIL"));
	}

	/**
	 * Set value to Estado Civil Drop Down List field.
	 *
	 * @return the Terceira class instance.
	 */
	public InformacoesPessoais3 setEstadoCivilDropDownListField(String estadoCivilValue) {
		new Select(estadoCivil).selectByVisibleText(estadoCivilValue);
		return this;
	}

	/**
	 * Set default value to Estado De Nascimento Search field.
	 *
	 * @return the Terceira class instance.
	 */
	public InformacoesPessoais3 setEstadoDeNascimentoSearchField() {
		return setEstadoDeNascimentoSearchField(data.get("ESTADO_DE_NASCIMENTO"));
	}

	/**
	 * Set value to Estado De Nascimento Search field.
	 *
	 * @return the Terceira class instance.
	 */
	public InformacoesPessoais3 setEstadoDeNascimentoSearchField(String estadoDeNascimentoValue) {
		selecionarPrimeiraOpcao(estadoDeNascimento, estadoDeNascimentoValue);
		return this;
	}

	/**
	 * Set default value to Nome Completo Da Me Text field.
	 *
	 * @return the Terceira class instance.
	 */
	public InformacoesPessoais3 setNomeCompletoDaMeTextField() {
		return setNomeCompletoDaMeTextField(data.get("NOME_COMPLETO_DA_ME"));
	}

	/**
	 * Set value to Nome Completo Da Me Text field.
	 *
	 * @return the Terceira class instance.
	 */
	public InformacoesPessoais3 setNomeCompletoDaMeTextField(String nomeCompletoDaMeValue) {
		nomeCompletoDaMe.sendKeys(nomeCompletoDaMeValue);
		return this;
	}

	/**
	 * Set default value to Nome Completo Do Pai Text field.
	 *
	 * @return the Terceira class instance.
	 */
	public InformacoesPessoais3 setNomeCompletoDoPaiTextField() {
		return setNomeCompletoDoPaiTextField(data.get("NOME_COMPLETO_DO_PAI"));
	}

	/**
	 * Set value to Nome Completo Do Pai Text field.
	 *
	 * @return the Terceira class instance.
	 */
	public InformacoesPessoais3 setNomeCompletoDoPaiTextField(String nomeCompletoDoPaiValue) {
		nomeCompletoDoPai.sendKeys(nomeCompletoDoPaiValue);
		return this;
	}

	/**
	 * Set default value to Opcional Text field.
	 *
	 * @return the Terceira class instance.
	 */
	public InformacoesPessoais3 setOpcionalTextField() {
		return setOpcionalTextField(data.get("OPCIONAL"));
	}

	/**
	 * Set value to Opcional Text field.
	 *
	 * @return the Terceira class instance.
	 */
	public InformacoesPessoais3 setOpcionalTextField(String opcionalValue) {
		opcional.sendKeys(opcionalValue);
		return this;
	}

	/**
	 * Set default value to Pas De Nascimento Search field.
	 *
	 * @return the Terceira class instance.
	 */
	public InformacoesPessoais3 setPasDeNascimentoSearchField() {
		return setPasDeNascimentoSearchField(data.get("PAS_DE_NASCIMENTO"));

	}
	/**
	 * Set value to Pas De Nascimento Search field.
	 *
	 * @return the Terceira class instance.
	 */
	public InformacoesPessoais3 setPasDeNascimentoSearchField(String pasDeNascimentoValue) {
		selecionarPrimeiraOpcao(pasDeNascimento, pasDeNascimentoValue);
		return this;
	}

	/**
	 * Set default value to Telefone Fixo Text field.
	 *
	 * @return the Terceira class instance.
	 */
	public InformacoesPessoais3 setTelefoneFixoTextField() {
		return setTelefoneFixoTextField(data.get("TELEFONE_FIXO"));
	}

	/**
	 * Set value to Telefone Fixo Text field.
	 *
	 * @return the Terceira class instance.
	 */
	public InformacoesPessoais3 setTelefoneFixoTextField(String telefoneFixoValue) {
		telefoneFixo.sendKeys(telefoneFixoValue);
		return this;
	}

	/**
	 * Unset default value from Estado Civil Drop Down List field.
	 *
	 * @return the Terceira class instance.
	 */
	public InformacoesPessoais3 unsetEstadoCivilDropDownListField() {
		return unsetEstadoCivilDropDownListField(data.get("ESTADO_CIVIL"));
	}

	/**
	 * Unset value from Estado Civil Drop Down List field.
	 *
	 * @return the Terceira class instance.
	 */
	public InformacoesPessoais3 unsetEstadoCivilDropDownListField(String estadoCivilValue) {
		new Select(estadoCivil).deselectByVisibleText(estadoCivilValue);
		return this;
	}

	/**
	 * Verify that the page loaded completely.
	 *
	 * @return the Terceira class instance.
	 */
	public InformacoesPessoais3 verifyPageLoaded() {
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
	 * @return the Terceira class instance.
	 */
	public InformacoesPessoais3 verifyPageUrl() {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getCurrentUrl().contains(pageUrl);
			}
		});
		return this;
	}
}
