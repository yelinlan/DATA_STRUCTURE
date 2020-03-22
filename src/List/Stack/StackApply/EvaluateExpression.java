package List.Stack.StackApply;

import List.Stack.LinkStack;

/**
 * @项目名称: DATA_STRUCTURE
 * @类名称: EvaluateExpression
 * @类描述: 表达式求值
 * @创建人: 权义翔
 * @创建时间: 2020/3/8 10:42
 **/
public class EvaluateExpression extends LinkStack {
    //操作符优先级列表
    private static final String[][] priority = {
            {">", ">", "<", "<", "<", ">", ">"},
            {">", ">", "<", "<", "<", ">", ">"},
            {">", ">", ">", ">", "<", ">", ">"},
            {">", ">", ">", ">", "<", ">", ">"},
            {"<", "<", "<", "<", "<", "=", "0"},
            {">", ">", ">", ">", "0", ">", ">"},
            {"<", "<", "<", "<", "<", "0", "="}
    };

    /**
     * @return : boolean
     * @方法名 : isNumOrDot
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/8 12:47
     * @功能描述 : 符号是数字或者点
     */
    private static boolean isNumOrDot(char sym) {
        return (sym >= '0' && sym <= '9') || sym == '.';
    }

    /**
     * @return : double
     * @方法名 : doEvalExpr
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/8 11:49
     * @功能描述 : 计算表达式值
     */
    public static double doEvalExpr(String expr) {
        String temp = "";
        String num = "";
        //补全参考头
        expr = "#("+expr+")#";
        //提取字符串表达式
        char[] sym = expr.replaceAll("\\s", "").toCharArray();
        for (int i = 0; i < sym.length; i++) {
            if (isNumOrDot(sym[i])) {
                num += sym[i];
            } else {
                if (!"".equals(num)) {
                    temp += num + ",";
                }
                temp += sym[i] + ",";
                num = "";
            }
        }
        //得到操作符，操作数表达式
        String[] syms = temp.replaceAll("\\s", "").split(",");
        //数字栈
        LinkStack<String> stackNum = new LinkStack<>();
        //符号栈
        LinkStack<String> stackSym = new LinkStack<>();
        stackSym.push(syms[0]);
        //计算
        int i = 1;
        while (!"#".equals(syms[i]) || !"#".equals(stackSym.getTop())) {
            if (isNumOrDot(syms[i].charAt(0))) {
                stackNum.push(syms[i]);
                i++;
            } else {
                String symTop = stackSym.getTop();
                switch (priority[getIndexOfPriority(symTop)][getIndexOfPriority(syms[i])]) {
                    case "<":
                        stackSym.push(syms[i]);
                        i++;
                        break;
                    case "=":
                        stackSym.pop();
                        i++;
                        break;
                    case ">":
                        String priSym = stackSym.pop();
                        String b = stackNum.pop();
                        String a = stackNum.pop();
                        //计算
                        stackNum.push(operator(a, priSym, b));
                        break;
                    case "0":throw new RuntimeException("运算符不匹配     "+symTop);
                }
            }
        }
        return Double.parseDouble(stackNum.getTop());
    }
/**
 * @方法名 : operator
 * @创建人 : 权义翔
 * @创建日期 : 2020/3/8 13:03
 * @功能描述 : 根据运算符计算值
 *
 * @return : T
 */
   private static String operator(String oper_a, String oper, String oper_b){
       try {
           double a = Double.parseDouble(oper_a);
           double b = Double.parseDouble(oper_b);
           switch (oper){
               case "+":
                   return String.valueOf((a+b));
               case "-":
                   return String.valueOf((a-b));
               case "*":
                   return String.valueOf((a*b));
               case "/":
                   return String.valueOf((a/b));
           }
           throw  new RuntimeException("找不到匹配的运算符   ："+oper);
       } catch (NumberFormatException e) {
           System.out.println(oper_a+"  :   "+oper_b);
           throw  new RuntimeException("字符串转换整型异常");
       }
   }

    /**
     * @return : int
     * @方法名 : getIndexOfPriority
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/8 11:44
     * @功能描述 : //获取操作符位置
     */
    private static int getIndexOfPriority(String sym) {
        switch (sym) {
            case "+":
                return 0;
            case "-":
                return 1;
            case "*":
                return 2;
            case "/":
                return 3;
            case "(":
                return 4;
            case ")":
                return 5;
            case "#":
                return 6;
            default:
                throw new RuntimeException("操作符错误");
        }
    }

}