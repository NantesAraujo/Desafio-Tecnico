# Desafio-Tecnico

### Estruta Do Projeto

![proposta-desafio-tecnico](https://user-images.githubusercontent.com/7785892/79163498-958fc000-7db5-11ea-9b45-1f10126c2533.jpg)

Este projeto foi desenvolvido utilizando um padrão de projeto SOLID onde temos uma classe ```ClassificadorFamiliar``` que possui como atributo uma interface como lista da seguinte maneita: ``` private List<IRegra> regras ```.

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
 - Logo mais, para cada objeto do tipo ```Familia``` eu chamo o método ```Classificada``` que conforme explicado logo acima, é quem invoca a implementação de cada regra especifíca dentro da classe ```Classificador```.
