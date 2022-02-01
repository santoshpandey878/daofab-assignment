package com.assignment.daofab.parser;

import com.assignment.daofab.core.utils.FileUtil;
import com.assignment.daofab.core.utils.JsonToJavaUtilities;
import com.assignment.daofab.dto.ChildDTO;
import com.assignment.daofab.dto.ParentDTO;
import com.assignment.daofab.entities.PaymentInstallment;
import com.assignment.daofab.services.PaymentInstallmentService;
import com.assignment.daofab.services.TransactionInformationService;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class JsonFileParser {

  @Value("${parent.json.file}")
  private String parentFile;

  @Value("${child.json.file}")
  private String childFile;

  @Autowired
  private TransactionInformationService transactionInformationService;

  @Autowired
  private PaymentInstallmentService paymentInstallmentService;

  @Autowired
  ResourceLoader resourceLoader;

  @PostConstruct
  public void parseProductFile() {
    parseParentJsonFile();
    parseChildJsonFile();
  }

  private void parseParentJsonFile() {
    List<String> content = FileUtil.readFileFromResource(resourceLoader.getResource(parentFile));
    ParentDTO parentDTO = JsonToJavaUtilities.jsonObjectToJavaObject(content.get(0), ParentDTO.class);
    System.out.println(content.get(0));
    System.out.println(parentDTO);
    System.out.println(parentDTO.getData().size());

    transactionInformationService.addAllTransactions(parentDTO.getData());
  }

  private void parseChildJsonFile() {
    List<String> content = FileUtil.readFileFromResource(resourceLoader.getResource(childFile));
    ChildDTO childDTO = JsonToJavaUtilities.jsonObjectToJavaObject(content.get(0), ChildDTO.class);
    List<PaymentInstallment> paymentInstallments = childDTO.getData();
    System.out.println(content.get(0));
    System.out.println(childDTO);
    System.out.println(childDTO.getData().size());
    paymentInstallments.forEach(paymentInstallment -> {
      paymentInstallment.setTransactionInformation(transactionInformationService.getTransaction(paymentInstallment.getParentId()));
    });
    paymentInstallmentService.addAllInstallments(paymentInstallments);
  }
}
