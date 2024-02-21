package com.pranshu.splitwise.controllers;

import com.pranshu.splitwise.dtos.CreateExpenseDto;
import com.pranshu.splitwise.dtos.CreateGroupDto;
import com.pranshu.splitwise.models.Group;
import com.pranshu.splitwise.models.GroupExpense;
import com.pranshu.splitwise.models.SettleUpTransaction;
import com.pranshu.splitwise.services.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/group")
public class GroupController {

    private GroupService groupService;

    @PostMapping("/")
    public Group createGroup(@RequestBody CreateGroupDto request) {
        return groupService.createGroup(request);
    }

    @GetMapping("/{id}")
    public Group getGroup(@PathVariable Long id) {
        return groupService.getGroup(id);
    }

    @PostMapping("/{id}/expense")
    public GroupExpense createGroupExpense(@PathVariable Long id, @RequestBody CreateExpenseDto request) {
        return groupService.createGroupExpense(id, request);
    }

    @GetMapping("/{id}/settle")
    public List<SettleUpTransaction> settle(@PathVariable Long id) {
        return groupService.settle(id);
    }

    @GetMapping("/{id}/expense")
    public List<GroupExpense> getExpenses(@PathVariable Long id) {
        return groupService.getExpenses(id);
    }
}
