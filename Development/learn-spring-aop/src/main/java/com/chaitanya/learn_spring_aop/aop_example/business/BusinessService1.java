package com.chaitanya.learn_spring_aop.aop_example.business;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.chaitanya.learn_spring_aop.aop_example.data.DataService1;

@Service
public class BusinessService1 {
	private DataService1 dataService;

	public BusinessService1(DataService1 dataService) {
		this.dataService = dataService;
	}

	public int caluclateMax() {
		int arr[] = dataService.getDate();
		return Arrays.stream(arr).max().orElse(0);
	}
}
