package Deducers;

import java.util.Comparator;

public 	class CDeduceTermComparator implements Comparator<CDeduceTerm>{

	@Override
	public int compare(CDeduceTerm o1, CDeduceTerm o2) {
		return o1.toString().compareTo(o2.toString());
	}

	
}
