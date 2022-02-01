package com.assignment.daofab.dto;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

/**
 * DTO class for TransactionInformation entity used with client interactions.
 */
@ApiModel(description="All details about the TransactionInformation dto.")
@Data
@Builder
public class TransactionInformationDTO {
	private Long id;
	private String sender;
	private String receiver;
	private Long totalAmount;
	private Long totalPaidAmount;
}
