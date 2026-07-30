import model.Jogo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JogoDAO {

    public void criarTabelaSeNaoExistir() {
        String sql = """
                CREATE TABLE IF NOT EXISTS jogo (
                    id INT PRIMARY KEY AUTO_INCREMENT,
                    nome VARCHAR(100) NOT NULL,
                    exigencia_cpu INT NOT NULL,
                    exigencia_gpu INT NOT NULL
                )
                """;

        try (Connection con = ConnectionFactory.getConexao();
             Statement stmt = con.createStatement()) {
            stmt.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void inserir(Jogo jogo) {
        criarTabelaSeNaoExistir();

        String sql = "INSERT INTO jogo (nome, exigencia_cpu, exigencia_gpu) VALUES (?, ?, ?)";

        try (Connection con = ConnectionFactory.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, jogo.getNome());
            ps.setInt(2, jogo.getExigenciaCpu());
            ps.setInt(3, jogo.getExigenciaGpu());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Jogo buscarPorId(int id) {
        criarTabelaSeNaoExistir();

        String sql = "SELECT * FROM jogo WHERE id = ?";

        try (Connection con = ConnectionFactory.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Jogo jogo = new Jogo();
                jogo.setId(rs.getInt("id"));
                jogo.setNome(rs.getString("nome"));
                jogo.setExigenciaCpu(rs.getInt("exigencia_cpu"));
                jogo.setExigenciaGpu(rs.getInt("exigencia_gpu"));
                return jogo;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Jogo> listar() {
        criarTabelaSeNaoExistir();

        List<Jogo> lista = new ArrayList<>();
        String sql = "SELECT * FROM jogo ORDER BY id";

        try (Connection con = ConnectionFactory.getConexao();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Jogo jogo = new Jogo();
                jogo.setId(rs.getInt("id"));
                jogo.setNome(rs.getString("nome"));
                jogo.setExigenciaCpu(rs.getInt("exigencia_cpu"));
                jogo.setExigenciaGpu(rs.getInt("exigencia_gpu"));
                lista.add(jogo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
