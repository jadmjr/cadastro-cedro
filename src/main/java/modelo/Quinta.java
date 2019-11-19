package modelo;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Quinta {
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

    public Quinta() {
    }

    public Quinta(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public Quinta(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public Quinta(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on No Sei Meu Cep Link.
     *
     * @return the Quinta class instance.
     */
    public Quinta clickNoSeiMeuCepLink() {
        noSeiMeuCep.click();
        return this;
    }

    /**
     * Click on Seguir Button.
     *
     * @return the Quinta class instance.
     */
    public Quinta clickSeguirButton() {
        seguir.click();
        return this;
    }

    /**
     * Click on Standart Button.
     *
     * @return the Quinta class instance.
     */
    public Quinta clickStandartButton() {
        standart.click();
        return this;
    }

    /**
     * Click on Voltar Button.
     *
     * @return the Quinta class instance.
     */
    public Quinta clickVoltarButton() {
        voltar.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the Quinta class instance.
     */
    public Quinta fill() {
        setCepTextField();
        return this;
    }

    /**
     * Set default value to Cep Text field.
     *
     * @return the Quinta class instance.
     */
    public Quinta setCepTextField() {
        return setCepTextField(data.get("CEP"));
    }

    /**
     * Set value to Cep Text field.
     *
     * @return the Quinta class instance.
     */
    public Quinta setCepTextField(String cepValue) {
        cep.sendKeys(cepValue);
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the Quinta class instance.
     */
    public Quinta verifyPageLoaded() {
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
    public Quinta verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
