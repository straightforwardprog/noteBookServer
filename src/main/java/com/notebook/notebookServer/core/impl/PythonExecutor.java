package com.notebook.notebookServer.core.impl;

import java.util.Map;

import net.bytebuddy.build.Plugin.Engine.Source.Empty;

import org.hamcrest.collection.IsEmptyCollection;
import org.python.core.PyInteger;
import org.python.util.PythonInterpreter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.notebook.notebookServer.core.Executor;
import com.notebook.notebookServer.model.CodeResponse;
import com.notebook.notebookServer.model.Program;


@Component
@SessionScope
public class PythonExecutor extends Executor{

	private PythonInterpreter pythonInterpreter;
	
	public PythonExecutor()
	{
		pythonInterpreter = new PythonInterpreter();
	}
	
	// TODO: review the performance of this method
	@Override
	public CodeResponse executeCode(final Program program) {
		CodeResponse codeResponse = new CodeResponse();
		// add the variables to the Python interpreter
		for(Map.Entry<String,String> entry : program.getInputs().entrySet())
		{
			pythonInterpreter.set(entry.getKey(),new PyInteger(Integer.parseInt(entry.getValue())));
		}
		// execute the Python program
		if(program.getExpression()!=null){
			pythonInterpreter.exec(program.getExpression());
			if(program.getExpression().contains("print ")){
				pythonInterpreter.exec("result="+program.getExpression().replace("print ",""));
				codeResponse.setResponse(pythonInterpreter.get("result").asInt()+"");
			}
				
		}
		
		
		return codeResponse;
	}

}
