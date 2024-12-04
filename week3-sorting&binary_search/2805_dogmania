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

void binary_search(vector<int> arr, int target, int start, int end, vector<long long>& answer) {
    while(start <= end) {
        int mid = (start + end) / 2;
        long long sum = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (arr[i] > mid) {
                sum += arr[i] - mid;
            }
        }
        if (sum < target) end = mid - 1;
        else {
            answer.push_back(mid);
            start = mid + 1;
        }
    }
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n, m;
    vector<long long> answer;

    cin >> n >> m;

    vector<int> arr(n, 0);

    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    sort(arr.begin(), arr.end());

    binary_search(arr, m, 1, arr.back(), answer);

    sort(answer.begin(), answer.end());

    if (answer.size() == 0) {
        cout << 0 << '\n';
    } else {
        cout << answer.back() << '\n';
    }
}