
import java.util.ArrayList;

public class Polinom {

    private int grad;
    private ArrayList<Monom> polinom;

    public Polinom() {
        polinom = new ArrayList<Monom>();
    }

    public void addPol(Monom m) {
        polinom.add(m);

    }
    public int getGrad() {
        return grad;

    }
    public ArrayList<Monom> getPolinom() {
        return polinom;
    }
    public void setPolinom(ArrayList<Monom> polinom) {
        this.polinom = polinom;
    }

}
