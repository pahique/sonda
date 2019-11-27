package gov.nasa.marte.model;

public class Sonda {

    private Coordenada posicao;
    private OrientacaoEnum orientacao;

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

    @Override
    public String toString() {
        return posicao + " " + orientacao;
    }
    
    public void girarEsquerda() {
        switch(this.orientacao) {
            case NORTE : this.setOrientacao(OrientacaoEnum.OESTE); break;
            case OESTE : this.setOrientacao(OrientacaoEnum.SUL); break;
            case SUL : this.setOrientacao(OrientacaoEnum.LESTE); break;
            case LESTE : this.setOrientacao(OrientacaoEnum.NORTE); break;
        }
    }

    public void girarDireita() {
        switch(this.orientacao) {
            case NORTE : this.setOrientacao(OrientacaoEnum.LESTE); break;
            case LESTE : this.setOrientacao(OrientacaoEnum.SUL); break;
            case SUL : this.setOrientacao(OrientacaoEnum.OESTE); break;
            case OESTE : this.setOrientacao(OrientacaoEnum.NORTE); break;
        }
    }

    public void mover() {
        switch(this.orientacao) {
            case NORTE : this.getPosicao().incrementY(1); break;
            case OESTE : this.getPosicao().incrementX(-1); break;
            case SUL : this.getPosicao().incrementY(-1); break;
            case LESTE : this.getPosicao().incrementX(1); break;
        }
    }
}