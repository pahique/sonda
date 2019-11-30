package gov.nasa.marte.sonda.model;

import java.util.Objects;

public class Planalto {

    protected Coordenada limiteInferior; 
    protected Coordenada limiteSuperior;

    public Planalto(Coordenada limiteSuperior) {
        this(new Coordenada(0, 0), limiteSuperior);
    }

    public Planalto(Coordenada limiteInferior, Coordenada limiteSuperior) {
        this.limiteInferior = limiteInferior;
        this.limiteSuperior = limiteSuperior;
    }

    public Coordenada getLimiteInferior() {
        return limiteInferior;
    }

    public void setLimiteInferior(Coordenada limiteInferior) {
        this.limiteInferior = limiteInferior;
    }

    public Coordenada getLimiteSuperior() {
        return limiteSuperior;
    }

    public void setLimiteSuperior(Coordenada limiteSuperior) {
        this.limiteSuperior = limiteSuperior;
    }

    @Override
    public String toString() {
        return "{limiteInferior: " + limiteInferior + ", limiteSuperior: " + limiteSuperior + "}";
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
        boolean limiteInferiorEquals = (this.limiteInferior == null && that.getLimiteInferior() == null) 
                || (this.limiteInferior != null && this.limiteInferior.equals(that.getLimiteInferior()));
        boolean limiteSuperiorEquals = (this.limiteSuperior == null && that.getLimiteSuperior() == null) 
                             || (this.limiteSuperior != null && this.limiteSuperior.equals(that.getLimiteSuperior()));
        if (limiteInferiorEquals && limiteSuperiorEquals) {
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(limiteInferior, limiteSuperior);
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