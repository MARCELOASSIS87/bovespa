package br.pucpcaldas.acoes.dominio;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.joda.time.LocalDate;
import org.junit.Test;

public class TestaFabricaDeCandlestick {

    @Test
    public void deveRetornarUmCandleDeUmaSequenciaDeNegocios() {
        LocalDate hoje = LocalDate.now();

        // Arranjo
        Negocio negocio1 = new Negocio(40.5, 100, hoje);
        Negocio negocio2 = new Negocio(45.0, 100, hoje);
        Negocio negocio3 = new Negocio(39.8, 100, hoje);
        Negocio negocio4 = new Negocio(42.3, 100, hoje);
        List<Negocio> negocios = Arrays.asList(negocio1, negocio2, negocio3, negocio4);
        CandlestickFabrica umFabricaDeCandlestick = new CandlestickFabrica();

        // Ação
        Candlestick umCandlestick = umFabricaDeCandlestick.constroiCandleParaData(negocios, hoje);

        // Asserção
        assertEquals("Preço de abertura: ", 40.5, umCandlestick.getAbertura(), 0.00001);
        assertEquals("Preço de fechamento: ", 42.3, umCandlestick.getFechamento(), 0.00001);
        assertEquals("Preço de mínimo: ", 39.8, umCandlestick.getMinimo(), 0.00001);
        assertEquals("Preço de máximo: ", 45.0, umCandlestick.getMaximo(), 0.00001);
        assertEquals("Volume Negociado: ", 16760, umCandlestick.getVolume(), 0.00001);
    }
}
