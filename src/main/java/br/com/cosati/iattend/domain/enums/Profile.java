package br.com.cosati.iattend.domain.enums;

public enum Profile {

	ADMIN(1, "ROLE_ADMIN"),
	STUDENT(2, "ROLE_STUDENT");
	
	private int cod;
	private String description;
	
	private Profile(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescription() {
		return description;
	}
	
public static Profile toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (Profile x : Profile.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Invalid: " + cod);
	}
	
}
