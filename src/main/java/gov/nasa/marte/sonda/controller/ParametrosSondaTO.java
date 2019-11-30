package gov.nasa.marte.sonda.controller;

import gov.nasa.marte.sonda.model.Coordenada;
import gov.nasa.marte.sonda.model.OrientacaoEnum;

public class ParametrosSondaTO {

	protected Coordenada posicao;
	protected OrientacaoEnum orientacao;
	
	public ParametrosSondaTO() {
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
}
