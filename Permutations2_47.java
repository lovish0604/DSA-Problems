import java.util.*;
public class Permutations2_47 {
    public List<List<Integer>> permuteUnique(int[] nums){
        Set<List<Integer>> result=new HashSet<>();
        boolean[] visited=new boolean[nums.length];
        bt(result,nums,visited,new ArrayList());
        return new ArrayList<>(result);
    }
    private  void bt(Set<List<Integer>>result,int[] nums,boolean [] visited,List<Integer>tempResult){
        if(tempResult.size()==nums.length){
            result.add(new ArrayList<>(tempResult));
        }
        for (int i = 0; i < nums.length; i++) {
            if(!visited[i]){
                visited[i]=true;
                tempResult.add(nums[i]);
                bt(result,nums,visited,tempResult);
                tempResult.remove(tempResult.size()-1);
                visited[i]=false;
            }
        }
    }
}
