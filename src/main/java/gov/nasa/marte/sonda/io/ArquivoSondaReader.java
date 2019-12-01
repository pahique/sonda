package gov.nasa.marte.sonda.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import gov.nasa.marte.sonda.model.Coordenada;
import gov.nasa.marte.sonda.model.MovimentoEnum;
import gov.nasa.marte.sonda.model.OrientacaoEnum;
import gov.nasa.marte.sonda.model.Sonda;

public class ArquivoSondaReader extends BufferedReader {
	
	public ArquivoSondaReader(Reader reader) {
		super(reader);
	}
	
    public Coordenada lerLimitePlanalto() throws IOException {
        Coordenada result = null;
        String linha = readLine();
        if (linha != null) {
            String[] dados = linha.trim().split(" ");
            int x = Integer.parseInt(dados[0]);
            int y = Integer.parseInt(dados[1]);
            result = new Coordenada(x, y);
        }
        return result;
    }

    public Sonda lerSonda() throws IOException {
        Sonda result = null; 
        String linha = readLine();
        if (linha != null) {
            String[] dados = linha.trim().split(" ");
            int x = Integer.parseInt(dados[0]);
            int y = Integer.parseInt(dados[1]);
            String orientacao = dados[2];
            result = new Sonda(null, new Coordenada(x, y), OrientacaoEnum.valueOf(orientacao));
        }
        return result;
    }

    public List<MovimentoEnum> lerMovimentos() throws IOException {
        List<MovimentoEnum> result = null;
        String linha = readLine();
        if (linha != null) {
            result = new ArrayList<MovimentoEnum>();
            String[] codigos = linha.trim().split("");
            for (String codigo : codigos) {
                result.add(MovimentoEnum.valueOf(codigo));
            }
        }
        return result;
    }
}
