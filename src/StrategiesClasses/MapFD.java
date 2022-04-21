package StrategiesClasses;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * This class implements the Map/Hash table strategy to count frequencies in an ArrayList.
 * @author Fernando J. Bermudez && Axel Negron
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
	 * like the previous strategies in this experiment. The method iterates through the parameter dataSet,
	 * if the the element is not present in the Hash table we add it, otherwise we add one to the element
	 * frequency value and place the object back with the new value. When we add the element into the Hash table
	 * we first add the element as the key and the starter frequency of 1. After we have our complete
	 * Hash Table we get the entries from the Hash table and iterate through the entries adding them into our resultant ArrayList.
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
		Set<Entry<E, Integer>> entry = storage.entrySet();
		
		for(Entry<E, Integer> e: entry) {
			results.add(e);
		}
		return results; //Dummy Return
	}

}
