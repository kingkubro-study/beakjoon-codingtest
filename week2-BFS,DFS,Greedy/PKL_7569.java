import java.util.*;
import java.io.*;

public class PKL_7569{    
    static int n;
    static int m;
    static int h;
    static int[] dx = {-1,0,1,0, 0, 0};
    static int[] dy = {0,1,0,-1, 0, 0};
    static int[] dh = {0,0,0,0,1,-1};
    static List<int[]>ones = new ArrayList<>();
    static int [][][] box;
    static int[][][] dist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        dist = new int[h][n][m];
        box = new int[h][n][m];

        Queue<int[]> q = new LinkedList<>();

        for(int t = 0; t<h; t++){
            for(int i = 0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<m; j++){
                    box[t][i][j] = Integer.parseInt(st.nextToken());
                     if (box[t][i][j] == 1) {
                        q.add(new int[]{t, i, j});
                        dist[t][i][j] = 0; // 익은 토마토는 시작점으로 설정
                    } else {
                        dist[t][i][j] = -1; // 미방문 상태로 설정
                    }
                }
            }
        }
        bfs(q);

        int maxDays = 0;
        boolean allRipe = true;
        for (int t = 0; t < h; t++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (box[t][i][j] == 0 && dist[t][i][j] == -1) {
                        allRipe = false; // 익지 않은 토마토가 있으면 실패
                    }
                    maxDays = Math.max(maxDays, dist[t][i][j]); 
                }
            }
        }

        System.out.println(allRipe ? maxDays : -1); 


    }
    public static void bfs(Queue<int[]>q){
        
        while(!q.isEmpty()){
            int[] pos = q.poll();
            int t = pos[0];
            int x = pos[1];
            int y = pos[2];
            for(int i = 0; i<6; i++){
                int nt = t + dh[i];
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nt>=0&&nx>=0 && ny>=0&&h>nt&&n>nx&&m>ny){
                    if(dist[nt][nx][ny]== -1&& box[nt][nx][ny]==0){
                        dist[nt][nx][ny]  = dist[t][x][y] +1;
                        box[nt][nx][ny] =1;
                        q.add(new int[]{nt,nx, ny});

                    }
                }
            }
        }


    }
}
