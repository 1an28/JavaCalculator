import javax.swing.*;
import java.awt.*;//import for border layout.
class Calculator {
    public static void main(String args[]) {
        //make a new instance of JFrame.
        JFrame frame = new JFrame( "Calculator" );
        //set a frame position and size.
        frame.setBounds( 100, 100, 600, 400 );
        //set a close button.
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        //make a panel.
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        //make a new instance of JButton class.
        JButton btn7 = new JButton("7");
        panel.add(btn7);
        JButton btn8 = new JButton("8");
        panel.add(btn8);
        JButton btn9 = new JButton("9");
        panel.add(btn9);
        JButton btnDivision = new JButton("/");
        panel.add(btnDivision);

        JButton btn4 = new JButton("4");
        panel.add(btn4);
        JButton btn5 = new JButton("5");
        panel.add(btn5);
        JButton btn6 = new JButton("6");
        panel.add(btn6);
        JButton btnMulti = new JButton("*");
        panel.add(btnMulti);

        JButton btn1 = new JButton("1");
        panel.add(btn1);
        JButton btn2 = new JButton("2");
        panel.add(btn2);
        JButton btn3 = new JButton("3");
        panel.add(btn3);
        JButton btnSubtraction = new JButton("-");
        panel.add(btnSubtraction);

        JButton btn0 = new JButton("0");
        panel.add(btn0);
        JButton btnC = new JButton("C");
        panel.add(btnC);
        JButton btnEqual = new JButton("=");
        panel.add(btnEqual);
        JButton btnAdd = new JButton("+");
        panel.add(btnAdd);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        //show a frame.
        frame.setVisible(true);
    }
}