import java.sql.*;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {

		Connection connection = DriverManager.
				getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "root");

		System.out.println("Fechando conexão!");
		connection.close();
	}

}
