import java.util.*;

import java.io.*;

public class PKL_2212{    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        List<Integer> nums = new ArrayList<>();
        List<Integer> lengths = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            nums.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(nums);

        for(int i = 1; i<nums.size();i++ ){
            int length = nums.get(i) - nums.get(i-1);
            lengths.add(length);
        }
        Collections.sort(lengths, Collections.reverseOrder());
        
        for(int i = 0; i<k-1; i++){
            if (!lengths.isEmpty()) {
                lengths.remove(0);
            }
        }


        int sum = 0;
        for(int l: lengths){
            sum += l;
        }

        System.out.println(sum);

    }

}