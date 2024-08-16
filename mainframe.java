import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class mainframe extends JFrame {
    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    JTextField tfFirstName, tfLastName;
    JLabel lbWelcome;
    public Object buttonsPanel;
    public void initialize() {
        JLabel lbFirstName = new JLabel("First Name"); // Label for the first name
        lbFirstName.setFont(mainFont); 
        tfFirstName = new JTextField(); //  Create an instance
        tfFirstName.setFont(mainFont);

        JLabel lbLastName = new JLabel("Last Name"); // Label for the last name
        lbLastName.setFont(mainFont); 
        tfLastName = new JTextField(); // Create an instance
        tfLastName.setFont(mainFont);


        JPanel formPanel = new JPanel(); 
        formPanel.setLayout(new GridLayout(4, 1, 5, 5));
        formPanel.add(lbFirstName);
        formPanel.add(tfFirstName); 
        formPanel.add(lbLastName); 
        formPanel.add(tfFirstName);



            lbWelcome = new JLabel("Welcome");
            lbWelcome.setFont(mainFont);


            JButton btnOK =  new JButton("OK");
            btnOK.setFont(mainFont);
            btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
                
            });

            JButton btnClear = new JButton("Clear");
            btnClear.setFont(mainFont);
            btnClear.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");

                }
                
            });

            ((JFrame) buttonsPanel).setLayout(new GridLayout(1, 2, 5, 5));
            ((Container) buttonsPanel).add(btnOK);
            ((Container) buttonsPanel).add(btnClear);


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128 , 128, 255));
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(lbWelcome, BorderLayout.CENTER);
        mainPanel.add((Component) buttonsPanel, BorderLayout.SOUTH);

        add(mainPanel);


        setTitle("Welcome");
        setSize(500,600);
        setMinimumSize(new Dimension(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        mainframe myFrame = new mainframe();
        myFrame.initialize();
    }
}