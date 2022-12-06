package View;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import Helper.*;
import Model.HeadDoctor;

public class LoginGUI extends JFrame {

	private JPanel w_pane;
	private JTextField fld_patientId;
	private JTextField fld_doctorId;
	private JPasswordField fld_passDoc;
	private JPasswordField fld_passPat;
	private DBConnection conn = new DBConnection();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("Hospital Automation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		w_pane = new JPanel();
		w_pane.setBackground(Color.WHITE);
		w_pane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(w_pane);
		w_pane.setLayout(null);

		JLabel lbl_logo = new JLabel(new ImageIcon(getClass().getResource("logo.png")));
		lbl_logo.setBounds(160, -12, 152, 120);
		w_pane.add(lbl_logo);

		JLabel lblNewLabel = new JLabel("Welcome to Hospital Automation");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblNewLabel.setBounds(98, 96, 279, 40);
		w_pane.add(lblNewLabel);

		JTabbedPane w_tabpane = new JTabbedPane(JTabbedPane.TOP);
		w_tabpane.setBounds(10, 134, 464, 216);
		w_pane.add(w_tabpane);

		JPanel w_patient = new JPanel();
		w_patient.setBackground(Color.WHITE);
		w_tabpane.addTab("Patient", null, w_patient, null);
		w_patient.setLayout(null);

		JLabel lblIdNumber = new JLabel("ID Number : ");
		lblIdNumber.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblIdNumber.setBounds(10, 11, 88, 40);
		w_patient.add(lblIdNumber);

		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblPassword.setBounds(10, 68, 82, 40);
		w_patient.add(lblPassword);

		fld_patientId = new JTextField();
		fld_patientId.setBounds(108, 24, 166, 20);
		w_patient.add(fld_patientId);
		fld_patientId.setColumns(10);

		JButton btn_pLogin = new JButton("Login");
		btn_pLogin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btn_pLogin.setBounds(25, 136, 166, 41);
		w_patient.add(btn_pLogin);

		JButton btn_register = new JButton("Register");
		btn_register.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btn_register.setBounds(237, 136, 166, 41);
		w_patient.add(btn_register);

		fld_passPat = new JPasswordField();
		fld_passPat.setBounds(108, 81, 166, 20);
		w_patient.add(fld_passPat);

		JPanel w_doctor = new JPanel();
		w_doctor.setBackground(Color.WHITE);
		w_tabpane.addTab("Doctor", null, w_doctor, null);
		w_doctor.setLayout(null);

		JLabel lblIdNumber_1 = new JLabel("ID Number : ");
		lblIdNumber_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblIdNumber_1.setBounds(10, 11, 88, 40);
		w_doctor.add(lblIdNumber_1);

		fld_doctorId = new JTextField();
		fld_doctorId.setColumns(10);
		fld_doctorId.setBounds(108, 24, 166, 20);
		w_doctor.add(fld_doctorId);

		JLabel lblPassword_1 = new JLabel("Password : ");
		lblPassword_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblPassword_1.setBounds(10, 68, 82, 40);
		w_doctor.add(lblPassword_1);

		JButton btn_Dlogin = new JButton("Login");
		btn_Dlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fld_doctorId.getText().length() == 0 || fld_passDoc.getText().length() == 0) {
					Helper.showMsg("fill");
				}
				else {
					try {
						Connection con = conn.connDb();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM user");
						while (rs.next()) {
							if (fld_doctorId.getText().equals(rs.getString("tcno")) && fld_passDoc.getText().equals(rs.getString("password"))) {
								HeadDoctor hdoc = new HeadDoctor();
								hdoc.setId(rs.getInt("id"));
								hdoc.setName(rs.getString("name"));
								hdoc.setPassword("password");
								hdoc.setTcno(rs.getString("tcno"));
								hdoc.setType(rs.getString("type"));
								HeadDoctorGUI hGUI = new HeadDoctorGUI(hdoc);
								hGUI.setVisible(true);
								dispose();
								
							}
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		btn_Dlogin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btn_Dlogin.setBounds(25, 136, 424, 41);
		w_doctor.add(btn_Dlogin);

		fld_passDoc = new JPasswordField();
		fld_passDoc.setBounds(108, 81, 166, 20);
		w_doctor.add(fld_passDoc);

		UIManager.put("TabbedPane.unselectedForeground", Color.white);
		UIManager.put("TabbedPane.selected", Color.white);
	}
}
