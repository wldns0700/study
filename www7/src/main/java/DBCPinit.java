

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


public class DBCPinit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DBCPinit() {
 

    } 

	
	public void init(ServletConfig config) throws ServletException {
		try {
			System.out.println("DBCP init call!!!");
		Class.forName("oracle.jdbc.OracleDriver");
		Class.forName("org.apache.commons.dbcp.PoolingDriver");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
