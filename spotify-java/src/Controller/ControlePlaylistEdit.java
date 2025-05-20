
package Controller;

import DAO.Conexao;
import DAO.PlaylistDAO;
import View.PlaylistEdit;
import View.PlaylistInfo;
import Model.Usuario;
import Model.PlaylistModel;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;

public class ControlePlaylistEdit {
    private PlaylistEdit view;
    private Usuario usuario;
    private PlaylistModel playlist;

    public ControlePlaylistEdit(PlaylistEdit view, Usuario usuario, PlaylistModel playlist) {
        this.view = view;
        this.usuario = usuario;
        this.playlist = playlist;
    }
    
    public ControlePlaylistEdit(PlaylistEdit view, Usuario usuario) {
        this.view = view;
        this.usuario = usuario;
    }
    
    public ControlePlaylistEdit(PlaylistEdit view) {
        this.view = view;
    }
    
    
    
    public void redirectPlaylistInfo(Usuario usuario, PlaylistModel playlist){
        view.setVisible(false);
        PlaylistInfo pi = new PlaylistInfo(usuario, playlist);
        pi.setVisible(true);
    }
    
    public void editarPlaylist(Usuario usuario, PlaylistModel playlist){
        String nome_antigo = playlist.getNome_playlist();
        String descricao_antiga = playlist.getDescricao_playlist();
    
        String novo_nome = view.getTxt_novo_nome().getText();
        String nova_descricao = view.getTxt_nova_descricao().getText();
    
        if (novo_nome.isEmpty()){
            novo_nome = nome_antigo;
        } if (nova_descricao.isEmpty()){
            nova_descricao = descricao_antiga;
        }
    
        int idPlaylist = playlist.getId_playlist();
        
        PlaylistModel playlistAtualizada = new PlaylistModel(idPlaylist, novo_nome, nova_descricao);
        PlaylistModel playlistAntiga = new PlaylistModel(idPlaylist, nome_antigo, descricao_antiga);
        Conexao conexao = new Conexao();

//        System.out.println("playlistatt: " + playlistAtualizada);
//        System.out.println("playlistAntiga: " + playlistAntiga);
//        System.out.println("usuario: " + usuario);
        
        try{
            Connection conn = conexao.getConnection();
            PlaylistDAO dao = new PlaylistDAO(conn);
            dao.atualizarPlaylist(usuario, playlistAtualizada, playlistAntiga);

            JOptionPane.showMessageDialog(view, "Playlist atualizada com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            redirectPlaylistInfo(usuario, playlistAtualizada);

        } catch (SQLException e){
            e.printStackTrace(); // Mostra o erro no console
                JOptionPane.showMessageDialog(view, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
