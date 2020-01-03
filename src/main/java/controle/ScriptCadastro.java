package controle;

import java.util.ArrayList;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import modelo.CondicoesGerais;
import modelo.ConfirmaPerfilInvestidor10;
import modelo.ConfirmacaoDeCadastro;
import modelo.Declaracoes11;
import modelo.Documentacao4;
import modelo.Endereco5;
import modelo.EnderecoCorrespondecia13;
import modelo.InformacoesBancarias8;
import modelo.InformacoesFinanceiras7;
import modelo.InformacoesPessoais3;
import modelo.InformacoesProfissionais6;
import modelo.Pendencias;
import modelo.PerfilInvestidor9;
//TELAS
import modelo.PreCadastro1;
import modelo.Proton;
import modelo.SelecaoDePlanos2;
import modelo.TerceirosProcuradores12;

public class ScriptCadastro {

	public boolean menorDeIdade, emancipado, gestorDeContas, estrangeiro;
	public int tipoDocumento;
	public Selenium sel;

	public void executar(boolean menorDeIdade, boolean emancipado, boolean estrangeiro, boolean gestorDeContas,
			int tipoDocumento) {

		this.menorDeIdade = menorDeIdade;
		this.emancipado = emancipado;
		this.estrangeiro = estrangeiro;
		this.gestorDeContas = gestorDeContas;
		this.tipoDocumento = tipoDocumento;

		sel = new Selenium();
		sel.inicializar();

		// sel.abrirURL("https://qa.cedrotech.com/cadastro/pre-cadastro");
		// sel.abrirURL("https://dev.cedrotech.com/cadastro/pre-cadastro");
		sel.abrirURL("https://uat.rbinvestimentos.com/cadastro/");
		// sel.abrirURL("https://plataforma.lerosa.com.br/cadastro/");

		try {
			preencherPrimeiraPagina(sel.navegador);
			sel.lerLog(sel.navegador);
			selecionaPlano(sel.navegador);

			informacoesPessoais(sel.navegador);

			preencherTipoDeDocumento(sel.navegador);
			preencherEndereco(sel.navegador);
			preencherInformacoesProfissionais(sel.navegador);
			preencherInformacoesFinanceiras(sel.navegador);
			preencherInformacoesBancarias(sel.navegador);
			preencherPerfilInvestidor(sel.navegador);
			confirmarPerfilInvestidor(sel.navegador);
			preencherDeclaracoes(sel.navegador);
			informarProcuradores(sel.navegador);
			enderecoCorrespondencia(sel.navegador);
			preencherCondicoesGerais(sel.navegador);
			preencherPendencias(sel.navegador);
			confirmarCadastro(sel.navegador);

		} catch (Exception e) {

			e.printStackTrace();

			/*
			 * if (sel.navegador.findElement(By.id("information-modal")).getText()
			 * .contains("Estamos com instabilidade no sistema, por favor tente novamente mais tarde!"
			 * )) System.out.println("Sistema com instabilidade");
			 */
		}

	}

	public void preencherPrimeiraPagina(WebDriver navegador) {

		PreCadastro1 preCadastro = new PreCadastro1(navegador);
		PageFactory.initElements(navegador, preCadastro);

		preCadastro.setNomeCompletoTextField("Teste " + sel.gerarNomeAleatorio());
		preCadastro.setCpfTextField(sel.geraCpf.cpf(true));
		preCadastro.setEmailTextField("robozim.qa@protonmail.com");
		preCadastro.setCelularTextField("34992881747");

		if (gestorDeContas) {
			preCadastro.clickToggle();
			sel.esperar(250);
			if (navegador.getCurrentUrl().contains("rbinvestimentos"))
				preCadastro.setAssessor("ADRIANO MORENO (BTO PARTNERS)");
		}

		if (!navegador.getCurrentUrl().contains("rbinvestimentos")) {
			preCadastro.clickTodosOsTiposDeInvestimentoButton();
		}

		// sel.salvarPaginaOFFLINE("pre-cadastro");
		preCadastro.clickSeguirButton();
	}

	private void selecionaPlano(WebDriver navegador) {

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

	private void informacoesPessoais(WebDriver navegador) {
		InformacoesPessoais3 informacoesPessoais = new InformacoesPessoais3(sel.navegador);
		PageFactory.initElements(navegador, informacoesPessoais);

		informacoesPessoais.clickMasculinoButton();

		if (menorDeIdade) {
			informacoesPessoais.setDataDeNascimentoTextField("12/06/2010");
			if (!emancipado) {
				if (!sel.navegador.getCurrentUrl().contains("lerosa")
						&& !sel.navegador.getCurrentUrl().contains("cedrotech"))
					informacoesPessoais.setResponsvelLegalDropDownListField("MÃE");
				else
					informacoesPessoais.setResponsvelLegalDropDownListField("Mãe");
				informacoesPessoais.setNomeDoResponsvelLegalTextField("REPRESENTA " + sel.gerarNomeAleatorio());
				informacoesPessoais.setCpfDoResponsvelLegalTextField(sel.geraCpf.cpf(true));
				informacoesPessoais.setRgDoResponsvelLegalTextField("16470301");
				informacoesPessoais.setEmailDoResponsvelLegalEmailField("jadmjr+1@gmail.com");

				informacoesPessoais.setUploadDoDocumentoDeIdentificaoComFileField(sel.carregarArquivo("cnh1.jpg"));
			} else {
				informacoesPessoais.clickSimButton();
				informacoesPessoais
						.setUploadDoDocumentoDeIdentificaoComFileField(sel.carregarArquivo("certidaodenascimento.png"));
			}

		} else {
			informacoesPessoais.setDataDeNascimentoTextField("12/06/1990");
		}

		informacoesPessoais.setEmailSecundrioTextField("jadmjr@gmail.com");
		informacoesPessoais.setTelefoneFixoTextField("3432177247");
		// informacoesPessoais.setPasDeNascimentoSearchField("");
		if (!estrangeiro) {
			informacoesPessoais.setPasDeNascimentoSearchField("BRASIL");
			sel.esperar(800);
			informacoesPessoais.setEstadoDeNascimentoSearchField("MINAS GERAIS");
			sel.esperar(1500);
			informacoesPessoais.setCidadeDeNascimentoSearchField("UBERLÂNDIA");
		}
		// ESTRANGEIRO
		else {
			informacoesPessoais.setPasDeNascimentoSearchField("EGITO");
			sel.esperar(800);
		}
		if (!sel.navegador.getCurrentUrl().contains("lerosa"))
			informacoesPessoais.setEstadoCivilDropDownListField("SOLTEIRO(A)");
		else
			informacoesPessoais.setEstadoCivilDropDownListField("Solteiro(a)");

		informacoesPessoais.setNomeCompletoDoPaiTextField("PAI " + sel.gerarNomeAleatorio());

		if (!menorDeIdade || emancipado)
			informacoesPessoais.setNomeCompletoDaMeTextField("MAE " + sel.gerarNomeAleatorio());

		informacoesPessoais.clickSeguirButton();
	}

	private void preencherTipoDeDocumento(WebDriver navegador) {
		Documentacao4 documentacao = new Documentacao4();
		PageFactory.initElements(navegador, documentacao);

		if (tipoDocumento == 1) {
			// FLUXO INFORMANDO RG
			documentacao.clickRgButton();
			documentacao.setNumeroDocumentoTextField("16472307");
			documentacao.setEstadoEmissorSearchField("MINAS GERAIS");
			sel.esperar(800);
			documentacao.setRgoEmissorDropDownListField("SECRETARIA DE SEGURANÇA PÚBLICA");
			documentacao.setDataDeEmissoTextField("12/06/2019");

			if (sel.navegador.getCurrentUrl().contains("lerosa")) {
				documentacao.setComprovantes();
			}
		} else if (tipoDocumento == 2) {
			documentacao.clickCnhButton();
			documentacao.setNumeroDocumentoTextField("16472307");
			documentacao.setEstadoEmissorSearchField("MINAS GERAIS");
			sel.esperar(800);
			documentacao.setRgoEmissorDropDownListField("DEPARTAMENTO ESTADUAL DE TRÂNSITO");
			documentacao.setDataDeEmissoTextField("12/06/2019");
			documentacao.setDataDeValidadeCNH("30/12/2020");
		} else if (tipoDocumento == 3) {
			documentacao.clickRneButton();
			documentacao.setNumeroDocumentoTextField("16472307");
			documentacao.setEstadoEmissorSearchField("MINAS GERAIS");
			documentacao.setRgoEmissorDropDownListField("MINISTÉRIO DA JUSTIÇA");
			documentacao.setDataDeEmissoTextField("12/06/2019");
			documentacao.setDataDeValidadeCNH("30/12/2020");

		}

		documentacao.clickSeguirButton();
	}

	private void preencherEndereco(WebDriver navegador) {
		Endereco5 endereco = new Endereco5();
		PageFactory.initElements(navegador, endereco);
		endereco.setCepTextField("38408714");
		sel.esperar(500);
		endereco.setNumero("768");
		endereco.setComplemento("CASA");
		endereco.clickSeguirButton();
	}

	private void preencherInformacoesProfissionais(WebDriver navegador) {
		InformacoesProfissionais6 informacoesProfissionais = new InformacoesProfissionais6(navegador);
		PageFactory.initElements(navegador, informacoesProfissionais);
		sel.dormir.until(ExpectedConditions.visibilityOf(informacoesProfissionais.getAreaOcupacao()));
		informacoesProfissionais.setQualASuaReaDeOcupaoSearchField("Acadêmica");
		informacoesProfissionais.setQualASuaProfissoDropDownListField("Professor de Ensino Superior");
		if (!navegador.getCurrentUrl().contains("rbinvestimentos"))
			informacoesProfissionais.setVinculoDropDownListField("Empregado do Setor Privado");
		informacoesProfissionais.setNoRadioButtonField();
		informacoesProfissionais.clickSeguirButton();
	}

	private void preencherInformacoesFinanceiras(WebDriver navegador) {
		InformacoesFinanceiras7 informacoesFinanceiras = new InformacoesFinanceiras7();
		PageFactory.initElements(navegador, informacoesFinanceiras);
		informacoesFinanceiras.setBensImveisTextField("150000");
		informacoesFinanceiras.setOutrosBensEValoresTextField("155000");
		informacoesFinanceiras.setRendimentosMensaisTextField("9000");
		informacoesFinanceiras.setOutrosRendimentosMensaisTextField("5000");
		informacoesFinanceiras.clickSeguirButton();
	}

	private void preencherInformacoesBancarias(WebDriver navegador) {
		InformacoesBancarias8 informacoesBancarias = new InformacoesBancarias8();
		PageFactory.initElements(navegador, informacoesBancarias);
		informacoesBancarias.setTipoDeContaDropDownListField("CONTA CORRENTE");
		informacoesBancarias.setBancoSearchField("NORDESTE");
		informacoesBancarias.setAgnciaNumberField("0165");
		informacoesBancarias.setContaNumberField("23393");
		informacoesBancarias.setDgitoTextField("5");
		informacoesBancarias.clickSalvarButton();
		sel.esperar(1000);
		informacoesBancarias.clickSeguirButton();
	}

	private void preencherPerfilInvestidor(WebDriver navegador) {
		PerfilInvestidor9 perfilInvestidor = new PerfilInvestidor9();
		PageFactory.initElements(navegador, perfilInvestidor);
		perfilInvestidor.preencherPerfilModerado();
		perfilInvestidor.clicarBotaoSeguir();
	}

	private void confirmarPerfilInvestidor(WebDriver navegador) {
		ConfirmaPerfilInvestidor10 confirmaPerfilInvestidor = new ConfirmaPerfilInvestidor10();
		PageFactory.initElements(navegador, confirmaPerfilInvestidor);
		confirmaPerfilInvestidor.clickSeguirButton();
	}

	private void preencherDeclaracoes(WebDriver navegador) {
		Declaracoes11 declaracoes = new Declaracoes11();
		PageFactory.initElements(navegador, declaracoes);
		declaracoes.negarTudoNasDeclaracoes();
		declaracoes.clickSeguirButton();

	}

	private void informarProcuradores(WebDriver navegador) {
		TerceirosProcuradores12 terceiros = new TerceirosProcuradores12();
		PageFactory.initElements(navegador, terceiros);
		sel.dormir.until(ExpectedConditions.visibilityOf(terceiros.getBotoes()));
		terceiros.negarProcuradores();
		sel.dormir.until(ExpectedConditions.visibilityOf(terceiros.getBotaoSeguir()));
		terceiros.clickSeguirButton();
	}

	private void enderecoCorrespondencia(WebDriver navegador) {
		if (!navegador.getCurrentUrl().contains("rbinvestimentos")) {
			EnderecoCorrespondecia13 enderecoC = new EnderecoCorrespondecia13();
			PageFactory.initElements(navegador, enderecoC);
			sel.dormir.until(ExpectedConditions.visibilityOf(enderecoC.getInputNoReceberCorrespondecia()));
			enderecoC.setNoDesejoReceberCorrespondnciasCheckboxField();
			enderecoC.clickSeguirButton();
		}
	}

	private void preencherCondicoesGerais(WebDriver navegador) {
		CondicoesGerais condicoes = new CondicoesGerais();
		PageFactory.initElements(navegador, condicoes);
		condicoes.aceitar();
		condicoes.clickSeguirButton();
	}

	private void preencherPendencias(WebDriver navegador) {
		Pendencias pendecias = new Pendencias();
		PageFactory.initElements(navegador, pendecias);
		sel.esperar(1500);
		pendecias.setComprovantes(gestorDeContas);
		pendecias.clickSeguirButton();

	}

	private void confirmarCadastro(WebDriver navegador) {

		ConfirmacaoDeCadastro confirmar = new ConfirmacaoDeCadastro();
		PageFactory.initElements(navegador, confirmar);

		confirmar.enviarToken();

		String token = sel.buscarTokenNoProtonMail(navegador, sel.pegarDataHora());

		confirmar.preencherCampoToken(token);
		confirmar.clickValidarToken();

		sel.esperar(1500);
		confirmar.clickSeguirButton();
	}

}
