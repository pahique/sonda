package gov.nasa.marte.sonda.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import gov.nasa.marte.sonda.model.Coordenada;
import gov.nasa.marte.sonda.model.MovimentoEnum;
import gov.nasa.marte.sonda.model.OrientacaoEnum;
import gov.nasa.marte.sonda.model.Planalto;
import gov.nasa.marte.sonda.model.Sonda;

public class SondaServiceTest {
		
	@Test
	public void criarPlanalto() {
		SondaService service = new SondaService();
		Coordenada limiteSuperior = new Coordenada(5, 5);
		service.criarPlanalto(limiteSuperior);
		Assert.assertEquals(service.planalto.getLimiteInferior(), new Coordenada(0, 0));
		Assert.assertEquals(service.planalto.getLimiteSuperior(), limiteSuperior);
	}

	@Test(expected = LimiteInvalidoException.class)
	public void criarPlanalto_limiteInvalidoX() {
		SondaService service = new SondaService();
		Coordenada limiteSuperior = new Coordenada(-5, 5);
		service.criarPlanalto(limiteSuperior);
	}

	@Test(expected = LimiteInvalidoException.class)
	public void criarPlanalto_limiteInvalidoY() {
		SondaService service = new SondaService();
		Coordenada limiteSuperior = new Coordenada(5, -1);
		service.criarPlanalto(limiteSuperior);
	}

	@Test
	public void getPlanalto() {
		SondaService service = new SondaService();
		service.planalto = new Planalto(new Coordenada(5, 5));
		Planalto planalto = service.getPlanalto();
		Assert.assertEquals(service.planalto.getLimiteInferior(), planalto.getLimiteInferior());
		Assert.assertEquals(service.planalto.getLimiteSuperior(), planalto.getLimiteSuperior());
	}
	
	@Test
    public void adicionarSonda() {
		SondaService service = new SondaService();
		service.planalto = new Planalto(new Coordenada(5, 5));
		Sonda sonda = service.adicionarSonda(new Coordenada(2, 4), OrientacaoEnum.W);
		Assert.assertEquals(1, service.listaSondas.size());
		Assert.assertEquals(sonda, service.listaSondas.get(0));
		Assert.assertEquals(new Integer(1), service.listaSondas.get(0).getId());
		Assert.assertEquals(new Coordenada(2, 4), service.listaSondas.get(0).getPosicao());
		Assert.assertEquals(OrientacaoEnum.W, service.listaSondas.get(0).getOrientacao());
    }

	@Test
    public void getSonda() {
		SondaService service = new SondaService();
		service.planalto = new Planalto(new Coordenada(5, 5));
		service.listaSondas.add(new Sonda(1, new Coordenada(2, 2), OrientacaoEnum.S));
		Sonda sonda = service.getSonda(1);
		Assert.assertEquals(new Integer(1), sonda.getId());
		Assert.assertEquals(new Coordenada(2, 2), sonda.getPosicao());
		Assert.assertEquals(OrientacaoEnum.S, sonda.getOrientacao());
    }
    
	@Test
    public void getSondas() {
		SondaService service = new SondaService();
		service.planalto = new Planalto(new Coordenada(5, 5));
		service.listaSondas.add(new Sonda(1, new Coordenada(2, 2), OrientacaoEnum.S));
		service.listaSondas.add(new Sonda(2, new Coordenada(2, 4), OrientacaoEnum.W));
		List<Sonda> sondas = service.getListaSondas();
		Assert.assertEquals(2, sondas.size());
		Assert.assertEquals(new Integer(1), sondas.get(0).getId());
		Assert.assertEquals(new Coordenada(2, 2), sondas.get(0).getPosicao());
		Assert.assertEquals(OrientacaoEnum.S, sondas.get(0).getOrientacao());
		Assert.assertEquals(new Integer(2), sondas.get(1).getId());
		Assert.assertEquals(new Coordenada(2, 4), sondas.get(1).getPosicao());
		Assert.assertEquals(OrientacaoEnum.W, sondas.get(1).getOrientacao());
    }
    
	@Test
    public void movimentarSonda() {
		SondaService service = new SondaService();
		Planalto planalto = new Planalto(new Coordenada(5, 5));
		service.planalto = planalto;
		Coordenada posicao = new Coordenada(2, 2);
		Integer idSonda = 1;
		Sonda sonda = new Sonda(idSonda, posicao, OrientacaoEnum.N);
		service.listaSondas.add(sonda);
		List<MovimentoEnum> listaMovimentos = new ArrayList<MovimentoEnum>();
		listaMovimentos.add(MovimentoEnum.M);
		listaMovimentos.add(MovimentoEnum.R);
		listaMovimentos.add(MovimentoEnum.M);
		listaMovimentos.add(MovimentoEnum.L);
		listaMovimentos.add(MovimentoEnum.M);
		listaMovimentos.add(MovimentoEnum.R);
		service.movimentarSonda(idSonda, listaMovimentos);
		Coordenada novaPosicao = new Coordenada(3, 4);
		Assert.assertEquals(novaPosicao, sonda.getPosicao());
		Assert.assertEquals(OrientacaoEnum.E, sonda.getOrientacao());
    }

	@Test
    public void movimentarSonda_sentidoNorteForaDosLimites() {
		SondaService service = new SondaService();
		Planalto planalto = new Planalto(new Coordenada(5, 5));
		service.planalto = planalto;
		Coordenada posicao = new Coordenada(2, 5);
		Integer idSonda = 1;
		Sonda sonda = new Sonda(idSonda, posicao, OrientacaoEnum.N);
		service.listaSondas.add(sonda);
		List<MovimentoEnum> listaMovimentos = new ArrayList<MovimentoEnum>();
		listaMovimentos.add(MovimentoEnum.M);
		service.movimentarSonda(idSonda, listaMovimentos);
		Coordenada novaPosicao = new Coordenada(2, 5);
		Assert.assertEquals(novaPosicao, sonda.getPosicao());
		Assert.assertEquals(OrientacaoEnum.N, sonda.getOrientacao());
    }

	
    @Test
    public void movimentarSonda_sentidoOesteForaDosLimites() {
		SondaService service = new SondaService();
		Planalto planalto = new Planalto(new Coordenada(5, 5));
		service.planalto = planalto;
		Coordenada posicao = new Coordenada(0, 4);
		Integer idSonda = 1;
		Sonda sonda = new Sonda(idSonda, posicao, OrientacaoEnum.W);
		service.listaSondas.add(sonda);
		List<MovimentoEnum> listaMovimentos = new ArrayList<MovimentoEnum>();
		listaMovimentos.add(MovimentoEnum.M);
		service.movimentarSonda(idSonda, listaMovimentos);
		Coordenada novaPosicao = new Coordenada(0, 4);
		Assert.assertEquals(novaPosicao, sonda.getPosicao());
		Assert.assertEquals(OrientacaoEnum.W, sonda.getOrientacao());
    }

    @Test
    public void movimentarSonda_sentidoSulForaDosLimites() {
		SondaService service = new SondaService();
		Planalto planalto = new Planalto(new Coordenada(5, 5));
		service.planalto = planalto;
		Coordenada posicao = new Coordenada(2, 0);
		Integer idSonda = 1;
		Sonda sonda = new Sonda(idSonda, posicao, OrientacaoEnum.S);
		service.listaSondas.add(sonda);
		List<MovimentoEnum> listaMovimentos = new ArrayList<MovimentoEnum>();
		listaMovimentos.add(MovimentoEnum.M);
		service.movimentarSonda(idSonda, listaMovimentos);
		Coordenada novaPosicao = new Coordenada(2, 0);
		Assert.assertEquals(novaPosicao, sonda.getPosicao());
		Assert.assertEquals(OrientacaoEnum.S, sonda.getOrientacao());
    }

    @Test
    public void movimentarSonda_sentidoLesteForaDosLimites() {
		SondaService service = new SondaService();
		Planalto planalto = new Planalto(new Coordenada(5, 5));
		service.planalto = planalto;
		Coordenada posicao = new Coordenada(5, 4);
		Integer idSonda = 1;
		Sonda sonda = new Sonda(idSonda, posicao, OrientacaoEnum.E);
		service.listaSondas.add(sonda);
		List<MovimentoEnum> listaMovimentos = new ArrayList<MovimentoEnum>();
		listaMovimentos.add(MovimentoEnum.M);
		service.movimentarSonda(idSonda, listaMovimentos);
		Coordenada novaPosicao = new Coordenada(5, 4);
		Assert.assertEquals(novaPosicao, sonda.getPosicao());
		Assert.assertEquals(OrientacaoEnum.E, sonda.getOrientacao());
    }
}
