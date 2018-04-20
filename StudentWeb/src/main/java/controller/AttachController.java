package controller;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


import service.*;
import model.*;

/**
 * Servlet implementation class AttachController
 */
@WebServlet("/AttachController")
public class AttachController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String LIST ="mailpdf.jsp";
	private AttachService am;
	String forward="";
	private static final int colNumber = 10;
	private static final int spacing = 2;
	private static final int padding = 2;
	
	public AttachController() {
		super();
		am = AttachService.getInstance();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] tableHeader = {"Studentid","LastName","Firstname","Address","City","Email","CourseName","CreditNumbers","Semester","Marks"};
		String action = request.getParameter("action");	
		Document document = new Document(PageSize.A4);
		if(action != null && action.trim().equals("attach")) {
			try {
				PdfWriter.getInstance(document, new FileOutputStream("C:/daiss/test/temp/scores.pdf"));
				document.open();
				
					PdfPTable datatable = new PdfPTable(colNumber);
					
					int[] cellsWidth = {5,5,5,5,5,5,5,5,5,5};					
					datatable.setWidths(cellsWidth);
					
					datatable.getDefaultCell().setPadding(padding);
					datatable.getDefaultCell().setBorder(spacing);
					datatable.getDefaultCell().setBackgroundColor(BaseColor.GREEN);
					datatable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);					
					for(int i =0; i <colNumber; i++) {
						datatable.addCell(new Paragraph(tableHeader[i]));						
					}
					datatable.setHeaderRows(1);					
					datatable.getDefaultCell().setBorderWidth(1);					
					List<Students> resultlist = new ArrayList<Students>();
					resultlist = am.getAllResult();
					for(int i =1; i<=resultlist.size(); i++) {
						datatable.addCell(new Paragraph(String.valueOf(resultlist.get(i).getStudentid())));
						datatable.addCell(new Paragraph(resultlist.get(i).getLastname()));
						datatable.addCell(new Paragraph(resultlist.get(i).getFirstname()));
						datatable.addCell(new Paragraph(resultlist.get(i).getAddress()));
						datatable.addCell(new Paragraph(resultlist.get(i).getCity()));
						datatable.addCell(new Paragraph(resultlist.get(i).getEmail()));
//						datatable.addCell(new Paragraph(resultlist.get(i).getCourse().getCoursename()));
//						datatable.addCell(new Paragraph(String.valueOf(resultlist.get(i).getCourse().getCreditnumbers())));
//						datatable.addCell(new Paragraph(String.valueOf(resultlist.get(i).getResults().getSemester())));
//						datatable.addCell(new Paragraph(String.valueOf(resultlist.get(i).getResults().getMarks())));
//						System.out.println(resultlist.get(i).getStudentid()+"@"+resultlist.get(i).getLastname()+"@"+resultlist.get(i).getFirstname()+"@"+resultlist.get(i).getAddress()+"@"+resultlist.get(i).getCity()+"@"+resultlist.get(i).getEmail()+"@"+resultlist.get(i).getCourse().getCoursename()+"@"+resultlist.get(i).getCourse().getCreditnumbers()+"@"+resultlist.get(i).getResults().getSemester()+"@"+String.valueOf(resultlist.get(i).getResults().getMarks()));
					}
					
					document.add(datatable);
				
			} catch (DocumentException e) {
				e.printStackTrace();
			}finally {
				document.close();
			}
			
		}	
		
		request.getRequestDispatcher(forward).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
