package demo;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class Uploader
 */
public class Uploader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Uploader() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			out.println("Nothing uploaded");
			return;
		}
		
		FileItemFactory itemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(itemFactory);
		
		try {
			List<FileItem> items = upload.parseRequest(request);
			
			for(FileItem item: items) {
				String contentType = item.getContentType();
				
				if(!contentType.equals("image/png")) {
					out.println("Only png format image files supported");
					continue;
				}
				
				File uploadDir = new File("C:\\workspace\\servlets2\\upload");
				File file = File.createTempFile("img", ".png", uploadDir); 
				item.write(file);
				
				out.println("File saved.");
			}
			
		} catch (FileUploadException e) {
			out.println("Upload failed.");
			return;
		}
		catch(Exception ex) {
			out.println("Can't save file");
		}
	}

}
