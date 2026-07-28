import model.PlacaVideo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlacaVideoDAO {

    public void inserir(PlacaVideo p) {
        String sql = "INSERT INTO placa_video (nome, fabricante, memoria, consumo, preco, desempenho) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = ConnectionFactory.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getNome());
            ps.setString(2, p.getFabricante());
            ps.setInt(3, p.getMemoria());
            ps.setInt(4, p.getConsumo());
            ps.setDouble(5, p.getPreco());
            ps.setInt(6, p.getDesempenho());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PlacaVideo buscarPorId(int id) {
        String sql = "SELECT * FROM placa_video WHERE id = ?";

        try (Connection con = ConnectionFactory.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new PlacaVideo(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getString("fabricante"),
                        rs.getInt("memoria"),
                        rs.getInt("consumo"),
                        rs.getInt("desempenho")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<PlacaVideo> listar() {

        List<PlacaVideo> lista = new ArrayList<>();

        String sql = "SELECT * FROM placa_video";

        try (Connection con = ConnectionFactory.getConexao();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                PlacaVideo p = new PlacaVideo(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getString("fabricante"),
                        rs.getInt("memoria"),
                        rs.getInt("consumo"),
                        rs.getInt("desempenho")
                );

                lista.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}