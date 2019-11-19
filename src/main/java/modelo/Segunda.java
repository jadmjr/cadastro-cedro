package modelo;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Segunda {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	

	private final String pageLoadedText = "*O valor mensal é revertido como crédito de corretagem, não sendo cumulativo nos meses seguintes";

	private final String pageUrl = "/cadastro/selecionar-planos";

	@FindBy(id = "buttonNext")
	@CacheLookup
	private WebElement seguir;

	@FindBy(id = "buttonPrevious")
	@CacheLookup
	private WebElement voltar;

	@FindBy(xpath = "//*[@id=\"plan.name\"]/div/div[3]")
	@CacheLookup
	private WebElement planoStandart;

	public Segunda() {
	}

	public Segunda(WebDriver driver) {
		this();		
		this.driver = driver;
		
	}

	public Segunda(WebDriver driver, Map<String, String> data) {
		this(driver);
		this.data = data;
	}

	public Segunda(WebDriver driver, Map<String, String> data, int timeout) {
		this(driver, data);
		this.timeout = timeout;
	}

	/**
	 * Click on Seguir Button.
	 *
	 * @return the Segunda class instance.
	 */
	public Segunda clickSeguirButton() {
		seguir.click();
		return this;
	}

	/**
	 * Click on Voltar Button.
	 *
	 * @return the Segunda class instance.
	 */
	public Segunda clickVoltarButton() {
		voltar.click();
		return this;
	}

	public Segunda clickPLanoStandart() {
		planoStandart.click();
		return this;
	}

	/**
	 * Verify that the page loaded completely.
	 *
	 * @return the Segunda class instance.
	 */
	public Segunda verifyPageLoaded() {
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
	 * @return the Segunda class instance.
	 */
	public Segunda verifyPageUrl() {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getCurrentUrl().contains(pageUrl);
			}
		});
		return this;
	}
}
