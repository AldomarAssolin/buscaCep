package br.com.aldomarassolin.consultas;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import br.com.aldomarassolin.modelos.Endereco;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class ConsultaCep {
    public Endereco buscaEndereco(String cep) throws InstantiationException, IllegalAccessException {

        Scanner writer = new Scanner(System.in);
        System.out.println("Digite o cep para consulta: ");
        cep = writer.nextLine();

        URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json/");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson((String) response.body(), Endereco.class);
        } catch (IOException | JsonSyntaxException | InterruptedException e) {
            throw new RuntimeException(e + "\nNão foi possível encontrar os dados para esta busca.\n");
        }



    }

}
