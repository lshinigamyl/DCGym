
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 * A servlet that takes message details from user and send it as a new e-mail
 * through an SMTP server.
 * 
 * @author www.codejava.net
 * 
 */
@WebServlet("/EmailSendingServlet")
public class EmailSendingServlet extends HttpServlet {
	private String host;
	private String port;
	private String user;
	private String pass;

	public void init() {
		// reads SMTP server setting from web.xml file
		ServletContext context  = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, HeadlessException {
		// reads form fields
		String recipient = request.getParameter("recipient");
		String subject = request.getParameter("subject");
		String  content = "!Gracias por Escribirnos "
				+ request.getParameter("name")+ 		"!\n\nEste fue tu Mensaje: \n\n<<"+
				request.getParameter("content")+
				" >>\n\nTe responderemos en lo antes posible. \n\nAtt. TeamDc";

		String resultMessage = "";


		try {
			EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
					content);
			resultMessage = "El mensaje fue enviado :)";
		} catch (Exception ex) {
			ex.printStackTrace();
			resultMessage = ":( No se ha podido enviar: " + ex.getMessage();
		} finally {
			try {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<head>");
				out.println("<title>DCGym - Correo Enviado</title>");
				out.println("</head>");
				out.println("<body style='background: url(image/fondo1.png); background-position: center center; background-repeat: no-repeat;	 background-attachment: fixed;background-size: cover;'>");
				out.println("<jsp:include page='_default_navbar.jsp'/>");
				out.println("<a href='inicio' style='	color: white; font-weight: 900;size: 30px; background: lightslategray; '>");
				out.println(resultMessage);
				out.println("</a>");
				out.println("</body>");
				out.println("</html>");



			}catch (Exception ex1){		ex1.printStackTrace();}
		}



	}
}