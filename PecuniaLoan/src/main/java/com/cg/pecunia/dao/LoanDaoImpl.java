package com.cg.pecunia.dao;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.cg.pecunia.model.Loan;
import com.cg.pecunia.exception.LoanException;

public class LoanDaoImpl implements LoanDao{
	private HashMap<String, Loan> loanMap;
	public LoanDaoImpl() {
		loanMap = new HashMap<String, Loan>();
	}
	
	
	
	public String createLoanRequest(Loan loan) throws LoanException {
		
		if(loanMap.containsKey(loan.getAccountId()))
			throw new LoanException("loan exsists for id");
		else
			loanMap.put(loan.getAccountId(),loan);
		return loan.getAccountId();
	}



	public Loan addLoanDetails(String accountId, double amount, int tenure, double rateOfInterest, int creditScore) throws LoanException {
		Loan loan = new Loan();
		loan.setAccountId(accountId);
		loan.setAmount(amount);
		loan.setRateOfInterest(rateOfInterest);
		loan.setCreditScore(creditScore);
		loan.setTenure(tenure);
		loan.setLoanStatus("pending");
		return loan;
	}

	@Override
	public String loanApprovalStatus(Loan loan) throws LoanException {
		// TODO Auto-generated method stub
		if(loan.getCreditScore()>=670 && loan.getCreditScore()<=999) {
			loan.setLoanStatus("approved");
			double balance = loan.getAccountBalance()+loan.getAmount();
			loan.setAccountBalance(balance);
		}
		else
			loan.setLoanStatus("rejected");
		
		double amount = loan.getAmount() + (loan.getAmount()*loan.getRateOfInterest()/100);
		double emi = amount/(loan.getTenure());
		if(loan.getLoanStatus().equals("approved"))
			loan.setEmi(emi);
		
		return loan.getLoanStatus();
	}

	public List<Loan> loanRequestList() throws LoanException {
		// TODO Auto-generated method stub
		Collection<Loan> collection = loanMap.values();
		List<Loan> list = new ArrayList<Loan>();
		for(Loan loan : collection) {
			list.add(loan);
		}
		return list;
	}



	@Override
	public List<Loan> loanApprovalList(Loan loan) throws LoanException {
		Collection<Loan> collection = loanMap.values();
		List<Loan> list = new ArrayList<Loan>();
		for(Loan approvedLoan : collection) {
			if(approvedLoan.getCreditScore()>=700 && approvedLoan.getCreditScore()<=999)
				list.add(approvedLoan);
		}
		return list;
	}
	


	@Override
	public double calculateEmiForLoan(Loan loan) throws LoanException {
		// TODO Auto-generated method stub
		
		if(loan.getLoanStatus().equals("approved"))
			return loan.getEmi();
		else 
			throw new LoanException("loan not approved");
		
	}



	



	
}
