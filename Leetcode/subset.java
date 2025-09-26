import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        for(int i=0; i < nums.length  ;i++){
            for(int j=0;j<answer.size();j++){
                List<Integer> temp = answer.get(j);
                temp.add(nums[i]);
                answer.add(temp);
            }
        }
        return answer;
    }
}