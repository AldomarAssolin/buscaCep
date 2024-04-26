package br.com.aldomarassolin.modelos;

import br.com.aldomarassolin.consultas.ConsultaCep;

import java.io.IOException;


public class Main{

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        ConsultaCep consultaCep = new ConsultaCep();

        try {
            Endereco newEndereco = consultaCep.buscaEndereco("");
            System.out.println(newEndereco);
            GerarArquivo gerar = new GerarArquivo();
            gerar.salvarJson(newEndereco);
        }catch (RuntimeException | IOException e){
            System.out.println("Opss. houve um problema ao buscar esta informação");
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Volte Sempre!");
        }



    }




}