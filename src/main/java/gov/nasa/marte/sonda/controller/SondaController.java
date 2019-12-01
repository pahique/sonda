package gov.nasa.marte.sonda.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import gov.nasa.marte.sonda.model.Coordenada;
import gov.nasa.marte.sonda.model.MovimentoEnum;
import gov.nasa.marte.sonda.model.Planalto;
import gov.nasa.marte.sonda.model.Sonda;
import gov.nasa.marte.sonda.service.SondaService;

@RestController
@RequestMapping("/api")
public class SondaController {

    private static final Logger LOGGER = LogManager.getLogger(SondaController.class);
    
	@Autowired
	SondaService sondaService;
	
	@PostMapping("/planalto")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Planalto criarPlanalto(@RequestBody Coordenada limiteSuperior) {
		LOGGER.debug("Criar planalto com limite " + limiteSuperior);
		return sondaService.criarPlanalto(limiteSuperior);
	}
	
	@GetMapping("/planalto")
	public Planalto getPlanalto() {
		LOGGER.debug("Obter planalto");
		return sondaService.getPlanalto();
	}
	  
	@PostMapping("/sondas")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Sonda adicionarSonda(@RequestBody ParametrosSondaTO params) {
		LOGGER.debug("Adicionar sonda com parametros " + params);
		return sondaService.adicionarSonda(params.getPosicao(), params.getOrientacao());
	}

	@GetMapping("/sondas")
	public List<Sonda> getListaSondas() {
		LOGGER.debug("Obter sondas");
		return sondaService.getListaSondas();
	}

	@GetMapping("/sondas/{id}")
	public Sonda getSonda(@PathVariable Integer id) {
		LOGGER.debug("Obter sonda " + id);
		return sondaService.getSonda(id);
	}
	
	@PutMapping("/sondas/{id}")
	public Sonda movimentarSonda(@PathVariable Integer id, @RequestBody List<MovimentoEnum> listaMovimentos)  {
		LOGGER.debug("Movimentar sonda " + id + " com os comandos " + listaMovimentos);
		return sondaService.movimentarSonda(id, listaMovimentos);
	}
	  
	
}
