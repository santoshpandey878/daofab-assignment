package com.assignment.daofab.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Data;

/**
 * Entity class for payment_installment table
 */
@Data
@Entity
@Table(name = "payment_installment")
public class PaymentInstallment implements Serializable{
	private static final long serialVersionUID = 4181157730494809671L;

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "paid_amount", nullable = false)
	private Long paidAmount;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="transaction_id")
	private TransactionInformation transactionInformation;

	@Transient
	private Long parentId;
}
