package modelo;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ModalAprovacao {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 2;

	@FindBy( tagName = "textarea")
	@CacheLookup
	private WebElement observacao;

	@FindBy(id = "accept")
	@CacheLookup
	private WebElement botaoAprovar;
	
	@FindBy(className = "modal-class")
	@CacheLookup
	private WebElement modal;
	
	@FindBy(className = "icon-close-modal")
	@CacheLookup
	private WebElement btnFechar;
	
	
	

	public ModalAprovacao() {
	}

	public ModalAprovacao(WebDriver driver) {
		this();
		this.driver = driver;
	}

	public ModalAprovacao(WebDriver driver, Map<String, String> data) {
		this(driver);
		this.data = data;
	}

	public ModalAprovacao(WebDriver driver, Map<String, String> data, int timeout) {
		this(driver, data);
		this.timeout = timeout;
	}

	/**
	 * Click on Entrar Button.
	 *
	 * @return the CockpitLogin class instance.
	 */
	public ModalAprovacao preencherObservacao() {
		observacao.sendKeys("Tá okay");
		return this;
	}
	
	public WebElement getCampoObservacao() {
		return observacao;
	}

	public ModalAprovacao clicarEmAprovar() {
		botaoAprovar.click();		
		return this;
	}
	
	public ModalAprovacao fechaModal() {
		btnFechar.click();		
		return this;
	}

	
	/**
	 * Fill every fields in the page.
	 *
	 * @return the CockpitLogin class instance.
	 */
	public ModalAprovacao fill() {
		return this;
	}

}
