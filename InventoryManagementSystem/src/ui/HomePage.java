package ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePage extends JFrame implements ActionListener{
	
	private JFrame frame;
	private JPanel panel,topPanel;
	
	private JButton products;
	
	private JButton customers;
	
	public HomePage() {
		setTitle("Home page");
		setPanel();
		setSize(700,500);
		/* Set frame to center of the screen */
    	setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setPanel() {
	    frame = new JFrame();
		panel = new JPanel();
		topPanel=new JPanel();
		
		products=new JButton("Products section");
		customers=new JButton("Customers section");
		
		JLabel label=new JLabel("Welcome to inventory management system!");
		label.setFont(new Font("Times New Roman", Font.BOLD, 24));
	
		
		setLayout(new GridBagLayout());
	    GridBagConstraints gc=new GridBagConstraints();
	    
	    /* Set weights */
	    gc.weightx=0.5;
	    gc.weighty=0.5;
	    
	    gc.gridx=0;
	    gc.gridy=0;
	    add(label,gc);
	    
	    gc.gridx=0;
	    gc.gridy=1;
	    gc.gridheight=1;
	    add(products,gc);
	    
	    gc.gridx=0;
	    gc.gridy=2;
	    add(customers,gc);
	    
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HomePage hp=new HomePage();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
	}

}
