import java.io.*;
import java.util.*;

public class PKL_18869 {
    private static List<List<Integer>> spaces = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;

        
        for (int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            List<Integer> space = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            for(int j = 0; j<m; j++){
                int num = Integer.parseInt(st.nextToken());
                space.add(num);
                set.add(num);
            }
            List<Integer> clone = new ArrayList<>(set);
            Collections.sort(clone);
            for(int j = 0; j<m; j++){
                int idx = Collections.binarySearch(clone, space.get(j));
                space.set(j, idx);
            }
            spaces.add(space);
        }      

        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                if(Arrays.equals(spaces.get(i).toArray(), spaces.get(j).toArray())) count++;
            }
        }
        System.out.println(count);
    }
}
