import java.sql.*;


public class TestaListagem {

    public static void main(String[] args) throws SQLException {

        Connection con = DriverManager.
                getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "root");

        Statement stm = con.createStatement();
        stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTTO");

        ResultSet rst = stm.getResultSet();

        while (rst.next()){
            Integer id = rst.getInt("ID");
            System.out.println(id);
            String nome = rst.getString("NOME");
            String descricao = rst.getString("DESCRICAO");
            System.out.println(descricao);
        }

        con.close();
    }

}

