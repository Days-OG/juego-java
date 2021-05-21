package proyecto_curso_java.objetosJuego;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import proyecto_curso_java.entradas.teclado;
import proyecto_curso_java.graphics.assets;
import proyecto_curso_java.matematica.vectores;

public class jugador extends movimiento {

    private vectores direccion;
    

    public jugador(vectores posicion, vectores velocidad, BufferedImage textura) {
        super(posicion, velocidad, textura);
        direccion = new vectores(0, 1);
    }

    @Override
    public void actualizar() {
        if(teclado.RIGHT)
        angulo += Math.PI/10;
        if(teclado.LEFT)
        angulo -= Math.PI/10;
       direccion = direccion.setDirection(angulo - Math.PI/2);
        
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        at = AffineTransform.getTranslateInstance(posicion.getX(), posicion.getY());
        at.rotate(angulo, assets.jugador.getWidth()/2, assets.jugador.getHeight()/2);
        g2d.drawImage(assets.jugador, at, null);
        //g.drawImage(textura, (int)posicion.getX(), (int)posicion.getY(), null);
    }
    
}
