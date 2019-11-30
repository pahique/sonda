# Projeto Sonda da NASA em Marte

Projeto simples de API Rest, feito em Java utilizando SpringBoot.

## Instruções para execução

 `mvn spring-boot:run`

## Exemplo de utilização da API

### Configurar planalto:

  `curl -X POST -H 'Content-Type: application/json' -d '{"x": 5,"y":5}' http://localhost:8080/planalto`

### Obter dados do planalto:

  `curl -X GET http://localhost:8080/planalto`

### Adicionar sonda:

  `curl -X POST -H 'Content-Type: application/json' -d '{"posicao": {"x": 2,"y":4}, "orientacao": "NORTE"}' http://localhost:8080/sonda`

### Obter dados da sonda:

  `curl -X GET http://localhost:8080/sonda/1`


### Movimentar sonda:

  `curl -X PUT -H 'Content-Type: application/json' -d '["GIRAR_ESQUERDA", "GIRAR_ESQUERDA", "MOVER_FRENTE", "MOVER_FRENTE", "GIRAR_DIREITA"]' http://localhost:8080/sonda/1`



  

  