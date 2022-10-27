package sample;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class IngredientBean implements Serializable {
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
	
	public static ArrayList<IngredientBean> getIngredientTable(){
		ArrayList<IngredientBean> list = new ArrayList<> ();
		String sql = "select * from ingredients";
		IngredientBean ibean;
		try (Connection conn = ResourceFinder.getConnection();
				Statement st = conn.createStatement();) {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				ibean = new IngredientBean();
				ibean.setId(rs.getInt("id"));
				ibean.setName(rs.getString("name"));
				ibean.setKana(rs.getString("kana"));
				list.add(ibean);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	
}
