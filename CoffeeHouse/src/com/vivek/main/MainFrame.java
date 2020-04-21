package com.vivek.main;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

import com.vivek.addon.Caramel;
import com.vivek.addon.Cream;
import com.vivek.addon.Milk;
import com.vivek.decorator.Coffee;
import com.vivek.delivery.FilterCoffee;
import com.vivek.delivery.InstantCoffee;
import com.vivek.type.Cappuccino;
import com.vivek.type.Espresso;
import com.vivek.type.Mochaccino;

public class MainFrame {

	private JFrame frame;
	private Coffee coffee;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_1;
	private JPanel panel;
	private boolean panelopen = false;;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame() {
		initialize();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 367);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Coffee House");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(149, 28, 110, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblCoffeeType = new JLabel("Coffee Type");
		lblCoffeeType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCoffeeType.setBounds(48, 118, 110, 19);
		frame.getContentPane().add(lblCoffeeType);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Cappuccino", "Espresso", "Mochaccino" }));
		comboBox.setBounds(272, 119, 98, 20);
		frame.getContentPane().add(comboBox);

		JLabel lblQueue = new JLabel("Queue Type");
		lblQueue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQueue.setBounds(48, 173, 110, 19);
		frame.getContentPane().add(lblQueue);

		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Instant", "Filter" }));
		comboBox_1.setBounds(272, 174, 98, 20);
		frame.getContentPane().add(comboBox_1);

		JLabel extralabel = new JLabel("Add Extra");
		extralabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		extralabel.setBounds(509, 21, 92, 30);
		frame.getContentPane().add(extralabel);

		panel = new JPanel();
		panel.setBounds(465, 73, 178, 151);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(true);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Milk");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxNewCheckBox.setBounds(23, 7, 97, 33);
		panel.add(chckbxNewCheckBox);

		JCheckBox chckbxCaramel = new JCheckBox("Caramel");
		chckbxCaramel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxCaramel.setBounds(23, 51, 97, 33);
		panel.add(chckbxCaramel);

		JCheckBox chckbxCream = new JCheckBox("Cream");
		chckbxCream.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxCream.setBounds(23, 93, 97, 33);
		panel.add(chckbxCream);

		JButton btnNewButton = new JButton("Order");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OrderCoffee();
			}
		});
		btnNewButton.setBounds(93, 276, 89, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnAddOn = new JButton("Extra");
		btnAddOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (panelopen) {
					panelopen = false;
					btnAddOn.setText("Extra");
					frame.setBounds(100, 100, 450, 367);
					frame.setLocationRelativeTo(null);
				} else {
					panelopen = true;
					btnAddOn.setText("Off panel");
					frame.setBounds(100, 100, 700, 367);
					frame.setLocationRelativeTo(null);
				}

			}
		});
		btnAddOn.setBounds(211, 276, 89, 23);
		frame.getContentPane().add(btnAddOn);

	}

	private void OrderCoffee() {

		switch (comboBox.getSelectedIndex()) {

		case 0:
			coffee = new Cappuccino();
			break;
		case 1:
			coffee = new Espresso();
			break;
		case 2:
			coffee = new Mochaccino();
			break;
		default:
			coffee = new Cappuccino();
			break;
		}

		switch (comboBox_1.getSelectedIndex()) {

		case 0:
			coffee = new InstantCoffee(coffee);
			break;
		case 1:
			coffee = new FilterCoffee(coffee);
			break;
		default:
			coffee = new InstantCoffee(coffee);
			break;
		}

		if (panelopen) {
			ArrayList<String> clickedData = manageCheckedCheckboxes(panel);

			for (String string : clickedData) {
				switch (string) {
				case "Milk":
					coffee = new Milk(coffee);
					break;
				case "Caramel":
					coffee = new Caramel(coffee);
					break;
				case "Cream":
					coffee = new Cream(coffee);
					break;
				}
			}
		}

		System.out.println("" + coffee.getDescription());
		System.out.println("" + coffee.cost());

	}

	public static ArrayList<String> manageCheckedCheckboxes(final Container c) {
		Component[] comps = c.getComponents();
		ArrayList<String> checkedTexts = new ArrayList<String>();
		for (Component comp : comps) {
			if (comp instanceof JCheckBox) {
				JCheckBox box = (JCheckBox) comp;
				if (box.isSelected()) {
					String text = box.getText();
					checkedTexts.add(text);
				}
			}
		}
		return checkedTexts;
	}
}
