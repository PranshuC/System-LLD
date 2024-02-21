package com.pranshu.splitwise.services;

import com.pranshu.splitwise.strategies.SettlementStrategy;
import com.pranshu.splitwise.models.Expense;
import com.pranshu.splitwise.models.SettleUpTransaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SettlementService {
    private SettlementStrategy settlementStrategy;

    public List<SettleUpTransaction> settle(List<Expense> expenses) {
        return settlementStrategy.settleExpenses(expenses);
    }
}
