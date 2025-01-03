import java.io.*;
import java.util.*;

public class Mon_PKL_2504{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String S = br.readLine();
        int temp = 1;
        int result = 0;
        for (int i = 0; i<S.length(); i++){
            char c = S.charAt(i);
            if(c=='('){
                temp *= 2;
                stack.push('(');
            }else if(c=='['){
                temp *=3;
                stack.push('[');
            }else if(c==')'){
                if (stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                }
                if (S.charAt(i - 1) == '(') {
                    result += temp;
                }
                stack.pop();
                temp /= 2;
            }else if(c==']'){
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                }
                if (S.charAt(i - 1) == '[') {
                    result += temp;
                }
                stack.pop();
                temp /= 3;
            }
        }
        if(stack.isEmpty()) System.out.println(result);
        else System.out.println(0);
        
    }

}