package modelo;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnderecoCorrespondecia13 {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(className =  "mat-checkbox-inner-container")
    @CacheLookup
    private WebElement noDesejoReceberCorrespondncias;

    private final String pageLoadedText = "Em complemento aos dados cadastrais, essas declarações são necessárias e exigidas por lei";

    private final String pageUrl = "/cadastro/endereco-correspondencia";

    @FindBy(id = "buttonNext")
    @CacheLookup
    private WebElement seguir;

    @FindBy(css = "button.block-plan.mx-auto.d-flex.justify-content-center.align-items-center.my-2")
    @CacheLookup
    private WebElement standart;

    @FindBy(id = "buttonPrevious")
    @CacheLookup
    private WebElement voltar;

    public EnderecoCorrespondecia13() {
    }

    public EnderecoCorrespondecia13(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public EnderecoCorrespondecia13(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public EnderecoCorrespondecia13(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Seguir Button.
     *
     * @return the EnderecoCorrespondecia class instance.
     */
    public EnderecoCorrespondecia13 clickSeguirButton() {
        seguir.click();
        return this;
    }

    /**
     * Click on Standart Button.
     *
     * @return the EnderecoCorrespondecia class instance.
     */
    public EnderecoCorrespondecia13 clickStandartButton() {
        standart.click();
        return this;
    }

    /**
     * Click on Voltar Button.
     *
     * @return the EnderecoCorrespondecia class instance.
     */
    public EnderecoCorrespondecia13 clickVoltarButton() {
        voltar.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the EnderecoCorrespondecia class instance.
     */
    public EnderecoCorrespondecia13 fill() {
        setNoDesejoReceberCorrespondnciasCheckboxField();
        return this;
    }

    /**
     * Set No Desejo Receber Correspondncias Checkbox field.
     *
     * @return the EnderecoCorrespondecia class instance.
     */
    public WebElement getInputNoReceberCorrespondecia() {
    	return noDesejoReceberCorrespondncias;
    }
    public EnderecoCorrespondecia13 setNoDesejoReceberCorrespondnciasCheckboxField() {
        if (!noDesejoReceberCorrespondncias.isSelected()) {
            noDesejoReceberCorrespondncias.click();
        }
        return this;
    }

    /**
     * Unset No Desejo Receber Correspondncias Checkbox field.
     *
     * @return the EnderecoCorrespondecia class instance.
     */
    public EnderecoCorrespondecia13 unsetNoDesejoReceberCorrespondnciasCheckboxField() {
        if (noDesejoReceberCorrespondncias.isSelected()) {
            noDesejoReceberCorrespondncias.click();
        }
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the EnderecoCorrespondecia class instance.
     */
    public EnderecoCorrespondecia13 verifyPageLoaded() {
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
     * @return the EnderecoCorrespondecia class instance.
     */
    public EnderecoCorrespondecia13 verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
