package com.association.ontomany;
import java.io.Serial;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.ManyToAny;



@Entity(name = "JoinTableAccountEntity")
@Table(name = "BankAc", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ID")})
public class BankAC implements Serializable 
{
	@Serial
	private static final long serialVersionUID = -6790693372846798580L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer accountId;

	@Column(name = "ACC_NUMBER", unique = true, nullable = false, length = 100)
	private String accountNumber;
	
	@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "categoryId", nullable = false)
	private BusinessMan businessMan;
	
	public BusinessMan getBusinessMan() {
		return businessMan;
	}

	public void setBusinessMan(BusinessMan businessMan) {
		this.businessMan = businessMan;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
}