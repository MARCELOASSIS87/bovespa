package br.pucpcaldas.acoes.dominio;

import org.joda.time.LocalDate;

/**
 * Um objeto da classe <code>Negocio</code> armazenará uma negociação com preço,
 * quantidade e data.
 * 
 * @author Luiz Alberto
 * @since 2021-02-25
 * @version 1.0
 */
public class Negocio {
    private final double preco;
    private final int quantidade;
    private final LocalDate data;

    /**
     * Construtor da classe.
     * 
     * @param preco      preço da unidade negociada.
     * @param quantidade quantidade negociada.
     * @param data       data da negociação.
     */
    public Negocio(double preco, int quantidade, LocalDate data) {
        if (data == null)
            throw new IllegalArgumentException("data não pode ser nula");

        this.preco = preco;
        this.quantidade = quantidade;
        this.data = data;
    }

    /**
     * Retorna a data da negociação.
     * 
     * @return data da negociação.
     */
    public LocalDate getData() {
        return this.data;
    }

    /**
     * Retorna a quantidade negociada.
     * 
     * @return quantidade negociada.
     */
    public int getQuantidade() {
        return this.quantidade;
    }

    /**
     * Retorna o preço de unidade negociada.
     * 
     * @return preco da unidade negociada.
     */
    public double getPreco() {
        return this.preco;
    }

    /**
     * Retorna o volume negociado que é o resultado da multiplicação do preco pela
     * quantidade negociada.
     * 
     * @return volume negociado.
     */
    public double getVolume() {
        return this.preco * this.quantidade;
    }
}
