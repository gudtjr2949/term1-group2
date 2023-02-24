import java.io.BufferedReader;
import java.io.InputStreamReader;

// 백준 19942 : 다이어트
public class BOJ_19942 {
	
	static int N;
	static Ingredient[] ing;
	static Ingredient min_ing;
	
	public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(bf.readLine());
        
        ing = new Ingredient[N];
        String s1 = bf.readLine();
        String[] s1_arr = s1.split(" ");
        
        min_ing = new Ingredient(Integer.parseInt(s1_arr[0]), Integer.parseInt(s1_arr[1]), Integer.parseInt(s1_arr[2]), Integer.parseInt(s1_arr[3]));
        for (int i = 0 ; i < N ; i++) {
        	String s2 = bf.readLine();
        	String[] s2_arr = s2.split(" ");
        	ing[i] = new Ingredient(Integer.parseInt(s2_arr[0]), Integer.parseInt(s2_arr[1]), Integer.parseInt(s2_arr[2]), Integer.parseInt(s2_arr[3]));
        }
        
        dfs(0, 0, new int[N]);
	}
	
	private static void dfs(int idx, int cur, int[] input) {
		if (idx == input.length) {
			
			return;
		}
		
		for (int i = cur ; i < N ; i++) {
			input[idx] = i;
			dfs(idx+1, i+1, input);
		}
	}
	
	private static boolean check(int idx, int[] input) {
		
	}
	
	static class Ingredient {
		int protein;
		int fat;
		int carbo;
		int vitamin;
		
		public Ingredient(int protein, int fat, int carbo, int vitamin) {
			super();
			this.protein = protein;
			this.fat = fat;
			this.carbo = carbo;
			this.vitamin = vitamin;
		}
	}
}
