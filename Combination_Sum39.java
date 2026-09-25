import java.util.ArrayList;
import java.util.List;

public class Combination_Sum39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(int[] candidates, int target, int i,List<Integer> current,List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0 || i == candidates.length) {
            return;
        }
        current.add(candidates[i]);
        backtrack(candidates, target - candidates[i], i,current, result);
        current.remove(current.size() - 1);
        backtrack(candidates, target, i + 1,current, result);
    }
}
