package br.com.felipe.loja_virtual.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

	public Produto pesquisa(Produto produto) throws SQLException {
		Produto found = new Produto();
		sql = "SELECT * FROM PRODUTO WHERE NOME IN (?)";
		try(PreparedStatement pstm = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			pstm.setString(1, produto.getNome());
			pstm.execute();
			ResultSet rs = pstm.getResultSet();
			while(rs.next()) {
				found.setId(rs.getInt("ID")); 
				found.setNome(rs.getString("NOME"));
				found.setDescricao(rs.getString("DESCRICAO")); 	
				
				return found;
			}
			
			
		}
		return null;
		
	}
	
	
	
}
