package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Destination;
import dao.DaoFactory;
import dao.DestinationDao;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DestinationDao DestinationDao;
	//private ArrayList<Destination> temp=new ArrayList<Destination>();
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException {
	    DaoFactory daoFactory = DaoFactory.getInstance();
	    DestinationDao = daoFactory.getBilletDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(DestinationDao.lister("hotel"));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
