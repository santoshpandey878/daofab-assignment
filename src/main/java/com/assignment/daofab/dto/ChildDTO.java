package com.assignment.daofab.dto;

import com.assignment.daofab.entities.PaymentInstallment;
import com.assignment.daofab.entities.TransactionInformation;
import io.swagger.annotations.ApiModel;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO class to load child json data.
 */
@ApiModel(description="All details about the child json data.")
@Data
public class ChildDTO {
	List<PaymentInstallment> data;

}
