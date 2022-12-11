import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {
	
	
	public void query() throws SQLException {
		
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
	
	public void insert() throws SQLException{
		
 		Connection con = ConnectionFactory.criaConexao();
		Statement stm = con.createStatement();
		stm.execute("INSERT INTO produto (nome, descricao) values ('Fogao', 'fogao brastemp')", Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = stm.getGeneratedKeys();
		
	}
	
	public void remove() throws SQLException {
		Connection con = ConnectionFactory.criaConexao();
		Statement stm = con.createStatement();
		stm.execute("Delete from produto where id > 2");
		int qm = stm.getUpdateCount();
		System.out.println("quantidade de linhas excluidas = " + qm);
		
	}

	public static void main(String[] args) throws SQLException{
		

		TestaListagem tl = new TestaListagem();
		tl.insert();
		tl.query();
		tl.remove();
		tl.query();
	}

}
