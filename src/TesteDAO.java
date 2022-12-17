import java.sql.Connection;
import java.sql.SQLException;

import br.com.felipe.loja_virtual.DAO.ProdutoDao;
import br.com.felipe.loja_virtual.modelo.Produto;

public class TesteDAO {

	public static void main(String[] args) throws SQLException {
		
		Produto comoda = new Produto("Painel", "32 polegadas");
		
		try(Connection con = new ConnectionFactory().criaConexao()){
			
			ProdutoDao  produtoDao = new ProdutoDao(con);
//			produtoDao.salvar(comoda);
//			produtoDao.delete(comoda);
			
			Produto produto = new Produto();
			produto.setNome("Guarda-Roupas");//SETTANDO O O NOME PRODUTO
			Produto pr = produtoDao.pesquisa(produto);//PASSANDO O PRODUTO COM APENAS UMA INFORMAÇAO, QUE IRA PESQUISAR E RETORNAR COM TODOS OS DADOS DO PRODUTO
			System.out.println(pr.getId() + ","+ pr.getNome() + ", "+ pr.getDescricao());
		}
	}

}
