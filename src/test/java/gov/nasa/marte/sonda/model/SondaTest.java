package gov.nasa.marte.sonda.model;

import org.junit.Assert;
import org.junit.Test;

public class SondaTest {

    @Test
    public void girarEsquerda_inicioN() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(1, posicao, OrientacaoEnum.N);
        sonda.girarEsquerda();
        Assert.assertEquals(posicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.W, sonda.getOrientacao());
    }

    @Test
    public void girarEsquerda_inicioW() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(1, posicao, OrientacaoEnum.W);
        sonda.girarEsquerda();
        Assert.assertEquals(posicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.S, sonda.getOrientacao());
    }

    @Test
    public void girarEsquerda_inicioS() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(1, posicao, OrientacaoEnum.S);
        sonda.girarEsquerda();
        Assert.assertEquals(posicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.E, sonda.getOrientacao());
    }

    @Test
    public void girarEsquerda_inicioE() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(1, posicao, OrientacaoEnum.E);
        sonda.girarEsquerda();
        Assert.assertEquals(posicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.N, sonda.getOrientacao());
    }

    @Test
    public void girarDireita_inicioN() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(1, posicao, OrientacaoEnum.N);
        sonda.girarDireita();
        Assert.assertEquals(posicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.E, sonda.getOrientacao());
    }

    @Test
    public void girarDireita_inicioE() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(1, posicao, OrientacaoEnum.E);
        sonda.girarDireita();
        Assert.assertEquals(posicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.S, sonda.getOrientacao());
    }

    @Test
    public void girarDireita_inicioS() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(1, posicao, OrientacaoEnum.S);
        sonda.girarDireita();
        Assert.assertEquals(posicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.W, sonda.getOrientacao());
    }

    @Test
    public void girarDireita_inicioW() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(1, posicao, OrientacaoEnum.W);
        sonda.girarDireita();
        Assert.assertEquals(posicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.N, sonda.getOrientacao());
    }

    @Test
    public void mover_sentidoN() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(1, posicao, OrientacaoEnum.N);
        sonda.moverFrente();
        Coordenada novaPosicao = new Coordenada(2, 5);
        Assert.assertEquals(novaPosicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.N, sonda.getOrientacao());
    }

    @Test
    public void mover_sentidoW() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(1, posicao, OrientacaoEnum.W);
        sonda.moverFrente();
        Coordenada novaPosicao = new Coordenada(1, 4);
        Assert.assertEquals(novaPosicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.W, sonda.getOrientacao());
    }

    @Test
    public void mover_sentidoS() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(1, posicao, OrientacaoEnum.S);
        sonda.moverFrente();
        Coordenada novaPosicao = new Coordenada(2, 3);
        Assert.assertEquals(novaPosicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.S, sonda.getOrientacao());
    }

    @Test
    public void mover_sentidoE() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(1, posicao, OrientacaoEnum.E);
        sonda.moverFrente();
        Coordenada novaPosicao = new Coordenada(3, 4);
        Assert.assertEquals(novaPosicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.E, sonda.getOrientacao());
    }

}
