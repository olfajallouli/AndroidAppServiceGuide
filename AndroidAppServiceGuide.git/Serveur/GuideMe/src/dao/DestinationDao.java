package dao;
import java.util.List;

import bean.Destination;



public interface DestinationDao {

	

		List<Destination> lister(String type);//type ={restaurant,cafee,hotel,cinema}
	
	

}
