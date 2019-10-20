package com.notebook.notebookServer.parser;

import com.notebook.notebookServer.model.CodeRequest;
import com.notebook.notebookServer.model.Program;



public interface CodeParser {

	void parse(final Program p , final CodeRequest code);
	String parseVariableName(final String t);
	String parseVariableValue(final String t);
	String parseCodeExpression(String t);

}
