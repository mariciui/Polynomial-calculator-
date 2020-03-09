import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GUI extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JTextField polinom1 = new JTextField();
    private JTextField polinom2= new JTextField();
    private JTextField res= new JTextField();

    private JButton ad;
    private JButton sub;
    private JButton mul;
    private JButton div;
    private JButton integr;
    private JButton deriv;

    private JLabel l1 = new JLabel("polinom 1:");
    private JLabel l2 = new JLabel("polinom 2:");
    private JLabel result = new JLabel("result:");

    private Polinom pol1=new Polinom();
    private Polinom pol2=new Polinom();
    private Polinom polrez=new Polinom();
    private ImplOperatii op=new ImplOperatii();



    private String p1String;
    private String p2String;

    private RegexUtil ru = new RegexUtil();



    public GUI(Object args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p = new JPanel();

        p.setLayout(new BorderLayout());
        p1.setLayout(new GridLayout(2,3));
        p2.setLayout(new GridLayout(3,1));
        p3.setLayout(new GridLayout(3,1));

        p1.add(ad = new JButton("Adunare"));
        p1.add(sub = new JButton("Scadere"));
        p1.add(mul = new JButton("Inmultire"));
        p1.add(div = new JButton("Impartire"));
        p1.add(integr = new JButton("Integrare"));
        p1.add(deriv = new JButton("Derivare"));

        ad.setBackground(Color.CYAN);
        sub.setBackground(Color.GREEN);
        mul.setBackground(Color.CYAN);
        div.setBackground(Color.GREEN);
        integr.setBackground(Color.CYAN);
        deriv.setBackground(Color.GREEN);

        p3.add(l1);
        p3.add(l2);
        p3.add(result);

        p2.add(polinom1);
        p2.add(polinom2);
        p2.add(res);

        p.add(p3,BorderLayout.WEST);
        p.add(p2,BorderLayout.CENTER);

        p.setBackground(Color.white);
        p1.setBackground(Color.white);
        p2.setBackground(Color.white);
        p3.setBackground(Color.white);
        res.setBackground(Color.white);

        frame.add(p);
        frame.add(p1);
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);

        res.setEditable(false);

        ad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                p1String = polinom1.getText();
                p2String = polinom2.getText();

                pol1 = ru.splitPolinom(p1String);
                pol2 = ru.splitPolinom(p2String);

                polrez = op.add(pol1, pol2);
                String display = op.toString(polrez);

                res.setText(display);


            }
        });

        sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                p1String = polinom1.getText();
                p2String = polinom2.getText();

                pol1 = ru.splitPolinom(p1String);
                pol2 = ru.splitPolinom(p2String);


                polrez = op.sub(pol1, pol2);
                String display = op.toString(polrez);

                res.setText(display);
            }
        });

        mul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                p1String = polinom1.getText();
                p2String = polinom2.getText();

                pol1 = ru.splitPolinom(p1String);
                pol2 = ru.splitPolinom(p2String);

                polrez = op.mul(pol1,pol2);
                String display = op.toString(polrez);

                res.setText(display);
            }
        });

        div.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                res.setText("Metoda neimplementata!");
            }
        });

        deriv.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                p1String = polinom1.getText();


                pol1 = ru.splitPolinom(p1String);

                polrez=op.deriv(pol1);
                String display = op.toString(polrez);

                res.setText(display);
            }
        });

        integr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                p1String = polinom1.getText();

                pol1 = ru.splitPolinom(p1String);

                polrez = op.integr(pol1);
                String display = op.toStringIntegr(polrez);

                res.setText(display);
            }
        });
    }



}
