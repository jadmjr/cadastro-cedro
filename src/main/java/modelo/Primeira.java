package modelo;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Primeira {
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

    @FindBy(id = "reason2")
    @CacheLookup
    private WebElement somenteCmbio;

    @FindBy(id = "reason1")
    @CacheLookup
    private WebElement todosOsTiposDeInvestimento;

    public Primeira() {
    	
    }

    public Primeira(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public Primeira(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public Primeira(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Entrar Link.
     *
     * @return the Primeira class instance.
     */
    public Primeira clickEntrarLink() {
        entrar.click();
        return this;
    }

    /**
     * Click on Seguir Button.
     *
     * @return the Primeira class instance.
     */
    public Primeira clickSeguirButton() {
        seguir.click();
        return this;
    }

    /**
     * Click on Somente Cmbio Button.
     *
     * @return the Primeira class instance.
     */
    public Primeira clickSomenteCmbioButton() {
        somenteCmbio.click();
        return this;
    }

    /**
     * Click on Todos Os Tipos De Investimento Button.
     *
     * @return the Primeira class instance.
     */
    public Primeira clickTodosOsTiposDeInvestimentoButton() {
        todosOsTiposDeInvestimento.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the Primeira class instance.
     */
    public Primeira fill() {
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
    public Primeira setBoletimDeTaxasDeCmbioCheckboxField() {
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
    public Primeira setCelularTextField() {
        return setCelularTextField(data.get("CELULAR"));
    }

    /**
     * Set value to Celular Text field.
     *
     * @return the Primeira class instance.
     */
    public Primeira setCelularTextField(String celularValue) {
        celular.sendKeys(celularValue);
        return this;
    }

    /**
     * Set default value to Cpf Text field.
     *
     * @return the Primeira class instance.
     */
    public Primeira setCpfTextField() {
        return setCpfTextField(data.get("CPF"));
    }

    /**
     * Set value to Cpf Text field.
     *
     * @return the Primeira class instance.
     */
    public Primeira setCpfTextField(String cpfValue) {
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
    public Primeira setEmailTextField() {
        return setEmailTextField(data.get("EMAIL"));
    }

    /**
     * Set value to Email Text field.
     *
     * @return the Primeira class instance.
     */
    public Primeira setEmailTextField(String emailValue) {
        email.sendKeys(emailValue);
        return this;
    }

    /**
     * Set default value to Nome Completo Text field.
     *
     * @return the Primeira class instance.
     */
    public Primeira setNomeCompletoTextField() {
        return setNomeCompletoTextField(data.get("NOME_COMPLETO"));
    }

    /**
     * Set value to Nome Completo Text field.
     *
     * @return the Primeira class instance.
     */
    public Primeira setNomeCompletoTextField(String nomeCompletoValue) {
        nomeCompleto.sendKeys(nomeCompletoValue);
        return this;
    }

    /**
     * Set Novidadespromoes Checkbox field.
     *
     * @return the Primeira class instance.
     */
    public Primeira setNovidadespromoesCheckboxField() {
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
    public Primeira setOfertasPblicasCheckboxField() {
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
    public Primeira unsetBoletimDeTaxasDeCmbioCheckboxField() {
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
    public Primeira unsetNovidadespromoesCheckboxField() {
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
    public Primeira unsetOfertasPblicasCheckboxField() {
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
    public Primeira verifyPageLoaded() {
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
    public Primeira verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
