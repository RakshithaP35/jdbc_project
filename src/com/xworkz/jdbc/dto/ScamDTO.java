package com.xworkz.jdbc.dto;

import java.io.Serializable;

public class ScamDTO implements Serializable{
	private String s_name;
	private int s_id;
	private String s_type;
	private int s_year;
	private String s_by;
	private int s_amount;
	private String s_location;

	public ScamDTO() {
		
	}

	public ScamDTO(String s_name, int s_id, String s_type, int s_year, String s_by, int s_amount, String s_location) {
		super();
		this.s_name = s_name;
		this.s_id = s_id;
		this.s_type = s_type;
		this.s_year = s_year;
		this.s_by = s_by;
		this.s_amount = s_amount;
		this.s_location = s_location;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getS_type() {
		return s_type;
	}

	public void setS_type(String s_type) {
		this.s_type = s_type;
	}

	public int getS_year() {
		return s_year;
	}

	public void setS_year(int s_year) {
		this.s_year = s_year;
	}

	public String getS_by() {
		return s_by;
	}

	public void setS_by(String s_by) {
		this.s_by = s_by;
	}

	public int getS_amount() {
		return s_amount;
	}

	public void setS_amount(int s_amount) {
		this.s_amount = s_amount;
	}

	public String getS_location() {
		return s_location;
	}

	public void setS_location(String s_location) {
		this.s_location = s_location;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + s_id;
		result = prime * result + ((s_name == null) ? 0 : s_name.hashCode());
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
		ScamDTO other = (ScamDTO) obj;
		if (s_id != other.s_id)
			return false;
		if (s_name == null) {
			if (other.s_name != null)
				return false;
		} else if (!s_name.equals(other.s_name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ScamDTO [s_name=" + s_name + ", s_id=" + s_id + ", s_type=" + s_type + ", s_year=" + s_year + ", s_by="
				+ s_by + ", s_amount=" + s_amount + ", s_location=" + s_location + "]";
	}

}
