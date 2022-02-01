package com.assignment.daofab.dto;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

/**
 * DTO class for PaymentInstallment entity used with client interactions.
 */
@ApiModel(description="All details about the PaymentInstallment dto.")
@Data
@Builder
public class PaymentInstallmentDTO {
	private Long id;
	private String sender;
	private String receiver;
	private Long totalAmount;
	private Long paidAmount;
}
