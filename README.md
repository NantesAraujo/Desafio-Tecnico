# Desafio-Tecnico

# Estruta Do Projeto

![proposta-desafio-tecnico](https://user-images.githubusercontent.com/7785892/79163498-958fc000-7db5-11ea-9b45-1f10126c2533.jpg)

# Projeto API-FAMILIA

Este projeto foi desenvolvido utilizando um Design Patterns Projetos conhecido como SOLID, onde utilizei do conceito de 'Desenvolvimento Orientado a Interfaces'. Neste projeto temos uma classe ```ClassificadorFamiliar``` que possui como atributo uma Lista do tipo interface da seguinte maneita: ``` private List<IRegra> regras ```.

Dessa forma, temo uma interface que terá alguém que a implementa. E para isso deleguei para classe ```Dependente.java``` ```Pretendente.java``` ```RendaFamiliar``` a implementação das regras separadamente pois estas classes implementam a interface ```ClassificadorFamiliar.java``` conforme ilustra a imagem a seguir:

![diagrama](https://user-images.githubusercontent.com/7785892/79059977-5bf47300-7c56-11ea-819d-15a62a85fc91.png)
 
 Assim nosso projeto fica aberto para novas regras caso seja necessário precisando apenas implementar uma nova classe desde que esta implemente a interface ```IRegra```.
 
 A classe ```Classificador.java``` Possui um construtor onde passamos quais regras desejamos utilizar ficando assim:
 ```
 public ClassificadorFamiliar(List<IRegra> regras){
      this.regras = regras;
 }
    
 ```
 
 e também possui um método com nomenclatura ``` public void classifica(Familia familia)  ``` onde invocamos para cada regra a sua implementação através do metodo ```executa ``` que ambas as classes ```Dependente.java``` ```Pretendente.java``` ```RendaFamiliar``` possuem. Ficando assim o método:
 
 ```
 public void classifica(Familia familia){
      regras.forEach(regra -> {
          regra.executa(familia);
      });
  }
 
 ```
 Como invocamos toda essa lógica? Bem, a utilização ficou  dentra da classe ```FamiliaBO.java``` dentro do método ``` cadastrarFamlias ``` da seguinte maneira:
 ```
 public List<Familia> cadastrarFamilias(List<Familia> familias) {
        List<IRegra> listaRegras = Arrays.asList(new Dependente(), new Pretendente(), new RendaFamiliar());

        ClassificadorFamiliar classificadorFamiliar = new ClassificadorFamiliar(listaRegras);

        familias.forEach(familia -> {
            classificadorFamiliar.classifica(familia);
        });

        return familiaRepository.saveAll(familias);
    } 
 ```
 - Onde primeiramente crio um lista de regras das quais quero utilizar. 
 - Depois na criação da Classe ```ClassificadorFamiliar``` passo as minhas regras desejadas. 
 - Logo mais, para cada objeto do tipo ```Familia``` eu chamo o método ```classifica``` que conforme explicado no diagrama a cima, é quem invoca a implementação de cada regra especifíca dentro da classe ```Classificador```.
 
 Estrutura do projeto: A organização da estrutura interna do projeto, separando as responsabilidades ficou da seguinte maneira:
* Controllers:  Camada responsável por receber as requisições e chamar a regras de negócio. Após processada a regra devolver uma resposta ao cliente.

* bo: Camada da aplicação onde foi implementado todas as classes responsáveis pelas regras de negócio.

* model: Camada onde coloquei classes que representam nossos modelos de negócio, como: Entidades, Classes de transferência de dados (DTO)

* Repository: Camada para persistencia das informações no banco de dados.

* Util: Camada reponsável por conter condifcações genericas para o projeto num todo.

* Client: Esta camada na aplicação ficou reponsável por se comunicar com outros serviços como o api-contemplados. Podendo ser utilzada para comunicação com outros serviços também.

# Projeto API-CONTEMPLADOS

Neste projeto também utilizei Design Patterns Projetos SOLID, com o conceito de 'Desenvolvimento Orientado a Interfaces'.
Conforme Ilustra a imagem abaixo:

![grafico 02](https://user-images.githubusercontent.com/7785892/79296408-bd644e00-7eb1-11ea-8f4f-097887e233c1.jpg)

Cirei a classe ```ContemplacaoRegra``` que espera no seu contrutor uma lista de regras que eu desejo utilizar para aplicar a seleção das familias contempladas.

Após definido a instancia da classe ```ContemplacaoRgra``` foi preciso apenas interar entre os objetos recebidos passando-os como parâmetro pra a método ```classificar``` ficando assim a implementação:

```
  List<IRegra> regas = Arrays.asList(new SituacaoCadastral());

  ContemplacaoRegra contemplacaoRegra = new ContemplacaoRegra(regas);

  classificacaoDtoList.forEach(classificacaoDto -> {
      contemplacaoRegra.classificiar(classificacaoDto);
  });
        
```

Primeiro crio as lista de regras que desejo utilizar passando-a depois para o contrutor da classe ```ContemplacaoRegra```.

O atributo 'classificacaoDtoList' é a lista de familias já classificadas no formato DTO (data transfer object) padrão bastante conhecido hoje em dia.

Dentro da classe ```ContemplacaoRegra``` o método ```classifica``` apenas faz um laço no atributo ```regras``` da classe, invocando assim quem as implementas, já que esse atributo é do Tipo List de uma Interface. É neste ponto que a classe ```SituacaoCadastral``` irá ser invocada para aplicar as regras destinadas a ela neste projeto.
Hoje temos apenas uma regra, mais caso suja outras regras, prcecisaremos apenas criar novas ``` classes ``` que implementam a interface ```IRegra```.

Estrutura do projeto: 
A organização da estrutura interna do projeto, separando as responsabilidades ficou da seguinte maneira:
* Controllers:  Camada responsável por receber as requisições e chamar a regras de negócio. Após processada a regra devolver uma resposta ao cliente.

* bo: Camada da aplicação onde foi implementado todas as classes responsáveis pelas regras de negócio.

* model: Camada onde coloquei classes que representam nossos modelos de negócio, como: Entidades, Classes de transferência de dados (DTO)

# Configurações necessário para rodar Projeto

 * Java 8+
 * Maven (versão utilizada 3.5.2
 * Node JS
 * Docker

# Configurando Serviço ElaticSearch

 * Dentro do diretório ```infra``` execute os seguintes comandos:

 ```

  //comando para subir o serviço do elasticSearch
  docker-compose up

  //comando necessario para criar o indice FAMILIAS (correspondente a tabela) no elasticSearch 
  node create-indice-familias.js

  //comando necessario para criar o indice CONTEMPLADOS (correspondente a tabela) no elasticSearch 
  node create-indice-contemplados.js

 ```
