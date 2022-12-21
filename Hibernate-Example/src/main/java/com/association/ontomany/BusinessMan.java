package com.association.ontomany;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.association.onetoone.AccountEntity;

@Entity(name = "JoinTableEmployeeEntity")
@Table(name = "business_man", uniqueConstraints = {
    @UniqueConstraint(columnNames = "ID"),
    @UniqueConstraint(columnNames = "EMAIL")})
public class BusinessMan implements Serializable {

  @Serial
  private static final long serialVersionUID = -1798070786993154676L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "ID", unique = true, nullable = false)
  private Integer employeeId;

  @Column(name = "EMAIL", unique = true, nullable = false, length = 100)
  private String email;

  @Column(name = "FIRST_NAME", nullable = false, length = 100)
  private String firstName;

  @Column(name = "LAST_NAME", nullable = false, length = 100)
  private String lastName;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinTable(name = "BUSINESS_ACCOUNT",
      joinColumns = {@JoinColumn(name = "BUSINESS_ID", referencedColumnName =
          "ID")}
      , inverseJoinColumns = {@JoinColumn(name = "BANK_ID",
      referencedColumnName = "ID")})
  private Set<BankAC> accounts;

  public Integer getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Integer employeeId) {
    this.employeeId = employeeId;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Set<BankAC> getAccounts() {
    return accounts;
  }

  public void setAccounts(Set<BankAC> accounts) {
    this.accounts = accounts;
  }
}