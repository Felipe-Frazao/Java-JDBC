package br.com.felipe.loja_virtual.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.felipe.loja_virtual.modelo.Categoria;
import br.com.felipe.loja_virtual.modelo.Produto;

public class CategoriaDAO {

	private Connection conexao;
	private String sql;
	
	
	public CategoriaDAO(Connection con) {
		this.conexao = con;
	}

	public List<Categoria> listar() throws SQLException {
		List<Categoria> categorias = new ArrayList<>();
		sql = "SELECT * FROM CATEGORIA";
		try(PreparedStatement pstm = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			pstm.execute();
			ResultSet rs = pstm.getResultSet();
			while(rs.next()) {
				Categoria categoria = new Categoria(rs.getInt("ID"),rs.getString("NOME"));
				categorias.add(categoria);
			}
			
		}
		return categorias;
	}

	public List<Categoria> exibir() throws SQLException{
		
		Categoria ultima = null;
		List<Categoria> categorias = new ArrayList<>();
		sql = "SELECT * FROM CATEGORIA C INNER JOIN PRODUTO P ON C.ID = P.CATEGORIA_ID";
		
		try(PreparedStatement pstm = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			pstm.execute();
			ResultSet rs = pstm.getResultSet();
			while(rs.next()) {
				if (ultima == null || !ultima.getNome().equals(rs.getString(2))) {
					Categoria categoria = new Categoria(rs.getInt(1),rs.getString(2));
					ultima = categoria;
					categorias.add(categoria);
				}
			Produto produto = new Produto(rs.getInt(3),rs.getString(4), rs.getString(5));
			ultima.adiciona(produto);
			}
		}	
		return categorias;
	}
	
}