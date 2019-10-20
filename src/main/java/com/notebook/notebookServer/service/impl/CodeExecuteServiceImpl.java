package com.notebook.notebookServer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.notebook.notebookServer.core.Executor;
import com.notebook.notebookServer.model.CodeResponse;
import com.notebook.notebookServer.model.Program;
import com.notebook.notebookServer.service.CodeExecuteService;


@Component
public class CodeExecuteServiceImpl implements CodeExecuteService {

	@Autowired 
	private Executor executor;
	
	@Override
	public CodeResponse executeCode(final Program program) {
		return executor.executeCode(program);
	}

}
