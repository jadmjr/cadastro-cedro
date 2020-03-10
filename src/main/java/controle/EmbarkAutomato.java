package controle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import modelo.CondicoesGerais;
import modelo.ConfirmaPerfilInvestidor10;
import modelo.ConfirmacaoDeCadastro;
import modelo.DeclaracaoDeProposito;
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
import modelo.SelecaoDePlanos2;
import modelo.TerceirosProcuradores12;

public class EmbarkAutomato implements Runnable {

	public boolean menorDeIdade, emancipado, gestorDeContas, estrangeiro;
	String ambiente;
	public int tipoDocumento;
	public Selenium sel;

	public boolean isMenorDeIdade() {
		return menorDeIdade;
	}

	public void setMenorDeIdade(boolean menorDeIdade) {
		this.menorDeIdade = menorDeIdade;
	}

	public boolean isEmancipado() {
		return emancipado;
	}

	public void setEmancipado(boolean emancipado) {
		this.emancipado = emancipado;
	}

	public boolean isGestorDeContas() {
		return gestorDeContas;
	}

	public void setGestorDeContas(boolean gestorDeContas) {
		this.gestorDeContas = gestorDeContas;
	}

	public boolean isEstrangeiro() {
		return estrangeiro;
	}

	public void setEstrangeiro(boolean estrangeiro) {
		this.estrangeiro = estrangeiro;
	}

	public String getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}

	public int getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(int tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
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
				informacoesPessoais.setRgDoResponsvelLegalTextField("17405201");
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
		if (!estrangeiro) {
			informacoesPessoais.setPasDeNascimentoSearchField("BRASIL");
			sel.esperar(800);
			if (sel.navegador.getCurrentUrl().contains("qa.cedrotech.com"))
				informacoesPessoais.setEstadoDeNascimentoCedroQASearchField("MINAS GERAIS");
			else
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
		informacoesFinanceiras.setRendimentosMensaisTextField("150000");
		informacoesFinanceiras.setOutrosRendimentosMensaisTextField("155000");
		informacoesFinanceiras.setAplicaoFinanceiraTextField("9000");
		informacoesFinanceiras.setTotalBensImveisbensMveisTextField("5000");
		if (!navegador.getCurrentUrl().contains("lerosa"))
			informacoesFinanceiras.setCheckBox();
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

	private void preencherDeclaracaoProposito(WebDriver navegador) {
		if (sel.navegador.getCurrentUrl().contains("rbinvestimentos")) {
			DeclaracaoDeProposito decProp = new DeclaracaoDeProposito();
			PageFactory.initElements(navegador, decProp);
			decProp.marcarCheckBox();
			decProp.preecherIndicacao("TESTE JADMJR");
			decProp.clickSeguirButton();
		}

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
			enderecoC.setNoDesejoReceberCorrespondnciasCheckboxField();
			enderecoC.clickSeguirButton();
			sel.esperar(1000);
			enderecoC.aceitarTermos();
			enderecoC.clickSeguirModalButton();

		}
	}

	private void preencherCondicoesGerais(WebDriver navegador) {
		if (!navegador.getCurrentUrl().contains("lerosa")) {
			CondicoesGerais condicoes = new CondicoesGerais();
			PageFactory.initElements(navegador, condicoes);
			sel.esperar(600);
			condicoes.aceitar();
			condicoes.clickSeguirButton();
			sel.esperar(1000);
			condicoes.clickBtnSeguirButton();
		}
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
		
		if (sel.navegador.getCurrentUrl().contains("plataforma.lerosa.com.br")) {
			confirmar.selecionarRadio();
			sel.esperar(500);
			                          
		}
		confirmar.enviarToken();

		String token = sel.buscarTokenNoProtonMail(navegador, sel.pegarDataHora());

		confirmar.preencherCampoToken(token);
		confirmar.clickValidarToken();

		sel.esperar(1500);
		confirmar.clickSeguirButton();
	}

	public void run() {

		
		sel = new Selenium();
		sel.inicializar();

		sel.abrirURL(this.ambiente);
		
		try {
			preencherPrimeiraPagina(sel.navegador);
			// ESTUDAR - sel.lerLog(sel.navegador);
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
			preencherDeclaracaoProposito(sel.navegador);
			informarProcuradores(sel.navegador);
			enderecoCorrespondencia(sel.navegador);
			preencherCondicoesGerais(sel.navegador);
			preencherPendencias(sel.navegador);
			confirmarCadastro(sel.navegador);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
