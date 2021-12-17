import java.sql.*;


public class TestaListagem {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory criaConexao = new ConnectionFactory();
        Connection connection = criaConexao.recuperarConexao();

        PreparedStatement stm = connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTTO");
        stm.execute();

        ResultSet rst = stm.getResultSet();

        while (rst.next()){
            Integer id = rst.getInt("ID");
            System.out.println(id);
            String nome = rst.getString("NOME");
            String descricao = rst.getString("DESCRICAO");
            System.out.println(descricao);
        }

        connection.close();
    }

}

