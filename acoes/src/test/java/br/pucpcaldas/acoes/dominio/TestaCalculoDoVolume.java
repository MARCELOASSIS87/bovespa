package br.pucpcaldas.acoes.dominio;

import static org.junit.Assert.assertEquals;

import org.joda.time.LocalDate;
import org.junit.Test;

public class TestaCalculoDoVolume {
   
    @Test
    public void deveRetornarMultiplicacaoDoPrecoPelaQuantidade() {
        //Arranjo
        Negocio umNegocio = new Negocio(1.5, 4, LocalDate.now());
        
        //Ação
        double volumeCalculado = umNegocio.getVolume();

        //Asserção
        assertEquals(1.5 * 4, volumeCalculado, 0.01);
    }
}
