package br.pucpcaldas.acoes.dominio;

import org.joda.time.LocalDate;

public class CandlestickBuilder {

    private double _abertura;
    private double _fechamento;
    private double _minimo;
    private double _maximo;
    private double _volume;
    private LocalDate _data;

    public CandlestickBuilder abertura(double abertura) {
        this._abertura = abertura;
        return this;
    }

    public CandlestickBuilder fechamento(double fechamento) {
        this._fechamento = fechamento;

        return this;
    }

    public CandlestickBuilder minimo(double minimo) {
        this._minimo = minimo;

        return this;
    }

    public CandlestickBuilder maximo(double maximo) {
        this._maximo = maximo;

        return this;
    }

    public CandlestickBuilder volume(double volume) {
        this._volume = volume;
        return this;
    }

    public CandlestickBuilder data(LocalDate data) {
        this._data = data;
        return this;
    }

    public Candlestick build() {
        return new Candlestick(this._abertura, this._fechamento, this._minimo, 
            this._maximo, this._volume, this._data);
    }
}
