package gov.nasa.marte.sonda.model;

import org.junit.Assert;
import org.junit.Test;

public class SondaTest {

    private Planalto planalto = new Planalto(new Coordenada(5, 5));

    @Test
    public void girarEsquerda_inicioNorte() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(planalto, posicao, OrientacaoEnum.NORTE);
        sonda.girarEsquerda();
        Assert.assertEquals(posicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.OESTE, sonda.getOrientacao());
    }

    @Test
    public void girarEsquerda_inicioOeste() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(planalto, posicao, OrientacaoEnum.OESTE);
        sonda.girarEsquerda();
        Assert.assertEquals(posicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.SUL, sonda.getOrientacao());
    }

    @Test
    public void girarEsquerda_inicioSul() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(planalto, posicao, OrientacaoEnum.SUL);
        sonda.girarEsquerda();
        Assert.assertEquals(posicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.LESTE, sonda.getOrientacao());
    }

    @Test
    public void girarEsquerda_inicioLeste() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(planalto, posicao, OrientacaoEnum.LESTE);
        sonda.girarEsquerda();
        Assert.assertEquals(posicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.NORTE, sonda.getOrientacao());
    }

    @Test
    public void girarDireita_inicioNorte() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(planalto, posicao, OrientacaoEnum.NORTE);
        sonda.girarDireita();
        Assert.assertEquals(posicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.LESTE, sonda.getOrientacao());
    }

    @Test
    public void girarDireita_inicioLeste() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(planalto, posicao, OrientacaoEnum.LESTE);
        sonda.girarDireita();
        Assert.assertEquals(posicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.SUL, sonda.getOrientacao());
    }

    @Test
    public void girarDireita_inicioSul() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(planalto, posicao, OrientacaoEnum.SUL);
        sonda.girarDireita();
        Assert.assertEquals(posicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.OESTE, sonda.getOrientacao());
    }

    @Test
    public void girarDireita_inicioOeste() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(planalto, posicao, OrientacaoEnum.OESTE);
        sonda.girarDireita();
        Assert.assertEquals(posicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.NORTE, sonda.getOrientacao());
    }

    @Test
    public void mover_sentidoNorte() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(planalto, posicao, OrientacaoEnum.NORTE);
        sonda.moverFrente();
        Coordenada novaPosicao = new Coordenada(2, 5);
        Assert.assertEquals(novaPosicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.NORTE, sonda.getOrientacao());
    }

    @Test
    public void mover_sentidoOeste() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(planalto, posicao, OrientacaoEnum.OESTE);
        sonda.moverFrente();
        Coordenada novaPosicao = new Coordenada(1, 4);
        Assert.assertEquals(novaPosicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.OESTE, sonda.getOrientacao());
    }

    @Test
    public void mover_sentidoSul() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(planalto, posicao, OrientacaoEnum.SUL);
        sonda.moverFrente();
        Coordenada novaPosicao = new Coordenada(2, 3);
        Assert.assertEquals(novaPosicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.SUL, sonda.getOrientacao());
    }

    @Test
    public void mover_sentidoLeste() {
        Coordenada posicao = new Coordenada(2, 4);
        Sonda sonda = new Sonda(planalto, posicao, OrientacaoEnum.LESTE);
        sonda.moverFrente();
        Coordenada novaPosicao = new Coordenada(3, 4);
        Assert.assertEquals(novaPosicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.LESTE, sonda.getOrientacao());
    }

    @Test
    public void mover_sentidoNorteForaDosLimites() {
        Coordenada posicao = new Coordenada(2, 5);
        Sonda sonda = new Sonda(planalto, posicao, OrientacaoEnum.NORTE);
        sonda.moverFrente();
        Coordenada novaPosicao = new Coordenada(2, 5);
        Assert.assertEquals(novaPosicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.NORTE, sonda.getOrientacao());
    }

    @Test
    public void mover_sentidoOesteForaDosLimites() {
        Coordenada posicao = new Coordenada(0, 4);
        Sonda sonda = new Sonda(planalto, posicao, OrientacaoEnum.OESTE);
        sonda.moverFrente();
        Coordenada novaPosicao = new Coordenada(0, 4);
        Assert.assertEquals(novaPosicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.OESTE, sonda.getOrientacao());
    }

    @Test
    public void mover_sentidoSulForaDosLimites() {
        Coordenada posicao = new Coordenada(2, 0);
        Sonda sonda = new Sonda(planalto, posicao, OrientacaoEnum.SUL);
        sonda.moverFrente();
        Coordenada novaPosicao = new Coordenada(2, 0);
        Assert.assertEquals(novaPosicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.SUL, sonda.getOrientacao());
    }

    @Test
    public void mover_sentidoLesteForaDosLimites() {
        Coordenada posicao = new Coordenada(5, 4);
        Sonda sonda = new Sonda(planalto, posicao, OrientacaoEnum.LESTE);
        sonda.moverFrente();
        Coordenada novaPosicao = new Coordenada(5, 4);
        Assert.assertEquals(novaPosicao, sonda.getPosicao());
        Assert.assertEquals(OrientacaoEnum.LESTE, sonda.getOrientacao());
    }
}
