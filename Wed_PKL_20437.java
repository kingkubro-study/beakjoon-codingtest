import java.io.*;
import java.util.*;

public class Wed_PKL_20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String S = br.readLine();
            int count = Integer.parseInt(br.readLine());
            List<Integer>[] alpha = new ArrayList[26];

            for (int j = 0; j < 26; j++) {
                alpha[j] = new ArrayList<>();
            }

            for (int j = 0; j < S.length(); j++) {
                char c = S.charAt(j);
                alpha[c - 'a'].add(j);
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            boolean isValid = false;

            for (int j = 0; j < 26; j++) {
                if (alpha[j].size() >= count) {
                    isValid = true;

                    // 주어진 count만큼의 구간에서 최소, 최대 차이 계산
                    for (int k = 0; k <= alpha[j].size() - count; k++) {
                        int minus = alpha[j].get(k + count - 1) - alpha[j].get(k) + 1;
                        min = Math.min(min, minus);
                        max = Math.max(max, minus);
                    }
                }
            }
            
            if (isValid) {
                System.out.println(min + " " + max);
            } else {
                System.out.println(-1);
            }
        }
    }
}
