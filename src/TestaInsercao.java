
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {

		
		ConnectionFactory cf = new ConnectionFactory();
		Connection con = cf.criaConexao();
 		con.setAutoCommit(false);
 		PreparedStatement stm = con.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
 		
		adicionarVariaveis ("Fogao", "fogao firehouse",stm);
		adicionarVariaveis( "Geladeira", "geladeira freezer", stm);
		
		con.commit();
		stm.close();
		con.close();
	}

	public static void adicionarVariaveis( String nome, String descricao, PreparedStatement stm) throws SQLException {
		
//		if(nome.equals("Geladeira")) {
//			throw new RuntimeException("Nada sera adicionado");
//		}
		
		stm.setString(1, nome);
		stm.setString(2, descricao);
		stm.execute();
		
		ResultSet rst = stm.getGeneratedKeys();
		
		while(rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id foi criado: " + id);
		}
		
		rst.close();
	}
}
