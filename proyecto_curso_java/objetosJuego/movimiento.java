package proyecto_curso_java.objetosJuego;

import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;

import proyecto_curso_java.matematica.vectores;

public abstract class movimiento extends ObjetosJ {

    protected vectores velocidad;
    protected AffineTransform at;
    protected double angulo;

    public movimiento(vectores posicion, vectores velocidad, BufferedImage textura) {
        super(posicion, textura);
        this.velocidad = velocidad;
        angulo = 0;
    }

}
