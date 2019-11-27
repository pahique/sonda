package gov.nasa.marte.model;

public class Planalto {

    private Coordenada limite;

    public Planalto(Coordenada limite) {
        this.limite = limite;
    }

    public Coordenada getLimite() {
        return limite;
    }

    public void setLimite(Coordenada limite) {
        this.limite = limite;
    }

    @Override
    public String toString() {
        return limite.toString();
    }
}