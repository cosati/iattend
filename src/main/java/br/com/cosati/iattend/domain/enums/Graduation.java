package br.com.cosati.iattend.domain.enums;

public enum Graduation {

	WHITE(1, "7º Kyu - Branca"),
	YELLOW(2, "6º Kyu - Amarela"),
	RED(3, "5º Kyu - Vermelha"),
	ORANGE(4, "4º Kyu - Laranja"),
	GREEN(5, "3º Kyu - Verde"),
	PURPLE(6, "2º Kyu - Roxa"),
	BROWN(7, "1º Kyu - Marrom"),
	BLACK(8, "2º Dan - Preta"),
	BLACK2(9, "3º Dan - Preta"),
	BLACK3(10, "4º Dan - Preta"),
	BLACK4(11, "5º Dan - Preta"),
	BLACK5(12, "6º Dan - Preta");
	
	private int cod;
	private String description;
	
	private Graduation(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}

	public static Graduation toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (Graduation x : Graduation.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}		
		throw new IllegalArgumentException("Invalid code: " + cod);
	}
	
}
