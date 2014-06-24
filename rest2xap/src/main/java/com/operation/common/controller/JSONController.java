package com.operation.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.operation.common.model.Operation;


@Controller
@RequestMapping("/op")
public class JSONController {

	static int count = 0;
	
	@RequestMapping(value = "/{opname},{parameters}", method = RequestMethod.GET)
	public @ResponseBody
	Operation getOperationInJSON (	@PathVariable String opname, 
									@PathVariable String parameters ){

		Operation operation = new Operation();
		operation.setOpName(opname);
		operation.setParameter2(parameters);
		
		System.out.println(opname.toString());
		System.out.println(parameters.toString());
		
        Feeder feeder = new Feeder("jini://*/*/vincentDataSpace");    // create the feeder and connect it to the space
        feeder.feed(count,"opName: " + opname.toString());                      // run the feeder for once
        count = count + 1;
        feeder.feed(count, "Parameters: " + parameters.toString());                      // run the feeder for once
        count = count + 1;
        
        feeder.readResults();                   // read back results
		
		return operation;

	}

}