package dummy.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dummy.entity.CallDetailsEntity;
import dummy.model.CallDetailsModel;
import dummy.repository.CallDetailsRepository;

@Service
public class CallDetailsServiceImpl implements CallDetailsService {
	
	@Autowired
	CallDetailsRepository repo;
	
	@Autowired
	DozerBeanMapper mapper;
	List<CallDetailsModel> callModels;

	@Override
	public void addCallDetails(CallDetailsModel calldetails) {
		System.out.println("inside call details service");
		repo.save(mapper.map(calldetails, CallDetailsEntity.class));
	}

	@Override
	public List<CallDetailsModel> findAll() {
		List<CallDetailsEntity> entities = repo.findAll();
		callModels = new ArrayList<CallDetailsModel>();
		for (CallDetailsEntity callDetailsEntity : entities) {
			 callModels.add(mapper.map(callDetailsEntity, CallDetailsModel.class));
		}
		return callModels;
	}

	@Override
	public int updateCallDetails(String calledTo, String calledon, String id) {
		repo.updateCallDetails(Long.parseLong(calledTo),Long.parseLong(calledon),Long.parseLong(id));
		return 0;
	}

	@Override
	public int deleteCallDetails(String id) {
		repo.deleteById(Long.parseLong(id)); 
		return 0;
	}

	@Override
	public List<CallDetailsModel> findByCalledBy(String calledBy) {
		List<CallDetailsEntity> entities = repo.findByCalledBy(Long.parseLong(calledBy));
		callModels = new ArrayList<CallDetailsModel>();
		for (CallDetailsEntity callDetailsEntity : entities) {
			callModels.add(mapper.map(callDetailsEntity, CallDetailsModel.class));
		}
		return callModels;
	}

}