/**
 * @author Matheus Henrique de Oliveira Santos - R.A 10409051 
*/

package br.mackenzie.interface_concetion;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class Ihm {

    private final NomeDAO nomeDAO;
    private final Scanner entrada;

    public Ihm(NomeDAO nomeDAO) {
        this.nomeDAO = nomeDAO;
        this.entrada = new Scanner(System.in);
    }

    public void dialogar() {
        boolean sair = false;
        while (!sair) {
            System.out.println("\n>> MENU PRINCIPAL:");
            System.out.println("(1) Listar nomes");
            System.out.println("(2) Adicionar Nome");
            System.out.println("(3) Deletar Nome");
            System.out.println("(4) Sair");
            System.out.print("Escolha uma opção: ");
            String op = entrada.nextLine();
            switch (op) {
                case "1":
                    listar();
                    break;
                case "2":
                    adicionar();
                    break;
                case "3":
                    deletar();
                    break;
                case "4":
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        System.out.println("Fim do programa!");
    }

    private void listar() {
        List<String> nomes = nomeDAO.obterNomes();
        System.out.println("\n>> Lista dos nomes:");
        for (String nome : nomes) {
            System.out.println(nome);
        }
    }

    private void adicionar() {
        System.out.print("\n>> Digite o novo nome: ");
        String novoNome = entrada.nextLine();
        nomeDAO.adicionarNome(novoNome);
    }

    private void deletar() {
        System.out.print("\n>> Digite o nome a ser deletado: ");
        String nome = entrada.nextLine();
        nomeDAO.deletar(nome);
    }
}
