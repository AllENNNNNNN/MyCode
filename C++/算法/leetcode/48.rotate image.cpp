//https://leetcode.com/problems/rotate-image/description/
class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int n=matrix.size()-1;
        for(int i=0;i<=n/2;i++)
        {
            for(int j=0;j<=(n-1)/2;j++)//Ҫע�⣬���������м䣬���ܻ�任���Σ�����������(n-1)/2
            {
                swap(matrix[i][j],matrix[j][n-i]);
                swap(matrix[n-j][i],matrix[n-i][n-j]);
                swap(matrix[i][j],matrix[n-i][n-j]);
            }
        }
        
    }
};