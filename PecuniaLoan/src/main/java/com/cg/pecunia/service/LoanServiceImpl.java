package com.cg.pecunia.service;

import java.util.List;

import com.cg.pecunia.model.Loan;
import com.cg.pecunia.dao.LoanDao;
import com.cg.pecunia.dao.LoanDaoImpl;
import com.cg.pecunia.exception.LoanException;

public class LoanServiceImpl implements LoanService {
	
	private LoanDao loanDao;
	
	public LoanServiceImpl() {
		loanDao = new LoanDaoImpl();
	}

	public Loan addLoanDetails(String accountId, double amount, int tenure, double rateOfInterest, int creditScore) throws LoanException {
		// TODO Auto-generated method stub
		if(!accountId.matches("[0-9]{12}"))
			throw new LoanException("Invalid account Id : Id should be 12 digit");
		if(!validateAmount(amount))
			throw new LoanException("Invalid Loan amount : Amount should be greater than 1000");
		if(!validateTenure(tenure))
			throw new LoanException("Invalid tenure: entered value is not valid");
		if(!validateRateOfInterest(rateOfInterest))
			throw new LoanException("Invalid Interest rate : Rate of interest should be  in range of 4% to 15%");
		if(!validateCreditScore(creditScore))
			throw new LoanException("Invalid credit score : credit score should be in range of 100 to 999");
		
		return loanDao.addLoanDetails(accountId, amount, tenure, rateOfInterest, creditScore) ;
	}

	public String createLoanRequest(Loan loan) throws LoanException {
		// TODO Auto-generated method stub
		return loanDao.createLoanRequest(loan);
	}

	public List<Loan> loanRequestList() throws LoanException {
		// TODO Auto-generated method stub
		return loanDao.loanRequestList();
	}

	@Override
	public List<Loan> loanApprovalList(Loan loan) throws LoanException {
		// TODO Auto-generated method stub
		return loanDao.loanApprovalList(loan);
	}

	@Override
	public boolean validateAmount(double amount) {
		// TODO Auto-generated method stub
		if(amount>=1000 && amount<=10000000)
			return true;
		return false;
	}

	@Override
	public boolean validateTenure(int tenure) {
		// TODO Auto-generated method stub
		if(tenure>=12 && tenure<=240)
			return true;
		return false;
	}

	@Override
	public boolean validateRateOfInterest(double rateOfInterest) {
		// TODO Auto-generated method stub
		if(rateOfInterest>=4 && rateOfInterest<=15)
			return true;
		return false;
	}

	@Override
	public boolean validateCreditScore(int creditScore) {
		// TODO Auto-generated method stub
		if(creditScore>=100 && creditScore<=999)
			return true;
		return false;
	}

	@Override
	public String loanApprovalStatus(Loan loan) throws LoanException {
		// TODO Auto-generated method stub
		return loanDao.loanApprovalStatus(loan);
	}

	@Override
	public double calculateEmiForLoan(Loan loan) throws LoanException {
		// TODO Auto-generated method stub
		return loanDao.calculateEmiForLoan(loan);
	}

}
