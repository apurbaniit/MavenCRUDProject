package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.countryDao;
import com.springmvc.model.Country;

@Service("countryService")
public class countryServiceImpl implements countryService{

	@Autowired
	countryDao countryDao;
	
	@Transactional
    public List<Country> getAllCountries() {
        return countryDao.getAllCountries();
    }

}
