package StrategiesClasses;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

/**
 * This class corresponds to the Sequential strategy to count frequencies in an
 * array list.
 * @author Fernando J. Bermudez && Axel Negron
 *
 * @param <E> The type of the elements whose frequencies are being counted.
 */
public class SequentialFD<E extends Comparable<E>> extends AbstractFDStrategy<E> {

	public SequentialFD() {
		super("Sequential");
	}
	/**
	 * Method that counts the frequency of a dataSet with a regular ArrayList
	 * It uses Map.Entry to count the frequency of each elements inside dataSet
	 * one by one without any sorting or re-arrangement of the elements
	 * 
	 * @param dataSet	The Data Set to count and distribute the frequency of its elements
	 * @return results 	The resulting entries of each elements inside dataSet
	 */
	@Override
	public ArrayList<Map.Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {
		ArrayList<Map.Entry<E,Integer>> results = new ArrayList<>();
		for(E e: dataSet) {
			boolean found = false;
			
			for(int i=0; i<results.size() && !found;i++) {
				Map.Entry<E, Integer> entry = results.get(i);
				if(entry.getKey().equals(e)) {
					found = true;
					entry.setValue(entry.getValue()+1);
					
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
