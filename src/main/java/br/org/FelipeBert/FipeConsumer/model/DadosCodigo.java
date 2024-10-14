package br.org.FelipeBert.FipeConsumer.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosCodigo(@JsonAlias("modelos") List<Dados> modelos) {
}
