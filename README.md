# Projeto Sonda da NASA em Marte

Projeto simples de API Rest, feito em Java utilizando SpringBoot.
Classes principais:

* SondaController: Porta de entrada da aplicação via API Rest.

* SondaService: Concentra a logica de negócio e mantem o estado entre cada chamada à API.

* Pacote model: Entidades do sistema, algumas com algumas funcionalidades simples que independem de fatores externos.


## Instruções para execução

Para executar a aplicação:

 `mvn spring-boot:run`
 
Para executar a aplicação carregando um arquivo de entrada inicial e gerando um arquivo de saída. Os dados carregados estarão acessíveis via API:
 
 `mvn spring-boot:run -Dspring-boot.run.arguments=input.txt,output.txt`

 

## Exemplo de utilização da API

### Configurar planalto:

  `curl -X POST -H 'Content-Type: application/json' -d '{"x": 5,"y":5}' http://localhost:8080/api/planalto`

### Obter dados do planalto:

  `curl -X GET http://localhost:8080/api/planalto`

### Adicionar sonda:

  `curl -X POST -H 'Content-Type: application/json' -d '{"posicao": {"x": 2,"y":4}, "orientacao": "N"}' http://localhost:8080/api/sondas`

### Obter dados da sonda:

  `curl -X GET http://localhost:8080/api/sondas/1`

### Obter lista de sondas:

  `curl -X GET http://localhost:8080/api/sondas`

### Movimentar sonda:

  `curl -X PUT -H 'Content-Type: application/json' -d '["L", "L", "M", "M", "R"]' http://localhost:8080/api/sondas/1`



  

  