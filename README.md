# xpto-systems
[![Build Status](https://travis-ci.org/alexandredavi/xpto-systems.svg?branch=master)](https://travis-ci.org/alexandredavi/xpto-systems)
[![GitHub issues](https://img.shields.io/github/issues/alexandredavi/xpto-systems.svg)](https://github.com/alexandredavi/xpto-systems/issues)
[![GitHub stars](https://img.shields.io/github/stars/alexandredavi/xpto-systems.svg)](https://github.com/alexandredavi/xpto-systems/stargazers)
[![GitHub license](https://img.shields.io/badge/license-MIT-blue.svg)](https://raw.githubusercontent.com/alexandredavi/xpto-systems/master/LICENSE)

Leitura e manutenção de cidades de um arquivo CSV feito com Java

Disponivel aqui: http://xpto.us-east-1.elasticbeanstalk.com/city

# Implementação

Nesse projeto utilizei wildfly-swarm para executar minha aplicação JavaEE com banco relacional PostgreSQL disponibilizado na RDS e criado uma imagem Docker com a aplicação para deploy via Elastic Beanstalk na AWS
**Funcionalidades**:
* Ler o arquivo CSV das cidades para a base de dados **(/import-csv)**
* Retornar somente as cidades que são capitais ordenadas por nome **(capitals)**
* Retornar o nome do estado com a maior e menor quantidade de cidades e a quantidade de cidades **(/states-bigger-and-smaller-number-of-cities)**
* Retornar a quantidade de cidades por estado **(/number-of-cities-by-state)**
* Obter os dados da cidade informando o id do IBGE **(/find-city-by-ibge/{ibge})**
* Retornar o nome das cidades baseado em um estado selecionado **(/find-cities-by-state/{state})**
* Permitir adicionar uma nova Cidade **(POST)**
* Permitir deletar uma cidade **(DELETE /{id})**
* Permitir selecionar uma coluna (do CSV) e através dela entrar com uma string para filtrar. retornar assim todos os objetos que contenham tal string **(/find-cities-by-csv-column/{column}/{filter})**
* Retornar a quantidade de registro baseado em uma coluna. Não deve contar itens iguais **(/count-register-by-column/{column})**
* Retornar a quantidade de registros total **(/count-all)**

# Instalação

Apenas execute
```
mvn wildfly-swarm:run
``` 
na raiz do projeto e tudo estará funcionando
