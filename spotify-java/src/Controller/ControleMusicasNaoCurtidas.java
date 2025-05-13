
package Controller;

import Model.Usuario;
import View.MusicasNaoCurtidas;
import View.Home;

public class ControleMusicasNaoCurtidas {
        private MusicasNaoCurtidas view;
        private Usuario usuario;

        public ControleMusicasNaoCurtidas(MusicasNaoCurtidas view, Usuario usuario){
            this.view = view;
            this.usuario = usuario;
        }

        public ControleMusicasNaoCurtidas(MusicasNaoCurtidas view){
            this.view = view;
        }
    
    
    
        public void redirectPaginaHome(Usuario usuario){     
            view.setVisible(false);
            Home h = new Home(usuario);
            h.setVisible(true);
    } 
}
