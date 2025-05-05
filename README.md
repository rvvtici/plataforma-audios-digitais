# spotify-java

réplica plataforma de áudios digitais utilizando Swing (Java) + JDBC PostgreSQL + MVC (Model, View, Controller)
conexão java-banco de dados escrita primeiramente em MER

## como rodar
deve ser instalado o postgresql (versão utilizada na aplicação: 16.8), com port em 5432*, nome de admin "postgres"*, senha "123"*
crie um banco de dados nomeado "spotify"* com a spotify-tabela.sql
*nomes alteráveis através de DAO/Conexao.java
postgresql-42.7.5.jar deve estar em Libraries

## funcionalidades:
1. cadastrar novo usuário
2. login de usuário
3. buscar músicas por nome, artista ou gênero
4. listar informações de músicas buscadas
5. curtir e descurtir músicas
6. gerenciar playlists
6.1 criar, editar, excluir playlists
6.2 adicionar & remover músicas de playlists
7. visualizar histórico
7.1 visualizar ultimas 10 músicas buscadas
7.2 visualizar lista de músicas curtidas
7.3 visualizar lista de músicas não curtidas

adicionais:
8. login como adm
9. cadastrar e excluir músicas
10. cadastrar artistas
11. consultar usuários
12. visualizar estatísticas do sistema
12.1 top 5 músicas curtidas
12.2 top 5 músicas não curtidas
12.3 total de usuários
12.4 total de músicas
