package br.com.felipe.loja_virtual.modelo;

public class Produto {

	private Integer id;
	private String nome;
	private String descricao;
	
	public Produto(int id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public Produto(String nome, String descricao){
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public Produto(){
		
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setId(int id) {
		this.id = id;
		
	}

	public int getId() {
		return this.id;
	}

	
}
