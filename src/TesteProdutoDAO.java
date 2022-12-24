import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.felipe.loja_virtual.DAO.ProdutoDao;
import br.com.felipe.loja_virtual.modelo.Produto;

public class TesteProdutoDAO {

	public static void main(String[] args) throws SQLException {
		
		Produto comoda = new Produto("Painel", "32 polegadas");
		
		try(Connection con = new ConnectionFactory().criaConexao()){
			
			ProdutoDao  produtoDao = new ProdutoDao(con);
//			produtoDao.salvar(comoda);
//			produtoDao.delete(comoda);
			
			Produto produto = new Produto();
			produto.setNome("fogao");//SETTANDO O O NOME PRODUTO
			
			//PASSANDO O PRODUTO COM APENAS UMA INFORMAÇAO, QUE IRA PESQUISAR E RETORNAR COM TODOS OS DADOS DO PRODUTO
			Produto pr = produtoDao.pesquisa(produto);
			System.out.println(pr.getId() + ","+ pr.getNome() + ", "+ pr.getDescricao());
			
			//RETORNA TODOS OS DADOS COM O MESMO NOME FORNECIDO
			List<Produto> pesquisa = produtoDao.pesquisaLista(produto);
			pesquisa.forEach(p -> System.out.println(p.getId()+ " - " + p.getNome()));
		}
	}

}
