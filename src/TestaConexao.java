import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory cf = new ConnectionFactory();
		
		Connection con = cf.criaConexao();
		
		System.out.println("Fechando conexao");
		
		con.close();
	}

}
