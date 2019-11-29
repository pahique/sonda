package gov.nasa.marte.sonda.model;

public class Coordenada {

    protected int x;
    protected int y;

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

    public void addX(int val) {
        this.x += val; 
    }

    public void addY(int val) {
        this.y += val; 
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj == this) {
            return true;
        } else if (!(obj instanceof Coordenada)) {
            return false;
        }
        Coordenada that = (Coordenada)obj;
        if (that.getX() == this.x && that.getY() == this.y) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "{x: " + x + ", y: " + y + "}";
    }
}