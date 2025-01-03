import java.util.*;

public class PKL_14503  {    
    
    static int N, M, r, c, d;
    static int[][]board;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};   
    static int count = 1; 
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();

        board = new int[N][M];

        for (int i = 0; i<N; i++){
            for (int j = 0; j<M; j++){
                board[i][j] = sc.nextInt();
            }
        }
        dfs(r,c,d);    
        System.out.println(count); 
    }  
    public static void dfs(int x, int y, int dir){
        board[x][y] = 2;
        
        for(int i = 0; i<4;i++){
            dir = (dir+3)%4;
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx >=0 && ny>=0 && N>nx && M>ny){
                if(board[nx][ny]==0){
                    count++;
                    dfs(nx, ny, dir);
                    return;
                }
            }

        }
        int d = (dir+2)%4;
        int bx = x + dx[d];
        int by = y + dy[d];
        if(bx >= 0 && by >=0 && N>bx && M>by && board[bx][by]!= 1){
            dfs(bx, by, dir);
        }
    }  
}