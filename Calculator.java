import javax.swing.*;
import java.awt.*;//import for border layout.
import java.awt.event.*;//import for the button event.
import java.util.ArrayList;

class Calculator extends JFrame {
    private String btnW[] = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "C", "=", "+"};
    private JButton[] btn = new JButton[16];
    private JTextField textF;
    private ArrayList<String> formula = new ArrayList<String>();
    private String preType = "";
    private String nowType = "";
    public static void main(String args[]) {
        //make a new instance of JFrame.
        Calculator frame = new Calculator( "Calculator" );
        //show a frame.
        frame.setVisible(true);
    }

    Calculator(String title) {
        //set a title
        setTitle(title);
        //set a frame position and size.
        setBounds( 100, 100, 600, 400 );
        //set a close button.
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        //make a panel.
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        //make a new instance of JButton class.
        for (int i = 0; i < 16; i++) {
            btn[i] = new JButton(btnW[i]);
            panel.add(btn[i]);
            btn[i].addActionListener(new ButtonPush());
        }

        //make a text field.
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(1, 1));
        textF = new JTextField();
        textF.setEditable(false);
        textPanel.add(textF);
        
        getContentPane().add(textPanel, BorderLayout.NORTH);
        getContentPane().add(panel, BorderLayout.CENTER);
    }

    class ButtonPush implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String text = "";
            String print = "";
            for (int i = 0; i < 16; i++) {
                if (btn[i] == e.getSource()) {
                    text = btn[i].getText();
                }
            }

            nowType = checkType(text.toCharArray()[0]);

            if (text == "C") {
                formula.clear();
            } else if (text == "=") {
                if (!(formula.size() == 0)) {
                    print = String.valueOf(calculation());
                    formula.clear();
                }
            } else if (!(formula.size() == 0 && nowType == "Sym")) {
                if (preType == "Num" && nowType == "Num") {
                    String numA = formula.get(formula.size() - 1);
                    formula.remove(formula.size() - 1);
                    text = numA + text;
                } else if ( preType == "Sym" && nowType == "Sym") {
                    formula.remove(formula.size() - 1);
                }

                formula.add(text);

                for (int i = 0; i < formula.size(); i++ ) {
                    print += formula.get(i);
                    print += " ";
                }
            }
            
            textF.setText(print);
            
            preType = checkType(text.toCharArray()[0]);
        }

        
    }
    
    private String checkType(char x) {
        String type;
        if (Character.isDigit(x)) {
            type = "Num";
        } else {
            type = "Sym";
        }
        return type;
    }
    private float calculation() {
        float ans = 0;
        float a = 0;
        float b = 0;
        String x = "";
        System.out.println(formula);
        try {
            for (int i = 0; i < formula.size(); i++ ) {
                if (formula.get(i+1) == "*" || formula.get(i+1) == "/") {
                    a = Float.parseFloat(formula.get(i));
                    x = formula.get(i+1);
                    b = Float.parseFloat(formula.get(i + 2));
                    if (x == "/" && b == 0) {
                        System.out.println("You entered 0 after / !");
                        System.exit(0);
                    }
                    formula.set(i, String.valueOf(x == "*" ? a*b : a/b));
                    formula.remove(i+2);
                    formula.remove(i+1);
                    
                    System.out.println(formula);

                    i--;
                }
            }  
        } catch (IndexOutOfBoundsException e) {
            //:)
            System.out.println(formula);
        }
        
        ans = Float.parseFloat(formula.get(0));

        for (int i = 1; i < formula.size() - 1; i+=2) {
            if (formula.get(i) == "+") {
                ans += Float.parseFloat(formula.get(i+1));
            } else if (formula.get(i) == "-") {
                ans -= Float.parseFloat(formula.get(i+1));
            }
            System.out.println(ans);
        }

        return ans;
    }
}