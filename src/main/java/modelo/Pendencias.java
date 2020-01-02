package modelo;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import controle.Selenium;

public class Pendencias extends Selenium {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;

	@FindAll({ @FindBy(id = "panel-upload") })
	@CacheLookup
	private List<WebElement> comprovantes;

	private final String pageLoadedText = "Apenas arquivos: PNG, JPG, JPEG, GIF e PDF";

	private final String pageUrl = "/cadastro/pendencias";

	@FindBy(id = "buttonNext")
	@CacheLookup
	private WebElement seguir;

	@FindBy(id = "buttonPrevious")
	@CacheLookup
	private WebElement voltar;

	public Pendencias() {
	}

	public Pendencias(WebDriver driver) {
		this();
		this.driver = driver;
	}

	public Pendencias(WebDriver driver, Map<String, String> data) {
		this(driver);
		this.data = data;
	}

	public Pendencias(WebDriver driver, Map<String, String> data, int timeout) {
		this(driver, data);
		this.timeout = timeout;
	}

	public Pendencias setComprovantes(Boolean gestorDeContas) {
		comprovantes.get(0).sendKeys(carregarArquivo("images.png"));
		esperar(1000);
		comprovantes.get(1).sendKeys(carregarArquivo("cnh1.jpg"));
		esperar(1000);
		if (gestorDeContas) {
			comprovantes.get(2).sendKeys(carregarArquivo("normas.jpeg"));
			esperar(1000);
			comprovantes.get(3).sendKeys(carregarArquivo("gestor.png"));
		}
		return this;
	}

	/**
	 * Click on Seguir Button.
	 *
	 * @return the Pendencias class instance.
	 */
	public Pendencias clickSeguirButton() {
		seguir.click();
		return this;
	}

	/**
	 * Click on Voltar Button.
	 *
	 * @return the Pendencias class instance.
	 */
	public Pendencias clickVoltarButton() {
		voltar.click();
		return this;
	}

	/**
	 * Fill every fields in the page.
	 *
	 * @return the Pendencias class instance.
	 */
	public Pendencias fill() {
		return this;
	}

	/**
	 * Set Comprovante De Endereo Arraste O Documento Aqui Ou Selecione Atravs Do
	 * Seu Dispositivo Apenas Arquivos Png Jpg Jpeg Gif E Pdf File field.
	 *
	 * @return the Pendencias class instance.
	 */
	public Pendencias setComprovanteDeEndereoArrasteODocumentoFileField() {
		return this;
	}

	/**
	 * Set Documento De Identificao Arraste O Documento Aqui Ou Selecione Atravs Do
	 * Seu Dispositivo Apenas Arquivos Png Jpg Jpeg Gif E Pdf File field.
	 *
	 * @return the Pendencias class instance.
	 */
	public Pendencias setDocumentoDeIdentificaoArrasteODocumentoFileField() {
		return this;
	}

	/**
	 * Set Normas E Declaraes Arraste O Documento Aqui Ou Selecione Atravs Do Seu
	 * Dispositivo Apenas Arquivos Png Jpg Jpeg Gif E Pdf File field.
	 *
	 * @return the Pendencias class instance.
	 */
	public Pendencias setNormasEDeclaraesArrasteODocumentoFileField() {
		return this;
	}

	/**
	 * Set Summary Arraste O Documento Aqui Ou Selecione Atravs Do Seu Dispositivo
	 * Apenas Arquivos Png Jpg Jpeg Gif E Pdf File field.
	 *
	 * @return the Pendencias class instance.
	 */
	public Pendencias setSummaryArrasteODocumentoAquiOuFileField() {
		return this;
	}

	/**
	 * Verify that the page loaded completely.
	 *
	 * @return the Pendencias class instance.
	 */
	public Pendencias verifyPageLoaded() {
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
	 * @return the Pendencias class instance.
	 */
	public Pendencias verifyPageUrl() {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getCurrentUrl().contains(pageUrl);
			}
		});
		return this;
	}
}
