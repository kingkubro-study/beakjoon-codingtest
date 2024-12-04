import java.io.*;
import java.util.*;

public class PKL_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine()); 
        int[] arr = new int[n];
        int[] sortedArr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sortedArr[i] = arr[i];
        }

        Arrays.sort(sortedArr);
        Map<Integer, Integer> compressed = new HashMap<>();
        int rank = 0;
        for (int num : sortedArr) {
            if (!compressed.containsKey(num)) { 
                compressed.put(num, rank++);
            }
        }

        for (int num : arr) {
            bw.write(compressed.get(num) + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
