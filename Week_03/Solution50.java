import java.util.LinkedList;
import java.util.List;

public class Solution50 {

    public static void main(String[] args) {
        Solution50 solution = new Solution50();
        double result = solution.myPow(2, -2);
        System.out.println("result" + result);
    }

    public double myPow(double x, int n) {
        return n > 0 ? myPow1(x, n) : 1.0 / myPow1(x, n);
    }

    private double myPow1(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double result = myPow1(x, n / 2);
        if (n % 2 == 0) {
            return result * result;
        } else {
            return result * result * x;
        }
    }
}