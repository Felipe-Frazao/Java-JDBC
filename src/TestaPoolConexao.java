import java.sql.SQLException;
import java.util.Iterator;

public class TestaPoolConexao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory con = new ConnectionFactory();
		
		for (int i = 0; i < 30; i++) {
			con.criaConexao();
			System.out.println("Numero de conexao: " + i);
			
		}
		

	}

}
