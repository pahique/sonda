package gov.nasa.marte.sonda.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import gov.nasa.marte.sonda.controller.PlanaltoNaoEncontradoException;
import gov.nasa.marte.sonda.controller.PosicaoInvalidaException;
import gov.nasa.marte.sonda.model.Coordenada;
import gov.nasa.marte.sonda.model.MovimentoEnum;
import gov.nasa.marte.sonda.model.OrientacaoEnum;
import gov.nasa.marte.sonda.model.Planalto;
import gov.nasa.marte.sonda.model.Sonda;

@Service
public class SondaService {

	protected Planalto planalto;
	List<Sonda> listaSondas = new ArrayList<Sonda>();
	
	
	public Planalto criarPlanalto(Coordenada limiteSuperior) {
		planalto = new Planalto(limiteSuperior);
		return planalto;
	}

	public Planalto getPlanalto() {
		return planalto;
	}
	
    public synchronized Sonda adicionarSonda(Coordenada posicao, OrientacaoEnum orientacao) 
    			throws PlanaltoNaoEncontradoException, PosicaoInvalidaException {
        if (planalto == null) {
        	throw new PlanaltoNaoEncontradoException();
        }  else if (!planalto.isCoordenadaValida(posicao)) {
    		throw new PosicaoInvalidaException();
        } else {
        	Integer id = listaSondas.size() + 1;
        	Sonda sonda = new Sonda(id, planalto, posicao, orientacao);
        	listaSondas.add(sonda);
            return sonda;
        }
    }

    public Sonda getSonda(Integer id) {
    	Sonda result = null;
    	for (Sonda sonda : listaSondas) {
    		if (sonda.getId().equals(id)) {
    			result = sonda;
    			break;
    		}
    	}
    	return result;
    }
    
    public Sonda movimentarSonda(Integer idSonda, List<MovimentoEnum> listaMovimentos) {
    	Sonda sonda = null;
    	if (idSonda != null) {
    		sonda = getSonda(idSonda);
    		if (listaMovimentos != null) {
				for (MovimentoEnum movimento : listaMovimentos) {
					switch(movimento) {
						case GIRAR_ESQUERDA: sonda.girarEsquerda(); break;
						case GIRAR_DIREITA: sonda.girarDireita(); break;
						case MOVER_FRENTE: sonda.moverFrente(); break;
					}
				}
    		}
    	}
    	return sonda;
    }

}
