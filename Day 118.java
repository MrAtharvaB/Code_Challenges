class Solution {
  public:
    int subarrayRanges(vector<int>& arr) {
        int n = arr.size();
        vector<int> leftGreater(n), rightGreater(n);
        vector<int> leftSmaller(n), rightSmaller(n);
        stack<int> st;

        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[st.top()] <= arr[i]) st.pop();
            leftGreater[i] = st.empty() ? i + 1 : i - st.top();
            st.push(i);
        }

        while (!st.empty()) st.pop();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && arr[st.top()] < arr[i]) st.pop();
            rightGreater[i] = st.empty() ? n - i : st.top() - i;
            st.push(i);
        }

        while (!st.empty()) st.pop();

        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[st.top()] >= arr[i]) st.pop();
            leftSmaller[i] = st.empty() ? i + 1 : i - st.top();
            st.push(i);
        }

        while (!st.empty()) st.pop();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && arr[st.top()] > arr[i]) st.pop();
            rightSmaller[i] = st.empty() ? n - i : st.top() - i;
            st.push(i);
        }

        long long maxSum = 0, minSum = 0;

        for (int i = 0; i < n; i++) {
            maxSum += (long long)arr[i] * leftGreater[i] * rightGreater[i];
            minSum += (long long)arr[i] * leftSmaller[i] * rightSmaller[i];
        }

        return (int)(maxSum - minSum);
    }
};
