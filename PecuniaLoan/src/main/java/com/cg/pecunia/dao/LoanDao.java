package com.cg.pecunia.dao;

import java.util.List;

import com.cg.pecunia.model.Loan;
import com.cg.pecunia.exception.LoanException;

public interface LoanDao {
	
	public Loan addLoanDetails(String accountId, double amount, int tenure, double rateOfInterest, int creditScore ) throws LoanException;
	public String createLoanRequest(Loan loan) throws LoanException;
	public List<Loan> loanRequestList() throws LoanException;
	public List<Loan> loanApprovalList(Loan loan) throws LoanException;
	public String loanApprovalStatus(Loan loan) throws LoanException;
	public double calculateEmiForLoan(Loan loan) throws LoanException;
}
