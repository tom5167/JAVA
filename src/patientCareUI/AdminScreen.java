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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import patientCareBusinessLogic.PatientLogic;
import patientCareBusinessLogic.UserLogic;
import patientCareConstants.CommonConstants;
import patientCarePOJO.Patient;
import patientCarePOJO.User;
import java.awt.Component;

public class AdminScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3642295893091456420L;
	UserLogic userLogic = new UserLogic();
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
	private JTextField txtUserName_AUF;
	private JTextField txtPassword_AUF;
	private JTextField txtFirstName_AUL;
	private JTextField txtFirstName_APL;
	private JTable tblUserList_AUL;
	private JTextField txtTotalBeds_ARF;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField txtOccupiedBeds_ARF;

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
		gbl_pnlUserForm_AU.columnWidths = new int[]{33, 107, 155, 91, 0, 0};
		gbl_pnlUserForm_AU.rowHeights = new int[]{20, 0, 0, 0, 0, 0, 0, 20, 0, 0};
		gbl_pnlUserForm_AU.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlUserForm_AU.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlUserForm_AU.setLayout(gbl_pnlUserForm_AU);
		
		JLabel lblUserId_AUF = new JLabel("");
		GridBagConstraints gbc_txtUserId_AUF = new GridBagConstraints();
		gbc_txtUserId_AUF.insets = new Insets(0, 0, 5, 5);
		gbc_txtUserId_AUF.gridx = 2;
		gbc_txtUserId_AUF.gridy = 0;
		pnlUserForm_AU.add(lblUserId_AUF, gbc_txtUserId_AUF);
		
		JLabel lblUsername_AUF = new JLabel("Username");
		GridBagConstraints gbc_lblUsername_AUF = new GridBagConstraints();
		gbc_lblUsername_AUF.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername_AUF.anchor = GridBagConstraints.EAST;
		gbc_lblUsername_AUF.gridx = 1;
		gbc_lblUsername_AUF.gridy = 1;
		pnlUserForm_AU.add(lblUsername_AUF, gbc_lblUsername_AUF);
		
		txtUserName_AUF = new JTextField();
		GridBagConstraints gbc_txtUserName_AUF = new GridBagConstraints();
		gbc_txtUserName_AUF.insets = new Insets(0, 0, 5, 5);
		gbc_txtUserName_AUF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUserName_AUF.gridx = 2;
		gbc_txtUserName_AUF.gridy = 1;
		pnlUserForm_AU.add(txtUserName_AUF, gbc_txtUserName_AUF);
		txtUserName_AUF.setColumns(10);
		
		JLabel lblPassword__AUF = new JLabel("Password");
		GridBagConstraints gbc_lblPassword__AUF = new GridBagConstraints();
		gbc_lblPassword__AUF.anchor = GridBagConstraints.EAST;
		gbc_lblPassword__AUF.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword__AUF.gridx = 1;
		gbc_lblPassword__AUF.gridy = 2;
		pnlUserForm_AU.add(lblPassword__AUF, gbc_lblPassword__AUF);
		
		txtPassword_AUF = new JTextField();
		GridBagConstraints gbc_txtPassword_AUF = new GridBagConstraints();
		gbc_txtPassword_AUF.insets = new Insets(0, 0, 5, 5);
		gbc_txtPassword_AUF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPassword_AUF.gridx = 2;
		gbc_txtPassword_AUF.gridy = 2;
		pnlUserForm_AU.add(txtPassword_AUF, gbc_txtPassword_AUF);
		txtPassword_AUF.setColumns(10);
		
		JLabel lblUserType_AUF = new JLabel("User Type");
		GridBagConstraints gbc_lblUserType_AUF = new GridBagConstraints();
		gbc_lblUserType_AUF.anchor = GridBagConstraints.EAST;
		gbc_lblUserType_AUF.insets = new Insets(0, 0, 5, 5);
		gbc_lblUserType_AUF.gridx = 1;
		gbc_lblUserType_AUF.gridy = 3;
		pnlUserForm_AU.add(lblUserType_AUF, gbc_lblUserType_AUF);
		
		JComboBox cmbFirstName_AUF = new JComboBox();
		JComboBox cmbUserType_AUF = new JComboBox();
		cmbUserType_AUF.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String userType = cmbUserType_AUF.getSelectedItem().toString();
				List<User> userDetails = new ArrayList<User>();
				userDetails = userLogic.getUserList(userType);
				if(userDetails.size() == 0) {
					cmbFirstName_AUF.removeAllItems();
					JOptionPane.showMessageDialog(null, "No records found.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				cmbFirstName_AUF.removeAllItems();
				cmbFirstName_AUF.addItem(CommonConstants.PLEASE_SELECT);
				for(int i=0;i<userDetails.size();i++) {
					cmbFirstName_AUF.addItem(userDetails.get(i).getReferId()
							+"_"+userDetails.get(i).getFirstName()
							+"_"+userDetails.get(i).getLastName()
							+"_"+userDetails.get(i).getUserType());
				}
			}
		});
		cmbUserType_AUF.setModel(new DefaultComboBoxModel(new String[] {"Please Select", "Admin", "Doctor", "Patient", "Receptionist"}));
		GridBagConstraints gbc_cmbUserType_AUF = new GridBagConstraints();
		gbc_cmbUserType_AUF.insets = new Insets(0, 0, 5, 5);
		gbc_cmbUserType_AUF.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbUserType_AUF.gridx = 2;
		gbc_cmbUserType_AUF.gridy = 3;
		pnlUserForm_AU.add(cmbUserType_AUF, gbc_cmbUserType_AUF);
		
		JLabel lblFirstName_AUF = new JLabel("First Name");
		GridBagConstraints gbc_lblFirstName_AUF = new GridBagConstraints();
		gbc_lblFirstName_AUF.anchor = GridBagConstraints.EAST;
		gbc_lblFirstName_AUF.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName_AUF.gridx = 1;
		gbc_lblFirstName_AUF.gridy = 4;
		pnlUserForm_AU.add(lblFirstName_AUF, gbc_lblFirstName_AUF);
		
		cmbFirstName_AUF.setModel(new DefaultComboBoxModel(new String[] {"Please Select"}));
		GridBagConstraints gbc_cmbFirstName_AUF = new GridBagConstraints();
		gbc_cmbFirstName_AUF.insets = new Insets(0, 0, 5, 5);
		gbc_cmbFirstName_AUF.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbFirstName_AUF.gridx = 2;
		gbc_cmbFirstName_AUF.gridy = 4;
		pnlUserForm_AU.add(cmbFirstName_AUF, gbc_cmbFirstName_AUF);
		
		JButton btnSave_AUF = new JButton("Save");
		btnSave_AUF.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				User userDetails = new User();
				if(lblUserId_AUF.getText().equalsIgnoreCase("")) {
					userDetails.setUserId(0);
				} else {
					userDetails.setUserId(Integer.parseInt(lblUserId_AUF.getText()));
				}
				userDetails.setUserName(txtUserName_AUF.getText());
				userDetails.setPwd(txtPassword_AUF.getText());
				userDetails.setUserType(cmbUserType_AUF.getSelectedItem().toString());
				String selectedItem = cmbFirstName_AUF.getSelectedItem().toString();
				userDetails.setReferId(selectedItem.split("_")[0]);
				userDetails.setFirstName(selectedItem.split("_")[1]);
				userDetails.setLastName(selectedItem.split("_")[2]);
				userLogic.saveUserDetails(userDetails);
			}
		});
		
		JButton btnNew_AUF = new JButton("New");
		btnNew_AUF.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		GridBagConstraints gbc_btnNew_AUF = new GridBagConstraints();
		gbc_btnNew_AUF.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNew_AUF.insets = new Insets(0, 0, 5, 5);
		gbc_btnNew_AUF.gridx = 1;
		gbc_btnNew_AUF.gridy = 6;
		pnlUserForm_AU.add(btnNew_AUF, gbc_btnNew_AUF);
		GridBagConstraints gbc_btnSave_AUF = new GridBagConstraints();
		gbc_btnSave_AUF.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSave_AUF.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave_AUF.gridx = 2;
		gbc_btnSave_AUF.gridy = 6;
		pnlUserForm_AU.add(btnSave_AUF, gbc_btnSave_AUF);
		
		JButton btnDelete_AUF = new JButton("Delete");
		GridBagConstraints gbc_btnDelete_AUF = new GridBagConstraints();
		gbc_btnDelete_AUF.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDelete_AUF.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete_AUF.gridx = 3;
		gbc_btnDelete_AUF.gridy = 6;
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
				"User Id", "User Name", "Password", "Refer Id", "User Type", "First Name", "Last Name", "Created By", "Created Date", "Modified By", "Modified Date"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		});
		
		tblUserList_AUL.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollUserList_AUL = new JScrollPane(tblUserList_AUL);
		scrollUserList_AUL.setBounds(6, 73, 453, 286);
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
				if(cmbUserType_AUL.getSelectedItem().toString().equalsIgnoreCase(CommonConstants.PLEASE_SELECT)) {
					JOptionPane.showMessageDialog(null, "Please select the user type", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(txtFirstName_AUL.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Please enter the first name to search", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				DefaultTableModel modelUser = (DefaultTableModel) tblUserList_AUL.getModel();
				List<User> alUserDetails = userLogic.getAlUserDetails(txtFirstName_AUL.getText(),cmbUserType_AUL.getSelectedItem().toString());
				modelUser.setRowCount(0);
				if(alUserDetails.size() == 0) {
					JOptionPane.showMessageDialog(null, "No record found", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					for (int i=0;i<alUserDetails.size();i++) {
						Object[] row = new String[21];
						row[0] = alUserDetails.get(i).getUserId()+"";
						row[1] = alUserDetails.get(i).getUserName();
						row[2] = alUserDetails.get(i).getPwd();
						row[3] = alUserDetails.get(i).getReferId();
						row[4] = alUserDetails.get(i).getUserType();
						row[5] = alUserDetails.get(i).getFirstName();
						row[6] = alUserDetails.get(i).getLastName();
						row[7] = alUserDetails.get(i).getCreatedBy();
						row[8] = alUserDetails.get(i).getCreatedDate();
						row[9] = alUserDetails.get(i).getModifiedBy();
						row[10] = alUserDetails.get(i).getModifiedDate();
						modelUser.addRow(row);
					}
				}
			}
		});
		btnSearch_AUL.setBounds(376, 22, 89, 23);
		pnlUserList_AU.add(btnSearch_AUL);
		
		JLabel lblNote_AUL = new JLabel("  Note: Result will show similar first names apart from exact match.");
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
		
		JPanel pnlBillDetails_A = new JPanel();
		pnlMainTabbed_A.addTab("Bill Details", null, pnlBillDetails_A, null);
		pnlBillDetails_A.setLayout(null);
		
		JPanel pnlBillForm_AB = new JPanel();
		pnlBillForm_AB.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "User Form", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlBillForm_AB.setBounds(0, 0, 483, 365);
		pnlBillDetails_A.add(pnlBillForm_AB);
		GridBagLayout gbl_pnlBillForm_AB = new GridBagLayout();
		gbl_pnlBillForm_AB.columnWidths = new int[]{33, 107, 155, 91, 0, 0};
		gbl_pnlBillForm_AB.rowHeights = new int[]{20, 0, 0, 0, 0, 0, 0, 20, 0, 0};
		gbl_pnlBillForm_AB.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlBillForm_AB.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlBillForm_AB.setLayout(gbl_pnlBillForm_AB);
		
		JLabel label = new JLabel("Username");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 1;
		pnlBillForm_AB.add(label, gbc_label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 1;
		pnlBillForm_AB.add(textField_1, gbc_textField_1);
		
		JButton button_4 = new JButton("New");
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_4.insets = new Insets(0, 0, 5, 5);
		gbc_button_4.gridx = 1;
		gbc_button_4.gridy = 6;
		pnlBillForm_AB.add(button_4, gbc_button_4);
		
		JButton button_5 = new JButton("Save");
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_5.insets = new Insets(0, 0, 5, 5);
		gbc_button_5.gridx = 2;
		gbc_button_5.gridy = 6;
		pnlBillForm_AB.add(button_5, gbc_button_5);
		
		JButton button_6 = new JButton("Delete");
		GridBagConstraints gbc_button_6 = new GridBagConstraints();
		gbc_button_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_6.insets = new Insets(0, 0, 5, 5);
		gbc_button_6.gridx = 3;
		gbc_button_6.gridy = 6;
		pnlBillForm_AB.add(button_6, gbc_button_6);
		
		JPanel pnlBillList_AB = new JPanel();
		pnlBillList_AB.setLayout(null);
		pnlBillList_AB.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "User List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlBillList_AB.setBounds(483, 0, 475, 365);
		pnlBillDetails_A.add(pnlBillList_AB);
		
		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		scrollPane_1.setBounds(6, 73, 453, 286);
		pnlBillList_AB.add(scrollPane_1);
		
		JLabel label_2 = new JLabel("First Name");
		label_2.setBounds(179, 26, 51, 14);
		pnlBillList_AB.add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(239, 23, 127, 20);
		pnlBillList_AB.add(textField_3);
		
		JButton button_7 = new JButton("Search");
		button_7.setBounds(376, 22, 89, 23);
		pnlBillList_AB.add(button_7);
		
		JLabel label_3 = new JLabel("  Note: Result will show similar first names apart from exact match.");
		label_3.setBounds(6, 49, 445, 14);
		pnlBillList_AB.add(label_3);
		
		JPanel pnlRoomDetails_A = new JPanel();
		pnlRoomDetails_A.setLayout(null);
		pnlMainTabbed_A.addTab("Room Details", null, pnlRoomDetails_A, null);
		
		JPanel pnlRoomForm_AR = new JPanel();
		pnlRoomForm_AR.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Room Form", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlRoomForm_AR.setBounds(0, 0, 483, 365);
		pnlRoomDetails_A.add(pnlRoomForm_AR);
		GridBagLayout gbl_pnlRoomForm_AR = new GridBagLayout();
		gbl_pnlRoomForm_AR.columnWidths = new int[]{33, 107, 155, 91, 0, 0};
		gbl_pnlRoomForm_AR.rowHeights = new int[]{20, 0, 0, 0, 0, 0, 0, 20, 0, 0};
		gbl_pnlRoomForm_AR.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlRoomForm_AR.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlRoomForm_AR.setLayout(gbl_pnlRoomForm_AR);
		
		JLabel lblTotalBeds_ARF = new JLabel("Total Beds");
		GridBagConstraints gbc_lblTotalBeds_ARF = new GridBagConstraints();
		gbc_lblTotalBeds_ARF.anchor = GridBagConstraints.EAST;
		gbc_lblTotalBeds_ARF.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalBeds_ARF.gridx = 1;
		gbc_lblTotalBeds_ARF.gridy = 1;
		pnlRoomForm_AR.add(lblTotalBeds_ARF, gbc_lblTotalBeds_ARF);
		
		txtTotalBeds_ARF = new JTextField();
		txtTotalBeds_ARF.setColumns(10);
		GridBagConstraints gbc_txtTotalBeds_ARF = new GridBagConstraints();
		gbc_txtTotalBeds_ARF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTotalBeds_ARF.insets = new Insets(0, 0, 5, 5);
		gbc_txtTotalBeds_ARF.gridx = 2;
		gbc_txtTotalBeds_ARF.gridy = 1;
		pnlRoomForm_AR.add(txtTotalBeds_ARF, gbc_txtTotalBeds_ARF);
		
		JLabel lblOccupiedBeds_ARF = new JLabel("Occupied Beds");
		GridBagConstraints gbc_lblOccupiedBeds_ARF = new GridBagConstraints();
		gbc_lblOccupiedBeds_ARF.anchor = GridBagConstraints.EAST;
		gbc_lblOccupiedBeds_ARF.insets = new Insets(0, 0, 5, 5);
		gbc_lblOccupiedBeds_ARF.gridx = 1;
		gbc_lblOccupiedBeds_ARF.gridy = 2;
		pnlRoomForm_AR.add(lblOccupiedBeds_ARF, gbc_lblOccupiedBeds_ARF);
		
		txtOccupiedBeds_ARF = new JTextField();
		txtOccupiedBeds_ARF.setColumns(10);
		GridBagConstraints gbc_txtOccupiedBeds_ARF = new GridBagConstraints();
		gbc_txtOccupiedBeds_ARF.insets = new Insets(0, 0, 5, 5);
		gbc_txtOccupiedBeds_ARF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtOccupiedBeds_ARF.gridx = 2;
		gbc_txtOccupiedBeds_ARF.gridy = 2;
		pnlRoomForm_AR.add(txtOccupiedBeds_ARF, gbc_txtOccupiedBeds_ARF);
		
		JLabel lblRoomType_ARF = new JLabel("Total Beds");
		GridBagConstraints gbc_lblRoomType_ARF = new GridBagConstraints();
		gbc_lblRoomType_ARF.anchor = GridBagConstraints.EAST;
		gbc_lblRoomType_ARF.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoomType_ARF.gridx = 1;
		gbc_lblRoomType_ARF.gridy = 3;
		pnlRoomForm_AR.add(lblRoomType_ARF, gbc_lblRoomType_ARF);
		
		JComboBox cmbRoomType_ARF = new JComboBox();
		cmbRoomType_ARF.setModel(new DefaultComboBoxModel(new String[] {"Please Select", "General Ward", "Private Bronze", "Private Silver", "Private Gold"}));
		GridBagConstraints gbc_cmbRoomType_ARF = new GridBagConstraints();
		gbc_cmbRoomType_ARF.insets = new Insets(0, 0, 5, 5);
		gbc_cmbRoomType_ARF.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbRoomType_ARF.gridx = 2;
		gbc_cmbRoomType_ARF.gridy = 3;
		pnlRoomForm_AR.add(cmbRoomType_ARF, gbc_cmbRoomType_ARF);
		
		JLabel lblBuildingNumber_ARF = new JLabel("Building Number");
		GridBagConstraints gbc_lblBuildingNumber_ARF = new GridBagConstraints();
		gbc_lblBuildingNumber_ARF.anchor = GridBagConstraints.EAST;
		gbc_lblBuildingNumber_ARF.insets = new Insets(0, 0, 5, 5);
		gbc_lblBuildingNumber_ARF.gridx = 1;
		gbc_lblBuildingNumber_ARF.gridy = 4;
		pnlRoomForm_AR.add(lblBuildingNumber_ARF, gbc_lblBuildingNumber_ARF);
		
		JComboBox cmbBuildingNumber_ARF = new JComboBox();
		cmbBuildingNumber_ARF.setModel(new DefaultComboBoxModel(new String[] {"Please Select", "A1", "A2", "A3", "A4", "A5", "A6", "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9"}));
		GridBagConstraints gbc_cmbBuildingNumber_ARF = new GridBagConstraints();
		gbc_cmbBuildingNumber_ARF.insets = new Insets(0, 0, 5, 5);
		gbc_cmbBuildingNumber_ARF.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbBuildingNumber_ARF.gridx = 2;
		gbc_cmbBuildingNumber_ARF.gridy = 4;
		pnlRoomForm_AR.add(cmbBuildingNumber_ARF, gbc_cmbBuildingNumber_ARF);
		
		JButton btnNew_ARF = new JButton("New");
		GridBagConstraints gbc_btnNew_ARF = new GridBagConstraints();
		gbc_btnNew_ARF.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNew_ARF.insets = new Insets(0, 0, 5, 5);
		gbc_btnNew_ARF.gridx = 1;
		gbc_btnNew_ARF.gridy = 6;
		pnlRoomForm_AR.add(btnNew_ARF, gbc_btnNew_ARF);
		
		JButton btnSave_ARF = new JButton("Save");
		GridBagConstraints gbc_btnSave_ARF = new GridBagConstraints();
		gbc_btnSave_ARF.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSave_ARF.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave_ARF.gridx = 2;
		gbc_btnSave_ARF.gridy = 6;
		pnlRoomForm_AR.add(btnSave_ARF, gbc_btnSave_ARF);
		
		JButton btnDelete_ARF = new JButton("Delete");
		GridBagConstraints gbc_btnDelete_ARF = new GridBagConstraints();
		gbc_btnDelete_ARF.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDelete_ARF.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete_ARF.gridx = 3;
		gbc_btnDelete_ARF.gridy = 6;
		pnlRoomForm_AR.add(btnDelete_ARF, gbc_btnDelete_ARF);
		
		JPanel pnlRoomList_AR = new JPanel();
		pnlRoomList_AR.setLayout(null);
		pnlRoomList_AR.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Room List", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlRoomList_AR.setBounds(483, 0, 475, 365);
		pnlRoomDetails_A.add(pnlRoomList_AR);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(6, 73, 453, 286);
		pnlRoomList_AR.add(scrollPane);
		
		JLabel label_6 = new JLabel("First Name");
		label_6.setBounds(179, 26, 51, 14);
		pnlRoomList_AR.add(label_6);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(239, 23, 127, 20);
		pnlRoomList_AR.add(textField_2);
		
		JButton button_3 = new JButton("Search");
		button_3.setBounds(376, 22, 89, 23);
		pnlRoomList_AR.add(button_3);
		
		JLabel label_7 = new JLabel("  Note: Result will show similar first names apart from exact match.");
		label_7.setBounds(6, 49, 445, 14);
		pnlRoomList_AR.add(label_7);
		
		JPanel pnlStaffDetails_A = new JPanel();
		pnlStaffDetails_A.setLayout(null);
		pnlMainTabbed_A.addTab("Staff Details", null, pnlStaffDetails_A, null);
		
		JPanel pnlStaffForm_AS = new JPanel();
		pnlStaffForm_AS.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "User Form", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlStaffForm_AS.setBounds(0, 0, 483, 365);
		pnlStaffDetails_A.add(pnlStaffForm_AS);
		GridBagLayout gbl_pnlStaffForm_AS = new GridBagLayout();
		gbl_pnlStaffForm_AS.columnWidths = new int[]{33, 107, 155, 91, 0, 0};
		gbl_pnlStaffForm_AS.rowHeights = new int[]{20, 0, 0, 0, 0, 0, 0, 20, 0, 0};
		gbl_pnlStaffForm_AS.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlStaffForm_AS.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlStaffForm_AS.setLayout(gbl_pnlStaffForm_AS);
		
		JLabel label_4 = new JLabel("Username");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.EAST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 1;
		gbc_label_4.gridy = 1;
		pnlStaffForm_AS.add(label_4, gbc_label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.gridx = 2;
		gbc_textField_4.gridy = 1;
		pnlStaffForm_AS.add(textField_4, gbc_textField_4);
		
		JButton button_8 = new JButton("New");
		GridBagConstraints gbc_button_8 = new GridBagConstraints();
		gbc_button_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_8.insets = new Insets(0, 0, 5, 5);
		gbc_button_8.gridx = 1;
		gbc_button_8.gridy = 6;
		pnlStaffForm_AS.add(button_8, gbc_button_8);
		
		JButton button_9 = new JButton("Save");
		GridBagConstraints gbc_button_9 = new GridBagConstraints();
		gbc_button_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_9.insets = new Insets(0, 0, 5, 5);
		gbc_button_9.gridx = 2;
		gbc_button_9.gridy = 6;
		pnlStaffForm_AS.add(button_9, gbc_button_9);
		
		JButton button_10 = new JButton("Delete");
		GridBagConstraints gbc_button_10 = new GridBagConstraints();
		gbc_button_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_10.insets = new Insets(0, 0, 5, 5);
		gbc_button_10.gridx = 3;
		gbc_button_10.gridy = 6;
		pnlStaffForm_AS.add(button_10, gbc_button_10);
		
		JPanel pnlStaffList_AS = new JPanel();
		pnlStaffList_AS.setLayout(null);
		pnlStaffList_AS.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "User List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlStaffList_AS.setBounds(483, 0, 475, 365);
		pnlStaffDetails_A.add(pnlStaffList_AS);
		
		JScrollPane scrollPane_2 = new JScrollPane((Component) null);
		scrollPane_2.setBounds(6, 73, 453, 286);
		pnlStaffList_AS.add(scrollPane_2);
		
		JLabel label_5 = new JLabel("First Name");
		label_5.setBounds(179, 26, 51, 14);
		pnlStaffList_AS.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(239, 23, 127, 20);
		pnlStaffList_AS.add(textField_5);
		
		JButton button_11 = new JButton("Search");
		button_11.setBounds(376, 22, 89, 23);
		pnlStaffList_AS.add(button_11);
		
		JLabel label_8 = new JLabel("  Note: Result will show similar first names apart from exact match.");
		label_8.setBounds(6, 49, 445, 14);
		pnlStaffList_AS.add(label_8);
		
		JPanel pnlEventDetails_A = new JPanel();
		pnlEventDetails_A.setLayout(null);
		pnlMainTabbed_A.addTab("Event Details", null, pnlEventDetails_A, null);
		
		JPanel pnlEventForm_AE = new JPanel();
		pnlEventForm_AE.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Event Form", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlEventForm_AE.setBounds(0, 0, 483, 365);
		pnlEventDetails_A.add(pnlEventForm_AE);
		GridBagLayout gbl_pnlEventForm_AE = new GridBagLayout();
		gbl_pnlEventForm_AE.columnWidths = new int[]{33, 107, 155, 91, 0, 0};
		gbl_pnlEventForm_AE.rowHeights = new int[]{20, 0, 0, 0, 0, 0, 0, 20, 0, 0};
		gbl_pnlEventForm_AE.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlEventForm_AE.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlEventForm_AE.setLayout(gbl_pnlEventForm_AE);
		
		JLabel lblPatientId = new JLabel("Patient Id");
		GridBagConstraints gbc_lblPatientId = new GridBagConstraints();
		gbc_lblPatientId.anchor = GridBagConstraints.EAST;
		gbc_lblPatientId.insets = new Insets(0, 0, 5, 5);
		gbc_lblPatientId.gridx = 1;
		gbc_lblPatientId.gridy = 1;
		pnlEventForm_AE.add(lblPatientId, gbc_lblPatientId);
		
		JComboBox cmbPatientId = new JComboBox();
		GridBagConstraints gbc_cmbPatientId = new GridBagConstraints();
		gbc_cmbPatientId.insets = new Insets(0, 0, 5, 5);
		gbc_cmbPatientId.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbPatientId.gridx = 2;
		gbc_cmbPatientId.gridy = 1;
		pnlEventForm_AE.add(cmbPatientId, gbc_cmbPatientId);
		
		JLabel lblStaffId = new JLabel("Staff Id");
		GridBagConstraints gbc_lblStaffId = new GridBagConstraints();
		gbc_lblStaffId.anchor = GridBagConstraints.EAST;
		gbc_lblStaffId.insets = new Insets(0, 0, 5, 5);
		gbc_lblStaffId.gridx = 1;
		gbc_lblStaffId.gridy = 2;
		pnlEventForm_AE.add(lblStaffId, gbc_lblStaffId);
		
		JComboBox cmbStaffId = new JComboBox();
		GridBagConstraints gbc_cmbStaffId = new GridBagConstraints();
		gbc_cmbStaffId.insets = new Insets(0, 0, 5, 5);
		gbc_cmbStaffId.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbStaffId.gridx = 2;
		gbc_cmbStaffId.gridy = 2;
		pnlEventForm_AE.add(cmbStaffId, gbc_cmbStaffId);
		
		JLabel lblEventType = new JLabel("Event Type");
		GridBagConstraints gbc_lblEventType = new GridBagConstraints();
		gbc_lblEventType.anchor = GridBagConstraints.EAST;
		gbc_lblEventType.insets = new Insets(0, 0, 5, 5);
		gbc_lblEventType.gridx = 1;
		gbc_lblEventType.gridy = 3;
		pnlEventForm_AE.add(lblEventType, gbc_lblEventType);
		
		JComboBox cmbEventType = new JComboBox();
		GridBagConstraints gbc_cmbEventType = new GridBagConstraints();
		gbc_cmbEventType.insets = new Insets(0, 0, 5, 5);
		gbc_cmbEventType.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbEventType.gridx = 2;
		gbc_cmbEventType.gridy = 3;
		pnlEventForm_AE.add(cmbEventType, gbc_cmbEventType);
		
		JLabel lblEventDate = new JLabel("Event Date");
		GridBagConstraints gbc_lblEventDate = new GridBagConstraints();
		gbc_lblEventDate.anchor = GridBagConstraints.EAST;
		gbc_lblEventDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblEventDate.gridx = 1;
		gbc_lblEventDate.gridy = 4;
		pnlEventForm_AE.add(lblEventDate, gbc_lblEventDate);
		
		JButton button_12 = new JButton("New");
		GridBagConstraints gbc_button_12 = new GridBagConstraints();
		gbc_button_12.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_12.insets = new Insets(0, 0, 5, 5);
		gbc_button_12.gridx = 1;
		gbc_button_12.gridy = 6;
		pnlEventForm_AE.add(button_12, gbc_button_12);
		
		JButton button_13 = new JButton("Save");
		GridBagConstraints gbc_button_13 = new GridBagConstraints();
		gbc_button_13.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_13.insets = new Insets(0, 0, 5, 5);
		gbc_button_13.gridx = 2;
		gbc_button_13.gridy = 6;
		pnlEventForm_AE.add(button_13, gbc_button_13);
		
		JButton button_14 = new JButton("Delete");
		GridBagConstraints gbc_button_14 = new GridBagConstraints();
		gbc_button_14.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_14.insets = new Insets(0, 0, 5, 5);
		gbc_button_14.gridx = 3;
		gbc_button_14.gridy = 6;
		pnlEventForm_AE.add(button_14, gbc_button_14);
		
		JPanel pnlEventList_AE = new JPanel();
		pnlEventList_AE.setLayout(null);
		pnlEventList_AE.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Event List", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlEventList_AE.setBounds(483, 0, 475, 365);
		pnlEventDetails_A.add(pnlEventList_AE);
		
		JScrollPane scrollPane_3 = new JScrollPane((Component) null);
		scrollPane_3.setBounds(6, 73, 453, 286);
		pnlEventList_AE.add(scrollPane_3);
		
		JLabel label_10 = new JLabel("First Name");
		label_10.setBounds(179, 26, 51, 14);
		pnlEventList_AE.add(label_10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(239, 23, 127, 20);
		pnlEventList_AE.add(textField_7);
		
		JButton button_15 = new JButton("Search");
		button_15.setBounds(376, 22, 89, 23);
		pnlEventList_AE.add(button_15);
		
		JLabel label_11 = new JLabel("  Note: Result will show similar first names apart from exact match.");
		label_11.setBounds(6, 49, 445, 14);
		pnlEventList_AE.add(label_11);
		
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
