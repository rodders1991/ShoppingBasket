package main;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Program {

	private final static ShoppingBasket basket = new ShoppingBasket();
	private static JTextArea basketView;
	private static JTextField noOfProductsInput;
	private static JTextField totalInput;
	private static JTextField noOfItemsInput;
	
	public static void main(String[] args) {
		
		final JFrame frame = new JFrame();
		frame.setTitle("Shopping Basket");
		frame.setSize(1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		JPanel top = new JPanel();
		top.setLayout(new GridLayout(1,7));
		
		JLabel productNameLabel = new JLabel("Product Name");
		final JTextField productNameInput = new JTextField();
		JLabel quantityLabel = new JLabel("Quantity");
		final JSpinner quantityInput = new JSpinner();
		JLabel priceLabel = new JLabel("Latest Price");
		final JTextField priceInput = new JTextField();
		JButton addBut = new JButton("Add");
		
		top.add(productNameLabel);
		top.add(productNameInput);
		top.add(quantityLabel);
		top.add(quantityInput);
		top.add(priceLabel);
		top.add(priceInput);
		top.add(addBut);
		
		
		JPanel centre = new JPanel();
		centre.setLayout(new GridLayout(1,1));
		
		
		//TODO: Set Colour
		basketView = new JTextArea("Basket\n");
		basketView.append("Name \t\t Price\t\t Quantity\n");
		centre.add(basketView);
		
		JPanel bottom = new JPanel();
		bottom.setLayout(new GridLayout(1,7));
		
		JLabel noOfItemsLabel = new JLabel("No. Items");
		noOfItemsInput = new JTextField();
		JLabel totalLabel = new JLabel("Total");
		totalInput = new JTextField();
		JLabel noOfProductsLabel = new JLabel("No. Pro");
		noOfProductsInput = new JTextField();
		JButton exit = new JButton("Exit");
		
		bottom.add(noOfItemsLabel);
		bottom.add(noOfItemsInput);
		bottom.add(totalLabel);
		bottom.add(totalInput);
		bottom.add(noOfProductsLabel);
		bottom.add(noOfProductsInput);
		bottom.add(exit);
		
		JPanel right = new JPanel();
		right.setLayout(new GridLayout(3,1));
		
		JButton remove = new JButton("Remove");
		JButton edit = new JButton("Edit");
		JButton clearBasket = new JButton("Clear Basket");
		
		right.add(remove);
		right.add(edit);
		right.add(clearBasket);
		
		
		//Click Listeners
		class ButClickListener implements ActionListener
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				String s = e.getActionCommand();
				
				if(s == "Add")
				{
					try{
					addButton(productNameInput.getText(), priceInput.getText(),(Integer)quantityInput.getValue());	
					}
					catch(Exception el)
					{
						JOptionPane.showMessageDialog(null,"Incorrect Input Please try again");
					}
				}
				else if(s == "Remove")
				{
					removeButton();
				}
				else if(s == "Edit")
				{
					editButton();
				}
				else if(s == "Clear Basket")
				{
					basket.clearBasket();
					refreshBasket();
				}
				else if(s == "Exit")
				{
					frame.setVisible(false);
				}
				
				
			}
			
		}
		
		ActionListener listener = new ButClickListener();
		addBut.addActionListener(listener);
		remove.addActionListener(listener);
		edit.addActionListener(listener);
		clearBasket.addActionListener(listener);
		exit.addActionListener(listener);
		
		
		mainPanel.add(right,BorderLayout.EAST);
		mainPanel.add(bottom,BorderLayout.SOUTH);
		mainPanel.add(centre,BorderLayout.CENTER);
		mainPanel.add(top,BorderLayout.NORTH);
		frame.add(mainPanel);
		frame.setVisible(true);
		
		
	}
	
	
	public static void addButton(String name, String price, int quant)
	{	
		double priceIn = Double.parseDouble(price);
		int quantIn = quant;
		
		if(!basket.isProductInTheBasket(name)){
			
		basket.addProduct(name,priceIn,quantIn);
		
		}
		else{
			
			int i = basket.findItemByName(name);
			basket.getItems().get(i).addItems(priceIn, quant);
			
		}
		
		refreshBasket();
		
	}
	
	public static void removeButton()
	{
		final JFrame remove = new JFrame();
		remove.setTitle("Remove");
		remove.setSize(300,300);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		JPanel content = new JPanel();
		content.setLayout(new GridLayout(3,2));
		
		JLabel nameLabel = new JLabel("Product Name");
		final JTextField nameInput = new JTextField();
		JLabel quantLabel = new JLabel ("Quantity");
		final JSpinner quantInput = new JSpinner();
		JButton submit = new JButton("Ok");
		JButton cancel = new JButton("Cancel");
		
		class ButLis implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s = e.getActionCommand();
				
				if(s == "Ok")
				{
					basket.removeProduct(nameInput.getText(), (Integer) quantInput.getValue());
					refreshBasket();
					remove.setVisible(false);
				}
				else
				{
					remove.setVisible(false);
				}
				
			}
			
		}
		
		ActionListener lis = new ButLis();
		submit.addActionListener(lis);
		cancel.addActionListener(lis);
		
		
		content.add(nameLabel);
		content.add(nameInput);
		content.add(quantLabel);
		content.add(quantInput);
		content.add(submit);
		content.add(cancel);
		
		
		mainPanel.add(content,BorderLayout.CENTER);
		remove.add(mainPanel);
		
		
		
		
		
		remove.setVisible(true);
	}
	
	public static void editButton()
	{
		final JFrame edit = new JFrame();
		edit.setTitle("Edit");
		edit.setSize(300,300);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		JPanel content = new JPanel();
		content.setLayout(new GridLayout(4,2));
		
		JLabel nameLabel = new JLabel("Product Name");
		final JTextField nameInput = new JTextField();
		JLabel priceLabel = new JLabel("Price");
		final JTextField priceInput = new JTextField();
		JLabel quantLabel = new JLabel ("Quantity");
		final JSpinner quantInput = new JSpinner();
		JButton submit = new JButton("Ok");
		JButton cancel = new JButton("Cancel");
		
		class ButLis implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s = e.getActionCommand();
				
				if(s == "Ok")
				{
					basket.editItem(nameInput.getText(),Double.parseDouble(priceInput.getText()), (Integer) quantInput.getValue());
					refreshBasket();
					edit.setVisible(false);
				}
				else
				{
					edit.setVisible(false);
				}
				
			}
			
		}
		
		ActionListener lis = new ButLis();
		submit.addActionListener(lis);
		cancel.addActionListener(lis);
		
		
		content.add(nameLabel);
		content.add(nameInput);
		content.add(priceLabel);
		content.add(priceInput);
		content.add(quantLabel);
		content.add(quantInput);
		content.add(submit);
		content.add(cancel);
		
		
		mainPanel.add(content,BorderLayout.CENTER);
		edit.add(mainPanel);
		
		edit.setVisible(true);
		
	}
	
	
	public static void refreshBasket ()
	{
		
		basketView.setText("");
		basketView.append("Name \t\t Price\t\t Quantity\n");
		basketView.append(basket.orderItems());
		noOfItemsInput.setText(Integer.toString(basket.numberOfItems()));
		noOfProductsInput.setText(Integer.toString(basket.numberOfProducts()));
		totalInput.setText(Double.toString(basket.basketTotal()));
		
	}
	
	

}
