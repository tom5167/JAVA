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

import PatientCareUtil.DateLabelFormatter;
import patientCareBusinessLogic.DiagnosisLogic;
import patientCareBusinessLogic.EventLogic;
import patientCareBusinessLogic.PatientLogic;
import patientCarePOJO.Diagnosis;
import patientCarePOJO.Event;
import patientCarePOJO.Patient;

public class DoctorScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 400619205466386651L;
	PatientLogic patientLogic = new PatientLogic();
	DiagnosisLogic diagnosisLogic = new DiagnosisLogic();
	EventLogic eventLogic = new EventLogic();
	private JPanel contentPane;
	private JTable tblPatientList_DPL;
	private JTextField txtFirstName_DPL;
	private JTextField txtFirstName_DDL;
	private JTable tblEventList_DEL;
	private JTable tblDiagnosisList_DDL;
	private JTextField txtIllness_DDF;
	private JTextField txtMedicationName_DDF;
	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "serial", "unchecked", "rawtypes" })
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
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addMouseListener(new MouseAdapter() {
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
		btnLogout.setBounds(853, 6, 100, 19);
		pnlTop_D.add(btnLogout);
		
		JLabel lblDoctor = new JLabel("Doctor Control");
		lblDoctor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDoctor.setBounds(10, -2, 131, 31);
		pnlTop_D.add(lblDoctor);
		
		JTabbedPane pnlMainTabbed_D = new JTabbedPane(JTabbedPane.TOP);
		pnlMainTabbed_D.setBounds(5, 37, 963, 393);
		contentPane.add(pnlMainTabbed_D);
		
		JPanel pnlPatientDetails_D = new JPanel();
		pnlPatientDetails_D.setLayout(null);
		pnlMainTabbed_D.addTab("Patient Details", null, pnlPatientDetails_D, null);
		
		JPanel pnlPatientList_DP = new JPanel();
		pnlPatientList_DP.setLayout(null);
		pnlPatientList_DP.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Patient List", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlPatientList_DP.setBounds(0, 0, 958, 365);
		pnlPatientDetails_D.add(pnlPatientList_DP);
		
		tblPatientList_DPL = new JTable();
		tblPatientList_DPL.setModel(new DefaultTableModel(
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
		
		tblPatientList_DPL.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPatientList_DPL = new JScrollPane(tblPatientList_DPL);
		scrollPatientList_DPL.setBounds(6, 73, 942, 286);
		pnlPatientList_DP.add(scrollPatientList_DPL);
		
		JLabel lblFirstName_DPL = new JLabel("First Name");
		lblFirstName_DPL.setBounds(10, 26, 51, 14);
		pnlPatientList_DP.add(lblFirstName_DPL);
		
		txtFirstName_DPL = new JTextField();
		txtFirstName_DPL.setColumns(10);
		txtFirstName_DPL.setBounds(71, 23, 152, 20);
		pnlPatientList_DP.add(txtFirstName_DPL);
		
		JButton btnSearch_DPL = new JButton("Search");
		btnSearch_DPL.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(txtFirstName_DPL.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Please enter the first name to search", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				DefaultTableModel modelPatient = (DefaultTableModel) tblPatientList_DPL.getModel();
				List<Patient> alPatientDetails = patientLogic.getAlPatientDetails(txtFirstName_DPL.getText());
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
		btnSearch_DPL.setBounds(233, 22, 89, 23);
		pnlPatientList_DP.add(btnSearch_DPL);
		
		JLabel lblNote_DPL = new JLabel("  Note: Result will show similar first names apart from exact match.");
		lblNote_DPL.setBounds(6, 49, 445, 14);
		pnlPatientList_DP.add(lblNote_DPL);
		
		JPanel pnlDiagnosisDetails_D = new JPanel();
		pnlMainTabbed_D.addTab("Diagnosis Details", null, pnlDiagnosisDetails_D, null);
		pnlDiagnosisDetails_D.setLayout(null);
		
		JPanel pnlDiagnosisForm_DD = new JPanel();
		pnlDiagnosisForm_DD.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Diagnosis Form", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlDiagnosisForm_DD.setBounds(0, 0, 483, 365);
		pnlDiagnosisDetails_D.add(pnlDiagnosisForm_DD);
		GridBagLayout gbl_pnlDiagnosisForm_DD = new GridBagLayout();
		gbl_pnlDiagnosisForm_DD.columnWidths = new int[]{33, 107, 155, 91, 0, 0};
		gbl_pnlDiagnosisForm_DD.rowHeights = new int[]{20, 0, 0, 0, 0, 0, 20, 0, 20, 0, 0};
		gbl_pnlDiagnosisForm_DD.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlDiagnosisForm_DD.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlDiagnosisForm_DD.setLayout(gbl_pnlDiagnosisForm_DD);
		
		JLabel lblDiagnosisId_DDF = new JLabel("");
		GridBagConstraints gbc_lblDiagnosisId_DDF = new GridBagConstraints();
		gbc_lblDiagnosisId_DDF.insets = new Insets(0, 0, 5, 5);
		gbc_lblDiagnosisId_DDF.gridx = 2;
		gbc_lblDiagnosisId_DDF.gridy = 0;
		pnlDiagnosisForm_DD.add(lblDiagnosisId_DDF, gbc_lblDiagnosisId_DDF);
		
		JLabel lblPatientId_DDF = new JLabel("Patient Id");
		GridBagConstraints gbc_lblPatientId_DDF = new GridBagConstraints();
		gbc_lblPatientId_DDF.insets = new Insets(0, 0, 5, 5);
		gbc_lblPatientId_DDF.anchor = GridBagConstraints.EAST;
		gbc_lblPatientId_DDF.gridx = 1;
		gbc_lblPatientId_DDF.gridy = 1;
		pnlDiagnosisForm_DD.add(lblPatientId_DDF, gbc_lblPatientId_DDF);
		
		JComboBox cmbPatientId_DDF = new JComboBox();
		cmbPatientId_DDF.setModel(new DefaultComboBoxModel(new String[] {"Please Select"}));
		GridBagConstraints gbc_cmbPatientId_DDF = new GridBagConstraints();
		gbc_cmbPatientId_DDF.insets = new Insets(0, 0, 5, 5);
		gbc_cmbPatientId_DDF.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbPatientId_DDF.gridx = 2;
		gbc_cmbPatientId_DDF.gridy = 1;
		pnlDiagnosisForm_DD.add(cmbPatientId_DDF, gbc_cmbPatientId_DDF);
		
		JLabel lblMedicationName = new JLabel("Medication Name");
		GridBagConstraints gbc_lblMedicationName = new GridBagConstraints();
		gbc_lblMedicationName.anchor = GridBagConstraints.EAST;
		gbc_lblMedicationName.insets = new Insets(0, 0, 5, 5);
		gbc_lblMedicationName.gridx = 1;
		gbc_lblMedicationName.gridy = 2;
		pnlDiagnosisForm_DD.add(lblMedicationName, gbc_lblMedicationName);
		
		txtMedicationName_DDF = new JTextField();
		GridBagConstraints gbc_txtMedicationName_DDF = new GridBagConstraints();
		gbc_txtMedicationName_DDF.insets = new Insets(0, 0, 5, 5);
		gbc_txtMedicationName_DDF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMedicationName_DDF.gridx = 2;
		gbc_txtMedicationName_DDF.gridy = 2;
		pnlDiagnosisForm_DD.add(txtMedicationName_DDF, gbc_txtMedicationName_DDF);
		txtMedicationName_DDF.setColumns(10);
		
		JLabel lblMedicationType = new JLabel("Medication Type");
		GridBagConstraints gbc_lblMedicationType = new GridBagConstraints();
		gbc_lblMedicationType.anchor = GridBagConstraints.EAST;
		gbc_lblMedicationType.insets = new Insets(0, 0, 5, 5);
		gbc_lblMedicationType.gridx = 1;
		gbc_lblMedicationType.gridy = 3;
		pnlDiagnosisForm_DD.add(lblMedicationType, gbc_lblMedicationType);
		
		JComboBox cmbMedicationType_DDF = new JComboBox();
		cmbMedicationType_DDF.setModel(new DefaultComboBoxModel(new String[] {"Please Select", "Syrup", "Inject", "Tablets"}));
		GridBagConstraints gbc_cmbMedicationType_DDF = new GridBagConstraints();
		gbc_cmbMedicationType_DDF.insets = new Insets(0, 0, 5, 5);
		gbc_cmbMedicationType_DDF.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbMedicationType_DDF.gridx = 2;
		gbc_cmbMedicationType_DDF.gridy = 3;
		pnlDiagnosisForm_DD.add(cmbMedicationType_DDF, gbc_cmbMedicationType_DDF);
		
		JLabel lblIllness_DDF = new JLabel("Illness");
		GridBagConstraints gbc_lblIllness_DDF = new GridBagConstraints();
		gbc_lblIllness_DDF.anchor = GridBagConstraints.EAST;
		gbc_lblIllness_DDF.insets = new Insets(0, 0, 5, 5);
		gbc_lblIllness_DDF.gridx = 1;
		gbc_lblIllness_DDF.gridy = 4;
		pnlDiagnosisForm_DD.add(lblIllness_DDF, gbc_lblIllness_DDF);
		
		txtIllness_DDF = new JTextField();
		GridBagConstraints gbc_txtIllness_DDF = new GridBagConstraints();
		gbc_txtIllness_DDF.anchor = GridBagConstraints.NORTH;
		gbc_txtIllness_DDF.insets = new Insets(0, 0, 5, 5);
		gbc_txtIllness_DDF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIllness_DDF.gridx = 2;
		gbc_txtIllness_DDF.gridy = 4;
		pnlDiagnosisForm_DD.add(txtIllness_DDF, gbc_txtIllness_DDF);
		txtIllness_DDF.setColumns(10);
		
		JLabel lblDosage = new JLabel("Dosage");
		GridBagConstraints gbc_lblDosage = new GridBagConstraints();
		gbc_lblDosage.anchor = GridBagConstraints.EAST;
		gbc_lblDosage.insets = new Insets(0, 0, 5, 5);
		gbc_lblDosage.gridx = 1;
		gbc_lblDosage.gridy = 5;
		pnlDiagnosisForm_DD.add(lblDosage, gbc_lblDosage);
		
		JComboBox cmbDosage_DDF = new JComboBox();
		cmbDosage_DDF.setModel(new DefaultComboBoxModel(new String[] {"Please Select", "1", "2", "3", "4", "5", "6"}));
		GridBagConstraints gbc_cmbDosage_DDF = new GridBagConstraints();
		gbc_cmbDosage_DDF.insets = new Insets(0, 0, 5, 5);
		gbc_cmbDosage_DDF.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbDosage_DDF.gridx = 2;
		gbc_cmbDosage_DDF.gridy = 5;
		pnlDiagnosisForm_DD.add(cmbDosage_DDF, gbc_cmbDosage_DDF);
		
		JButton btnNew_DDF = new JButton("New");
		GridBagConstraints gbc_btnNew_DDF = new GridBagConstraints();
		gbc_btnNew_DDF.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNew_DDF.insets = new Insets(0, 0, 5, 5);
		gbc_btnNew_DDF.gridx = 1;
		gbc_btnNew_DDF.gridy = 7;
		pnlDiagnosisForm_DD.add(btnNew_DDF, gbc_btnNew_DDF);
		
		JButton btnSave_DDF = new JButton("Save");
		GridBagConstraints gbc_btnSave_DDF = new GridBagConstraints();
		gbc_btnSave_DDF.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSave_DDF.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave_DDF.gridx = 2;
		gbc_btnSave_DDF.gridy = 7;
		pnlDiagnosisForm_DD.add(btnSave_DDF, gbc_btnSave_DDF);
		
		JButton btnDelete_DDF = new JButton("Delete");
		btnDelete_DDF.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Diagnosis diagnosisDetails = new Diagnosis();
				if(lblDiagnosisId_DDF.getText().equalsIgnoreCase("")) {
					diagnosisDetails.setDiagnosisId(0);
				} else {
					diagnosisDetails.setDiagnosisId(Integer.parseInt(lblDiagnosisId_DDF.getText()));
				}
				diagnosisLogic.deleteDiagnosisDetails(diagnosisDetails);
			}
		});
		GridBagConstraints gbc_btnDelete_DDF = new GridBagConstraints();
		gbc_btnDelete_DDF.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDelete_DDF.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete_DDF.gridx = 3;
		gbc_btnDelete_DDF.gridy = 7;
		pnlDiagnosisForm_DD.add(btnDelete_DDF, gbc_btnDelete_DDF);
		
		JPanel pnlDiagnosisList_DD = new JPanel();
		pnlDiagnosisList_DD.setLayout(null);
		pnlDiagnosisList_DD.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Diagnosis List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDiagnosisList_DD.setBounds(483, 0, 475, 365);
		pnlDiagnosisDetails_D.add(pnlDiagnosisList_DD);
		
		tblDiagnosisList_DDL = new JTable();
		tblDiagnosisList_DDL.setModel(new DefaultTableModel(
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
		
		tblDiagnosisList_DDL.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollDiagnosisList_DDL = new JScrollPane(tblDiagnosisList_DDL);
		scrollDiagnosisList_DDL.setBounds(6, 73, 453, 286);
		pnlDiagnosisList_DD.add(scrollDiagnosisList_DDL);
		
		JLabel lblFirstName_DDL = new JLabel("First Name");
		lblFirstName_DDL.setBounds(179, 26, 51, 14);
		pnlDiagnosisList_DD.add(lblFirstName_DDL);
		
		txtFirstName_DDL = new JTextField();
		txtFirstName_DDL.setColumns(10);
		txtFirstName_DDL.setBounds(239, 23, 127, 20);
		pnlDiagnosisList_DD.add(txtFirstName_DDL);
		
		JButton btnSearch_DDL = new JButton("Search");
		btnSearch_DDL.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(txtFirstName_DDL.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Please enter the first name to search", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				DefaultTableModel modelDiagnosis = (DefaultTableModel) tblDiagnosisList_DDL.getModel();
				List<Diagnosis> alDiagnosisDetails = diagnosisLogic.getAlDiagnosisDetails(txtFirstName_DDL.getText());
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
		btnSearch_DDL.setBounds(376, 22, 89, 23);
		pnlDiagnosisList_DD.add(btnSearch_DDL);
		
		JLabel lblNote_DDL = new JLabel("  Note: Result will show similar first names apart from exact match.");
		lblNote_DDL.setBounds(6, 49, 445, 14);
		pnlDiagnosisList_DD.add(lblNote_DDL);
		
		JPanel pnlEventDetails_D = new JPanel();
		pnlMainTabbed_D.addTab("Event Details", null, pnlEventDetails_D, null);
		pnlEventDetails_D.setLayout(null);
		
		JPanel pnlEventList_DE = new JPanel();
		pnlEventList_DE.setLayout(null);
		pnlEventList_DE.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Event List", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlEventList_DE.setBounds(0, 0, 958, 365);
		pnlEventDetails_D.add(pnlEventList_DE);
				
		tblEventList_DEL = new JTable();
		tblEventList_DEL.setModel(new DefaultTableModel(
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
		tblEventList_DEL.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollEventList_DEL = new JScrollPane(tblEventList_DEL);
		scrollEventList_DEL.setBounds(6, 73, 942, 286);
		pnlEventList_DE.add(scrollEventList_DEL);
		
		JLabel lblEventDate = new JLabel("Event Date");
		lblEventDate.setBounds(192, 22, 71, 23);
		pnlEventList_DE.add(lblEventDate);
		
		UtilDateModel dateModel_DEL = new UtilDateModel();
		Properties prop_DEL = new Properties();
		prop_DEL.put("text.today", "Today");
		prop_DEL.put("text.month", "Month");
		prop_DEL.put("text.year", "Year");
		JDatePanelImpl datePanel_DEL = new JDatePanelImpl(dateModel_DEL, prop_DEL);
		DateLabelFormatter dateLabelFormatter_DEL = new DateLabelFormatter();
		JDatePickerImpl datePicker_DEL = new JDatePickerImpl(datePanel_DEL, dateLabelFormatter_DEL);
		datePicker_DEL.setBounds(249, 22, 117, 23);
		pnlEventList_DE.add(datePicker_DEL);
		
		JLabel lblEventType_DEL = new JLabel("Event Type");
		lblEventType_DEL.setBounds(10, 26, 55, 14);
		pnlEventList_DE.add(lblEventType_DEL);
		
		JComboBox cmbEventType_DEL = new JComboBox();
		cmbEventType_DEL.setModel(new DefaultComboBoxModel(new String[] {"Please Select", "Appointment", "Operation"}));
		cmbEventType_DEL.setBounds(75, 23, 111, 20);
		pnlEventList_DE.add(cmbEventType_DEL);
		
		JButton btnSearch_DEL = new JButton("Search");
		btnSearch_DEL.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(cmbEventType_DEL.getSelectedItem().toString().equalsIgnoreCase("Please Select")) {
					JOptionPane.showMessageDialog(null, "Please select the event type to search", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(datePicker_DEL.getJFormattedTextField().getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Please enter the event date to search", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				DefaultTableModel modelEvent = (DefaultTableModel) tblEventList_DEL.getModel();
				List<Event> alEventDetails = eventLogic.getAlEventDetails(cmbEventType_DEL.getSelectedItem().toString(),
						datePicker_DEL.getJFormattedTextField().getText());
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
		btnSearch_DEL.setBounds(376, 22, 89, 23);
		pnlEventList_DE.add(btnSearch_DEL);
		
		JLabel lblNote_DEL = new JLabel("  Note: Result will show similar first names apart from exact match.");
		lblNote_DEL.setBounds(6, 49, 445, 14);
		pnlEventList_DE.add(lblNote_DEL);
		
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
