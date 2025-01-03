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

int n, m;

int binarySearch(vector<int> &arr) {
    int first = 1;
    int last = arr.back();
    int max = 0;
    
    while(first <= last) {
        int mid = (first + last) / 2;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] < mid) continue;

            count += arr[i] / mid;
            if (count >= m) break;
        }

        if (count >= m) {
            max = mid;
            first = mid + 1;
        } else {
            last = mid - 1;
        }
    }

    return max;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> m >> n;
    int answer = 0;
    vector<int> arr(n, 0);

    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    sort(arr.begin(), arr.end());

    answer = binarySearch(arr);

    cout << answer << '\n';
}