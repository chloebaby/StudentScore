package service;

import java.util.List;

import DAOImplementation.AttachtDAOImplementation;
import interfaceDAO.AttachDAO;
import model.*;

public class AttachService{
	private static AttachService am;
	static {
		if(am == null) {
			am = new AttachService();
			am.setAttachDAO(new AttachtDAOImplementation());
		}	
		
	}
	AttachDAO attachDAO;
	
	public AttachDAO getAttachDAO() {
		return attachDAO;
	}
	public void setAttachDAO(AttachDAO attachDAO) {
		this.attachDAO = attachDAO;
	}
	public static AttachService getInstance() {
		return am;
	}
	private AttachService() {}
	
	public List<Students> getAllResult() {
		return attachDAO.getAllResult();
	}
}
