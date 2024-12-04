# UrnaJava

UrnaJava é uma simulação de urna eletrônica brasileira desenvolvida em Java. O projeto tem como objetivo fornecer uma plataforma para entender o funcionamento das urnas eletrônicas utilizadas nas eleições brasileiras, permitindo a simulação de votações e a visualização dos resultados.

## Estrutura do Projeto

A estrutura do projeto é organizada da seguinte forma:

```
UrnaJava/
┣ src/
┃ ┗ br/
┃   ┗ ifpi/
┃     ┗ urna/
┃       ┣ app/
┃       ┃ ┗ App.java
┃       ┣ candidato/
┃       ┃ ┣ titular/
┃       ┃ ┃ ┣ Governador.java
┃       ┃ ┃ ┣ Prefeito.java
┃       ┃ ┃ ┗ Presidente.java
┃       ┃ ┗ vice/
┃       ┃   ┣ ViceGovernador.java
┃       ┃   ┣ VicePrefeito.java
┃       ┃   ┗ VicePresidente.java
┃       ┣ partido/
┃       ┃ ┗ Partido.java
┃       ┗ shared/
┃         ┣ interfaces/
┃         ┃ ┗ candidato/
┃         ┃   ┗ IViceAssociado.java
┃         ┗ models/
┃           ┗ candidato/
┃             ┣ Candidato.java
┃             ┣ CandidatoTitular.java
┃             ┗ ViceCandidato.java
┣ .editorconfig
┣ .gitignore
┗ README.md
```

## Funcionalidades

- **Simulação de Votação**: Permite que os usuários simulem o processo de votação para diferentes cargos, incluindo Governador, Prefeito e Presidente.
- **Gerenciamento de Candidatos**: Inclui classes para gerenciar candidatos titulares e vices, bem como partidos políticos.
- **Interface**: ( ainda não implementada ).

## Pré-requisitos

- Java 21 ou superior instalado no seu sistema. Você pode verificar a versão instalada com o seguinte comando:

```bash
java -version
```

## Instalação

1. Clone o repositório:

```bash
git clone https://github.com/9erikSantos6/UrnaJava.git
```

2. Navegue até o diretório do projeto:

```bash
cd UrnaJava/src
```

3. Compile o projeto:

```bash
javac br/ifpi/urna/app/App.java
```

## Uso

Para executar a aplicação, use o seguinte comando:

```bash
java br.ifpi.urna.app.App
```

Siga as instruções na tela para realizar a simulação da votação.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).

## Contato

Para mais informações, entre em contato com [9xerikx6@gmail.com](mailto:9xerikx6@gmail.com).

---

Agradecemos por conferir o UrnaJava! Esperamos que você encontre este projeto útil e educativo.