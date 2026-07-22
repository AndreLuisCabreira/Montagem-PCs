import model.PlacaMae;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlacaMaeDAO {

    public void inserir(PlacaMae p) {
        String sql = "INSERT INTO placa_mae (nome, fabricante, socket, tipo_memoria, consumo, preco) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = ConnectionFactory.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getNome());
            ps.setString(2, p.getFabricante());
            ps.setString(3, p.getSocket());
            ps.setString(4, p.getTipoMemoria());
            ps.setInt(5, p.getConsumo());
            ps.setDouble(6, p.getPreco());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PlacaMae buscarPorId(int id) {
        String sql = "SELECT * FROM placa_mae WHERE id = ?";

        try (Connection con = ConnectionFactory.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new PlacaMae(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getString("fabricante"),
                        rs.getString("socket"),
                        rs.getString("tipo_memoria"),
                        rs.getInt("consumo")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<PlacaMae> listar() {

        List<PlacaMae> lista = new ArrayList<>();

        String sql = "SELECT * FROM placa_mae";

        try (Connection con = ConnectionFactory.getConexao();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                PlacaMae placaMae = new PlacaMae(

                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getDouble("preco"),
                    rs.getString("fabricante"),
                    rs.getString("socket"),
                    rs.getString("tipo_memoria"),
                    rs.getInt("consumo")
                );

                lista.add(placaMae);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}