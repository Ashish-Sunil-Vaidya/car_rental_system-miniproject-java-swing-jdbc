import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.sql.*;

public class ResetPassword extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField resetemail;
	private JPasswordField resetPassword;
	private JPasswordField confirmPassword;
	private JButton resetButton,backButton;
	private JLabel resetUsernameLabel,resetPasswordLabel,confirmPasswordLabel;

	public static void main(String[] args) {
		new ResetPassword();
	}

	public ResetPassword() {
		setTitle("Reset Password");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 388);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		resetUsernameLabel = new JLabel("Username");
		resetUsernameLabel.setForeground(Color.WHITE);
		resetUsernameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		resetemail = new JTextField("");
		resetemail.setBackground(Color.LIGHT_GRAY);
		resetemail.setHorizontalAlignment(SwingConstants.CENTER);
		resetemail.setFont(new Font("Tahoma", Font.BOLD, 13));
		resetemail.setColumns(10);
		
		resetPasswordLabel = new JLabel("New Password");
		resetPasswordLabel.setForeground(Color.WHITE);
		resetPasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		confirmPasswordLabel = new JLabel("Confirm Password");
		confirmPasswordLabel.setForeground(Color.WHITE);
		confirmPasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		resetPassword = new JPasswordField("");
		resetPassword.setBackground(Color.LIGHT_GRAY);
		resetPassword.setHorizontalAlignment(SwingConstants.CENTER);
		resetPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		confirmPassword = new JPasswordField("");
		confirmPassword.setBackground(Color.LIGHT_GRAY);
		confirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
		confirmPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		resetButton = new JButton("Reset\r\n");
		resetButton.setBorder(null);
		resetButton.setBackground(Color.CYAN);
		resetButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		resetButton.addActionListener(this);

		ImageIcon backpng = new ImageIcon(getClass().getResource("backIcon.png"));
	
		backButton = new JButton(backpng);
		backButton.setBackground(Color.DARK_GRAY);
		backButton.setBorder(null);
		backButton.addActionListener(this);
		backButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(172)
					.addComponent(resetButton, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
					.addGap(162))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(449, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(confirmPasswordLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(confirmPassword, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(resetPasswordLabel)
								.addComponent(resetUsernameLabel, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(resetPassword)
								.addComponent(resetemail, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))))
					.addGap(30))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(resetUsernameLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(resetemail, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(resetPasswordLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(resetPassword, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(confirmPassword, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addComponent(confirmPasswordLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(11, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		backButton.addActionListener(this);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String username = resetemail.getText();
		String rspass = resetPassword.getText();
		String rsconfpass = confirmPassword.getText();
		
		if(e.getSource() == resetButton)
		{
			if(rsconfpass.equals("") || rspass.equals("") || username.equals(""))
			{
				JOptionPane.showMessageDialog(this,"Field(s) Empty complete all field(s)");
			}
			else if(rspass.equals(rsconfpass))
			{
			try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsales", "root",
						"root")) {
					Statement stmt = conn.createStatement();
					String query = "UPDATE logindetails"+" SET passwrd='"+rspass+"'"+" WHERE Username='"+username+"' ";
					stmt.executeUpdate(query);
		
					JOptionPane.showMessageDialog(this,"You have succefully updated your password!!");
					dispose();
					new LoginPage();

					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			dispose();
		}
		}

		if(e.getSource() == backButton)
		{
			dispose();
			new LoginPage();
		}
		
	}

}
