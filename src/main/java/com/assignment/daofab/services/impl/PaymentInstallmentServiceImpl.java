package com.assignment.daofab.services.impl;

import com.assignment.daofab.dao.PaymentInstallmentRepository;
import com.assignment.daofab.dto.PaymentInstallmentDTO;
import com.assignment.daofab.entities.PaymentInstallment;
import com.assignment.daofab.entities.TransactionInformation;
import com.assignment.daofab.services.PaymentInstallmentService;
import com.assignment.daofab.services.TransactionInformationService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *  Class responsible to handle business logic for payment installment operations
 */
@Service
public class PaymentInstallmentServiceImpl implements PaymentInstallmentService {

	private final PaymentInstallmentRepository paymentInstallmentRepository;
	private final TransactionInformationService transactionInformationService;

	@Autowired
	public PaymentInstallmentServiceImpl(PaymentInstallmentRepository paymentInstallmentRepository,
										 TransactionInformationService transactionInformationService) {
		this.paymentInstallmentRepository = paymentInstallmentRepository;
		this.transactionInformationService = transactionInformationService;
	}


	@Override
	public List<PaymentInstallmentDTO> getAllInstallments(Long transactionId) {
		TransactionInformation transactionInformation = transactionInformationService.getTransaction(transactionId);

		List<PaymentInstallment> installments = paymentInstallmentRepository.findAllByTransactionInformation_Id(transactionId);
		List<PaymentInstallmentDTO> installmentsDTOs = installments.stream().map(installment -> {
			PaymentInstallmentDTO paymentInstallmentDTO = PaymentInstallmentDTO
					.builder()
					.id(installment.getId())
					.paidAmount(installment.getPaidAmount())
					.sender(transactionInformation.getSender())
					.receiver(transactionInformation.getReceiver())
					.totalAmount(transactionInformation.getTotalAmount())
					.build();
			return paymentInstallmentDTO;
		}).collect(Collectors.toList());
		return installmentsDTOs;
	}

	@Transactional
	@Override
	public void addAllInstallments(List<PaymentInstallment> paymentInstallments) {
		paymentInstallmentRepository.saveAll(paymentInstallments);
	}
}
