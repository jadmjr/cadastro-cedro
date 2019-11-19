package modelo;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Setima {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(id = "properties_value")
    @CacheLookup
    private WebElement bensImveis;

    @FindBy(id = "others_availability")
    @CacheLookup
    private WebElement outrosBensEValores;

    @FindBy(id = "others_mensal_income")
    @CacheLookup
    private WebElement outrosRendimentosMensais;

    private final String pageLoadedText = "* A corretora se reserva o direito de solicitar documentos adicionais para validação das informações acima, se necessário";

    private final String pageUrl = "/cadastro/informacoes-financeiras";

    @FindBy(id = "mensal_income")
    @CacheLookup
    private WebElement rendimentosMensais;

    @FindBy(id = "buttonNext")
    @CacheLookup
    private WebElement seguir;

    @FindBy(css = "button.block-plan.mx-auto.d-flex.justify-content-center.align-items-center.my-2.ng-star-inserted")
    @CacheLookup
    private WebElement standart;

    @FindBy(id = "buttonPrevious")
    @CacheLookup
    private WebElement voltar;

    public Setima() {
    }

    public Setima(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public Setima(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public Setima(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Seguir Button.
     *
     * @return the Setima class instance.
     */
    public Setima clickSeguirButton() {
        seguir.click();
        return this;
    }

    /**
     * Click on Standart Button.
     *
     * @return the Setima class instance.
     */
    public Setima clickStandartButton() {
        standart.click();
        return this;
    }

    /**
     * Click on Voltar Button.
     *
     * @return the Setima class instance.
     */
    public Setima clickVoltarButton() {
        voltar.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the Setima class instance.
     */
    public Setima fill() {
        setBensImveisTextField();
        setOutrosBensEValoresTextField();
        setRendimentosMensaisTextField();
        setOutrosRendimentosMensaisTextField();
        return this;
    }

    /**
     * Set default value to Bens Imveis Text field.
     *
     * @return the Setima class instance.
     */
    public Setima setBensImveisTextField() {
        return setBensImveisTextField(data.get("BENS_IMVEIS"));
    }

    /**
     * Set value to Bens Imveis Text field.
     *
     * @return the Setima class instance.
     */
    public Setima setBensImveisTextField(String bensImveisValue) {
        bensImveis.sendKeys(bensImveisValue);
        return this;
    }

    /**
     * Set default value to Outros Bens E Valores Text field.
     *
     * @return the Setima class instance.
     */
    public Setima setOutrosBensEValoresTextField() {
        return setOutrosBensEValoresTextField(data.get("OUTROS_BENS_E_VALORES"));
    }

    /**
     * Set value to Outros Bens E Valores Text field.
     *
     * @return the Setima class instance.
     */
    public Setima setOutrosBensEValoresTextField(String outrosBensEValoresValue) {
        outrosBensEValores.sendKeys(outrosBensEValoresValue);
        return this;
    }

    /**
     * Set default value to Outros Rendimentos Mensais Text field.
     *
     * @return the Setima class instance.
     */
    public Setima setOutrosRendimentosMensaisTextField() {
        return setOutrosRendimentosMensaisTextField(data.get("OUTROS_RENDIMENTOS_MENSAIS"));
    }

    /**
     * Set value to Outros Rendimentos Mensais Text field.
     *
     * @return the Setima class instance.
     */
    public Setima setOutrosRendimentosMensaisTextField(String outrosRendimentosMensaisValue) {
        outrosRendimentosMensais.sendKeys(outrosRendimentosMensaisValue);
        return this;
    }

    /**
     * Set default value to Rendimentos Mensais Text field.
     *
     * @return the Setima class instance.
     */
    public Setima setRendimentosMensaisTextField() {
        return setRendimentosMensaisTextField(data.get("RENDIMENTOS_MENSAIS"));
    }

    /**
     * Set value to Rendimentos Mensais Text field.
     *
     * @return the Setima class instance.
     */
    public Setima setRendimentosMensaisTextField(String rendimentosMensaisValue) {
        rendimentosMensais.sendKeys(rendimentosMensaisValue);
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the Setima class instance.
     */
    public Setima verifyPageLoaded() {
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
     * @return the Setima class instance.
     */
    public Setima verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
