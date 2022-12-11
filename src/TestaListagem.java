import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

	public static void main(String[] args) throws SQLException{
		
			Connection con = ConnectionFactory.criaConexao();
		
			Statement stm = con.createStatement();
			stm.execute("SELECT id, nome,descricao FROM produto");
			ResultSet rs = stm.getResultSet();
			while(rs.next()) {
				Integer id = rs.getInt("ID");
				String nome = rs.getString("NOME");
				String descricao = rs.getString("DESCRICAO");
				System.out.println( id + "\n" + nome + "\n" + descricao);
			}
		con.close();

	}

}
