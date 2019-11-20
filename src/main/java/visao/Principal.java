package visao;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import controle.Funcoes;
import modelo.ConfirmaPerfilInvestidor10;
import modelo.Declaracoes11;
import modelo.TerceirosProcuradores12;
import modelo.PerfilInvestidor9;
import modelo.InformacoesBancarias8;
import modelo.PreCadastro1;
import modelo.Documentacao4;
import modelo.Endereco5;
import modelo.SelecaoDePlanos2;
import modelo.InformacoesFinanceiras7;
import modelo.InformacoesProfissionais6;
import modelo.InformacoesPessoais3;

public class Principal {

	public static Funcoes func = new Funcoes();

	public static void main(String[] args) {
		func.inicializar();
		func.abrirURL("https://dev.cedrotech.com/cadastro/pre-cadastro");
		preencherPrimeiraPagina(func.navegador);
		selecionaPlano(func.navegador);
		informacoesPessoais(func.navegador);
		preencherTipoDeDocumento(func.navegador);
		preencherEndereco(func.navegador);
		preencherInformacoesProfissionais(func.navegador);
		preencherInformacoesFinanceiras(func.navegador);
		preencherInformacoesBancarias(func.navegador);
		preencherPerfilInvestidor(func.navegador);
		confirmarPerfilInvestidor(func.navegador);
		preencherDeclaracoes(func.navegador);
		informarProcuradores(func.navegador);
	}

	public static void preencherPrimeiraPagina(WebDriver navegador) {
		PreCadastro1 preCadastro = new PreCadastro1();
		PageFactory.initElements(navegador, preCadastro);
		preCadastro.setNomeCompletoTextField("Teste " + func.gerarNomeAleatorio());
		preCadastro.setCpfTextField(func.geraCpf.cpf(true));
		preCadastro.setEmailTextField("aaaa@aaa.com");
		preCadastro.setCelularTextField("34992881747");
		preCadastro.clickTodosOsTiposDeInvestimentoButton();
		preCadastro.clickSeguirButton();

	}

	private static void selecionaPlano(WebDriver navegador) {
		SelecaoDePlanos2 selecionarPlano = new SelecaoDePlanos2(navegador);
		PageFactory.initElements(navegador, selecionarPlano);
		selecionarPlano.clickPLanoStandart();
		selecionarPlano.clickSeguirButton();
	}

	private static void informacoesPessoais(WebDriver navegador) {
		InformacoesPessoais3 informacoesPessoais = new InformacoesPessoais3();
		PageFactory.initElements(navegador, informacoesPessoais);
		informacoesPessoais.setDataDeNascimentoTextField("12/06/1990");
		informacoesPessoais.clickMasculinoButton();
		informacoesPessoais.setOpcionalTextField("jadmjr@gmail.com");
		informacoesPessoais.setTelefoneFixoTextField("3432177247");
		informacoesPessoais.setPasDeNascimentoSearchField("BRASIL");
		informacoesPessoais.setEstadoDeNascimentoSearchField("MINAS GERAIS");
		informacoesPessoais.setCidadeDeNascimentoSearchField("UBERLÂNDIA");
		informacoesPessoais.setEstadoCivilDropDownListField("Solteiro(a)");
		informacoesPessoais.setNomeCompletoDoPaiTextField("PAI " + func.gerarNomeAleatorio());
		informacoesPessoais.setNomeCompletoDaMeTextField("MAE " + func.gerarNomeAleatorio());
		informacoesPessoais.clickSeguirButton();
	}

	private static void preencherTipoDeDocumento(WebDriver navegador) {
		Documentacao4 documentacao = new Documentacao4();
		PageFactory.initElements(navegador, documentacao);
		// FLUXO INFORMANDO RG
		documentacao.clickRgButton();
		documentacao.setNmeroDoRgTextField("16472307");
		documentacao.setEstadoEmissorSearchField("MINAS GERAIS");
		func.esperar(800);
		documentacao.setRgoEmissorDropDownListField("POLÍCIA CIVIL");
		documentacao.setDataDeEmissoTextField("12/06/2000");
		documentacao.clickSeguirButton();
	}

	private static void preencherEndereco(WebDriver navegador) {
		Endereco5 endereco = new Endereco5();
		PageFactory.initElements(navegador, endereco);
		endereco.setCepTextField("38408714");
		func.esperar(500);
		endereco.setNumero("768");
		endereco.setComplemento("CASA");
		endereco.clickSeguirButton();
	}

	private static void preencherInformacoesProfissionais(WebDriver navegador) {
		InformacoesProfissionais6 informacoesProfissionais = new InformacoesProfissionais6(navegador);
		PageFactory.initElements(navegador, informacoesProfissionais);
		informacoesProfissionais.setQualASuaReaDeOcupaoSearchField("Acadêmica");
		informacoesProfissionais.setQualASuaProfissoDropDownListField("Professor de Ensino Superior");
		informacoesProfissionais.setVinculoDropDownListField("Empregado do Setor Privado");
		informacoesProfissionais.setNoRadioButtonField();
		informacoesProfissionais.clickSeguirButton();

	}

	private static void preencherInformacoesFinanceiras(WebDriver navegador) {
		InformacoesFinanceiras7 informacoesFinanceiras = new InformacoesFinanceiras7();
		PageFactory.initElements(navegador, informacoesFinanceiras);
		informacoesFinanceiras.setBensImveisTextField("150000");
		informacoesFinanceiras.setOutrosBensEValoresTextField("155000");
		informacoesFinanceiras.setRendimentosMensaisTextField("9000");
		informacoesFinanceiras.setOutrosRendimentosMensaisTextField("5000");
		informacoesFinanceiras.clickSeguirButton();
	}

	private static void preencherInformacoesBancarias(WebDriver navegador) {
		InformacoesBancarias8 informacoesBancarias = new InformacoesBancarias8();
		PageFactory.initElements(navegador, informacoesBancarias);
		informacoesBancarias.setTipoDeContaDropDownListField("CONTA CORRENTE");
		informacoesBancarias.setBancoSearchField("001 - BRASIL S/A");
		informacoesBancarias.setAgnciaNumberField("0165");
		informacoesBancarias.setContaNumberField("23393");
		informacoesBancarias.setDgitoTextField("5");
		informacoesBancarias.clickSalvarButton();
		informacoesBancarias.clickSeguirButton();

	}

	private static void preencherPerfilInvestidor(WebDriver navegador) {
		PerfilInvestidor9 perfilInvestidor = new PerfilInvestidor9();
		PageFactory.initElements(navegador, perfilInvestidor);
		perfilInvestidor.preencherPerfilModerado();
		perfilInvestidor.clicarBotaoSeguir();

	}

	private static void confirmarPerfilInvestidor(WebDriver navegador) {
		ConfirmaPerfilInvestidor10 confirmaPerfilInvestidor = new ConfirmaPerfilInvestidor10();
		PageFactory.initElements(navegador, confirmaPerfilInvestidor);
		confirmaPerfilInvestidor.clickSeguirButton();
	}

	private static void preencherDeclaracoes(WebDriver navegador) {
		Declaracoes11 declaracoes = new Declaracoes11();
		PageFactory.initElements(navegador, declaracoes);
		declaracoes.negarTudoNasDeclaracoes();
		declaracoes.clickSeguirButton();

	}

	private static void informarProcuradores(WebDriver navegador) {
		TerceirosProcuradores12 terceiros = new TerceirosProcuradores12();
		PageFactory.initElements(navegador, terceiros);
		terceiros.negarProcuradores();
		terceiros.clickSeguirButton();
	}

}
