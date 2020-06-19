package com.java.sort;

import java.util.Comparator;

public class MobileSortingByName implements Comparator<Mobile> {

	@Override
	public int compare(Mobile o1, Mobile o2) {
		return o1.getName().compareTo(o2.getName());
	}

	
	
}
