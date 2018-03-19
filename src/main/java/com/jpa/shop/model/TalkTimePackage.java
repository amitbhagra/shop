package com.jpa.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "talktime")
public class TalkTimePackage extends BaseProduct {

	@Column(name = "validity")
	private Integer validity;

	public Integer getValidity() {
		return validity;
	}

	public void setValidity(Integer validity) {
		this.validity = validity;
	}

	@Override
	public String toString() {
		return "TalkTimePackage [validity=" + validity + ", getName()="
				+ getName() + "]";
	}
	
	
}
