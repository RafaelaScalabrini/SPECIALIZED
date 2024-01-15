<html>
# SPECIALIZED
<title>Automação de testes </title>
<p> A IDE de desenvolvimento da automação foi o Intellij, a linguagem de programação da automação foi Java, o designer partner foi
o Page Object, seguindo os padrões de estrutura e as boas práticas de encapsulamento e divisão das classes e organização de código,
para uma melhor reutilização do código, foi criado os  métodos na classe BasePage o click e o select. Utilizei o site do Cucumber para criar a estrutura do projeto. O siste do selenium para especificar os passos básicos e complementar com a organização .</p>
A estrutura geral do código foi em programação orientada a objetos com o encapsulamento dos métodos para uma melhor reutilização do código, as classes (  VehicleDataPage, InsurantDataPage , ProductDataPage,PriceOptionPage,QuotePage) representam as telas e elas herdam da classe 
Base Page.
<p> O mapeamento e organização dos objetos eu utilizei as boas práticas de programação orientada a objetos, o site do cucumber para criar a estrutura do projeto, o site do selenium para esquecificar os passos básicos e complementar com a model e a page object para fazer a organização dos testes com base nas ações e elementos que estão disponíveis nas páginas que representam as telas e herdam da Basepage.</p>
<p> A estrutura do Guerkin utilizada no script eu criei apenas um cenário de teste "Create Quote" e coloquei os passos de preenchimento de todas as páginas no mesmo script do BDD. Criei os hooks para abrir e fechar o chrome, declarei as variáveis para chamar as classes nos passos do BDD e no arquivo de configuração do Maven eu chamei todas as bibliotecas.</p> <br>

Fontes:

https://cucumber.io/docs/guides/10-minute-tutorial/?lang=java < br>
https://www.selenium.dev/documentation/webdriver/getting_started/using_selenium/
https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/
</html>
