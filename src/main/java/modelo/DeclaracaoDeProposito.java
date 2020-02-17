package modelo;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class DeclaracaoDeProposito {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;

	@FindBy(id = "next")
	@CacheLookup
	private WebElement seguir;

	@FindBy(id = "previous")
	@CacheLookup
	private WebElement voltar;

	@FindAll({ @FindBy(className = "mat-checkbox-inner-container") })
	@CacheLookup
	private List<WebElement> checkboxs;
	
	@FindBy(xpath = "//*[@id=\"declarations\"]/form/div/div/div/div[2]/div[6]/div/input")
	@CacheLookup
	private WebElement indicacao;

	public DeclaracaoDeProposito() {
	}

	public DeclaracaoDeProposito(WebDriver driver) {
		this();
		this.driver = driver;
	}

	public DeclaracaoDeProposito(WebDriver driver, Map<String, String> data) {
		this(driver);
		this.data = data;
	}

	public DeclaracaoDeProposito(WebDriver driver, Map<String, String> data, int timeout) {
		this(driver, data);
		this.timeout = timeout;
	}

	/**
	 * Click on Seguir Button.
	 *
	 * @return the Decima class instance.
	 */
	public DeclaracaoDeProposito clickSeguirButton() {
		seguir.click();
		return this;
	}

	/**
	 * Click on Voltar Button.
	 *
	 * @return the Decima class instance.
	 */
	public DeclaracaoDeProposito clickVoltarButton() {
		voltar.click();
		return this;
	}

	public DeclaracaoDeProposito marcarCheckBox() {
		for (WebElement checkbox : checkboxs) {
			checkbox.click();
		}
		return this;
	}

	public DeclaracaoDeProposito preecherIndicacao(String texto) {
		indicacao.sendKeys(texto);
		return this;
	}

}
