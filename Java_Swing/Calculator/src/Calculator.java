import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Calculator extends JFrame {

	private JPanel contentPane;
	private JTextField input;
	private double answer,number;
	int operation;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
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
	public void addInput(String str) {
		input.setText(input.getText() + str);
	}
	
	public void calculate(){
		switch(operation) {
		case 1:
			answer = number + Double.parseDouble(input.getText());
			input.setText(Double.toString(answer));
			break;
		case 2:
			answer = number - Double.parseDouble(input.getText());
			input.setText(Double.toString(answer));
			break;
		case 3:
			answer = number * Double.parseDouble(input.getText());
			input.setText(Double.toString(answer));
			break;
		case 4:
			if (Double.parseDouble(input.getText()) == 0.0) {
				JOptionPane.showMessageDialog(contentPane, "Number cannot be divided by zero");
				input.setText("");
				break;
			}
			answer = number / Double.parseDouble(input.getText());
			input.setText(Double.toString(answer));
			break;
		}
	}
	
	
	public Calculator() {
		setType(Type.UTILITY);
		setTitle("Calculator");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel screen = new JPanel();
		screen.setBounds(10, 11, 414, 60);
		contentPane.add(screen);
		screen.setLayout(null);
		
		input = new JTextField();
		input.setForeground(Color.WHITE);
		input.setBackground(Color.GRAY);
		input.setEditable(false);
		input.setHorizontalAlignment(SwingConstants.RIGHT);
		input.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		input.setBounds(0, 22, 414, 38);
		screen.add(input);
		input.setColumns(10);
		
		JLabel lbl = new JLabel("");
		lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		lbl.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl.setBounds(0, 0, 414, 14);
		screen.add(lbl);
		
		JPanel control = new JPanel();
		control.setBounds(10, 92, 414, 404);
		contentPane.add(control);
		control.setLayout(new GridLayout(4, 4, 20, 20));
		
		JButton btnNewButton_1 = new JButton("7");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		control.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("8");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.GRAY);
		btnNewButton_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		control.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("9");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.GRAY);
		btnNewButton_3.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		control.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("+");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = Double.parseDouble(input.getText());
				operation = 1;
				input.setText("");
				lbl.setText(number + e.getActionCommand());
			}
		});
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBackground(Color.GRAY);
		btnNewButton_4.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		control.add(btnNewButton_4);
		
		JButton btnNewButton_4_1 = new JButton("4");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		btnNewButton_4_1.setForeground(Color.WHITE);
		btnNewButton_4_1.setBackground(Color.GRAY);
		btnNewButton_4_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		control.add(btnNewButton_4_1);
		
		JButton btnNewButton = new JButton("5");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		control.add(btnNewButton);
		
		JButton btnNewButton_6 = new JButton("6");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		btnNewButton_6.setForeground(Color.WHITE);
		btnNewButton_6.setBackground(Color.GRAY);
		btnNewButton_6.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		control.add(btnNewButton_6);
		
		JButton btnNewButton_5 = new JButton("-");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = Double.parseDouble(input.getText());
				operation = 2;
				input.setText("");
				lbl.setText(number + e.getActionCommand());
			}
		});
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBackground(Color.GRAY);
		btnNewButton_5.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		control.add(btnNewButton_5);
		
		JButton btnNewButton_9 = new JButton("1");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		btnNewButton_9.setForeground(Color.WHITE);
		btnNewButton_9.setBackground(Color.GRAY);
		btnNewButton_9.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		control.add(btnNewButton_9);
		
		JButton btnNewButton_7 = new JButton("2");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		btnNewButton_7.setForeground(Color.WHITE);
		btnNewButton_7.setBackground(Color.GRAY);
		btnNewButton_7.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		control.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("3");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		btnNewButton_8.setForeground(Color.WHITE);
		btnNewButton_8.setBackground(Color.GRAY);
		btnNewButton_8.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		control.add(btnNewButton_8);
		
		JButton btnNewButton_10 = new JButton("*");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = Double.parseDouble(input.getText());
				operation = 3;
				input.setText("");
				lbl.setText(number + e.getActionCommand());
			}
		});
		btnNewButton_10.setForeground(Color.WHITE);
		btnNewButton_10.setBackground(Color.GRAY);
		btnNewButton_10.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		control.add(btnNewButton_10);
		
		JButton btnC = new JButton("0");
		btnC.setForeground(new Color(255, 255, 255));
		btnC.setBackground(Color.GRAY);
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		btnC.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		control.add(btnC);
		
		JButton btnNewButton_4_2 = new JButton("C");
		btnNewButton_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input.setText("");
			}
		});
		btnNewButton_4_2.setForeground(Color.WHITE);
		btnNewButton_4_2.setBackground(Color.GRAY);
		btnNewButton_4_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		control.add(btnNewButton_4_2);
		
		JButton btnNewButton_4_3 = new JButton("=");
		btnNewButton_4_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate();
				lbl.setText("");
			}
		});
		btnNewButton_4_3.setForeground(Color.WHITE);
		btnNewButton_4_3.setBackground(Color.GRAY);
		btnNewButton_4_3.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		control.add(btnNewButton_4_3);
		
		JButton btnNewButton_4_4 = new JButton("/");
		btnNewButton_4_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = Double.parseDouble(input.getText());
				operation = 4;
				input.setText("");
				lbl.setText(number + e.getActionCommand());
			}
		});
		btnNewButton_4_4.setForeground(Color.WHITE);
		btnNewButton_4_4.setBackground(Color.GRAY);
		btnNewButton_4_4.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		control.add(btnNewButton_4_4);
	}
}
