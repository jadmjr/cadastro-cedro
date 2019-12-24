package modelo;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import controle.Selenium;

public class CondicoesGerais extends Selenium {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;

	private final String pageUrl = "/cadastro/termoss";

	@FindBy(id = "next")
	@CacheLookup
	private WebElement seguir;

	@FindBy(id = "previous")
	@CacheLookup
	private WebElement voltar;

	@FindBy(id = "termsAcception")
	@CacheLookup
	private WebElement aceitar;

	public CondicoesGerais() {
	}

	public CondicoesGerais(WebDriver driver) {
		this();
		this.driver = driver;
	}

	public CondicoesGerais(WebDriver driver, Map<String, String> data) {
		this(driver);
		this.data = data;
	}

	public CondicoesGerais(WebDriver driver, Map<String, String> data, int timeout) {
		this(driver, data);
		this.timeout = timeout;
	}

	/**
	 * Click on Seguir Button.
	 *
	 * @return the Decima class instance.
	 */
	public WebElement getBotaoSeguir() {
		return seguir;
	}

	public CondicoesGerais clickSeguirButton() {
		seguir.click();
		return this;
	}

	/**
	 * Click on Voltar Button.
	 *
	 * @return the Decima class instance.
	 */
	public CondicoesGerais clickVoltarButton() {
		voltar.click();
		return this;
	}

	/**
	 * Verify that the page loaded completely.
	 *
	 * @return the Decima class instance.
	 */

	/**
	 * Verify that current page URL matches the expected URL.
	 *
	 * @return the Decima class instance.
	 */
	public CondicoesGerais verifyPageUrl() {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getCurrentUrl().contains(pageUrl);
			}
		});
		return this;
	}

	public WebElement getBotoes() {
		return aceitar;
	}

	public CondicoesGerais aceitar() {
		aceitar.click();
		return this;
	}

}
