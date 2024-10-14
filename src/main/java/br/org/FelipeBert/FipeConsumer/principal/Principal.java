package br.org.FelipeBert.FipeConsumer.principal;

import br.org.FelipeBert.FipeConsumer.model.DadosCodigo;
import br.org.FelipeBert.FipeConsumer.model.Dados;
import br.org.FelipeBert.FipeConsumer.model.DadosVeiculo;
import br.org.FelipeBert.FipeConsumer.service.ConsumoApi;
import br.org.FelipeBert.FipeConsumer.service.ConverterDados;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Locale;
import java.util.Scanner;

public class Principal {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String ADRESS = "https://parallelum.com.br/fipe/api/v1/";

    private final ConsumoApi consumoApi = new ConsumoApi();

    private final ConverterDados conversor = new ConverterDados();

    public void exibiMenu() throws JsonProcessingException {
        System.out.println("***** Opções ****");
        System.out.println("Carros");
        System.out.println("Motos");
        System.out.println("Caminhões\n");

        System.out.println("Digite uma das opções para consultar o valor: ");
        String opcao = scanner.nextLine();
        opcao = opcao.toLowerCase(Locale.ROOT);

        String endereco = ADRESS;

        endereco += opcao + "/marcas/";
        String jsonString = realizaConsulta(endereco);

        var dadosMarca = conversor.obterLista(jsonString, Dados.class);
        dadosMarca.forEach(d -> System.out.println("Codigo " + d.codigo() +" , Marca: " + d.nome()));

        System.out.println("Digite o codigo da marca que deseja consultar: ");
        String codigo = scanner.nextLine();
        endereco +=  codigo + "/modelos/";
        jsonString = realizaConsulta(endereco);

        var dadosModelo = conversor.obterDados(jsonString, DadosCodigo.class);
        dadosModelo.modelos().forEach(m -> System.out.println("Codigo: " + m.codigo() + " Nome: " + m.nome()));

        System.out.println("Digite o codigo do modelo que deseja buscar: ");
        String codigoVeiculo = scanner.nextLine();

        endereco += codigoVeiculo + "/anos/";
        jsonString = realizaConsulta(endereco);
        var dadosVeiculo = conversor.obterLista(jsonString, Dados.class);
        dadosVeiculo.forEach(v -> System.out.println("Codigo: " + v.codigo() + ", Nome: " + v.nome()));

//        for (int i = 0; i < dadosVeiculo.size(); i++) {
//            jsonString = realizaConsulta(ADRESS + opcao + "/marcas/" + codigo + "/modelos/" + codigoVeiculo + "/anos/" + dadosVeiculo.get(i).codigo());
//            var veiculoAno = conversor.obterDados(jsonString, DadosVeiculo.class);
//            System.out.println(veiculoAno);
//        }

        System.out.println("Digite o codigo do ano que deseja buscar: ");
        String codigoAno = scanner.nextLine();

        endereco += codigoAno;
        jsonString = realizaConsulta(endereco);
        var dadosVeiculoAno = conversor.obterDados(jsonString, DadosVeiculo.class);
        System.out.println(dadosVeiculoAno);
    }

    private String realizaConsulta(String endereco){
        return consumoApi.obterDados(endereco);
    }
}
