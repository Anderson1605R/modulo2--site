package agenciaCrud.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import agenciaCrud.Compra;
import agenciaCrud.Conexao;
import agenciaCrud.PacoteDeViagem;
import agenciaCrud.User;

public class ComprasDAO extends Compra {

    public ComprasDAO() {
        super();
    }

    public ComprasDAO(User user, PacoteDeViagem pacote, int idCompra) {
        super(user, pacote, idCompra);
    }

    public static void create(Compra compra) {
        String sql = "INSERT INTO Compra (Id_user, ID_pacote) VALUES (?, ?)";

        try (Connection conn = Conexao.createConnectionToMysql();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setInt(1, compra.getUser().getId());
            pstm.setInt(2, compra.getPacote().getIdPacote());

            pstm.execute();

            System.out.println("Criado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id) {
        String sql = "DELETE FROM compra WHERE Id_compra = ?";

        try (Connection conn = Conexao.createConnectionToMysql();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setInt(1, id);

            pstm.execute();

            System.out.println("Deletado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Compra> getCompras() {
        String sql = "SELECT c.Id_compra, c.Id_user, c.ID_pacote, u.nome, p.destino " +
                     "FROM Compra c " +
                     "JOIN User u ON c.Id_user = u.Id_user " +
                     "JOIN Pacote p ON c.ID_pacote = p.ID_pacote";

        List<Compra> compras = new ArrayList<Compra>();

        try (Connection conn = Conexao.createConnectionToMysql();
             PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet rset = pstm.executeQuery()) {

            while (rset.next()) {
                int idCompra = rset.getInt("Id_compra");
                int idUser = rset.getInt("Id_user");
                int idPacote = rset.getInt("ID_pacote");
           

                User user = new User(); // You need to implement a method to retrieve User details by ID
                user.setId(idUser);
                // Populate other User details

                PacoteDeViagem pacote = new PacoteDeViagem(); // You need to implement a method to retrieve Pacote details by ID
                pacote.setIdPacote(idPacote);
                // Populate other Pacote details

                Compra compra = new Compra(user, pacote, idCompra);
                compras.add(compra);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return compras;
    }
}