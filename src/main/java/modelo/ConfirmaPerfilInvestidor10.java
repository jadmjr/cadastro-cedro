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

public class ConfirmaPerfilInvestidor10 {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    private final String pageLoadedText = "Ele serve para identificarmos a sua tolerância em relação à exposição aos riscos, para que possamos oferecer produtos e serviços compatíveis ao seu perfil ou até mesmo alertá-lo em caso de desenquadramento";

    private final String pageUrl = "/cadastro/perfil-investidor";

    @FindBy(id = "redoSuitability")
    @CacheLookup
    private WebElement refazerOTeste;

    @FindBy(id = "next")
    @CacheLookup
    private WebElement seguir;

    @FindBy(css = "button.block-plan.mx-auto.d-flex.justify-content-center.align-items-center.my-2")
    @CacheLookup
    private WebElement standart;

    @FindBy(id = "previous")
    @CacheLookup
    private WebElement voltar;

    public ConfirmaPerfilInvestidor10() {
    }

    public ConfirmaPerfilInvestidor10(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public ConfirmaPerfilInvestidor10(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public ConfirmaPerfilInvestidor10(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Refazer O Teste Button.
     *
     * @return the Decima class instance.
     */
    public ConfirmaPerfilInvestidor10 clickRefazerOTesteButton() {
        refazerOTeste.click();
        return this;
    }

    /**
     * Click on Seguir Button.
     *
     * @return the Decima class instance.
     */
    public ConfirmaPerfilInvestidor10 clickSeguirButton() {
        seguir.click();
        return this;
    }

    /**
     * Click on Standart Button.
     *
     * @return the Decima class instance.
     */
    public ConfirmaPerfilInvestidor10 clickStandartButton() {
        standart.click();
        return this;
    }

    /**
     * Click on Voltar Button.
     *
     * @return the Decima class instance.
     */
    public ConfirmaPerfilInvestidor10 clickVoltarButton() {
        voltar.click();
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the Decima class instance.
     */
    public ConfirmaPerfilInvestidor10 verifyPageLoaded() {
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
     * @return the Decima class instance.
     */
    public ConfirmaPerfilInvestidor10 verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
