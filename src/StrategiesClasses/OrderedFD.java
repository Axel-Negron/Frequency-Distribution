package StrategiesClasses;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

/**
 * This class implements the Ordered strategy to count frequencies in an ArrayList.
 * @author Fernando J. Bermudez && Axel Negron
 *
 * @param <E> The type of the elements whose frequencies are being counted.
 */
public class OrderedFD<E extends Comparable<E>> extends AbstractFDStrategy<E> {

	public OrderedFD() {
		super("Ordered");
	}

	/**
	 * Method that counts the frequency of a dataSet with a SORTED COPY of dataSet
	 * It uses Map.Entry to count the frequency of each elements inside dataSet. The method takes
	 * the parameter dataSet which is an ArrayList<E> utilizes sort() to sort through the parameter
	 * dataSet. Once sorted we iterate over the SortedArrayList and verify if the element is accounted 
	 * for in a our resultant ArrayList<Map.Entry> structure. If the element is present we increase the 
	 * frequency of the element by 1, otherwise we add it as an entry of our ArrayList<Map.Entry>. 
	 * Finally we return the resultant ArrayList containing Map Entries.
	 * 
	 * @param dataSet	The Data Set to count and distribute the frequency of its elements
	 * @return results 	The resulting entries of each elements inside dataSet
	 */
	@Override
	public ArrayList<Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {
		dataSet.sort(null);
		ArrayList<Map.Entry<E, Integer>> results = new ArrayList<>();
		Map.Entry<E, Integer> first = new AbstractMap.SimpleEntry<E,Integer>(dataSet.get(0),1);
		results.add(first);
		for(E e: dataSet) {
			if(e.compareTo(results.get(results.size()-1).getKey())>0) {
				Map.Entry<E, Integer> temp = new AbstractMap.SimpleEntry<>(e,1);
				results.add(temp);
			}
			
			else {
				results.get(results.size()-1).setValue(results.get(results.size()-1).getValue()+1);
				}
			}

	 	return results; //Dummy Return
	}

}
