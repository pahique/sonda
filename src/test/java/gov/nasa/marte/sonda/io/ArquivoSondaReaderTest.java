package gov.nasa.marte.sonda.io;

import java.io.StringReader;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import gov.nasa.marte.sonda.model.Coordenada;
import gov.nasa.marte.sonda.model.MovimentoEnum;
import gov.nasa.marte.sonda.model.OrientacaoEnum;
import gov.nasa.marte.sonda.model.Sonda;


public class ArquivoSondaReaderTest {

	
	final String fileContents = "4 5\n" + 
			"1 2 S\n" + 
			"LMRMLMLMM\n" + 
			"3 2 E\n" + 
			"MMRMMRMRRM";

	@Test
	public void lerLimitePlanalto() throws Exception {
		try (ArquivoSondaReader reader = new ArquivoSondaReader(new StringReader(fileContents))) {
			Coordenada limitePlanalto = reader.lerLimitePlanalto();
			Assert.assertEquals(new Coordenada(4, 5), limitePlanalto);
		} 
	}
	
	@Test(expected = RuntimeException.class)
	public void lerLimitePlanalto_invalido() throws Exception {
		String invalidContents = "5 N";
		try (ArquivoSondaReader reader = new ArquivoSondaReader(new StringReader(invalidContents))) {
			reader.lerLimitePlanalto();
		} 
	}
	
	
	@Test
	public void lerSonda() throws Exception {
		try (ArquivoSondaReader reader = new ArquivoSondaReader(new StringReader(fileContents))) {
			reader.readLine(); // salta primeira linha
			Sonda sonda = reader.lerSonda();
			Assert.assertNull(sonda.getId());
			Assert.assertEquals(new Coordenada(1, 2), sonda.getPosicao());
			Assert.assertEquals(OrientacaoEnum.S, sonda.getOrientacao());
		} 
	}
	
	@Test(expected = RuntimeException.class)
	public void lerSonda_incompleta() throws Exception {
		String invalidContents = "5 5\n1 4";
		try (ArquivoSondaReader reader = new ArquivoSondaReader(new StringReader(invalidContents))) {
			reader.readLine(); // salta primeira linha
			reader.lerSonda();
		} 
	}
	
	@Test
	public void lerMovimentos() throws Exception {
		try (ArquivoSondaReader reader = new ArquivoSondaReader(new StringReader(fileContents))) {
			reader.readLine(); // salta primeira linha
			reader.readLine(); // salta segunda linha
			List<MovimentoEnum> listaMovimentos = reader.lerMovimentos();
			Assert.assertEquals(9, listaMovimentos.size());
			int pos = 0;
			Assert.assertEquals(MovimentoEnum.L, listaMovimentos.get(pos++));
			Assert.assertEquals(MovimentoEnum.M, listaMovimentos.get(pos++));
			Assert.assertEquals(MovimentoEnum.R, listaMovimentos.get(pos++));
			Assert.assertEquals(MovimentoEnum.M, listaMovimentos.get(pos++));
			Assert.assertEquals(MovimentoEnum.L, listaMovimentos.get(pos++));
			Assert.assertEquals(MovimentoEnum.M, listaMovimentos.get(pos++));
			Assert.assertEquals(MovimentoEnum.L, listaMovimentos.get(pos++));
			Assert.assertEquals(MovimentoEnum.M, listaMovimentos.get(pos++));
			Assert.assertEquals(MovimentoEnum.M, listaMovimentos.get(pos++));
		} 
	}
	
	@Test(expected = RuntimeException.class)
	public void lerMovimentos_invalidos() throws Exception {
		String invalidContents = "5 5\n1 4 N\nLM5";
		try (ArquivoSondaReader reader = new ArquivoSondaReader(new StringReader(invalidContents))) {
			reader.readLine(); // salta primeira linha
			reader.readLine(); // salta segunda linha
			reader.lerMovimentos();
		} 
	}
}
