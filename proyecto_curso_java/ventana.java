package proyecto_curso_java;
import javax.swing.JFrame;

import proyecto_curso_java.graphics.assets;

import java.awt.Dimension;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;

public class ventana extends JFrame implements Runnable {
    public static final int WIDTH = 800, HEIGHT = 600;
    private Canvas canvas;
    private Thread hilo;
    private boolean jugando = false;

    private BufferStrategy bs;
    private Graphics g;

    //velocidad del juego  fps
    private final int FPS = 60;
    private double TARGETTIME = 1000000000/FPS;
    private double delta = 0;
    private int AVERAGEFPS = FPS;
    //fin de fps

    // ventana emergente
    public ventana()
    {
        setTitle("juego java");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        canvas = new Canvas();

        canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        canvas.setFocusable(true);

        add(canvas);
    }

    public static void main(String[] args){
        new ventana().start();
    }

    private void actualizar(){

    }

    //fin de ventana----
    // declaracion de dibujos
    private void dibujar(){
        bs = canvas.getBufferStrategy();

        if (bs == null){
            canvas.createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        //empieza dibujo
        g.setColor(Color.BLACK);
		
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		g.drawImage(assets.jugador, 0, 0, null);
		
		g.drawString(""+AVERAGEFPS, 10, 20);


        //termina dibujo----
        g.dispose();
        bs.show();
    }

    private void init()
    {
        assets.init();
    }

    @Override
    public void run() {
        
        long now = 0;
        long lastTime = System.nanoTime();
        int frames = 0;
        long time = 0;

        init();

        while(jugando){
            now = System.nanoTime();
            delta += (now - lastTime)/TARGETTIME;
            lastTime = now;
            if(delta >= 1){
                actualizar();
                dibujar();
                delta --;
                frames ++;
            }    
            if(time >= 1000000000){
                AVERAGEFPS = frames;
                frames = 0;
                time = 0;
            }
        }

        stop();
    }

    private void start(){
        hilo = new Thread(this);
        hilo.start();
        jugando = true;
    }
    private void stop(){
        try {
            hilo.join();
            jugando = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
