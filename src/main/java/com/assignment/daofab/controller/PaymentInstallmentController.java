package com.assignment.daofab.controller;

import com.assignment.daofab.services.PaymentInstallmentService;
import com.assignment.daofab.dto.PaymentInstallmentDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Payment Installment Controller responsible to handle all client requests related to installments and return the response.
 * DTO is used to interact with client.
 */
@RestController
@RequestMapping("/api/transactions/{transactionId}/installments")
@Api(value = "Payment Installment Controller responsible to handle all client requests related to installments.")
public class PaymentInstallmentController {

	private final PaymentInstallmentService paymentInstallmentService;

	@Autowired
	public PaymentInstallmentController(PaymentInstallmentService paymentInstallmentService) {
		this.paymentInstallmentService = paymentInstallmentService;
	}


	/**
	 * API to get all installments of a transaction
	 * @param transactionId
	 * @return
	 */
	@GetMapping
	@ApiOperation(value = "API to get all installments of a transaction")
	public List<PaymentInstallmentDTO> getAllInstallments(@PathVariable("transactionId") Long transactionId) {
		return paymentInstallmentService.getAllInstallments(transactionId);
	}
}
