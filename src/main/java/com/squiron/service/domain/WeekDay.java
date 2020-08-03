package com.squiron.service.domain;

public enum WeekDay {

	DOMINGO(1, "domingo"), SEGUNDA(2, "segunda"), TERCA(3, "terca"), QUARTA(4, "quarta"), QUINTA(5, "quinta"),
	SEXTA(6, "sexta"), SABADO(7, "sábado");

	private int id;
	private String nome;

	private WeekDay(int id, String nome) {
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
