package com.springmvc.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.springmvc.model.BranchMaster;

public interface branchDao {

	List<BranchMaster> getAllBranches();

	String addBranch(HttpServletRequest re, BranchMaster branchMaster);

	BranchMaster getByBranchId(long id);

	String updateBranch(HttpServletRequest re, BranchMaster branchMaster);

	String deleteByBranchId(long id);

	String getByBranchName(String parameter);

	String getByBranchCode(String parameter);

}
