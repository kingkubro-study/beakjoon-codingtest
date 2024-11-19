#include <stdio.h>
#include <cmath>
#include <vector>
#include <queue>
#include <stack>
#include <algorithm>  
#include <iostream> 
#include <string>   
#include <set>        
#include <map>      
#include <deque>      

using namespace std;

int n, m, h;
int dx[] = {1, -1, 0, 0, 0, 0};
int dy[] = {0, 0, 1, -1, 0, 0};
int dz[] = {0, 0, 0, 0, 1, -1};

void bfs(vector<vector<vector<int>>> &graph, deque<tuple<int, int, int>> dq, int &answer) {
    while(!dq.empty()) {
        int dqSize = dq.size();
        answer++;

        for (int i = 0; i < dqSize; i++) {
            tuple<int, int, int> currentNode = dq.front();
            dq.pop_front();
            int currentX = get<0>(currentNode);
            int currentY = get<1>(currentNode);
            int currentZ = get<2>(currentNode);

            for (int i = 0; i < 6; i++) {
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];
                int nz = currentZ + dz[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && nz >= 0 && nz < h && graph[nz][ny][nx] == 0) {
                    graph[nz][ny][nx] = 1;
                    dq.push_back({nx, ny, nz});
                }
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> m >> n >> h;
    int answer = 0;
    vector<vector<vector<int>>> graph(h, vector<vector<int>>(n, vector<int>(m, 0)));
    deque<tuple<int, int, int>> dq;
    
    for (int i = 0; i < h; i++) {
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                cin >> graph[i][j][k];
                if (graph[i][j][k] == 1) dq.push_back({k, j, i});
            }
        }
    }

    bfs(graph, dq, answer);

    for (int i = 0; i < h; i++) {
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                if (graph[i][j][k] == 0) {
                    answer = -1;
                    break;
                }
            }
        }
    }

    if (answer == -1) cout << -1 << '\n';
    else cout << answer - 1 << '\n';
}