package com.mort.airthmethic;

/**
 * @author mort
 * @Description
 * @date 2023/3/31
 * <p>
 * 写字符串需要的行数
 * <p>
 * 我们要把给定的字符串 S 从左到右写到每一行上，每一行的最大宽度为 100 个单位，如果我们在写某个字母的时候会使这行超过了 100 个单位，那么我们应该把这个字母写到下一行。
 * <p>
 * 我们给定了一个数组 widths ，这个数组 widths [0] 代表 'a' 需要的单位，widths [1] 代表 'b' 需要的单位，...， widths [25] 代表 'z' 需要的单位。
 * <p>
 * 现在回答两个问题：至少多少行能放下 S ，以及最后一行使用的宽度是多少个单位？将你的答案作为长度为 2 的整数列表返回。
 * <p>
 * 示例 2:
 * 输入:
 * widths = [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
 * S = "bbbcccdddaaa"
 * 输出: [2, 4]
 * 解释:
 * 除去字母'a'所有的字符都是相同的单位10，并且字符串 "bbbcccdddaa" 将会覆盖 9 * 10 + 2 * 4 = 98 个单位.
 * 最后一个字母 'a' 将会被写到第二行，因为第一行只剩下2个单位了。
 * 所以，这个答案是2行，第二行有4个单位宽度。
 **/
public class WriteCharNeedsLine {

    public static final int MAX_WIDTH = 100;


    public static int[] numberOfLines(int[] width, String s) {
        int line = 1;
        int widthTmp = 0;
        for (int i = 0; i < s.length(); i++) {
            int charLength = width[s.charAt(i) - 'a'];
            widthTmp = widthTmp + charLength;
            if (widthTmp > MAX_WIDTH) {
                line++;
                widthTmp = charLength;
            }
        }
        return new int[]{line, widthTmp};
    }

    public static void main(String[] args) {
        int[] widths = {4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        String s = "bbbcccdddaaa";
        numberOfLines(widths, s);
    }

}
