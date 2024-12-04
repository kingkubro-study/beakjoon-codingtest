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

int binary_search(vector<int> home, int c) {
    int start = 1;
    int end = home.back() - home.front();
    int answer = 0;

    while (start <= end) {
        int mid = (start + end) / 2;
        int count = 1;
        int index = 0;

        for (int i = index; i < home.size(); i++) {
            if (home[i] - home[index] >= mid) {
                index = i;
                count++;
            }
        }

        if (count >= c) {
            start = mid + 1;
            answer = mid;
        } else end = mid - 1;
    }

    return answer;
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n, c;
    int answer = 0;
    cin >> n >> c;
    vector<int> home(n, 0);

    for (int i = 0; i < n; i++) {
        cin >> home[i];
    }

    sort(home.begin(), home.end());

    answer = binary_search(home, c);

    cout << answer << '\n';
}