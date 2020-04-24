package br.com.cosati.iattend.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class UserNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=3, max=120, message="O tamenho deve ter entre 5 e 120 caracteres")
	private String name;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=4, max=120, message="O tamenho deve ter entre 5 e 120 caracteres")
	private String lastName;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="E-mail inválido")
	private String email;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String cpf;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String password;
	
	private Integer graduation;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String phone;
	
	public UserNewDTO() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getGraduation() {
		return graduation;
	}

	public void setGraduation(Integer graduation) {
		this.graduation = graduation;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
