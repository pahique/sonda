package gov.nasa.marte.sonda.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import gov.nasa.marte.sonda.model.Coordenada;
import gov.nasa.marte.sonda.model.MovimentoEnum;
import gov.nasa.marte.sonda.model.OrientacaoEnum;
import gov.nasa.marte.sonda.model.Planalto;
import gov.nasa.marte.sonda.model.Sonda;
import lombok.Synchronized;

@Service
public class SondaService {

    private static final Logger LOGGER = LogManager.getLogger(SondaService.class);
	
	protected Planalto planalto;
	protected List<Sonda> listaSondas = new ArrayList<Sonda>();
	protected int idSondaAtual = 1;
	
	
	public Planalto criarPlanalto(Coordenada limiteSuperior) {
		LOGGER.info("criarPlanalto() - limiteSuperior: " + limiteSuperior);
		if (limiteSuperior == null || limiteSuperior.getX() <= 0 || limiteSuperior.getY() <= 0) {
			throw new LimiteInvalidoException("O limite deve ser uma coordenada maior que (0, 0)");
		}
		planalto = new Planalto(limiteSuperior);
		return planalto;
	}

	public Planalto getPlanalto() {
		LOGGER.info("getPlanalto()");
		if (planalto == null) {
			throw new PlanaltoNaoEspecificadoException("O planalto ainda não foi criado");
		}
		return planalto;
	}
	
	public List<Sonda> getListaSondas() {
		LOGGER.info("getListaSondas()");
		return listaSondas;
	}
	
	@Synchronized
    public Sonda adicionarSonda(Coordenada posicao, OrientacaoEnum orientacao) 
    			throws PlanaltoNaoEspecificadoException, PosicaoInvalidaException {
		LOGGER.info("adicionarSonda() - posicao: " + posicao + ", orientacao: " + orientacao);
        if (planalto == null) {
        	throw new PlanaltoNaoEspecificadoException("É necessário criar o planalto antes de adicionar uma sonda");
        }  else if (!planalto.isCoordenadaValida(posicao)) {
    		throw new PosicaoInvalidaException("Posição da sonda " + posicao + " está fora dos limites do planalto " + planalto);
        } else {
        	Integer id = idSondaAtual++;
        	Sonda sonda = new Sonda(id, posicao, orientacao);
        	listaSondas.add(sonda);
            return sonda;
        }
    }

    public Sonda getSonda(Integer id) {
		LOGGER.info("getSonda() - id: " + id);
    	Sonda result = null;
    	for (Sonda sonda : listaSondas) {
    		if (sonda.getId().equals(id)) {
    			result = sonda;
    			break;
    		}
    	}
    	if (result == null) {
    		throw new SondaNaoEncontradaException("Não foi encontrada nenhuma sonda com o id " + id);
    	}
    	return result;
    }
    
    /**
     * Movimenta a sonda dentro do planalto. A sonda nunca ultrapassa os limites do planalto, caso algum 
     * movimento leve a isso ele será ignorado e a sonda permanecerá na posição corrente. Os movimentos
     * seguintes serão executados normalmente.
     * @param idSonda ID da sonda que será movimentada
     * @param listaMovimentos Lista de movimentos a serem executados
     * @return Sonda com sua posição e orientação atualizados após a execução dos movimentos
     */
    public Sonda movimentarSonda(Integer idSonda, List<MovimentoEnum> listaMovimentos) {
		LOGGER.info("movimentarSonda() - idSonda: " + idSonda + ", listaMovimentos: " + listaMovimentos);
    	Sonda sonda = null;
    	if (idSonda != null) {
    		sonda = getSonda(idSonda);
    		if (listaMovimentos != null) {
				for (MovimentoEnum movimento : listaMovimentos) {
					switch(movimento) {
						case L: 
							sonda.girarEsquerda(); break;
						case R: 
							sonda.girarDireita(); break;
						case M: 
							Coordenada proximaPosicao = sonda.calcularProximaPosicao();
							if (planalto.isCoordenadaValida(proximaPosicao)) {
								sonda.moverFrente(); 
							}
							break;
					}
				}
    		}
    	}
    	return sonda;
    }

}
