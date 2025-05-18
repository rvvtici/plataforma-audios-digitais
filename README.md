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
6. gerenciar playlists (criar, editar, excluir playlists | adicionar & remover músicas de playlists)
7. visualizar histórico (visualizar ultimas 10 músicas buscadas I visualizar lista de músicas curtidas | visualizar lista de músicas não curtidas)

## para ser adicionado:
1. login como adm
2. cadastrar e excluir músicas
3. cadastrar artistas
4. consultar usuários
5. visualizar estatísticas do sistema (top 5 músicas curtidas | top 5 músicas não curtidas | total de usuários | total de músicas)

créditos:
para adicionar o jbutton à tabela playlist, utilizei o tutorial de [Raven](https://github.com/DJ-Raven/raven-java-swing-tutorial-project/blob/main/LICENSE)