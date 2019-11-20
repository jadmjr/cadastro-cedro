package modelo;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelecaoDePlanos2 {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;

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

	public SelecaoDePlanos2() {
	}

	public SelecaoDePlanos2(WebDriver driver) {
		this();		
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"plan.name\"]/div/div[3]")));
	}

	public SelecaoDePlanos2(WebDriver driver, Map<String, String> data) {
		this(driver);
		this.data = data;
	}

	public SelecaoDePlanos2(WebDriver driver, Map<String, String> data, int timeout) {
		this(driver, data);
		this.timeout = timeout;
	}

	/**
	 * Click on Seguir Button.
	 *
	 * @return the Segunda class instance.
	 */
	public SelecaoDePlanos2 clickSeguirButton() {
		seguir.click();
		return this;
	}

	/**
	 * Click on Voltar Button.
	 *
	 * @return the Segunda class instance.
	 */
	public SelecaoDePlanos2 clickVoltarButton() {
		voltar.click();
		return this;
	}

	public SelecaoDePlanos2 clickPLanoStandart() {
		planoStandart.click();
		return this;
	}

	/**
	 * Verify that the page loaded completely.
	 *
	 * @return the Segunda class instance.
	 */
	public SelecaoDePlanos2 verifyPageLoaded() {
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
	public SelecaoDePlanos2 verifyPageUrl() {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getCurrentUrl().contains(pageUrl);
			}
		});
		return this;
	}
}
