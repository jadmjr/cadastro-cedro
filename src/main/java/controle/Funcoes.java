package controle;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Funcoes {

	private String pathChromeServer = "resources\\chromedriver\\chromedriver.exe";
	public WebDriverWait dormir;
	public WebDriver navegador;
	public JavascriptExecutor JSexecutor;
	public Random randon;
	public GerarCpfCnpj geraCpf;

	public Funcoes() {

	}

	public void inicializar() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		// SEM UI
		// options.addArguments("--headless");
		System.setProperty("webdriver.chrome.driver", pathChromeServer);
		navegador = new ChromeDriver(options);
		dormir = new WebDriverWait(navegador, 10);
		JSexecutor = (JavascriptExecutor) navegador;
		randon = new Random();
		geraCpf = new GerarCpfCnpj();		
		navegador.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void abrirURL(String url) {
		navegador.get(url);
	}

	public String gerarNomeAleatorio() {
		String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ";

		Random random = new Random();

		String armazenaChaves = "";
		int index = -1;
		for (int i = 0; i < 9; i++) {
			index = random.nextInt(letras.length());
			armazenaChaves += letras.substring(index, index + 1);
		}
		return armazenaChaves;
	}

	public void selecionarPrimeiraOpcao(WebElement input, String texto) {
		input.clear();
		esperar(250);
		input.sendKeys(texto);
		esperar(500);
		input.sendKeys(Keys.ARROW_DOWN);
		esperar(500);
		input.sendKeys(Keys.ENTER);
	}

	public void esperar(int tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
