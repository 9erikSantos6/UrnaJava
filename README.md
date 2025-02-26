# UrnaJava

Este projeto simula um sistema de votação eletrônico, onde eleitores podem votar em candidatos para diferentes cargos em eleições locais e gerais. Uma simulação de urna eletrônica brasileira desenvolvida em Java. O projeto tem como objetivo fornecer uma plataforma para entender o funcionamento das urnas eletrônicas utilizadas nas eleições brasileiras, permitindo a simulação de votações e a visualização dos resultados.

## Estrutura do Projeto

A estrutura do projeto é organizada da seguinte forma:

```
src/
└── br/
    └── ifpi/
        └── eleicao/
            ├── app/
            │   ├── App.java
            │   └── Demo.java
            ├── candidato/
            │   ├── titular/
            │   │   ├── DeputadoEstadual.java
            │   │   ├── DeputadoFederal.java
            │   │   ├── Governador.java
            │   │   ├── Prefeito.java
            │   │   ├── Presidente.java
            │   │   ├── Senador.java
            │   │   └── Vereador.java
            │   └── vice/
            │       ├── ViceGovernador.java
            │       ├── VicePrefeito.java
            │       └── VicePresidente.java
            ├── db/
            │   ├── DatabaseConnection.java
            │   ├── eleitor/
            │   │   ├── EleitorDAO.java
            │   │   └── TituloDAO.java
            │   └── README.MD
            ├── eleitor/
            │   ├── Eleitor.java
            │   └── Titulo.java
            ├── partido/
            │   └── Partido.java
            ├── secao/
            │   ├── Secao.java
            │   └── Urna.java
            └── shared/
                ├── interfaces/
                │   └── candidato/
                │       └── IViceAssociado.java
                ├── models/
                │   └── candidato/
                │       ├── Candidato.java
                │       ├── CandidatoTitular.java
                │       └── ViceCandidato.java
                └── utils/
                    ├── candidato/
                    │   ├── Candidato.java
                    │   ├── TipoCandidato.java
                    │   └── TipoInformacaoCandidato.java
                    ├── eleicao/
                    │   ├── CadastroEleicao.java
                    │   ├── TipoEleicao.java
                    │   └── TipoLocalizacao.java
                    ├── eleitor/
                    │   └── Eleitor.java
                    └── urna/
                        └── TipoVoto.java
```
## Funcionalidades

- **Simulação de Votação**: Permite que os usuários simulem o processo de votação para diferentes cargos, incluindo Governador, Prefeito e Presidente.
- **Gerenciamento de Candidatos**: Inclui classes para gerenciar candidatos titulares e vices, bem como partidos políticos.
- **Interface**: ( ainda não comlpetamente implementada ).

## Pré-requisitos

- Java 21 ou superior instalado no seu sistema. Você pode verificar a versão instalada com o seguinte comando:

```bash
java --version
```


## Como Executar

1. Compile o projeto utilizando um compilador Java.
2. Execute a classe principal `App.java` ou `Demo.java` para iniciar o sistema de votação.


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
# ou 
javac br/ifpi/urna/app/Demo.java
```

## Uso

Para executar a aplicação, use o seguinte comando:

```bash
java br.ifpi.urna.app.App

# ou

java br.ifpi.urna.app.Demo
```

## Descrição dos Principais Componentes

### Pacote `app`

- **App.java**: Classe principal que executa o sistema de votação.
- **Demo.java**: Classe de demonstração para simular uma eleição.

### Pacote `candidato`

- **titular**: Contém classes para diferentes tipos de candidatos titulares (Prefeito, Governador, Presidente, etc.).
- **vice**: Contém classes para diferentes tipos de candidatos a vice (VicePrefeito, ViceGovernador, VicePresidente).

### Pacote `db`

- **Base de dados**: Ainda não implementado.
- **DatabaseConnection.java**: Classe para gerenciar a conexão com o banco de dados.
- **eleitor**: Contém classes DAO para gerenciar eleitores e títulos de eleitor.

### Pacote `eleitor`

- **Eleitor.java**: Classe que representa um eleitor.
- **Titulo.java**: Classe que representa um título de eleitor.

### Pacote `partido`

- **Partido.java**: Classe que representa um partido político.

### Pacote `secao`

- **Secao.java**: Classe que representa uma seção eleitoral.
- **Urna.java**: Classe que representa uma urna eletrônica.

### Pacote `shared`

- **interfaces**: Contém interfaces compartilhadas entre diferentes pacotes.
- **models**: Contém classes de modelos compartilhados.
- **utils**: Contém classes utilitárias para candidatos, eleições, eleitores e urnas.

## Contribuição

Sinta-se à vontade para contribuir com melhorias e novas funcionalidades para este projeto. Faça um fork do repositório, crie uma branch para suas alterações e envie um pull request.

## Licença

Este projeto está licenciado sob a licença MIT. Veja o arquivo [LICENSE](./LICENSE) para mais detalhes.
