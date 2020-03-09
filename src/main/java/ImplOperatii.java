import java.util.*;

public class ImplOperatii implements Operatii{


    Polinom prez = new Polinom();


    public Polinom add(Polinom p1, Polinom p2) {

        Polinom auxp1 = new Polinom();
        Polinom auxp2 = new Polinom();

        auxp1.setPolinom(p1.getPolinom());
        auxp2.setPolinom(p2.getPolinom());

        while(auxp1.getPolinom().size() != 0 && auxp2.getPolinom().size() != 0)
        {
            int powerOfFirstEl1 = auxp1.getPolinom().get(0).getGrad();
            int powerOfFirstEl2 = auxp2.getPolinom().get(0).getGrad();

            if (powerOfFirstEl1 == powerOfFirstEl2) {
                int coefSum = auxp1.getPolinom().get(0).getCoeff()+auxp2.getPolinom().get(0).getCoeff();
                Monom newMonom = new Monom(coefSum,powerOfFirstEl1);
                prez.addPol(newMonom);
                auxp1.getPolinom().remove(0);
                System.out.println(auxp2.getPolinom());
                auxp2.getPolinom().remove(0);

            }

            if(powerOfFirstEl1 > powerOfFirstEl2) {
                prez.addPol(auxp1.getPolinom().get(0));
                auxp1.getPolinom().remove(0);
            }

            if(powerOfFirstEl1 < powerOfFirstEl2) {
                prez.addPol(auxp2.getPolinom().get(0));
                auxp2.getPolinom().remove(0);
            }

        }

        while (auxp1.getPolinom().size() != 0)
        {
            prez.addPol(auxp1.getPolinom().get(0));
            auxp1.getPolinom().remove(0);
        }

        while (auxp2.getPolinom().size() != 0) {
            prez.addPol(auxp2.getPolinom().get(0));
            auxp2.getPolinom().remove(0);
        }
        sort(prez);
        return prez;
    }



    public Polinom sub(Polinom p1, Polinom p2) {

        Polinom auxp1 = new Polinom();
        Polinom auxp2 = new Polinom();

        auxp1.setPolinom(p1.getPolinom());
        auxp2.setPolinom(p2.getPolinom());

        while(auxp1.getPolinom().size() != 0 && auxp2.getPolinom().size() != 0)
        {
            int powerOfFirstEl1 = auxp1.getPolinom().get(0).getGrad();
            int powerOfFirstEl2 = auxp2.getPolinom().get(0).getGrad();

            if (powerOfFirstEl1 == powerOfFirstEl2) {
                int coefSum = auxp1.getPolinom().get(0).getCoeff()-auxp2.getPolinom().get(0).getCoeff();
                Monom newMonom = new Monom(coefSum,powerOfFirstEl1);
                prez.addPol(newMonom);
                auxp1.getPolinom().remove(0);
                auxp2.getPolinom().remove(0);
            }

            if(powerOfFirstEl1 > powerOfFirstEl2) {
                prez.addPol(p1.getPolinom().get(0));
                auxp1.getPolinom().remove(0);
            }

            if(powerOfFirstEl1 < powerOfFirstEl2) {
                int coef = -auxp2.getPolinom().get(0).getCoeff();
                int grad = auxp2.getPolinom().get(0).getGrad();
                System.out.println(coef);
                Monom m = new Monom(coef,grad);
                prez.addPol(m);
                auxp2.getPolinom().remove(0);
            }

        }

        while (auxp1.getPolinom().size() != 0)
        {
            prez.addPol(p1.getPolinom().get(0));
            auxp1.getPolinom().remove(0);
        }

        while (auxp2.getPolinom().size() != 0) {
            int coef = -auxp2.getPolinom().get(0).getCoeff();
            int grad = auxp2.getPolinom().get(0).getGrad();
            System.out.println(coef);
            Monom m = new Monom(coef,grad);
            prez.addPol(m);
            auxp2.getPolinom().remove(0);
        }
        sort(prez);
        return prez;
    }


    public Polinom mul(Polinom p1, Polinom p2) {


        for(int i = 0; i<p1.getPolinom().size();i++) {
            for(int j=0;j<p2.getPolinom().size();j++) {
                int prodCoeff = p1.getPolinom().get(i).getCoeff() * p2.getPolinom().get(j).getCoeff();
                int sumGrad = p1.getPolinom().get(i).getGrad() + p2.getPolinom().get(j).getGrad();
                Monom mNew = new Monom(prodCoeff,sumGrad);
                prez.addPol(mNew);

            }
        }

        sort(prez);
        return prez;
    }


    public Polinom div(Polinom p1, Polinom p2) {

        return null;
    }


    public Polinom deriv(Polinom p1) {
        for(int i = 0; i<p1.getPolinom().size();i++)
        {
            int mGrad = p1.getPolinom().get(i).getGrad()-1;
            int mCoeff = p1.getPolinom().get(i).getCoeff()*p1.getPolinom().get(i).getGrad();
            Monom mDeriv = new Monom(mCoeff,mGrad);
            prez.addPol(mDeriv);
        }

        return prez;
    }

    public Polinom integr(Polinom p1) {
        for(int i=0; i<p1.getPolinom().size();i++)
        {
            int mGrad = p1.getPolinom().get(i).getGrad()+1;
            int mCoeff = p1.getPolinom().get(i).getCoeff();


            Monom mInt = new Monom(mCoeff,mGrad);
            prez.addPol(mInt);
        }

        return prez;
    }
    public String toStringIntegr(Polinom p1) {
        String display="";

        int coeff = p1.getPolinom().get(0).getCoeff();
        int grad = p1.getPolinom().get(0).getGrad();
        display+=String.valueOf(String.valueOf(coeff)+"/"+String.valueOf(grad) + "x^" + String.valueOf(grad));
        p1.getPolinom().remove(0);

        while (p1.getPolinom().size() != 0) {
            int coef = p1.getPolinom().get(0).getCoeff();
            int g = p1.getPolinom().get(0).getGrad();

            if(coef != 0)
            {
                if (coef == 1 && g == 1) {
                    display += "+x";
                }
                else
                    display += "+" + coef + "/" + g + "x^" + g;

            }
            p1.getPolinom().remove(0);
        }

        return display;
    }

    public String toString(Polinom p1) {

        String display="";

        display += String.valueOf(p1.getPolinom().get(0).getCoeff()) + "x^" + String.valueOf(p1.getPolinom().get(0).getGrad());
        p1.getPolinom().remove(0);
        while (p1.getPolinom().size() != 0) {
            int coeff = p1.getPolinom().get(0).getCoeff();
            int grad = p1.getPolinom().get(0).getGrad();

            if(coeff != 0)
            {
                if (coeff > 0 && coeff != 1)
                {
                    if (grad == 0)
                    {
                        display += "+" + coeff;
                    }
                    else if (grad ==1)
                    {
                        display += "+" + coeff + "x";
                    }
                    else {
                        display += "+" + coeff + "x^" + grad;
                    }
                }
                else if (coeff == 1) {
                    if (grad == 0)
                        display += "+" + coeff;
                    else if (grad == 1)
                        display += "+" + "x";
                    else
                        display += "+" + "x^" + grad;

                } else  {
                    if (grad == 0)
                        display += coeff;
                    else if (grad == 1)
                        display += coeff + "x";
                    else
                        display += coeff + "x^" + grad;
                }
            }
            else if (grad != 0)
                display+="";
            p1.getPolinom().remove(0);
        }

        return display;

    }

    public void sort(Polinom p1) {

        Collections.sort(p1.getPolinom(),new Comp().reversed() );
    }

    class Comp implements Comparator<Monom>{

        public int compare(Monom m1, Monom m2) {

            return m1.getGrad() - m2.getGrad();
        }

    }
}