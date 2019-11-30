package gov.nasa.marte.sonda.model;

import java.util.Objects;

public class Sonda {

	protected Integer id;
    protected Coordenada posicao;
    protected OrientacaoEnum orientacao;

    public Sonda(Integer id, Coordenada posicao, OrientacaoEnum orientacao) {
    	this.id = id;
        this.posicao = posicao;
        this.orientacao = orientacao;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

    @Override
    public String toString() {
        return "{id: " + id + ", posicao: " + posicao + ", orientacao: " + orientacao + "}";
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
        boolean idEquals = (this.id == null && that.getId() == null) || (this.id != null && this.id.equals(that.getId()));
        boolean posicaoEquals = (this.posicao == null && that.getPosicao() == null) || (this.posicao != null && this.posicao.equals(that.getPosicao()));
        boolean orientacaoEquals = (this.orientacao == null && that.getOrientacao() == null) || (this.orientacao != null && this.orientacao.equals(that.getOrientacao()));
        if (idEquals && posicaoEquals && orientacaoEquals) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, posicao, orientacao);
    }

    public void girarEsquerda() {
        if (this.orientacao != null) {
            switch(this.orientacao) {
                case N : this.setOrientacao(OrientacaoEnum.W); break;
                case W : this.setOrientacao(OrientacaoEnum.S); break;
                case S : this.setOrientacao(OrientacaoEnum.E); break;
                case E : this.setOrientacao(OrientacaoEnum.N); break;
            }
        }
    }

    public void girarDireita() {
        if (this.orientacao != null) {
            switch(this.orientacao) {
                case N : this.setOrientacao(OrientacaoEnum.E); break;
                case E : this.setOrientacao(OrientacaoEnum.S); break;
                case S : this.setOrientacao(OrientacaoEnum.W); break;
                case W : this.setOrientacao(OrientacaoEnum.N); break;
            }
        }
    }

    public Coordenada calcularProximaPosicao() {
    	Coordenada novaPosicao = null;
        if (this.posicao != null && this.orientacao != null) {
            novaPosicao = new Coordenada(this.posicao.getX(), this.posicao.getY());
            incrementarPosicao(this.orientacao, novaPosicao);
        }
        return novaPosicao;
    }

    public void moverFrente() {
        if (this.posicao != null && this.orientacao != null) {
        	incrementarPosicao(this.orientacao, this.posicao);
        }
    }
    
    private void incrementarPosicao(OrientacaoEnum orientacao, Coordenada posicao) {
        switch(orientacao) {
        	case N : posicao.addY(1); break;
        	case W : posicao.addX(-1); break;
        	case S : posicao.addY(-1); break;
        	case E : posicao.addX(1); break;
        }        
    }
    
}