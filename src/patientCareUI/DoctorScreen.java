/*
 * Copyright (C) 2019 PatientCare - Hospital Management System
 *
 * Licensed under PatientCare CLIENT LICENSE AGREEMENT (the "License");
 * you may not use this file except in compliance with the License.
 *
 * User acknowledges and agrees that this class constitute and incorporate PatientCare's confidential information. 
 * User shall take all reasonable precautions necessary to safeguard the confidentiality of all confidential information.  
 * 
 * User shall not:
 * (a) allow the removal or defacement of any confidentiality or proprietary notice placed on any confidential information
 * (a) permit any other person or third party to use or access the class; 
 * (b) sublicense, redistribute, sell, lease, or otherwise make the class available to any other person or third party;
 * (c) redistribute through personal email accounts, USB drives, internal or third party FTP sites, or internal share drives;  
 * (c) reproduce, copy, translate, modify, adapt, decompile, disassemble or reverse engineer any portion of the class or 
 *     otherwise attempt to secure the source code of all or any part of the Software; 
 */
package patientCareUI;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DoctorScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 400619205466386651L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the frame.
	 */
	public DoctorScreen() {
		setTitle("Patient Care");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 494);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlTop_D = new JPanel();
		pnlTop_D.setLayout(null);
		pnlTop_D.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlTop_D.setBounds(5, 5, 963, 30);
		contentPane.add(pnlTop_D);
		
		JButton button_1 = new JButton("Logout");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?",
						"Close Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (option == JOptionPane.YES_OPTION) {
					LoginScreen loginScreen = new LoginScreen();
					loginScreen.setVisible(true);
					setVisible(false);
				}
			}
		});
		button_1.setBounds(853, 6, 100, 19);
		pnlTop_D.add(button_1);
		
		JLabel label = new JLabel("Admin Control");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(10, -2, 131, 31);
		pnlTop_D.add(label);
		
		JTabbedPane pnlMainTabbed_D = new JTabbedPane(JTabbedPane.TOP);
		pnlMainTabbed_D.setBounds(5, 37, 963, 393);
		contentPane.add(pnlMainTabbed_D);
		
		JPanel pnlPatientDetails_D = new JPanel();
		pnlPatientDetails_D.setLayout(null);
		pnlMainTabbed_D.addTab("New tab", null, pnlPatientDetails_D, null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "User Form", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(0, 0, 483, 365);
		pnlPatientDetails_D.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{33, 107, 155, 91, 0, 0};
		gbl_panel_1.rowHeights = new int[]{20, 0, 0, 0, 0, 0, 0, 20, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel label_2 = new JLabel("Username");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 1;
		panel_1.add(label_2, gbc_label_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		panel_1.add(textField, gbc_textField);
		
		JButton button_2 = new JButton("New");
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_2.insets = new Insets(0, 0, 5, 5);
		gbc_button_2.gridx = 1;
		gbc_button_2.gridy = 6;
		panel_1.add(button_2, gbc_button_2);
		
		JButton button_3 = new JButton("Save");
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_3.insets = new Insets(0, 0, 5, 5);
		gbc_button_3.gridx = 2;
		gbc_button_3.gridy = 6;
		panel_1.add(button_3, gbc_button_3);
		
		JButton button_4 = new JButton("Delete");
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_4.insets = new Insets(0, 0, 5, 5);
		gbc_button_4.gridx = 3;
		gbc_button_4.gridy = 6;
		panel_1.add(button_4, gbc_button_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "User List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(483, 0, 475, 365);
		pnlPatientDetails_D.add(panel_2);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(6, 73, 453, 286);
		panel_2.add(scrollPane);
		
		JLabel label_3 = new JLabel("First Name");
		label_3.setBounds(179, 26, 51, 14);
		panel_2.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(239, 23, 127, 20);
		panel_2.add(textField_1);
		
		JButton button_5 = new JButton("Search");
		button_5.setBounds(376, 22, 89, 23);
		panel_2.add(button_5);
		
		JLabel label_4 = new JLabel("  Note: Result will show similar first names apart from exact match.");
		label_4.setBounds(6, 49, 445, 14);
		panel_2.add(label_4);
		
		JPanel pnlDiagnosisDetails_D = new JPanel();
		pnlMainTabbed_D.addTab("New tab", null, pnlDiagnosisDetails_D, null);
		pnlDiagnosisDetails_D.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "User Form", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(0, 0, 483, 365);
		pnlDiagnosisDetails_D.add(panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{33, 107, 155, 91, 0, 0};
		gbl_panel_4.rowHeights = new int[]{20, 0, 0, 0, 0, 0, 0, 20, 0, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel label_5 = new JLabel("Username");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.EAST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 1;
		gbc_label_5.gridy = 1;
		panel_4.add(label_5, gbc_label_5);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 1;
		panel_4.add(textField_2, gbc_textField_2);
		
		JButton button_6 = new JButton("New");
		GridBagConstraints gbc_button_6 = new GridBagConstraints();
		gbc_button_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_6.insets = new Insets(0, 0, 5, 5);
		gbc_button_6.gridx = 1;
		gbc_button_6.gridy = 6;
		panel_4.add(button_6, gbc_button_6);
		
		JButton button_7 = new JButton("Save");
		GridBagConstraints gbc_button_7 = new GridBagConstraints();
		gbc_button_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_7.insets = new Insets(0, 0, 5, 5);
		gbc_button_7.gridx = 2;
		gbc_button_7.gridy = 6;
		panel_4.add(button_7, gbc_button_7);
		
		JButton button_8 = new JButton("Delete");
		GridBagConstraints gbc_button_8 = new GridBagConstraints();
		gbc_button_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_8.insets = new Insets(0, 0, 5, 5);
		gbc_button_8.gridx = 3;
		gbc_button_8.gridy = 6;
		panel_4.add(button_8, gbc_button_8);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "User List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(483, 0, 475, 365);
		pnlDiagnosisDetails_D.add(panel_5);
		
		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		scrollPane_1.setBounds(6, 73, 453, 286);
		panel_5.add(scrollPane_1);
		
		JLabel label_6 = new JLabel("First Name");
		label_6.setBounds(179, 26, 51, 14);
		panel_5.add(label_6);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(239, 23, 127, 20);
		panel_5.add(textField_3);
		
		JButton button_9 = new JButton("Search");
		button_9.setBounds(376, 22, 89, 23);
		panel_5.add(button_9);
		
		JLabel label_7 = new JLabel("  Note: Result will show similar first names apart from exact match.");
		label_7.setBounds(6, 49, 445, 14);
		panel_5.add(label_7);
		
		JPanel pnlEventDetails_D = new JPanel();
		pnlMainTabbed_D.addTab("New tab", null, pnlEventDetails_D, null);
		pnlEventDetails_D.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "User Form", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(0, 0, 483, 365);
		pnlEventDetails_D.add(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{33, 107, 155, 91, 0, 0};
		gbl_panel_3.rowHeights = new int[]{20, 0, 0, 0, 0, 0, 0, 20, 0, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel label_8 = new JLabel("Username");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.anchor = GridBagConstraints.EAST;
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 1;
		gbc_label_8.gridy = 1;
		panel_3.add(label_8, gbc_label_8);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.gridx = 2;
		gbc_textField_4.gridy = 1;
		panel_3.add(textField_4, gbc_textField_4);
		
		JButton button_10 = new JButton("New");
		GridBagConstraints gbc_button_10 = new GridBagConstraints();
		gbc_button_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_10.insets = new Insets(0, 0, 5, 5);
		gbc_button_10.gridx = 1;
		gbc_button_10.gridy = 6;
		panel_3.add(button_10, gbc_button_10);
		
		JButton button_11 = new JButton("Save");
		GridBagConstraints gbc_button_11 = new GridBagConstraints();
		gbc_button_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_11.insets = new Insets(0, 0, 5, 5);
		gbc_button_11.gridx = 2;
		gbc_button_11.gridy = 6;
		panel_3.add(button_11, gbc_button_11);
		
		JButton button_12 = new JButton("Delete");
		GridBagConstraints gbc_button_12 = new GridBagConstraints();
		gbc_button_12.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_12.insets = new Insets(0, 0, 5, 5);
		gbc_button_12.gridx = 3;
		gbc_button_12.gridy = 6;
		panel_3.add(button_12, gbc_button_12);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "User List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(483, 0, 475, 365);
		pnlEventDetails_D.add(panel_6);
		
		JScrollPane scrollPane_2 = new JScrollPane((Component) null);
		scrollPane_2.setBounds(6, 73, 453, 286);
		panel_6.add(scrollPane_2);
		
		JLabel label_9 = new JLabel("First Name");
		label_9.setBounds(179, 26, 51, 14);
		panel_6.add(label_9);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(239, 23, 127, 20);
		panel_6.add(textField_5);
		
		JButton button_13 = new JButton("Search");
		button_13.setBounds(376, 22, 89, 23);
		panel_6.add(button_13);
		
		JLabel label_10 = new JLabel("  Note: Result will show similar first names apart from exact match.");
		label_10.setBounds(6, 49, 445, 14);
		panel_6.add(label_10);
		
		JPanel pnlBottom_D = new JPanel();
		pnlBottom_D.setLayout(null);
		pnlBottom_D.setBounds(5, 430, 963, 23);
		contentPane.add(pnlBottom_D);
		
		JLabel label_1 = new JLabel("Copyright @PatientCare 2019");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(0, 0, 268, 23);
		pnlBottom_D.add(label_1);
	}
}
