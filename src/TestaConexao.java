import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		
		
		Connection con = ConnectionFactory.criaConexao();
		
		System.out.println("Fechando conexao");
		
		con.close();
	}

}
