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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import PatientCareUtil.DateLabelFormatter;
import patientCareBusinessLogic.BillLogic;
import patientCareBusinessLogic.DiagnosisLogic;
import patientCareBusinessLogic.EventLogic;
import patientCareBusinessLogic.PatientLogic;
import patientCareBusinessLogic.StaffLogic;
import patientCareConstants.CommonConstants;
import patientCareLogger.PatientCareLogger;
import patientCarePOJO.Bill;
import patientCarePOJO.Diagnosis;
import patientCarePOJO.Event;
import patientCarePOJO.Patient;
import patientCarePOJO.Staff;

public class ReceptionistScreen extends JFrame {
	
	static Logger logger = PatientCareLogger.getLogger();

	/**
	 * 
	 */
	private static final long serialVersionUID = 400619205466386651L;
	PatientLogic patientLogic = new PatientLogic();
	EventLogic eventLogic = new EventLogic();
	DiagnosisLogic diagnosisLogic = new DiagnosisLogic();
	BillLogic billlogic = new BillLogic();
	StaffLogic staffLogic = new StaffLogic();
	private JPanel contentPane;
	private JTextField txtFirstname_RSB;
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
	private JTextField txtFirstName_APFR;
	private JTable tblPatientList_APL;
	private JTextField txtFirstName_APL;
	private JTable tblEventList_APL;
	private JTable tblDiagnosisList_APL;
	private JTextField txtInsuranceId_RSB;
	private JTextField txtPayername_RSB;
	private JTextField txtBillAmt_RSB;
	private JTable tblBilllist_RSP;
	

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "serial", "unchecked", "rawtypes" })
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
		
		JLabel lblUserId_APF = new JLabel("");
		GridBagConstraints gbc_txtUserId_AUF = new GridBagConstraints();
		gbc_txtUserId_AUF.insets = new Insets(0, 0, 5, 5);
		gbc_txtUserId_AUF.gridx = 2;
		gbc_txtUserId_AUF.gridy = 0;
		pnlPatientForm_AP.add(lblUserId_APF, gbc_txtUserId_AUF);
		
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
		
		JLabel lblBillid_RSB = new JLabel("");
		lblBillid_RSB.setEnabled(false);
		GridBagConstraints gbc_lblBillid_RSB = new GridBagConstraints();
		gbc_lblBillid_RSB.insets = new Insets(0, 0, 5, 5);
		gbc_lblBillid_RSB.gridx = 2;
		gbc_lblBillid_RSB.gridy = 0;
		panel.add(lblBillid_RSB, gbc_lblBillid_RSB);
		
		JLabel label_14 = new JLabel("Patient Id");
		GridBagConstraints gbc_label_14 = new GridBagConstraints();
		gbc_label_14.anchor = GridBagConstraints.EAST;
		gbc_label_14.insets = new Insets(0, 0, 5, 5);
		gbc_label_14.gridx = 1;
		gbc_label_14.gridy = 1;
		panel.add(label_14, gbc_label_14);
		
		JComboBox cmbPatientId_RSB = new JComboBox();
		cmbPatientId_RSB.setModel(new DefaultComboBoxModel(new String[] {"Please Select"}));
		GridBagConstraints gbc_cmbPatientId_RSB = new GridBagConstraints();
		gbc_cmbPatientId_RSB.insets = new Insets(0, 0, 5, 5);
		gbc_cmbPatientId_RSB.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbPatientId_RSB.gridx = 2;
		gbc_cmbPatientId_RSB.gridy = 1;
		panel.add(cmbPatientId_RSB, gbc_cmbPatientId_RSB);
		
		JLabel label_16 = new JLabel("Mode of Payment");
		GridBagConstraints gbc_label_16 = new GridBagConstraints();
		gbc_label_16.anchor = GridBagConstraints.EAST;
		gbc_label_16.insets = new Insets(0, 0, 5, 5);
		gbc_label_16.gridx = 1;
		gbc_label_16.gridy = 3;
		panel.add(label_16, gbc_label_16);
		
		JComboBox cmbmodeofpay_RSB = new JComboBox();
		cmbmodeofpay_RSB.setModel(new DefaultComboBoxModel(new String[] {"Please Select", "Cash", "Card"}));
		GridBagConstraints gbc_cmbmodeofpay_RSB = new GridBagConstraints();
		gbc_cmbmodeofpay_RSB.insets = new Insets(0, 0, 5, 5);
		gbc_cmbmodeofpay_RSB.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbmodeofpay_RSB.gridx = 2;
		gbc_cmbmodeofpay_RSB.gridy = 3;
		panel.add(cmbmodeofpay_RSB, gbc_cmbmodeofpay_RSB);
		
		JLabel label_17 = new JLabel("Payment Due Date");
		GridBagConstraints gbc_label_17 = new GridBagConstraints();
		gbc_label_17.anchor = GridBagConstraints.EAST;
		gbc_label_17.insets = new Insets(0, 0, 5, 5);
		gbc_label_17.gridx = 1;
		gbc_label_17.gridy = 4;
		panel.add(label_17, gbc_label_17);
		
		UtilDateModel dateModelpaydue_RSB = new UtilDateModel();
		Properties proppaydue_RSB = new Properties();
		proppaydue_RSB.put("text.today", "Today");
		proppaydue_RSB.put("text.month", "Month");
		proppaydue_RSB.put("text.year", "Year");
		JDatePanelImpl datePanelpaydue_RSB = new JDatePanelImpl(dateModelpaydue_RSB, proppaydue_RSB);
		DateLabelFormatter dateLabelFormatterpaydue_RSB = new DateLabelFormatter();
		JDatePickerImpl datePickerpaydue_RSB = new JDatePickerImpl(datePanelpaydue_RSB, dateLabelFormatterpaydue_RSB);
		
		GridBagConstraints gbc_datePicker_RSB = new GridBagConstraints();
		gbc_datePicker_RSB.insets = new Insets(0, 0, 5, 5);
		gbc_datePicker_RSB.fill = GridBagConstraints.HORIZONTAL;
		gbc_datePicker_RSB.gridx = 2;
		gbc_datePicker_RSB.gridy = 4;
		panel.add(datePickerpaydue_RSB, gbc_datePicker_RSB);
		
		JLabel label_19 = new JLabel("Insurance Number");
		GridBagConstraints gbc_label_19 = new GridBagConstraints();
		gbc_label_19.anchor = GridBagConstraints.EAST;
		gbc_label_19.insets = new Insets(0, 0, 5, 5);
		gbc_label_19.gridx = 1;
		gbc_label_19.gridy = 5;
		panel.add(label_19, gbc_label_19);
		
		txtInsuranceId_RSB = new JTextField();
		GridBagConstraints gbc_txtInsuranceId_RSB = new GridBagConstraints();
		gbc_txtInsuranceId_RSB.insets = new Insets(0, 0, 5, 5);
		gbc_txtInsuranceId_RSB.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInsuranceId_RSB.gridx = 2;
		gbc_txtInsuranceId_RSB.gridy = 5;
		panel.add(txtInsuranceId_RSB, gbc_txtInsuranceId_RSB);
		txtInsuranceId_RSB.setColumns(10);
		
		JLabel label_20 = new JLabel("Payer Name");
		GridBagConstraints gbc_label_20 = new GridBagConstraints();
		gbc_label_20.anchor = GridBagConstraints.EAST;
		gbc_label_20.insets = new Insets(0, 0, 5, 5);
		gbc_label_20.gridx = 1;
		gbc_label_20.gridy = 6;
		panel.add(label_20, gbc_label_20);
		
		txtPayername_RSB = new JTextField();
		GridBagConstraints gbc_txtPayername_RSB = new GridBagConstraints();
		gbc_txtPayername_RSB.insets = new Insets(0, 0, 5, 5);
		gbc_txtPayername_RSB.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPayername_RSB.gridx = 2;
		gbc_txtPayername_RSB.gridy = 6;
		panel.add(txtPayername_RSB, gbc_txtPayername_RSB);
		txtPayername_RSB.setColumns(10);
		
		JLabel label_21 = new JLabel("Bill Amount");
		GridBagConstraints gbc_label_21 = new GridBagConstraints();
		gbc_label_21.anchor = GridBagConstraints.EAST;
		gbc_label_21.insets = new Insets(0, 0, 5, 5);
		gbc_label_21.gridx = 1;
		gbc_label_21.gridy = 7;
		panel.add(label_21, gbc_label_21);
		
		txtBillAmt_RSB = new JTextField();
		GridBagConstraints gbc_txtBillAmt_RSB = new GridBagConstraints();
		gbc_txtBillAmt_RSB.insets = new Insets(0, 0, 5, 5);
		gbc_txtBillAmt_RSB.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBillAmt_RSB.gridx = 2;
		gbc_txtBillAmt_RSB.gridy = 7;
		panel.add(txtBillAmt_RSB, gbc_txtBillAmt_RSB);
		txtBillAmt_RSB.setColumns(10);
		
		JLabel label_22 = new JLabel("Payment Completed");
		GridBagConstraints gbc_label_22 = new GridBagConstraints();
		gbc_label_22.anchor = GridBagConstraints.EAST;
		gbc_label_22.insets = new Insets(0, 0, 5, 5);
		gbc_label_22.gridx = 1;
		gbc_label_22.gridy = 8;
		panel.add(label_22, gbc_label_22);
		
		JComboBox cmbpaymentstatus_RSB = new JComboBox();
		cmbpaymentstatus_RSB.setModel(new DefaultComboBoxModel(new String[] {"Please Select", "Pending", "Paid"}));
		GridBagConstraints gbc_cmbpaymentstatus_RSB = new GridBagConstraints();
		gbc_cmbpaymentstatus_RSB.insets = new Insets(0, 0, 5, 5);
		gbc_cmbpaymentstatus_RSB.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbpaymentstatus_RSB.gridx = 2;
		gbc_cmbpaymentstatus_RSB.gridy = 8;
		panel.add(cmbpaymentstatus_RSB, gbc_cmbpaymentstatus_RSB);
		
		JButton btnNew_RSP = new JButton("New");
		btnNew_RSP.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				lblBillid_RSB.setText(CommonConstants.EMPTY_STRING);
				cmbPatientId_RSB.setSelectedItem(CommonConstants.PLEASE_SELECT);
				cmbmodeofpay_RSB.setSelectedItem(CommonConstants.PLEASE_SELECT);
				datePickerpaydue_RSB.getJFormattedTextField().setText(CommonConstants.EMPTY_STRING);
				txtInsuranceId_RSB.setText(CommonConstants.EMPTY_STRING);
				txtPayername_RSB.setText(CommonConstants.EMPTY_STRING);
				txtBillAmt_RSB.setText(CommonConstants.EMPTY_STRING);
				cmbpaymentstatus_RSB.setSelectedItem(CommonConstants.PLEASE_SELECT);
			}
		});
		GridBagConstraints gbc_btnNew_RSP = new GridBagConstraints();
		gbc_btnNew_RSP.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNew_RSP.insets = new Insets(0, 0, 5, 5);
		gbc_btnNew_RSP.gridx = 1;
		gbc_btnNew_RSP.gridy = 11;
		panel.add(btnNew_RSP, gbc_btnNew_RSP);
		
		JButton btnSave_RSP = new JButton("Save");
		btnSave_RSP.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			Bill billdetails = new Bill();
			if(lblBillid_RSB.getText().equalsIgnoreCase("")) {
				billdetails.setBillId(0);
			} else {
				billdetails.setBillId(Integer.parseInt(lblBillid_RSB.getText()));
			}
			String patientObj = cmbPatientId_RSB.getSelectedItem().toString();
			billdetails.setPatientId(Integer.parseInt(patientObj.split("_")[0]));
			billdetails.setmodeofpay(cmbmodeofpay_RSB.getSelectedItem().toString());
			billdetails.setpaymentduedate(datePickerpaydue_RSB.getJFormattedTextField().getText());
			billdetails.setinsurancenumber(txtInsuranceId_RSB.getText());
			billdetails.setpayername(txtPayername_RSB.getText());
			billdetails.setbillamount(txtBillAmt_RSB.getText());
			billdetails.setpaymentstatus(cmbpaymentstatus_RSB.getSelectedItem().toString());
			boolean flag = billlogic.saveBillDetails(billdetails);
			if(flag) {
				lblBillid_RSB.setText(CommonConstants.EMPTY_STRING);
				cmbmodeofpay_RSB.setSelectedItem(CommonConstants.PLEASE_SELECT);
				cmbPatientId_RSB.setSelectedItem(CommonConstants.PLEASE_SELECT);
				datePickerpaydue_RSB.getJFormattedTextField().setText(CommonConstants.EMPTY_STRING);
				txtInsuranceId_RSB.setText(CommonConstants.EMPTY_STRING);
				txtPayername_RSB.setText(CommonConstants.EMPTY_STRING);
				txtBillAmt_RSB.setText(CommonConstants.EMPTY_STRING);
				cmbpaymentstatus_RSB.setSelectedItem(CommonConstants.PLEASE_SELECT);
				JOptionPane.showMessageDialog(null, "Saved successfully", "Success",
						JOptionPane.PLAIN_MESSAGE);
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Error occurred while saving", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			}
		});
		GridBagConstraints gbc_btnSave_RSP = new GridBagConstraints();
		gbc_btnSave_RSP.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSave_RSP.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave_RSP.gridx = 2;
		gbc_btnSave_RSP.gridy = 11;
		panel.add(btnSave_RSP, gbc_btnSave_RSP);
		
		JButton btnDelete_RSP = new JButton("Delete");
		btnDelete_RSP.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Bill billdetails = new Bill();
				if(lblBillid_RSB.getText().equalsIgnoreCase("")) {
					billdetails.setBillId(0);
				} else {
					billdetails.setBillId(Integer.parseInt(lblBillid_RSB.getText()));
				}
				boolean flag = billlogic.deleteBillDetails(billdetails);
				if(flag) {
					JOptionPane.showMessageDialog(null, "Deleted successfully", "Success",
							JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Error occurred while saving", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		GridBagConstraints gbc_btnDelete_RSP = new GridBagConstraints();
		gbc_btnDelete_RSP.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDelete_RSP.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete_RSP.gridx = 3;
		gbc_btnDelete_RSP.gridy = 11;
		panel.add(btnDelete_RSP, gbc_btnDelete_RSP);
		
		JPanel pnlbilllist_RSP = new JPanel();
		pnlbilllist_RSP.setLayout(null);
		pnlbilllist_RSP.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Bills List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlbilllist_RSP.setBounds(483, 0, 475, 365);
		pnlBillDetails_R.add(pnlbilllist_RSP);
		
		tblBilllist_RSP = new JTable();
		tblBilllist_RSP.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				DefaultTableModel modelBill = (DefaultTableModel) tblBilllist_RSP.getModel();
				int selectedRowIndex = tblBilllist_RSP.getSelectedRow();
				if(selectedRowIndex > -1) {
					lblBillid_RSB.setText(modelBill.getValueAt(selectedRowIndex, 0).toString());
					cmbPatientId_RSB.setSelectedItem(
							modelBill.getValueAt(selectedRowIndex, 1).toString()+"_"
							+modelBill.getValueAt(selectedRowIndex, 2).toString()+"_"
							+modelBill.getValueAt(selectedRowIndex, 3).toString());
					cmbmodeofpay_RSB.setSelectedItem(modelBill.getValueAt(selectedRowIndex, 4).toString());
					datePickerpaydue_RSB.getJFormattedTextField().setText(modelBill.getValueAt(selectedRowIndex, 5).toString());
					txtInsuranceId_RSB.setText(modelBill.getValueAt(selectedRowIndex, 7).toString());
					txtPayername_RSB.setText(modelBill.getValueAt(selectedRowIndex, 8).toString());
					txtBillAmt_RSB.setText(modelBill.getValueAt(selectedRowIndex, 9).toString());
					cmbpaymentstatus_RSB.setSelectedItem(modelBill.getValueAt(selectedRowIndex, 10).toString());
				}
			}
		});
		
		tblBilllist_RSP.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Bill ID","Patient ID", "First Name", "Last Name", "Mode Of Payment", "Due Date", "Billing Time", "Insurance Number", "Payer", "Amount", "Bill Status", "Created By", "Created Date", "Modified By", "Modified Date"
				}
			) {
				Class[] columnTypes = new Class[] {
					Integer.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				public boolean isCellEditable(int rowIndex, int mColIndex) {
					return false;
				}
			});
		
		tblBilllist_RSP.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollBilllist_RSP = new JScrollPane(tblBilllist_RSP);
		scrollBilllist_RSP.setBounds(6, 73, 453, 286);
		pnlbilllist_RSP.add(scrollBilllist_RSP);
		
		JLabel lblFirstName_RSB = new JLabel("First Name");
		lblFirstName_RSB.setBounds(178, 26, 52, 14);
		pnlbilllist_RSP.add(lblFirstName_RSB);
		
		txtFirstname_RSB = new JTextField();
		txtFirstname_RSB.setColumns(10);
		txtFirstname_RSB.setBounds(239, 23, 127, 20);
		pnlbilllist_RSP.add(txtFirstname_RSB);
		
		JButton btnSearch_RSP = new JButton("Search");
		btnSearch_RSP.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(txtFirstname_RSB.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Please enter the first name to search", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				DefaultTableModel modelBill = (DefaultTableModel) tblBilllist_RSP.getModel();
				List<Bill> alBillDetails = billlogic.getAlBillDetails(txtFirstname_RSB.getText());
				modelBill.setRowCount(0);
				if(alBillDetails.size() == 0) {
					JOptionPane.showMessageDialog(null, "No record found", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					for (int i=0;i<alBillDetails.size();i++) {
						Object[] row = new String[15];
						row[0] = alBillDetails.get(i).getBillId()+"";
						row[1] = alBillDetails.get(i).getPatientId()+"";
						row[2] = alBillDetails.get(i).getpFirstName();
						row[3] = alBillDetails.get(i).getpLastName();
						row[4] = alBillDetails.get(i).getmodeofpay();
						row[5] = alBillDetails.get(i).getpaymentduedate();
						row[6] = alBillDetails.get(i).getbillingtime();
						row[7] = alBillDetails.get(i).getinsurancenumber();
						row[8] = alBillDetails.get(i).getpayername();
						row[9] = alBillDetails.get(i).getbillamount();
						row[10] = alBillDetails.get(i).getpaymentstatus();
						row[11] = alBillDetails.get(i).getCreatedBy();
						row[12] = alBillDetails.get(i).getCreatedDate();
						row[13] = alBillDetails.get(i).getModifiedBy();
						row[14] = alBillDetails.get(i).getModifiedDate();
						modelBill.addRow(row);
					}
				}
			}
		});
		btnSearch_RSP.setBounds(376, 22, 89, 23);
		pnlbilllist_RSP.add(btnSearch_RSP);
		
		JLabel label_13 = new JLabel("  Note: Result will show similar first names apart from exact match.");
		label_13.setBounds(6, 49, 445, 14);
		pnlbilllist_RSP.add(label_13);
		
		JPanel pnlDiagnosisDetails_R = new JPanel();
		pnlMainTabbed_R.addTab("Diagnosis Details", null, pnlDiagnosisDetails_R, null);
		pnlDiagnosisDetails_R.setLayout(null);
		
		JPanel pnlDiagnosisDetails_RR = new JPanel();
		pnlDiagnosisDetails_RR.setLayout(null);
		pnlDiagnosisDetails_RR.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Diagnosis List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDiagnosisDetails_RR.setBounds(0, 0, 958, 365);
		pnlDiagnosisDetails_R.add(pnlDiagnosisDetails_RR);
		// Diagnosis List View
		
		tblDiagnosisList_APL = new JTable();
		tblDiagnosisList_APL.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Diagnosis Id", "Patient Id", "Patient First Name", "Patient Last Name", "Medication Name", "Medication Type", "Illness", "Dosage", "Created By", "Created Date", "Modified By", "Modified Date"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, Object.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		tblDiagnosisList_APL.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollDiagnosisList_DDL = new JScrollPane(tblDiagnosisList_APL);
		scrollDiagnosisList_DDL.setBounds(6, 73, 942, 286);
		pnlDiagnosisDetails_RR.add(scrollDiagnosisList_DDL);
		
		JLabel lblFirstName_DDL = new JLabel("First Name");
		lblFirstName_DDL.setBounds(10, 26, 51, 14);
		pnlDiagnosisDetails_RR.add(lblFirstName_DDL);
		
		txtFirstName_APFR = new JTextField();
		txtFirstName_APFR.setColumns(10);
		txtFirstName_APFR.setBounds(70, 23, 127, 20);
		pnlDiagnosisDetails_RR.add(txtFirstName_APFR);
		
		JButton btnSearch_DDL = new JButton("Search");
		btnSearch_DDL.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(txtFirstName_APFR.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Please enter the first name to search", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				DefaultTableModel modelDiagnosis = (DefaultTableModel) tblDiagnosisList_APL.getModel();
				List<Diagnosis> alDiagnosisDetails = diagnosisLogic.getAlDiagnosisDetails(txtFirstName_APFR.getText());
				modelDiagnosis.setRowCount(0);
				if(alDiagnosisDetails.size() == 0) {
					JOptionPane.showMessageDialog(null, "No record found", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					for (int i=0;i<alDiagnosisDetails.size();i++) {
						Object[] row = new String[12];
						row[0] = alDiagnosisDetails.get(i).getDiagnosisId()+"";
						row[1] = alDiagnosisDetails.get(i).getPatientId()+"";
						row[2] = alDiagnosisDetails.get(i).getpFirstName();
						row[3] = alDiagnosisDetails.get(i).getpLastName();
						row[4] = alDiagnosisDetails.get(i).getMedicationName();
						row[5] = alDiagnosisDetails.get(i).getMedicationType();
						row[6] = alDiagnosisDetails.get(i).getIllness();
						row[7] = alDiagnosisDetails.get(i).getDosage();
						row[8] = alDiagnosisDetails.get(i).getCreatedBy();
						row[9] = alDiagnosisDetails.get(i).getCreatedDate();
						row[10] = alDiagnosisDetails.get(i).getModifiedBy();
						row[11] = alDiagnosisDetails.get(i).getModifiedDate();
						modelDiagnosis.addRow(row);
					}
				}
			}
		});
		btnSearch_DDL.setBounds(207, 22, 89, 23);
		pnlDiagnosisDetails_RR.add(btnSearch_DDL);
		
		JLabel lblNote_DDL = new JLabel("  Note: Result will show similar first names apart from exact match.");
		lblNote_DDL.setBounds(6, 49, 445, 14);
		pnlDiagnosisDetails_RR.add(lblNote_DDL);
		
		// End of DLV
		JPanel pnlEventDetails_R = new JPanel();
		pnlMainTabbed_R.addTab("Event Details", null, pnlEventDetails_R, null);
		pnlEventDetails_R.setLayout(null);

		// Event Tab
		JPanel pnlEventForm_AE = new JPanel();
		pnlEventForm_AE.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Event Form", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlEventForm_AE.setBounds(0, 0, 483, 365);
		pnlEventDetails_R.add(pnlEventForm_AE);
		GridBagLayout gbl_pnlEventForm_AE = new GridBagLayout();
		gbl_pnlEventForm_AE.columnWidths = new int[]{33, 107, 155, 91, 0, 0};
		gbl_pnlEventForm_AE.rowHeights = new int[]{20, 0, 0, 0, 0, 0, 20, 0, 20, 0, 0};
		gbl_pnlEventForm_AE.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlEventForm_AE.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlEventForm_AE.setLayout(gbl_pnlEventForm_AE);
		
		JLabel lblEventId_AEF = new JLabel("");
		lblEventId_AEF.setEnabled(false);
		GridBagConstraints gbc_lblEventId_AEF = new GridBagConstraints();
		gbc_lblEventId_AEF.insets = new Insets(0, 0, 5, 5);
		gbc_lblEventId_AEF.gridx = 2;
		gbc_lblEventId_AEF.gridy = 0;
		pnlEventForm_AE.add(lblEventId_AEF, gbc_lblEventId_AEF);
		
		JLabel lblPatientId_AEF = new JLabel("Patient Id");
		GridBagConstraints gbc_lblPatientId_AEF = new GridBagConstraints();
		gbc_lblPatientId_AEF.anchor = GridBagConstraints.EAST;
		gbc_lblPatientId_AEF.insets = new Insets(0, 0, 5, 5);
		gbc_lblPatientId_AEF.gridx = 1;
		gbc_lblPatientId_AEF.gridy = 1;
		pnlEventForm_AE.add(lblPatientId_AEF, gbc_lblPatientId_AEF);
		
		JComboBox cmbPatientId_AEF = new JComboBox();
		cmbPatientId_AEF.setModel(new DefaultComboBoxModel(new String[] {"Please Select"}));
		GridBagConstraints gbc_cmbPatientId_AEF = new GridBagConstraints();
		gbc_cmbPatientId_AEF.insets = new Insets(0, 0, 5, 5);
		gbc_cmbPatientId_AEF.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbPatientId_AEF.gridx = 2;
		gbc_cmbPatientId_AEF.gridy = 1;
		pnlEventForm_AE.add(cmbPatientId_AEF, gbc_cmbPatientId_AEF);
		
		JLabel lblDoctorId_AEF = new JLabel("Doctor Id");
		GridBagConstraints gbc_lblDoctorId_AEF = new GridBagConstraints();
		gbc_lblDoctorId_AEF.anchor = GridBagConstraints.EAST;
		gbc_lblDoctorId_AEF.insets = new Insets(0, 0, 5, 5);
		gbc_lblDoctorId_AEF.gridx = 1;
		gbc_lblDoctorId_AEF.gridy = 2;
		pnlEventForm_AE.add(lblDoctorId_AEF, gbc_lblDoctorId_AEF);
		
		JComboBox cmbDoctorId_AEF = new JComboBox();
		cmbDoctorId_AEF.setModel(new DefaultComboBoxModel(new String[] {"Please Select"}));
		GridBagConstraints gbc_cmbDoctorId_AEF = new GridBagConstraints();
		gbc_cmbDoctorId_AEF.insets = new Insets(0, 0, 5, 5);
		gbc_cmbDoctorId_AEF.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbDoctorId_AEF.gridx = 2;
		gbc_cmbDoctorId_AEF.gridy = 2;
		pnlEventForm_AE.add(cmbDoctorId_AEF, gbc_cmbDoctorId_AEF);
		
		JLabel lblEventType_AEF = new JLabel("Event Type");
		GridBagConstraints gbc_lblEventType_AEF = new GridBagConstraints();
		gbc_lblEventType_AEF.anchor = GridBagConstraints.EAST;
		gbc_lblEventType_AEF.insets = new Insets(0, 0, 5, 5);
		gbc_lblEventType_AEF.gridx = 1;
		gbc_lblEventType_AEF.gridy = 3;
		pnlEventForm_AE.add(lblEventType_AEF, gbc_lblEventType_AEF);
		
		JComboBox cmbEventType_AEF = new JComboBox();
		cmbEventType_AEF.setModel(new DefaultComboBoxModel(new String[] {"Please Select", "Appointment", "Operation"}));
		GridBagConstraints gbc_cmbEventType_AEF = new GridBagConstraints();
		gbc_cmbEventType_AEF.insets = new Insets(0, 0, 5, 5);
		gbc_cmbEventType_AEF.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbEventType_AEF.gridx = 2;
		gbc_cmbEventType_AEF.gridy = 3;
		pnlEventForm_AE.add(cmbEventType_AEF, gbc_cmbEventType_AEF);
		
		JLabel lblEventDate_AEF = new JLabel("Event Date");
		GridBagConstraints gbc_lblEventDate_AEF = new GridBagConstraints();
		gbc_lblEventDate_AEF.anchor = GridBagConstraints.EAST;
		gbc_lblEventDate_AEF.insets = new Insets(0, 0, 5, 5);
		gbc_lblEventDate_AEF.gridx = 1;
		gbc_lblEventDate_AEF.gridy = 4;
		pnlEventForm_AE.add(lblEventDate_AEF, gbc_lblEventDate_AEF);
		
		UtilDateModel dateModel_AEF = new UtilDateModel();
		Properties prop_AEF = new Properties();
		prop_AEF.put("text.today", "Today");
		prop_AEF.put("text.month", "Month");
		prop_AEF.put("text.year", "Year");
		JDatePanelImpl datePanel_AEF = new JDatePanelImpl(dateModel_AEF, prop_AEF);
		DateLabelFormatter dateLabelFormatter_AEF = new DateLabelFormatter();
		JDatePickerImpl datePicker_AEF = new JDatePickerImpl(datePanel_AEF, dateLabelFormatter_AEF);
		
		GridBagConstraints gbc_datePicker_AEF = new GridBagConstraints();
		gbc_datePicker_AEF.insets = new Insets(0, 0, 5, 5);
		gbc_datePicker_AEF.fill = GridBagConstraints.HORIZONTAL;
		gbc_datePicker_AEF.gridx = 2;
		gbc_datePicker_AEF.gridy = 4;
		pnlEventForm_AE.add(datePicker_AEF, gbc_datePicker_AEF);
		
		JLabel lblEventTime_AEF = new JLabel("Event Time");
		GridBagConstraints gbc_lblEventTime_AEF = new GridBagConstraints();
		gbc_lblEventTime_AEF.anchor = GridBagConstraints.EAST;
		gbc_lblEventTime_AEF.insets = new Insets(0, 0, 5, 5);
		gbc_lblEventTime_AEF.gridx = 1;
		gbc_lblEventTime_AEF.gridy = 5;
		pnlEventForm_AE.add(lblEventTime_AEF, gbc_lblEventTime_AEF);
		
		JComboBox cmbEventTime_AEF = new JComboBox();
		cmbEventTime_AEF.setModel(new DefaultComboBoxModel(new String[] {"Please Select", "Early Morning (4-8)", "Morning (8-12)", "Afternoon (12-16)", "Evening (16-20)", "Night (20-24)", "Mid Night (24-4)"}));
		GridBagConstraints gbc_cmbEventTime_AEF = new GridBagConstraints();
		gbc_cmbEventTime_AEF.insets = new Insets(0, 0, 5, 5);
		gbc_cmbEventTime_AEF.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbEventTime_AEF.gridx = 2;
		gbc_cmbEventTime_AEF.gridy = 5;
		pnlEventForm_AE.add(cmbEventTime_AEF, gbc_cmbEventTime_AEF);
		
		JButton btnNew_AEF = new JButton("New");
		btnNew_AEF.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblUserId_APF.setText(CommonConstants.EMPTY_STRING);
				cmbPatientId_AEF.setSelectedItem(CommonConstants.PLEASE_SELECT);
				cmbDoctorId_AEF.setSelectedItem(CommonConstants.PLEASE_SELECT);
				cmbEventType_AEF.setSelectedItem(CommonConstants.PLEASE_SELECT);
				datePicker_AEF.getJFormattedTextField().setText(CommonConstants.EMPTY_STRING);
				cmbEventTime_AEF.setSelectedItem(CommonConstants.PLEASE_SELECT);
			}
		});
		GridBagConstraints gbc_btnNew_AEF = new GridBagConstraints();
		gbc_btnNew_AEF.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNew_AEF.insets = new Insets(0, 0, 5, 5);
		gbc_btnNew_AEF.gridx = 1;
		gbc_btnNew_AEF.gridy = 7;
		pnlEventForm_AE.add(btnNew_AEF, gbc_btnNew_AEF);
		
		JButton btnSave_AEF = new JButton("Save");
		btnSave_AEF.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Event eventDetails = new Event();
				if(lblEventId_AEF.getText().equalsIgnoreCase("")) {
					eventDetails.setEventId(0);
				} else {
					eventDetails.setEventId(Integer.parseInt(lblEventId_AEF.getText()));
				}
				String patientObj = cmbPatientId_AEF.getSelectedItem().toString();
				eventDetails.setPatientId(Integer.parseInt(patientObj.split("_")[0]));
				String doctorObj = cmbDoctorId_AEF.getSelectedItem().toString();
				eventDetails.setDoctorId(Integer.parseInt(doctorObj.split("_")[0]));
				eventDetails.setEventType(cmbEventType_AEF.getSelectedItem().toString());
				eventDetails.setEventDate(datePicker_AEF.getJFormattedTextField().getText());
				eventDetails.setEventTime(cmbEventTime_AEF.getSelectedItem().toString());
				boolean flag = eventLogic.saveEventDetails(eventDetails);
				if(flag) {
					lblUserId_APF.setText(CommonConstants.EMPTY_STRING);
					cmbPatientId_AEF.setSelectedItem(CommonConstants.PLEASE_SELECT);
					cmbDoctorId_AEF.setSelectedItem(CommonConstants.PLEASE_SELECT);
					cmbEventType_AEF.setSelectedItem(CommonConstants.PLEASE_SELECT);
					datePicker_AEF.getJFormattedTextField().setText(CommonConstants.EMPTY_STRING);
					cmbEventTime_AEF.setSelectedItem(CommonConstants.PLEASE_SELECT);
					JOptionPane.showMessageDialog(null, "Saved successfully", "Success",
							JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Error occurred while saving", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_btnSave_AEF = new GridBagConstraints();
		gbc_btnSave_AEF.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSave_AEF.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave_AEF.gridx = 2;
		gbc_btnSave_AEF.gridy = 7;
		pnlEventForm_AE.add(btnSave_AEF, gbc_btnSave_AEF);
		
		JButton btnDelete__AEF = new JButton("Delete");
		btnDelete__AEF.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Event eventDetails = new Event();
				if(lblEventId_AEF.getText().equalsIgnoreCase("")) {
					eventDetails.setEventId(0);
				} else {
					eventDetails.setEventId(Integer.parseInt(lblEventId_AEF.getText()));
				}
				boolean flag = eventLogic.deleteEventDetails(eventDetails);
				if(flag) {
					JOptionPane.showMessageDialog(null, "Deleted successfully", "Success",
							JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Error occurred while saving", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_btnDelete__AEF = new GridBagConstraints();
		gbc_btnDelete__AEF.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDelete__AEF.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete__AEF.gridx = 3;
		gbc_btnDelete__AEF.gridy = 7;
		pnlEventForm_AE.add(btnDelete__AEF, gbc_btnDelete__AEF);
		
		JPanel pnlEventList_AE = new JPanel();
		pnlEventList_AE.setLayout(null);
		pnlEventList_AE.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Event List", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlEventList_AE.setBounds(483, 0, 475, 365);
		pnlEventDetails_R.add(pnlEventList_AE);
		
		tblEventList_APL = new JTable();
		tblEventList_APL.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				DefaultTableModel modelEvent = (DefaultTableModel) tblEventList_APL.getModel();
				int selectedRowIndex = tblEventList_APL.getSelectedRow();
				if(selectedRowIndex > -1) {
					lblEventId_AEF.setText(modelEvent.getValueAt(selectedRowIndex, 0).toString());
					cmbPatientId_AEF.setSelectedItem(
							modelEvent.getValueAt(selectedRowIndex, 1).toString()+"_"
							+modelEvent.getValueAt(selectedRowIndex, 2).toString()+"_"
							+modelEvent.getValueAt(selectedRowIndex, 3).toString());
					cmbDoctorId_AEF.setSelectedItem(
							modelEvent.getValueAt(selectedRowIndex, 4).toString()+"_"
							+modelEvent.getValueAt(selectedRowIndex, 5).toString()+"_"
							+modelEvent.getValueAt(selectedRowIndex, 6).toString());
					cmbEventType_AEF.setSelectedItem(modelEvent.getValueAt(selectedRowIndex, 7).toString());
					datePicker_AEF.getJFormattedTextField().setText(modelEvent.getValueAt(selectedRowIndex, 8).toString());
					cmbEventTime_AEF.setSelectedItem(modelEvent.getValueAt(selectedRowIndex, 9).toString());
				}
			}
		});
		tblEventList_APL.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Event Id", "Patient Id", "Patient First Name", "Patient Last Name", "Doctor Id", "Doctor First Name", "Doctor Last Name", "Event Type", "Event Date", "Event Time", "Created By", "Created Date", "Modified By", "Modified Date" 
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class,	String.class, String.class,String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tblEventList_APL.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollEventList_AEL = new JScrollPane(tblEventList_APL);
		scrollEventList_AEL.setBounds(6, 73, 459, 286);
		pnlEventList_AE.add(scrollEventList_AEL);
		
		JLabel lblEventDate = new JLabel("Event Date");
		lblEventDate.setBounds(192, 22, 71, 23);
		pnlEventList_AE.add(lblEventDate);
		
		UtilDateModel dateModel_AEL = new UtilDateModel();
		Properties prop_AEL = new Properties();
		prop_AEL.put("text.today", "Today");
		prop_AEL.put("text.month", "Month");
		prop_AEL.put("text.year", "Year");
		JDatePanelImpl datePanel_AEL = new JDatePanelImpl(dateModel_AEL, prop_AEL);
		DateLabelFormatter dateLabelFormatter_AEL = new DateLabelFormatter();
		JDatePickerImpl datePicker_AEL = new JDatePickerImpl(datePanel_AEL, dateLabelFormatter_AEL);
		datePicker_AEL.setBounds(249, 22, 117, 23);
		pnlEventList_AE.add(datePicker_AEL);
		
		JLabel lblEventType_AEL = new JLabel("Event Type");
		lblEventType_AEL.setBounds(10, 26, 55, 14);
		pnlEventList_AE.add(lblEventType_AEL);
		
		JComboBox cmbEventType_AEL = new JComboBox();
		cmbEventType_AEL.setModel(new DefaultComboBoxModel(new String[] {"Please Select", "Appointment", "Operation"}));
		cmbEventType_AEL.setBounds(75, 23, 111, 20);
		pnlEventList_AE.add(cmbEventType_AEL);
		
		JButton btnSearch_AEL = new JButton("Search");
		btnSearch_AEL.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(cmbEventType_AEL.getSelectedItem().toString().equalsIgnoreCase("Please Select")) {
					JOptionPane.showMessageDialog(null, "Please select the event type to search", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(datePicker_AEL.getJFormattedTextField().getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Please enter the event date to search", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				DefaultTableModel modelEvent = (DefaultTableModel) tblEventList_APL.getModel();
				List<Event> alEventDetails = eventLogic.getAlEventDetails(cmbEventType_AEL.getSelectedItem().toString(),
						datePicker_AEL.getJFormattedTextField().getText());
				modelEvent.setRowCount(0);
				if(alEventDetails.size() == 0) {
					JOptionPane.showMessageDialog(null, "No record found", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					for (int i=0;i<alEventDetails.size();i++) {
						Object[] row = new String[14];
						row[0] = alEventDetails.get(i).getEventId()+"";
						row[1] = alEventDetails.get(i).getPatientId()+"";
						row[2] = alEventDetails.get(i).getpFirstName();
						row[3] = alEventDetails.get(i).getpLastName();
						row[4] = alEventDetails.get(i).getDoctorId()+"";
						row[5] = alEventDetails.get(i).getdFirstName();
						row[6] = alEventDetails.get(i).getdLastName();
						row[7] = alEventDetails.get(i).getEventType();
						row[8] = alEventDetails.get(i).getEventDate();
						row[9] = alEventDetails.get(i).getEventTime();
						row[10] = alEventDetails.get(i).getCreatedBy();
						row[11] = alEventDetails.get(i).getCreatedDate();
						row[12] = alEventDetails.get(i).getModifiedBy();
						row[13] = alEventDetails.get(i).getModifiedDate();
						modelEvent.addRow(row);
					}
				}
			}
		});
		btnSearch_AEL.setBounds(376, 22, 89, 23);
		pnlEventList_AE.add(btnSearch_AEL);
		
		JLabel lblNote_AEL = new JLabel("  Note: Result will show similar first names apart from exact match.");
		lblNote_AEL.setBounds(6, 49, 445, 14);
		pnlEventList_AE.add(lblNote_AEL);
		
		//Tab Change Listener
				pnlMainTabbed_R.addChangeListener(new ChangeListener() {
			        public void stateChanged(ChangeEvent e) {
			        	logger.info("pnlMainTabbed_R Number "+pnlMainTabbed_R.getSelectedIndex());
			        	if(pnlMainTabbed_R.getSelectedIndex() == 3) {
			            	List<Patient> patientDetails = new ArrayList<Patient>();
							patientDetails = patientLogic.getAlPatientDetails("");
							if(patientDetails.size() == 0) {
								cmbPatientId_AEF.removeAllItems();
							} else {
								cmbPatientId_AEF.removeAllItems();
								cmbPatientId_AEF.addItem(CommonConstants.PLEASE_SELECT);
								for(int i=0;i<patientDetails.size();i++) {
									cmbPatientId_AEF.addItem(patientDetails.get(i).getPatientId()
											+ "_" + patientDetails.get(i).getFirstName()
											+ "_" + patientDetails.get(i).getLastName());
								}
							}
			            	List<Staff> staffDetails = new ArrayList<Staff>();
			            	staffDetails = staffLogic.getAlStaffDetails("");
							if(staffDetails.size() == 0) {
								cmbDoctorId_AEF.removeAllItems();
							} else {
								cmbDoctorId_AEF.removeAllItems();
								cmbDoctorId_AEF.addItem(CommonConstants.PLEASE_SELECT);
								for(int i=0;i<staffDetails.size();i++) {
									if(staffDetails.get(i).getStaffType().equalsIgnoreCase(CommonConstants.DOCTOR)){
										cmbDoctorId_AEF.addItem(staffDetails.get(i).getStaffId()
												+ "_" + staffDetails.get(i).getFirstName()
												+ "_" + staffDetails.get(i).getLastName());
									}
								}
							}
			            }
			        	if(pnlMainTabbed_R.getSelectedIndex() == 1) {
			            	List<Patient> patientDetails1 = new ArrayList<Patient>();
							patientDetails1 = patientLogic.getAlPatientDetails("");
							if(patientDetails1.size() == 0) {
								cmbPatientId_RSB.removeAllItems();
							} else {
								cmbPatientId_RSB.removeAllItems();
								cmbPatientId_RSB.addItem(CommonConstants.PLEASE_SELECT);
								for(int i=0;i<patientDetails1.size();i++) {
									cmbPatientId_RSB.addItem(patientDetails1.get(i).getPatientId()
											+ "_" + patientDetails1.get(i).getFirstName()
											+ "_" + patientDetails1.get(i).getLastName());
								}
							}	
			            }
			        }
			    });
		
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
