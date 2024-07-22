package crud;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.CopyOnWriteArrayList;

class ErrorFrame {
	public ErrorFrame() {
		JFrame fr1 = new JFrame("Error");
		fr1.setVisible(true);
		fr1.setSize(300, 200);
		fr1.setLayout(null);

		JLabel l = new JLabel("Data not Found");
		l.setBounds(50, 50, 120, 20);
		fr1.add(l);
	}
}

class swing1 implements ActionListener{
	JLabel l1, l2, l3, l4,l5;
	JTextField t1, t3, t2, t4,t5;
	JButton b1, b2, b3, b4;
	
	public swing1() {
		JFrame fr = new JFrame("My Swing Example");
		fr.setVisible(true);
		fr.setSize(700, 500);
		fr.setLayout(null);

		l1 = new JLabel("Id : ");
		l1.setBounds(100, 100, 120, 20);
		fr.add(l1);

		l2 = new JLabel("FirstName : ");
		l2.setBounds(100, 130, 120, 20);
		fr.add(l2);
		
		l3 = new JLabel("LastName : ");
		l3.setBounds(100, 160, 120, 20);
		fr.add(l3);
		
		l4 = new JLabel("Email : ");
		l4.setBounds(100, 190, 120, 20);
		fr.add(l4);

		l5 = new JLabel("Mobile : ");
		l5.setBounds(100, 220, 120, 20);
		fr.add(l5);

		t1 = new JTextField();
		t1.setBounds(180, 100, 120, 20);
		fr.add(t1);

		t2 = new JTextField();
		t2.setBounds(180, 130, 120, 20);
		fr.add(t2);

		t3 = new JTextField();
		t3.setBounds(180, 160, 120, 20);
		fr.add(t3);

		t4 = new JTextField();
		t4.setBounds(180, 190, 120, 20);
		fr.add(t4);
		
		t5 = new JTextField();
		t5.setBounds(180, 220, 120, 20);
		fr.add(t5);

		b1 = new JButton("Insert");
		b1.setBounds(100, 260, 130, 20);
		fr.add(b1);
		b2 = new JButton("Search");
		b2.setBounds(250, 260, 130, 20);
		fr.add(b2);
		b3 = new JButton("Update");
		b3.setBounds(100, 290, 130, 20);
		fr.add(b3);
		b4 = new JButton("Delete");
		b4.setBounds(250, 290, 130, 20);
		fr.add(b4);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
	}
	public static Connection createConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_assessment", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == b1) {
		System.out.println("insert button clicked");
		
		String Firstname = t2.getText();
		String Lastname=t3.getText();
		String Email = t4.getText();
		long Mobile = Long.parseLong(t5.getText());
		
		System.out.println( Firstname + Lastname + Email + Mobile);
		try {
			Connection conn = swing1.createConnection();
			String sql = "insert into example (Firstname,Lastname,Email,Mobile) values(?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, Firstname);
			pst.setString(2, Lastname);
			pst.setString(3, Email);
			pst.setLong(4,Mobile);
			
			pst.executeUpdate();
			System.out.println("data inserted successfully");
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	} else if (e.getSource() == b2) {
		System.out.println("search button clicked");
		int id = Integer.parseInt(t1.getText());
		try {
			Connection conn = swing1.createConnection();
			String sql = "select * from example where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				t1.setText(String.valueOf(rs.getInt("id")));
				t2.setText(rs.getString("Firstname"));
				t3.setText(rs.getString("Lastname"));
				t4.setText(rs.getString("Email"));
				t5.setText(String.valueOf(rs.getLong("Mobile")));
				
				
			} else {
				System.out.println("data not founnd");
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				new ErrorFrame();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	} else if (e.getSource() == b3) {
		System.out.println("update button clicked");
		int id = Integer.parseInt(t1.getText());
		String Firstname = t2.getText();
		String Lastname=t3.getText();
		String Email = t4.getText();
		long Mobile = Long.parseLong(t5.getText());
		try {
			Connection conn = swing1.createConnection();
			String sql = "update example set Firstname=?,Lastname=?,Email=?,Mobile=? where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, Firstname);
			pst.setString(2, Lastname);
			pst.setString(3, Email);
			pst.setLong(4, Mobile);
			pst.setInt(5, id);
			pst.executeUpdate();
			System.out.println("data updated");
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
		} catch (Exception e2) {
			e2.printStackTrace();
		}

	} else if (e.getSource() == b4) {
		System.out.println("delete button clicked");
		int id = Integer.parseInt(t1.getText());
		try {
			Connection conn = swing1.createConnection();
			String sql = "delete from example where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			System.out.println("data deleted");
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}
}
public class assessment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new swing1();

	}

}
