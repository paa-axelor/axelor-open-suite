package com.axelor.apps.account.service;

import com.axelor.apps.account.db.AnalyticMoveLine;
import com.axelor.apps.account.db.Invoice;
import com.axelor.apps.account.db.InvoiceLine;
import com.axelor.apps.account.db.InvoicePayment;
import com.axelor.apps.account.db.InvoiceTerm;
import com.axelor.apps.account.db.Move;
import com.axelor.apps.account.db.MoveLine;
import com.axelor.apps.base.db.Company;
import com.axelor.apps.base.db.Currency;
import com.axelor.apps.base.service.CurrencyScaleService;
import java.math.BigDecimal;

public interface CurrencyScaleServiceAccount extends CurrencyScaleService {

  BigDecimal getScaledValue(Move move, BigDecimal amount);

  BigDecimal getCompanyScaledValue(Move move, BigDecimal amount);

  BigDecimal getScaledValue(MoveLine moveLine, BigDecimal amount);

  BigDecimal getCompanyScaledValue(MoveLine moveLine, BigDecimal amount);

  BigDecimal getScaledValue(InvoiceTerm invoiceTerm, BigDecimal amount);

  BigDecimal getCompanyScaledValue(InvoiceTerm invoiceTerm, BigDecimal amount);

  BigDecimal getScaledValue(Invoice invoice, BigDecimal amount);

  BigDecimal getCompanyScaledValue(Invoice invoice, BigDecimal amount);

  BigDecimal getScaledValue(InvoiceLine invoiceLine, BigDecimal amount);

  BigDecimal getCompanyScaledValue(InvoiceLine invoiceLine, BigDecimal amount);

  BigDecimal getScaledValue(InvoicePayment invoicePayment, BigDecimal amount);

  BigDecimal getCompanyScaledValue(InvoicePayment invoicePayment, BigDecimal amount);

  BigDecimal getScaledValue(AnalyticMoveLine analyticMoveLine, BigDecimal amount);

  int getScale(Move move);

  int getCompanyScale(Move move);

  int getScale(MoveLine moveLine);

  int getCompanyScale(MoveLine moveLine);

  int getScale(Invoice invoice);

  int getCompanyScale(Invoice invoice);

  int getScale(InvoiceLine invoiceLine);

  int getCompanyScale(InvoiceLine invoiceLine);

  int getScale(InvoiceTerm invoiceTerm);

  int getCompanyScale(InvoiceTerm invoiceTerm);

  int getScale(InvoicePayment invoicePayment);

  int getCompanyScale(InvoicePayment invoicePayment);

  int getScale(AnalyticMoveLine analyticMoveLine);

  int getScale(Currency currency);

  int getCompanyScale(Company company);
}