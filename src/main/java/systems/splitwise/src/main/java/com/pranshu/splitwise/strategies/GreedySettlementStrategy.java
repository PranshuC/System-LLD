package com.pranshu.splitwise.strategies;

import com.pranshu.splitwise.models.User;
import com.pranshu.splitwise.models.Expense;
import com.pranshu.splitwise.models.SettleUpTransaction;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class GreedySettlementStrategy implements SettlementStrategy {

    @Override
    public List<SettleUpTransaction> settleExpenses(List<Expense> expenses) {

        // 1. Compute the balances
        Map<Long, Double> balances = computeBalances(expenses);
        // 1.5 Create heap, TreeSet implementation
        TreeSet<Pair<Long, Double>> expenseTree = new TreeSet<>((left, right) -> (int) (left.getSecond() - right.getSecond()));
        for (Map.Entry<Long, Double> entry : balances.entrySet()) {
            expenseTree.add(Pair.of(entry.getKey(), entry.getValue()));
        }

        // 2. Iterate over the balances
        List<SettleUpTransaction> transactions = new ArrayList<>();
        while (expenseTree.size() > 1) {

            // 3. Pick the max and min
            Pair<Long, Double> smallestPair = expenseTree.first();
            Pair<Long, Double> largestPair = expenseTree.last();
            SettleUpTransaction transaction = SettleUpTransaction.builder()
                    .from(largestPair.getFirst())
                    .to(smallestPair.getFirst())
                    .amount(largestPair.getSecond()).build();

            // 4. Remove the existing balances and add a new one
            expenseTree.remove(largestPair);
            expenseTree.remove(smallestPair);
            expenseTree.add(Pair.of(smallestPair.getFirst(), smallestPair.getSecond() + largestPair.getSecond()));
            transactions.add(transaction);
        }

        return transactions;
    }

    private static Map<Long, Double> computeBalances(List<Expense> expenses) {
        Map<Long, Double> balances = new HashMap<>();

        // Iterate over expenses
        for (Expense expense : expenses) {

            // In the expense, what is owed by
            for (User user : expense.getOwedBy().keySet()) {
                if (!balances.containsKey(user.getId())) {
                    balances.put(user.getId(), 0.0);
                }
                // Update the balance
                balances.put(user.getId(), balances.get(user.getId()) + expense.getOwedBy().get(user));
            }

            // In the expense, what is paid by
            for (User user : expense.getPaidBy().keySet()) {
                if (!balances.containsKey(user.getId())) {
                    balances.put(user.getId(), 0.0);
                }
                // Update the balance
                balances.put(user.getId(), balances.get(user.getId()) - expense.getPaidBy().get(user));
            }
        }
        return balances;
    }
}
