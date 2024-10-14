package br.org.FelipeBert.FipeConsumer.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosVeiculo(@JsonAlias("TipoVeiculo") String tipo,
                           @JsonAlias("Valor")String valor,
                           @JsonAlias("Marca")String marca,
                           @JsonAlias("Modelo")String modelo,
                           @JsonAlias("AnoModelo")String ano,
                           @JsonAlias("Combustivel")String combustivel,
                           @JsonAlias("CodigoFipe")String codigoFipe,
                           @JsonAlias("MesReferencia")String referencia) {

    @Override
    public String toString() {
        return  "tipo='" + tipo + '\'' +
                ", valor='" + valor + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano='" + ano + '\'' +
                ", combustivel='" + combustivel + '\'' +
                ", codigoFipe='" + codigoFipe + '\'' +
                ", referencia='" + referencia + '\'';
    }
}