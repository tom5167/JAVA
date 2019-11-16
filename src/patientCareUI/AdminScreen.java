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
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import patientCareBusinessLogic.PatientLogic;
import patientCareConstants.CommonConstants;
import patientCarePOJO.Patient;

public class AdminScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3642295893091456420L;
	PatientLogic patientLogic = new PatientLogic();
	private JPanel contentPane;
	private JTable tblPatientList_APL;
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
	private JTextField txtCreatedBy_APF;
	private JTextField txtCreatedDate_APF;
	private JTextField txtModifiedBy_APF;
	private JTextField txtModifiedDate_APF;
	private JTable tblUserList_AUL;
	private JTextField txtUsername_AUF;
	private JTextField txtPassword_AUF;
	private JTextField txtRefId_AUF;
	private JTextField txtLastName_AUF;
	private JTextField txtFirstName_AUL;
	private JTextField txtFirstName_APL;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "serial", "unchecked", "rawtypes" })
	public AdminScreen() {
		setTitle("Patient Care");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 978, 483);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlTop_A = new JPanel();
		pnlTop_A.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlTop_A.setBounds(5, 5, 963, 30);
		contentPane.add(pnlTop_A);
		pnlTop_A.setLayout(null);
		
		JButton btnBack_AT = new JButton("Back");
		btnBack_AT.setBounds(10, 6, 100, 19);
		pnlTop_A.add(btnBack_AT);
		
		JButton btnLogout_AT = new JButton("Logout");
		btnLogout_AT.setBounds(853, 6, 100, 19);
		pnlTop_A.add(btnLogout_AT);
		
		JLabel lblTop_AT = new JLabel("Admin Control");
		lblTop_AT.setBounds(444, -2, 131, 31);
		pnlTop_A.add(lblTop_AT);
		lblTop_AT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JTabbedPane pnlMainTabbed_A = new JTabbedPane(JTabbedPane.TOP);
		pnlMainTabbed_A.setBounds(5, 37, 963, 393);
		contentPane.add(pnlMainTabbed_A);
		
		JPanel pnlUserDetails_A = new JPanel();
		pnlMainTabbed_A.addTab("User Details", null, pnlUserDetails_A, null);
		pnlUserDetails_A.setLayout(null);
		
		JPanel pnlUserForm_AU = new JPanel();
		pnlUserForm_AU.setBounds(0, 0, 483, 365);
		pnlUserDetails_A.add(pnlUserForm_AU);
		pnlUserForm_AU.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "User Form", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagLayout gbl_pnlUserForm_AU = new GridBagLayout();
		gbl_pnlUserForm_AU.columnWidths = new int[]{33, 105, 107, 115, 91, 0, 0};
		gbl_pnlUserForm_AU.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 20, 0, 0};
		gbl_pnlUserForm_AU.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlUserForm_AU.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlUserForm_AU.setLayout(gbl_pnlUserForm_AU);
		
		JLabel lblUsername_AUF = new JLabel("Username");
		GridBagConstraints gbc_lblUsername_AUF = new GridBagConstraints();
		gbc_lblUsername_AUF.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername_AUF.anchor = GridBagConstraints.EAST;
		gbc_lblUsername_AUF.gridx = 2;
		gbc_lblUsername_AUF.gridy = 1;
		pnlUserForm_AU.add(lblUsername_AUF, gbc_lblUsername_AUF);
		
		txtUsername_AUF = new JTextField();
		GridBagConstraints gbc_txtUsername_AUF = new GridBagConstraints();
		gbc_txtUsername_AUF.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsername_AUF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsername_AUF.gridx = 3;
		gbc_txtUsername_AUF.gridy = 1;
		pnlUserForm_AU.add(txtUsername_AUF, gbc_txtUsername_AUF);
		txtUsername_AUF.setColumns(10);
		
		JLabel lblPassword__AUF = new JLabel("Password");
		GridBagConstraints gbc_lblPassword__AUF = new GridBagConstraints();
		gbc_lblPassword__AUF.anchor = GridBagConstraints.EAST;
		gbc_lblPassword__AUF.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword__AUF.gridx = 2;
		gbc_lblPassword__AUF.gridy = 2;
		pnlUserForm_AU.add(lblPassword__AUF, gbc_lblPassword__AUF);
		
		txtPassword_AUF = new JTextField();
		GridBagConstraints gbc_txtPassword_AUF = new GridBagConstraints();
		gbc_txtPassword_AUF.insets = new Insets(0, 0, 5, 5);
		gbc_txtPassword_AUF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPassword_AUF.gridx = 3;
		gbc_txtPassword_AUF.gridy = 2;
		pnlUserForm_AU.add(txtPassword_AUF, gbc_txtPassword_AUF);
		txtPassword_AUF.setColumns(10);
		
		JLabel lblUserType_AUF = new JLabel("User Type");
		GridBagConstraints gbc_lblUserType_AUF = new GridBagConstraints();
		gbc_lblUserType_AUF.anchor = GridBagConstraints.EAST;
		gbc_lblUserType_AUF.insets = new Insets(0, 0, 5, 5);
		gbc_lblUserType_AUF.gridx = 2;
		gbc_lblUserType_AUF.gridy = 3;
		pnlUserForm_AU.add(lblUserType_AUF, gbc_lblUserType_AUF);
		
		JComboBox cmbUserType_AUF = new JComboBox();
		cmbUserType_AUF.setModel(new DefaultComboBoxModel(new String[] {"Please Select", "Admin", "Doctor", "Patient", "Receptionist"}));
		GridBagConstraints gbc_cmbUserType_AUF = new GridBagConstraints();
		gbc_cmbUserType_AUF.insets = new Insets(0, 0, 5, 5);
		gbc_cmbUserType_AUF.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbUserType_AUF.gridx = 3;
		gbc_cmbUserType_AUF.gridy = 3;
		pnlUserForm_AU.add(cmbUserType_AUF, gbc_cmbUserType_AUF);
		
		JLabel lblFirstName_AUF = new JLabel("First Name");
		GridBagConstraints gbc_lblFirstName_AUF = new GridBagConstraints();
		gbc_lblFirstName_AUF.anchor = GridBagConstraints.EAST;
		gbc_lblFirstName_AUF.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName_AUF.gridx = 2;
		gbc_lblFirstName_AUF.gridy = 4;
		pnlUserForm_AU.add(lblFirstName_AUF, gbc_lblFirstName_AUF);
		
		JComboBox cmbFirstName_AUF = new JComboBox();
		cmbFirstName_AUF.setModel(new DefaultComboBoxModel(new String[] {"Please Select"}));
		GridBagConstraints gbc_cmbFirstName_AUF = new GridBagConstraints();
		gbc_cmbFirstName_AUF.insets = new Insets(0, 0, 5, 5);
		gbc_cmbFirstName_AUF.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbFirstName_AUF.gridx = 3;
		gbc_cmbFirstName_AUF.gridy = 4;
		pnlUserForm_AU.add(cmbFirstName_AUF, gbc_cmbFirstName_AUF);
		
		JLabel lblLastName_AUF = new JLabel("Last Name");
		GridBagConstraints gbc_lblLastName_AUF = new GridBagConstraints();
		gbc_lblLastName_AUF.anchor = GridBagConstraints.EAST;
		gbc_lblLastName_AUF.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName_AUF.gridx = 2;
		gbc_lblLastName_AUF.gridy = 5;
		pnlUserForm_AU.add(lblLastName_AUF, gbc_lblLastName_AUF);
		
		txtLastName_AUF = new JTextField();
		txtLastName_AUF.setEditable(false);
		GridBagConstraints gbc_txtLastName_AUF = new GridBagConstraints();
		gbc_txtLastName_AUF.insets = new Insets(0, 0, 5, 5);
		gbc_txtLastName_AUF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLastName_AUF.gridx = 3;
		gbc_txtLastName_AUF.gridy = 5;
		pnlUserForm_AU.add(txtLastName_AUF, gbc_txtLastName_AUF);
		txtLastName_AUF.setColumns(10);
		
		JLabel lblRefernceId_AUF = new JLabel("Refernce Id");
		GridBagConstraints gbc_lblRefernceId_AUF = new GridBagConstraints();
		gbc_lblRefernceId_AUF.anchor = GridBagConstraints.EAST;
		gbc_lblRefernceId_AUF.insets = new Insets(0, 0, 5, 5);
		gbc_lblRefernceId_AUF.gridx = 2;
		gbc_lblRefernceId_AUF.gridy = 6;
		pnlUserForm_AU.add(lblRefernceId_AUF, gbc_lblRefernceId_AUF);
		
		txtRefId_AUF = new JTextField();
		txtRefId_AUF.setEditable(false);
		GridBagConstraints gbc_txtRefId_AUF = new GridBagConstraints();
		gbc_txtRefId_AUF.insets = new Insets(0, 0, 5, 5);
		gbc_txtRefId_AUF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRefId_AUF.gridx = 3;
		gbc_txtRefId_AUF.gridy = 6;
		pnlUserForm_AU.add(txtRefId_AUF, gbc_txtRefId_AUF);
		txtRefId_AUF.setColumns(10);
		
		JButton btnSave_AUF = new JButton("Save");
		GridBagConstraints gbc_btnSave_AUF = new GridBagConstraints();
		gbc_btnSave_AUF.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSave_AUF.insets = new Insets(0, 0, 0, 5);
		gbc_btnSave_AUF.gridx = 2;
		gbc_btnSave_AUF.gridy = 8;
		pnlUserForm_AU.add(btnSave_AUF, gbc_btnSave_AUF);
		
		JButton btnDelete_AUF = new JButton("Delete");
		GridBagConstraints gbc_btnDelete_AUF = new GridBagConstraints();
		gbc_btnDelete_AUF.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDelete_AUF.insets = new Insets(0, 0, 0, 5);
		gbc_btnDelete_AUF.gridx = 3;
		gbc_btnDelete_AUF.gridy = 8;
		pnlUserForm_AU.add(btnDelete_AUF, gbc_btnDelete_AUF);
		
		JPanel pnlUserList_AU = new JPanel();
		pnlUserList_AU.setBounds(483, 0, 475, 365);
		pnlUserList_AU.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "User List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlUserDetails_A.add(pnlUserList_AU);
		pnlUserList_AU.setLayout(null);
		
		tblUserList_AUL = new JTable();
		tblUserList_AUL.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"user_id", "username", "pwd", "refer_id", "user_type","firstName", "lastName", "createdBy", "createdDate", "modifiedBy", "modifiedDate"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		tblUserList_AUL.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollUserList_AUL = new JScrollPane(tblUserList_AUL);
		scrollUserList_AUL.setBounds(6, 74, 459, 285);
		pnlUserList_AU.add(scrollUserList_AUL);
		
		JLabel lblUserType_AUL = new JLabel("User Type");
		lblUserType_AUL.setBounds(10, 26, 49, 14);
		pnlUserList_AU.add(lblUserType_AUL);
		
		JComboBox cmbUserType_AUL = new JComboBox();
		cmbUserType_AUL.setModel(new DefaultComboBoxModel(new String[] {"Please Select", "Admin", "Doctor", "Patient", "Receptionist"}));
		cmbUserType_AUL.setBounds(69, 23, 100, 20);
		pnlUserList_AU.add(cmbUserType_AUL);
		
		JLabel lblFirstName_AUL = new JLabel("First Name");
		lblFirstName_AUL.setBounds(179, 26, 51, 14);
		pnlUserList_AU.add(lblFirstName_AUL);
		
		txtFirstName_AUL = new JTextField();
		txtFirstName_AUL.setColumns(10);
		txtFirstName_AUL.setBounds(239, 23, 127, 20);
		pnlUserList_AU.add(txtFirstName_AUL);
		
		JButton btnSearch_AUL = new JButton("Search");
		btnSearch_AUL.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});
		btnSearch_AUL.setBounds(376, 22, 89, 23);
		pnlUserList_AU.add(btnSearch_AUL);
		
		JLabel lblNote_AUL = new JLabel("  Note: Result will show similar first names aprt from exact match.");
		lblNote_AUL.setBounds(6, 49, 445, 14);
		pnlUserList_AU.add(lblNote_AUL);
		
		JPanel pnlPatientDetails_A = new JPanel();
		pnlMainTabbed_A.addTab("Patient Details", null, pnlPatientDetails_A, null);
		pnlPatientDetails_A.setLayout(null);
		
		JPanel pnlPatientForm_AP = new JPanel();
		pnlPatientForm_AP.setBounds(0, 0, 493, 365);
		pnlPatientDetails_A.add(pnlPatientForm_AP);
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
		
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel_APF = new JDatePanelImpl(model, p);
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
		
		JLabel lblCreatedBy_APF = new JLabel("Created By");
		GridBagConstraints gbc_lblCreatedBy_APF = new GridBagConstraints();
		gbc_lblCreatedBy_APF.anchor = GridBagConstraints.EAST;
		gbc_lblCreatedBy_APF.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreatedBy_APF.gridx = 3;
		gbc_lblCreatedBy_APF.gridy = 7;
		pnlPatientForm_AP.add(lblCreatedBy_APF, gbc_lblCreatedBy_APF);
		
		txtCreatedBy_APF = new JTextField();
		GridBagConstraints gbc_txtCreatedBy_APF = new GridBagConstraints();
		gbc_txtCreatedBy_APF.insets = new Insets(0, 0, 5, 5);
		gbc_txtCreatedBy_APF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCreatedBy_APF.gridx = 4;
		gbc_txtCreatedBy_APF.gridy = 7;
		pnlPatientForm_AP.add(txtCreatedBy_APF, gbc_txtCreatedBy_APF);
		txtCreatedBy_APF.setColumns(10);
		
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
		
		JLabel lblCreatedDate_APF = new JLabel("Created Date");
		GridBagConstraints gbc_lblCreatedDate_APF = new GridBagConstraints();
		gbc_lblCreatedDate_APF.anchor = GridBagConstraints.EAST;
		gbc_lblCreatedDate_APF.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreatedDate_APF.gridx = 3;
		gbc_lblCreatedDate_APF.gridy = 8;
		pnlPatientForm_AP.add(lblCreatedDate_APF, gbc_lblCreatedDate_APF);
		
		txtCreatedDate_APF = new JTextField();
		GridBagConstraints gbc_txtCreatedDate_APF = new GridBagConstraints();
		gbc_txtCreatedDate_APF.insets = new Insets(0, 0, 5, 5);
		gbc_txtCreatedDate_APF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCreatedDate_APF.gridx = 4;
		gbc_txtCreatedDate_APF.gridy = 8;
		pnlPatientForm_AP.add(txtCreatedDate_APF, gbc_txtCreatedDate_APF);
		txtCreatedDate_APF.setColumns(10);
		
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
		
		JLabel lblModifiedBy_APF = new JLabel("Modified By");
		GridBagConstraints gbc_lblModifiedBy_APF = new GridBagConstraints();
		gbc_lblModifiedBy_APF.anchor = GridBagConstraints.EAST;
		gbc_lblModifiedBy_APF.insets = new Insets(0, 0, 5, 5);
		gbc_lblModifiedBy_APF.gridx = 3;
		gbc_lblModifiedBy_APF.gridy = 9;
		pnlPatientForm_AP.add(lblModifiedBy_APF, gbc_lblModifiedBy_APF);
		
		txtModifiedBy_APF = new JTextField();
		GridBagConstraints gbc_txtModifiedBy_APF = new GridBagConstraints();
		gbc_txtModifiedBy_APF.insets = new Insets(0, 0, 5, 5);
		gbc_txtModifiedBy_APF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtModifiedBy_APF.gridx = 4;
		gbc_txtModifiedBy_APF.gridy = 9;
		pnlPatientForm_AP.add(txtModifiedBy_APF, gbc_txtModifiedBy_APF);
		txtModifiedBy_APF.setColumns(10);
		
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
		
		JLabel lblModifiedDate_APF = new JLabel("Modified Date");
		GridBagConstraints gbc_lblModifiedDate_APF = new GridBagConstraints();
		gbc_lblModifiedDate_APF.anchor = GridBagConstraints.EAST;
		gbc_lblModifiedDate_APF.insets = new Insets(0, 0, 5, 5);
		gbc_lblModifiedDate_APF.gridx = 3;
		gbc_lblModifiedDate_APF.gridy = 10;
		pnlPatientForm_AP.add(lblModifiedDate_APF, gbc_lblModifiedDate_APF);
		
		txtModifiedDate_APF = new JTextField();
		GridBagConstraints gbc_txtModifiedDate_APF = new GridBagConstraints();
		gbc_txtModifiedDate_APF.insets = new Insets(0, 0, 5, 5);
		gbc_txtModifiedDate_APF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtModifiedDate_APF.gridx = 4;
		gbc_txtModifiedDate_APF.gridy = 10;
		pnlPatientForm_AP.add(txtModifiedDate_APF, gbc_txtModifiedDate_APF);
		txtModifiedDate_APF.setColumns(10);
		
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
				patientDetails.setCreatedBy(txtCreatedBy_APF.getText());
				patientDetails.setCreatedDate(txtCreatedDate_APF.getText());
				patientDetails.setModifiedBy(txtModifiedBy_APF.getText());
				patientDetails.setModifiedDate(txtModifiedDate_APF.getText());
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
				txtCreatedBy_APF.setText(CommonConstants.EMPTY_STRING);
				txtCreatedDate_APF.setText(CommonConstants.EMPTY_STRING);
				txtModifiedBy_APF.setText(CommonConstants.EMPTY_STRING);
				txtModifiedDate_APF.setText(CommonConstants.EMPTY_STRING);
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
		pnlPatientDetails_A.add(pnlPatientList_AP);
		pnlPatientList_AP.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Patient List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlPatientList_AP.setLayout(null);
		
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
					txtCreatedBy_APF.setText(modelPatient.getValueAt(selectedRowIndex, 16).toString());
					txtCreatedDate_APF.setText(modelPatient.getValueAt(selectedRowIndex, 16).toString());
					txtModifiedBy_APF.setText(modelPatient.getValueAt(selectedRowIndex, 16).toString());
					txtModifiedDate_APF.setText(modelPatient.getValueAt(selectedRowIndex, 16).toString());
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
		scrollPatientList_APL.setBounds(6, 73, 453, 286);
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
			@SuppressWarnings("deprecation")
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
					tblPatientList_APL.setRowSelectionInterval(0, 0);
				}
			}
		});
		btnSearch_APL.setBounds(366, 19, 89, 23);
		pnlPatientList_AP.add(btnSearch_APL);
		
		JLabel lblNote_APL = new JLabel("  Note: Result will show similar first names apart from exact match.");
		lblNote_APL.setBounds(6, 48, 445, 14);
		pnlPatientList_AP.add(lblNote_APL);
		
		JPanel pnlBillDetails = new JPanel();
		pnlMainTabbed_A.addTab("Bill Details", null, pnlBillDetails, null);
		pnlBillDetails.setLayout(null);
		
		JPanel pnlInsuranceDetails = new JPanel();
		pnlInsuranceDetails.setLayout(null);
		pnlMainTabbed_A.addTab("Insurance Details", null, pnlInsuranceDetails, null);
		
		JPanel pnlRoomDetails = new JPanel();
		pnlRoomDetails.setLayout(null);
		pnlMainTabbed_A.addTab("Room Details", null, pnlRoomDetails, null);
		
		JPanel pnlStaffDetails = new JPanel();
		pnlStaffDetails.setLayout(null);
		pnlMainTabbed_A.addTab("Staff Details", null, pnlStaffDetails, null);
		
		JPanel pnlEventDetails = new JPanel();
		pnlEventDetails.setLayout(null);
		pnlMainTabbed_A.addTab("Event Details", null, pnlEventDetails, null);
		
		JPanel pnlBottom_A = new JPanel();
		pnlBottom_A.setLayout(null);
		pnlBottom_A.setBounds(5, 430, 963, 23);
		contentPane.add(pnlBottom_A);
		
		JLabel lblBottom_AB = new JLabel("Copyright @PatientCare 2019");
		lblBottom_AB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBottom_AB.setBounds(0, 0, 268, 23);
		pnlBottom_A.add(lblBottom_AB);
	}
}
