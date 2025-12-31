package com.repoviewer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class RepoStatviewerApplication {

	public static void main(String[] args) {
		Integer[] nums = {2, 4, 5, 6};
		List<Integer> numbers = Arrays.asList(nums);

		for(int index = 0; index < numbers.size(); index++){
			numbers.set(index, (int) Math.pow(numbers.get(index), 2));
		}
		for (int n: nums){
			System.out.println(n);
		}
		List<Integer> subList = numbers.subList(2,4) ;
//		subList.clear();
		List<String> names = new ArrayList<>();
		names.add("Habeeb"); names.add("Aminat");

		Set<String> integerSet = new HashSet<>(names);
		
		System.out.printf("Size %d %d",names.size(), integerSet.size());

		SpringApplication.run(RepoStatviewerApplication.class, args);
	}

}
