package sample;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SpiceBean implements Serializable {
	private int id;
	private String name;
	private String kana;
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
	public String getKana() {
		return kana;
	}
	public void setKana(String kana) {
		this.kana = kana;
	}
	
	public static ArrayList<SpiceBean> getSpiceTable(){
		ArrayList<SpiceBean> list = new ArrayList<> ();
		String sql = "select * from spices";
		SpiceBean sbean;
		try (Connection conn = ResourceFinder.getConnection();
				Statement st = conn.createStatement();) {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				sbean = new SpiceBean();
				sbean.setId(rs.getInt("id"));
				sbean.setName(rs.getString("name"));
				sbean.setKana(rs.getString("kana"));
				list.add(sbean);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

}
