/*
 * @author: Christian Giesler
 * 
 * Main.java
 */

import java.util.HashMap;

public class Main {

	/*
	 * From a string, determine if it is a "pyramid" string. A string is considered
	 * a pyramid if you can arrange the letters in increasing frequency, starting
	 * with 1 and continuing without gaps and without duplicates.
	 */
	public static boolean isPyramid(String pyramid) {
		// Put characters into a hash map, incrementing each time a char is seen
		HashMap<Character, Integer> amounts = new HashMap<Character, Integer>();
		for (int i = 0; i < pyramid.length(); i++) {
			if (amounts.containsKey(pyramid.charAt(i))) { // increment
				amounts.put(pyramid.charAt(i), amounts.get(pyramid.charAt(i)) + 1);
			} else { // new key
				amounts.put(pyramid.charAt(i), 1);
			}
		}
		boolean[] takenVals = new boolean[amounts.size()];
		for (int i = 0; i < pyramid.length(); i++) { // Check for duplicates
			if (amounts.get(pyramid.charAt(i)) != null) {
				int index = amounts.remove(pyramid.charAt(i)) - 1;
				try {
					if (takenVals[index] == true) { // duplicate amount
						return false;
					}
				} catch (ArrayIndexOutOfBoundsException e) { // A character occurs too much
					return false;
				}
				takenVals[index] = true;
			} else { // character already used
				continue;
			}
		}
		// All conditions met
		return true;
	}

	public static void main(String[] args) {
		// A few test cases
		System.out.println(isPyramid("banana"));
		System.out.println(isPyramid("el"));
		System.out.println(isPyramid("banaana"));
		System.out.println(isPyramid("bandana"));
		System.out.println(isPyramid("steve"));
		System.out.println(isPyramid("abbcccddddeeeee"));
	}

}
