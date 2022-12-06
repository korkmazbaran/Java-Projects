package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import Helper.*;
import Model.*;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HeadDoctorGUI extends JFrame {
	static HeadDoctor headdoctor = new HeadDoctor();
	Clinic clinic = new Clinic();

	private JPanel w_pane;
	private JTextField fld_name;
	private JTextField fld_Id;
	private JTextField fld_userId;
	private JPasswordField fld_pass;
	private JTable table_doctor;
	private DefaultTableModel doctorModel = null;
	private Object[] doctorData = null;
	private JTable table_clinic;
	private JTextField fld_clinicName;
	private DefaultTableModel clinicModel = null;
	private Object[] clinicData = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HeadDoctorGUI frame = new HeadDoctorGUI(headdoctor);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public HeadDoctorGUI(HeadDoctor headdoctor) throws SQLException {

		//Doctor Model
		doctorModel = new DefaultTableModel();
		Object[] colDoctorName = new Object[4];
		colDoctorName[0] = "ID";
		colDoctorName[1] = "Name and Surname";
		colDoctorName[2] = "ID Number";
		colDoctorName[3] = "Password";
		doctorModel.setColumnIdentifiers(colDoctorName);
		doctorData = new Object[4];
		for (int i = 0; i < headdoctor.getDoctorList().size(); i++) {
			doctorData[0] = headdoctor.getDoctorList().get(i).getId();
			doctorData[1] = headdoctor.getDoctorList().get(i).getName();
			doctorData[2] = headdoctor.getDoctorList().get(i).getTcno();
			doctorData[3] = headdoctor.getDoctorList().get(i).getPassword();
			doctorModel.addRow(doctorData);
		}
		
		//Clinic Model
		clinicModel = new DefaultTableModel();
		Object[] colClinicName = new Object[2];
		colClinicName[0] = "ID";
		colClinicName[1] = "Clinic Name";
		clinicModel.setColumnIdentifiers(colClinicName);
		clinicData = new Object[4];
		for (int i = 0; i < clinic.getClinicList().size(); i++) {
			clinicData[0] = clinic.getClinicList().get(i).getId();
			clinicData[1] = clinic.getClinicList().get(i).getName();
			clinicModel.addRow(clinicData); 
		}
		

		setTitle("Hospital Automation");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		w_pane = new JPanel();
		w_pane.setBackground(Color.WHITE);
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(w_pane);
		w_pane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Welcome" + headdoctor.getName());
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 11, 138, 24);
		w_pane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		btnNewButton.setBounds(603, 15, 121, 23);
		w_pane.add(btnNewButton);

		JTabbedPane w_tabPane = new JTabbedPane(JTabbedPane.TOP);
		w_tabPane.setBounds(10, 46, 714, 404);
		w_pane.add(w_tabPane);

		JPanel panel_doctor = new JPanel();
		panel_doctor.setBackground(Color.WHITE);
		w_tabPane.addTab("Doctor Management", null, panel_doctor, null);
		panel_doctor.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Name Surmame");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(475, 11, 132, 21);
		panel_doctor.add(lblNewLabel_1);

		fld_name = new JTextField();
		fld_name.setBounds(475, 40, 202, 20);
		panel_doctor.add(fld_name);
		fld_name.setColumns(10);

		fld_Id = new JTextField();
		fld_Id.setColumns(10);
		fld_Id.setBounds(475, 100, 202, 20);
		panel_doctor.add(fld_Id);

		JLabel lblNewLabel_1_1 = new JLabel("ID Number");
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(475, 71, 132, 21);
		panel_doctor.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(475, 131, 132, 21);
		panel_doctor.add(lblNewLabel_1_1_1);

		JButton btn_add = new JButton("Add");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fld_name.getText().length() == 0 || fld_Id.getText().length() == 0
						|| fld_pass.getText().length() == 0) {
					Helper.showMsg("fill");
				} else {
					try {
						boolean control = headdoctor.addDoctor(fld_name.getText(), fld_Id.getText(),
								fld_pass.getText());
						if (control) {
							Helper.showMsg("success");
							fld_Id.setText(null);
							fld_pass.setText(null);
							fld_name.setText(null);
							updateDoctorModel();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		btn_add.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btn_add.setBounds(475, 191, 202, 31);
		panel_doctor.add(btn_add);

		fld_userId = new JTextField();
		fld_userId.setEditable(false);
		fld_userId.setColumns(10);
		fld_userId.setBounds(475, 290, 202, 20);
		panel_doctor.add(fld_userId);

		JLabel lblNewLabel_1_2 = new JLabel("User ID");
		lblNewLabel_1_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(475, 261, 132, 21);
		panel_doctor.add(lblNewLabel_1_2);

		JButton btn_delete = new JButton("Delete");
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fld_userId.getText().length() == 0 ) {
					Helper.showMsg("Please select a valid doctor");
				}
				else {
					if (Helper.confirm("sure")) {
						int selectId = Integer.parseInt(fld_userId.getText());
						try {
							boolean control = headdoctor.deleteDoctor(selectId);
							if (control) {
								Helper.showMsg("success");
								fld_userId.setText(null);
								updateDoctorModel();
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btn_delete.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btn_delete.setBounds(475, 323, 202, 31);
		panel_doctor.add(btn_delete);

		fld_pass = new JPasswordField();
		fld_pass.setBounds(475, 160, 202, 20);
		panel_doctor.add(fld_pass);

		JScrollPane w_scrollDoctor = new JScrollPane();
		w_scrollDoctor.setBounds(10, 11, 455, 343);
		panel_doctor.add(w_scrollDoctor);

		table_doctor = new JTable(doctorModel);
		w_scrollDoctor.setViewportView(table_doctor);
		

		table_doctor.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				try {
					fld_userId.setText(table_doctor.getValueAt(table_doctor.getSelectedRow(), 0).toString());

				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		table_doctor.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				if (e.getType() == TableModelEvent.UPDATE) {
					int selectID = Integer.parseInt(table_doctor.getValueAt(table_doctor.getSelectedRow(), 0).toString());
					String selectName = table_doctor.getValueAt(table_doctor.getSelectedRow(), 1).toString();
					String selectTcno = table_doctor.getValueAt(table_doctor.getSelectedRow(), 2).toString();
					String selectPassword = table_doctor.getValueAt(table_doctor.getSelectedRow(), 3).toString();
					try {
						boolean control = headdoctor.updateDoctor(selectID, selectName, selectTcno, selectPassword);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		JPanel w_clinic = new JPanel();
		w_clinic.setBackground(Color.WHITE);
		w_tabPane.addTab("Clinic", null, w_clinic, null);
		w_clinic.setLayout(null);
		
		JScrollPane w_scrollClinic = new JScrollPane();
		w_scrollClinic.setBounds(10, 11, 273, 354);
		w_clinic.add(w_scrollClinic);
		
		table_clinic = new JTable(clinicModel);
		w_scrollClinic.setViewportView(table_clinic);
		
		JLabel lblNewLabel_1_3 = new JLabel("Clinic Name");
		lblNewLabel_1_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(293, 11, 132, 21);
		w_clinic.add(lblNewLabel_1_3);
		
		fld_clinicName = new JTextField();
		fld_clinicName.setColumns(10);
		fld_clinicName.setBounds(293, 40, 155, 20);
		w_clinic.add(fld_clinicName);
		
		JButton btn_addClinic = new JButton("Add");
		btn_addClinic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btn_addClinic.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btn_addClinic.setBounds(293, 71, 155, 31);
		w_clinic.add(btn_addClinic);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(457, 11, 242, 354);
		w_clinic.add(scrollPane);
		
	}
	public void updateDoctorModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_doctor.getModel();
		clearModel.setRowCount(0);
		for (int i = 0; i < headdoctor.getDoctorList().size(); i++) {
			doctorData[0] = headdoctor.getDoctorList().get(i).getId();
			doctorData[1] = headdoctor.getDoctorList().get(i).getName();
			doctorData[2] = headdoctor.getDoctorList().get(i).getTcno();
			doctorData[3] = headdoctor.getDoctorList().get(i).getPassword();
			doctorModel.addRow(doctorData);
		}
	}
}
