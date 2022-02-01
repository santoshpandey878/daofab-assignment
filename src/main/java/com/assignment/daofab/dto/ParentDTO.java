package com.assignment.daofab.dto;

import com.assignment.daofab.entities.TransactionInformation;
import io.swagger.annotations.ApiModel;
import java.util.LinkedList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO class to load parent json data.
 */
@ApiModel(description="All details about the parent json data.")
@Data
public class ParentDTO {
	private List<TransactionInformation> data;

}
