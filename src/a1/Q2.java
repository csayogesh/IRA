package a1;

import java.util.ArrayList;
import java.util.Random;

public class Q2 {
	public static Random rand = new Random();

	public static int randbit() {
		return rand.nextInt(2);
	}

	public static int getk(int n) {
		int k = 0;
		int x = 1;
		while (x < n) {
			x *= 2;
			k++;
		}
		return k;
	}

	public static int randint(int n) {
		rand = new Random();
		int x = n;
		int k = getk(n);
		while (x >= n) {
			int tmp = k;
			int m = 1;
			x = 0;
			while (tmp > 0) {
				x += m * randbit();
				m *= 2;
				tmp--;
			}
		}
		return x + 1;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ArrayList<Integer> p2() {
		ArrayList<Integer> res = new ArrayList();
		int cnt = 1000000;
		while (cnt-- > 0) {
			res.add(randint(8));
		}
		return res;
	}

	public static int streak(ArrayList<Integer>a) {
		int res=1;
		int cur=1;
		for(int i=1;i<a.size();i++) {
			if(a.get(i)==a.get(i-1))
				cur++;
			else cur=1;
			res=Math.max(res,cur);
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(streak(p2()));
	}
}
