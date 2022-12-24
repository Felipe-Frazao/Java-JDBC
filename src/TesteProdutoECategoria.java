import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.felipe.loja_virtual.DAO.CategoriaDAO;
import br.com.felipe.loja_virtual.modelo.Categoria;
import br.com.felipe.loja_virtual.modelo.Produto;

public class TesteProdutoECategoria {

	public static void main(String[] args) throws SQLException {
		
		try(Connection con = new ConnectionFactory().criaConexao()){
			CategoriaDAO categoria = new CategoriaDAO(con);
			
			List<Categoria> listaCategoria = categoria.exibir();
			listaCategoria.forEach(lc ->{ 
					try {
						for(Produto produto : lc.getProdutos()) {
						System.out.println("Produto: "+produto.getNome()+ " - " + " Categoria: "+ lc.getNome() + " Descrição: " + produto.getDescricao());	
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
			});
		}
		
		

	}

}
