package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.agentDao;
import com.springmvc.model.AgentMaster;

@Service("agentService")
public class agentServiceImpl implements agentService{

	@Autowired
	agentDao agentDao;
	
	@Transactional
	public String addAgent(AgentMaster agentMaster, Long id) {
		return agentDao.addagent(agentMaster,id);
	}

	@Transactional
	public List<AgentMaster> getAllAgenets() {
		return agentDao.getAllAgents();
	}

	@Transactional
	public void deleteByAgentId(long id) {
		agentDao.deleteByAgentId(id);
	}

}
