package br.pucpcaldas.acoes.dominio;

import static org.junit.Assert.assertTrue;

import org.joda.time.LocalDate;
import org.junit.Test;

public class CandlestickTest {

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

    @Test(expected = IllegalArgumentException.class)
    public void deveRetornarUmaExcecaoParaPrecoMaximoMenorDoQueMinimo() {
        // Arranjo, Ação, Asserção
        Candlestick umCandle = new Candlestick(50.0, 40.0, 55.0, 35.0, 1500.00, LocalDate.now());
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveRetornarUmaExcecaoParaDataNula() {
        // Arranjo, Ação, Asserção
        Candlestick umCandle = new Candlestick(50.0, 40.0, 35.0, 55.0, 1500.00, null);
    }
    

    @Test(expected = IllegalArgumentException.class)
    public void deveRetornarUmaExcecaoParaAberturaNegativa() {
        // Arranjo, Ação, Asserção
        Candlestick umCandle = new Candlestick(-50.0, 35.0, 40.0, 55.0, 1500.00, LocalDate.now());
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveRetornarUmaExcecaoParaFechamentoNegativo() {
        // Arranjo, Ação, Asserção
        Candlestick umCandle = new Candlestick(50.0, -35.0, 40.0, 55.0, 1500.00, LocalDate.now());
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveRetornarUmaExcecaoParaMinimoNegativo() {
        // Arranjo, Ação, Asserção
        Candlestick umCandle = new Candlestick(50.0, 35.0, -40.0, 55.0, 1500.00, LocalDate.now());
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveRetornarUmaExcecaoParaMaximoNegativo() {
        // Arranjo, Ação, Asserção
        Candlestick umCandle = new Candlestick(50.0, 35.0, 40.0, -55.0, 1500.00, LocalDate.now());
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveRetornarUmaExcecaoParaVolumeNegativo() {
        // Arranjo, Ação, Asserção
        Candlestick umCandle = new Candlestick(50.0, 35.0, 40.0, 55.0, -1500.00, LocalDate.now());
    }

}
