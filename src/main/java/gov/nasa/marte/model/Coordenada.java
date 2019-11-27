package gov.nasa.marte.model;

public class Coordenada {

    private int x;
    private int y;

    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void incrementX(int val) {
        this.x += val; 
    }

    public void incrementY(int val) {
        this.y += val; 
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj == this) {
            return true;
        } else if (obj instanceof Coordenada 
                    && ((Coordenada)obj).getX() == this.x && ((Coordenada)obj).getY() == this.y) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return x + " " + y;
        //return "{x: " + x + ", y: " + y + "}";
    }
}