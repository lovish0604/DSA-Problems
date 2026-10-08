import java.util.ArrayList;
import java.util.List;

public class PermutationSequence_60 {
    public String getPermutation(int n, int k) {
        List<Integer>nums=new ArrayList<Integer>();
        int fact=1;
        for(int i=1;i<=n;i++){
            nums.add(i);
            fact*=i;
        }
        k--;
        fact/=n;
        StringBuilder sb=new StringBuilder();
        for(int i=n-1;i>=1;i--){
            int curr=k/fact;
            sb.append(String.valueOf(nums.get(curr)));
            nums.remove(curr);
            k%=fact;
            fact/=i;
        }
        sb.append(String.valueOf(nums.get(0)));
        return sb.toString();
    }
}
