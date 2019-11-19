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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import PatientCareUtil.CommonUtil;
import patientCareBusinessLogic.LoginLogic;
import patientCareConstants.CommonConstants;
import patientCareLogger.PatientCareLogger;
import patientCarePOJO.User;

public class LoginScreen extends JFrame {
	
	static Logger logger = PatientCareLogger.getLogger();

	/**
	 * 
	 */
	private static final long serialVersionUID = 2705889911763507462L;
	CommonUtil commonUtil = new CommonUtil();
	private JPanel loginPanel;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private JLabel lblUserType;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbUserType;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public LoginScreen() {
		setTitle("Patient Care");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 193);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		loginPanel = new JPanel();
		loginPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(loginPanel);
		GridBagLayout gbl_loginPanel = new GridBagLayout();
		gbl_loginPanel.columnWidths = new int[]{37, 65, 197, 0, 0};
		gbl_loginPanel.rowHeights = new int[]{20, 20, 20, 23, 0, 0};
		gbl_loginPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_loginPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		loginPanel.setLayout(gbl_loginPanel);
		
		JLabel lblUsername = new JLabel("Username");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.EAST;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 1;
		loginPanel.add(lblUsername, gbc_lblUsername);
		
		txtUsername = new JTextField();
		GridBagConstraints gbc_txtUsername = new GridBagConstraints();
		gbc_txtUsername.anchor = GridBagConstraints.NORTH;
		gbc_txtUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsername.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsername.gridx = 2;
		gbc_txtUsername.gridy = 1;
		loginPanel.add(txtUsername, gbc_txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 2;
		loginPanel.add(lblPassword, gbc_lblPassword);
		
		pwdPassword = new JPasswordField();
		GridBagConstraints gbc_pwdPassword = new GridBagConstraints();
		gbc_pwdPassword.anchor = GridBagConstraints.NORTH;
		gbc_pwdPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwdPassword.insets = new Insets(0, 0, 5, 5);
		gbc_pwdPassword.gridx = 2;
		gbc_pwdPassword.gridy = 2;
		loginPanel.add(pwdPassword, gbc_pwdPassword);
		
		lblUserType = new JLabel("User Type");
		GridBagConstraints gbc_lblUserType = new GridBagConstraints();
		gbc_lblUserType.anchor = GridBagConstraints.EAST;
		gbc_lblUserType.insets = new Insets(0, 0, 5, 5);
		gbc_lblUserType.gridx = 1;
		gbc_lblUserType.gridy = 3;
		loginPanel.add(lblUserType, gbc_lblUserType);
		
		cmbUserType = new JComboBox();
		cmbUserType.setModel(new DefaultComboBoxModel(new String[] {"Please Select", "Admin", "Doctor", "Patient", "Receptionist"}));
		GridBagConstraints gbc_cmbUserType = new GridBagConstraints();
		gbc_cmbUserType.insets = new Insets(0, 0, 5, 5);
		gbc_cmbUserType.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbUserType.gridx = 2;
		gbc_cmbUserType.gridy = 3;
		loginPanel.add(cmbUserType, gbc_cmbUserType);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mousePressed(MouseEvent e) {
				String username = txtUsername.getText();
				String password = pwdPassword.getText();
				LoginLogic loginObj = new LoginLogic();
				if (username.isEmpty() ) {
					JOptionPane.showMessageDialog(null, "Please enter the username", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else if (password.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter the password", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else if (loginObj.checkUser(username, password)) {
					JOptionPane.showMessageDialog(null, "Welcome - "+username, "Success",
							JOptionPane.INFORMATION_MESSAGE);
					User userObj = new User();
					userObj = loginObj.getUserDetails(username, password);
					commonUtil.setUserId(userObj.getUserId());
					if(userObj.getUserType().equalsIgnoreCase(CommonConstants.ADMIN)) {
						AdminScreen adminScreen = new AdminScreen();
						adminScreen.setVisible(true);
						dispose();
					} else if(userObj.getUserType().equalsIgnoreCase(CommonConstants.PATIENT)) {
						PatientScreen patientScreen = new PatientScreen();
						patientScreen.setVisible(true);
						dispose();
					} else if(userObj.getUserType().equalsIgnoreCase(CommonConstants.DOCTOR)) {
						DoctorScreen doctorScreen = new DoctorScreen();
						doctorScreen.setVisible(true);
						dispose();
					} else if(userObj.getUserType().equalsIgnoreCase(CommonConstants.RECEPTIONIST)) {
						ReceptionistScreen receptionistScreen = new ReceptionistScreen();
						receptionistScreen.setVisible(true);
						dispose();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Incorrect login or password", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLogin.anchor = GridBagConstraints.NORTH;
		gbc_btnLogin.insets = new Insets(0, 0, 0, 5);
		gbc_btnLogin.gridx = 2;
		gbc_btnLogin.gridy = 4;
		loginPanel.add(btnLogin, gbc_btnLogin);
	}
}
