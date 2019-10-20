package com.notebook.notebookServer.service;

import com.notebook.notebookServer.model.CodeResponse;
import com.notebook.notebookServer.model.Program;



public interface CodeExecuteService {
	CodeResponse executeCode(final Program program);
}
