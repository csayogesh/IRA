package a1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class Utility {
	public static Random rand = new Random();

	public static int randbit() {
		return rand.nextInt(2);
	}
	
	public static int getk(int n) {
		int k=0;
		int x=1;
		while(x<n) {
			x*=2; k++;
		}
		return k;
	}
	
	public static int randint(int n) {
		rand=new Random();
		int x=n;
		int k=getk(n);
		while(x>=n) {
			int tmp=k;
			int m=1;
			x=0;
			while(tmp>0) {
				x+=m*randbit();
				m*=2;
				tmp--;
			}
		}
		return x+1;
	}
	
	public static void p2() {
		PrintWriter pw = null;
		String fName = "output";
		try {
			pw = new PrintWriter(new File(fName + ".out"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cnt=1000000;
		while(cnt-->0) {
			pw.print(randint(8)+"  ");
		}
		pw.close();
	}
	
	public static void main(String[] args) {
		p2();
	}
}
