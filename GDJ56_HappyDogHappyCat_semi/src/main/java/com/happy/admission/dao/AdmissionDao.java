package com.happy.admission.dao;

import static com.happy.common.JDBCTemplate.close;


import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.happy.admission.vo.AdmissionForm;
import com.happy.animal.model.vo.Animal;





public class AdmissionDao {
	private Properties sql=new Properties();
	
	//경로지정 
	public AdmissionDao() {
		String path=AdmissionDao.class
				.getResource("/sql/admission/admission_sql.properties")
				.getPath();
		try {
			sql.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//동물 데이터 저장 
	public int enrollAnimal(Connection conn, Animal ani) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("enrollAnimal"));
			pstmt.setString(1, ani.getAniName());
			pstmt.setString(2, ani.getAniType());
			pstmt.setString(3, ani.getAniKind());
			pstmt.setString(4, String.valueOf(ani.getAniGender()));
			pstmt.setInt(5, ani.getAniAge());
			pstmt.setString(6, String.valueOf(ani.getAniNeuYn()));
			pstmt.setString(7, ani.getAniSize());
			pstmt.setString(8,ani.getAniColor());
			pstmt.setString(9, String.join(",",ani.getAniChar()));
			pstmt.setString(10,ani.getAniSpecial());
			pstmt.setString(11,ani.getAniReason());
			pstmt.setString(12, String.valueOf(ani.getMadDog()));
			pstmt.setString(13, String.valueOf(ani.getCovid()));
			pstmt.setString(14, String.valueOf(ani.getKennel()));
			pstmt.setString(15, String.valueOf(ani.getInflu()));
			pstmt.setString(16, String.valueOf(ani.getAntibody()));
			pstmt.setString(17, String.valueOf(ani.getTotalvac()));
			result=pstmt.executeUpdate();
			System.out.println(result);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	//동물번호
	public int selectAniNo(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int aniNo=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectAniNo"));
			rs=pstmt.executeQuery();
			if(rs.next()) aniNo=rs.getInt("no");
			System.out.println(aniNo);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return aniNo;
	
	}
	
	//입소데이터 저장 
	public int enrollAdmission(Connection conn,int aniNo, String hopeDate,int memberNo) {
		PreparedStatement pstmt=null;
		int result=0;
		AdmissionForm ad=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("enrollAdmission"));
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2,aniNo);
			pstmt.setString(3, hopeDate);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}


	public int selectAdmissionCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectAdmissionCount"));
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
	}

	public List<AdmissionForm> selectAdmissionList(Connection conn, int cPage, int numPerpage) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<AdmissionForm> list=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectAdmissionList"));
			pstmt.setInt(1, (cPage-1)*numPerpage+1);
			pstmt.setInt(2, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				list.add(getAdmission(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;
	}

	private AdmissionForm getAdmission(ResultSet rs) throws SQLException {
		return AdmissionForm.builder()
				.admissionNo(rs.getInt("adm_board_no"))
				.memberNo(rs.getInt("member_no"))
				.writeDate(rs.getDate("adm_write_date"))
				.memberId(rs.getString("member_id"))
				.build();

	}

	private Animal getAnimal(ResultSet rs) throws SQLException{
		return Animal.builder()
				.aniName(rs.getString("ani_name"))
				.aniType(rs.getString("ani_type"))
				.aniKind(rs.getString("ani_kind"))
				.aniGender(rs.getString("ani_gender").charAt(0))
				.aniAge(rs.getInt("ani_age"))
				.aniNeuYn(rs.getString("ani_neu_yn").charAt(0))
				.aniSize(rs.getString("ani_size"))
				.aniColor(rs.getString("ani_color"))
				.aniChar(rs.getString("ani_char").split(","))
				.aniSpecial(rs.getString("ani_special"))
				.aniReason(rs.getString("ani_reason"))
				.madDog(rs.getString("maddog").charAt(0))
				.covid(rs.getString("covid").charAt(0))
				.kennel(rs.getString("kennel").charAt(0))
				.influ(rs.getString("influ").charAt(0))
				.antibody(rs.getString("antibody").charAt(0))
				.totalvac(rs.getString("totalvac").charAt(0))
				.build();
		
	}

	public Animal admissionView(Connection conn, int admissionNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Animal a=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectAnimal"));
			pstmt.setInt(1, admissionNo);
			rs=pstmt.executeQuery();
			if(rs.next()) a=getAnimal(rs);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return a;
	}
	
	

	

}

