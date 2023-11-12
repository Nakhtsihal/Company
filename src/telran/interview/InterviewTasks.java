package telran.interview;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;

public class InterviewTasks {

	/*
	 *
	 * @param ar array of integer numbers
	 * @param sum integer number
	 * @return true if the given array contains two numbers, the sum of which equals the given sum value
	 */

	public static void main(String[] args) {
		int[] ar1 = {1000, 300, -200, 20, 40, -10};

		isSum2(ar1, 800);

	}

	public static boolean isSum2(int[] ar, int sum) {
		HashSet<Integer> seenNumbers = new HashSet<>();
		for (int num : ar) {
			int complement = sum - num;

			if (seenNumbers.contains(complement)) {
				return true;
			}

			seenNumbers.add(num);
		}

		return false;
	}

	/*  public static boolean isSum2(int [] ar, int sum) {
		boolean running = true;
		HashSet<Integer> setHelper = new HashSet<>();
		int i = 0;
		while (i < ar.length && running) {
			if (setHelper.contains(sum - ar[i])) {
				running = false;
			} else {
				setHelper.add(ar[i]);
				i++;
			}
		}
		return !running;
	}
*/
	public static boolean isSum2N2(int[] ar, int sum) {
		int i = 0;
		int j = 0;
		boolean running = true;
		while (i < ar.length && running) {
			j = i - 1;
			while (j >= 0) {
				if (ar[j] + ar[i] == sum) {
					running = false;
					break;
				}
				j--;
			}
			i++;
		}
		return !running;
	}

	/*
		public static int getMaxPositiveWithNegativeValue(int ar[]){
			HashSet<Integer> set = new HashSet<>();
			int l_buff;
			int l_res = -1;
			for(int num: ar) {
			l_buff = num;
			if(set.contains(1 * l_buff))
			{
			if(Math.abs(l_buff) > l_res){
				l_res = Math.abs(l_buff);
				}
			} else {
				set.add(l_buff);
				}
			}
			return l_res;
		}

		}
	 */
	public static int getMaxPositiveWithNegativeValue(int ar[]) {
		int numb = Integer.MIN_VALUE;
		int testNum = 0;
		HashSet<Integer> seenNumbers = new HashSet<>();
		for (int num : ar) {
			testNum = num * -1;
			if (seenNumbers.contains(testNum) && testNum > numb) {
				numb = testNum;
			}
			if (num < 0 && num > numb) {
				numb = num;
			}
			seenNumbers.add(num);
		}
		return numb;
	}
/*
HashMap<String, Long> res = new HashMap<>();
	for(String string: strings){
		res.merge(string, 1l, (a,b) -> Long.sum(a,b));
	}
	return res;
}
*/

	public static HashMap<String, Long> getMapOccurrences(String[] strings) {
		HashMap<String, Long> map = new HashMap<>();
		for (String s : strings) {
			boolean res = map.containsKey(s);
			if (res == false) {
				map.put(s, 1L);
			} else {
				Long value = map.get(s);
				value++;
				map.replace(s, value);
			}
		}
		return map;
	}
}