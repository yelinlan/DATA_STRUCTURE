package Tree.TreeApply;

import utils.Common;

/**
 * @项目名称: DATA_STRUCTURE
 * @类名称: VIIIQueen
 * @类描述: 八皇后问题
 * @创建人: 权义翔
 * @创建时间: 2020/3/15 11:46
 **/
public class VIIIQueen<T> {
    //有线性表构成的数组
    public String[][] arr;
    int len;
    String sym = "0";
    String Que = "*";
    int res = 0;

    /**
     * @return :
     * @方法名 : VIIIQueen
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/15 11:54
     * @功能描述 : 初始化八皇后规模
     */
    public VIIIQueen(int count) {
        len = count;
        arr = new String[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                arr[i][j] = "0";
            }
        }
    }

    /**
     * @return : void
     * @方法名 : doVIIIQueen
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/15 11:49
     * @功能描述 : 求解八皇后问题
     */
    public void doVIIIQueen(String[][] arr, int row) {
        if (row >= len) {
            //打印皇后
            print(arr);
            return;
        }
        //思路分析 对每一行遍历
        for (int i = 0; i < len; i++) {
            //当前位置是否可放置
            if (canPut(arr, row, i)) {
                arr[row][i] = Que;
                doVIIIQueen(arr, row + 1);
                arr[row][i] = sym;
            } else {
                continue;
            }
        }
    }

    /**
     * @return : boolean
     * @方法名 : canPut
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/16 19:09
     * @功能描述 : 可以放置
     */
    public boolean canPut(String[][] arr, int row, int col) {

        //行
        for (int i = 0; i < col; i++) {
            if (Que.equals(arr[row][i])) {
                return false;
            }
        }
        //列
        for (int i = 0; i < row; i++) {
            if (Que.equals(arr[i][col])) {
                return false;
            }
        }
        //左斜线
        for (int i = 1; i <=Common.min(row, col); i++) {
            if (Que.equals(arr[row - i][col - i])) {
                return false;
            }
        }
        //右斜线
        for (int i = 1; i <= Common.min(row, len - col - 1); i++) {
            if (Que.equals(arr[row - i][col + i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return : void
     * @方法名 : print
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/16 19:55
     * @功能描述 : 打印数组
     */
    public void print(String[][] arr) {
        System.out.println("第" + (++res) + "种");
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}