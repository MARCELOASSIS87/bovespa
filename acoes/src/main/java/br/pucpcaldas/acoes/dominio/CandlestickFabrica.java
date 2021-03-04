package br.pucpcaldas.acoes.dominio;

import java.util.List;

import org.joda.time.LocalDate;

public class CandlestickFabrica {

    public Candlestick constroiCandleParaData(List<Negocio> negocios, LocalDate data) {
        double abertura = negocios.get(0).getPreco();
        double fechamento = negocios.get(negocios.size() - 1).getPreco();

        double minimo = negocios.get(0).getPreco();
        double maximo = negocios.get(0).getPreco();
        double volume = 0.0;

        for (Negocio negocio : negocios) {
            volume += negocio.getVolume();

            double preco = negocio.getPreco();
            if (preco > maximo) {
                maximo = preco;
            } else if (preco < minimo) {
                minimo = preco;
            }
        }

        return new Candlestick(abertura, fechamento, minimo, maximo, volume, data);
    }

}
