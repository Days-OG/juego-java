package proyecto_curso_java.entradas;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class teclado implements KeyListener {
    
    private boolean[] key = new boolean[256];
    public static boolean UP, LEFT, RIGHT;

    public teclado()
    {
        UP = false;
        LEFT = false;
        RIGHT = false;
    }

    public void actualizar()
    {
        UP = key[KeyEvent.VK_UP];
        LEFT = key[KeyEvent.VK_LEFT];
        RIGHT = key[KeyEvent.VK_RIGHT];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        key[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        key[e.getKeyCode()] = false;

    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    
}
