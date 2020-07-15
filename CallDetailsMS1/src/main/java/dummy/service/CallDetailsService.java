package dummy.service;

import java.util.List;

import dummy.model.CallDetailsModel;

public interface CallDetailsService {
	public void addCallDetails(CallDetailsModel calldetails);
	public List<CallDetailsModel> findAll();
	int updateCallDetails(String calledTo, String calledon, String id);
	int deleteCallDetails(String id);
	List<CallDetailsModel> findByCalledBy(String calledBy);

}