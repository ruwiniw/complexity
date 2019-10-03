package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.CalculateComplexity;
import models.ProgramStatementComplexity;

/**
 * Servlet implementation class FileServlet
 */
@WebServlet("/FileServlet")
public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		List <ProgramStatementComplexity> programComplexity = null;
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		String fileName = request.getParameter("document");
		out.println("fileName: " + fileName);

		    programComplexity = CalculateComplexity.getComplexity(fileName);
	
		    
		    
		    if (programComplexity != null) {
				session.setAttribute("ProgramComplexity", programComplexity);
				session.setAttribute("FileName", fileName);
			
			
			response.sendRedirect(request.getContextPath() + "/viewFile.jsp");
		    }
			else {
				session.setAttribute("FileName", fileName);
			}
			}
				
}
