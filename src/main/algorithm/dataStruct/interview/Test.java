package algorithm.dataStruct.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zero
 * @created 2019/10/09
 */

class Solution {
    public void getAllIps(char[] nums, int begin, int end, String cur, int cnt, List<String> ans) {
        if (end - begin < cnt || cnt < 0) {
            return;
        }
        if (cnt == 0) {
            ans.add(cur.substring(1));
            return;
        }
//        getAllIps(nums, begin + 1, end, cur, cnt, ans);
        int temp = 0;
        for (int i = begin; i < end; i++) {
            temp = temp * 10 + nums[i] - '0';
            if (temp >= 256) {
                break;
            }
            getAllIps(nums, i + 1, end, cur + "." + temp, cnt - 1, ans);
            if (temp == 0) {
                break;
            }
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "374215";
        List<String> ans = new ArrayList<>();
        solution.getAllIps(s.toCharArray(), 0, s.length(), "", 4, ans);
        System.out.println(ans);
    }
}
