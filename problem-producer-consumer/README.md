## Problema Produtor/Consumidor

<hr> O problema produtor-consumidor é composto basicamente por duas classes, uma responsável por produzir o conteúdo e outra responsável por consumi-lo, semelhante a um rodízio de comidas onde um produtor, cozinheiro, prepara os pratos e os clientes, consumidores, o comem. Um dos possíveis problemas encontrados nesse algorítmo é o consumidor tentar consumir algo que ainda não foi produzido (comer um prato vazio), por isso o desenvolvedor deve tomar cuidado ao implementá-lo para esse fato não ocorrer. Durante estudos que foram feitos sobre a implementação do código também foi notado a possiblidade do produtor gerar dados de mais e esses não serem usados e ficarem ocupando espaço na memória (mais pratos preparados do que os clientes conseguem comer no momento, gera desperdício).

### Uso

<hr>  Uma das implementações do produtor-consumidor é a divisão nas threads responsáveis por ler (consumidor) e salvar (produtor) arquivos ou a movimentação do mouse onde o produtor faz os inputs da movimentação e o consumidor executa elas em tela.

### Implementação

<hr>  A implementação do código em Java possui algumas particularidades como:

  Na classe Produto:
* uso de threads para separar produtor e consumidores;
* uso de métodos synchronized para garantir que os métodos sejam executados em ordem;
* uso de boleanos para indicar quando o dado está pronto para ser consumido;
* uso do método wait (garantir que será esperado o produto ficar pronto) e notifyAll (garantir que todas as threads saibam o estado atual dos produtos gerados/consumidos) para garantir que uma organização extra

```xml

```
