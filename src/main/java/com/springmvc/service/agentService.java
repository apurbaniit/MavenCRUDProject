package com.springmvc.service;

import java.util.List;

import com.springmvc.model.AgentMaster;

public interface agentService {

	String addAgent(AgentMaster agentMaster, Long id);

	List<AgentMaster> getAllAgenets();

	void deleteByAgentId(long id);

	//void addAgent(AgentMaster agentMaster, Long valueOf);

}
