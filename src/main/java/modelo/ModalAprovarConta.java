package modelo;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModalAprovarConta {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

 

    @FindBy(id = "confirm-account")
    @CacheLookup
    private WebElement botaoAprovarConta;
    
    @FindBy( tagName = "textarea")
	@CacheLookup
	private WebElement observacao;

  

    public ModalAprovarConta() {
    }
    
       public void aprovarConta() {
    	   
    	   observacao.click();
    	   observacao.sendKeys("Aprovado");
    	   
    	   botaoAprovarConta.click();
    	   
       }
    
    
    
    
    

    public ModalAprovarConta(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public ModalAprovarConta(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public ModalAprovarConta(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }


}
