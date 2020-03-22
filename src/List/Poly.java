package List;

import java.util.Arrays;

/**
 * @项目名称: DATA_STRUCTURE
 * @类名称: Poly
 * @类描述: 多项式
 * @创建人: 权义翔
 * @创建时间: 2020/3/8 17:40
 **/
public class Poly extends ListAndLink<CoefExpn> {
    //默认创建多项式
    public Poly(double ceof[]) {
        for (int i = 0; i < ceof.length; i++) {
            if (ceof[i] != 0) {
                this.addLast(new CoefExpn(ceof[i], i));
            }
        }
        if (this.getLength() == 0) {
            throw new RuntimeException("多项式为空");
        }
    }

    public Poly() {
    }

    /**
     * @方法名 : Poly
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/8 22:48
     * @功能描述 : 默认创建多项式
     *
     * @return :
     */
    public Poly(double ceof[], int expn[]) {
        if (ceof.length != expn.length) {
            throw new RuntimeException("系数与指数不匹配");
        }
        for (int i = 0; i < ceof.length; i++) {
            if (ceof[i] != 0) {
                this.addLast(new CoefExpn(ceof[i], expn[i]));
            }
        }
        if (this.getLength() == 0) {
            throw new RuntimeException("多项式为空");
        }
    }

    /**
     * @return : List.Poly
     * @方法名 : add
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/8 22:12
     * @功能描述 : 多项式加
     */
    public static Poly add(Poly p, Poly q) {
        p.sortPolyByCoef();
        q.sortPolyByCoef();
        Poly temp_poly = new Poly();
        Node pc = temp_poly.node;
        Node pa = p.node;
        Node pb = q.node;
        pa = pa.nextNode;
        pb = pb.nextNode;
        while (pa != null && pb != null) {
            CoefExpn pa_temp = (CoefExpn) pa.data;
            CoefExpn pb_temp = (CoefExpn) pb.data;
            if (pa_temp.expn > pb_temp.expn) {
                Node Lnode = new Node();
                pc.nextNode = Lnode;
                pc = pc.nextNode;
                pc.data = pb.data;
                pb = pb.nextNode;
            } else if (pa_temp.expn < pb_temp.expn) {
                Node Lnode = new Node();
                pc.nextNode = Lnode;
                pc = pc.nextNode;
                pc.data = pa.data;
                pa = pa.nextNode;
            } else {
                Node Lnode = new Node();
                pc.nextNode = Lnode;
                pc = pc.nextNode;
                CoefExpn coefExpn_temp = new CoefExpn((((CoefExpn) pa.data).coef + ((CoefExpn) pb.data).coef), ((CoefExpn) pa.data).expn);
                pc.data = coefExpn_temp;
                pa = pa.nextNode;
                pb = pb.nextNode;
            }
        }
        if (pb != null) {
            while (pb != null) {
                Node Lnode = new Node();
                pc.nextNode = Lnode;
                pc = pc.nextNode;
                pc.data = pb.data;
                pb = pb.nextNode;
            }

        }
        if (pa != null) {
            while (pa != null) {
                Node Lnode = new Node();
                pc.nextNode = Lnode;
                pc = pc.nextNode;
                pc.data = pa.data;
                pa = pa.nextNode;
            }
        }
        return temp_poly;
    }

    /**
     * @return : List.Poly
     * @方法名 : substract
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/8 22:13
     * @功能描述 : 多项式减p-q
     */
    public static Poly substract(Poly p, Poly q) {
        p.sortPolyByCoef();
        q.sortPolyByCoef();
        Poly temp_poly = new Poly();
        Node pc = temp_poly.node;
        Node pa = p.node;
        Node pb = q.node;
        pa = pa.nextNode;
        pb = pb.nextNode;
        while (pa != null && pb != null) {
            CoefExpn pa_temp = (CoefExpn) pa.data;
            CoefExpn pb_temp = (CoefExpn) pb.data;
            if (pa_temp.expn > pb_temp.expn) {
                Node Lnode = new Node();
                pc.nextNode = Lnode;
                pc = pc.nextNode;
                //a-b,放入负b值
                CoefExpn coefExpn_temp = new CoefExpn(-((CoefExpn) pb.data).coef, ((CoefExpn) pb.data).expn);
                pc.data = coefExpn_temp;
                pb = pb.nextNode;
            } else if (pa_temp.expn < pb_temp.expn) {
                Node Lnode = new Node();
                pc.nextNode = Lnode;
                pc = pc.nextNode;
                pc.data = pa.data;
                pa = pa.nextNode;
            } else {
                double ceof_result = ((CoefExpn) pa.data).coef - ((CoefExpn) pb.data).coef;
                if (ceof_result != 0) {
                    //结果不为零，正常减
                    Node Lnode = new Node();
                    pc.nextNode = Lnode;
                    pc = pc.nextNode;
                    CoefExpn coefExpn_temp = new CoefExpn(ceof_result, ((CoefExpn) pa.data).expn);
                    pc.data = coefExpn_temp;
                    pa = pa.nextNode;
                    pb = pb.nextNode;
                } else {
                    //结果为零，舍去该项
                    pa = pa.nextNode;
                    pb = pb.nextNode;
                }
            }
        }
        if (pb != null) {
            while (pb != null) {
                Node Lnode = new Node();
                pc.nextNode = Lnode;
                pc = pc.nextNode;
                pc.data = pb.data;
                pb = pb.nextNode;
            }

        }
        if (pa != null) {
            while (pa != null) {
                Node Lnode = new Node();
                pc.nextNode = Lnode;
                pc = pc.nextNode;
                pc.data = pa.data;
                pa = pa.nextNode;
            }
        }
        return temp_poly;
    }

    /**
     * @return : void
     * @方法名 : sortPolyByCoef
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/8 20:53
     * @功能描述 : 默认0升序(选择排序)
     */
    public void sortPolyByCoef(int... sort) {
        int sortType = 0;
        if (sort.length != 0) {
            sortType = 1;
        }
        int len = this.getLength();
        for (int i = 1; i <= len; i++) {
            int index = i;
            for (int j = i + 1; j <= len; j++) {
                if (sortType == 0) {
                    if (this.getElemByIndex(index).expn > this.getElemByIndex(j).expn) {
                        index = j;
                    }
                } else {
                    if (this.getElemByIndex(index).expn < this.getElemByIndex(j).expn) {
                        index = j;
                    }
                }
            }
            if (index != i) {
                CoefExpn re = this.remove(index);
                this.add(i, re);
            }
        }
    }

    /**
     * @return : List.Poly
     * @方法名 : multiply
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/8 22:41
     * @功能描述 : 多项式乘
     */
    public static Poly multiply(Poly p, Poly q) {
        Poly poly_sum = new Poly();
        for (int i = 1; i <= p.getLength(); i++) {
            for (int j = 1; j <= q.getLength(); j++) {
                CoefExpn coefExpn_p = p.getElemByIndex(i);
                CoefExpn coefExpn_q = q.getElemByIndex(j);
                Poly poly = new Poly(new double[]{coefExpn_p.coef * coefExpn_q.coef}, new int[]{coefExpn_p.expn + coefExpn_q.expn});
                poly_sum = add(poly_sum, poly);
            }
        }
        return poly_sum;
    }
/**
 * @方法名 : getSup
 * @创建人 : 权义翔
 * @创建日期 : 2020/3/8 23:35
 * @功能描述 : 得到上标
 *
 * @return : String
 */
   public String getSup(Integer dec){
       char[] chs = dec.toString().toCharArray();
       String str = "";
       for (int i = 0; i < chs.length; i++) {
           switch (chs[i]){
               case '0':str+='⁰';break;
               case '1':str+='¹';break;
               case '2':str+='²';break;
               case '3':str+='³';break;
               case '4':str+='⁴';break;
               case '5':str+='⁵';break;
               case '6':str+='⁶';break;
               case '7':str+='⁷';break;
               case '8':str+='⁸';break;
               case '9':str+='⁹';break;
               default:throw new RuntimeException("不是数字，转不了上标");
           }
       }
       return str;
   }

    @Override
    public String toString() {
        String s = "";
        Node p = this.node;
        while (p.nextNode != null) {
            p = p.nextNode;
            CoefExpn data = (CoefExpn) p.data;
            if (data.coef != 0) {
                if (data.expn == 0) {
                    s = s + data.coef + " + ";
                } else if (data.expn == 1) {
                    s = s + data.coef + "x + ";
                } else {
                    s = s + data.coef + "x" + getSup(data.expn) + " + ";
                }
            }
        }
        int len = s.length();
        s = s.substring(0, len - 2);
        return "Poly{" + s +
                "}";
    }

}