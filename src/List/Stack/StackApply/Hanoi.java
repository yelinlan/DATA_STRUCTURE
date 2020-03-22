package List.Stack.StackApply;

/**
 * @项目名称: DATA_STRUCTURE
 * @类名称: Hanoi
 * @类描述:    汉诺塔（递归）
 * @创建人: 权义翔
 * @创建时间: 2020/3/8 14:00
 **/
public class Hanoi {
    private static int count =0;
    /**
     * @方法名 : exec
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/8 14:03
     * @功能描述 :把n个盘子，借助y柱，从x柱搬到z柱
     *
     * @return : void
     */
  public static void  exec(int n,String x,String y,String z){
        if(n==1){
            move(x,1,z);
        }else{
            exec(n-1,x,z,y);
            move(x,n,z);
            exec(n-1,y,x,z);
        }
    }
    /**
     * @方法名 : move
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/8 14:16
     * @功能描述 : 移动
     *
     * @return : void
     */
   private static void move(String x,int n,String z){
       System.out.println("第"+(++count)+"步： "+n+"号盘子，"+x+"--->"+z);
    }
}