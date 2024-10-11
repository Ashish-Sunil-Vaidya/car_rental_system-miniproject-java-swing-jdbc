import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import java.awt.event.*;

public class MainPage extends JFrame implements ActionListener{
	
	
	private JPanel contentPane;
	private JTextField textCar_Model;
	private JTextField textCapacity;
	private JTextField textFieldPrice;
	private JTextField textSeat;
	private JTextField textFieldDriving_Range;
	private JTextField textCarNo;
	private JTextField textTax;
	private JTextField textDiscount;
	private JButton btnSave;
	public String username;
	public String fname;
	public String lname;
	private JTextArea textArea;
	public static void main(String[] args) {
		new MainPage();
	}

	/**
	 * Create the frame.
	 */
	public MainPage() {
		setAlwaysOnTop(true);
		setTitle("Car Register Tool");
		setBackground(SystemColor.controlText);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 941, 758);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Car  Sales");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Century Schoolbook", Font.BOLD, 46));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(260, 10, 420, 56);
		contentPane.add(lblNewLabel);

		JLabel lblCarModel = new JLabel("Car Model\r\n");
		lblCarModel.setVerticalAlignment(SwingConstants.TOP);
		lblCarModel.setBackground(SystemColor.text);
		lblCarModel.setForeground(Color.GREEN);
		lblCarModel.setFont(new Font("Cambria", Font.PLAIN, 25));
		lblCarModel.setBounds(26, 150, 112, 48);
		contentPane.add(lblCarModel);

		JLabel lblCapacity = new JLabel("Capacity ");
		lblCapacity.setForeground(Color.GREEN);
		lblCapacity.setFont(new Font("Cambria", Font.PLAIN, 25));
		lblCapacity.setHorizontalAlignment(SwingConstants.LEFT);
		lblCapacity.setBounds(24, 264, 96, 48);
		contentPane.add(lblCapacity);

		JLabel lblPrice = new JLabel("Price   ");
		lblPrice.setForeground(Color.GREEN);
		lblPrice.setFont(new Font("Cambria", Font.PLAIN, 25));
		lblPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice.setBounds(24, 322, 77, 42);
		contentPane.add(lblPrice);

		JLabel lblEngine = new JLabel("Seats");
		lblEngine.setForeground(Color.GREEN);
		lblEngine.setFont(new Font("Cambria", Font.PLAIN, 25));
		lblEngine.setHorizontalAlignment(SwingConstants.LEFT);
		lblEngine.setBounds(26, 383, 62, 48);
		contentPane.add(lblEngine);

		JLabel lblDrivingRang = new JLabel("Driving range");
		lblDrivingRang.setForeground(Color.GREEN);
		lblDrivingRang.setFont(new Font("Cambria", Font.PLAIN, 25));
		lblDrivingRang.setHorizontalAlignment(SwingConstants.LEFT);
		lblDrivingRang.setBounds(24, 448, 149, 48);
		contentPane.add(lblDrivingRang);

		textCar_Model = new JTextField("");
		textCar_Model.setForeground(new Color(51, 0, 0));
		textCar_Model.setBackground(new Color(255, 255, 153));
		textCar_Model.setFont(new Font("Serif", Font.PLAIN, 25));
		textCar_Model.setBounds(200, 147, 232, 34);
		contentPane.add(textCar_Model);
		textCar_Model.setColumns(10);

		textCapacity = new JTextField("");
		textCapacity.setForeground(new Color(51, 0, 0));
		textCapacity.setBackground(new Color(255, 255, 153));
		textCapacity.setFont(new Font("Serif", Font.PLAIN, 25));
		textCapacity.setColumns(10);
		textCapacity.setBounds(200, 270, 232, 34);
		contentPane.add(textCapacity);

		textFieldPrice = new JTextField("");
		textFieldPrice.setForeground(new Color(51, 0, 0));
		textFieldPrice.setBackground(new Color(255, 255, 153));
		textFieldPrice.setFont(new Font("Serif", Font.PLAIN, 25));
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(200, 325, 232, 34);
		contentPane.add(textFieldPrice);

		textSeat = new JTextField("");
		textSeat.setForeground(new Color(51, 0, 0));
		textSeat.setBackground(new Color(255, 255, 153));
		textSeat.setFont(new Font("Serif", Font.PLAIN, 25));
		textSeat.setColumns(10);
		textSeat.setBounds(200, 389, 125, 34);
		contentPane.add(textSeat);

		textFieldDriving_Range = new JTextField("");
		textFieldDriving_Range.setForeground(new Color(51, 0, 0));
		textFieldDriving_Range.setBackground(new Color(255, 255, 153));
		textFieldDriving_Range.setFont(new Font("Serif", Font.PLAIN, 25));
		textFieldDriving_Range.setColumns(10);
		textFieldDriving_Range.setBounds(200, 454, 232, 34);
		contentPane.add(textFieldDriving_Range);

		btnSave = new JButton("Save");
		btnSave.setForeground(new Color(0, 102, 0));
		btnSave.setFont(new Font("Mongolian Baiti", Font.PLAIN, 26));
		btnSave.setBounds(395, 649, 149, 48);
		contentPane.add(btnSave);

		textCarNo = new JTextField("");
		textCarNo.setForeground(new Color(51, 0, 0));
		textCarNo.setFont(new Font("Serif", Font.PLAIN, 25));
		textCarNo.setColumns(10);
		textCarNo.setBackground(new Color(255, 255, 153));
		textCarNo.setBounds(200, 202, 125, 34);
		contentPane.add(textCarNo);

		JLabel lblIndexNo = new JLabel("Car No");
		lblIndexNo.setVerticalAlignment(SwingConstants.TOP);
		lblIndexNo.setForeground(Color.GREEN);
		lblIndexNo.setFont(new Font("Cambria", Font.PLAIN, 25));
		lblIndexNo.setBackground(Color.WHITE);
		lblIndexNo.setBounds(24, 205, 77, 49);
		contentPane.add(lblIndexNo);

		JLabel lblPrice_1 = new JLabel(":");
		lblPrice_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice_1.setForeground(Color.GREEN);
		lblPrice_1.setFont(new Font("Cambria", Font.PLAIN, 35));
		lblPrice_1.setBounds(127, 140, 46, 42);
		contentPane.add(lblPrice_1);

		JLabel lblPrice_1_1 = new JLabel(":");
		lblPrice_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice_1_1.setForeground(Color.GREEN);
		lblPrice_1_1.setFont(new Font("Cambria", Font.PLAIN, 35));
		lblPrice_1_1.setBounds(83, 195, 46, 42);
		contentPane.add(lblPrice_1_1);

		JLabel lblPrice_1_1_1 = new JLabel(":");
		lblPrice_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice_1_1_1.setForeground(Color.GREEN);
		lblPrice_1_1_1.setFont(new Font("Cambria", Font.PLAIN, 35));
		lblPrice_1_1_1.setBounds(100, 263, 46, 42);
		contentPane.add(lblPrice_1_1_1);

		JLabel lblPrice_1_1_2 = new JLabel(":");
		lblPrice_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice_1_1_2.setForeground(Color.GREEN);
		lblPrice_1_1_2.setFont(new Font("Cambria", Font.PLAIN, 35));
		lblPrice_1_1_2.setBounds(64, 318, 46, 42);
		contentPane.add(lblPrice_1_1_2);

		JLabel lblPrice_1_1_3 = new JLabel(":");
		lblPrice_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice_1_1_3.setForeground(Color.GREEN);
		lblPrice_1_1_3.setFont(new Font("Cambria", Font.PLAIN, 35));
		lblPrice_1_1_3.setBounds(74, 382, 46, 42);
		contentPane.add(lblPrice_1_1_3);

		JLabel lblPrice_1_1_4 = new JLabel(":");
		lblPrice_1_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice_1_1_4.setForeground(Color.GREEN);
		lblPrice_1_1_4.setFont(new Font("Cambria", Font.PLAIN, 35));
		lblPrice_1_1_4.setBounds(157, 447, 46, 42);
		contentPane.add(lblPrice_1_1_4);

		JLabel lblPrice_2 = new JLabel("Tax");
		lblPrice_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice_2.setForeground(Color.GREEN);
		lblPrice_2.setFont(new Font("Cambria", Font.PLAIN, 25));
		lblPrice_2.setBounds(26, 506, 46, 42);
		contentPane.add(lblPrice_2);

		JLabel lblPrice_1_1_4_1 = new JLabel(":");
		lblPrice_1_1_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice_1_1_4_1.setForeground(Color.GREEN);
		lblPrice_1_1_4_1.setFont(new Font("Cambria", Font.PLAIN, 35));
		lblPrice_1_1_4_1.setBounds(110, 554, 46, 42);
		contentPane.add(lblPrice_1_1_4_1);

		textTax = new JTextField("");
		textTax.setForeground(new Color(51, 0, 0));
		textTax.setFont(new Font("Serif", Font.PLAIN, 25));
		textTax.setColumns(10);
		textTax.setBackground(new Color(255, 255, 153));
		textTax.setBounds(200, 509, 232, 34);
		contentPane.add(textTax);

		JLabel lblPrice_2_1 = new JLabel("Discount");
		lblPrice_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice_2_1.setForeground(Color.GREEN);
		lblPrice_2_1.setFont(new Font("Cambria", Font.PLAIN, 25));
		lblPrice_2_1.setBounds(24, 558, 103, 42);
		contentPane.add(lblPrice_2_1);

		JLabel lblPrice_1_1_4_1_1 = new JLabel(":");
		lblPrice_1_1_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice_1_1_4_1_1.setForeground(Color.GREEN);
		lblPrice_1_1_4_1_1.setFont(new Font("Cambria", Font.PLAIN, 35));
		lblPrice_1_1_4_1_1.setBounds(53, 502, 46, 42);
		contentPane.add(lblPrice_1_1_4_1_1);

		textDiscount = new JTextField("");
		textDiscount.setForeground(new Color(51, 0, 0));
		textDiscount.setFont(new Font("Serif", Font.PLAIN, 25));
		textDiscount.setColumns(10);
		textDiscount.setBackground(new Color(255, 255, 153));
		textDiscount.setBounds(200, 561, 232, 34);
		contentPane.add(textDiscount);

		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.BOLD, 18));
		textArea.setBounds(471, 76, 427, 536);
		textArea.setEditable(false);
		contentPane.add(textArea);
		btnSave.addActionListener(this);
		setResizable(false);

		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		

		String car_model = textCar_Model.getText();
		String car_no = textCarNo.getText();
		String capacity= textCapacity.getText();
		String price = textFieldPrice.getText();
		String seats = textSeat.getText();
		String driving_range = textFieldDriving_Range.getText();
		String tax = textTax.getText();
		String discount = textDiscount.getText();

		if(e.getSource() == btnSave){
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsales", "root", "root")) {
			


			PreparedStatement p = conn.prepareStatement("UPDATE logindetails SET Car_Model = ?, Car_No =?, Capacity=?, Price =?,Seats=?,Driving_Range=?,Tax=?,Discount=? WHERE Username = ?;");
			p.setString(1, car_model);
			p.setString(2, car_no);
			p.setString(3, capacity);
			p.setString(4, price);
			p.setString(5, seats);
			p.setString(6, driving_range);
			p.setString(7, tax);
			p.setString(8, discount);
			p.setString(9, username);
			if(car_model.equals("") || car_no.equals("") || capacity.equals("") || price.equals("") || seats.equals("")|| driving_range.equals("") || tax.equals("") || discount.equals(""))
			{
				JOptionPane.showMessageDialog(this,"Field(s) Empty complete all field(s)");
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Details saved Succesfully!!");
				textArea.setText("**************************************"+"\n"+"     CAR SALES MANAGEMENT PROJECT"+"\n"+"**************************************"+"\n\n"+"  Your FullName: "+fname+" "+lname+"\n\n"+"  Car Model: "+car_model+"\n\n"+"  Car No: "+car_no+"\n\n"+"  capacity: "+capacity+" ltrs\n\n"+"  Price: "+price+" Rs\n\n"+"  Seats: "+seats+"\n\n"+"  Driving Range: "+driving_range+" kms\n\n"+"  Tax: "+tax+" %GST\n\n"+"  Discount: "+discount+"%");
			}

			

			p.executeUpdate();
			conn.close();
	
						
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
	}
}
}
