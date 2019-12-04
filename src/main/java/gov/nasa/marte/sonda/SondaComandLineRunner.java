package gov.nasa.marte.sonda;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import gov.nasa.marte.sonda.io.ArquivoSondaReader;
import gov.nasa.marte.sonda.model.Coordenada;
import gov.nasa.marte.sonda.model.MovimentoEnum;
import gov.nasa.marte.sonda.model.Sonda;
import gov.nasa.marte.sonda.service.SondaService;

@Component
public class SondaComandLineRunner implements CommandLineRunner {

    private static final Logger LOGGER = LogManager.getLogger(SondaComandLineRunner.class);

    @Autowired
    SondaService service;
    
    @Override
    public void run(String...args) throws Exception {
    	if (args.length == 2) {
    		String inputFilename = args[0];
    		String outputFilename = args[1];
			LOGGER.info("Parametro encontrado, processando arquivo " + inputFilename + " ...");
	        File inputFile = new File(inputFilename);
	        if (!inputFile.exists()) {
	            LOGGER.error("Arquivo não encontrado: " + inputFilename);
	        } else {
		        try (ArquivoSondaReader reader = new ArquivoSondaReader(new FileReader(inputFile));
	            	 PrintWriter writer = new PrintWriter(new FileWriter(outputFilename))) {
		        	
		            Coordenada limiteSuperior = reader.lerLimitePlanalto();
		            service.criarPlanalto(limiteSuperior);
		            Sonda sonda = null;
		            while ((sonda = reader.lerSonda()) != null) {
		            	sonda = service.adicionarSonda(sonda.getPosicao(), sonda.getOrientacao());
	            		List<MovimentoEnum> movimentos = reader.lerMovimentos();
		            	if (movimentos != null) {
		            		sonda = service.movimentarSonda(sonda.getId(), movimentos);
		            		writer.println(sonda.getPosicao().getX() + " " + sonda.getPosicao().getY() + " " + sonda.getOrientacao());
		            	}
		            }
					LOGGER.info("Arquivo processado com sucesso! Saída gerada em " + outputFilename);    
		        } catch(Exception e) {
		            LOGGER.error("Erro ao processar arquivo", e);
		        }
	        }
    	} else {
        	LOGGER.info("Parametros (opcionais, para carga de dados): <arquivo de entrada> <arquivo de saida>");
    	}
    }
}