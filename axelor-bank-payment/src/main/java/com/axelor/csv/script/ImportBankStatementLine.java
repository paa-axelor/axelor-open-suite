/*
 * Axelor Business Solutions
 *
 * Copyright (C) 2005-2024 Axelor (<http://axelor.com>).
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.axelor.csv.script;

import com.axelor.apps.bankpayment.db.BankStatementLine;
import com.axelor.apps.bankpayment.service.CurrencyScaleServiceBankPayment;
import com.axelor.apps.base.db.BankDetails;
import com.axelor.apps.base.db.repo.BankDetailsRepository;
import java.util.Map;
import javax.inject.Inject;

public class ImportBankStatementLine {

  protected BankDetailsRepository bankDetailsRepository;
  protected CurrencyScaleServiceBankPayment currencyScaleServiceBankPayment;

  @Inject
  public ImportBankStatementLine(
      BankDetailsRepository bankDetailsRepository,
      CurrencyScaleServiceBankPayment currencyScaleServiceBankPayment) {
    this.bankDetailsRepository = bankDetailsRepository;
    this.currencyScaleServiceBankPayment = currencyScaleServiceBankPayment;
  }

  public Object importBankStatementLine(Object bean, Map<String, Object> values) {
    assert bean instanceof BankStatementLine;
    BankStatementLine bankStatementLine = (BankStatementLine) bean;

    if (values.get("bankDetails_iban") != null) {
      BankDetails bankDetails =
          bankDetailsRepository.findByIban((String) values.get("bankDetails_iban"));
      bankStatementLine.setBankDetails(bankDetails);
    }

    // Used for Bank reconcile process
    bankStatementLine.setAmountRemainToReconcile(
        currencyScaleServiceBankPayment.getScaledValue(
            bankStatementLine, bankStatementLine.getDebit().add(bankStatementLine.getCredit())));

    return bankStatementLine;
  }
}