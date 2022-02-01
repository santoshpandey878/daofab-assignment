package com.assignment.daofab.controller;

import com.assignment.daofab.dto.TransactionInformationDTO;
import com.assignment.daofab.services.TransactionInformationService;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * Transaction Information Controller responsible to handle all client requests related to transactions and return the response.
 * DTO is used to interact with client.
 */
@RestController
@RequestMapping(value = "/api/transactions")
@Api(value = "Transaction Information Controller responsible to handle all client requests related to transactions.")
public class TransactionInfoController {

	private final TransactionInformationService transactionInformationService;

	@Autowired
	public TransactionInfoController(TransactionInformationService transactionInformationService) {
		this.transactionInformationService = transactionInformationService;
	}

	/**
	 * API to get all transactions with pagination
	 * @param pageNo
	 * @param pageSize
	 * @param sortBy
	 * @return
	*/
	@GetMapping
	@ApiOperation(value = "API to get all transactions with pagination")
	public List<TransactionInformationDTO> getAllTransactions(
			@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "2") Integer pageSize,
			@RequestParam(defaultValue = "id") String sortBy
	) {
		return transactionInformationService.getAllTransactions(pageNo, pageSize, sortBy);
	}
}
