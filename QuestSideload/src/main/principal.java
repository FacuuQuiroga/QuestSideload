package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import main.ADB;
import utils.CustomOutputStream;

import javax.swing.JTextArea;
import java.awt.Toolkit;
import java.awt.Button;

public class principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal frame = new principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Facu\\eclipse-workspace\\QuestSideload\\resources\\icon.png"));
		setTitle("QuestSideload");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("install apk");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ADB.installApk();
			}
		});
		btnNewButton.setBounds(26, 20, 123, 49);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Copy Obb data");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ADB.pushObb();
			}
		});
		btnNewButton_1.setBounds(161, 20, 123, 49);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Restart device");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ADB.reboot();
			}
		});
		btnNewButton_2.setBounds(382, 280, 123, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("adb Devices");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ADB.adbDevices();
			}
		});
		btnNewButton_3.setBounds(382, 245, 123, 23);
		contentPane.add(btnNewButton_3);
		
		//TEXTAREA de la consola
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 111, 360, 192);
		PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
		System.setOut(printStream);
		System.setErr(printStream);

		contentPane.add(textArea);
		
		JButton btnNewButton_3_1 = new JButton("Apps instaladas");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ADB.installedApps();
			}
		});
		btnNewButton_3_1.setBounds(382, 211, 123, 23);
		contentPane.add(btnNewButton_3_1);
	}
}
