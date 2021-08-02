package com.springmvc.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.model.BranchMaster;
import com.springmvc.model.Country;

@Repository
@Transactional
public class branchDaoImpl implements branchDao {

	@Autowired
    private SessionFactory sessionFactory;
 
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }
	
	@Override
	public List<BranchMaster> getAllBranches() {
		Session session = this.sessionFactory.getCurrentSession();
        List<BranchMaster> branchList = session.createQuery("from BranchMaster").list();
        return branchList;
	}

	@Override
	public String addBranch(HttpServletRequest re, BranchMaster branchMaster) {
		Session session = this.sessionFactory.getCurrentSession();
		Country country=(Country)session.get(Country.class, branchMaster.getCountryId());
		branchMaster.setCountry(country);
		session.save(branchMaster);
		return "success";
	}

	@Override
	public BranchMaster getByBranchId(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		BranchMaster branchMaster = (BranchMaster) session.get(BranchMaster.class,id);
		return branchMaster;
	}

	@Override
	public String updateBranch(HttpServletRequest re, BranchMaster branchMaster) {
		Session session = this.sessionFactory.getCurrentSession();
		
		BranchMaster branch = (BranchMaster) session.get(BranchMaster.class,Long.valueOf(re.getParameter("branch_id")));
		branch.setBranch_code(branchMaster.getBranch_code());
		Country country=(Country)session.get(Country.class, branchMaster.getCountryId());
		branch.setCountry(country);
		branch.setBranch_name(branchMaster.getBranch_name());
		branch.setBranch_address(branchMaster.getBranch_address());
		
		session.saveOrUpdate(branch);
		return "success";
	}

	@Override
	public String deleteByBranchId(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		BranchMaster branchMaster = (BranchMaster) session.get(BranchMaster.class,id);
		session.delete(branchMaster);
		return "successFully deleted";
	}

	@Override
	public String getByBranchName(String parameter) {
		Session session = this.sessionFactory.getCurrentSession();
		List<BranchMaster> branchList =  session.createCriteria(BranchMaster.class).add(Restrictions.eq("branch_name", parameter)).list();
		if(branchList.size() != 0) {
			return "branch_name already existed";
		}else {
			return "";
		}
	}

	@Override
	public String getByBranchCode(String parameter) {
		Session session = this.sessionFactory.getCurrentSession();
		List<BranchMaster> branchList =  session.createCriteria(BranchMaster.class).add(Restrictions.eq("branch_code", parameter)).list();
		if(branchList.size() != 0) {
			return "branch_name already existed";
		}else {
			return "";
		}
	}
}
