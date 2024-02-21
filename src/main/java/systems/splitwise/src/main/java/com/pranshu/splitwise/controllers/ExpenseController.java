package com.pranshu.splitwise.controllers;

import com.pranshu.splitwise.dtos.CreateExpenseDto;
import com.pranshu.splitwise.models.Expense;
import com.pranshu.splitwise.services.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/expense")
public class ExpenseController {

    private ExpenseService service;

    @PostMapping("/")
    public Expense createExpense(@RequestBody CreateExpenseDto request) {
        return service.createExpense(request);
    }

    @GetMapping("/{id}")
    public Expense getExpense(@PathVariable Long id) {
        return service.getExpense(id);
    }

    @GetMapping("/")
    public List<Expense> getExpenses() {
        return service.getExpenses();
    }

}
