package br.pucpcaldas.acoes.dominio;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;


public class FabricaDeCandlestickTest {

    private LocalDate hoje;
    private Negocio negocio1;
    private Negocio negocio2;
    private Negocio negocio3;
    private Negocio negocio4;
    
    @Before
    public void init()
    {
        hoje = LocalDate.now();
        negocio1 = new Negocio(40.5, 100, hoje);
        negocio2 = new Negocio(45.0, 100, hoje);
        negocio3 = new Negocio(39.8, 100, hoje);
        negocio4 = new Negocio(42.3, 100, hoje);
    }

    @Test
    public void deveRetornarUmCandleDeUmaSequenciaDeNegocios() {
        
        // Arranjo
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

    @Test
    public void deveRetornarUmCandleDeParaNegociosEmOrdemCrescente() {
        
        List<Negocio> negocios = Arrays.asList(negocio3, negocio1, negocio4, negocio2);
        CandlestickFabrica umFabricaDeCandlestick = new CandlestickFabrica();

        // Ação
        Candlestick umCandlestick = umFabricaDeCandlestick.constroiCandleParaData(negocios, hoje);

        // Asserção
        assertEquals("Preço de abertura: ", 39.8, umCandlestick.getAbertura(), 0.00001);
        assertEquals("Preço de fechamento: ", 45.0, umCandlestick.getFechamento(), 0.00001);
        assertEquals("Preço de mínimo: ", 39.8, umCandlestick.getMinimo(), 0.00001);
        assertEquals("Preço de máximo: ", 45.0, umCandlestick.getMaximo(), 0.00001);
        assertEquals("Volume Negociado: ", 16760, umCandlestick.getVolume(), 0.00001);
    }

    @Test
    public void deveRetornarUmCandleDeParaNegociosEmOrdemDecrescente() {
        
        List<Negocio> negocios = Arrays.asList(negocio2, negocio4, negocio1, negocio3);
        CandlestickFabrica umFabricaDeCandlestick = new CandlestickFabrica();

        // Ação
        Candlestick umCandlestick = umFabricaDeCandlestick.constroiCandleParaData(negocios, hoje);

        // Asserção
        assertEquals("Preço de abertura: ", 45.0, umCandlestick.getAbertura(), 0.00001);
        assertEquals("Preço de fechamento: ", 39.8, umCandlestick.getFechamento(), 0.00001);
        assertEquals("Preço de mínimo: ", 39.8, umCandlestick.getMinimo(), 0.00001);
        assertEquals("Preço de máximo: ", 45.0, umCandlestick.getMaximo(), 0.00001);
        assertEquals("Volume Negociado: ", 16760, umCandlestick.getVolume(), 0.00001);
    }
}
