import java.util.*;

import java.io.*;

public class PKL_14502 {    
    
    static int n, m;
    static int[][]board;
    static int[][]tempb;
    static List<Integer> walls;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};   
    static List<int[]> emptySpaces = new ArrayList<>();
    static List<int[]> viruses = new ArrayList<>();
    static int maxSafeArea = 0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for (int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) emptySpaces.add(new int[]{i, j});
                if (board[i][j] == 2) viruses.add(new int[]{i, j});
            }
        }
        dfs(0,0);
        System.out.println(maxSafeArea);
    }
    public static void dfs(int start, int count){
        if(count == 3){
            bfs();
            return;
        }
        for(int i = start; i<emptySpaces.size();i++){
            int[] pos = emptySpaces.get(i);
            board[pos[0]][pos[1]] = 1;
            dfs(i+1, count+1);
            board[pos[0]][pos[1]] = 0;

        }

    }
    public static void bfs(){
        tempb = new int[n][m];
        for(int i = 0; i<n; i++){
            System.arraycopy(board[i], 0, tempb[i], 0, m);
        }
        Queue<int[]> q = new LinkedList<>();
        for(int[] virus : viruses){
            q.add(virus);
        }
        while(!q.isEmpty()){
            int[] pos = q.poll();
            int x = pos[0];
            int y = pos[1];
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && ny>=0 && n>nx && m>ny ){
                    if(tempb[nx][ny]==0){
                        tempb[nx][ny] = 2;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        countSafeArea();
    }
    static void countSafeArea() {
        int safeArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tempb[i][j] == 0) {
                    safeArea++;
                }
            }
        }
        maxSafeArea = Math.max(maxSafeArea, safeArea);
    }
}