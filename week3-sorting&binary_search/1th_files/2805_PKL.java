import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

public class PKL_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); 
        
        int[] trees = new int[n];
        st = new StringTokenizer(br.readLine());
        
        int maxTreeHeight = 0; 
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            maxTreeHeight = Math.max(maxTreeHeight, trees[i]);
        }
        
        int left = 0, right = maxTreeHeight, result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (cutTree(trees, mid) >= m) {
                result = mid; 
                left = mid + 1; 
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    public static long cutTree(int[] trees, int height) {
        long total = 0;
        for (int tree : trees) {
            if (tree > height) {
                total += tree - height;
            }
        }
        return total;
    }
}

