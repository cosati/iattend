package br.com.cosati.iattend.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Entity;

import br.com.cosati.iattend.domain.enums.Graduation;
import br.com.cosati.iattend.domain.enums.Profile;

@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String lastName;
	private String email;
	private String cpf;
	private Integer graduation;

	private String password;
	
	private String address;
	private Set<String> phones = new HashSet<>();
	
	private Set<Integer> profiles = new HashSet<>();
	
	public User() {}

	public User(Integer id, String name, String lastName, String email, String cpf, Graduation graduation, String password,
			String address) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.cpf = cpf;
		this.graduation = (graduation == null) ? null : graduation.getCod();
		this.password = password;
		this.address = address;		
		//TODO add Profile
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Graduation getGraduation() {
		return Graduation.toEnum(graduation);
	}

	public void setGraduation(Graduation graduation) {
		this.graduation = graduation.getCod();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public Set<Profile> getProfiles() {
		return this.profiles.stream().map(x -> Profile.toEnum(x)).collect(Collectors.toSet());
	}	
	
	public Set<String> getPhones() {
		return phones;
	}

	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}

	public void addProfile(Profile profile) {
		this.profiles.add(profile.getCod());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
	
}
