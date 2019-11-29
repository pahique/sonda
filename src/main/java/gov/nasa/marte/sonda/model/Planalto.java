package gov.nasa.marte.sonda.model;

import java.util.ArrayList;
import java.util.List;

public class Planalto {

    protected Coordenada limiteInferior; 
    protected Coordenada limiteSuperior;

    protected List<Sonda> sondas = new ArrayList<Sonda>();
    

    public Planalto(Coordenada limiteSuperior) {
        this.limiteInferior = new Coordenada(0, 0);
        this.limiteSuperior = limiteSuperior;
    }

    public Coordenada getLimiteSuperior() {
        return limiteSuperior;
    }

    public void setLimiteSuperior(Coordenada limiteSuperior) {
        this.limiteSuperior = limiteSuperior;
    }

    public void adicionarSonda(Sonda sonda) {
        if (isCoordenadaValida(sonda.getPosicao())) {
            sonda.setPlanalto(this);
            sondas.add(sonda);
        }
    }

    @Override
    public String toString() {
        return "{limiteSuperior: " + limiteSuperior + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj == this) {
            return true;
        } else if (!(obj instanceof Planalto)) {
            return false;
        }
        Planalto that = (Planalto)obj;
        boolean limiteEquals = (this.limiteSuperior == null && that.getLimiteSuperior() == null) 
                             || (this.limiteSuperior != null && this.limiteSuperior.equals(that.getLimiteSuperior()));
        if (limiteEquals) {
            return true;
        }
        return false;
    }

    public boolean isCoordenadaValida(Coordenada coordenada) {
        boolean result = false;
        if (coordenada != null) {
            int x = coordenada.getX();
            int y = coordenada.getY();
            if (x >= limiteInferior.getX() && y >= limiteInferior.getY() 
                && x <= limiteSuperior.getX() && y <= limiteSuperior.getY()) {
                result = true;
            }
        }
        return result;
    } 
}