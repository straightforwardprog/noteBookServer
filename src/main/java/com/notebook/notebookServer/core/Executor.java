package com.notebook.notebookServer.core;

import com.notebook.notebookServer.model.CodeResponse;
import com.notebook.notebookServer.model.Program;




public abstract class Executor {
	
	public abstract CodeResponse executeCode(final Program p);
	
}
