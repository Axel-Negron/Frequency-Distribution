package TesterClasses;

import java.util.ArrayList;
import java.util.Map;

import StrategiesClasses.OrderedFD;

public class OrderedTester1 {
	public static void main(String[] args) {
		
		System.out.println("Testing Map strategy"); 
		ArrayList<Integer> data = TestingUtils.generateListOfIntegers(5000); 
		
		TestingUtils.displayListElements("Original Data", data);
		
		OrderedFD<Integer> s = new OrderedFD<Integer>(); 
		ArrayList<Map.Entry<Integer, Integer>> fd = s.computeFDList(data); 

		fd.sort(new EntryIntComparator());
		
		TestingUtils.displayListElements("Frequency Distribution", fd);
	}

}