import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {
	
	
	public void query() throws SQLException {
		
		Connection con = ConnectionFactory.criaConexao();
		
		PreparedStatement stm = con.prepareStatement("SELECT id, nome,descricao FROM produto");
		stm.execute();
		ResultSet rs = stm.getResultSet();
		while(rs.next()) {
			Integer id = rs.getInt("ID");
			String nome = rs.getString("NOME");
			String descricao = rs.getString("DESCRICAO");
			System.out.println( id + "\n" + nome + "\n" + descricao);
		}
		con.close();
	}
	
	public void insert(String produto, String descricao) throws SQLException{
		
 		Connection con = ConnectionFactory.criaConexao();
 		con.setAutoCommit(false);
 		PreparedStatement stm = con.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
		stm.setString(1, produto);
		stm.setString(2, descricao);
		stm.execute();
		ResultSet rs = stm.getGeneratedKeys();
		
	}
	
	public void remove() throws SQLException {
		Connection con = ConnectionFactory.criaConexao();
		PreparedStatement stm = con.prepareStatement("Delete from produto where id > ?");
		stm.setInt(1, 2);
		stm.execute();
		int qm = stm.getUpdateCount();
		System.out.println("quantidade de linhas excluidas = " + qm);
		
	}

	public static void main(String[] args) throws SQLException{
		

		TestaListagem tl = new TestaListagem();
//		tl.insert("fogao", "fogao brastemp");
//		tl.insert("fogao", "Microondas consul");
		tl.query();
//		tl.remove();
//		tl.query();
	}

}
