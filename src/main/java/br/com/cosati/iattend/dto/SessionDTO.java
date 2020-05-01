package br.com.cosati.iattend.dto;

import java.io.Serializable;

import br.com.cosati.iattend.domain.Session;
import br.com.cosati.iattend.domain.User;
import br.com.cosati.iattend.util.iAttendUtil;

public class SessionDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String place;
	private String address;
	private String dayOfWeek;
	private String start;
	private String end;
	private boolean checkedIn;
	
	public SessionDTO() {}
	
	public SessionDTO(Session session) {
		this.id = session.getId();
		this.place = session.getDojo().getName();
		this.address = session.getDojo().getAddress().toString();
		this.dayOfWeek = iAttendUtil.dayOfWeek(session.getStart());
		this.start = iAttendUtil.formatDate(session.getStart());
		this.end = iAttendUtil.formatDate(session.getEnd());
	}
	
	public SessionDTO(Session session, Integer userId) {
		this.id = session.getId();
		this.place = session.getDojo().getName();
		this.address = session.getDojo().getAddress().toString();
		this.dayOfWeek = iAttendUtil.dayOfWeek(session.getStart());
		this.start = iAttendUtil.formatDate(session.getStart());
		this.end = iAttendUtil.formatDate(session.getEnd());
		this.checkedIn = false;
		for (User user : session.getUsers()) {
			if (user.getId().equals(userId)) {
				this.checkedIn = true;
			}
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public boolean isCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}	
	
}
