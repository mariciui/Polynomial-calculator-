
public interface Operatii {

    public Polinom add(Polinom p1, Polinom p2);

    public Polinom sub(Polinom p1, Polinom p2);

    public Polinom mul(Polinom p1, Polinom p2);

    public Polinom div(Polinom p1, Polinom p2);

    public Polinom deriv(Polinom p1);

    public Polinom integr(Polinom p1);

    public String toString(Polinom p1);

    public void sort(Polinom p1);

}
