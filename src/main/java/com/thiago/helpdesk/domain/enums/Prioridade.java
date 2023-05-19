package com.thiago.helpdesk.domain.enums;

public enum Prioridade {

	BAIXA(0, "BAIXA"),MEDIA(1,"MEDIA"),ALTA(2,"ALTA");
	
	private Integer codigo;
	private String descricao;
	
	
	private Prioridade(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public static Prioridade toEnum(Integer codigo) {
		if(codigo == null) {
			return null;
		}
		
		for(Prioridade prioridade : Prioridade.values()) {
			if(codigo == prioridade.getCodigo()) {
				return prioridade;
			}
		}
		throw new IllegalArgumentException("Prioridade inválida!");
	}

	public Integer getCodigo() {
		return codigo;
	}


	public String getDescricao() {
		return descricao;
	}
	
	
}
