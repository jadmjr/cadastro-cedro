package modelo;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import controle.Funcoes;

public class PerfilInvestidor9 extends Funcoes {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;

	@FindAll({ @FindBy(tagName = "mat-radio-group") })
	@CacheLookup
	private List<WebElement> botoes;

	@FindBy(id = "buttonNext")
	@CacheLookup
	private WebElement botaoSeguir;

	public PerfilInvestidor9() {
	}

	public PerfilInvestidor9(WebDriver driver) {
		this();
		this.driver = driver;
	}

	public PerfilInvestidor9(WebDriver driver, Map<String, String> data) {
		this(driver);
		this.data = data;
	}

	public PerfilInvestidor9(WebDriver driver, Map<String, String> data, int timeout) {
		this(driver, data);
		this.timeout = timeout;
	}

	public PerfilInvestidor9 preencherPerfilModerado() {

		for (WebElement botao : botoes) {
			botao.findElements(By.tagName("mat-radio-button")).get(0).click();
			esperar(500);
		}
		return this;
	}

	public PerfilInvestidor9 clicarBotaoSeguir() {
		botaoSeguir.click();
		return this;
	}

}
