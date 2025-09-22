# Projeto 4 com Spring Boot + JPA

Este projeto é uma refatoração de um sistema de vendas que inicialmente usava JDBC, agora com a camada de persistência baseada em **JPA (Java Persistence API)** e **Spring Boot**. A mudança simplifica a gestão de dados, substituindo o código manual do JDBC por interfaces automáticas do **Spring Data JPA**.

### **Tecnologias Utilizadas**

* **Java 17**
* **Spring Boot 3.2.1**
* **Maven**
* **JPA / Hibernate**
* **PostgreSQL**
* **Lombok**

### **Entidades e Relacionamentos**

O projeto simula um sistema de vendas com as seguintes entidades e seus relacionamentos:

* **Cliente**: Entidade que representa o cliente.
* **Produto**: Entidade que representa um produto do catálogo.
* **Venda**: Representa uma transação de venda.
  * Relacionamento **`Many-to-One`** com `Cliente` (uma venda tem um cliente).
  * Relacionamento **`One-to-Many`** com `ProdutoQuantidade` (uma venda pode ter vários produtos).
* **ProdutoQuantidade**: Entidade de junção que registra a quantidade e o valor de um produto em uma venda.
  * Relacionamento **`Many-to-One`** com `Produto` (um item se refere a um produto).
  * Relacionamento **`Many-to-One`** com `Venda` (um item pertence a uma venda específica).

### **Configuração do Ambiente**

1.  **Banco de Dados PostgreSQL**: Crie um banco de dados e configure a conexão no arquivo `application.properties`.
2.  **`application.properties`**:

    ```properties
    # Configuração do PostgreSQL
    spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_seu_banco
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha
    spring.datasource.driver-class-name=org.postgresql.Driver

    # Configuração do JPA/Hibernate
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.format_sql=true
    ```

    *A propriedade `spring.jpa.hibernate.ddl-auto=update` fará com que o Hibernate crie as tabelas automaticamente na primeira execução.*

### **Como Executar o Projeto**

1.  Abra o terminal na pasta raiz do projeto (`projeto-4-jpa`).
2.  Execute o comando do Maven:

    ```bash
    mvn spring-boot:run
    ```

## Contato

Para dúvidas ou sugestões, entre em contato:

*   **Gmail**: lh5818181@gmail.com
*   **GitHub (Profissional)**: [devhenriquejs](https://github.com/devhenriquejs)
*   **GitHub (Estudos)**: [lh5818181](https://github.com/lh5818181)
*   **LinkedIn**: [Luis Henrique Vieira de Oliveira](https://www.linkedin.com/in/luis-henrique-76245231a/)

