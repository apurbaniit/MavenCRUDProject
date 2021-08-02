package com.springmvc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.branchDao;
import com.springmvc.model.BranchMaster;

@Service("branchService")
public class branchServiceImpl implements branchService {

	@Autowired
	branchDao branchDao;
	
	
	@Transactional
	public List<BranchMaster> getAllBranches() {
		return branchDao.getAllBranches();
	}


	@Override
	public String addBranch(HttpServletRequest re, BranchMaster branchMaster) {
		return branchDao.addBranch(re,branchMaster);
	}


	@Override
	public BranchMaster getByBranchId(long id) {
		return branchDao.getByBranchId(id);
	}


	@Override
	public String updateBranch(HttpServletRequest re, BranchMaster branchMaster) {
		return branchDao.updateBranch(re,branchMaster);
	}


	@Override
	public String deleteByBranchId(long id) {
		return branchDao.deleteByBranchId(id);
	}


	@Override
	public String getByBranchName(String parameter) {
		return branchDao.getByBranchName(parameter);
	}
	

	@Override
	public String getByBranchCode(String parameter) {
		return branchDao.getByBranchCode(parameter);
	}

}
