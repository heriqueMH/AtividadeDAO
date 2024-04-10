/**
 * @author Matheus Henrique de Oliveira Santos - R.A 10409051 
*/

package br.mackenzie.interface_concetion;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GerenciadorNomesApplication implements CommandLineRunner {

    public GerenciadorNomesApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(GerenciadorNomesApplication.class, args);
    }
    @Override
    public void run(String... args) {
        try {
            System.out.println("EXECUTING: command line runner");

            BancoInicializador bancoInicializador = new BancoInicializador();
            bancoInicializador.criarTabela();

            NomeDAO nomeDAO = new NomeDAOImpl();
            Ihm ihm = new Ihm(nomeDAO);
            ihm.dialogar();

        } catch (Exception e) {
            System.out.println("Erro saindo...");
            e.printStackTrace();
        }
    }
}

