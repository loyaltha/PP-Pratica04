# Sistema de Biblioteca - Prática 04 (SOLID - LSP)

Este repositório contém a evolução do sistema de gerenciamento de biblioteca em Java. 

**Objetivo desta prática:** 
Aplicar o **Princípio da Substituição de Liskov (LSP)** do SOLID, garantindo que as subclasses e implementações de interfaces (como `Livro`, `Revista` e a nova `Enciclopedia`) possam ser substituídas sem quebrar o comportamento esperado da aplicação. A arquitetura separa itens de acervo de itens emprestáveis para evitar o lançamento de exceções inesperadas.