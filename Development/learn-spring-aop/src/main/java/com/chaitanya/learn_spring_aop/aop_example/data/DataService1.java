package com.chaitanya.learn_spring_aop.aop_example.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {
	public int[] getDate() {
		return new int[]{1,2,3,4,5};
	}
}
