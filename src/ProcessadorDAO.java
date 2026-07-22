import model.Processador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProcessadorDAO {

    public void inserir(Processador p) {
        String sql = "INSERT INTO processador (nome, socket, consumo, preco, fabricante, nucleos, threads, desempenho) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = ConnectionFactory.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getNome());
            ps.setString(2, p.getSocket());
            ps.setInt(3, p.getConsumo());
            ps.setDouble(4, p.getPreco());
            ps.setString(5, p.getFabricante());
            ps.setInt(6, p.getNucleos());
            ps.setInt(7, p.getThreads());
            ps.setDouble(8, p.getDesempenho());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Processador buscarPorId(int id) {
        String sql = "SELECT * FROM processador WHERE id = ?";

        try (Connection con = ConnectionFactory.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Processador(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getString("fabricante"),
                        rs.getString("socket"),
                        rs.getInt("nucleos"),
                        rs.getInt("threads"),
                        rs.getInt("consumo"),
                        rs.getDouble("desempenho")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public List<Processador> listar() {
        List<Processador> lista = new ArrayList<>();

        String sql = "SELECT * FROM processador";

        try (Connection con = ConnectionFactory.getConexao();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Processador p = new Processador(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getString("fabricante"),
                        rs.getString("socket"),
                        rs.getInt("nucleos"),
                        rs.getInt("threads"),
                        rs.getInt("consumo"),
                        rs.getDouble("desempenho")
                );

                lista.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}