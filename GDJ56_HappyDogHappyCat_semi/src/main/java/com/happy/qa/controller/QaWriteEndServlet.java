package com.happy.qa.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.happy.qa.service.QaService;
import com.happy.qa.vo.QaForm;
import com.happy.qa.vo.QaPhoto;
import com.happy.vol.model.vo.VolPhoto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class QaWriteEndServlet
 */
@WebServlet("/qa/qaWriteEnd.do")
public class QaWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QaWriteEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			System.out.println("4646ifif");
			response.sendRedirect(request.getContextPath());
		}else {
			System.out.println("49else");
			String path=request.getServletContext().getRealPath("/upload/qa");
			int maxSize=1024*1024*10;
			String encoding="UTF-8";
			DefaultFileRenamePolicy dfr=new DefaultFileRenamePolicy();
			MultipartRequest mr=new MultipartRequest(request, 
					path,maxSize,encoding,dfr);
		

			Enumeration e=mr.getFileNames();	
			System.out.println("57" + e);
			List<QaPhoto> fileList=new ArrayList();
			System.out.println("59" + fileList);
			
			
		while(e.hasMoreElements()) {
				String name=(String)e.nextElement();
				String fileName2 = mr.getFilesystemName(name);
				String oriName2 = mr.getOriginalFileName(name);
				
					fileList.add(QaPhoto.builder()
							.qaPhotoReName(fileName2)
							.qaPhotoOriName(oriName2)
							.build());
				
				System.out.println(fileList);
			
			}
		
		
		String qaTitle=mr.getParameter("qaTitle");
		System.out.println("??????"+qaTitle);
		String qaContents=mr.getParameter("qaContents");
		System.out.println("??????"+qaContents);
		char openYn=mr.getParameter("qaOpenYn").charAt(0);
		System.out.println("????????????"+openYn);
		System.out.println("????????????????????????"+mr.getParameter("qaPassword"));
		int qaPassword=0;
		if(!mr.getParameter("qaPassword").equals("") && mr.getParameter("qaPassword") != null) {
			System.out.println("88????????????"+mr.getParameter("qaPassword"));
			qaPassword=Integer.parseInt(mr.getParameter("qaPassword"));
			System.out.println("90????????????"+qaPassword);
		}else {
			System.out.println("92????????????"+mr.getParameter("qaPassword"));
			qaPassword=0;
			System.out.println("94????????????"+qaPassword);
		}
		
		int memberNo=Integer.parseInt(mr.getParameter("memberNo"));
		System.out.println("????????????"+memberNo);
		
		QaForm qa=QaForm.builder()
				.qaTitle(qaTitle)
				.qaContents(qaContents)
				.qaOpenYn(openYn)
				.qaPassword(qaPassword)
				
				.build();
		
		
		
		
		int result=new QaService().enrollQa(qa,memberNo,fileList);
		
		
		
		String msg="",loc="";
		if(result==0) {
			//qa ?????? ?????????
			msg="????????? ?????? ??????, ?????? ??????????????????!";
			loc="/qa/qaWrite.do";
		}else {
			//qa ?????? ?????????2
			msg="????????? ?????? ??????! :)";
			loc="/qa/qaList.do";
			
		}
		
		Map<String,String> responseMsg=Map.of("msg",msg,"loc",loc);
		
		response.setContentType("application/json;charset=utf-8");
		new Gson().toJson(responseMsg,response.getWriter());
		
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
