package modelo;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sexta {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(name = "mat-radio-group-0")
    @CacheLookup
    private List<WebElement> no;

    private final String noValue = "on";

    private final String pageLoadedText = "Para sua identificação e segurança, essas informações são necessárias para a criação e validação do seu cadastro";

    private final String pageUrl = "/cadastro/informacoes-profissionais";

    @FindBy(id = "profession")
    @CacheLookup
    private WebElement qualASuaProfisso;

    @FindBy(id = "occupation_area")
    @CacheLookup
    private WebElement qualASuaReaDeOcupao;

    @FindBy(id = "buttonNext")
    @CacheLookup
    private WebElement seguir;

    @FindBy(name = "mat-radio-group-0")
    @CacheLookup
    private List<WebElement> sim;

    private final String simValue = "on";

    @FindBy(css = "button.block-plan.mx-auto.d-flex.justify-content-center.align-items-center.my-2.ng-star-inserted")
    @CacheLookup
    private WebElement standart;

    @FindBy(id = "buttonPrevious")
    @CacheLookup
    private WebElement voltar;

    public Sexta() {
    }

    public Sexta(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public Sexta(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public Sexta(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Seguir Button.
     *
     * @return the Sexta class instance.
     */
    public Sexta clickSeguirButton() {
        seguir.click();
        return this;
    }

    /**
     * Click on Standart Button.
     *
     * @return the Sexta class instance.
     */
    public Sexta clickStandartButton() {
        standart.click();
        return this;
    }

    /**
     * Click on Voltar Button.
     *
     * @return the Sexta class instance.
     */
    public Sexta clickVoltarButton() {
        voltar.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the Sexta class instance.
     */
    public Sexta fill() {
        setQualASuaReaDeOcupaoSearchField();
        setQualASuaProfissoDropDownListField();
        setSimRadioButtonField();
        setNoRadioButtonField();
        return this;
    }

    /**
     * Set default value to No Radio Button field.
     *
     * @return the Sexta class instance.
     */
    public Sexta setNoRadioButtonField() {
        for (WebElement el : no) {
            if (el.getAttribute("value").equals(noValue)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    /**
     * Set default value to Qual A Sua Profisso Drop Down List field.
     *
     * @return the Sexta class instance.
     */
    public Sexta setQualASuaProfissoDropDownListField() {
        return setQualASuaProfissoDropDownListField(data.get("QUAL_A_SUA_PROFISSO"));
    }

    /**
     * Set value to Qual A Sua Profisso Drop Down List field.
     *
     * @return the Sexta class instance.
     */
    public Sexta setQualASuaProfissoDropDownListField(String qualASuaProfissoValue) {
        new Select(qualASuaProfisso).selectByVisibleText(qualASuaProfissoValue);
        return this;
    }

    /**
     * Set default value to Qual A Sua Rea De Ocupao Search field.
     *
     * @return the Sexta class instance.
     */
    public Sexta setQualASuaReaDeOcupaoSearchField() {
        return setQualASuaReaDeOcupaoSearchField(data.get("QUAL_A_SUA_REA_DE_OCUPAO"));
    }

    /**
     * Set value to Qual A Sua Rea De Ocupao Search field.
     *
     * @return the Sexta class instance.
     */
    public Sexta setQualASuaReaDeOcupaoSearchField(String qualASuaReaDeOcupaoValue) {
        qualASuaReaDeOcupao.sendKeys(qualASuaReaDeOcupaoValue);
        return this;
    }

    /**
     * Set default value to Sim Radio Button field.
     *
     * @return the Sexta class instance.
     */
    public Sexta setSimRadioButtonField() {
        for (WebElement el : sim) {
            if (el.getAttribute("value").equals(simValue)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    /**
     * Unset default value from Qual A Sua Profisso Drop Down List field.
     *
     * @return the Sexta class instance.
     */
    public Sexta unsetQualASuaProfissoDropDownListField() {
        return unsetQualASuaProfissoDropDownListField(data.get("QUAL_A_SUA_PROFISSO"));
    }

    /**
     * Unset value from Qual A Sua Profisso Drop Down List field.
     *
     * @return the Sexta class instance.
     */
    public Sexta unsetQualASuaProfissoDropDownListField(String qualASuaProfissoValue) {
        new Select(qualASuaProfisso).deselectByVisibleText(qualASuaProfissoValue);
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the Sexta class instance.
     */
    public Sexta verifyPageLoaded() {
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
     * @return the Sexta class instance.
     */
    public Sexta verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
