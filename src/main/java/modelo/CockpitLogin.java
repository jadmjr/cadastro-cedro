package modelo;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CockpitLogin {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(css = "button.btn-primary.btn-md.mat-flat-button.ng-star-inserted")
    @CacheLookup
    private WebElement entrar;

    private final String pageLoadedText = "";

    private final String pageUrl = "/cockpit/login";

    @FindBy(id = "mat-input-1")
    @CacheLookup
    private WebElement senha;

    @FindBy(id = "username")
    @CacheLookup
    private WebElement usurio;

    public CockpitLogin() {
    }

    public CockpitLogin(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public CockpitLogin(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public CockpitLogin(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Entrar Button.
     *
     * @return the CockpitLogin class instance.
     */
    public CockpitLogin clickEntrarButton() {
        entrar.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the CockpitLogin class instance.
     */
    public CockpitLogin fill() {
        setUsurioTextField();
        setSenhaPasswordField();
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the CockpitLogin class instance.
     */
    public CockpitLogin fillAndSubmit() {
        fill();
        return submit();
    }

    /**
     * Set default value to Senha Password field.
     *
     * @return the CockpitLogin class instance.
     */
    public CockpitLogin setSenhaPasswordField() {
        return setSenhaPasswordField(data.get("SENHA"));
    }

    /**
     * Set value to Senha Password field.
     *
     * @return the CockpitLogin class instance.
     */
    public CockpitLogin setSenhaPasswordField(String senhaValue) {
        senha.sendKeys(senhaValue);
        return this;
    }

    /**
     * Set default value to Usurio Text field.
     *
     * @return the CockpitLogin class instance.
     */
    public CockpitLogin setUsurioTextField() {
        return setUsurioTextField(data.get("USURIO"));
    }

    /**
     * Set value to Usurio Text field.
     *
     * @return the CockpitLogin class instance.
     */
    public CockpitLogin setUsurioTextField(String usurioValue) {
        usurio.sendKeys(usurioValue);
        return this;
    }

    /**
     * Submit the form to target page.
     *
     * @return the CockpitLogin class instance.
     */
    public CockpitLogin submit() {
        clickEntrarButton();
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the CockpitLogin class instance.
     */
    public CockpitLogin verifyPageLoaded() {
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
     * @return the CockpitLogin class instance.
     */
    public CockpitLogin verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
