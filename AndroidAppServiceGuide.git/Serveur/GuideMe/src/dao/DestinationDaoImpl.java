package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Destination;



public class DestinationDaoImpl implements DestinationDao {

	private DaoFactory daoFactory;
	
 
	public  DestinationDaoImpl(DaoFactory daoFactory){
		this.daoFactory=daoFactory;	
	}

	@Override
	public List<Destination> lister(String type) {
		// TODO Auto-generated method stub
		return null;
	}



}
