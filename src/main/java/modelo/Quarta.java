package modelo;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Quarta {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(id = "driver")
    @CacheLookup
    private WebElement cnh;

    @FindBy(id = "issuing_date")
    @CacheLookup
    private WebElement dataDeEmisso;

    @FindBy(id = "issuing_state")
    @CacheLookup
    private WebElement estadoEmissor;

    @FindBy(id = "functional_identification")
    @CacheLookup
    private WebElement identificaoFuncional;

    @FindBy(id = "document_number")
    @CacheLookup
    private WebElement nmeroDoRg;

    private final String pageLoadedText = "Para sua identificação e segurança, essas informações são necessárias para a criação e validação do seu cadastro";

    private final String pageUrl = "/cadastro/documento-identificacao";

    @FindBy(id = "register")
    @CacheLookup
    private WebElement rg;

    @FindBy(id = "issuing_agency")
    @CacheLookup
    private WebElement rgoEmissor;

    @FindBy(id = "buttonNext")
    @CacheLookup
    private WebElement seguir;

    @FindBy(css = "button.block-plan.mx-auto.d-flex.justify-content-center.align-items-center.my-2.ng-star-inserted")
    @CacheLookup
    private WebElement standart;

    @FindBy(id = "buttonPrevious")
    @CacheLookup
    private WebElement voltar;

    public Quarta() {
    }

    public Quarta(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public Quarta(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public Quarta(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Cnh Button.
     *
     * @return the Quarta class instance.
     */
    public Quarta clickCnhButton() {
        cnh.click();
        return this;
    }

    /**
     * Click on Identificao Funcional Button.
     *
     * @return the Quarta class instance.
     */
    public Quarta clickIdentificaoFuncionalButton() {
        identificaoFuncional.click();
        return this;
    }

    /**
     * Click on Rg Button.
     *
     * @return the Quarta class instance.
     */
    public Quarta clickRgButton() {
        rg.click();
        return this;
    }

    /**
     * Click on Seguir Button.
     *
     * @return the Quarta class instance.
     */
    public Quarta clickSeguirButton() {
        seguir.click();
        return this;
    }

    /**
     * Click on Standart Button.
     *
     * @return the Quarta class instance.
     */
    public Quarta clickStandartButton() {
        standart.click();
        return this;
    }

    /**
     * Click on Voltar Button.
     *
     * @return the Quarta class instance.
     */
    public Quarta clickVoltarButton() {
        voltar.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the Quarta class instance.
     */
    public Quarta fill() {
        setNmeroDoRgTextField();
        setEstadoEmissorSearchField();
        setRgoEmissorDropDownListField();
        setDataDeEmissoTextField();
        return this;
    }

    /**
     * Set default value to Data De Emisso Text field.
     *
     * @return the Quarta class instance.
     */
    public Quarta setDataDeEmissoTextField() {
        return setDataDeEmissoTextField(data.get("DATA_DE_EMISSO"));
    }

    /**
     * Set value to Data De Emisso Text field.
     *
     * @return the Quarta class instance.
     */
    public Quarta setDataDeEmissoTextField(String dataDeEmissoValue) {
        dataDeEmisso.sendKeys(dataDeEmissoValue);
        return this;
    }

    /**
     * Set default value to Estado Emissor Search field.
     *
     * @return the Quarta class instance.
     */
    public Quarta setEstadoEmissorSearchField() {
        return setEstadoEmissorSearchField(data.get("ESTADO_EMISSOR"));
    }

    /**
     * Set value to Estado Emissor Search field.
     *
     * @return the Quarta class instance.
     */
    public Quarta setEstadoEmissorSearchField(String estadoEmissorValue) {
        estadoEmissor.sendKeys(estadoEmissorValue);
        return this;
    }

    /**
     * Set default value to Nmero Do Rg Text field.
     *
     * @return the Quarta class instance.
     */
    public Quarta setNmeroDoRgTextField() {
        return setNmeroDoRgTextField(data.get("NMERO_DO_RG"));
    }

    /**
     * Set value to Nmero Do Rg Text field.
     *
     * @return the Quarta class instance.
     */
    public Quarta setNmeroDoRgTextField(String nmeroDoRgValue) {
        nmeroDoRg.sendKeys(nmeroDoRgValue);
        return this;
    }

    /**
     * Set default value to Rgo Emissor Drop Down List field.
     *
     * @return the Quarta class instance.
     */
    public Quarta setRgoEmissorDropDownListField() {
        return setRgoEmissorDropDownListField(data.get("RGO_EMISSOR"));
    }

    /**
     * Set value to Rgo Emissor Drop Down List field.
     *
     * @return the Quarta class instance.
     */
    public Quarta setRgoEmissorDropDownListField(String rgoEmissorValue) {
        new Select(rgoEmissor).selectByVisibleText(rgoEmissorValue);
        return this;
    }

    /**
     * Unset default value from Rgo Emissor Drop Down List field.
     *
     * @return the Quarta class instance.
     */
    public Quarta unsetRgoEmissorDropDownListField() {
        return unsetRgoEmissorDropDownListField(data.get("RGO_EMISSOR"));
    }

    /**
     * Unset value from Rgo Emissor Drop Down List field.
     *
     * @return the Quarta class instance.
     */
    public Quarta unsetRgoEmissorDropDownListField(String rgoEmissorValue) {
        new Select(rgoEmissor).deselectByVisibleText(rgoEmissorValue);
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the Quarta class instance.
     */
    public Quarta verifyPageLoaded() {
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
     * @return the Quarta class instance.
     */
    public Quarta verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
