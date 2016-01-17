package a1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Q4 {
	public static int n = 50;
	public static int[] parent = new int[n];
	public static boolean[][] adj = new boolean[n][];
	static {
		try {
			Scanner sc = new Scanner(new File("matrix"));
			for (int i = 0; i < n; i++)
				adj[i] = new boolean[n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					adj[i][j] = sc.nextInt() == 1;
					// System.out.print(adj[i][j] + " ");
				}
				// System.out.println();
			}
			for (int i = 0; i < n; i++)
				parent[i] = -1;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static int find(int parent[], int i) {
		if (parent[i] == -1)
			return i;
		return find(parent, parent[i]);
	}

	public static void Union(int parent[], int x, int y) {
		int xset = find(parent, x);
		int yset = find(parent, y);
		parent[xset] = yset;
	}

	public static void uniteVertices() {
		ArrayList<Integer> ls = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			ls.add(i);
		Random r = new Random();
		while (ls.size() > 2) {
			int i = r.nextInt(ls.size());
			int j = i;
			while (j == i) {
				j = r.nextInt(ls.size());
			}
			int x = ls.get(i);
			int y = ls.get(j);
			ls.remove(j);
			Union(parent, x, y);
		}
	}

	public static int getMinCut() {
		uniteVertices();
		int cnt = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (adj[i][j] && find(parent, i) != find(parent, j))
					cnt++;
		for (int i = 0; i < n; i++)
			parent[i] = -1;
		return cnt / 2;
	}

	public static void main(String[] args) {
		int min = Integer.MAX_VALUE;
		int iter = 1000000;
		int cnt=0;
		int tmp=iter;
		while (tmp-- > 0) {
			if(24==getMinCut())
				cnt++;
		}
		System.out.println(iter/cnt);
	}
}
