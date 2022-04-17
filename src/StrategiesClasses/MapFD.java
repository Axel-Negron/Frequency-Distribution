package StrategiesClasses;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * This class implements the Map/Hash table strategy to count frequencies in an ArrayList.
 * @author Fernando J. Bermudez && YOUR NAME HERE
 *
 * @param <E> The type of the elements whose frequencies are being counted.
 */
public class MapFD<E extends Comparable<E>> extends AbstractFDStrategy<E> {

	public MapFD() {
		super("Map");
	}
	
	/**
	 * Method that counts the frequency of a dataSet with a Hash table
	 * It uses a Hash table to count the frequency of each elements inside dataSet instead of Map.Entry
	 * like the previous strategies in this experiment
	 * 
	 * @param dataSet	The Data Set to count and distribute the frequency of its elements
	 * @return results 	The resulting entries of each elements inside dataSet
	 */
	@Override
	public ArrayList<Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {
		ArrayList<Entry<E, Integer>> results = new ArrayList<>();
		Hashtable<E,Integer> storage = new Hashtable<>();
		for(E e: dataSet) {
			if(storage.get(e)==null) {
				storage.put(e, 1);
			}
			else {
				int value = 1;
				value+=storage.get(e);
				storage.put(e, value);
			}
		}
		Set<E> keys = storage.keySet();
		for(E e: keys) {
			Map.Entry<E, Integer> temp = new AbstractMap.SimpleEntry<E,Integer>(e,storage.get(e));
			results.add(temp);
		}
		return results; //Dummy Return
	}

}
