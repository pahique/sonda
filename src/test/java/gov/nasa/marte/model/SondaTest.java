package gov.nasa.marte.model;

import org.junit.Test;		
import org.junit.Assert;

public class SondaTest {

    @Test
    public void girarEsquerda_inicioNorte() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(posicao, OrientacaoEnum.NORTE);
        sonda.girarEsquerda();
        Assert.assertEquals(posicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.OESTE, sonda.getOrientacao());
    }

    @Test
    public void girarEsquerda_inicioOeste() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(posicao, OrientacaoEnum.OESTE);
        sonda.girarEsquerda();
        Assert.assertEquals(posicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.SUL, sonda.getOrientacao());
    }

    @Test
    public void girarEsquerda_inicioSul() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(posicao, OrientacaoEnum.SUL);
        sonda.girarEsquerda();
        Assert.assertEquals(posicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.LESTE, sonda.getOrientacao());
    }

    @Test
    public void girarEsquerda_inicioLeste() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(posicao, OrientacaoEnum.LESTE);
        sonda.girarEsquerda();
        Assert.assertEquals(posicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.NORTE, sonda.getOrientacao());
    }

    @Test
    public void girarDireita_inicioNorte() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(posicao, OrientacaoEnum.NORTE);
        sonda.girarDireita();
        Assert.assertEquals(posicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.LESTE, sonda.getOrientacao());
    }

    @Test
    public void girarDireita_inicioLeste() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(posicao, OrientacaoEnum.LESTE);
        sonda.girarDireita();
        Assert.assertEquals(posicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.SUL, sonda.getOrientacao());
    }

    @Test
    public void girarDireita_inicioSul() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(posicao, OrientacaoEnum.SUL);
        sonda.girarDireita();
        Assert.assertEquals(posicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.OESTE, sonda.getOrientacao());
    }

    @Test
    public void girarDireita_inicioOeste() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(posicao, OrientacaoEnum.OESTE);
        sonda.girarDireita();
        Assert.assertEquals(posicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.NORTE, sonda.getOrientacao());
    }

    @Test
    public void mover_inicioNorte() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(posicao, OrientacaoEnum.NORTE);
        sonda.mover();
        Coordenada novaPosicao = new Coordenada(2, 5);
        Assert.assertEquals(novaPosicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.NORTE, sonda.getOrientacao());
    }

    @Test
    public void mover_inicioOeste() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(posicao, OrientacaoEnum.OESTE);
        sonda.mover();
        Coordenada novaPosicao = new Coordenada(1, 4);
        Assert.assertEquals(novaPosicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.OESTE, sonda.getOrientacao());
    }

    @Test
    public void mover_inicioSul() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(posicao, OrientacaoEnum.SUL);
        sonda.mover();
        Coordenada novaPosicao = new Coordenada(2, 3);
        Assert.assertEquals(novaPosicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.SUL, sonda.getOrientacao());
    }

    @Test
    public void mover_inicioLeste() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(posicao, OrientacaoEnum.LESTE);
        sonda.mover();
        Coordenada novaPosicao = new Coordenada(3, 4);
        Assert.assertEquals(novaPosicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.LESTE, sonda.getOrientacao());
    }
}
