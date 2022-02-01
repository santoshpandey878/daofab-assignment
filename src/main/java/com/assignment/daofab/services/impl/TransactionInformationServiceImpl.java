package com.assignment.daofab.services.impl;

import com.assignment.daofab.core.constant.MessageConstant;
import com.assignment.daofab.core.exceptions.ResourceNotFoundException;
import com.assignment.daofab.core.utils.MessageUtil;
import com.assignment.daofab.dao.TransactionInformationRepository;
import com.assignment.daofab.dto.PaymentInstallmentDTO;
import com.assignment.daofab.dto.TransactionInformationDTO;
import com.assignment.daofab.entities.TransactionInformation;
import com.assignment.daofab.services.TransactionInformationService;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *  Class responsible to handle business logic for transaction operations
 */
@Service
public class TransactionInformationServiceImpl implements TransactionInformationService {

	private final TransactionInformationRepository transactionInformationRepository;
	private final MessageUtil message;

	@Autowired
	public TransactionInformationServiceImpl(TransactionInformationRepository transactionInformationRepository,
											 MessageUtil message) {
		this.transactionInformationRepository = transactionInformationRepository;
		this.message = message;
	}

	@Override
	public TransactionInformation getTransaction(Long id) {
		return transactionInformationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(message.get(MessageConstant.TRANSACTION_NOT_FOUND, id)));
	}

	@Transactional
	@Override
	public void addAllTransactions(List<TransactionInformation> transactionInformations) {
		transactionInformationRepository.saveAll(transactionInformations);
	}

	@Override
	public List<TransactionInformationDTO> getAllTransactions(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		Page<TransactionInformation> pagedResult = transactionInformationRepository.findAll(paging);

		if(pagedResult.hasContent()) {
			List<TransactionInformation> transactionInformations = pagedResult.getContent();
			List<TransactionInformationDTO> transactionInformationsDTOs = transactionInformations.stream().map(transaction -> {
				TransactionInformationDTO transactionInformationsDTO = TransactionInformationDTO
						.builder()
						.id(transaction.getId())
						.sender(transaction.getSender())
						.receiver(transaction.getReceiver())
						.totalAmount(transaction.getTotalAmount())
						.totalPaidAmount(getTotalPaidAmount(transaction))
						.build();
				return transactionInformationsDTO;
			}).collect(Collectors.toList());
			return transactionInformationsDTOs;
		} else {
			return new ArrayList<>();
		}
	}

	/**
	 * Method to calculate total paid amount from all installments
	 * @param transaction
	 * @return
	 */
	private long getTotalPaidAmount(TransactionInformation transaction) {
		if(null != transaction.getPaymentInstallments()) {
			return transaction.getPaymentInstallments().stream().collect(Collectors.summingLong(trans -> trans.getPaidAmount()));
		}
		return 0;
	}
}
