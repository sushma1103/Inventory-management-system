package ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.CustomerDAO;
import pojo.Customer;


	public class AddCustomerPage extends JFrame implements ActionListener{
		private JPanel panel;
		
		private JLabel name;
		private JTextField customerName;
		
		private JLabel location;
		private JTextField customerLocation;
		
		private JLabel phone;
		private JTextField phoneNumber;
		
		private JLabel customerCode;
		private JTextField code;
		
		private JLabel email;
		private JTextField emailAddress;
		
		private JButton save;
		private JButton back;

		public AddCustomerPage()
		{
			setTitle("Add customer page");
			setPanel();
			setSize(1000,800);
			setLocationRelativeTo(null);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
		}

		private void setPanel() {		
			/* Setting up panel */
			panel = new JPanel();
		    
			name=new JLabel("Name");
			customerName=new JTextField(20);
		    
			location=new JLabel("Location");
			customerLocation=new JTextField(20);
		    
			phone=new JLabel("Phone Number");
			phoneNumber=new JTextField(20);
			
			email=new JLabel("Email");
			emailAddress=new JTextField(20);
		    
			customerCode=new JLabel("Customer Code");
			code=new JTextField(20);
		    
		    save=new JButton("Save");
		    back= new JButton("Back");
			
			panel.add(name);
			panel.add(customerName);
			
			panel.add(location);
			panel.add(customerLocation);
			
			panel.add(phone);
			panel.add(phoneNumber);
			
			panel.add(email);
			panel.add(emailAddress);
			
			panel.add(customerCode);
			panel.add(code);
			
			panel.add(save);
			panel.add(back);
				
			setLayout(new GridBagLayout());
		    GridBagConstraints gc=new GridBagConstraints();
		    
		    /* Set weights */
		    gc.weightx=0.5;
		    gc.weighty=0.5;
		    
		    gc.gridx=0;
		    gc.gridy=2;
		    add(name,gc);
		    
		    gc.gridx=1;
		    gc.gridy=2;
		    add(customerName,gc);
		    
		    gc.gridx=0;
		    gc.gridy=3;
		    add(location,gc);
		    
		    gc.gridx=1;
		    gc.gridy=3;
		    add(customerLocation,gc);
		    
		    gc.gridx=1;
		    gc.gridy=4;
		    add(phoneNumber,gc);
		    
		    gc.gridx=0;
		    gc.gridy=4;
		    add(phone,gc);
		    
		    gc.gridx=1;
		    gc.gridy=5;
		    add(emailAddress,gc);
		    
		    gc.gridx=0;
		    gc.gridy=5;
		    add(email,gc);
		    
		    gc.gridx=0;
		    gc.gridy=6;
		    add(customerCode,gc);
		    
		    gc.gridx=1;
		    gc.gridy=6;
		    add(code,gc);
		    
		    gc.gridx=1;
		    gc.gridy=7;
		    add(save,gc);
		    
		    gc.gridx=0;
		    gc.gridy=7;
		    add(back,gc);
		    
		    save.addActionListener(this);
		    back.addActionListener(this);		    
		}
		
		public static void main(String[] args) {
			AddCustomerPage ca =new AddCustomerPage();
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource()==save) {
				Customer customer=new Customer();
			
				if(customerName.getText().equals("") || customerLocation.getText().equals("") || phoneNumber.getText().equals("") || code.getText().equals("") || emailAddress.getText().equals("") ){
					JOptionPane.showMessageDialog(null,"Please fill all the fields!");
				}   
				else {
					customer.setName(customerName.getText());
					customer.setLocation(customerLocation.getText());
					customer.setPhone(phoneNumber.getText());
					customer.setCustomerCode(code.getText());
					customer.setEmail(emailAddress.getText());
				
					new CustomerDAO().addCustomerDAO(customer); 
					JOptionPane.showMessageDialog(null,"Customer added succesfully!");
					}
				}
			
			 if(event.getSource()==back) {
				  	this.dispose();
					CustomersPage cp = new CustomersPage();
			  }
		}			
	}