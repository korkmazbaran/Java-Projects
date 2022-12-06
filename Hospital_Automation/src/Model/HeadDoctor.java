package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HeadDoctor extends User{
	Connection con = conn.connDb();
	Statement st =null;
	ResultSet rs= null;
	PreparedStatement preparedStatement = null;
	

	public HeadDoctor(int id, String tcno, String name, String password, String type) {
		super(id, tcno, name, password, type);
	}
	public HeadDoctor() {}
	
	public ArrayList<User> getDoctorList() throws SQLException{
		ArrayList<User> list = new ArrayList<User>();
		
		User obj;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM user WHERE type ='doctor'");
			while (rs.next()) {
				obj = new User(rs.getInt("id"),rs.getString("tcno"),rs.getString("name"),rs.getString("password"),rs.getString("type"));
				list.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public boolean addDoctor(String name, String tcno, String password) throws SQLException {
		
		String query = "INSERT INTO user"+"(tcno,password,name,type) VALUES"+"(?,?,?,?)";
		boolean key = false ;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, tcno);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, name);
			preparedStatement.setString(4, "doctor");
			preparedStatement.executeUpdate();
			key = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (key) {
			return true;
		}
		else {
			return false;
		}
	}
	
public boolean deleteDoctor(int id) throws SQLException {
		
		String query = "DELETE FROM user WHERE id= ?";
		boolean key = false ;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			key = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (key) {
			return true;
		}
		else {
			return false;
		}
	}
public boolean updateDoctor(int id,String name,String tcno, String password) throws SQLException {
	
	String query = "UPDATE user SET name =?,tcno=?,password=? WHERE id=? ";
	boolean key = false ;
	try {
		st = con.createStatement();
		preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, tcno);
		preparedStatement.setString(3, password);
		preparedStatement.setInt(4, id);
		preparedStatement.executeUpdate();
		key = true;
	} catch (Exception e) {
		e.printStackTrace();
	}
	if (key) {
		return true;
	}
	else {
		return false;
	}
}

}

