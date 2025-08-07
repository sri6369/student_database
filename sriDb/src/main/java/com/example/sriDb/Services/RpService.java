package com.example.sriDb.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sriDb.Entity.sData;
import com.example.sriDb.Repositories.RpRepo;

@Service
public class RpService {
@Autowired
RpRepo repo;

public sData method2(sData data) {
	return repo.save(data);
}
public sData getById(int id) {
    return repo.findById(id).orElse(null); // or throw a custom exception
}
public String deleteById(int id) {
	if(repo.existsById(id)) {
		repo.deleteById(id);
		return "Successfully deleted";
	}else {
		return "Id not found";
	}
}

public sData updateData(sData st,int id) {
	
		sData oldData=repo.findById(id).orElseThrow(()->new NullPointerException("Id not found"));
		oldData.setName(st.getName());
		oldData.setDepart(st.getDepart());
		return repo.save(oldData);
	}
}

