package interfaceDAO;

import java.util.List;

import model.Results;

public interface ResultDAO {
	void createResult(Results r);
	List<Results> getResults();
	List<Results> getResults(int pageNo, int pageSize);
	Results getResultById(long sid,String cid);
    void deleteResult(long sid,String cid);
    void updateResult(Results res);

}
