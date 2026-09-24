import java.util.*;
public class Permutations_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>result=new ArrayList<>();
        findPermutations(nums,result,new ArrayList<>(),new boolean[nums.length]);
        return result;
    }
    void findPermutations(int[] nums,List<List<Integer>>result,List<Integer>currList,boolean[] usedVals){
        if(currList.size()==nums.length){
            result.add(new ArrayList<>(currList));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(usedVals[i]==true) continue;
            currList.add(nums[i]);
            usedVals[i]=true;
            findPermutations(nums,result,currList,usedVals);
            currList.remove(currList.size()-1);
            usedVals[i]=false;
        }
    }
}
