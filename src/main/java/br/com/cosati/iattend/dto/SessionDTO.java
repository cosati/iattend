package br.com.cosati.iattend.dto;

import java.io.Serializable;

import br.com.cosati.iattend.domain.Session;
import br.com.cosati.iattend.util.iAttendUtil;

public class SessionDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String date;
	private Integer duration;
	private String description;
	
	public SessionDTO() {}
	
	public SessionDTO(Session session) {
		this.id = session.getId();
		this.date = iAttendUtil.formatDate(session.getDate());
		this.duration = session.getDuration();
		this.description = session.getDescription();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
