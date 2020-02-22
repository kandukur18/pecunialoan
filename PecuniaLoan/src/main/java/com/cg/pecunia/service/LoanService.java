package com.cg.pecunia.service;

import java.util.List;

import com.cg.pecunia.model.Loan;
import com.cg.pecunia.exception.LoanException;

public interface LoanService {
	public Loan addLoanDetails(String accountId, double amount, int tenure, double rateOfInterest, int creditScore ) throws LoanException;
	public String createLoanRequest(Loan loan) throws LoanException;
	public List<Loan> loanRequestList() throws LoanException;
	public List<Loan> loanApprovalList(Loan loan) throws LoanException;
	public boolean validateAmount(double amount);
	public boolean validateTenure(int tenure);
	public boolean validateRateOfInterest(double rateOfInterest);
	public boolean validateCreditScore(int creditScore);
	public String loanApprovalStatus(Loan loan) throws LoanException;
	public double calculateEmiForLoan(Loan loan) throws LoanException;

}
