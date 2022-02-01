package com.assignment.daofab.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 * Entity class for transaction_information table
 */
@Data
@Entity
@Table(name = "transaction_information")
public class TransactionInformation implements Serializable{
	private static final long serialVersionUID = 4181157730494809671L;

	@Id
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "sender", nullable = false)
	private String sender;

	@Column(name = "receiver", nullable = false)
	private String receiver;

	@Column(name = "total_amount", nullable = false)
	private Long totalAmount;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transactionInformation", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PaymentInstallment> paymentInstallments;

}
