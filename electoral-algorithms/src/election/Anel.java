package election;

import java.util.ArrayList;
import java.util.Random;

public class Anel {

	private final int adicionar = 3000;
	private final int requisicao = 2500;
	private final int inativo_coordenador = 10000;
	private final int inativo_processo = 8000;

	public static ArrayList<Processo> processosAtivos;
	private final Object lock = new object();

	public Anel() {
		processosAtivos = new ArrayList<Processo>();
	}

	public void criarProcessos() {

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {

					synchronized (lock) {
						if (processosAtivos.isEmpty()) {

							processosAtivos.add(new Processo(1, true));

						} else {
							processosAtivos.add(
									new Processo(processosAtivos.get(processosAtivos.size() - 1).getPid() + 1, false));
						}
						System.out.println("Processo " + processosAtivos.get(processosAtivos.size() - 1).getPid() + 1);
					}
					try {
						Thread.sleep(adicionar);

					} catch (Exception e) {
						e.printStackTrace();
					}

				}

			}

		}).start();
	}

	public void fazRequicao() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(requisicao);
					} catch (Exception e) {
						e.printStackTrace();
					}
					synchronized (lock) {
						if (processosAtivos.size() > 0) {
							int indexProcessoAleatorio = new Random().nextInt(processosAtivos.size());
							Processo processoRequisita = processosAtivos.get(indexProcessoAleatorio);
							System.out.println("Processo " + processoRequisita.getPid() + " Faz requisição");
							processoRequisita.enviarRequisicao();
						}
					}
				}
			}
		}).start();
	}

	public void inativaProcesso() {
		new Thread(new Runnable() {

			public void run() {
				while (true) {
					try {
						Thread.sleep(inativo_processo);
					} catch (Exception e) {
						e.printStackTrace();
					}

					synchronized (lock) {
						if (!processosAtivos.isEmpty()) {
							int indexProcessoAleatorio = new Random().nextInt(processosAtivos.size());
							Processo pRemover = processosAtivos.get(indexProcessoAleatorio);
							if (pRemover != null && !pRemover.isEhCoordenador()) {
								processosAtivos.remove(pRemover);
								System.out.println("Processo " + pRemover.getPid() + " Inativo");
							}
						}
					}
				}
			}
		}).start();
	}

	public void inativaCoordenador() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(inativo_coordenador);
					} catch (Exception e) {
						e.printStackTrace();
					}
					synchronized (lock) {
						Processo coordenador = null;
						for (Processo p : processosAtivos) {
							if (p.isEhCoordenador()) {
								coordenador = p;
							}
						}
						if (coordenador != null) {
							processosAtivos.remove(coordenador);
							System.out.println("Processo Coordenador " + coordenador.getPid() + " Inativado");
						}
					}
				}
			}
		}).start();

	}

}
