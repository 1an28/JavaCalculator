import javax.swing.*;

class Calculator {
    public static void main(String args[]) {
        //make a new instance of JFrame.
        JFrame frame = new JFrame( "Calculator" );
        //set a frame position and size.
        frame.setBounds( 100, 100, 600, 400 );
        //set a close button.
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        //show a frame.
        frame.setVisible(true);
    }
}