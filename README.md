Sistema de Gerenciamento de Biblioteca

Sistema de biblioteca em Java puro (sem frameworks), rodando via terminal, desenvolvido como projeto de estudo para consolidar fundamentos de Java antes de avançar para Spring Boot.

Funcionalidades

. Cadastro de livros e usuários, com validação de duplicidade (ISBN e ID únicos)
. Empréstimo e devolução de livros, com controle automático de estoque
. Listagem de livros, usuários e empréstimos ativos
. Busca de livros por título ou autor (case-insensitive)
. Persistência de dados em arquivos CSV (os dados sobrevivem entre execuções)
. Menu interativo via terminal
. Conceitos aplicados
. Programação orientada a objetos: encapsulamento, herança, interfaces
. Coleções (List, Map) e Streams/lambdas
. Exceções customizadas para representar regras de negócio
. Generics (interface Repositorio<T>)
. Leitura e escrita de arquivos (BufferedReader/BufferedWriter)
. Sobrecarga de construtores

Arquitetura

biblioteca/
├── model/          # Entidades: Livro, Usuario, Emprestimo
├── exception/      # Exceções customizadas de regras de negócio
├── service/        # Lógica de negócio (BibliotecaService)
├── repository/     # Persistência em arquivo (CSV)
└── Main.java       # Menu interativo (ponto de entrada)

Como rodar

1- Clone o repositório
2- Importe como projeto Java no Eclipse (ou IDE de sua preferência)
3- Execute a classe Main.java
4- Os arquivos de dados (livros.txt, usuarios.txt, emprestimos.txt) são criados automaticamente na raiz do projeto

Limitações conhecidas
. Entrada de dados não numérica em campos que esperam números (ex: digitar uma letra na quantidade de cópias) causa erro de execução — tratamento planejado para uma próxima iteração
. Sem interface gráfica (uso via terminal)

Próximos passos

Migração para Spring Boot + Spring Data JPA
API REST substituindo o menu de terminal
Persistência em banco de dados relacional (PostgreSQL)
Testes automatizados (JUnit + Mockito)

Projeto desenvolvido como parte de um plano de estudos para atuação como desenvolvedor Java júnior.