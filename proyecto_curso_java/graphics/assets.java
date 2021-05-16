package proyecto_curso_java.graphics;
import java.awt.image.BufferedImage;


public class assets {

    public static BufferedImage jugador;


    public static void init(){
        jugador = loader.loadImg("/home/xogx/Desktop/java/proyecto_curso_java/recursos/jugador.png");
    }
}
