import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.*;
import java.sql.*;

public class LoginPage extends JFrame implements ActionListener{

	private JPanel mainContainer;
	public JTextField emailField;
	private JPasswordField password;
	JLabel emailLabel,passwordLabel,warning,lblNewLabel;
	JButton loginButton,signinButton,resetButton;
	String emailValue,passValue;
	

	public static void main(String[] args) {
		new LoginPage();
	}

	
	public LoginPage() {

		setTitle("Login or Create");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 348, 450);
		mainContainer = new JPanel();
		mainContainer.setBackground(Color.DARK_GRAY);
		mainContainer.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(mainContainer);
		
		emailLabel = new JLabel("Username");
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		emailField = new JTextField();
		emailField.setHorizontalAlignment(SwingConstants.CENTER);
		emailField.setBackground(Color.LIGHT_GRAY);
		emailField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		emailField.setColumns(17);
		
		passwordLabel = new JLabel("Password ");
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		password = new JPasswordField();
		password.setBackground(Color.LIGHT_GRAY);
		password.setColumns(15);
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		loginButton = new JButton("Login");
		loginButton.setBorder(null);
		loginButton.setBackground(Color.GREEN);
		loginButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		signinButton = new JButton("Signin");
		signinButton.setBackground(Color.CYAN);
		signinButton.setBorder(null);
		signinButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		warning = new JLabel("");
		warning.setHorizontalAlignment(SwingConstants.CENTER);
		warning.setForeground(new Color(255, 0, 0));
		
		lblNewLabel = new JLabel("Forgot Password?");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		resetButton = new JButton("Reset");
		resetButton.setBorder(null);
		resetButton.setBackground(Color.PINK);
		resetButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		
		GroupLayout gl_mainContainer = new GroupLayout(mainContainer);
		gl_mainContainer.setHorizontalGroup(
			gl_mainContainer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainContainer.createSequentialGroup()
					.addGap(69)
					.addGroup(gl_mainContainer.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
						.addGroup(gl_mainContainer.createSequentialGroup()
							.addComponent(loginButton, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(signinButton, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)))
					.addGap(75))
				.addGroup(gl_mainContainer.createSequentialGroup()
					.addGap(106)
					.addComponent(resetButton, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
					.addGap(107))
				.addGroup(gl_mainContainer.createSequentialGroup()
					.addGap(96)
					.addComponent(emailLabel, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
					.addGap(99))
				.addGroup(gl_mainContainer.createSequentialGroup()
					.addGap(16)
					.addGroup(gl_mainContainer.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_mainContainer.createSequentialGroup()
							.addComponent(emailField, GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
							.addGap(19))
						.addGroup(gl_mainContainer.createSequentialGroup()
							.addComponent(password)
							.addGap(17))))
				.addGroup(Alignment.TRAILING, gl_mainContainer.createSequentialGroup()
					.addGap(119)
					.addComponent(passwordLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(115))
		);
		gl_mainContainer.setVerticalGroup(
			gl_mainContainer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainContainer.createSequentialGroup()
					.addGap(19)
					.addComponent(emailLabel, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(emailField, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(password, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_mainContainer.createParallelGroup(Alignment.LEADING)
						.addComponent(loginButton, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
						.addComponent(signinButton, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
					.addGap(18))
		);
		resetButton.addActionListener(this);
		loginButton.addActionListener(this);
		signinButton.addActionListener(this);
		
		mainContainer.setLayout(gl_mainContainer);
		setVisible(true);
	}

	public String getUserName(String u)
	{
		return emailField.getText();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource() == loginButton) {
			try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsales","root","root")) {
				String userValue = emailField.getText();
				String passValue = password.getText();
				try (Statement stmt = conn.createStatement()) {
					String query1 = "SELECT * FROM logindetails WHERE Username ='"+userValue+"' AND passwrd='"+passValue+"'";
					
					ResultSet rs = stmt.executeQuery(query1);
			
					
					if(rs.next())
					{
						dispose();
						MainPage main = new MainPage();
						main.username = userValue;
						main.fname = rs.getString("FirstName");
						main.lname = rs.getString("LastName");
						main.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(this, "Wrong email Id or Password");
						password.setText("");
					}
					
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if(e.getSource() == resetButton)
		{
			new ResetPassword();
		}

		if(e.getSource() == signinButton)
		{
			dispose();
			new SiginPage();
		}


	}
}
