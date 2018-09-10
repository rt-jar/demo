package com.demo.settlement.entities;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Cycle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date openedDate;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date expectedClosedDate;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date actualClosedDate;
    private String state;
    private String cycleConfigurationId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public Date getOpenedDate() {
		return openedDate;
	}

	public void setOpenedDate(Date openedDate) {
		this.openedDate = openedDate;
	}

	public Date getExpectedClosedDate() {
		return expectedClosedDate;
	}

	public void setExpectedClosedDate(Date expectedClosedDate) {
		this.expectedClosedDate = expectedClosedDate;
	}

	public Date getActualClosedDate() {
		return actualClosedDate;
	}

	public void setActualClosedDate(Date actualClosedDate) {
		this.actualClosedDate = actualClosedDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCycleConfigurationId() {
		return cycleConfigurationId;
	}

	public void setCycleConfigurationId(String cycleConfigurationId) {
		this.cycleConfigurationId = cycleConfigurationId;
	}

    
}
