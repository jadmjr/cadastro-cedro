package controle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium {

	private String pathChromeServer = "resources\\chromedriver\\chromedriver.exe";
	public WebDriverWait dormir;
	public WebDriver navegador;
	public JavascriptExecutor JSexecutor;
	public Random randon;
	public GerarCpfCnpj geraCpf;
	public JavascriptExecutor js;

	public Selenium() {

	}

	public void inicializar() {

		ChromeOptions options = new ChromeOptions();

		// options.addArguments("user-data-dir=C:\\Users\\julimar.miranda\\AppData\\Local\\Google\\Chrome\\User
		// Data\\");
		// SEM UI
		// options.addArguments("--headless");
		// options.addArguments("test-type");
		options.addArguments("enable-extensions");
		// options.addArguments("disable-infobars");
		options.addArguments("enable-plugins");
		// options.addArguments("no-sandbox");
		options.addArguments("start-maximized");
		// options.addArguments("test-type");
		// options.addArguments("test-type=browser");
		options.addArguments("auto-open-devtools-for-tabs");
		// options.addArguments("disable-default-apps");
		// options.addArguments("--disable-popup-blocking");
		// options.addArguments("enable-precise-memory-info");
		// options.addArguments("incognito");
		// options.addArguments("disable-infobars");
		// options.addArguments("--disable-notifications");
		// options.addArguments("js-flags=--expose-gc");
		// options.setExperimentalOption("useAutomationExtension", false);
		// options.setBinary("C:\\Program Files
		// (x86)\\Google\\Chrome\\Application\\chrome.exe");

		System.setProperty("webdriver.chrome.driver", pathChromeServer);
		navegador = new ChromeDriver(options);
		dormir = new WebDriverWait(navegador, 10);
		JSexecutor = (JavascriptExecutor) navegador;
		randon = new Random();
		geraCpf = new GerarCpfCnpj();
		navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		js = (JavascriptExecutor) navegador;

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

	public void esperarPorElemento(WebDriver navegador, WebElement elemento) {
		dormir = new WebDriverWait(navegador, 10);
		dormir.until(ExpectedConditions.visibilityOf(elemento));

	}

	public String carregarArquivo(String nomeArquivo) {
		File file = new File("resources\\imagem\\" + nomeArquivo);
		return file.getAbsolutePath();
	}

	public void salvarPaginaOFFLINE(String nomePagina) {
		String stored_report = navegador.getPageSource();

		File f = new File("resources\\pages-html\\" + nomePagina + ".html");
		FileWriter writer;
		try {
			writer = new FileWriter(f, true);
			writer.write(stored_report);
			System.out.println("Report Created is in Location : " + f.getAbsolutePath());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
