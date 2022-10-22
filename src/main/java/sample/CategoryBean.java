package sample;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoryBean implements Serializable {
	private int id;
	private String category;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public static ArrayList<CategoryBean> getCategoryTable(){
		ArrayList<CategoryBean> list = new ArrayList<> ();
		String sql = "select * from categories";
		CategoryBean cbean;
		try (Connection conn = ResourceFinder.getConnection();
				Statement st = conn.createStatement();) {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				cbean = new CategoryBean();
				cbean.setId(rs.getInt("id"));
				cbean.setCategory(rs.getString("category"));
				list.add(cbean);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

}
