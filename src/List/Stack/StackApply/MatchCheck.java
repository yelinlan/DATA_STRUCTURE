package List.Stack.StackApply;

import List.Stack.LinkStack;
/**
 * @项目名称: DATA_STRUCTURE
 * @类名称: MatchCheck
 * @类描述: 括号匹配
 * @创建人: 权义翔
 * @创建时间: 2020/3/6 20:32
 **/
public class MatchCheck {
    /**
     * @return : jBoolean
     * @方法名 : MatchRules
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/6 20:39
     * @功能描述 : check匹配
     */
    public static Boolean MatchRules(char a, char b) {
        switch (a) {
            case '{':
                return b == '}';
            case '[':
                return b == ']';
            case '(':
                return b == ')';
            default:
                return false;
        }
    }

    public static Boolean MatchSymbol(String mat) {
        LinkStack stack = new LinkStack();
        char[] letter = mat.toCharArray();
        for (int i = 0; i < letter.length; i++) {
            if (stack.isEmpty()) {
                stack.push(letter[i]);
            } else if (MatchRules((char) stack.getTop(), letter[i])) {
                stack.pop();
            } else {
                stack.push(letter[i]);
            }
        }
        return stack.getLength() == 0;
    }
}