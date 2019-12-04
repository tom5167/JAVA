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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import PatientCareUtil.DateLabelFormatter;
import patientCareBusinessLogic.PatientLogic;
import patientCareConstants.CommonConstants;
import patientCarePOJO.Patient;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Properties;

import javax.swing.JComboBox;

public class ReceptionistScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 400619205466386651L;
	PatientLogic patientLogic = new PatientLogic();
	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField txtFirstName_APF;
	private JTextField txtLastName_APF;
	private JTextField txtStreetNumber_APF;
	private JTextField txtAddress_APF;
	private JTextField txtCity_APF;
	private JTextField txtCountry_APF;
	private JTextField txtPostalCode_APF;
	private JTextField txtSinId_APF;
	private JTextField txtContactNumber_APF;
	private JTextField txtAlternativeNumber_APF;
	private JTextField txtInsuranceId_APF;
	private JTextField txtEmailId_APF;
	private JTable tblPatientList_APL;
	private JTextField txtFirstName_APL;

	/**
	 * Create the frame.
	 */
	public ReceptionistScreen() {
		setTitle("Patient Care");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 983, 494);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlTop_R = new JPanel();
		pnlTop_R.setLayout(null);
		pnlTop_R.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlTop_R.setBounds(5, 5, 963, 30);
		contentPane.add(pnlTop_R);
		
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
		pnlTop_R.add(button_1);
		
		JLabel label = new JLabel("Receptionist Control");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(10, -2, 131, 31);
		pnlTop_R.add(label);
		
		JTabbedPane pnlMainTabbed_R = new JTabbedPane(JTabbedPane.TOP);
		pnlMainTabbed_R.setBounds(5, 37, 963, 393);
		contentPane.add(pnlMainTabbed_R);
		
		JPanel pnlPatientDetails_R = new JPanel();
		pnlPatientDetails_R.setLayout(null);
		pnlMainTabbed_R.addTab("Patient Details", null, pnlPatientDetails_R, null);
		
		JPanel pnlPatientForm_AP = new JPanel();
		pnlPatientForm_AP.setBounds(0, 0, 493, 365);
		pnlPatientDetails_R.add(pnlPatientForm_AP);
		pnlPatientForm_AP.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Patient Form", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagLayout gbl_pnlPatientForm_AP = new GridBagLayout();
		gbl_pnlPatientForm_AP.columnWidths = new int[]{26, 95, 106, 79, 0, 0, 0};
		gbl_pnlPatientForm_AP.rowHeights = new int[]{20, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlPatientForm_AP.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_pnlPatientForm_AP.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		pnlPatientForm_AP.setLayout(gbl_pnlPatientForm_AP);
		
		JLabel lblPatientId_APF = new JLabel("");
		lblPatientId_APF.setEnabled(false);
		GridBagConstraints gbc_lblPatientId_APF = new GridBagConstraints();
		gbc_lblPatientId_APF.fill = GridBagConstraints.VERTICAL;
		gbc_lblPatientId_APF.insets = new Insets(0, 0, 5, 5);
		gbc_lblPatientId_APF.gridx = 2;
		gbc_lblPatientId_APF.gridy = 0;
		pnlPatientForm_AP.add(lblPatientId_APF, gbc_lblPatientId_APF);
		
		JLabel lblFirstName_APF = new JLabel("First Name");
		GridBagConstraints gbc_lblFirstName_APF = new GridBagConstraints();
		gbc_lblFirstName_APF.anchor = GridBagConstraints.EAST;
		gbc_lblFirstName_APF.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName_APF.gridx = 1;
		gbc_lblFirstName_APF.gridy = 1;
		pnlPatientForm_AP.add(lblFirstName_APF, gbc_lblFirstName_APF);
		
		txtFirstName_APF = new JTextField();
		GridBagConstraints gbc_txtFirstName_APF = new GridBagConstraints();
		gbc_txtFirstName_APF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFirstName_APF.insets = new Insets(0, 0, 5, 5);
		gbc_txtFirstName_APF.anchor = GridBagConstraints.NORTH;
		gbc_txtFirstName_APF.gridx = 2;
		gbc_txtFirstName_APF.gridy = 1;
		pnlPatientForm_AP.add(txtFirstName_APF, gbc_txtFirstName_APF);
		txtFirstName_APF.setColumns(10);
		
		JLabel lblBloodGroup_APF = new JLabel("Blood Group");
		GridBagConstraints gbc_lblBloodGroup_APF = new GridBagConstraints();
		gbc_lblBloodGroup_APF.anchor = GridBagConstraints.EAST;
		gbc_lblBloodGroup_APF.insets = new Insets(0, 0, 5, 5);
		gbc_lblBloodGroup_APF.gridx = 3;
		gbc_lblBloodGroup_APF.gridy = 1;
		pnlPatientForm_AP.add(lblBloodGroup_APF, gbc_lblBloodGroup_APF);
		
		JComboBox cmbBloodGroup_APF = new JComboBox();
		cmbBloodGroup_APF.setModel(new DefaultComboBoxModel(new String[] {"Please Select", "A+", "B+", "B-", "C+", "O+", "AB+"}));
		GridBagConstraints gbc_cmbBloodGroup_APF = new GridBagConstraints();
		gbc_cmbBloodGroup_APF.insets = new Insets(0, 0, 5, 5);
		gbc_cmbBloodGroup_APF.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbBloodGroup_APF.gridx = 4;
		gbc_cmbBloodGroup_APF.gridy = 1;
		pnlPatientForm_AP.add(cmbBloodGroup_APF, gbc_cmbBloodGroup_APF);
		
		JLabel lblLastName_APF = new JLabel("Last Name");
		GridBagConstraints gbc_lblLastName_APF = new GridBagConstraints();
		gbc_lblLastName_APF.anchor = GridBagConstraints.EAST;
		gbc_lblLastName_APF.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName_APF.gridx = 1;
		gbc_lblLastName_APF.gridy = 2;
		pnlPatientForm_AP.add(lblLastName_APF, gbc_lblLastName_APF);
		
		txtLastName_APF = new JTextField();
		GridBagConstraints gbc_txtLastName_APF = new GridBagConstraints();
		gbc_txtLastName_APF.insets = new Insets(0, 0, 5, 5);
		gbc_txtLastName_APF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLastName_APF.gridx = 2;
		gbc_txtLastName_APF.gridy = 2;
		pnlPatientForm_AP.add(txtLastName_APF, gbc_txtLastName_APF);
		txtLastName_APF.setColumns(10);
		
		JLabel lblContactNumber_APF = new JLabel("Contact Number");
		GridBagConstraints gbc_lblContactNumber_APF = new GridBagConstraints();
		gbc_lblContactNumber_APF.anchor = GridBagConstraints.EAST;
		gbc_lblContactNumber_APF.insets = new Insets(0, 0, 5, 5);
		gbc_lblContactNumber_APF.gridx = 3;
		gbc_lblContactNumber_APF.gridy = 2;
		pnlPatientForm_AP.add(lblContactNumber_APF, gbc_lblContactNumber_APF);
		
		txtContactNumber_APF = new JTextField();
		GridBagConstraints gbc_txtContactNumber_APF = new GridBagConstraints();
		gbc_txtContactNumber_APF.insets = new Insets(0, 0, 5, 5);
		gbc_txtContactNumber_APF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtContactNumber_APF.gridx = 4;
		gbc_txtContactNumber_APF.gridy = 2;
		pnlPatientForm_AP.add(txtContactNumber_APF, gbc_txtContactNumber_APF);
		txtContactNumber_APF.setColumns(10);
		
		JLabel lblSex_APF = new JLabel("Sex");
		GridBagConstraints gbc_lblSex_APF = new GridBagConstraints();
		gbc_lblSex_APF.anchor = GridBagConstraints.EAST;
		gbc_lblSex_APF.insets = new Insets(0, 0, 5, 5);
		gbc_lblSex_APF.gridx = 1;
		gbc_lblSex_APF.gridy = 3;
		pnlPatientForm_AP.add(lblSex_APF, gbc_lblSex_APF);
		
		JComboBox cmbSex_APF = new JComboBox();
		cmbSex_APF.setModel(new DefaultComboBoxModel(new String[] {"Please Select", "Male", "Female", "Other"}));
		GridBagConstraints gbc_cmbSex_APF = new GridBagConstraints();
		gbc_cmbSex_APF.insets = new Insets(0, 0, 5, 5);
		gbc_cmbSex_APF.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbSex_APF.gridx = 2;
		gbc_cmbSex_APF.gridy = 3;
		pnlPatientForm_AP.add(cmbSex_APF, gbc_cmbSex_APF);
		
		JLabel lblAlternativeNumber_APF = new JLabel("Alternative Number");
		GridBagConstraints gbc_lblAlternativeNumber_APF = new GridBagConstraints();
		gbc_lblAlternativeNumber_APF.anchor = GridBagConstraints.EAST;
		gbc_lblAlternativeNumber_APF.insets = new Insets(0, 0, 5, 5);
		gbc_lblAlternativeNumber_APF.gridx = 3;
		gbc_lblAlternativeNumber_APF.gridy = 3;
		pnlPatientForm_AP.add(lblAlternativeNumber_APF, gbc_lblAlternativeNumber_APF);
		
		txtAlternativeNumber_APF = new JTextField();
		GridBagConstraints gbc_txtAlternativeNumber_APF = new GridBagConstraints();
		gbc_txtAlternativeNumber_APF.insets = new Insets(0, 0, 5, 5);
		gbc_txtAlternativeNumber_APF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAlternativeNumber_APF.gridx = 4;
		gbc_txtAlternativeNumber_APF.gridy = 3;
		pnlPatientForm_AP.add(txtAlternativeNumber_APF, gbc_txtAlternativeNumber_APF);
		txtAlternativeNumber_APF.setColumns(10);
		
		JLabel lblDateOfBirth_APF = new JLabel("Date of Birth");
		GridBagConstraints gbc_lblDateOfBirth_APF = new GridBagConstraints();
		gbc_lblDateOfBirth_APF.anchor = GridBagConstraints.EAST;
		gbc_lblDateOfBirth_APF.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateOfBirth_APF.gridx = 1;
		gbc_lblDateOfBirth_APF.gridy = 4;
		pnlPatientForm_AP.add(lblDateOfBirth_APF, gbc_lblDateOfBirth_APF);
		
		UtilDateModel dateModel_APF = new UtilDateModel();
		Properties prop_APF = new Properties();
		prop_APF.put("text.today", "Today");
		prop_APF.put("text.month", "Month");
		prop_APF.put("text.year", "Year");
		JDatePanelImpl datePanel_APF = new JDatePanelImpl(dateModel_APF, prop_APF);
		DateLabelFormatter dateLabelFormatter_APF = new DateLabelFormatter();
		JDatePickerImpl datePicker_APF = new JDatePickerImpl(datePanel_APF, dateLabelFormatter_APF);
		
		GridBagConstraints gbc_datePicker_APF = new GridBagConstraints();
		gbc_datePicker_APF.insets = new Insets(0, 0, 5, 5);
		gbc_datePicker_APF.fill = GridBagConstraints.HORIZONTAL;
		gbc_datePicker_APF.gridx = 2;
		gbc_datePicker_APF.gridy = 4;
		pnlPatientForm_AP.add(datePicker_APF, gbc_datePicker_APF);
		
		JLabel lblEmailId_APF = new JLabel("Email Id");
		GridBagConstraints gbc_lblEmailId_APF = new GridBagConstraints();
		gbc_lblEmailId_APF.anchor = GridBagConstraints.EAST;
		gbc_lblEmailId_APF.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmailId_APF.gridx = 3;
		gbc_lblEmailId_APF.gridy = 4;
		pnlPatientForm_AP.add(lblEmailId_APF, gbc_lblEmailId_APF);
		
		txtEmailId_APF = new JTextField();
		GridBagConstraints gbc_txtEmailId_APF = new GridBagConstraints();
		gbc_txtEmailId_APF.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmailId_APF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmailId_APF.gridx = 4;
		gbc_txtEmailId_APF.gridy = 4;
		pnlPatientForm_AP.add(txtEmailId_APF, gbc_txtEmailId_APF);
		txtEmailId_APF.setColumns(10);
		
		JLabel lblMaritalStatus_APF = new JLabel("Marital Status");
		GridBagConstraints gbc_lblMaritalStatus_APF = new GridBagConstraints();
		gbc_lblMaritalStatus_APF.anchor = GridBagConstraints.EAST;
		gbc_lblMaritalStatus_APF.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaritalStatus_APF.gridx = 1;
		gbc_lblMaritalStatus_APF.gridy = 5;
		pnlPatientForm_AP.add(lblMaritalStatus_APF, gbc_lblMaritalStatus_APF);
		
		JComboBox cmbMaritalStatus_APF = new JComboBox();
		cmbMaritalStatus_APF.setModel(new DefaultComboBoxModel(new String[] {"Please Select", "Single", "Married", "Divorced"}));
		GridBagConstraints gbc_cmbMaritalStatus_APF = new GridBagConstraints();
		gbc_cmbMaritalStatus_APF.insets = new Insets(0, 0, 5, 5);
		gbc_cmbMaritalStatus_APF.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbMaritalStatus_APF.gridx = 2;
		gbc_cmbMaritalStatus_APF.gridy = 5;
		pnlPatientForm_AP.add(cmbMaritalStatus_APF, gbc_cmbMaritalStatus_APF);
		
		JLabel lblSinId_APF = new JLabel("Sin Id");
		GridBagConstraints gbc_lblSinId_APF = new GridBagConstraints();
		gbc_lblSinId_APF.anchor = GridBagConstraints.EAST;
		gbc_lblSinId_APF.insets = new Insets(0, 0, 5, 5);
		gbc_lblSinId_APF.gridx = 3;
		gbc_lblSinId_APF.gridy = 5;
		pnlPatientForm_AP.add(lblSinId_APF, gbc_lblSinId_APF);
		
		txtSinId_APF = new JTextField();
		txtSinId_APF.setColumns(10);
		GridBagConstraints gbc_txtSinId_APF = new GridBagConstraints();
		gbc_txtSinId_APF.insets = new Insets(0, 0, 5, 5);
		gbc_txtSinId_APF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSinId_APF.gridx = 4;
		gbc_txtSinId_APF.gridy = 5;
		pnlPatientForm_AP.add(txtSinId_APF, gbc_txtSinId_APF);
		
		JLabel lblStreetNumber_APF = new JLabel("Street Number");
		GridBagConstraints gbc_lblStreetNumber_APF = new GridBagConstraints();
		gbc_lblStreetNumber_APF.anchor = GridBagConstraints.EAST;
		gbc_lblStreetNumber_APF.insets = new Insets(0, 0, 5, 5);
		gbc_lblStreetNumber_APF.gridx = 1;
		gbc_lblStreetNumber_APF.gridy = 6;
		pnlPatientForm_AP.add(lblStreetNumber_APF, gbc_lblStreetNumber_APF);
		
		txtStreetNumber_APF = new JTextField();
		GridBagConstraints gbc_txtStreetNumber_APF = new GridBagConstraints();
		gbc_txtStreetNumber_APF.insets = new Insets(0, 0, 5, 5);
		gbc_txtStreetNumber_APF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStreetNumber_APF.gridx = 2;
		gbc_txtStreetNumber_APF.gridy = 6;
		pnlPatientForm_AP.add(txtStreetNumber_APF, gbc_txtStreetNumber_APF);
		txtStreetNumber_APF.setColumns(10);
		
		JLabel lblInsuranceId_APF = new JLabel("Insurance Id");
		GridBagConstraints gbc_lblInsuranceId_APF = new GridBagConstraints();
		gbc_lblInsuranceId_APF.anchor = GridBagConstraints.EAST;
		gbc_lblInsuranceId_APF.insets = new Insets(0, 0, 5, 5);
		gbc_lblInsuranceId_APF.gridx = 3;
		gbc_lblInsuranceId_APF.gridy = 6;
		pnlPatientForm_AP.add(lblInsuranceId_APF, gbc_lblInsuranceId_APF);
		
		txtInsuranceId_APF = new JTextField();
		GridBagConstraints gbc_txtInsuranceId_APF = new GridBagConstraints();
		gbc_txtInsuranceId_APF.insets = new Insets(0, 0, 5, 5);
		gbc_txtInsuranceId_APF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInsuranceId_APF.gridx = 4;
		gbc_txtInsuranceId_APF.gridy = 6;
		pnlPatientForm_AP.add(txtInsuranceId_APF, gbc_txtInsuranceId_APF);
		txtInsuranceId_APF.setColumns(10);
		
		JLabel lblAddress_APF = new JLabel("Address");
		GridBagConstraints gbc_lblAddress_APF = new GridBagConstraints();
		gbc_lblAddress_APF.anchor = GridBagConstraints.EAST;
		gbc_lblAddress_APF.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress_APF.gridx = 1;
		gbc_lblAddress_APF.gridy = 7;
		pnlPatientForm_AP.add(lblAddress_APF, gbc_lblAddress_APF);
		
		txtAddress_APF = new JTextField();
		GridBagConstraints gbc_txtAddress_APF = new GridBagConstraints();
		gbc_txtAddress_APF.insets = new Insets(0, 0, 5, 5);
		gbc_txtAddress_APF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAddress_APF.gridx = 2;
		gbc_txtAddress_APF.gridy = 7;
		pnlPatientForm_AP.add(txtAddress_APF, gbc_txtAddress_APF);
		txtAddress_APF.setColumns(10);
		
		JLabel lblCity_APF = new JLabel("City");
		GridBagConstraints gbc_lblCity_APF = new GridBagConstraints();
		gbc_lblCity_APF.anchor = GridBagConstraints.EAST;
		gbc_lblCity_APF.insets = new Insets(0, 0, 5, 5);
		gbc_lblCity_APF.gridx = 1;
		gbc_lblCity_APF.gridy = 8;
		pnlPatientForm_AP.add(lblCity_APF, gbc_lblCity_APF);
		
		txtCity_APF = new JTextField();
		GridBagConstraints gbc_txtCity_APF = new GridBagConstraints();
		gbc_txtCity_APF.insets = new Insets(0, 0, 5, 5);
		gbc_txtCity_APF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCity_APF.gridx = 2;
		gbc_txtCity_APF.gridy = 8;
		pnlPatientForm_AP.add(txtCity_APF, gbc_txtCity_APF);
		txtCity_APF.setColumns(10);
		
		JLabel lblCountry_APF = new JLabel("Country");
		GridBagConstraints gbc_lblCountry_APF = new GridBagConstraints();
		gbc_lblCountry_APF.anchor = GridBagConstraints.EAST;
		gbc_lblCountry_APF.insets = new Insets(0, 0, 5, 5);
		gbc_lblCountry_APF.gridx = 1;
		gbc_lblCountry_APF.gridy = 9;
		pnlPatientForm_AP.add(lblCountry_APF, gbc_lblCountry_APF);
		
		txtCountry_APF = new JTextField();
		GridBagConstraints gbc_txtCountry_APF = new GridBagConstraints();
		gbc_txtCountry_APF.insets = new Insets(0, 0, 5, 5);
		gbc_txtCountry_APF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCountry_APF.gridx = 2;
		gbc_txtCountry_APF.gridy = 9;
		pnlPatientForm_AP.add(txtCountry_APF, gbc_txtCountry_APF);
		txtCountry_APF.setColumns(10);
		
		JLabel lblPostalCode_APF = new JLabel("Postal Code");
		GridBagConstraints gbc_lblPostalCode_APF = new GridBagConstraints();
		gbc_lblPostalCode_APF.anchor = GridBagConstraints.EAST;
		gbc_lblPostalCode_APF.insets = new Insets(0, 0, 5, 5);
		gbc_lblPostalCode_APF.gridx = 1;
		gbc_lblPostalCode_APF.gridy = 10;
		pnlPatientForm_AP.add(lblPostalCode_APF, gbc_lblPostalCode_APF);
		
		txtPostalCode_APF = new JTextField();
		GridBagConstraints gbc_txtPostalCode_APF = new GridBagConstraints();
		gbc_txtPostalCode_APF.insets = new Insets(0, 0, 5, 5);
		gbc_txtPostalCode_APF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPostalCode_APF.gridx = 2;
		gbc_txtPostalCode_APF.gridy = 10;
		pnlPatientForm_AP.add(txtPostalCode_APF, gbc_txtPostalCode_APF);
		txtPostalCode_APF.setColumns(10);
		
		JButton btnDelete_APF = new JButton("Delete");
		btnDelete_APF.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Patient patientDetails = new Patient();
				if(lblPatientId_APF.getText().equalsIgnoreCase("")) {
					patientDetails.setPatientId(0);
				} else {
					patientDetails.setPatientId(Integer.parseInt(lblPatientId_APF.getText()));
				}
				patientLogic.deletePatientDetails(patientDetails);
			}
		});
		
		JButton btnSave_APF = new JButton("Save");
		btnSave_APF.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Patient patientDetails = new Patient();
				if(lblPatientId_APF.getText().equalsIgnoreCase("")) {
					patientDetails.setPatientId(0);
				} else {
					patientDetails.setPatientId(Integer.parseInt(lblPatientId_APF.getText()));
				}
				patientDetails.setFirstName(txtFirstName_APF.getText());
				patientDetails.setLastName(txtLastName_APF.getText());
				patientDetails.setSex(cmbSex_APF.getSelectedItem().toString());
				patientDetails.setDob(datePicker_APF.getJFormattedTextField().getText());
				patientDetails.setStreetNumber(txtStreetNumber_APF.getText());
				patientDetails.setAddressFull(txtAddress_APF.getText());
				patientDetails.setCity(txtCity_APF.getText());
				patientDetails.setCountry(txtCountry_APF.getText());
				patientDetails.setPostalCode(txtPostalCode_APF.getText());
				patientDetails.setSinId(txtSinId_APF.getText());
				patientDetails.setContactNumber(txtContactNumber_APF.getText());
				patientDetails.setAlternativeNumber(txtAlternativeNumber_APF.getText());
				patientDetails.setInsuranceId(txtInsuranceId_APF.getText());
				patientDetails.setEmailId(txtEmailId_APF.getText());
				patientDetails.setBloodGroup(cmbBloodGroup_APF.getSelectedItem().toString());
				patientDetails.setMaritalStatus(cmbMaritalStatus_APF.getSelectedItem().toString());
				patientLogic.savePatientDetails(patientDetails);
			}
		});
		
		JButton btnNew_APF = new JButton("New");
		btnNew_APF.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblPatientId_APF.setText(CommonConstants.EMPTY_STRING);
				txtFirstName_APF.setText(CommonConstants.EMPTY_STRING);
				txtLastName_APF.setText(CommonConstants.EMPTY_STRING);
				cmbSex_APF.setSelectedItem(CommonConstants.PLEASE_SELECT);
				datePicker_APF.getJFormattedTextField().setText(CommonConstants.EMPTY_STRING);
				txtStreetNumber_APF.setText(CommonConstants.EMPTY_STRING);
				txtCountry_APF.setText(CommonConstants.EMPTY_STRING);
				txtAddress_APF.setText(CommonConstants.EMPTY_STRING);
				txtCity_APF.setText(CommonConstants.EMPTY_STRING);
				txtPostalCode_APF.setText(CommonConstants.EMPTY_STRING);
				txtSinId_APF.setText(CommonConstants.EMPTY_STRING);
				txtContactNumber_APF.setText(CommonConstants.EMPTY_STRING);
				txtAlternativeNumber_APF.setText(CommonConstants.EMPTY_STRING);
				txtInsuranceId_APF.setText(CommonConstants.EMPTY_STRING);
				txtEmailId_APF.setText(CommonConstants.EMPTY_STRING);
				cmbBloodGroup_APF.setSelectedItem(CommonConstants.PLEASE_SELECT);
				cmbMaritalStatus_APF.setSelectedItem(CommonConstants.PLEASE_SELECT);
			}
		});
		GridBagConstraints gbc_btnNew_APF = new GridBagConstraints();
		gbc_btnNew_APF.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNew_APF.insets = new Insets(0, 0, 0, 5);
		gbc_btnNew_APF.gridx = 2;
		gbc_btnNew_APF.gridy = 12;
		pnlPatientForm_AP.add(btnNew_APF, gbc_btnNew_APF);
		GridBagConstraints gbc_btnSave_APF = new GridBagConstraints();
		gbc_btnSave_APF.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSave_APF.insets = new Insets(0, 0, 0, 5);
		gbc_btnSave_APF.gridx = 3;
		gbc_btnSave_APF.gridy = 12;
		pnlPatientForm_AP.add(btnSave_APF, gbc_btnSave_APF);
		GridBagConstraints gbc_btnDelete_APF = new GridBagConstraints();
		gbc_btnDelete_APF.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDelete_APF.insets = new Insets(0, 0, 0, 5);
		gbc_btnDelete_APF.gridx = 4;
		gbc_btnDelete_APF.gridy = 12;
		pnlPatientForm_AP.add(btnDelete_APF, gbc_btnDelete_APF);
		
		JPanel pnlPatientList_AP = new JPanel();
		pnlPatientList_AP.setBounds(493, 0, 465, 365);
		pnlPatientDetails_R.add(pnlPatientList_AP);
		pnlPatientList_AP.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Patient List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlPatientList_AP.setLayout(null);
		
		// Patient Details View
		
		tblPatientList_APL = new JTable();
		tblPatientList_APL.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				DefaultTableModel modelPatient = (DefaultTableModel) tblPatientList_APL.getModel();
				int selectedRowIndex = tblPatientList_APL.getSelectedRow();
				if(selectedRowIndex > -1) {
					lblPatientId_APF.setText(modelPatient.getValueAt(selectedRowIndex, 0).toString());
					txtFirstName_APF.setText(modelPatient.getValueAt(selectedRowIndex, 1).toString());
					txtLastName_APF.setText(modelPatient.getValueAt(selectedRowIndex, 2).toString());
					cmbSex_APF.setSelectedItem(modelPatient.getValueAt(selectedRowIndex, 3).toString());
					datePicker_APF.getJFormattedTextField().setText(modelPatient.getValueAt(selectedRowIndex, 4).toString());
					txtStreetNumber_APF.setText(modelPatient.getValueAt(selectedRowIndex, 5).toString());
					txtCountry_APF.setText(modelPatient.getValueAt(selectedRowIndex, 6).toString());
					txtAddress_APF.setText(modelPatient.getValueAt(selectedRowIndex, 7).toString());
					txtCity_APF.setText(modelPatient.getValueAt(selectedRowIndex, 8).toString());
					txtPostalCode_APF.setText(modelPatient.getValueAt(selectedRowIndex, 9).toString());
					txtSinId_APF.setText(modelPatient.getValueAt(selectedRowIndex, 10).toString());
					txtContactNumber_APF.setText(modelPatient.getValueAt(selectedRowIndex, 11).toString());
					txtAlternativeNumber_APF.setText(modelPatient.getValueAt(selectedRowIndex, 12).toString());
					txtInsuranceId_APF.setText(modelPatient.getValueAt(selectedRowIndex, 13).toString());
					txtEmailId_APF.setText(modelPatient.getValueAt(selectedRowIndex, 14).toString());
					cmbBloodGroup_APF.setSelectedItem(modelPatient.getValueAt(selectedRowIndex, 15).toString());
					cmbMaritalStatus_APF.setSelectedItem(modelPatient.getValueAt(selectedRowIndex, 16).toString());
				}
			}
		});
		tblPatientList_APL.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Patient Id", "First Name", "Last Name", "Sex", "Date of Birth", "Street Number", "Address", "City", "Country","Postal Code", "Sin Id", "Contact Number", "Alternative Number", "Insurance Id", "Email Id", "Blood_group", "Marital Status", "Created By", "Created Date", "Modified By", "Modified Date"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		});
		
		tblPatientList_APL.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPatientList_APL = new JScrollPane(tblPatientList_APL);
		scrollPatientList_APL.setBounds(6, 73, 449, 286);
		pnlPatientList_AP.add(scrollPatientList_APL);
		
		JLabel lblFirstName_APL = new JLabel("First Name");
		lblFirstName_APL.setBounds(10, 23, 51, 14);
		pnlPatientList_AP.add(lblFirstName_APL);
		
		txtFirstName_APL = new JTextField();
		txtFirstName_APL.setColumns(10);
		txtFirstName_APL.setBounds(70, 20, 127, 20);
		pnlPatientList_AP.add(txtFirstName_APL);
		
		JButton btnSearch_APL = new JButton("Search");
		btnSearch_APL.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(txtFirstName_APL.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Please enter the first name to search", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				DefaultTableModel modelPatient = (DefaultTableModel) tblPatientList_APL.getModel();
				List<Patient> alPatientDetails = patientLogic.getAlPatientDetails(txtFirstName_APL.getText());
				modelPatient.setRowCount(0);
				if(alPatientDetails.size() == 0) {
					JOptionPane.showMessageDialog(null, "No record found", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					for (int i=0;i<alPatientDetails.size();i++) {
						Object[] row = new String[21];
						row[0] = alPatientDetails.get(i).getPatientId()+"";
						row[1] = alPatientDetails.get(i).getFirstName();
						row[2] = alPatientDetails.get(i).getLastName();
						row[3] = alPatientDetails.get(i).getSex();
						row[4] = alPatientDetails.get(i).getDob();
						row[5] = alPatientDetails.get(i).getStreetNumber();
						row[6] = alPatientDetails.get(i).getAddressFull();
						row[7] = alPatientDetails.get(i).getCity();
						row[8] = alPatientDetails.get(i).getCountry();
						row[9] = alPatientDetails.get(i).getPostalCode();
						row[10] = alPatientDetails.get(i).getSinId();
						row[11] = alPatientDetails.get(i).getContactNumber();
						row[12] = alPatientDetails.get(i).getAlternativeNumber();
						row[13] = alPatientDetails.get(i).getInsuranceId();
						row[14] = alPatientDetails.get(i).getEmailId();
						row[15] = alPatientDetails.get(i).getBloodGroup();
						row[16] = alPatientDetails.get(i).getMaritalStatus();
						row[17] = alPatientDetails.get(i).getCreatedBy();
						row[18] = alPatientDetails.get(i).getCreatedDate();
						row[19] = alPatientDetails.get(i).getModifiedBy();
						row[20] = alPatientDetails.get(i).getModifiedDate();
						modelPatient.addRow(row);
					}
				}
			}
		});
		btnSearch_APL.setBounds(366, 19, 89, 23);
		pnlPatientList_AP.add(btnSearch_APL);
		
		JLabel lblNote_APL = new JLabel("  Note: Result will show similar first names apart from exact match.");
		lblNote_APL.setBounds(6, 48, 445, 14);
		pnlPatientList_AP.add(lblNote_APL);
		
		
		// Patient Details View
		
		JPanel pnlBillDetails_R = new JPanel();
		pnlBillDetails_R.setLayout(null);
		pnlMainTabbed_R.addTab("Bill Details", null, pnlBillDetails_R, null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Bill Form", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(0, 0, 483, 365);
		pnlBillDetails_R.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{33, 107, 155, 91, 0, 0};
		gbl_panel.rowHeights = new int[]{20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0, 20, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel label_11 = new JLabel("");
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.insets = new Insets(0, 0, 5, 5);
		gbc_label_11.gridx = 2;
		gbc_label_11.gridy = 0;
		panel.add(label_11, gbc_label_11);
		
		JLabel label_14 = new JLabel("Patient Id");
		GridBagConstraints gbc_label_14 = new GridBagConstraints();
		gbc_label_14.anchor = GridBagConstraints.EAST;
		gbc_label_14.insets = new Insets(0, 0, 5, 5);
		gbc_label_14.gridx = 1;
		gbc_label_14.gridy = 1;
		panel.add(label_14, gbc_label_14);
		
		JLabel label_15 = new JLabel("Patient Name");
		GridBagConstraints gbc_label_15 = new GridBagConstraints();
		gbc_label_15.anchor = GridBagConstraints.EAST;
		gbc_label_15.insets = new Insets(0, 0, 5, 5);
		gbc_label_15.gridx = 1;
		gbc_label_15.gridy = 2;
		panel.add(label_15, gbc_label_15);
		
		JLabel label_16 = new JLabel("Mode of Payment");
		GridBagConstraints gbc_label_16 = new GridBagConstraints();
		gbc_label_16.anchor = GridBagConstraints.EAST;
		gbc_label_16.insets = new Insets(0, 0, 5, 5);
		gbc_label_16.gridx = 1;
		gbc_label_16.gridy = 3;
		panel.add(label_16, gbc_label_16);
		
		JLabel label_17 = new JLabel("Payment Due Date");
		GridBagConstraints gbc_label_17 = new GridBagConstraints();
		gbc_label_17.anchor = GridBagConstraints.EAST;
		gbc_label_17.insets = new Insets(0, 0, 5, 5);
		gbc_label_17.gridx = 1;
		gbc_label_17.gridy = 4;
		panel.add(label_17, gbc_label_17);
		
		JLabel label_18 = new JLabel("Billing Time Stamp");
		GridBagConstraints gbc_label_18 = new GridBagConstraints();
		gbc_label_18.anchor = GridBagConstraints.EAST;
		gbc_label_18.insets = new Insets(0, 0, 5, 5);
		gbc_label_18.gridx = 1;
		gbc_label_18.gridy = 5;
		panel.add(label_18, gbc_label_18);
		
		JLabel label_19 = new JLabel("Insurance Number");
		GridBagConstraints gbc_label_19 = new GridBagConstraints();
		gbc_label_19.anchor = GridBagConstraints.EAST;
		gbc_label_19.insets = new Insets(0, 0, 5, 5);
		gbc_label_19.gridx = 1;
		gbc_label_19.gridy = 6;
		panel.add(label_19, gbc_label_19);
		
		JLabel label_20 = new JLabel("Payer Name");
		GridBagConstraints gbc_label_20 = new GridBagConstraints();
		gbc_label_20.anchor = GridBagConstraints.EAST;
		gbc_label_20.insets = new Insets(0, 0, 5, 5);
		gbc_label_20.gridx = 1;
		gbc_label_20.gridy = 7;
		panel.add(label_20, gbc_label_20);
		
		JLabel label_21 = new JLabel("Bill Amount");
		GridBagConstraints gbc_label_21 = new GridBagConstraints();
		gbc_label_21.anchor = GridBagConstraints.EAST;
		gbc_label_21.insets = new Insets(0, 0, 5, 5);
		gbc_label_21.gridx = 1;
		gbc_label_21.gridy = 8;
		panel.add(label_21, gbc_label_21);
		
		JLabel label_22 = new JLabel("Payment Completed");
		GridBagConstraints gbc_label_22 = new GridBagConstraints();
		gbc_label_22.anchor = GridBagConstraints.EAST;
		gbc_label_22.insets = new Insets(0, 0, 5, 5);
		gbc_label_22.gridx = 1;
		gbc_label_22.gridy = 9;
		panel.add(label_22, gbc_label_22);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 9;
		panel.add(comboBox, gbc_comboBox);
		
		JButton button = new JButton("New");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.HORIZONTAL;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 1;
		gbc_button.gridy = 11;
		panel.add(button, gbc_button);
		
		JButton button_14 = new JButton("Save");
		GridBagConstraints gbc_button_14 = new GridBagConstraints();
		gbc_button_14.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_14.insets = new Insets(0, 0, 5, 5);
		gbc_button_14.gridx = 2;
		gbc_button_14.gridy = 11;
		panel.add(button_14, gbc_button_14);
		
		JButton button_15 = new JButton("Delete");
		GridBagConstraints gbc_button_15 = new GridBagConstraints();
		gbc_button_15.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_15.insets = new Insets(0, 0, 5, 5);
		gbc_button_15.gridx = 3;
		gbc_button_15.gridy = 11;
		panel.add(button_15, gbc_button_15);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "User List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_8.setBounds(483, 0, 475, 365);
		pnlBillDetails_R.add(panel_8);
		
		JScrollPane scrollPane_3 = new JScrollPane((Component) null);
		scrollPane_3.setBounds(6, 73, 453, 286);
		panel_8.add(scrollPane_3);
		
		JLabel label_12 = new JLabel("First Name");
		label_12.setBounds(179, 26, 51, 14);
		panel_8.add(label_12);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(239, 23, 127, 20);
		panel_8.add(textField_7);
		
		JButton button_16 = new JButton("Search");
		button_16.setBounds(376, 22, 89, 23);
		panel_8.add(button_16);
		
		JLabel label_13 = new JLabel("  Note: Result will show similar first names apart from exact match.");
		label_13.setBounds(6, 49, 445, 14);
		panel_8.add(label_13);
		
		JPanel pnlDiagnosisDetails_R = new JPanel();
		pnlMainTabbed_R.addTab("Diagnosis Details", null, pnlDiagnosisDetails_R, null);
		pnlDiagnosisDetails_R.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "User Form", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(0, 0, 483, 365);
		pnlDiagnosisDetails_R.add(panel_4);
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
		pnlDiagnosisDetails_R.add(panel_5);
		
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
		
		JPanel pnlEventDetails_R = new JPanel();
		pnlMainTabbed_R.addTab("Event Details", null, pnlEventDetails_R, null);
		pnlEventDetails_R.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "User Form", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(0, 0, 483, 365);
		pnlEventDetails_R.add(panel_3);
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
		pnlEventDetails_R.add(panel_6);
		
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
		
		JPanel pnlBottom_R = new JPanel();
		pnlBottom_R.setLayout(null);
		pnlBottom_R.setBounds(5, 430, 963, 23);
		contentPane.add(pnlBottom_R);
		
		JLabel label_1 = new JLabel("Copyright @PatientCare 2019");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(0, 0, 268, 23);
		pnlBottom_R.add(label_1);
	}
}
