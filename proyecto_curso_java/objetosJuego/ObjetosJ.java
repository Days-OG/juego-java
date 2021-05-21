package proyecto_curso_java.objetosJuego;
import proyecto_curso_java.matematica.vectores;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class ObjetosJ {
        protected BufferedImage textura;
        protected vectores posicion;

        public ObjetosJ(vectores posicion, BufferedImage textura)
        {
            this.posicion = posicion;
            this.textura = textura;
        }

        public abstract void actualizar();

        public abstract void draw(Graphics g);

        public vectores getPosicion() {
            return posicion;
        }

        public void setPosicion(vectores posicion) {
            this.posicion = posicion;
        }

        
}
