package br.pucpcaldas.acoes.dominio;

import org.joda.time.LocalDate;

/**
 * Um objeto da classe <code>Candlestick</code> armazena o preço minimo, máximo,
 * de abertura, de fechamento, volume e data a partir de uma coleção de objetos
 * da classe <code>Negocio</code>
 * 
 * @author Luiz Alberto (gomes.luiz@gmail.com)
 * @since 2020-03-04
 * @version 1.0
 * @see Negocio
 */
public class Candlestick {
    private final double abertura;
    private final double fechamento;
    private final double minimo;
    private final double maximo;
    private final double volume;
    private final LocalDate data;

    /**
     * Construtor da classe.
     * 
     * @param abertura   preço de abertura
     * @param fechamento preço de fechamento
     * @param minimo     preço mínimo
     * @param maximo     preço máximo
     * @param volume     volume negociado
     * @param data2      data da negociação
     */
    public Candlestick(double abertura, double fechamento, double minimo, double maximo, double volume,
            LocalDate data) {

        if ((abertura < 0.0) || (fechamento < 0.0) || (minimo < 0.0) || (maximo < 0.0) || (volume < 0.0))
            throw new IllegalArgumentException("valores negativos não são permitidos.");

        if (maximo < minimo)
            throw new IllegalArgumentException("preço máximo deve ser maior ou igual ao mínimo.");

        if (data == null)
            throw new IllegalArgumentException("data não pode ser nula.");

        this.abertura = abertura;
        this.fechamento = fechamento;
        this.minimo = minimo;
        this.maximo = maximo;
        this.volume = volume;
        this.data = data;
    }

    /**
     * Retorna o preço de abertura.
     * 
     * @return preço de abertura
     */
    public double getAbertura() {
        return abertura;
    }

    /**
     * Retorna o preço de fechamento.
     * 
     * @return preço de fechamento
     */
    public double getFechamento() {
        return fechamento;
    }

    /**
     * Retorna o preço mínimo.
     * 
     * @return preço mínimo
     */
    public double getMinimo() {
        return minimo;
    }

    /**
     * Retorna o preço máximo.
     * 
     * @return preço máximo.
     */
    public double getMaximo() {
        return maximo;
    }

    /**
     * Retorna volume negociado
     * 
     * @return volume negociado
     */
    public double getVolume() {
        return volume;
    }

    /**
     * Retorna a data da negociação
     * 
     * @return data da negociação
     */
    public LocalDate getData() {
        return data;
    }

    public boolean isAlta() {
        return this.abertura < this.fechamento;
    }

    public boolean isBaixa() {
        return this.abertura > this.fechamento;
    }

}
