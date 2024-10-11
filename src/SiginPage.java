import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.*;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.sql.*;
import java.awt.Color;

public class SiginPage extends JFrame implements ActionListener {
	private JTextField firstName;
	private JPasswordField passnew;
	private JPasswordField passconfirm;
	private JTextField lastName;
	private JTextField usernamenew;
	JButton createButton,backButton;

	public static void main(String[] args) {

		new SiginPage();
	}

	public SiginPage() {
		getContentPane().setForeground(Color.YELLOW);
		getContentPane().setBackground(Color.DARK_GRAY);
		setTitle("Create new account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 516);

		JLabel lblNewLabel = new JLabel("Create new Account");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblNewLabel_1_1 = new JLabel("Last Name");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lbl = new JLabel("Username");
		lbl.setForeground(Color.WHITE);
		lbl.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lbl3 = new JLabel("Password");
		lbl3.setForeground(Color.WHITE);
		lbl3.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lbl2 = new JLabel("Confirm Password");
		lbl2.setForeground(Color.WHITE);
		lbl2.setFont(new Font("Tahoma", Font.BOLD, 13));

		firstName = new JTextField("");
		firstName.setHorizontalAlignment(SwingConstants.CENTER);
		firstName.setFont(new Font("Tahoma", Font.BOLD, 15));
		firstName.setColumns(10);

		passnew = new JPasswordField("");
		passnew.setHorizontalAlignment(SwingConstants.CENTER);

		passconfirm = new JPasswordField("");
		passconfirm.setHorizontalAlignment(SwingConstants.CENTER);

		lastName = new JTextField("");
		lastName.setHorizontalAlignment(SwingConstants.CENTER);
		lastName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lastName.setColumns(10);

		usernamenew = new JTextField("");
		usernamenew.setHorizontalAlignment(SwingConstants.CENTER);
		usernamenew.setFont(new Font("Tahoma", Font.BOLD, 15));
		usernamenew.setColumns(10);

		createButton = new JButton("Create");
		createButton.setBackground(Color.GREEN);
		createButton.setBorder(null);
		createButton.setFont(new Font("Tahoma", Font.BOLD, 15));

		ImageIcon backpng = new ImageIcon(getClass().getResource("backIcon.png"));
		
		
	
		backButton = new JButton(backpng);
		backButton.setBackground(Color.DARK_GRAY);
		// backButton.setBackground(Color.DARK_GRAY);
		backButton.setBorder(null);
		backButton.addActionListener(this);
		backButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(95)
					.addComponent(lblNewLabel_1_1)
					.addGap(4)
					.addComponent(lastName, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
					.addGap(135))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(100)
					.addComponent(lbl)
					.addGap(4)
					.addComponent(usernamenew, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
					.addGap(135))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(102)
					.addComponent(lbl3)
					.addGap(4)
					.addComponent(passnew, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
					.addGap(135))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(58)
					.addComponent(lbl2)
					.addGap(4)
					.addComponent(passconfirm, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
					.addGap(135))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(312)
					.addComponent(createButton, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(90)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(firstName, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
					.addGap(135))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
					.addGap(60))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addGap(46)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(4)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
								.addComponent(firstName, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
							.addGap(12)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
								.addComponent(lastName, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(4)
									.addComponent(lbl, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
								.addComponent(usernamenew, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(4)
									.addComponent(lbl3, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
								.addComponent(passnew, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(lbl2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
								.addComponent(passconfirm, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
							.addGap(35)
							.addComponent(createButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(78, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		createButton.addActionListener(this);
		backButton.addActionListener(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == createButton) {
			String fName = firstName.getText();
			String lName = lastName.getText();
			String newuser = usernamenew.getText();
			String newpass = passnew.getText();
			String confpass = passconfirm.getText();
			

			
			if(newpass.equals("") || confpass.equals("") || fName.equals("") || lName.equals(""))
			{
				JOptionPane.showMessageDialog(this,"Field(s) Empty complete all field(s)");
			}

			else if (newpass.equals(confpass)) {
				try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsales", "root",
						"root")) {
					Statement stmt = conn.createStatement();
					String query = "INSERT INTO logindetails" + "(FirstName,LastName,Username,passwrd)" + "VALUES('"
							+ fName + "','" + lName + "','" + newuser + "','" + newpass + "')";
					stmt.executeUpdate(query);
		
					JOptionPane.showMessageDialog(this,"You have succefully created your account!!");
					dispose();
					new LoginPage();

					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Passwords don't match");
				passnew.setText("");
				passconfirm.setText("");
			}
		}
		if(e.getSource() == backButton)
		{
			new LoginPage();
			dispose();
		}

	}

}
