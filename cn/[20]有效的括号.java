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
// 👍 1853 👎 0

/**
 * 创建hash函数 将）]}等右括号存入，当扫描s时 如果有s与其三个中的任意一个相等则进行判断stack中的顶端哪个数据
 * 是否与其相等，相等则这两个括号匹配，不相等则返回false，相等则移除顶部第一个数据 利用 POP将栈顶的元素移除
 *
 * Stack.Peek 与 stack.pop 的区别
 * 相同点：大家都返回栈顶的值。
 * 不同点：peek 不改变栈的值(不删除栈顶的值)，pop会把栈顶的值删除。
 */

import java.util.HashMap;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0)//可以不写 最后return stack.isEmpty()也是判断这的 写了可以调高运行效率
            return false;
        /**
         * 第一步存入右括号 出现右括号时 则与栈顶元素比较 如果值相同则ture 不同则false
         */
        Map<Character,Character> map = new HashMap<Character,Character>();
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');

        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)){
                if (stack.isEmpty()||stack.peek() != map.get(ch)){//此时右括号已经出现，栈为空或者 右括号与栈顶元素不同 返回false
                    return false;
                }
                 stack.pop();//匹配成功  删除栈顶元素，便于下一次比较
            }else{
                stack.push(ch);//不包含 说明时左括号 存入栈中
            }
        }
        return stack.isEmpty();//比较完之后 如果还有则
    }
}
//leetcode submit region end(Prohibit modification and deletion)
