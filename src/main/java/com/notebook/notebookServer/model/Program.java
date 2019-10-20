package com.notebook.notebookServer.model;

import java.util.HashMap;
import java.util.Map;

public class Program {
	
	private Map<String,String> inputs = new HashMap<String, String>();
	
	private String expression;
	
	private String code;
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Map<String, String> getInputs() {
		return inputs;
	}

	public void setInputs(Map<String, String> inputs) {
		this.inputs = inputs;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expressions) {
		this.expression = expressions;
	}

}
