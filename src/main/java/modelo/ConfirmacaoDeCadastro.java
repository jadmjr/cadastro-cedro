package modelo;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ConfirmacaoDeCadastro {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;

	@FindBy(xpath = "//*[@id=\"registration-confirmation\"]/div/form/div[3]/div[2]/button")
	@CacheLookup
	private WebElement enviarToken;

	@FindBy(id = "buttonNext")
	@CacheLookup
	private WebElement seguir;

	@FindBy(id = "previous")
	@CacheLookup
	private WebElement voltar;

	public ConfirmacaoDeCadastro() {
	}

	public ConfirmacaoDeCadastro(WebDriver driver) {
		this();
		this.driver = driver;
	}

	public ConfirmacaoDeCadastro(WebDriver driver, Map<String, String> data) {
		this(driver);
		this.data = data;
	}

	public ConfirmacaoDeCadastro(WebDriver driver, Map<String, String> data, int timeout) {
		this(driver, data);
		this.timeout = timeout;
	}

	/**
	 * Click on Refazer O Teste Button.
	 *
	 * @return the Decima class instance.
	 */
	public ConfirmacaoDeCadastro enviarToken() {
		enviarToken.click();
		return this;
	}

	/**
	 * Click on Seguir Button.
	 *
	 * @return the Decima class instance.
	 */
	public ConfirmacaoDeCadastro clickSeguirButton() {
		seguir.click();
		return this;
	}

	/**
	 * Click on Voltar Button.
	 *
	 * @return the Decima class instance.
	 */
	public ConfirmacaoDeCadastro clickVoltarButton() {
		voltar.click();
		return this;
	}

}
