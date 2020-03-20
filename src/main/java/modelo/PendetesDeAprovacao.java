package modelo;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import controle.Selenium;

public class PendetesDeAprovacao extends Selenium {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;

	@FindBy(name = "termSearch")
	@CacheLookup
	private WebElement campoPesquisa;

	@FindAll({ @FindBy(className = "red-block"), @FindBy(className = "yellow-block") })
	@CacheLookup
	private List<WebElement> pendetesDeAprovacao;

	public PendetesDeAprovacao() {
	}

	public void aprovarPendencias() {
		
		WebDriverWait wait = new WebDriverWait(this.driver, 2);
		
		for (WebElement pendente : pendetesDeAprovacao) {
			ModalAprovacao modal = new ModalAprovacao();
			PageFactory.initElements(this.driver, modal);
			try {
				pendente.click();	
				wait.until(ExpectedConditions.visibilityOf(modal.getCampoObservacao()));
				modal.preencherObservacao();
				modal.clicarEmAprovar();
				esperar(200);
			} catch (Exception e) {
				modal.fechaModal();
			}

		}
	}

	public PendetesDeAprovacao(WebDriver driver) {
		this();
		this.driver = driver;
	}

	public PendetesDeAprovacao(WebDriver driver, Map<String, String> data) {
		this(driver);
		this.data = data;
	}

	public PendetesDeAprovacao(WebDriver driver, Map<String, String> data, int timeout) {
		this(driver, data);
		this.timeout = timeout;
	}

}
