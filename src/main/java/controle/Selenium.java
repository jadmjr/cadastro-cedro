package controle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import modelo.Proton;

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
		//options.addArguments("--headless");
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
		
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);

		// set performance logger
		// this sends Network.enable to chromedriver
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
		cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

		System.setProperty("webdriver.chrome.driver", pathChromeServer);
		navegador = new ChromeDriver(cap);
		dormir = new WebDriverWait(navegador, 10);
		JSexecutor = (JavascriptExecutor) navegador;
		randon = new Random();
		geraCpf = new GerarCpfCnpj();
		navegador.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		js = (JavascriptExecutor) navegador;

	}
	
	public void lerLog(WebDriver driver){
		 // then ask for all the performance logs from this request
        // one of them will contain the Network.responseReceived method
        // and we shall find the "last recorded url" response
        LogEntries logs = driver.manage().logs().get("performance");

        int status = -1;

        System.out.println("\nList of log entries:\n");

        for (Iterator<LogEntry> it = logs.iterator(); it.hasNext();)
        {
            LogEntry entry = it.next();

            try
            {
                JSONObject json = new JSONObject(entry.getMessage());

                System.out.println(json.toString());

                JSONObject message = json.getJSONObject("message");
                String method = message.getString("method");

                if (method != null
                        && "Network.responseReceived".equals(method))
                {
                    JSONObject params = message.getJSONObject("params");

                    JSONObject response = params.getJSONObject("response");
                    String messageUrl = response.getString("url");

                    if (driver.getCurrentUrl().equals(messageUrl))
                    {
                        status = response.getInt("status");

                        System.out.println(
                                "---------- bingo !!!!!!!!!!!!!! returned response for "
                                        + messageUrl + ": " + status);

                        System.out.println(
                                "---------- bingo !!!!!!!!!!!!!! headers: "
                                        + response.get("headers"));
                    }
                }
            } catch (JSONException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        System.out.println("\nstatus code: " + status);
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

	public String buscarTokenNoProtonMail(WebDriver navegador, String dataHora) {

		JSexecutor.executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(navegador.getWindowHandles());
		navegador.switchTo().window(tabs.get(1));

		Proton proton = new Proton(navegador);
		PageFactory.initElements(navegador, proton);

		String token = proton.buscarToken(dataHora);

		navegador.close();
		tabs = new ArrayList<String>(navegador.getWindowHandles());
		navegador.switchTo().window(tabs.get(0));

		return token;

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

	public String pegarDataHora() {
		Date date = new Date(System.currentTimeMillis() - 3600 * 1000);
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		String dataHoras = formatter.format(date);
		return dataHoras;
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
