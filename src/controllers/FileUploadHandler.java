package controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import logic.CalculateComplexity;
import models.ProgramStatementComplexity;

/**
 * Servlet implementation class FileUploadHandler
 */
@WebServlet("/upload")
public class FileUploadHandler extends HttpServlet {
	
    private final String UPLOAD_DIRECTORY = "C:/uploads";
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    	HttpSession session = request.getSession();
        //process only if its multi part content
        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload( new DiskFileItemFactory()).parseRequest(request);
               
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                    	File file = new File(item.getName());
                        String name = new File(item.getName()).getName();
                        String extension = FilenameUtils.getExtension(item.getName());
                        
                        if (!extension.equals("txt")) {
                        	request.setAttribute("error", "You must upload a .java file");
//                        	request.getRequestDispatcher("/uploadFile.jsp").forward(request, response);
                        	response.sendRedirect(request.getContextPath() + "/uploadFile.jsp");
                        }
                        else {
                            item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                            List<ProgramStatementComplexity> programComplexity = CalculateComplexity.getComplexity("C:\\uploads\\" + name);
                            System.out.println("length: " + programComplexity.size());
                            session.setAttribute("ProgramComplexity", programComplexity);
                            session.setAttribute("message", "File Uploaded Successfully");
                            session.setAttribute("filePath", "C:\\uploads\\" + name);
                            session.setAttribute("fileName", item.getName());
//                        	request.getRequestDispatcher("/viewFile.jsp").forward(request, response);
                        	response.sendRedirect(request.getContextPath() + "/viewFile.jsp");
                        }
                        System.out.println("C:\\uploads\\" + name);
                    }
                }
            
               //File uploaded successfully
               
            } catch (Exception ex) {
            	session.setAttribute("message", "File Upload Failed due to " + ex);
            }          
          
        }else{
        	session.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
        }
     
//        request.getRequestDispatcher("/CalculateComplexity.jsp").forward(request, response);
//        response.sendRedirect("/CalculateComplexity.jsp");
      
    }
   
}	
