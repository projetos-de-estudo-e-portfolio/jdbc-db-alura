import java.sql.*;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory criaConexao = new ConnectionFactory();
		Connection connection = criaConexao.recuperarConexao();

		System.out.println("Fechando conexão!");
		connection.close();
	}

}
