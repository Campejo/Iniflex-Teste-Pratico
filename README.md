# Gerenciamento de Funcionários

Este é um projeto Java que realiza diversas operações de gerenciamento de funcionários, incluindo cadastro, remoção, aumento de salário, agrupação por função, ordenação e cálculo de idade e salário médio.

## Estrutura do Projeto

O projeto contém as seguintes classes:

- **Principal.java**: Classe principal que executa as operações de gerenciamento dos funcionários.
- **Funcionario.java**: Representa um funcionário e herda atributos de "Pessoa".
- **Pessoa.java**: Classe base que representa uma pessoa com nome e data de nascimento.

## Funcionalidades

1. **Cadastro de Funcionários**: Insere uma lista de funcionários com nome, data de nascimento, salário e função.
2. **Remoção de Funcionários**: Remove um funcionário específico da lista.
3. **Exibição da Lista de Funcionários**: Imprime os detalhes de todos os funcionários.
4. **Ajuste Salarial**: Aplica um aumento de 10% ao salário de todos os funcionários.
5. **Agrupamento por Função**: Organiza os funcionários por sua função em um mapa.
6. **Filtragem por Data de Aniversário**: Lista os funcionários que fazem aniversário em outubro ou dezembro.
7. **Identifica o Funcionário Mais Velho**: Determina o funcionário de maior idade.
8. **Ordenação Alfabética**: Ordena e exibe os funcionários em ordem alfabética.
9. **Cálculo do Total dos Salários**: Soma e exibe o total dos salários de todos os funcionários.
10. **Comparativo com o Salário Mínimo**: Calcula quantos salários mínimos cada funcionário recebe.

## Tecnologias Utilizadas

- **Java SE 8+**
- **API de Data e Hora (java.time)**
- **BigDecimal para operações financeiras**
- **Coleções Java (List, Map, Iterator)**

## Como Executar o Projeto

1. Clone o repositório ou baixe os arquivos.
2. Compile os arquivos `.java` utilizando um compilador Java:
   ```sh
   javac Principal.java Funcionario.java Pessoa.java
   ```
3. Execute a classe principal:
   ```sh
   java Principal
   ```
---
