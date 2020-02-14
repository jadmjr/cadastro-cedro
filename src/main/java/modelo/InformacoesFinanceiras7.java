package modelo;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InformacoesFinanceiras7 {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;

	@FindBy(id = "others_mensal_income")
	@CacheLookup
	private WebElement outrosRendimentosMensais;

	private final String pageLoadedText = "* A corretora se reserva o direito de solicitar documentos adicionais para validação das informações acima, se necessário";

	private final String pageUrl = "/cadastro/informacoes-financeiras";

	@FindBy(id = "mensal_income")
	@CacheLookup
	private WebElement rendimentosMensais;

	@FindBy(id = "buttonNext")
	@CacheLookup
	private WebElement seguir;

	@FindBy(id = "properties_value")
	@CacheLookup
	private WebElement totalBensImveisbensMveis;

	@FindBy(id = "buttonPrevious")
	@CacheLookup
	private WebElement voltar;

	@FindAll({ @FindBy(tagName = "mat-checkbox") })
	private List<WebElement> checkBox;

	@FindBy(id = "others_availability")
	@CacheLookup
	private WebElement aplicaoFinanceira;

	public InformacoesFinanceiras7() {
	}

	public InformacoesFinanceiras7(WebDriver driver) {
		this();
		this.driver = driver;
	}

	public InformacoesFinanceiras7(WebDriver driver, Map<String, String> data) {
		this(driver);
		this.data = data;
	}

	public InformacoesFinanceiras7(WebDriver driver, Map<String, String> data, int timeout) {
		this(driver, data);
		this.timeout = timeout;
	}

	public InformacoesFinanceiras7 setAplicaoFinanceiraTextField(String aplicaoFinanceiraValue) {
		aplicaoFinanceira.sendKeys(aplicaoFinanceiraValue);
		return this;
	}
	
	public InformacoesFinanceiras7 setCheckBox() {
		checkBox.get(0).click();
		return this;
	}

	/**
	 * Click on Seguir Button.
	 *
	 * @return the InformacoesFinanceiras7 class instance.
	 */
	public InformacoesFinanceiras7 clickSeguirButton() {
		seguir.click();
		return this;
	}

	/**
	 * Click on Voltar Button.
	 *
	 * @return the InformacoesFinanceiras7 class instance.
	 */
	public InformacoesFinanceiras7 clickVoltarButton() {
		voltar.click();
		return this;
	}

	/**
	 * Fill every fields in the page.
	 *
	 * @return the InformacoesFinanceiras7 class instance.
	 */
	public InformacoesFinanceiras7 fill() {
		setRendimentosMensaisTextField();
		setOutrosRendimentosMensaisTextField();
		setTotalBensImveisbensMveisTextField();
		return this;
	}

	/**
	 * Set Aluguel De Propriedades Checkbox field.
	 *
	 * @return the InformacoesFinanceiras7 class instance.
	 */

	/**
	 * Set default value to Aplicao Financeira Text field.
	 *
	 * @return the InformacoesFinanceiras7 class instance.
	 */

	/**
	 * Set value to Aplicao Financeira Text field.
	 *
	 * @return the InformacoesFinanceiras7 class instance.
	 */

	/**
	 * Set Aposentadoria Checkbox field.
	 *
	 * @return the InformacoesFinanceiras7 class instance.
	 * 
	 *         /** Set Doao Checkbox field.
	 *
	 * @return the InformacoesFinanceiras7 class instance.
	 */

	/**
	 * Set Herana Checkbox field.
	 *
	 * @return the InformacoesFinanceiras7 class instance.
	 */

	/**
	 * Set Outros. Indique Checkbox field.
	 *
	 * @return the InformacoesFinanceiras7 class instance.
	 */

	/**
	 * Set default value to Outros Rendimentos Mensais Text field.
	 *
	 * @return the InformacoesFinanceiras7 class instance.
	 */
	public InformacoesFinanceiras7 setOutrosRendimentosMensaisTextField() {
		return setOutrosRendimentosMensaisTextField(data.get("OUTROS_RENDIMENTOS_MENSAIS"));
	}

	/**
	 * Set value to Outros Rendimentos Mensais Text field.
	 *
	 * @return the InformacoesFinanceiras7 class instance.
	 */
	public InformacoesFinanceiras7 setOutrosRendimentosMensaisTextField(String outrosRendimentosMensaisValue) {
		outrosRendimentosMensais.sendKeys(outrosRendimentosMensaisValue);
		return this;
	}

	/**
	 * Set Partilha De Bens Checkbox field.
	 *
	 * @return the InformacoesFinanceiras7 class instance.
	 */

	/**
	 * Set Renda Ocupao Profissional Checkbox field.
	 *
	 * @return the InformacoesFinanceiras7 class instance.
	 */

	/**
	 * Set default value to Rendimentos Mensais Text field.
	 *
	 * @return the InformacoesFinanceiras7 class instance.
	 */
	public InformacoesFinanceiras7 setRendimentosMensaisTextField() {
		return setRendimentosMensaisTextField(data.get("RENDIMENTOS_MENSAIS"));
	}

	/**
	 * Set value to Rendimentos Mensais Text field.
	 *
	 * @return the InformacoesFinanceiras7 class instance.
	 */
	public InformacoesFinanceiras7 setRendimentosMensaisTextField(String rendimentosMensaisValue) {
		rendimentosMensais.sendKeys(rendimentosMensaisValue);
		return this;
	}

	/**
	 * Set default value to Total Bens Imveisbens Mveis Text field.
	 *
	 * @return the InformacoesFinanceiras7 class instance.
	 */
	public InformacoesFinanceiras7 setTotalBensImveisbensMveisTextField() {
		return setTotalBensImveisbensMveisTextField(data.get("TOTAL_BENS_IMVEISBENS_MVEIS"));
	}

	/**
	 * Set value to Total Bens Imveisbens Mveis Text field.
	 *
	 * @return the InformacoesFinanceiras7 class instance.
	 */
	public InformacoesFinanceiras7 setTotalBensImveisbensMveisTextField(String totalBensImveisbensMveisValue) {
		totalBensImveisbensMveis.sendKeys(totalBensImveisbensMveisValue);
		return this;
	}

	/**
	 * Unset Aluguel De Propriedades Checkbox field.
	 *
	 * @return the InformacoesFinanceiras7 class instance.
	 */

	/**
	 * Unset Doao Checkbox field.
	 *
	 * @return the InformacoesFinanceiras7 class instance.
	 */

	/**
	 * Unset Partilha De Bens Checkbox field.
	 *
	 * @return the InformacoesFinanceiras7 class instance.
	 */

	/**
	 * Verify that the page loaded completely.
	 *
	 * @return the InformacoesFinanceiras7 class instance.
	 */
	public InformacoesFinanceiras7 verifyPageLoaded() {
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
	 * @return the InformacoesFinanceiras7 class instance.
	 */
	public InformacoesFinanceiras7 verifyPageUrl() {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getCurrentUrl().contains(pageUrl);
			}
		});
		return this;
	}
}
