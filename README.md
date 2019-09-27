<h1><b>Desafio ProJuris,</b></h1>
Olá avaliador! Neste readme irei dividir as informações relevantes em tópicos, o desafio que me foi passado foi:
https://github.com/Scarabe/DesafioProJuris/blob/master/teste_projuris_java.pdf

<h3><b>Como executar o projeto:</b></h3>
  <LI><b>Via Tomcat servlet</b><br>
    Para executar o projeto basta deployar o projeto no Apache Tomcat e faz as calls necessárias.
</UL>

<h3><b>Code coverege e code quality:</b></h3>
Para code coverage, testes unitários, foi considerada apenas classes de serviço, para estas classes o código teve 100% de suas linhas cobertas.
Para code quality foi utilizada a ferramenta <b>codacy</b> apos analyse feita, a ferramenta apontou apenas 2 issues, totalizando 5% de issues no projeto e disponibilizando ao projeto a certificação A.
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/2fa2b9a4e8c7444e90803007db547786)](https://www.codacy.com/manual/Scarabe/DesafioProJuris?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Scarabe/DesafioProJuris&amp;utm_campaign=Badge_Grade)

<h3><b>Testes automatizados:</b></h3>
  <LI><b>Testes unitários</b><br>
    São testes aplicados somente a camada de serviço do projeto.</b>
</UL>
 
<h3><b>Técnologias Utilizadas:</b></h3>
<UL>
  <LI><b>Junit v4.12:</b> Ferramenta utilizada para criação de testes unitários.</LI>
  <LI><b>Rest Assure v2.9.0:</b> Ferramenta de automação de testes em api rest.</LI>
  <LI><b>Maven v4.0:</b> Ferramenta de gerenciamento de dependecias e atuamatização de builds.</LI>
  <LI><b>Intellij v2019.2.2 (Ultimate Edition):</b> IDE de desenvolvimento.</LI>
</UL>

<h3><b>Urls relevantes:</b></h3>
  <LI><b>http://localhost:8080/spot_check</b><br>
    Unica url disponivel no projeto.
</UL>

<h3><b>Considerações finais:</b></h3>
  Faziam alguns anos que não era desafiado com algoritimos complexos como o "matrix island" achei bem interessante e desafiador reproduzilo.
  Com relação a arquitetura e tecnilogias utilizadas, como recomendação do projeto era utilizar apenas JAVAEE tentei ser o mais purista possivel neste quesito, evitando ao maximo utilização de frameworks.
