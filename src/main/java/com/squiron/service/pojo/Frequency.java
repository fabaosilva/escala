package com.squiron.service.pojo;

public enum Frequency {
	
	UNICO(1,"Único"),DIARIA(2,"Diária"),SEMANAL(3,"Semanal"),QUINZENAL(4,"Quinzenal"),MENSAL(5,"Mensal");
	
	private int id;
	
	private String nome;
	
	private Frequency(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
