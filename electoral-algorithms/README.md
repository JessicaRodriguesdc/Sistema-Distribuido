## Algoritmo de eleição

<hr>

### Uso

>  Em geral o algoritmos de eleição tenta localizar o processo com o menor identificador (rank) para ser indicado como líder (ou coordenador).

Anel - É baseado no uso de um anel virtual, mas
sem token. Assumimos que os processos são fisicamente
ou logicamente ordenado de tal forma que cada processo
sabe quem é seu sucessor

### Implementação

* Classe Anel

> Cria Processos

```xml
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

```

> Fazer Requisição

```xml
	public void fazRequisicao() {
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
```

> Inativar Processo

```xml
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
```

> Inativar Coordenador

```xml
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
```
* Classe Processos

> Enviar Requisição

```xml
public boolean enviarRequisicao() {
		boolean resultadoRequisicao = false;
		for (Processo p : Anel.processosAtivos) {
			if (p.isEhCoordenador())
				resultadoRequisicao = p.receberRequisicao(this.pid);
		}
		// Se nao existe um coordenador.
		if (!resultadoRequisicao)
			this.realizarEleicao();

		System.out.println("Fim da Reqisicao");
		return resultadoRequisicao;
	}

```

> Receber Requisição

```xml
	private boolean receberRequisicao(int pidOrigemRequisicao) {
		// Tratamento da Requisicao aqui
		System.out.println("Requisicao do processo " + pidOrigemRequisicao + " recebida com sucesso");
		return true;

	}
```

> Realizar Eleição

```xml
private void realizarEleicao() {
		System.out.println("Processo de eleicao iniciado");
		// Primeira consulta cada processo, adicionando o id de cada um em uma nova
		// lista
		LinkedList<Integer> idProcessosConsultados = new LinkedList<>();
		for (Processo p : Anel.processosAtivos)
			p.consultarProcesso(idProcessosConsultados);
		// Depois percorre a lista de Ids procurado pelo maior
		int idNovoCoordenador = this.getPid();
		for (Integer id : idProcessosConsultados) {
			if (id > idNovoCoordenador)
				idNovoCoordenador = id;
		}
		// Então atualiza o novo coordenador
		boolean resultadoAtualizacao = false;
		resultadoAtualizacao = atualizarCoordenador(idNovoCoordenador);

		if (resultadoAtualizacao)
			System.out.println("Eleica concluida com sucesso. Novo coordenador é :" + idNovoCoordenador);
		else
			System.out.println("A eleicao falhou. Nao foi econtrado um novo coordenador");
	}

```

> Consulta o Processo

```xml
	private void consultarProcesso(LinkedList<Integer> processosConsultados) {
		processosConsultados.add(this.getPid());
	}

```

> Atualiza o Coordenador

```xml
	private boolean atualizarCoordenador(int idNovoCoordenador) {
		// Garante que nao existe nenhum outro processo cadastrado como coordenador
		// Nao ser o novo coordenador
		for (Processo p : Anel.processosAtivos) {
			if (p.getPid() == idNovoCoordenador)
				p.setEhCoordenador(true);
			else
				p.setEhCoordenador(false);

		}
		return true;
	}
```
