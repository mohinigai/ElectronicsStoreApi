package com.bikkadIT.helper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

import com.bikkadIT.Dtos.PageableResponse;

public class Helper {
	
	public static <U,V> PageableResponse<V> getPageableResponse(Page<U> page,Class<V>type){
		
		List<U> list = page.getContent();
		 List<V> collect = list.stream().map(Object->new ModelMapper().map(Object, type)).collect(Collectors.toList());
		 
		 PageableResponse<V> response = new PageableResponse<>();
		 response.setContent(collect);
		 response.setPageNumber(page.getNumber());
		 response.setPageSize(page.getSize());
		 response.setTotalElement(page.getTotalElements());
		 response.setTotalPage(page.getTotalPages());
		 response.setLastPage(page.isLast());
		 
		return response;
		
	}

}
