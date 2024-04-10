/**
 * @author Matheus Henrique de Oliveira Santos - R.A 10409051 
*/

package br.mackenzie.interface_concetion;

import java.util.List;

public interface NomeDAO {
    List<String> obterNomes();

    void adicionarNome(String nome);

    void deletar(String nome);
}