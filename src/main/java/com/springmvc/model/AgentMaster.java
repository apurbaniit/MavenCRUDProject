package com.springmvc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="agentmaster")
public class AgentMaster {
	
	@Id
    @Column(name="agent_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
 
    @Column(name="agent_name")
    private String agent_name;
    
    @Column(name="agent_code")
    private String agent_code;
    
    @ManyToOne(targetEntity = BranchMaster.class)
	@JoinColumn(name="branch_id")
	private BranchMaster branch;
    
    @Transient
    private long branchId;

	public AgentMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getAgent_name() {
		return agent_name;
	}

	public void setAgent_name(String agent_name) {
		this.agent_name = agent_name;
	}

	public String getAgent_code() {
		return agent_code;
	}

	public void setAgent_code(String agent_code) {
		this.agent_code = agent_code;
	}

	public BranchMaster getBranch() {
		return branch;
	}

	public void setBranch(BranchMaster branch) {
		this.branch = branch;
	}

	public long getBranchId() {
		return branchId;
	}

	public void setBranchId(long branchId) {
		this.branchId = branchId;
	}
	
}
