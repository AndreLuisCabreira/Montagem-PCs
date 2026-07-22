import model.SSD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SSDDAO {

    public void inserir(SSD s) {
        String sql = "INSERT INTO ssd (nome, capacidade, leitura, escrita, tipo, preco) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = ConnectionFactory.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getNome());
            ps.setInt(2, s.getCapacidade());
            ps.setInt(3, s.getLeitura());
            ps.setInt(4, s.getEscrita());
            ps.setString(5, s.getTipo());
            ps.setDouble(6, s.getPreco());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SSD buscarPorId(int id) {
        String sql = "SELECT * FROM ssd WHERE id = ?";

        try (Connection con = ConnectionFactory.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new SSD(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getInt("capacidade"),
                        rs.getInt("leitura"),
                        rs.getInt("escrita"),
                        rs.getString("tipo")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<SSD> listar() {

        List<SSD> lista = new ArrayList<>();

        String sql = "SELECT * FROM ssd";

        try (Connection con = ConnectionFactory.getConexao();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                SSD ssd = new SSD(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getDouble("preco"),
                    rs.getInt("capacidade"),
                    rs.getInt("leitura"),
                    rs.getInt("escrita"),
                    rs.getString("tipo")
                );

                lista.add(ssd);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}