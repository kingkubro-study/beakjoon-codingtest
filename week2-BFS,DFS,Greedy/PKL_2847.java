
import java.util.*;

import java.io.*;
public class PKL_2847 {    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int [] nums = new int[n];

        for(int i = 0; i<n; i++){

            nums[i] = sc.nextInt();

        }

        int count = 0;
        for(int i = n-1; i > 0; i--){

            if(nums[i] <= nums[i-1]){

                int minus = nums[i-1] - (nums[i]-1);

                count += minus;
                nums[i-1] = nums[i] -1;

            }
        }
        System.out.println(count);

    }

}
