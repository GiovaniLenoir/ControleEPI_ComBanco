import java.sql.*;
import java.util.ArrayList;

public class EmprestimoDao {
    public void inserirEmprestimo(Emprestimo emp) {
        String sql = "INSERT INTO emprestimo (id_colaborador, id_epi, data_emprestimo) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, emp.getIdColaborador());
            stmt.setInt(2, emp.getIdEpi());
            stmt.setString(3, emp.getDataEmprestimo());
            stmt.executeUpdate();
            System.out.println("Empréstimo registrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir empréstimo: " + e.getMessage());
        }
    }

    public ArrayList<Emprestimo> listarEmprestimos() {
        ArrayList<Emprestimo> lista = new ArrayList<>();
        String sql = "SELECT * FROM emprestimo";
        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Emprestimo emp = new Emprestimo(
                        rs.getInt("id_emprestimo"),
                        rs.getInt("id_colaborador"),
                        rs.getInt("id_epi"),
                        rs.getString("data_emprestimo")
                );
                lista.add(emp);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar empréstimos: " + e.getMessage());
        }
        return lista;
    }

    public void atualizarEmprestimo(Emprestimo emp) {
        String sql = "UPDATE emprestimo SET id_colaborador = ?, id_epi = ?, data_emprestimo = ? WHERE id_emprestimo = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, emp.getIdColaborador());
            stmt.setInt(2, emp.getIdEpi());
            stmt.setString(3, emp.getDataEmprestimo());
            stmt.setInt(4, emp.getId());
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Empréstimo atualizado com sucesso!");
            } else {
                System.out.println("Empréstimo não encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar empréstimo: " + e.getMessage());
        }
    }

    public void excluirEmprestimo(int id) {
        String sql = "DELETE FROM emprestimo WHERE id_emprestimo = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Empréstimo excluído com sucesso!");
            } else {
                System.out.println("Empréstimo não encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao excluir empréstimo: " + e.getMessage());
        }
    }
}

