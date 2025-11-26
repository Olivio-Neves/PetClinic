Visão Geral
O projeto ClinicaPetApplication consiste em uma aplicação backend desenvolvida em Java utilizando o framework Spring Boot versão 3.5.8. A aplicação segue a arquitetura tradicional de camadas, composta por camadas de apresentação, serviço e persistência. O objetivo principal é fornecer uma API RESTful para gerenciamento de informações relacionadas a uma clínica veterinária, incluindo cadastro e gerenciamento de clientes e animais de estimação. O projeto utiliza o banco de dados em memória H2 para fins de desenvolvimento e teste, garantindo facilidade de execução e isolamento de dados durante o ciclo de vida da aplicação.
A aplicação é construída de forma modular, permitindo fácil manutenção, escalabilidade e futura integração com um frontend ou com sistemas externos. Todas as dependências são gerenciadas por Maven, garantindo consistência entre ambientes de desenvolvimento, teste e produção. A aplicação é executável como um JAR autônomo ou diretamente a partir da IDE.

















O projeto segue a seguinte estrutura de diretórios:
clinica-pet/
│
├─ src/main/java/br/com/clinicapet/clinica_pet/
│   ├─ ClinicaPetApplication.java          Arquivo principal que inicializa o Spring Boot
│   ├─ model/                              Pacote contendo entidades JPA
│   │   ├─ Pet.java                        Entidade representando animais de estimação
│   │   └─ Client.java                     Entidade representando clientes da clínica
│   ├─ repository/                         Pacote contendo interfaces de repositórios JPA
│   │   ├─ PetRepository.java              Interface para persistência de dados de animais
│   │   └─ ClientRepository.java           Interface para persistência de dados de clientes
│   └─ controller/                         Pacote contendo controladores REST
│       ├─ PetController.java              Controlador REST para endpoints relacionados a pets
│       └─ ClientController.java           Controlador REST para endpoints relacionados a clientes
│
├─ src/main/resources/
│   ├─ application.properties              Arquivo de configuração do Spring Boot
│   └─ data.sql                             Script opcional para populamento inicial do banco
│
└─ pom.xml                                 Arquivo de configuração Maven contendo dependências do projeto




Dependências Principais
As principais dependências do projeto são:
Spring Boot Starter Web: Fornece suporte para criação de APIs RESTful, incluindo servidor Tomcat embutido e suporte a serialização e desserialização JSON.
Spring Boot Starter Data JPA: Fornece integração com Java Persistence API utilizando Hibernate como provedor de persistência, permitindo operações CRUD e consultas complexas.
H2 Database: Banco de dados relacional em memória utilizado para desenvolvimento e testes. Permite execução rápida sem configuração de servidor externo.
Lombok: Biblioteca que reduz código boilerplate, gerando automaticamente getters, setters, construtores, equals, hashCode e toString em tempo de compilação.
Spring Boot Starter Logging: Configuração padrão de logging, utilizando Logback e integração com SLF4J.
Spring Boot Starter JSON: Suporte para processamento de JSON, incluindo módulos Jackson para serialização e desserialização.
Spring Boot Starter JDBC: Suporte a operações JDBC diretas, pool de conexões com HikariCP e integração com JPA.










Banco de Dados
A aplicação utiliza o banco de dados H2 em memória, configurado no arquivo application.properties. As informações de conexão são as seguintes:
URL de conexão JDBC: jdbc:h2:mem:clinica
Usuário: SA
Senha: (em branco)
O H2 Console está disponível em /h2-console para visualização e testes das tabelas criadas automaticamente pelo JPA. O banco de dados é inicializado automaticamente na inicialização da aplicação e não persiste dados entre reinicializações, sendo adequado para desenvolvimento e testes.
As tabelas são criadas automaticamente a partir das entidades JPA anotadas com @Entity. As colunas são derivadas das propriedades das classes, podendo ser customizadas com anotações como @Column, @Id, @GeneratedValue e @Temporal. Relacionamentos entre entidades são definidos utilizando anotações @OneToMany, @ManyToOne e @ManyToMany quando necessário.
Entidades Principais
Pet
A entidade Pet representa os animais de estimação cadastrados na clínica. Possui os seguintes atributos principais:
id: Identificador único do pet, do tipo Long, gerado automaticamente pelo banco de dados.
name: Nome do pet, do tipo String, obrigatório.
species: Espécie do animal, do tipo String, obrigatório.
breed: Raça do animal, do tipo String, opcional.
age: Idade do pet, do tipo Integer, opcional.
owner: Referência ao cliente proprietário do pet, representada por uma associação ManyToOne com a entidade Client.



Client
A entidade Client representa os clientes da clínica. Possui os seguintes atributos principais:
id: Identificador único do cliente, do tipo Long, gerado automaticamente pelo banco de dados.
name: Nome completo do cliente, do tipo String, obrigatório.
email: Endereço de e-mail do cliente, do tipo String, obrigatório e único.
phone: Número de telefone do cliente, do tipo String, opcional.
pets: Lista de pets do cliente, representada por uma associação OneToMany com a entidade Pet.

Repositórios
PetRepository
Interface que estende JpaRepository, fornecendo métodos padrão para operações CRUD em pets, incluindo findAll(), findById(), save() e deleteById(). Permite também definir métodos customizados utilizando convenções de nomenclatura do Spring Data JPA.
ClientRepository
Interface que estende JpaRepository, fornecendo métodos padrão para operações CRUD em clientes, incluindo findAll(), findById(), save() e deleteById(). Permite também métodos customizados baseados em propriedades da entidade, como findByEmail(String email).








Controladores REST
PetController
Controlador responsável por gerenciar endpoints relacionados a pets. Os endpoints disponíveis são:
GET /pets: Retorna a lista de todos os pets cadastrados.
GET /pets/{id}: Retorna os detalhes de um pet específico pelo identificador.
POST /pets: Cria um novo pet com os dados fornecidos no corpo da requisição em formato JSON.
PUT /pets/{id}: Atualiza os dados de um pet existente identificado pelo id.
DELETE /pets/{id}: Remove o pet identificado pelo id do banco de dados.
ClientController
Controlador responsável por gerenciar endpoints relacionados a clientes. Os endpoints disponíveis são:
GET /clients: Retorna a lista de todos os clientes cadastrados.
GET /clients/{id}: Retorna os detalhes de um cliente específico pelo identificador.
POST /clients: Cria um novo cliente com os dados fornecidos no corpo da requisição em formato JSON.
PUT /clients/{id}: Atualiza os dados de um cliente existente identificado pelo id.
DELETE /clients/{id}: Remove o cliente identificado pelo id do banco de dados.







Configuração da Aplicação
O arquivo application.properties contém configurações essenciais para o funcionamento do Spring Boot, incluindo:
server.port=8080
spring.datasource.url=jdbc:h2:mem:clinica
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=SA
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
Inicialização da Aplicação
A classe ClinicaPetApplication contém o método main que inicializa o Spring Boot. A execução pode ser realizada diretamente na IDE ou via linha de comando. Para executar via Maven, utilizar os comandos:
mvn clean install
mvn spring-boot:run
Ao iniciar, o Spring Boot configura automaticamente o contexto da aplicação, inicializa o servidor Tomcat embutido na porta 8080, cria as tabelas do banco de dados e registra os controladores e repositórios no contexto do Spring.




Testes e Verificação
Após iniciar a aplicação, é possível testar os endpoints utilizando ferramentas como Postman, Insomnia ou cURL. Exemplos de requisições:
GET http://localhost:8080/pets
POST http://localhost:8080/pets
Conteúdo JSON:
{
"name": "Fido",
"species": "Cachorro",
"breed": "Labrador",
"age": 3,
"ownerId": 1
}
GET http://localhost:8080/clients
POST http://localhost:8080/clients
Conteúdo JSON:
{
"name": "João Silva",
"email": "joao.silva@email.com",
"phone": "11999999999"
}
O H2 Console pode ser acessado para verificação direta das tabelas e dados persistidos.
Observações Técnicas
A aplicação foi projetada para ser modular, facilitando futura implementação de camadas de serviço e integração com frontends. O uso de Spring Data JPA permite abstrair o acesso a banco de dados, reduzindo código repetitivo e garantindo maior produtividade. O H2 em memória proporciona rápida execução de testes sem necessidade de configuração de banco externo. A aplicação utiliza convenções do Spring Boot para configuração automática, logging detalhado e inicialização de contexto, garantindo boas práticas de desenvolvimento.
