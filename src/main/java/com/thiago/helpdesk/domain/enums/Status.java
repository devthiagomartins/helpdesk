package com.thiago.helpdesk.domain.enums;

public enum Status {

	ABERTO(0, "ABERTO"),ANDAMENTO(1,"ANDAMENTO"),ENCERRADO(2,"ENCERRADO");
	
	private Integer codigo;
	private String descricao;
	
	
	private Status(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public static Status toEnum(Integer codigo) {
		if(codigo == null) {
			return null;
		}
		
		for(Status status : Status.values()) {
			if(codigo == status.getCodigo()) {
				return status;
			}
		}
		throw new IllegalArgumentException("Status inválido!");
	}

	public Integer getCodigo() {
		return codigo;
	}


	public String getDescricao() {
		return descricao;
	}
	
	
}
