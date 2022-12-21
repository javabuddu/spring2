package com.association.onetoone;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
@Builder
@Entity(name = "ForeignKeyAssEmployeeEntity")
@Table(name = "Borrower", uniqueConstraints = {
    @UniqueConstraint(columnNames = "ID"),
    @UniqueConstraint(columnNames = "EMAIL")})
public class EmployeeEntity implements Serializable {

  private static final long serialVersionUID = -1798070786993154676L;

  public EmployeeEntity() {}

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", unique = true, nullable = false)
  private Integer employeeId;

  @Column(name = "EMAIL", unique = true, nullable = false, length = 100)
  private String email;

  @Column(name = "FIRST_NAME", unique = false, nullable = false, length = 100)
  private String firstName;

  @Column(name = "LAST_NAME", unique = false, nullable = false, length = 100)
  private String lastName;

  @OneToOne(cascade = CascadeType.ALL,mappedBy = "employee")
  @JoinColumn(name = "ACCOUNT_ID")
  @OrderBy("firstName ASC, email DESC")
  private AccountEntity account;
}