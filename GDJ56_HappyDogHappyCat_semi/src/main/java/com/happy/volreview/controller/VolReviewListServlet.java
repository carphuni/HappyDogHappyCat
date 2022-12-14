package com.happy.volreview.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.volreview.model.service.VolReviewService;
import com.happy.volreview.model.vo.VntEnr;
import com.happy.volreview.model.vo.VolReview;

/**
 * Servlet implementation class VolReviewListServlet
 */
@WebServlet("/reviewlist.do")
public class VolReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VolReviewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cPage;
		int numPerpage;
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage=1;
		}
		
		numPerpage=5;
		List<VntEnr> enr = new VolReviewService().enrollMember();
		List<VolReview> list = new VolReviewService().selectVolunteerList(cPage, numPerpage);

		String pageBar="";
		int totalData = new VolReviewService().selectVolReviewCount();
		int totalPage=(int)Math.ceil((double)totalData/numPerpage);
		
		int pageBarSize = 10;
		
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd=pageNo+pageBarSize-1;
		if(pageNo==1) {
			pageBar+="<span>[이전]</span>";
		}else {
			pageBar+="<a href='"+request.getRequestURL()+"?cPage="+(pageNo-1)+"'>[이전]</a>";
		}
		
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(pageNo==cPage) {
				pageBar+="<span>"+pageNo+"</span>";
			}else {
				pageBar+="<a href='"+request.getRequestURL()+"?cPage="+(pageNo)+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
			
		if(pageNo>totalPage) {
			pageBar+="<span>[다음]</span>";
		}else {
			pageBar+="<a href='"+request.getRequestURL()+"?cPage="+(pageNo)+"'>[다음]</a>";
		}
		
	
		request.setAttribute("enr", enr);
		System.out.println(enr);
		request.setAttribute("volReview", list);
		request.setAttribute("pageBar", pageBar);
		request.getRequestDispatcher("/views/volreview/reviewList.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
