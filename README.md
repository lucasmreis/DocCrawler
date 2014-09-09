DocCrawler
==========

Comandos importantes:
---------------------

`./gradlew setup` (baixa todos as bibliotecas)

`./gradlew clean build`

`./gradlew run -Pargs="twitter randomsubject"`

Próximos passos:
----------------

- Terminar FileStrategy (colocar depth, doc e pdf)


- Testes para TwitterStrategy (mocks?)


- Implementar log (Strategies e PersistenceLayer recebem uma função log(String) como parâmetro)


- Mudar dados de configuração de hard coded para arquivos de configuração 


- Tratar mensagens de erro (retirar print do stacktrace)


- Usar bind no PersistenceLayer para proteger de SQL Injection


- Em paralelo: implementar mais testes unitários / bateria de testes com usuários

