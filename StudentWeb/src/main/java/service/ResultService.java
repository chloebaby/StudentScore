package service;

import java.util.ArrayList;
import java.util.List;

import DAOImplementation.ResultDAOImplementation;
import interfaceDAO.ResultDAO;
import model.Results;


public class ResultService {
	private static ResultService rm = null;
	static {
		if(rm == null) {
			rm = new ResultService();
			rm.setResDAO(new ResultDAOImplementation());
		}
	}
	ResultDAO resDAO;
	public ResultDAO getResDAO() {
		return resDAO;
	}
	public void setResDAO(ResultDAO resDAO) {
		this.resDAO = resDAO;
	}
	
	List<Results> resultlist = new ArrayList<Results>();
	
	public static ResultService getInstance() {
		return rm;
	}
	private ResultService() {}
	
	
	public void createResult(Results res) {
		resDAO.createResult(res);
	}
	
	public List<Results> getResults() {
		return resDAO.getResults();
	}
	
	public List<Results> getResults(int pageNo, int pageSize) {
		return resDAO.getResults(pageNo,pageSize);
	}
	
	public Results getResultById(int sid,String cid) {
		Results res = new Results();
		res = resDAO.getResultById(sid,cid);		
		return res;
	}
	public void deleteResult(int sid,String cid) {
		resDAO.deleteResult(sid,cid);
	}
	public void updateResult(Results res) {
		resDAO.updateResult(res);
	}
	public void exportInfo(String dir) {}
	public void importInfo(String dir) {}
}