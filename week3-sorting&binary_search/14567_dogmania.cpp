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

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M; 
    cin>> N >> M;

    vector<vector<int>> v(N + 1);
    vector<int> cnt(N + 1, 0);
    vector<int> ans(N + 1, 0);

    int a, b;
    for(int i = 0; i < M; i++){
        cin >> a >> b;
        v[a].push_back(b);
        cnt[b]++;
    }

    queue<pair<int, int>> q;
    for(int i = 1; i <= N; i++) if (cnt[i] == 0) q.push({i, 1});

    while(!q.empty()) {
        int next = q.front().first;
        int next_cnt = q.front().second;
        ans[next] = next_cnt;
        q.pop();

        for (int i = 0; i < (int) v[next].size(); i++) {
            int x = v[next][i];
            cnt[x]--;
            if(cnt[x] == 0) q.push({x, next_cnt + 1});
        }
    }

    for (int i = 1; i <= N; i++) cout << ans[i] << " ";
}