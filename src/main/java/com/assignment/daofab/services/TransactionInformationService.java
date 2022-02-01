package com.assignment.daofab.services;

import com.assignment.daofab.dto.TransactionInformationDTO;
import com.assignment.daofab.entities.TransactionInformation;
import java.util.List;

/**
 * Interface responsible to provide methods for transaction operations
 */
public interface TransactionInformationService {

	/**
	 * Method to get a transaction by id
	 * @param id
	 * @return
	 */
	TransactionInformation getTransaction(Long id);

	/**
	 * Method to add all transactions
	 * @param transactionInformations
	 */
  	void addAllTransactions(List<TransactionInformation> transactionInformations);

	/**
	 * Method to get all transactions with pagination
	 * @param pageNo
	 * @param pageSize
	 * @param sortBy
	 * @return
	 */
	List<TransactionInformationDTO> getAllTransactions(Integer pageNo, Integer pageSize, String sortBy);
}
