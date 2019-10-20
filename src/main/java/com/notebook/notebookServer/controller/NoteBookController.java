package com.notebook.notebookServer.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

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
    public CodeResponse execute(@RequestBody CodeRequest code, HttpSession httpSession) 
    {	
		String sessionId = code.getSessionId() != null ? code.getSessionId() : httpSession.getId();
		code.setSessionId(sessionId);
		
		Map<String,String> inputs=	(Map<String, String>) httpSession.getAttribute(sessionId);
		//check if these any variable already declared
		Program p = new Program();
		if(inputs!=null)
		{
			p.setInputs(inputs);
		}
    	codeParser.parse(p,  code);
    	CodeResponse resp=null;
    	try{
    		codeExecuteService.executeCode(p);
    	}catch(Exception e){
    		resp.setErrors(e.getMessage());
    	}
    	
    	resp.setSessionId(sessionId);
    	httpSession.setAttribute(sessionId, p.getInputs());
    	return resp;
    }
	
	
	
}
