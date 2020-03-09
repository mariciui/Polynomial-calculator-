
public class RegexUtil {

    public Integer extractCoefficient (String s1) {
        String[] var = s1.split("x\\^?(-?\\d+\\b)?");
        return Integer.parseInt(var[0]);

    }
    public Integer extractGrad(String s1) {

        String[] var1 = s1.split("\\^");

        return Integer.parseInt(var1[1]);
    }

    public Polinom splitPolinom(String s1) {
        Polinom p1 = new Polinom();
        String[] ret = s1.split("(?:[+-]|$)");
        for(int i = 0;i<ret.length;i++)
        {

            int grad = extractGrad(ret[i]);
            int coef = extractCoefficient(ret[i]);

            Monom m = new Monom(coef,grad);

            p1.addPol(m);
        }

        return p1;
    }



}
