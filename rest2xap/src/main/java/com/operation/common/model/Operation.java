package com.operation.common.model;


import java.io.Serializable;

import org.springframework.web.bind.annotation.PathVariable;

public class Operation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String opname;
	private String parameter2;
	
	public String getOpName() {
		return opname;
	}
	public void setOpName(String opname) {
		this.opname = opname;
	}
	public String getParameter2() {
		return parameter2;
	}
	public void setParameter2(String parameter2) {
		this.parameter2 = parameter2;
	}

	
}