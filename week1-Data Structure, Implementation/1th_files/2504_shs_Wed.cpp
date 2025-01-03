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

    stack<char> st;
    stack<int> product;
    stack<int> result;
    string s;
    int len;
    int answer = 0;

    cin >> s;
    len = s.length();

    for (int i = 0; i < len; i++) {
        if (answer == -1) break;

        switch(s[i]) {
            case '(':
                st.push('(');
                if (i > 0 && (s[i - 1] == ')' || s[i - 1] == ']')) {
                    stack<int> tempStack = product;

                    while(!tempStack.empty()) {
                        int top = tempStack.top();
                        int newResult = result.top();
                        tempStack.pop();
                        result.pop();

                        newResult *= top;
                        result.push(newResult);
                    }
                }

                product.push(2);

                break;
            case ')':
                if (st.empty() || st.top() != '(') {
                    answer = -1;
                } else {
                    st.pop();

                    if (i > 0) {
                        if (s[i - 1] == '(') {
                            result.push(2);
                            product.pop();
                        } else {
                            int newResult = result.top();
                            result.pop();
                            newResult *= 2;
                            result.push(newResult);
                            product.pop();
                        }
                    }
                }

                break;
            case '[':
                st.push('[');

                if (i > 0 && (s[i - 1] == ')' || s[i - 1] == ']')) {
                    stack<int> tempStack = product;

                    while(!tempStack.empty()) {
                        int top = tempStack.top();
                        int newResult = result.top();
                        tempStack.pop();
                        result.pop();

                        newResult *= top;
                        result.push(newResult);
                    }
                }
                product.push(3);

                break;
            case ']':
                if (st.empty() || st.top() != '[') {
                    answer = -1;
                } else {
                    st.pop();

                    if (i > 0) {
                        if (s[i - 1] == '[') {
                            result.push(3);
                            product.pop();
                        } else {
                            int newResult = result.top();
                            result.pop();
                            newResult *= 3;
                            result.push(newResult);
                            product.pop();
                        }
                    }
                }

                break;
            default:
                break;
        }
    }

    if (answer == -1 || !st.empty()) cout << 0 << '\n';
    else {
        while(!result.empty()) {
            answer += result.top();
            result.pop();
        }

        cout << answer << '\n';
    }
}