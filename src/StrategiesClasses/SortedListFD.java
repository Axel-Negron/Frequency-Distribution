package StrategiesClasses;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

import DataStructures.SortedList.*;

/**
 * This class implements the SortedList strategy to count frequencies in an ArrayList.
 * @author Fernando J. Bermudez && Axel Negron
 *
 * @param <E> The type of the elements whose frequencies are being counted.
 */
public class SortedListFD<E extends Comparable<E>> extends AbstractFDStrategy<E> {

	/**
	 * Our SortedList classes require the data type to be Comparable.
	 * However, Map.Entry and AbstractMap.SimpleEntry are not Comparable,
	 * so we extend AbstractMap.SimpleEntry and create a Comparable
	 * version that we can use with our SortedList.
	 * Note: The K (key) of this class will be the E of SortedListFD,
	 *       so it will be Comparable.
	 * @author Fernando J. Bermudez
	 *
	 * @param <K>  The type of the key of each entry
	 * @param <V>  The type of the value of each entry
	 */
	@SuppressWarnings("serial")
	private static class ComparableEntry<K extends Comparable<K>, V> extends AbstractMap.SimpleEntry<K, V>
																	 implements Comparable<Map.Entry<K, V>> {

		public ComparableEntry(K key, V value) {
			super(key, value);
		}

		@Override
		public int compareTo(Map.Entry<K, V> entry) {
			/* Entries will be compared based on their keys, which are Comparable */
			return getKey().compareTo(entry.getKey());
		}

	} // End of ComparableEntry class

	/* Constructor */
	public SortedListFD() {
		super("SortedList");
	}
	
	/**
	 * Method that counts the frequency of a dataSet with a SortedList
	 * It uses Map.Entry to count the frequency of each elements inside dataSet
	 * 
	 * @author Axel Negron
	 * @param dataSet	The Data Set to count and distribute the frequency of its elements
	 * @return results 	The resulting entries of each elements inside dataSet
	 */
	@Override
	public ArrayList<Map.Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {
		
	// We begin by adding data into a SortedArrayList, the data is sorted automatically when added.
		SortedArrayList<E> sorted = new SortedArrayList<>(dataSet.size());
		ArrayList<Map.Entry<E, Integer>> results = new ArrayList<>();
		for(E e: dataSet) {
			sorted.add(e);
		}
		Map.Entry<E, Integer> first = new AbstractMap.SimpleEntry<E,Integer>(sorted.get(0),1);
		results.add(first);
		
		for(int i=1; i<sorted.size();i++) {
			E e = sorted.get(i);
			
			for(int j=0; j<results.size();j++) {
				Map.Entry<E, Integer> entry = results.get(j);
					
				if(entry.getKey().equals(e)) {
					entry.setValue(entry.getValue()+1);
					break;
				}
				
				else if(entry.getKey().compareTo(e)<0&& j== results.size()-1){
					
					Map.Entry<E, Integer> temp = new AbstractMap.SimpleEntry<E,Integer>(e,1);
					results.add(temp);
					break;
				}
			}
		}
	
	 	return results; //Dummy Return
	}
	
}