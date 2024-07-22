package crud;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


class swingdemo implements ActionListener{
	JLabel l1, l2, l3, l4;
	JTextField t1, t3, t2, t4;
	JButton b1, b2, b3, b4;

	public swingdemo() {
		JFrame fr = new JFrame("AppName");
		fr.setVisible(true);
		fr.setSize(700, 500);
		fr.setLayout(null);

		l1 = new JLabel("Id : ");
		l1.setBounds(100, 100, 120, 20);
		fr.add(l1);

		l2 = new JLabel("Name : ");
		l2.setBounds(100, 130, 120, 20);
		fr.add(l2);

		l3 = new JLabel("Contact : ");
		l3.setBounds(100, 160, 120, 20);
		fr.add(l3);

		l4 = new JLabel("Email : ");
		l4.setBounds(100, 190, 120, 20);
		fr.add(l4);

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

		b1 = new JButton("Insert");
		b1.setBounds(100, 230, 120, 20);
		fr.add(b1);
		b2 = new JButton("Search");
		b2.setBounds(250, 230, 120, 20);
		fr.add(b2);
		b3 = new JButton("Update");
		b3.setBounds(100, 260, 120, 20);
		fr.add(b3);
		b4 = new JButton("Delete");
		b4.setBounds(250, 260, 120, 20);
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
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub//
		if(e.getSource()==b1)
		{
			System.out.println("indert clicked");
			int id=Integer.parseInt(t1.getText());
			String name=t2.getText();
			long contact=Long.parseLong(t3.getText());
			String email=t4.getText();
			
			System.out.println(id + name + contact + email);
			try {
				  Connection conn=swingdemo.createConnection();
				  String sql="insert into user1(id,name,contact,email) values(?,?,?,?)";
				  PreparedStatement pst=conn.prepareStatement(sql);
				  pst.setInt(1, id);
				  pst.setString(2, name);
				  pst.setLong(3, contact);
				  pst.setString(4, email);
				  pst.executeUpdate();
				  
				  System.out.println("data inserted successfully");
				  t1.setText("");
				  t2.setText("");
				  t3.setText("");
				  t4.setText("");
				  
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		else if(e.getSource()==b2)
		{
			System.out.println("search clicked");
			int id=Integer.parseInt(t1.getText());
			try {
				Connection conn=swingdemo.createConnection();
				String sql="select * from user1 where id=?";
				PreparedStatement pst=conn.prepareStatement(sql);
				pst.setInt(1, id);
				ResultSet rs=pst.executeQuery();
				if (rs.next()) {
					t1.setText(String.valueOf(rs.getInt("id")));
					t2.setText(rs.getString("name"));
					t3.setText(String.valueOf(rs.getLong("contact")));
					t4.setText(rs.getString("email"));
				} 
				else {
					System.out.println("data not founnd");
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
				}
			}
			catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();		}
		}
		else if(e.getSource()==b3)
		{
			System.out.println("update clicked");
			int id=Integer.parseInt(t1.getText());
			String name=t2.getText();
			long contact=Long.parseLong(t3.getText());
			String email=t4.getText();
			
			try {
				Connection conn=swingdemo.createConnection();
				String sql="update user1 set name=?,contact=?,email=? where id=?";
				PreparedStatement pst=conn.prepareStatement(sql);
				pst.setString(1, name);
				pst.setLong(2, contact);
				pst.setString(3, email);
				pst.setInt(4, id);
				pst.executeUpdate();
				
				System.out.println("data updated");
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
			} 
			catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			
		}
		else if(e.getSource()==b4)
			System.out.println("delete clicked");
		int id = Integer.parseInt(t1.getText());
		try {
			Connection conn = swingdemo.createConnection();
			String sql = "delete from user where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			System.out.println("data deleted");
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
		   
}
public class swing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new swingdemo();

	}

}
