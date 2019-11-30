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
import gov.nasa.marte.sonda.model.Planalto;
import gov.nasa.marte.sonda.model.Sonda;
import gov.nasa.marte.sonda.service.SondaService;

@RestController
public class SondaController {

	@Autowired
	SondaService sondaService;
	
	@PostMapping("/planalto")
	Planalto novoPlanalto(@RequestBody Coordenada limiteSuperior) {
		return sondaService.criarPlanalto(limiteSuperior);
	}
	
	@GetMapping("/planalto")
	Planalto getPlanalto() {
		return sondaService.getPlanalto();
	}
	  
	@PostMapping("/sonda")
	Sonda novaSonda(@RequestBody ParametrosSonda params) {
		return sondaService.adicionarSonda(params.getPosicao(), params.getOrientacao());
	}

	@GetMapping("/sonda/{id}")
	Sonda getSonda(@PathVariable Integer id) {
		return sondaService.getSonda(id);
	}
	
	@PutMapping("/sonda/{id}")
	Sonda movimentarSonda(@PathVariable Integer id, @RequestBody List<MovimentoEnum> listaMovimentos)  {
		return sondaService.movimentarSonda(id, listaMovimentos);
	}
	  
	
}
