import java.util.Arrays;
import java.util.Scanner;
/**
1007 - DNA Sorting
**/


public class DNASorting {
	private static class DNA implements Comparable<DNA>{
		String dna;
		int inv;
		
		public DNA(String s, int invr) {
			dna = s;
			inv = invr;
		}
		
		@Override
		public int compareTo(DNA that) {
			if(this.inv > that.inv) return 1;
			if(this.inv < that.inv) return -1;
			return 0;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int n = sc.nextInt();
		
		DNA[] arr = new DNA[n];
		
		for(int i=0;i<n;i++) {
			String s = sc.next();
			int inv = countInv(s);
			arr[i] = new DNA(s, inv);
		}
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i].dna);
		}
	}
	
	public static int countInv(String s) {
		int c = 0;
		char[] ch = s.toCharArray();
		for(int i=0;i<ch.length;i++){
			for(int j=i;j>0 && ch[j] < ch[j-1]; j--){
				char temp = ch[j];
				ch[j] = ch[j-1];
				ch[j-1] = temp;
				c++;
			}
		}
		return c;
	}
}
