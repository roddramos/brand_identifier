# Brand Identifier

Ao precisar criar um idenfiticador de bandeira de cartão e depois de algumas pesquisas 
percebi que existem poucas soluções e nenhum caso encontrei soluções em JAVA.

Então criei essa API para centralizar as identificações das bandeiras e atualizações 
futuras.

Nesse solução estou utilizando:
* Quarkus 0.19.1
* Java 11

Aberto a Pull Request


## Para compilar / executar a API

```
./mvnw compile quarkus:dev
```

## Para executar os Tests Unitarios

```
mvn test
```

## Docker
Na pasta src/main/docker/ existem informações para rodar com Docker.
