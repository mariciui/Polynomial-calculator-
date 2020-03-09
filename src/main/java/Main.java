import javax.swing.JFrame;

public class Main {



    public static void main(String[] args) {
        // TODO Auto-generated method stub


        GUI g = new GUI(args);
        g.pack();
        g.setLocationRelativeTo(null);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.setVisible(true);


    }

}
