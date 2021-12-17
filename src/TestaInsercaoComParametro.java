import java.sql.*;

public class TestaInsercaoComParametro {
    public static void main(String[] args) throws SQLException {
        String nome = "Mouse";
        String descricao = "Mouse sem fio); delete from Produto;";
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.recuperarConexao();

        connection.setAutoCommit(false);

        try {
            PreparedStatement stm =
                    connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);

            adicionarVariavel("Smart TV", "45 polegadas", stm);
            adicionarVariavel("Radio", "Radio de bateria", stm);

            connection.commit();
            stm.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ROLLBACK executado");
            connection.rollback();
        }

        connection.close();
    }

    private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
        stm.setString(1, nome);
        stm.setString(2, descricao);

        stm.execute();

        ResultSet rst = stm.getGeneratedKeys();
        while (rst.next()){
            Integer id = rst.getInt(1);
            System.out.println("O ID criado foi: "+id);
        }
    }
}
