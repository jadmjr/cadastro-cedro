package visao;

import controle.EmbarkAutomato;

public class ThreadTeste {

	public static void main(String[] args) {
		
		EmbarkAutomato e1 = new EmbarkAutomato();
		e1.setEmancipado(false);
		e1.setEstrangeiro(false);
		e1.setGestorDeContas(false);
		e1.setTipoDocumento(1);
		e1.setGestorDeContas(false);
		e1.setMenorDeIdade(false);
		e1.setAmbiente("https://plataforma.lerosa.com.br/cadastro/pre-cadastro");
		
		Thread t1 = new Thread(e1);
	
		
		
		EmbarkAutomato e2 = new EmbarkAutomato();
		e2.setEmancipado(false);
		e2.setEstrangeiro(false);
		e2.setGestorDeContas(false);
		e2.setTipoDocumento(1);
		e2.setGestorDeContas(false);
		e2.setMenorDeIdade(false);
		e2.setAmbiente("https://uat.rbinvestimentos.com/cadastro/pre-cadastro");
		Thread t2 = new Thread(e2);
		
		
		t1.start();
		t2.start();
		
		
		
		
	}

}
