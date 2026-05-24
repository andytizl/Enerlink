# Enerlink - Marketplace de Consultoria em Energia Limpa

## Sobre o Projeto
O **Enerlink** é um Sistema Web inovador desenvolvido como um marketplace para conectar empresas que procuram adequar-se a práticas sustentáveis a consultores especializados em energias renováveis e transição energética. O foco central da plataforma é mitigar o impacto ambiental corporativo e auxiliar as organizações no alinhamento com os **Objetivos de Desenvolvimento Sustentável (ODS)** da Organização das Nações Unidas (ONU).

Este repositório contém o código-fonte do **Back-end** da aplicação, desenvolvido sob a arquitetura de uma **API RESTful** em Java com Spring Boot. O sistema utiliza o padrão de desenvolvimento em camadas (*Models*, *Repositories*, *Services* e *Controllers*) para garantir alta escalabilidade, separação de responsabilidades e facilidade de manutenção. A API gerencia de forma segura o ciclo de vida dos dados, controlando cadastros de utilizadores, perfis de empresas e consultores, além do fluxo de publicação de projetos e submissão de propostas de consultoria.

## Tecnologias Utilizadas
* **Linguagem Principal:** Java 17
* **Framework Core:** Spring Boot 3.x
  * *Spring Web:* Criação de endpoints RESTful e gestão de requisições HTTP.
  * *Spring Data JPA:* Mapeamento objeto-relacional (ORM) e persistência de dados automatizada.
* **Banco de Dados:** MySQL 8.0 (Contentorizado via Docker)
* **Contentorização e Orquestração:** Docker & Docker Compose
* **Gerenciador de Dependências:** Maven
* **Documentação Interativa:** Swagger UI / Springdoc OpenAPI
* **Produtividade:** Lombok

## Instruções para Execução Local (Via Docker Compose)

Com a inclusão do ambiente contentorizado, já não é necessário configurar o banco de dados local manualmente ou compilar o projeto através da IDE. Todo o ecossistema (API Spring Boot + Banco de Dados MySQL) é construído e iniciado automaticamente.

### Pré-requisitos
Antes de iniciar, certifique-se de ter instalado na sua máquina:
1. O **Docker** instalado e em execução.
2. O **Docker Compose** habilitado.

### Passo a Passo para Execução

1. **Clonar o Repositório e Acessar a Pasta:**
   Abra o terminal da sua máquina, faça o clone do projeto e entre na pasta `demo` (onde os arquivos de configuração do Docker estão localizados):
   ```bash
   git clone [https://github.com/andytizl/Enerlink.git](https://github.com/andytizl/Enerlink.git)
   cd Enerlink/demo
   ```

2. **Configurar as Variáveis de Ambiente:**
Antes de rodar a aplicação, é necessário configurar as suas credenciais. Na pasta `demo`, crie um arquivo chamado `.env`. Você deve fazer isso copiando o arquivo `.env.example` que já está no repositório e preenchendo-o com as suas credenciais locais de banco de dados.
3. **Compilar e Iniciar a Solução:**
Ainda dentro da pasta `demo` (e com o arquivo `.env` configurado), execute o comando abaixo. Ele fará o build da aplicação e subirá os contentores em segundo plano (modo detached):
```bash
docker compose up -d --build
```

*Nota: Este processo pode demorar alguns minutos na primeira execução.*
4. **Testar e Validar os Endpoints (Swagger):**
Com os contentores ativos, abra o seu navegador de preferência e acesse a interface gráfica do Swagger através do link abaixo para testar a aplicação:
[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
A partir desta página, você poderá testar visualmente todas as operações de criação, leitura e remoção (GET, POST, DELETE) para os módulos de Utilizadores, Empresas, Consultores, Projetos e Propostas.

## 👥 Integrantes do Grupo

* **Andressa Tizl Americo** - RA: 252295
* **Isabela Reis Alves** - RA: 252222
* **Guilherme Henrique Moraes da Silva** - RA: 252150
* **Gabriel Oliveira Cenciati** - RA: 235858
* **Kauan Soares da Silva Mello** - RA: 240269
* **Vinicios Henrique Franco Joya** - RA: 240251
