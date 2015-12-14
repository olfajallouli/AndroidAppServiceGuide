package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Destination;
import dao.DaoFactory;
import dao.DestinationDao;

import org.json.JSONArray;

/**
 * Servlet implementation class Index
 */
@WebServlet("/api")
public class api extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DestinationDao destinationDao;
	final String tag_id="id";
	final String tag_lat="lat";
	final String tag_lng="lng";
	final String tag_nom="nom";
	final String tag_numT="numT";
	final String tag_img="img";
	final String tag_desc="desc";
	final String tag_adresse="adresse";
	final String tag_type="type";
	final String tag_tableau="destinations";

	private ArrayList<Destination> temp=new ArrayList<Destination>();
    public api() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException {
	    /*DaoFactory daoFactory = DaoFactory.getInstance();
	    destinationDao = daoFactory.getDestinationDao();
	    temp=destinationDao.lister();*/
	    temp.add(new Destination(1,1,1,"a","z","z","h","d","d"));
	    temp.add(new Destination(1,1,1,"b","z","z","h","d","d"));
	    temp.add(new Destination(1,1,1,"c","z","z","h","d","d"));

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        response.setHeader("Cache-control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "-1");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "86400");
    	response.setContentType("application/json");
	    response.setCharacterEncoding("utf-8");
	     try {
 	        org.json.JSONArray jsonArr = new JSONArray();
    
	    	 for(int i=0;i<temp.size();i++){  
	    	        org.json.JSONObject json = new org.json.JSONObject();
	                Destination d=temp.get(i);
			    	json.put(tag_id,d.getId());
			    	json.put(tag_adresse,d.getAdresse());
			    	json.put(tag_desc,d.getDesc());
			    	json.put(tag_lat,d.getLat());
			    	json.put(tag_lng,d.getLng());
			    	json.put(tag_nom,d.getNom());
			    	json.put(tag_numT,d.getNumT());
			    	json.put(tag_type,d.getType());	
			    	json.put(tag_img, d.getImg());
			    	jsonArr.put(json);
	             }
				    
			    	out.print(jsonArr.toString());
		        	System.out.println("envoi de "+jsonArr.toString());
		        	 
	     } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
    	  finally{
    		  out.flush();
    		  out.close();
    	  }
    			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
