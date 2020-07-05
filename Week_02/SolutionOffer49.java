import java.util.ArrayList;
import java.util.List;

public class SolutionOffer49 {

    public static void main(String[] args) {
        System.out.println(new SolutionOffer49().nthUglyNumber(1020));
    }

    /**
     * 根据递推公式求，不然会超时
     * Xn-1 > Xn
     * 那么将Xn分别除以2、3、5之后，找到下一个比所得数大的数，Xa、Xb、Xc，那么下一个比Xn大的数就是这三个数分别乘以2、3、5之后的最小那个数
     */
    public int nthUglyNumber(int n) {
        if (n < 7) {
            return n;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            list.add(i);
        }
        int d2 = 0, d3 = 0, d5 = 0;

        while (list.size() < n) {
            int value = list.get(list.size() - 1);
            int m2 = value / 2;
            for (int i = d2; i < list.size(); i++) {
                if (list.get(i) > m2) {
                    m2 = list.get(i);
                    d2 = i;
                    break;
                }
            }

            int m3 = value / 3;
            for (int i = d3; i < list.size(); i++) {
                if (list.get(i) > m3) {
                    m3 = list.get(i);
                    d3 = i;
                    break;
                }
            }

            int m5 = value / 5;
            for (int i = d5; i < list.size(); i++) {
                if (list.get(i) > m5) {
                    m5 = list.get(i);
                    d5 = i;
                    break;
                }
            }
            list.add(Math.min(m5 * 5, Math.min(m2 * 2, m3 * 3)));
        }
        return list.get(n - 1);
    }
}
