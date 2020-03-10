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

import controle.Selenium;

public class PendetesDeAprovacao extends Selenium {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;

	@FindBy(name = "termSearch")
	@CacheLookup
	private WebElement campoPesquisa;

	@FindBy(className = "datatable-body")
	@CacheLookup
	private WebElement ficha;

	private List<WebElement> botoesStatus;

	public PendetesDeAprovacao() {
	}

	public void aprovarPendencias() {

		List<WebElement> paineisClientes = ficha.findElements(By.tagName("datatable-body-row"));

		for (WebElement painel : paineisClientes) {

			botoesStatus = painel.findElements(By.className("block-type-ap"));

			for (WebElement botao : botoesStatus) {

				if (botao.getAttribute("class").contains("red")) {

					botao.click();

					esperar(200);
					ModalAprovacao modal = new ModalAprovacao();
					PageFactory.initElements(this.driver, modal);

					modal.preencherObservacao();
					modal.clicarEmAprovar();

				}

				if (botao.getAttribute("class").contains("yellow")) {

					botao.click();

					esperar(200);
					ModalAprovacao modal = new ModalAprovacao();
					PageFactory.initElements(this.driver, modal);

					modal.preencherObservacao();
					modal.clicarEmAprovar();

				}

				esperar(250);

			}

			WebElement btnAprovar = painel.findElement(By.className("d-flex")).findElements(By.tagName("div")).get(5);

			if (!btnAprovar.getAttribute("class").contains("bt-opacity")) {

				btnAprovar.click();

				ModalAprovarConta modalAprovaConta = new ModalAprovarConta();
				PageFactory.initElements(this.driver, modalAprovaConta);

				modalAprovaConta.aprovarConta();

			}

			esperar(250);

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
