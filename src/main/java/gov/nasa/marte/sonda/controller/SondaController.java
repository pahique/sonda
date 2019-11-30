package gov.nasa.marte.sonda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gov.nasa.marte.sonda.model.Coordenada;
import gov.nasa.marte.sonda.model.MovimentoEnum;
import gov.nasa.marte.sonda.model.OrientacaoEnum;
import gov.nasa.marte.sonda.model.Planalto;
import gov.nasa.marte.sonda.model.Sonda;
import gov.nasa.marte.sonda.service.SondaService;

@RestController
public class SondaController {

	@Autowired
	SondaService sondaService;
	
	@GetMapping("/planalto")
	Planalto getPlanalto() throws PlanaltoNaoEncontradoException {
		Planalto planalto = sondaService.getPlanalto();
		if (planalto == null) {
			throw new PlanaltoNaoEncontradoException();
		}
		return planalto;
	}
	  
	@PostMapping("/planalto")
	Planalto novoPlanalto(@RequestBody Coordenada limiteSuperior) {
		return sondaService.criarPlanalto(limiteSuperior);
	}
	
	@PostMapping("/sonda")
	Sonda novaSonda(@RequestBody ParametrosSonda params) {
		return sondaService.adicionarSonda(params.getPosicao(), params.getOrientacao());
	}

	@GetMapping("/sonda/{id}")
	Sonda getSonda(@PathVariable Integer id) throws SondaNaoEncontradaException {
		Sonda sonda = sondaService.getSonda(id);
		if (sonda == null) {
			throw new SondaNaoEncontradaException();
		}
		return sonda;
	}
	
	@PutMapping("/sonda/{id}")
	Sonda movimentarSonda(@PathVariable Integer id, @RequestBody List<MovimentoEnum> listaMovimentos)  {
		Sonda sonda = sondaService.movimentarSonda(id, listaMovimentos);
		return sonda;
	}
	  
	
}
