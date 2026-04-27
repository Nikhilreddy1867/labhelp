import java.util.*;
class program7 {
    private static int rec(int i,int j,int[][] adj,Integer[][] dp,int m,int n,int[] delRow,int[] delCol){
        if(dp[i][j]!=null) return dp[i][j];
        int ans=1;
        for(int k=0;k<4;k++){
            int n_row=i+delRow[k];
            int n_col=j+delCol[k];
            if(n_row>=0 && n_row<m && n_col>=0 && n_col<n && adj[n_row][n_col]>adj[i][j]){
                ans=Math.max(ans,1+rec(n_row,n_col,adj,dp,m,n,delRow,delCol));
            }
        }
        return dp[i][j]=ans;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][] adj=new int[m][n];
        Integer[][] dp=new Integer[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                adj[i][j]=sc.nextInt();
            }
        }
        int[] delRow={-1,0,1,0};
        int[] delCol={0,-1,0,1};
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans=Math.max(ans,rec(i,j,adj,dp,m,n,delRow,delCol));
            }
        }
        System.out.println(ans);
    }
}
