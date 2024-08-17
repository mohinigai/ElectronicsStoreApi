package com.bikkadIT.excepation;

import lombok.Builder;

@Builder
public class ResourceNotFoundExcption extends RuntimeException {

	public ResourceNotFoundExcption() {
		super("Resource Not Found Excepation!!");
		// TODO Auto-generated constructor stub
	}

	public ResourceNotFoundExcption(String Message) {
		super(Message);
		
	}
	
	
	}

	

