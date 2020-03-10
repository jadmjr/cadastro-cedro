package modelo;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
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

    public Login() {
    }

    public Login(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public Login(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public Login(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Entrar Button.
     *
     * @return the CockpitLogin class instance.
     */
    public Login clickEntrarButton() {
        entrar.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the CockpitLogin class instance.
     */
    public Login fill() {
        setUsurioTextField();
        setSenhaPasswordField();
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the CockpitLogin class instance.
     */
    public Login fillAndSubmit() {
        fill();
        return submit();
    }

    /**
     * Set default value to Senha Password field.
     *
     * @return the CockpitLogin class instance.
     */
    public Login setSenhaPasswordField() {
        return setSenhaPasswordField(data.get("SENHA"));
    }

    /**
     * Set value to Senha Password field.
     *
     * @return the CockpitLogin class instance.
     */
    public Login setSenhaPasswordField(String senhaValue) {
        senha.sendKeys(senhaValue);
        return this;
    }

    /**
     * Set default value to Usurio Text field.
     *
     * @return the CockpitLogin class instance.
     */
    public Login setUsurioTextField() {
        return setUsurioTextField(data.get("USURIO"));
    }

    /**
     * Set value to Usurio Text field.
     *
     * @return the CockpitLogin class instance.
     */
    public Login setUsurioTextField(String usurioValue) {
        usurio.sendKeys(usurioValue);
        return this;
    }

    /**
     * Submit the form to target page.
     *
     * @return the CockpitLogin class instance.
     */
    public Login submit() {
        clickEntrarButton();
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the CockpitLogin class instance.
     */
    public Login verifyPageLoaded() {
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
    public Login verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
