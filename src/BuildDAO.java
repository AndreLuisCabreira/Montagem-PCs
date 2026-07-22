import model.Build;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BuildDAO {

    public void inserir(Build b) {

        String sql = """
                INSERT INTO build
                (nome,
                usuario_id,
                processador_id,
                placa_mae_id,
                placa_video_id,
                memoria_id,
                ssd_id,
                fonte_id,
                favorita)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (Connection con = ConnectionFactory.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, b.getNome());
            ps.setInt(2, b.getUsuarioId());

            ps.setInt(3, b.getProcessador().getId());
            ps.setInt(4, b.getPlacaMae().getId());
            ps.setInt(5, b.getPlacaVideo().getId());
            ps.setInt(6, b.getMemoria().getId());
            ps.setInt(7, b.getSsd().getId());
            ps.setInt(8, b.getFonte().getId());

            ps.setBoolean(9, b.isFavorita());

            ps.executeUpdate();

            System.out.println("Build cadastrada com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Build buscarPorId(int id) {

        String sql = "SELECT * FROM build WHERE id = ?";

        try (Connection con = ConnectionFactory.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                ProcessadorDAO processadorDAO = new ProcessadorDAO();
                PlacaMaeDAO placaMaeDAO = new PlacaMaeDAO();
                PlacaVideoDAO placaVideoDAO = new PlacaVideoDAO();
                MemoriaDAO memoriaDAO = new MemoriaDAO();
                SSDDAO ssdDAO = new SSDDAO();
                FonteDAO fonteDAO = new FonteDAO();

                Build build = new Build();

                build.setId(rs.getInt("id"));
                build.setNome(rs.getString("nome"));
                build.setUsuarioId(rs.getInt("usuario_id"));

                build.setProcessador(
                        processadorDAO.buscarPorId(rs.getInt("processador_id")));

                build.setPlacaMae(
                        placaMaeDAO.buscarPorId(rs.getInt("placa_mae_id")));

                build.setPlacaVideo(
                        placaVideoDAO.buscarPorId(rs.getInt("placa_video_id")));

                build.setMemoria(
                        memoriaDAO.buscarPorId(rs.getInt("memoria_id")));

                build.setSsd(
                        ssdDAO.buscarPorId(rs.getInt("ssd_id")));

                build.setFonte(
                        fonteDAO.buscarPorId(rs.getInt("fonte_id")));

                build.setFavorita(rs.getBoolean("favorita"));

                return build;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Build> listar() {

        List<Build> builds = new ArrayList<>();

        String sql = "SELECT * FROM build";

        try (Connection con = ConnectionFactory.getConexao();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            ProcessadorDAO processadorDAO = new ProcessadorDAO();
            PlacaMaeDAO placaMaeDAO = new PlacaMaeDAO();
            PlacaVideoDAO placaVideoDAO = new PlacaVideoDAO();
            MemoriaDAO memoriaDAO = new MemoriaDAO();
            SSDDAO ssdDAO = new SSDDAO();
            FonteDAO fonteDAO = new FonteDAO();

            while (rs.next()) {

                Build build = new Build();

                build.setId(rs.getInt("id"));
                build.setNome(rs.getString("nome"));
                build.setUsuarioId(rs.getInt("usuario_id"));

                build.setProcessador(
                        processadorDAO.buscarPorId(rs.getInt("processador_id")));

                build.setPlacaMae(
                        placaMaeDAO.buscarPorId(rs.getInt("placa_mae_id")));

                build.setPlacaVideo(
                        placaVideoDAO.buscarPorId(rs.getInt("placa_video_id")));

                build.setMemoria(
                        memoriaDAO.buscarPorId(rs.getInt("memoria_id")));

                build.setSsd(
                        ssdDAO.buscarPorId(rs.getInt("ssd_id")));

                build.setFonte(
                        fonteDAO.buscarPorId(rs.getInt("fonte_id")));

                build.setFavorita(rs.getBoolean("favorita"));

                builds.add(build);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return builds;
    }

    public void atualizar(Build b) {

        String sql = """
            UPDATE build
            SET nome = ?,
                usuario_id = ?,
                processador_id = ?,
                placa_mae_id = ?,
                placa_video_id = ?,
                memoria_id = ?,
                ssd_id = ?,
                fonte_id = ?,
                favorita = ?
            WHERE id = ?
            """;

        try (Connection con = ConnectionFactory.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, b.getNome());
            ps.setInt(2, b.getUsuarioId());

            ps.setInt(3, b.getProcessador().getId());
            ps.setInt(4, b.getPlacaMae().getId());
            ps.setInt(5, b.getPlacaVideo().getId());
            ps.setInt(6, b.getMemoria().getId());
            ps.setInt(7, b.getSsd().getId());
            ps.setInt(8, b.getFonte().getId());

            ps.setBoolean(9, b.isFavorita());

            ps.setInt(10, b.getId());

            ps.executeUpdate();

            System.out.println("Build atualizada com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {

        String sql = "DELETE FROM build WHERE id = ?";

        try (Connection con = ConnectionFactory.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Build excluída com sucesso!");
            } else {
                System.out.println("Nenhuma build encontrada com esse ID.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}