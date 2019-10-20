package com.notebook.notebookServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.notebook.notebookServer.model.CodeRequest;
import com.notebook.notebookServer.model.CodeResponse;
import com.notebook.notebookServer.model.Program;
import com.notebook.notebookServer.parser.CodeParser;
import com.notebook.notebookServer.service.CodeExecuteService;


@RestController
public class NoteBookController {

	@Autowired
	private CodeParser codeParser;
	@Autowired
	private CodeExecuteService codeExecuteService;
	
	@RequestMapping(value="/execute", method = RequestMethod.POST)
    public CodeResponse execute(@RequestBody CodeRequest code) 
    {	
		Program p = new Program();
    	codeParser.parse(p,  code);
    	return codeExecuteService.executeCode(p);
    }
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
    public String executee() 
    {	
    	
    	return "Yes ss";
    }
	
}
