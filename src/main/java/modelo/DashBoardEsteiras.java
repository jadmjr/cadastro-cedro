package modelo;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class DashBoardEsteiras {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;

	@FindBy(name = "termSearch")
	@CacheLookup
	private WebElement campoPesquisa;

	@FindAll({ @FindBy(className = "qtd-source") })
	@CacheLookup
	private List<WebElement> esteiras;
	


	public DashBoardEsteiras() {
	}

	public DashBoardEsteiras acessarEsteiraPendentesAprovacao() {

		esteiras.get(0).click();
		return this;

	}

	public DashBoardEsteiras(WebDriver driver) {
		this();
		this.driver = driver;
	}

	public DashBoardEsteiras(WebDriver driver, Map<String, String> data) {
		this(driver);
		this.data = data;
	}

	public DashBoardEsteiras(WebDriver driver, Map<String, String> data, int timeout) {
		this(driver, data);
		this.timeout = timeout;
	}

}
