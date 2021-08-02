
package com.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.model.AgentMaster;
import com.springmvc.model.BranchMaster;
import com.springmvc.model.Country;

@Repository
public class agentDaoImpl implements agentDao{

	@Autowired
    private SessionFactory sessionFactory;
 
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }
	
	@Override
	public String addagent(AgentMaster agentMaster, Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		BranchMaster branch=(BranchMaster)session.get(BranchMaster.class,id);
		agentMaster.setBranch(branch);
		session.save(agentMaster);
		return "success";
	}

	@Override
	public List<AgentMaster> getAllAgents() {
		Session session = this.sessionFactory.getCurrentSession();
		List<AgentMaster> agentList = session.createQuery("from AgentMaster").list();
        return agentList;
	}

	@Override
	public void deleteByAgentId(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		AgentMaster agent = (AgentMaster) session.get(AgentMaster.class,id);
		session.delete(agent);
		
	}

}
