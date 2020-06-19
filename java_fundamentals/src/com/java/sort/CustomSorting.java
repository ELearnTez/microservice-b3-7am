package com.java.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomSorting {
	
	public static void main(String[] args) {
		
		Mobile m1 = new Mobile("Samsung", 15000);
		Mobile m2 = new Mobile("MI", 18000);
		Mobile m3 = new Mobile("MOto", 11000);
		Mobile m4 = new Mobile("Lenovo", 14000);
		Mobile m5 = new Mobile("Nokia", 2000);
		
		List<Mobile> mobiles = Arrays.asList(m1, m2,m3,m4, m5);
		
		
		Comparator<Mobile> sortByName = ( o1,  o2)  -> o1.getName().compareTo(o2.getName());
		
		mobiles.stream()
				.sorted( sortByName  )
					.forEach(mobile -> System.out.println(mobile));
		
		System.out.println("-----------------------------------------------");
		
		
		Comparator<Mobile> sortByNameDesc = ( o1,  o2)  -> o2.getName().compareTo(o1.getName());
		
		mobiles.stream().sorted(sortByNameDesc).forEach(mobile -> System.out.println(mobile));
		
		System.out.println("-----------------------------------------------  Low to High Price");
		
		mobiles.stream()
		.sorted( (mo1, mo2) -> mo1.getPrice().compareTo(mo2.getPrice())  )
			.forEach(mobile -> System.out.println(mobile));
		
		
     System.out.println("----------------------------------------------- High to Low Price");
		
		mobiles.stream()
		.sorted( (mo1, mo2) -> mo2.getPrice().compareTo(mo1.getPrice())  )
			.forEach(mobile -> System.out.println(mobile));

		
		
		/*Collections.sort(mobiles, new MobileSortingByName());
		
		mobiles.forEach(mobile -> System.out.println(mobile));
		
		System.out.println("---------------------"); 
		
		Collections.sort(mobiles, new MobileSortingByPrice());
		
		mobiles.forEach(mobile -> System.out.println(mobile));*/
		
		
	}

}
