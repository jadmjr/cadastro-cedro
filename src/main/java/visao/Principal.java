package visao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import controle.Funcoes;
import modelo.Primeira;
import modelo.Segunda;
import modelo.Terceira;

public class Principal {
	public static Funcoes func = new Funcoes();

	public static void main(String[] args) {

		func.inicializar();
		func.abrirURL("https://dev.cedrotech.com/cadastro/pre-cadastro");
		
		preencherPrimeiraPagina(func.navegador);
		selecionaPlano(func.navegador);
		informacoesPessoais(func.navegador);

	}

	private static void informacoesPessoais(WebDriver navegador) {
		Terceira terceira = new Terceira();
		PageFactory.initElements(navegador, terceira);
		terceira.setDataDeNascimentoTextField("12/06/1990");
		terceira.clickMasculinoButton();
		terceira.setOpcionalTextField("jadmjr@gmail.com");
		terceira.setTelefoneFixoTextField("3432177247");		
		terceira.setPasDeNascimentoSearchField("BRASIL");
		terceira.setEstadoDeNascimentoSearchField("MINAS GERAIS");

	}

	public static void preencherPrimeiraPagina(WebDriver navegador) {
		Primeira primeira = new Primeira();
		PageFactory.initElements(navegador, primeira);
		primeira.setNomeCompletoTextField("Teste " + func.gerarNomeAleatorio());
		primeira.setCpfTextField(func.geraCpf.cpf(true));
		primeira.setEmailTextField("aaaa@aaa.com");
		primeira.setCelularTextField("34992881747");
		primeira.clickTodosOsTiposDeInvestimentoButton();
		primeira.clickSeguirButton();

	}
	private static void selecionaPlano(WebDriver navegador) {
		Segunda segunda = new Segunda(navegador);
		PageFactory.initElements(navegador, segunda);
		segunda.clickPLanoStandart();
		segunda.clickSeguirButton();
	}

}
