# Projeto 4 com Spring Boot + JPA

Este projeto é uma refatoração do sistema anterior baseado em JDBC, agora utilizando o framework **Spring Boot** e a especificação **JPA (Java Persistence API)** para a camada de persistência.

A mudança de JDBC para JPA com Spring Boot simplifica a interação com o banco de dados, eliminando o código boilerplate de conexão e as queries SQL manuais. Em vez disso, utilizamos o **Spring Data JPA**, que nos permite definir repositórios de dados através de interfaces, com métodos que o próprio Spring implementa automaticamente.

### Tecnologias

- **Java 17**
- **Spring Boot 3.2.1**
- **Maven**
- **JPA / Hibernate**
- **PostgreSQL**
- **Lombok** (para simplificar as classes de entidade)

### Estrutura do Projeto

- `src/main/java/com/luisjpa/domain`: Contém as classes de entidade (`Cliente`, `Produto`, `Venda`, `ProdutoQuantidade`) mapeadas para as tabelas do banco de dados usando anotações JPA.
- `src/main/java/com/luisjpa/repository`: Interfaces que estendem `JpaRepository`, permitindo operações CRUD (Create, Read, Update, Delete) prontas para uso.
- `src/main/java/com/luisjpa/service`: Camada de serviço que contém a lógica de negócio, utilizando os repositórios.
- `src/main/resources/application.properties`: Arquivo de configuração para a conexão com o banco de dados e propriedades do JPA.
- `pom.xml`: Gerencia as dependências do projeto.

### Modelagem de Dados

O modelo de dados reflete o projeto original e seus relacionamentos:

- `Cliente`: Uma entidade simples.
- `Produto`: Uma entidade simples.
- `Venda`: Tem uma relação **ManyToOne** com `Cliente` (uma venda pertence a um cliente) e uma relação **OneToMany** com `ProdutoQuantidade` (uma venda pode ter vários produtos).
- `ProdutoQuantidade`: Representa um item de venda, com uma relação **ManyToOne** com `Produto` (cada item tem um produto) e uma relação **ManyToOne** com `Venda` (cada item pertence a uma venda).

### Como Executar o Projeto

1.  **Configure o Banco de Dados:** Certifique-se de que o PostgreSQL está instalado e em execução. Crie um banco de dados e ajuste as configurações de `url`, `username` e `password` no arquivo `src/main/resources/application.properties`.

2.  **Execute a Aplicação:**
    - Abra o terminal na pasta raiz do projeto.
    - Execute o comando Maven:
    ```sh
    mvn spring-boot:run
    ```
    O Spring Boot irá iniciar a aplicação, criar as tabelas no banco de dados (graças à propriedade `ddl-auto=update`), e você poderá interagir com a aplicação.

3.  **Execute os Testes Unitários:**
    - Para verificar se tudo está funcionando corretamente, rode os testes:
    ```sh
    mvn test
    ```
    - O resultado deve ser `BUILD SUCCESS`.

Este projeto está pronto para ser enviado ao professor para avaliação.