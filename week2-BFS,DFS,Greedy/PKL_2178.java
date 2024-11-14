import java.util.*;
import java.io.*;

public class PKL_2178 {    
    public int min_count = Integer.MAX_VALUE;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int n, m;
    static int[][] board;
    static int[][] dist;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        dist = new int[n][m];
        for(int i = 0; i<n; i++){
            String S = br.readLine();
            for(int j = 0; j<m; j++){
                board[i][j] = S.charAt(j)-'0';
                dist[i][j] = -1;
            }
        }
        bfs();
        System.out.println(dist[n-1][m-1]);
        
    }
    public static void bfs(){
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{0,0});
        dist[0][0] = 1;
        while(!q.isEmpty()){
            int[] pos = q.poll();
            int x = pos[0];
            int y = pos[1];
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >=0 && ny >=0 && n >nx && m>ny){
                    if(dist[nx][ny] == -1 && board[nx][ny]==1){
                        dist[nx][ny] = dist[x][y] +1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }


    }

}