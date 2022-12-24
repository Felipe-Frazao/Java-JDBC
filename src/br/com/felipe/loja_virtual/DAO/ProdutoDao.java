package br.com.felipe.loja_virtual.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.felipe.loja_virtual.modelo.Produto;

public class ProdutoDao {

	private Connection conexao;
	private String sql;
	
	public ProdutoDao(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void salvar(Produto produto) throws SQLException {
		
		sql = "INSERT INTO PRODUTO(NOME, DESCRICAO) VALUES (? , ?)";
		
		try(PreparedStatement pstm = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());
			
			pstm.execute();
			
			try(ResultSet rst = pstm.getGeneratedKeys()){
				
				while(rst.next()) {
					produto.setId(rst.getInt(1));
					
				}
				
			}
		}
		
	}

	public void delete(Produto produto) throws SQLException {
		
		sql = "DELETE FROM PRODUTO WHERE ID in (?) ";
		
		try(PreparedStatement pstm = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			pstm.setInt(1, 47);//produto.getId());
			pstm.execute();
			int qm = pstm.getUpdateCount();
			System.out.println("quantidade de linhas excluidas = " + qm);
		}
	}

	// ME FONECE APENAS O PRIMEIRO RESULTADO ENCONTRADO
	public Produto pesquisa(Produto produto) throws SQLException {
		
		sql = "SELECT * FROM PRODUTO WHERE NOME IN (?)";
		try(PreparedStatement pstm = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			pstm.setString(1, produto.getNome());
			pstm.execute();
			ResultSet rs = pstm.getResultSet();
			while(rs.next()) {
				Produto found = new Produto(rs.getInt(1),rs.getString(2),rs.getString(3));			
				return found;
			}
			
			
		}
		return null;
		
	}
 // ME FORNECE TODOS OS RESULTADOS ENCONTRADOS
	public List<Produto> pesquisaLista(Produto produto) throws SQLException {
		
	    List<Produto> produtos = new ArrayList<>();
		sql = "SELECT * FROM PRODUTO WHERE NOME IN (?)";
		try(PreparedStatement pstm = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			pstm.setString(1, produto.getNome());
			pstm.execute();
			ResultSet rs = pstm.getResultSet();
			while(rs.next()) {
				Produto found = new Produto(rs.getInt("ID"),rs.getString("NOME"),rs.getString("DESCRICAO"));
				produtos.add(found);
			}
		}
		return produtos;
		
	}
	
	
	
}
