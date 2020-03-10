package modelo;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ModalAprovacao {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;

	@FindBy( tagName = "textarea")
	@CacheLookup
	private WebElement observacao;

	@FindBy(name = "accept")
	@CacheLookup
	private WebElement botaoAprovar;
	
	@FindBy(className = "modal-class")
	@CacheLookup
	private WebElement modal;
	
	

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
		observacao.sendKeys("teste");
		return this;
	}

	public ModalAprovacao clicarEmAprovar() {
		botaoAprovar.click();
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
