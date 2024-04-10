/**
 * @author Matheus Henrique de Oliveira Santos - R.A 10409051 
*/

package br.mackenzie.interface_concetion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BancoInicializador {
    private Connection conn = CriaConexao.getConnection();

    public BancoInicializador() {
    }

    public void criarTabela() {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS nomes (id INT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(255))";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println("Tabela 'nomes' criada com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela 'nomes': " + e.getMessage());
        }
    }
}
