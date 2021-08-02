package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.AgentMaster;

public interface agentDao {

	String addagent(AgentMaster agentMaster, Long id);

	List<AgentMaster> getAllAgents();

	void deleteByAgentId(long id);

}
