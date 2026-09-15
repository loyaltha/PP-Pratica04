# 📚 Sistema de Biblioteca (Prática de POO e Padrão GRASP Indirection)

Este projeto é uma simulação simples de um sistema de biblioteca, desenvolvido como exercício prático para aplicar conceitos fundamentais de Programação Orientada a Objetos (POO) na linguagem Java e introduzir boas práticas de modelagem com o padrão **GRASP Indirection (Indireção)**.

O sistema permite cadastrar livros, gerenciar diferentes tipos de usuários (Alunos e Professores) e simular empréstimos, aplicando regras de negócio específicas para cada tipo de usuário e garantindo o baixo acoplamento entre as entidades principais.

## 🚀 Conceitos Aplicados

O código foi cuidadosamente planejado e escrito para demonstrar a aplicação prática dos seguintes pilares da Orientação a Objetos e Padrões de Projeto:

* **Padrão GRASP (Indirection / Indireção)**: Criação da classe mediadora `Emprestimo` para assumir a responsabilidade de ligar usuários a livros. Isso evita o acoplamento direto entre as entidades, facilitando manutenções e centralizando as regras de transação.
* **Classes e Objetos**: Estruturação de moldes (`Livro`, `Usuario`, `Emprestimo`) e instanciação de objetos.
* **Encapsulamento**: Proteção de dados utilizando modificadores de acesso (`private`, `protected`) e acesso via métodos `Getters` e `Setters`.
* **Construtores**: Inicialização segura dos objetos garantindo as regras de negócio iniciais. Referências com as palavras-chave `this` e `super`.
* **Atributos Estáticos**: Uso de `static` para armazenar informações que pertencem à classe como um todo (Ex: contagem total de livros cadastrados).
* **Associação e Delegação**: O `Usuario` não modifica mais o `Livro` diretamente; ele guarda uma referência ao `Emprestimo` ativo, delegando ao mediador as operações de registrar e finalizar empréstimos.
* **Herança**: Uso da palavra `extends` para criar uma hierarquia onde `Aluno` e `Professor` herdam características da superclasse `Usuario`.
* **Classe Abstrata e Métodos Abstratos**: A classe `Usuario` foi definida como `abstract`, impedindo sua instanciação direta e forçando suas subclasses a implementarem regras de negócio obrigatórias (ex: `obterDiasDevolucao()`).
* **Polimorfismo (Sobrescrita / Overriding)**: Comportamentos distintos herdados — Alunos têm 7 dias para devolução e Professores têm 15 dias.
* **Interfaces**: Uso da palavra `implements` para assinar contratos de comportamento através da interface `Imprimivel`.

## 📁 Estrutura do Projeto

* `Imprimivel.java`: Interface que obriga a implementação do método `imprimirDados()`.
* `Livro.java`: Representa os livros da biblioteca, armazenando título, autor, status de disponibilidade e contabilizando o total de exemplares.
* `Usuario.java`: Superclasse abstrata que define os dados base dos usuários e delega as ações de pegar emprestado e devolver para o mediador.
* `Aluno.java`: Subclasse de Usuário (prazo de 7 dias).
* `Professor.java`: Subclasse de Usuário (prazo de 15 dias).
* `Emprestimo.java`: *(NOVO)* Classe mediadora (Indirection) que gerencia o estado da transação, conectando o Usuário e o Livro.
* `Principal.java`: Classe executável contendo o método `main` para rodar e testar o funcionamento e a nova arquitetura do sistema.

## ⚙️ Como executar

1. Certifique-se de ter o JDK (Java Development Kit) instalado em sua máquina.
2. Abra o terminal e navegue até a raiz do projeto (onde está a pasta `src`).
3. Compile os arquivos Java:
   ```bash
   javac src/biblioteca/*.java
