# Biblioteca API

Uma API RESTful desenvolvida com Spring Boot, voltada para o gerenciamento de livros em uma biblioteca.  
O sistema permite **criar, listar, buscar, atualizar e deletar livros**, utilizando um banco de dados **H2 em memória**.

---

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.5.4**
- **Spring Web**
- **Spring Data JPA**
- **H2 Database**
- **Hibernate Validator (Jakarta Validation)**
- **SpringDoc OpenAPI (Swagger UI)**
- **Lombok**
- **JUnit 5 + Mockito (Testes Unitários)**

---

## Requisitos

Antes de iniciar, precisa ter:

- **Java 17+**
- **Maven 3.9+**
- IDE (IntelliJ, VS Code, Eclipse, etc.)

---

## Como Rodar o Projeto

### Clonar o repositório

```bash
git clone https://github.com/seu-usuario/biblioteca.git
cd biblioteca
```

2. **Compile o projeto:**
   ```bash
   mvn clean install
   ```

3. **Inicie o servidor:**
   ```bash
   mvn spring-boot:run
   ```

4. **Verifique se o serviço está no ar:**  
   Acesse o endpoint, nele você pode testar a aplicação:
   ```
   http://localhost:8080/swagger-ui/index.html#/
   ```
---

## Acesso ao Swagger

Após iniciar o projeto, acesse o **Swagger UI** para testar os endpoints de forma interativa:

 **[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)**


---

