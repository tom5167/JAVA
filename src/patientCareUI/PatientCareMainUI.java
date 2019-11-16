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

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.apache.log4j.Logger;

import patientCareLogger.PatientCareLogger;

public class PatientCareMainUI {

	static Logger logger = PatientCareLogger.getLogger();
	
	private JFrame patientCareUI;
	private JPanel welcomePanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		logger.info("PatientCareMainUI.main() starts");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientCareMainUI window = new PatientCareMainUI();
					window.patientCareUI.setVisible(true);
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		logger.info("PatientCareMainUI.main() ends");
	}

	/**
	 * Create the application.
	 */
	public PatientCareMainUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		patientCareUI = new JFrame();
		patientCareUI.setTitle("Patient Care");
		patientCareUI.setResizable(false);
		patientCareUI.setBounds(200, 10, 551, 600);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		patientCareUI.setLocation(dim.width/2-patientCareUI.getSize().width/2, dim.height/2-patientCareUI.getSize().height/2);
		
		patientCareUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		patientCareUI.getContentPane().setLayout(new CardLayout(0, 0));
		
		welcomePanel = new JPanel();
		patientCareUI.getContentPane().add(welcomePanel, "welcomePanel");
		welcomePanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblWelcomelabel = new JLabel("");
		lblWelcomelabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblWelcomelabel.setIcon(new ImageIcon(System.getProperty("user.dir")+"\\image\\hospitalWelcome.png"));
		welcomePanel.add(lblWelcomelabel, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		patientCareUI.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmLogin = new JMenuItem("Login");
		mntmLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				LoginScreen loginScreen = new LoginScreen();
				loginScreen.setVisible(true);
				patientCareUI.setVisible(false);
			}
		});
		mnFile.add(mntmLogin);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int option = JOptionPane.showConfirmDialog(patientCareUI, "Are you sure you want to close the application?",
						"Close Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (option == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		mnFile.add(mntmExit);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmAboutUs = new JMenuItem("About Us");
		mntmAboutUs.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Patient Care", "About Us", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnHelp.add(mntmAboutUs);
	}
	
}
