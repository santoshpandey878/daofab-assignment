package com.assignment.daofab.services;

import com.assignment.daofab.dto.PaymentInstallmentDTO;
import com.assignment.daofab.entities.PaymentInstallment;
import java.util.List;

/**
 * Interface responsible to provide methods for payment installment operations
 */
public interface PaymentInstallmentService {


	/**
	 * Method to get all installments of a transaction
	 * @param transactionId
	 * @return
	 */
	List<PaymentInstallmentDTO> getAllInstallments(Long transactionId);


	/**
	 * Method to add all payment installments
	 * @param paymentInstallments
	 */
	void addAllInstallments(List<PaymentInstallment> paymentInstallments);

}
