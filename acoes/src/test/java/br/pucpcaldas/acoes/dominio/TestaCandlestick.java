package br.pucpcaldas.acoes.dominio;

import static org.junit.Assert.assertTrue;

import org.joda.time.LocalDate;
import org.junit.Test;

public class TestaCandlestick {

    @Test
    public void deveRetornarTrueParaAberturaMenorQueFehamento() {
        // Arranjo
        Candlestick umCandle = new Candlestick(40.0, 50.0, 35.0, 55.0, 1500.00, LocalDate.now());

        // Ação
        boolean houveUmaAlta = umCandle.isAlta();

        // Asserção
        assertTrue(houveUmaAlta);

    }

    @Test
    public void deveRetornarTrueParaAberturaMaiorQueFehamento() {
        // Arranjo
        Candlestick umCandle = new Candlestick(50.0, 40.0, 35.0, 55.0, 1500.00, LocalDate.now());

        // Ação
        boolean houveUmaBaixa = umCandle.isBaixa();

        // Asserção
        assertTrue(houveUmaBaixa);

    }

}
