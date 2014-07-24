package com.thinkgem.jeesite.modules.potevio.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.thinkgem.jeesite.common.persistence.IdEntity;

@Entity
@Table(name = "t_watch")
@JsonIgnoreProperties(value = { "updateDate", "searchFromPage", "delFlag" })
public class Watch extends IdEntity<Watch> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 726824016288718535L;

	private String temperature;
	private String humidity;
	private String heartbeat;
	private String stepcount;

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getHeartbeat() {
		return heartbeat;
	}

	public void setHeartbeat(String heartbeat) {
		this.heartbeat = heartbeat;
	}

	public String getStepcount() {
		return stepcount;
	}

	public void setStepcount(String stepcount) {
		this.stepcount = stepcount;
	}
}
