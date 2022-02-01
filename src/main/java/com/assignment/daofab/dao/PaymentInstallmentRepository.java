package com.assignment.daofab.dao;

import com.assignment.daofab.entities.PaymentInstallment;
import java.util.List;

/**
 * Repository to handle all database operation for payment installment.
 */
public interface PaymentInstallmentRepository extends BaseRepository<PaymentInstallment, Long>{

  /**
   * Method to get all installments of a transaction
   * @param transactionId
   * @return
   */
  List<PaymentInstallment> findAllByTransactionInformation_Id(Long transactionId);
}
