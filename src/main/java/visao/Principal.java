package visao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import controle.Funcoes;
import modelo.CondicoesGerais;
import modelo.ConfirmaPerfilInvestidor10;
import modelo.Declaracoes11;
import modelo.Documentacao4;
import modelo.Endereco5;
import modelo.EnderecoCorrespondecia13;
import modelo.InformacoesBancarias8;
import modelo.InformacoesFinanceiras7;
import modelo.InformacoesPessoais3;
import modelo.InformacoesProfissionais6;
import modelo.PerfilInvestidor9;
//TELAS
import modelo.PreCadastro1;
import modelo.SelecaoDePlanos2;
import modelo.TerceirosProcuradores12;

public class Principal {
	
	boolean MENOR_DE_IDADE = true;
	boolean BRASILEIRO = true;
	boolean GESTOR = true;
	
	int procuradores = 0;

	public static Funcoes func = new Funcoes();

	public static void main(String[] args) {
		func.inicializar();

		// func.abrirURL("https://qa.cedrotech.com/cadastro/pre-cadastro");
		// func.abrirURL("https://dev.cedrotech.com/cadastro/pre-cadastro");
		func.abrirURL("https://uat.rbinvestimentos.com/cadastro/");

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
		enderecoCorrespondencia(func.navegador);
		preencherCondicoesGerais(func.navegador);

	}

	public static void preencherPrimeiraPagina(WebDriver navegador) {
		PreCadastro1 preCadastro = new PreCadastro1();
		PageFactory.initElements(navegador, preCadastro);
		preCadastro.setNomeCompletoTextField("Teste " + func.gerarNomeAleatorio());
		preCadastro.setCpfTextField(func.geraCpf.cpf(true));
		preCadastro.setEmailTextField("julimar.miranda@cedrotech.com");
		preCadastro.setCelularTextField("34992881747");
		if (!navegador.getCurrentUrl().contains("rbinvestimentos")) {
			preCadastro.clickTodosOsTiposDeInvestimentoButton();
		}
		preCadastro.clickSeguirButton();
	}

	private static void selecionaPlano(WebDriver navegador) {

		if (!navegador.getCurrentUrl().contains("rbinvestimentos")) {
			try {
				// LEROSA VALIDACAO
				if (!navegador.getCurrentUrl().contains("plataforma.lerosa.com.br")) {
					SelecaoDePlanos2 selecionarPlano = new SelecaoDePlanos2(navegador);
					PageFactory.initElements(navegador, selecionarPlano);
					selecionarPlano.clickPLanoStandart();
					selecionarPlano.clickSeguirButton();
				} else
					System.out.println("JADMJR -> LEROSA BYPASS");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

	}

	private static void informacoesPessoais(WebDriver navegador) {
		InformacoesPessoais3 informacoesPessoais = new InformacoesPessoais3();
		PageFactory.initElements(navegador, informacoesPessoais);
		informacoesPessoais.setDataDeNascimentoTextField("12/06/1990");
		informacoesPessoais.clickMasculinoButton();
		informacoesPessoais.setOpcionalTextField("jadmjr@gmail.com");
		informacoesPessoais.setTelefoneFixoTextField("3432177247");
		informacoesPessoais.setPasDeNascimentoSearchField("BRASIL");
		func.esperar(800);
		informacoesPessoais.setEstadoDeNascimentoSearchField("MINAS GERAIS");
		func.esperar(1500);
		informacoesPessoais.setCidadeDeNascimentoSearchField("UBERLÂNDIA");
		informacoesPessoais.setEstadoCivilDropDownListField("SOLTEIRO(A)");
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
		documentacao.setRgoEmissorDropDownListField("SECRETARIA DE SEGURANÇA PÚBLICA");
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
		func.dormir.until(ExpectedConditions.visibilityOf(informacoesProfissionais.getAreaOcupacao()));
		informacoesProfissionais.setQualASuaReaDeOcupaoSearchField("Acadêmica");
		informacoesProfissionais.setQualASuaProfissoDropDownListField("Professor de Ensino Superior");
		if (!navegador.getCurrentUrl().contains("rbinvestimentos"))
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
		informacoesBancarias.setBancoSearchField("NORDESTE");
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
		func.dormir.until(ExpectedConditions.visibilityOf(terceiros.getBotoes()));
		terceiros.negarProcuradores();
		func.dormir.until(ExpectedConditions.visibilityOf(terceiros.getBotaoSeguir()));
		terceiros.clickSeguirButton();
	}

	private static void enderecoCorrespondencia(WebDriver navegador) {
		if (!navegador.getCurrentUrl().contains("rbinvestimentos")) {
			EnderecoCorrespondecia13 enderecoC = new EnderecoCorrespondecia13();
			PageFactory.initElements(navegador, enderecoC);
			func.dormir.until(ExpectedConditions.visibilityOf(enderecoC.getInputNoReceberCorrespondecia()));
			enderecoC.setNoDesejoReceberCorrespondnciasCheckboxField();
			enderecoC.clickSeguirButton();
		}
	}

	private static void preencherCondicoesGerais(WebDriver navegador) {
		CondicoesGerais condicoes = new CondicoesGerais();
		PageFactory.initElements(navegador, condicoes);
		condicoes.aceitar();
		condicoes.clickSeguirButton();
	}

}
