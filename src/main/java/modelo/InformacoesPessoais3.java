package modelo;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import controle.Selenium;

public class InformacoesPessoais3 extends Selenium {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(id = "city")
    @CacheLookup
    private WebElement cidadeDeNascimento;

    @FindBy(id = "representative_cpf")
    @CacheLookup
    private WebElement cpfDoResponsvelLegal;

    @FindBy(id = "birth_date")
    @CacheLookup
    private WebElement dataDeNascimento;

    @FindBy(id = "representative_email")
    @CacheLookup
    private WebElement emailDoResponsvelLegal;
    
    @FindBy(id = "second_email")
    @CacheLookup
    private WebElement emailSecundrio;

    @FindBy(id = "marital_status")
    @CacheLookup
    private WebElement estadoCivil;

    @FindBy(id = "state")
    @CacheLookup
    private WebElement estadoDeNascimento;

    @FindBy(id = "female")
    @CacheLookup
    private WebElement feminino;

    @FindBy(id = "male")
    @CacheLookup
    private WebElement masculino;

    @FindBy(id = "emancipated-no")
    @CacheLookup
    private WebElement no;

    @FindBy(id = "mother_name")
    @CacheLookup
    private WebElement nomeCompletoDaMe;

    @FindBy(id = "father_name")
    @CacheLookup
    private WebElement nomeCompletoDoPai;

    @FindBy(id = "representative_name")
    @CacheLookup
    private WebElement nomeDoResponsvelLegal;

    private final String pageLoadedText = "Upload do documento de Identificação com CPF do Representante Legal";

    private final String pageUrl = "/cadastro/informacoes-pessoais";

    @FindBy(id = "country")
    @CacheLookup
    private WebElement pasDeNascimento;

    @FindBy(id = "representative_id")
    @CacheLookup
    private WebElement responsvelLegal;

    @FindBy(id = "representative_rg")
    @CacheLookup
    private WebElement rgDoResponsvelLegal;

    @FindBy(id = "buttonNext")
    @CacheLookup
    private WebElement seguir;

    @FindBy(id = "emancipated-yes")
    @CacheLookup
    private WebElement sim;

    @FindBy(id = "home_phone")
    @CacheLookup
    private WebElement telefoneFixo;

    @FindBy(id = "panel-upload")
    @CacheLookup
    private WebElement uploadDoDocumentoDeIdentificaoCom;

    @FindBy(id = "buttonPrevious")
    @CacheLookup
    private WebElement voltar;

    public InformacoesPessoais3() {
    }

    public InformacoesPessoais3(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public InformacoesPessoais3(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public InformacoesPessoais3(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Feminino Button.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 clickFemininoButton() {
        feminino.click();
        return this;
    }

    /**
     * Click on Masculino Button.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 clickMasculinoButton() {
        masculino.click();
        return this;
    }

    /**
     * Click on No Button.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 clickNoButton() {
        no.click();
        return this;
    }

    /**
     * Click on Seguir Button.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 clickSeguirButton() {
        seguir.click();
        return this;
    }

    /**
     * Click on Sim Button.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 clickSimButton() {
        sim.click();
        return this;
    }

    /**
     * Click on Voltar Button.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 clickVoltarButton() {
        voltar.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 fill() {
        setDataDeNascimentoTextField();
        setResponsvelLegalDropDownListField();
        setNomeDoResponsvelLegalTextField();
        setCpfDoResponsvelLegalTextField();
        setRgDoResponsvelLegalTextField();
        setEmailDoResponsvelLegalEmailField();
        setEmailSecundrioTextField();
        setTelefoneFixoTextField();
        setPasDeNascimentoSearchField();
        setEstadoDeNascimentoSearchField();
        setCidadeDeNascimentoSearchField();
        setNomeCompletoDaMeTextField();
        setNomeCompletoDoPaiTextField();
        setEstadoCivilDropDownListField();
        return this;
    }

    /**
     * Set default value to Cidade De Nascimento Search field.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 setCidadeDeNascimentoSearchField() {
        return setCidadeDeNascimentoSearchField(data.get("CIDADE_DE_NASCIMENTO"));
    }

    /**
     * Set value to Cidade De Nascimento Search field.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 setCidadeDeNascimentoSearchField(String cidadeDeNascimentoValue) {
    	selecionarPrimeiraOpcao(cidadeDeNascimento, cidadeDeNascimentoValue);
        return this;
    }

    /**
     * Set default value to Cpf Do Responsvel Legal Text field.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 setCpfDoResponsvelLegalTextField() {
        return setCpfDoResponsvelLegalTextField(data.get("CPF_DO_RESPONSVEL_LEGAL"));
    }

    /**
     * Set value to Cpf Do Responsvel Legal Text field.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 setCpfDoResponsvelLegalTextField(String cpfDoResponsvelLegalValue) {
        cpfDoResponsvelLegal.sendKeys(cpfDoResponsvelLegalValue);
        return this;
    }

    /**
     * Set default value to Data De Nascimento Text field.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 setDataDeNascimentoTextField() {
        return setDataDeNascimentoTextField(data.get("DATA_DE_NASCIMENTO"));
    }

    /**
     * Set value to Data De Nascimento Text field.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 setDataDeNascimentoTextField(String dataDeNascimentoValue) {
        dataDeNascimento.sendKeys(dataDeNascimentoValue);
        return this;
    }

    /**
     * Set default value to Email Do Responsvel Legal Email field.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 setEmailDoResponsvelLegalEmailField() {
        return setEmailDoResponsvelLegalEmailField(data.get("EMAIL_DO_RESPONSVEL_LEGAL"));
    }

    /**
     * Set value to Email Do Responsvel Legal Email field.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 setEmailDoResponsvelLegalEmailField(String emailDoResponsvelLegalValue) {
        emailDoResponsvelLegal.sendKeys(emailDoResponsvelLegalValue);
        return this;
    }

    /**
     * Set default value to Email Secundrio Text field.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 setEmailSecundrioTextField() {
        return setEmailSecundrioTextField(data.get("EMAIL_SECUNDRIO"));
    }

    /**
     * Set value to Email Secundrio Text field.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 setEmailSecundrioTextField(String emailSecundrioValue) {
        emailSecundrio.sendKeys(emailSecundrioValue);
        return this;
    }

    /**
     * Set default value to Estado Civil Drop Down List field.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 setEstadoCivilDropDownListField() {
        return setEstadoCivilDropDownListField(data.get("ESTADO_CIVIL"));
    }

    /**
     * Set value to Estado Civil Drop Down List field.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 setEstadoCivilDropDownListField(String estadoCivilValue) {
        new Select(estadoCivil).selectByVisibleText(estadoCivilValue);
        return this;
    }

    /**
     * Set default value to Estado De Nascimento Search field.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 setEstadoDeNascimentoSearchField() {
        return setEstadoDeNascimentoSearchField(data.get("ESTADO_DE_NASCIMENTO"));
    }

    /**
     * Set value to Estado De Nascimento Search field.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 setEstadoDeNascimentoSearchField(String estadoDeNascimentoValue) {
    	selecionarPrimeiraOpcao(estadoDeNascimento, estadoDeNascimentoValue);
        return this;
    }

    /**
     * Set default value to Nome Completo Da Me Text field.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 setNomeCompletoDaMeTextField() {
        return setNomeCompletoDaMeTextField(data.get("NOME_COMPLETO_DA_ME"));
    }

    /**
     * Set value to Nome Completo Da Me Text field.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 setNomeCompletoDaMeTextField(String nomeCompletoDaMeValue) {
        nomeCompletoDaMe.sendKeys(nomeCompletoDaMeValue);
        return this;
    }

    /**
     * Set default value to Nome Completo Do Pai Text field.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 setNomeCompletoDoPaiTextField() {
        return setNomeCompletoDoPaiTextField(data.get("NOME_COMPLETO_DO_PAI"));
    }

    /**
     * Set value to Nome Completo Do Pai Text field.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 setNomeCompletoDoPaiTextField(String nomeCompletoDoPaiValue) {
        nomeCompletoDoPai.sendKeys(nomeCompletoDoPaiValue);
        return this;
    }

    /**
     * Set default value to Nome Do Responsvel Legal Text field.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 setNomeDoResponsvelLegalTextField() {
        return setNomeDoResponsvelLegalTextField(data.get("NOME_DO_RESPONSVEL_LEGAL"));
    }

    /**
     * Set value to Nome Do Responsvel Legal Text field.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 setNomeDoResponsvelLegalTextField(String nomeDoResponsvelLegalValue) {
        nomeDoResponsvelLegal.sendKeys(nomeDoResponsvelLegalValue);
        return this;
    }

    /**
     * Set default value to Pas De Nascimento Search field.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 setPasDeNascimentoSearchField() {
        return setPasDeNascimentoSearchField(data.get("PAS_DE_NASCIMENTO"));
    }

    /**
     * Set value to Pas De Nascimento Search field.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 setPasDeNascimentoSearchField(String pasDeNascimentoValue) {
    	selecionarPrimeiraOpcao(pasDeNascimento, pasDeNascimentoValue);
        return this;
    }

    /**
     * Set default value to Responsvel Legal Drop Down List field.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 setResponsvelLegalDropDownListField() {
        return setResponsvelLegalDropDownListField(data.get("RESPONSVEL_LEGAL"));
    }

    /**
     * Set value to Responsvel Legal Drop Down List field.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 setResponsvelLegalDropDownListField(String responsvelLegalValue) {
        new Select(responsvelLegal).selectByVisibleText(responsvelLegalValue);
        return this;
    }

    /**
     * Set default value to Rg Do Responsvel Legal Text field.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 setRgDoResponsvelLegalTextField() {
        return setRgDoResponsvelLegalTextField(data.get("RG_DO_RESPONSVEL_LEGAL"));
    }

    /**
     * Set value to Rg Do Responsvel Legal Text field.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 setRgDoResponsvelLegalTextField(String rgDoResponsvelLegalValue) {
        rgDoResponsvelLegal.sendKeys(rgDoResponsvelLegalValue);
        return this;
    }

    /**
     * Set default value to Telefone Fixo Text field.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 setTelefoneFixoTextField() {
        return setTelefoneFixoTextField(data.get("TELEFONE_FIXO"));
    }

    /**
     * Set value to Telefone Fixo Text field.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 setTelefoneFixoTextField(String telefoneFixoValue) {
        telefoneFixo.sendKeys(telefoneFixoValue);
        return this;
    }

    /**
     * Set Upload Do Documento De Identificao Com Cpf Do Representante Legal Arraste O Documento Aqui Ou Selecione Atravs Do Seu Dispositivo Apenas Arquivos Png Jpg Jpeg Gif E Pdf File field.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 setUploadDoDocumentoDeIdentificaoComFileField(String path) {
    	uploadDoDocumentoDeIdentificaoCom.sendKeys(path);
        return this;
    }

    /**
     * Unset default value from Estado Civil Drop Down List field.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 unsetEstadoCivilDropDownListField() {
        return unsetEstadoCivilDropDownListField(data.get("ESTADO_CIVIL"));
    }

    /**
     * Unset value from Estado Civil Drop Down List field.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 unsetEstadoCivilDropDownListField(String estadoCivilValue) {
        new Select(estadoCivil).deselectByVisibleText(estadoCivilValue);
        return this;
    }

    /**
     * Unset default value from Responsvel Legal Drop Down List field.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 unsetResponsvelLegalDropDownListField() {
        return unsetResponsvelLegalDropDownListField(data.get("RESPONSVEL_LEGAL"));
    }

    /**
     * Unset value from Responsvel Legal Drop Down List field.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 unsetResponsvelLegalDropDownListField(String responsvelLegalValue) {
        new Select(responsvelLegal).deselectByVisibleText(responsvelLegalValue);
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 verifyPageLoaded() {
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
     * @return the Temp class instance.
     */
    public InformacoesPessoais3 verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
