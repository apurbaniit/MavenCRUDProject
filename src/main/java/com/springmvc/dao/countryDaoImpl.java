package com.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.model.Country;

@Repository
public class countryDaoImpl implements countryDao{

	@Autowired
    private SessionFactory sessionFactory;
 
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }
	
	@Override
	public List<Country> getAllCountries() {
		Session session = this.sessionFactory.getCurrentSession();
        List<Country> countryList = session.createQuery("from Country").list();
        return countryList;
	}

}
