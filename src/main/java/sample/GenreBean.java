package sample;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class GenreBean implements Serializable {
	private int id;
	private String genre;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public static ArrayList<GenreBean> getGenreTable(){
		ArrayList<GenreBean> list = new ArrayList<> ();
		String sql = "select * from genres";
		GenreBean gbean;
		try (Connection conn = ResourceFinder.getConnection();
				Statement st = conn.createStatement();) {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				gbean = new GenreBean();
				gbean.setId(rs.getInt("id"));
				gbean.setGenre(rs.getString("genre"));
				list.add(gbean);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	
}
