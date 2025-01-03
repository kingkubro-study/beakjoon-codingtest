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

tuple<int, int> binary_search(vector<int> solution) {
    deque<tuple<int, int>> dq;
    int start = 0;
    int end = solution.size() - 1;
    long long min = LLONG_MAX;

    dq.push_back({solution[start], solution[end]});

    while (start < end) {
        long long current_value = solution[start] + solution[end];

        if (current_value == 0) {
            return {solution[start], solution[end]};
        }

        if (abs(current_value) < min) {
            min = abs(current_value);
            dq.pop_front();
            dq.push_back({solution[start], solution[end]});
        }

        if (current_value > 0) {
            end--;
        } else {
            start++;
        }
    }

    return dq.front();
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n;
    cin >> n;
    vector<int> solution(n, 0);

    for (int i = 0; i < n; i++) {
        cin >> solution[i];
    }

    tuple<int, int> answer = binary_search(solution);

    cout << get<0>(answer) << ' ' << get<1>(answer) << '\n';
}