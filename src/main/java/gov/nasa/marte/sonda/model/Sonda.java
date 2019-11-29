package gov.nasa.marte.sonda.model;

public class Sonda {

    protected Coordenada posicao;
    protected OrientacaoEnum orientacao;
    protected Planalto planalto;

    public Sonda(Planalto planalto, Coordenada posicao, OrientacaoEnum orientacao) {
        this.planalto = planalto;
        this.posicao = posicao;
        this.orientacao = orientacao;
    }

    public Sonda(Coordenada posicao, OrientacaoEnum orientacao) {
        this.posicao = posicao;
        this.orientacao = orientacao;
    }

    public Coordenada getPosicao() {
		return posicao;
    }
    
	public void setPosicao(Coordenada posicao) {
		this.posicao = posicao;
    }
    
	public OrientacaoEnum getOrientacao() {
		return orientacao;
    }
    
	public void setOrientacao(OrientacaoEnum orientacao) {
		this.orientacao = orientacao;
    }

    public Planalto getPlanalto() {
        return planalto;
    }

    public void setPlanalto(Planalto planalto) {
        this.planalto = planalto;
    }

    @Override
    public String toString() {
        return "{posicao: " + posicao + ", orientacao: " + orientacao + "}";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj == this) {
            return true;
        } else if (!(obj instanceof Sonda)) {
            return false;
        }
        Sonda that = (Sonda)obj;
        boolean posicaoEquals = (this.posicao == null && that.getPosicao() == null) || (this.posicao != null && this.posicao.equals(that.getPosicao()));
        boolean orientacaoEquals = (this.orientacao == null && that.getOrientacao() == null) || (this.orientacao != null && this.orientacao.equals(that.getOrientacao()));
        if (posicaoEquals && orientacaoEquals) {
            return true;
        }
        return false;
    }

    public void girarEsquerda() {
        if (this.orientacao != null) {
            switch(this.orientacao) {
                case NORTE : this.setOrientacao(OrientacaoEnum.OESTE); break;
                case OESTE : this.setOrientacao(OrientacaoEnum.SUL); break;
                case SUL : this.setOrientacao(OrientacaoEnum.LESTE); break;
                case LESTE : this.setOrientacao(OrientacaoEnum.NORTE); break;
            }
        }
    }

    public void girarDireita() {
        if (this.orientacao != null) {
            switch(this.orientacao) {
                case NORTE : this.setOrientacao(OrientacaoEnum.LESTE); break;
                case LESTE : this.setOrientacao(OrientacaoEnum.SUL); break;
                case SUL : this.setOrientacao(OrientacaoEnum.OESTE); break;
                case OESTE : this.setOrientacao(OrientacaoEnum.NORTE); break;
            }
        }
    }

    public void moverFrente() {
        if (this.posicao != null && this.orientacao != null) {
            Coordenada novaPosicao = new Coordenada(this.posicao.getX(), this.posicao.getY());
            switch(this.orientacao) {
                case NORTE : novaPosicao.addY(1); break;
                case OESTE : novaPosicao.addX(-1); break;
                case SUL : novaPosicao.addY(-1); break;
                case LESTE : novaPosicao.addX(1); break;
            }        
            if (planalto != null && planalto.isCoordenadaValida(novaPosicao)) {
                this.setPosicao(novaPosicao);
            } 
        }
    }

}