import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.felipe.loja_virtual.DAO.CategoriaDAO;
import br.com.felipe.loja_virtual.modelo.Categoria;

public class TestaCategoriaDAO {

	public static void main(String[] args) throws SQLException {
		
		try(Connection con = new ConnectionFactory().criaConexao()){
			CategoriaDAO categoria = new CategoriaDAO(con);
			List<Categoria> categorias = categoria.listar();
			
			categorias.forEach(c -> System.out.println(c.getId() +"," + c.getNome()));
		}
		
		

	}

}
