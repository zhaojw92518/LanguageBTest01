package Deducers;

import java.util.Comparator;
import java.util.TreeSet;

public class CTermTreeSet extends TreeSet<CDeduceTerm>{
	public CTermTreeSet(){
		super(new CDeduceTermComparator());
	}
}
