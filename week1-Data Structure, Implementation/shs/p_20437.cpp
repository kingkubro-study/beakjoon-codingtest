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

    int T;
    cin >> T;

    while(T > 0) {
        string w;
        int k;
        int min = 10001;
        int max = -1;
        map<char, pair<vector<int>, int>> mp;
        cin >> w >> k;

        if (k == 1) {
            cout << 1 << ' ' << 1 << '\n';
            T--;
            continue;
        }

        for (int i = 0; i < w.length(); i++) {
            char c = w[i];
            mp[c].first.push_back(i);
            mp[c].second++;
        }

        for (auto m: mp) {
            if (m.second.second >= k) {
                for (int i = 0; i < m.second.first.size() - k + 1; i++) {
                    if (min > m.second.first[i + k - 1] - m.second.first[i] + 1) {
                        min = m.second.first[i + k - 1] - m.second.first[i] + 1;
                    }
                    if (max < m.second.first[i + k - 1] - m.second.first[i] + 1) {
                        max = m.second.first[i + k - 1] - m.second.first[i] + 1;
                    }
                }
            }
        }

        if (min == 10001) cout << -1 << '\n';
        else cout << min << ' ' << max << '\n';

        T--;
    }
}