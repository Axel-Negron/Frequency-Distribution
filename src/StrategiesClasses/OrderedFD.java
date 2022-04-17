package StrategiesClasses;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

/**
 * This class implements the Ordered strategy to count frequencies in an ArrayList.
 * @author Fernando J. Bermudez && YOUR NAME HERE
 *
 * @param <E> The type of the elements whose frequencies are being counted.
 */
public class OrderedFD<E extends Comparable<E>> extends AbstractFDStrategy<E> {

	public OrderedFD() {
		super("Ordered");
	}

	/**
	 * Method that counts the frequency of a dataSet with a SORTED COPY of dataSet
	 * It uses Map.Entry to count the frequency of each elements inside dataSet
	 * 
	 * @param dataSet	The Data Set to count and distribute the frequency of its elements
	 * @return results 	The resulting entries of each elements inside dataSet
	 */
	@Override
	public ArrayList<Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {
		dataSet.sort(null);
		ArrayList<Map.Entry<E, Integer>> results = new ArrayList<>();
		for(E e: dataSet) {
			boolean found = false;
			
			for(int i=0; i<results.size() && results.get(i).getKey().compareTo(e)!=1 && !found;i++) {
				
				Map.Entry<E, Integer> entry = results.get(i);
				
				if(entry.getKey().equals(e)) {
					found = true;
					entry.setValue(entry.getValue()+1);
					break;
					
				}
			}
			if(!found) {
				Map.Entry<E, Integer> temp = new AbstractMap.SimpleEntry<E, Integer>(e,1);
				results.add(temp);
			}
			
			
			
		}
	 	return results; //Dummy Return
	}

}
