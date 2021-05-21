package proyecto_curso_java.matematica;

public class vectores {
    private double x,y;
    public vectores(double x, double y)
    {
        this.x = x;
        this.y = y;
    } 

    public vectores()
    {
        x = 0;
        y = 0;
    }

    public double getMagnitude()
    {
        return Math.sqrt(x*x + y*y);
    }

    public vectores setDirection(double angulo)
    {
        return new vectores(Math.cos(angulo)* getMagnitude(), Math.sin(angulo)* getMagnitude());
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
