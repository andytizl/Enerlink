# Etapa 1: Compilação (Build) usando o Maven
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app
# Copia os arquivos de dependência e o código-fonte
COPY pom.xml .
COPY src ./src
# Compila o projeto e gera o arquivo .jar (ignorando os testes para ser mais rápido)
RUN mvn clean package -DskipTests

# Etapa 2: Execução (Run) usando apenas o Java (deixa a imagem mais leve)
FROM eclipse-temurin:17-jre
WORKDIR /app
# Copia o arquivo .jar gerado na etapa anterior
COPY --from=build /app/target/*.jar app.jar
# Expõe a porta que a API vai usar
EXPOSE 8080
# Comando para iniciar o servidor
ENTRYPOINT ["java", "-jar", "app.jar"]