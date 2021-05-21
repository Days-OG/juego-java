package proyecto_curso_java.eventos;
import java.awt.Graphics;

import proyecto_curso_java.objetosJuego.jugador;
import proyecto_curso_java.graphics.assets;
import proyecto_curso_java.matematica.vectores;


public class juego {
    
    private jugador jugador;

    public juego()
    {
        jugador  = new jugador(new vectores(100, 500), new vectores(), assets.jugador);

    }

    public void actualizar(){
        jugador.actualizar();

    }
    
    public void draw(Graphics g)
    {
        jugador.draw(g);
    }
}

