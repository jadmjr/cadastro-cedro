package modelo;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PendetesDeApovacao {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;

	@FindBy(name = "termSearch")
	@CacheLookup
	private WebElement pesquisa;

	@FindAll(@FindBy(className = "qtd-type"))
	@CacheLookup
	private List<WebElement> cadastroCompliance;

	@FindAll(@FindBy(className = "datatable-body-row"))
	@CacheLookup
	private List<WebElement> LinhaClient;

	@FindAll(@FindBy(className = "red-block"))
	@CacheLookup
	private List<WebElement> reprovados;

	@FindBy( tagName = "textarea")
	@CacheLookup
	private WebElement observacao;

	@FindBy(name = "accept")
	@CacheLookup
	private WebElement botaoAprovar;
	
	@FindBy(className = "modal-class")
	@CacheLookup
	private WebElement modal;
	
	

	public PendetesDeApovacao() {
	}

	public PendetesDeApovacao(WebDriver driver) {
		this();
		this.driver = driver;
	}

	public PendetesDeApovacao(WebDriver driver, Map<String, String> data) {
		this(driver);
		this.data = data;
	}

	public PendetesDeApovacao(WebDriver driver, Map<String, String> data, int timeout) {
		this(driver, data);
		this.timeout = timeout;
	}

	/**
	 * Click on Entrar Button.
	 *
	 * @return the CockpitLogin class instance.
	 */
	public PendetesDeApovacao clickCadastroButton() {
		cadastroCompliance.get(0).click();
		return this;
	}

	public PendetesDeApovacao clickComplianceButton() {
		cadastroCompliance.get(1).click();
		return this;
	}

	public PendetesDeApovacao imprimeClientes() {
		for (WebElement cliente : LinhaClient) {
			System.out.println(cliente.getText());
		}
		return this;
	}

	public PendetesDeApovacao aprovaClientes() {
		for (WebElement reprovado : reprovados) {
			try {
				reprovado.click();				
				ModalAprovacao modal = new ModalAprovacao();
				PageFactory.initElements(this.driver, modal);
				modal.preencherObservacao();
				modal.clicarEmAprovar();

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return this;
	}

	/**
	 * Fill every fields in the page.
	 *
	 * @return the CockpitLogin class instance.
	 */
	public PendetesDeApovacao fill() {
		return this;
	}

}
