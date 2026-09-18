
public class Nqueens2 {
    int count=0;
    public int totalNQueens(int n) {
        boolean[] col=new boolean[n];
        boolean[] dia45=new boolean[2*n-1];
        boolean[] dia135=new boolean[2*n-1];
        helper(0,n,col,dia45,dia135);
        return count;
        
    }
    void helper(int row,int n,boolean[] colf,boolean[] dia45,boolean[] dia135){
        if(row==n){
            count++;
            return;
        }
        for(int col=0;col<n;col++){
            if(!colf[col] && !dia45[col+row] && !dia135[col+n-1-row]){
                colf[col]=true;
                dia45[col+row]=true;
                dia135[col+n-1-row]=true;
                helper(row+1,n,colf,dia45,dia135);
                colf[col]=false;
                dia45[col+row]=false;
                dia135[col+n-1-row]=false;
            }
        }
    }
    
}