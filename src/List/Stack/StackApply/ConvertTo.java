package List.Stack.StackApply;

import List.Stack.LinkStack;
import utils.StringUtils;

/**
 * @项目名称: DATA_STRUCTURE
 * @类名称: ConvertTo
 * @类描述: 进制转换（LinkStack）
 * @创建人: 权义翔
 * @创建时间: 2020/3/6 19:10
 **/
public class ConvertTo {
    /**
     * @return : String
     * @方法名 : BinaryForm
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/6 19:13
     * @功能描述 : M进制转换N进制
     */
    public static String AnyNumForm(String src, int M, int N) {
        int num = M2num(src, M);
        String s = num2M(num,N);
        return s;
    }

    /**
     * @return : String
     * @方法名 : num2M
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/6 19:35
     * @功能描述 : 十进制转M进制
     */
    public static String num2M(int number, int M) {
        String des = "";
        LinkStack stack = new LinkStack();
        while (number != 0) {
            stack.push(number % M);
            number /= M;
        }
        while (!stack.isEmpty()) {
            des += stack.pop() + ",";
        }
        des = des.substring(0, des.length() - 1);
        return des;
    }

    /**
     * @return : int
     * @方法名 : M2num
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/6 19:38
     * @功能描述 : M进制(1,2,3,4,5,6)转十进制
     */
    public static int M2num(String number, int M) {
        if(StringUtils.isBlank(number)){
            throw new RuntimeException("进制转换失败，原因数字为空 ");
        }
        String[] num = number.split(",");
        int index=1;
        int result=0;
        for (int i = 0; i < num.length; i++) {
            result+=index*StringUtils.toInteger(num[num.length-i-1]);
            index*=M;
        }
        return result;
    }
}