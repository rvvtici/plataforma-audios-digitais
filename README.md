# plataforma-audios-digitais
réplica de plataformas de áudios digitais, inspirado nos serviços de streming spotify e deezer. nele, foi utilizado:
  - Swing (Java)
  - JDBC
  - PostgreSQL
  - MVC (Model, View, Controller)

## como rodar
instale o banco de dados PostgreSQL (versão utilizada na aplicação: 16.8) com as seguintes variáveis:
  - port: 5432*
  - nome de admin: postgres*
  - senha: 123*

crie um banco de dados no postgreSQL nomeado "spotify"* com a tabela spotify-tabela.sql  
 *todos os valores são alteráveis, mas é também é necessário mudá-los através de DAO/Conexao.java:

![image](https://github.com/user-attachments/assets/ca31af6c-3160-4413-be3a-e25e2c47383d)

[postgresql-42.7.5.jar](https://jdbc.postgresql.org/download/postgresql-42.7.5.jar) deve estar na pasta Libraries. se não estiver, instale-o

![image](https://github.com/user-attachments/assets/7de234dd-5269-4ad4-adb9-8d635d6e1282)


## funcionalidades da aplicação:
  1. cadastrar novo usuário
  2. login de usuário
  3. buscar músicas por nome, artista, álbum ou gênero & listar informações de músicas buscadas
  4. curtir e descurtir músicas
  5. acessar perfil (excluir perfil e editar dados)
  6. visualizar histórico (visualizar últimas 10 músicas buscadas, lista de músicas curtidas & lista de músicas não curtidas)
  7. gerenciar playlists (criar, editar, excluir playlists | adicionar & remover músicas de playlists)

## cadastrar novo usuário
  para a criar um novo usuário, deve ser inserido nome, usuário e senha.  
  caso o usuário já não tenha sido utilizado, é possível criar a conta:
  
  ![m2Mu9KSz2t](https://github.com/user-attachments/assets/ced04bfe-5a3c-4ee3-b915-d9e8fc6a933b)

  dessa maneira, a conta é registrada no banco de dados.
  após a criação do usuário, a página se redireciona automaticamente à página login.
  na página cadastro, também é possível se redirecionar à página login. 





## login de usuário
após o cadastro, é possível realizar o login.  
nele é necessário o usuário e senha.

![java_f1ayuYiwRm](https://github.com/user-attachments/assets/9e91f673-2364-478b-9053-43971563c140)

ela busca se o usuário existe no banco de dados.
após o login, a página se redireciona automaticamente à página home






## buscar músicas por nome, artista ou gênero & listar informações de músicas buscadas
na página home, é possível fazer as buscas pelas músicas a partir do filtro de nome, artista, álbum ou gênero:

<img src="https://github.com/user-attachments/assets/c944a3fa-cc02-4b1f-9023-b189f8b66c47" width="700"/>

ao obter a busca e o filtro, procura no banco de dados as músicas equivalentes à pesquisa.  
também é possivel se redirecionar às páginas perfil, músicas curtidas, músicas descurtidas, histórico.






## curtir e descurtir músicas

após a busca das músicas, é possível curtir e descurtir as músicas.  
se curtidas, vão à página músicas curtidas.  
caso descurtidas, vão à página músicas descurtidas.

<img src="https://github.com/user-attachments/assets/7ffbaced-d6e9-41ac-8884-9cfc9aa20c0c" width="700" />



## acessar perfil (excluir perfil e editar dados)

na página de perfil, é possível visualizar nome e usuário.
além disso, é possível alterar dados e excluir a conta.

![explorer_sQY8bGPset](https://github.com/user-attachments/assets/f15fb10d-ea80-47b3-91be-ff6333205d0c)

após os dados alterados, o usuário é redirecionado automaticamente à página de perfil.
após a exclusão da conta, o usuário é redirecionado automaticamente à página de login.

## visualizar histórico (visualizar últimas 10 músicas buscadas, lista de músicas curtidas & lista de músicas não curtidas)

é possível acessar o histórico de pesquisas, músicas curtidas e músicas descurtidas:
<img src="https://github.com/user-attachments/assets/ff0389ab-4132-4dc9-a1d3-4cb74b7020d9" width = "700"/>

eles são acessados no banco pelas tabelas liked_songs, unliked_songs & historico.



## gerenciar playlists (criar, editar, excluir playlists | adicionar & remover músicas de playlists)
na página playlist é possível criar, editar e excluir playlists.  
além disso, é possível adicionar e remover músicas da playlist.

criação de uma nova playlist, é necessário de nome de playlist e a descrição é opcional: 

<img src="https://github.com/user-attachments/assets/0beefe7a-7c76-4bfb-b46d-415b377311fe" width="700" />

adição e remoção das músicas na playlist. se faz a partir do id da música:  

<img src="https://github.com/user-attachments/assets/8b8f4391-efab-4a9a-ad86-f5765554ea87" width="700" />

editar nome e descrição da playlist:  

<img src="https://github.com/user-attachments/assets/5049fd96-5cc8-47b0-afe6-47d7d6212837" width="700" />









## créditos:
para adicionar o jbutton à tabela playlist, utilizei o tutorial de [Raven](https://github.com/DJ-Raven/raven-java-swing-tutorial-project/blob/main/LICENSE)
