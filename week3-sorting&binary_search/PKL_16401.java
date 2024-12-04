import java.io.*;
import java.util.*;

public class PKL_16401 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int [] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int left = 1;
        int right = arr[n-1];
        int result = 0;
        while(left<=right){
            int mid = (left+right) /2;
            if(canDistribute(arr, m, mid)){
                result = mid;
                left = mid+1;       
            }else{
                right = mid -1;
            }

        }
        System.out.println(result);
        
        
    }
    public static boolean canDistribute(int[]snacks,int m, int cookie){
        int count = 0;
        for(int snack: snacks){
            count += snack / cookie;
        }
        return count >=m;
    }
}