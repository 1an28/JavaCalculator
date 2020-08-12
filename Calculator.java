import javax.swing.*;
import java.awt.*;//import for border layout.
import java.awt.event.*;//import for the button event.

class Calculator extends JFrame {
    private String btnW[] = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "C", "=", "+"};
    private JButton[] btn = new JButton[16];

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
        textPanel.setLayout(new GridLayout(2, 1));
        JTextArea textA = new JTextArea();
        textPanel.add(textA);
        textA.setEditable(false);
        JTextField textF = new JTextField();
        textPanel.add(textF);
        
        getContentPane().add(textPanel, BorderLayout.NORTH);
        getContentPane().add(panel, BorderLayout.CENTER);
    }

    class ButtonPush implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String text = " ";
            for (int i = 0; i < 16; i++) {
                if (btn[i] == e.getSource()) {
                    text = btn[i].getText();
                }
            }
            JLabel label = new JLabel(text);
            JOptionPane.showMessageDialog(Calculator.this, label);
        }
    }
    
}