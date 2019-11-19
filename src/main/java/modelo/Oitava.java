package modelo;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Oitava {
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

    public Oitava() {
    }

    public Oitava(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public Oitava(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public Oitava(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Salvar Button.
     *
     * @return the Oitava class instance.
     */
    public Oitava clickSalvarButton() {
        salvar.click();
        return this;
    }

    /**
     * Click on Seguir Button.
     *
     * @return the Oitava class instance.
     */
    public Oitava clickSeguirButton() {
        seguir.click();
        return this;
    }

    /**
     * Click on Standart Button.
     *
     * @return the Oitava class instance.
     */
    public Oitava clickStandartButton() {
        standart.click();
        return this;
    }

    /**
     * Click on Voltar Button.
     *
     * @return the Oitava class instance.
     */
    public Oitava clickVoltarButton() {
        voltar.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the Oitava class instance.
     */
    public Oitava fill() {
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
    public Oitava setAgnciaNumberField() {
        return setAgnciaNumberField(data.get("AGNCIA"));
    }

    /**
     * Set value to Agncia Number field.
     *
     * @return the Oitava class instance.
     */
    public Oitava setAgnciaNumberField(String agnciaValue) {
        agncia.sendKeys(agnciaValue);
        return this;
    }

    /**
     * Set default value to Banco Search field.
     *
     * @return the Oitava class instance.
     */
    public Oitava setBancoSearchField() {
        return setBancoSearchField(data.get("BANCO"));
    }

    /**
     * Set value to Banco Search field.
     *
     * @return the Oitava class instance.
     */
    public Oitava setBancoSearchField(String bancoValue) {
        banco.sendKeys(bancoValue);
        return this;
    }

    /**
     * Set Conta Conjunta Checkbox field.
     *
     * @return the Oitava class instance.
     */
    public Oitava setContaConjuntaCheckboxField() {
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
    public Oitava setContaNumberField() {
        return setContaNumberField(data.get("CONTA"));
    }

    /**
     * Set value to Conta Number field.
     *
     * @return the Oitava class instance.
     */
    public Oitava setContaNumberField(String contaValue) {
        conta.sendKeys(contaValue);
        return this;
    }

    /**
     * Set default value to Dgito Text field.
     *
     * @return the Oitava class instance.
     */
    public Oitava setDgitoTextField() {
        return setDgitoTextField(data.get("DGITO"));
    }

    /**
     * Set value to Dgito Text field.
     *
     * @return the Oitava class instance.
     */
    public Oitava setDgitoTextField(String dgitoValue) {
        dgito.sendKeys(dgitoValue);
        return this;
    }

    /**
     * Set default value to Tipo De Conta Drop Down List field.
     *
     * @return the Oitava class instance.
     */
    public Oitava setTipoDeContaDropDownListField() {
        return setTipoDeContaDropDownListField(data.get("TIPO_DE_CONTA"));
    }

    /**
     * Set value to Tipo De Conta Drop Down List field.
     *
     * @return the Oitava class instance.
     */
    public Oitava setTipoDeContaDropDownListField(String tipoDeContaValue) {
        new Select(tipoDeConta).selectByVisibleText(tipoDeContaValue);
        return this;
    }

    /**
     * Unset Conta Conjunta Checkbox field.
     *
     * @return the Oitava class instance.
     */
    public Oitava unsetContaConjuntaCheckboxField() {
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
    public Oitava unsetTipoDeContaDropDownListField() {
        return unsetTipoDeContaDropDownListField(data.get("TIPO_DE_CONTA"));
    }

    /**
     * Unset value from Tipo De Conta Drop Down List field.
     *
     * @return the Oitava class instance.
     */
    public Oitava unsetTipoDeContaDropDownListField(String tipoDeContaValue) {
        new Select(tipoDeConta).deselectByVisibleText(tipoDeContaValue);
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the Oitava class instance.
     */
    public Oitava verifyPageLoaded() {
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
    public Oitava verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
