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
import java.awt.Component;
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
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable tblEventList_DEL;
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
