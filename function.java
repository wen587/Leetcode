import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solutionla {
	public int funtion(int num, int k) {
		int i = 0;
		while(i++ < k) {
			if(num == 1) break;//return another num?
			if(num % 2 == 0) {
				num = num / 2;
			} else {
				if(num > (Integer.MAX_VALUE - 1) / 3) {//long
					num = Integer.MAX_VALUE;
					continue;
				} else if(num < Integer.MIN_VALUE / 3) {
					num = Integer.MIN_VALUE;
					continue;
				}
				
				num = num * 3 + 1;
				
			}
		}
		return num;
	}
		
	
	public static void main(String[] args) {
		System.out.println("Please input: ");
		Scanner sc = new Scanner(System.in);
	    int num = sc.nextInt();
		int k = sc.nextInt();
		Solutionla slt = new Solutionla();
		System.out.print(slt.funtion(num, k));
	}
	
}








 public static void main(String[] args) {
    	HashSet<String> set = new HashSet<>();
    	Scanner sc = new Scanner(System.in);
    	String sInput = sc.nextLine();
    	Solution slt = new Solution();
    	int[] nums = {0, 1, 2, 3, 4};
//    	int res = slt.findKthLargest(nums, 2);I am Amy mya, how are you, Bob?
    	sInput = sInput.replaceAll("[!?,.]", "").toLowerCase();
    	String[] str = sInput.split("\\s+");//+ 1个以上
    	System.out.println(str.length);
    	System.out.print(Arrays.toString(str));
    	for(int i=0; i<str.length; i++) {
    		char[] ch = str[i].toCharArray();
    		Arrays.sort(ch);
    		str[i] = new String(ch);
    		set.add(str[i]);
    	}
    	String[] sorted = new String[set.size()];
    	int i=0;
    	for(String sort : sorted) sorted[i++] = sort;
    	Arrays.sort(sorted);
    	System.out.println(Arrays.toString(sorted));