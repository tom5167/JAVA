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

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import PatientCareUtil.DateLabelFormatter;
import patientCareBusinessLogic.BillLogic;
import patientCareBusinessLogic.EventLogic;
import patientCareConstants.CommonConstants;
import patientCarePOJO.Bill;
import patientCarePOJO.Event;
import patientCarePOJO.Patient;
import patientCarePOJO.Staff;

public class PatientScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 400619205466386651L;
	private JPanel contentPane;
	private JTextField textField_3;
	private JTable tblBilllist_RSP;
	private JButton lblBillid_RSB;
	private JComboBox cmbPatientId_RSB;
	private JTextField txtBillAmt_RSB;
	private JTextField txtPayername_RSB;
	private JTextField txtInsuranceId_RSB;
	private JTextField txtFirstname_RSB;
	BillLogic billlogic = new BillLogic();
	EventLogic eventLogic = new EventLogic();
	private JTable tblEventList_APL;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("rawtypes")
	public PatientScreen() {
		setTitle("Patient Care");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 984, 494);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlTop_P = new JPanel();
		pnlTop_P.setLayout(null);
		pnlTop_P.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlTop_P.setBounds(5, 5, 963, 30);
		contentPane.add(pnlTop_P);
		
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
		pnlTop_P.add(button_1);
		
		JLabel lblPatientControl = new JLabel("Patient Control");
		lblPatientControl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPatientControl.setBounds(10, -2, 131, 31);
		pnlTop_P.add(lblPatientControl);
		
		JTabbedPane pnlMainTabbed_P = new JTabbedPane(JTabbedPane.TOP);
		pnlMainTabbed_P.setBounds(5, 37, 963, 393);
		contentPane.add(pnlMainTabbed_P);
		
		JPanel pnlBillDetails_P = new JPanel();
		pnlMainTabbed_P.addTab("Bill Details", null, pnlBillDetails_P, null);
		pnlBillDetails_P.setLayout(null);
		
		JPanel pnlbilllist_RSP = new JPanel();
		pnlbilllist_RSP.setLayout(null);
		pnlbilllist_RSP.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Bills List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlbilllist_RSP.setBounds(0, 0, 958, 365);
		pnlBillDetails_P.add(pnlbilllist_RSP);
		
		tblBilllist_RSP = new JTable();
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
		scrollBilllist_RSP.setBounds(6, 73, 942, 286);
		pnlbilllist_RSP.add(scrollBilllist_RSP);
		
			
		JButton btnSearch_RSP = new JButton("Search");
		btnSearch_RSP.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				DefaultTableModel modelBill = (DefaultTableModel) tblBilllist_RSP.getModel();
				List<Bill> alBillDetails = billlogic.getAlBillDetailsUser();
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
		btnSearch_RSP.setBounds(10, 25, 89, 23);
		pnlbilllist_RSP.add(btnSearch_RSP);
		
		JPanel pnlEventDetails_P = new JPanel();
		pnlEventDetails_P.setLayout(null);
		pnlMainTabbed_P.addTab("Event Details", null, pnlEventDetails_P, null);
		
		UtilDateModel dateModel_AEF = new UtilDateModel();
		Properties prop_AEF = new Properties();
		prop_AEF.put("text.today", "Today");
		prop_AEF.put("text.month", "Month");
		prop_AEF.put("text.year", "Year");
		JDatePanelImpl datePanel_AEF = new JDatePanelImpl(dateModel_AEF, prop_AEF);
		DateLabelFormatter dateLabelFormatter_AEF = new DateLabelFormatter();
		
		JPanel pnlEventList_AE = new JPanel();
		pnlEventList_AE.setLayout(null);
		pnlEventList_AE.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Event List", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlEventList_AE.setBounds(0, 0, 958, 365);
		pnlEventDetails_P.add(pnlEventList_AE);
		
		tblEventList_APL = new JTable();
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
		scrollEventList_AEL.setBounds(6, 73, 942, 286);
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
				List<Event> alEventDetails = eventLogic.getAlEventDetailsUser(cmbEventType_AEL.getSelectedItem().toString(),
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
		
		JPanel pnlBottom_P = new JPanel();
		pnlBottom_P.setLayout(null);
		pnlBottom_P.setBounds(5, 430, 963, 23);
		contentPane.add(pnlBottom_P);
		
		JLabel label_1 = new JLabel("Copyright @PatientCare 2019");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(0, 0, 268, 23);
		pnlBottom_P.add(label_1);
	}
}
