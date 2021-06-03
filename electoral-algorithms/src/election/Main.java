package election;

public class Main {
	public static void main(String[] agrs) {
		Anel anel = new Anel();
		anel.criarProcessos();
		anel.fazRequisicao();
		anel.inativaCoordenador();
		anel.inativaProcesso();
	}

}
