package com.happy.support.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.member.model.vo.Member;
import com.happy.support.model.service.SupportService;
import com.happy.support.model.vo.SupComment;
import com.happy.support.model.vo.SupPhoto;
import com.happy.support.model.vo.Support;
import com.happy.vol.model.service.VolunteerService;
import com.happy.vol.model.vo.Agency;

/**
 * Servlet implementation class SupportViewServlet
 */
@WebServlet("/supview.do")
public class SupportViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupportViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		int AgencyNo = Integer.parseInt(request.getParameter("agencyNo"));
		Support s = new SupportService().selectSupport(boardNo);
		Agency a = new VolunteerService().selectAgency(AgencyNo);
		List<SupComment> sc = new SupportService().selectSupportComment(boardNo);
		System.out.println(sc);
		List<SupPhoto> sp = new SupportService().selectSupPhoto2(boardNo);
		List<Member> member = new ArrayList();
		request.setAttribute("boardNo", boardNo);
		request.setAttribute("photo", sp);
		request.setAttribute("agency",a);
		request.setAttribute("info", s);
		request.setAttribute("comment", sc);
		for(int i = 0; i<sc.size();i++) {
			int memberNo = sc.get(i).getSupUserNo();
			Member m = new SupportService().selectMember(memberNo);
			member.add(m);
		}
		request.setAttribute("member", member);
		if(request.getParameter("memberNo")!=null) {
			int memberNo= Integer.parseInt(request.getParameter("memberNo"));
			int check = new SupportService().selectSupPick(boardNo, memberNo);
			request.setAttribute("check", check);}
		request.getRequestDispatcher("/views/support/supView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
