//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
// 注意空字符串可被认为是有效字符串。
//
// 示例 1:
//
// 输入: "()"
//输出: true
//
//
// 示例 2:
//
// 输入: "()[]{}"
//输出: true
//
//
// 示例 3:
//
// 输入: "(]"
//输出: false
//
//
// 示例 4:
//
// 输入: "([)]"
//输出: false
//
//
// 示例 5:
//
// 输入: "{[]}"
//输出: true
// Related Topics 栈 字符串

package com.mort.leetCode.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        solution.isValid("{[]}");
        solution.isValid("()[]{}");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {




        public boolean isValid(String s) {

            Map<Character, Character> matchMap = new HashMap<>();

            matchMap.put('(',')');
            matchMap.put(')','(');
            matchMap.put('[',']');
            matchMap.put(']','[');
            matchMap.put('{','}');
            matchMap.put('}','{');

            Stack<Character> stack = new Stack<>();
            char[] chars = s.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                if (!stack.isEmpty()) {
                    Character character = stack.pop();
                    if (chars[i] != matchMap.get(character)) {
                        stack.push(character);
                        stack.push(chars[i]);
                    }

                } else {
                    stack.push(chars[i]);
                }
            }
            return stack.size() == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}