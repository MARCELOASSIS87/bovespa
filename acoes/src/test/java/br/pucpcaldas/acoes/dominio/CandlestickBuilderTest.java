package br.pucpcaldas.acoes.dominio;

import static org.junit.Assert.assertTrue;

import org.joda.time.LocalDate;
import org.junit.Test;

public class CandlestickBuilderTest {

    @Test
    public void deveRetornarTrueParaAberturaMenorQueFehamento() {
        // Arranjo
        CandlestickBuilder builder = new CandlestickBuilder();

        Candlestick umCandle = builder.abertura(40.0)
                .fechamento(50.0)
                .minimo(35.0)
                .maximo(55.0)
                .volume(500.00)
                .data(LocalDate.now())
                .build();

        // Ação
        boolean houveUmaAlta = umCandle.isAlta();

        // Asserção
        assertTrue(houveUmaAlta);

    }

    @Test(expected = IllegalArgumentException.class)
    public void deveRetornarUmaExcecaoParaPrecoMaximoMenorDoQueMinimo() {
        // Arranjo, Ação, Asserção
        new CandlestickBuilder()
            .abertura(40.0)
            .fechamento(50.0)
            .minimo(55.0)
            .maximo(35.0)
            .volume(500.00)
            .data(LocalDate.now())
            .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveRetornarUmaExcecaoParaDataNula() {
        // Arranjo, Ação, Asserção
        new CandlestickBuilder()
                .abertura(40.0)
                .fechamento(50.0)
                .minimo(35.0)
                .maximo(55.0)
                .volume(500.00)
                .data(null)
                .build();
    }
}
