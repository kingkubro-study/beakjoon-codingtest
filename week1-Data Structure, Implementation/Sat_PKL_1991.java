
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
    char value;
    Node left;
    Node right;
    public Node(char value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class Sat_PKL_1991{
    static Node[] tree;
    public static void preorder(Node node){
        if(node==null) return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }
    public static void inorder(Node node){
        if(node==null) return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }
    public static void postorder(Node node){
        if(node==null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new Node[n+1];
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char pval = st.nextToken().charAt(0);
            char lval = st.nextToken().charAt(0);
            char rval = st.nextToken().charAt(0);

            if (tree[pval - 'A'] == null) { 
                tree[pval - 'A'] = new Node(pval); 
            }
            if(lval != '.'){
                tree[lval-'A'] = new Node(lval);
                tree[pval-'A'].left = tree[lval-'A'];
            }
            if(rval != '.'){
                tree[rval-'A'] = new Node(rval);
                tree[pval-'A'].right = tree[rval-'A'];
            }
        }
    preorder(tree[0]);
    System.out.println();


    inorder(tree[0]);
    System.out.println();

    postorder(tree[0]);
    System.out.println();
        
    }



}