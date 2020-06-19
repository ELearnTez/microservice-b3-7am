package com.java.sort;

import java.util.Comparator;

public class MobileSortingByPrice  implements Comparator<Mobile>{

	@Override
	public int compare(Mobile o1, Mobile o2) {
	     //	return o1.getPrice() - o2.getPrice();
		return o1.getPrice().compareTo(o2.getPrice());
	}

	
	
}
