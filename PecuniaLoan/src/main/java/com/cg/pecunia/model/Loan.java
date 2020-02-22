package com.cg.pecunia.model;

public class Loan {
	private String accountId;
	private int tenure;
	private double amount;
	private double rateOfInterest;
	private String loanStatus;
	private int creditScore;
	private double accountBalance;
	private double emi;
	public double getEmi() {
		return emi;
	}
	public void setEmi(double emi) {
		this.emi = emi;
	}
	public Loan() {
		super();
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	public String getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	public int getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public String toString() {
		return accountId+"\t\t"+tenure+"\t\t"+amount+"\t\t"+rateOfInterest+"%\t\t\t\t"+creditScore+"\t\t\t"+loanStatus+"\t\t"+accountBalance+"\t\t"+emi;
	}
	
	

}
