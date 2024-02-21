package com.pranshu.splitwise.strategies;

import com.pranshu.splitwise.models.Expense;
import com.pranshu.splitwise.models.SettleUpTransaction;

import java.util.List;

public interface SettlementStrategy {
    List<SettleUpTransaction> settleExpenses(List<Expense> expenses);

}
