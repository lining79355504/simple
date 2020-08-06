//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
// 示例:
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//
//
// 说明:
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
// Related Topics 字符串 回溯算法

package leetCode.leetcode.editor.cn;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        solution.letterCombinations("235");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<String> res=new ArrayList<>();
        char[] ref=new char[]{'0','0','a','d','g','j','m','p','t','w'};//记录2~9字母首位置
        char[] nums;//记录字符串数字'2'~'9'
        int len;//数字字符串长

        public void dfs(int index,StringBuilder sb){//对index下标处的数字按键，进行添加字母处理
            if(index==len){//字符添加足够
                res.add(new String(sb.toString()));//对应字符串加入结果集
                return;
            }
            char start=ref[nums[index]-'0'];//当前对应数字首字母
            char end= (start=='w')? 'z': (char)(ref[nums[index]-'0' +1]-1);//当前对应数字尾字母

            for(char x=start;x<=end;x++){//对当前按键数字（index下标处），的字母遍历操作
                sb.append(x);//添加当前按键的字母
                dfs(index+1,sb);//处理下一个按键
                sb.deleteCharAt(index);//回溯，退回当前按键字母；开始下一轮当前按键，下一个字母处理流程
            }
        }

        public List<String> letterCombinations(String digits) {
            this.len=digits.length();
            if(this.len==0) return new ArrayList<>();//特例返回
            this.nums=digits.toCharArray();//数字字符串转char[]
            dfs(0,new StringBuilder());
            return res;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}