import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FindTwo {
	
	public int[] methodA(int[] nums, int target) {

		for(int j=0; j < nums.length; j++) {
			for(int k=j+1; k < nums.length; k++) {
				if (nums[j] + nums[k] == target) {
					return new int[] {j,k};
				}
			}
		}
		return new int[] {0,0}; // never reached
	}
	
	public int[] methodB(int[] nums, int target) {
		int[] copy = new int[nums.length];
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int val : nums) list.add(val);
		
		System.arraycopy(nums, 0, copy, 0, nums.length);
		Arrays.sort(copy);
		for(int a : copy) {
			int index = Arrays.binarySearch(copy, target-a);
			if (index >= 0) {
				int j = list.indexOf(a);
				int k = list.indexOf(copy[index]);
				return new int[] {j,k};
			}
		}
		return new int[] {0,0};
	}
	
	public static void main(String[] args) {
		int size = 1000000;
		int[] nums = new int[size];
		ArrayList<Integer> list = new ArrayList<>();
		for(int k=1; k <= size; k++) {
			list.add(k);
		}
		int target = size-1 + size;
		Collections.shuffle(list);
		for(int k=0; k < list.size(); k++) {
			nums[k] = list.get(k);
		}

		FindTwo f = new FindTwo();
		double start = System.nanoTime();
		int[] x = f.methodA(nums,target);
		double end = System.nanoTime();
		double simpleTime = (end-start)/1e9;
		
		start = System.nanoTime();
		int[] y = f.methodB(nums,target);
		end = System.nanoTime();
		double binaryTime = (end-start)/1e9;
		System.out.printf("[%d,%d] in %1.5f\n",x[0],x[1],simpleTime);
		System.out.printf("[%d,%d] in %1.5f\n",y[0],y[1],binaryTime);
	}
}
