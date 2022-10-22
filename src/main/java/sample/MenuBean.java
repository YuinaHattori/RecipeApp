package sample;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MenuBean implements Serializable {
	private int id;
	private String name;
	private int category_id;
	private int genre_id;
	private int servings;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getGenre_id() {
		return genre_id;
	}
	public void setGenre_id(int genre_id) {
		this.genre_id = genre_id;
	}
	public int getServings() {
		return servings;
	}
	public void setServings(int servings) {
		this.servings = servings;
	}
	
	public static ArrayList<MenuBean> getMenuTable(){
		ArrayList<MenuBean> list = new ArrayList<> ();
		String sql = "select * from menus";
		MenuBean mbean;
		try (Connection conn = ResourceFinder.getConnection();
				Statement st = conn.createStatement();) {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				mbean = new MenuBean();
				mbean.setId(rs.getInt("id"));
				mbean.setName(rs.getString("name"));
				mbean.setCategory_id(rs.getInt("category_id"));
				mbean.setGenre_id(rs.getInt("genre_id"));
				mbean.setServings(rs.getInt("servings"));
				list.add(mbean);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

}
