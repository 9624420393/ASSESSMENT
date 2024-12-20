package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Connection.Dbconnection;
import model.usermodel;
import java.sql.SQLException;
public class Userdao {
	public static void employeeadd(usermodel u) {
		try {
			Connection conn = Dbconnection.createConnection();
			String sql = "insert into emp(fname,lname,email,mobile,address,gender,pass,cpass) values(?,?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1,u.getFname());
			pst.setString(2,u.getLname());
			pst.setString(3,u.getEmail());
			pst.setLong(4, u.getMobile());
			pst.setString(5,u.getAddress());
			pst.setString(6,u.getGender());
			pst.setString(7, u.getPass());
			pst.setString(8, u.getCpass());
			pst.executeUpdate();
			System.out.println("data inserted");
		} catch (Exception e) {
			e.printStackTrace();
		   }
		}
	
		public static List<usermodel>getALLEmployees() {
			List<usermodel>list = new ArrayList<usermodel>();
			try {
				Connection conn = Dbconnection.createConnection();
				String sql = "select * from emp";
				PreparedStatement pst =conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				while(rs.next()) {
					usermodel s1 =new usermodel();
					s1.setId(rs.getInt("id"));
					s1.setFname(rs.getString("fname"));
					s1.setLname(rs.getString("lname"));
					s1.setEmail(rs.getString("email"));
					s1.setMobile(rs.getLong("mobile"));
					list.add(s1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		public static usermodel getemployeeById(int id) {
			usermodel s1 = null;
			try {
				
				Connection conn = Dbconnection.createConnection();
				String sql = "select * from emp where id=?";
				PreparedStatement pst =conn.prepareStatement(sql);
				pst.setInt(1, id);
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					s1 = new usermodel();
					s1.setId(rs.getInt("id"));
					s1.setFname(rs.getString("fname"));
					s1.setLname(rs.getString("lname"));
					s1.setEmail(rs.getString("email"));
				 	s1.setMobile(rs.getLong("mobile"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return s1;
		}
		public static void updatemployee(usermodel u) {
              try {
				
				Connection conn = Dbconnection.createConnection();
				String sql = "update  emp set fname=?,lname=?,email=?,mobile=? where id=?";
				PreparedStatement pst =conn.prepareStatement(sql);
				pst.setString(1, u.getFname());
				pst.setString(2,u.getLname());
				pst.setString(3,u.getEmail());
				pst.setLong(4, u.getMobile());
				pst.setInt(5, u.getId());
				pst.executeUpdate();
				System.out.println("data updated");
			} catch (Exception e) {
				e.printStackTrace();
			}
	
		}
			public static void deletemployee(int id) {
				 try {
						
						Connection conn = Dbconnection.createConnection();
						String sql = "delete from emp  where id=?";
						PreparedStatement pst =conn.prepareStatement(sql);
						pst.setInt(1, id);
						pst.executeUpdate();
					    System.out.println("data deleted");
						
					} catch (Exception e) {
						e.printStackTrace();
					}
			
				}
			}
			


