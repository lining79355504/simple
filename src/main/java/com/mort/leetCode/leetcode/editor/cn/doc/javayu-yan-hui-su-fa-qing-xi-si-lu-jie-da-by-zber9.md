```
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
```
