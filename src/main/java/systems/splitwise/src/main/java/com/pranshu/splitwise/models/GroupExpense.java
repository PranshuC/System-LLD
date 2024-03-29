package com.pranshu.splitwise.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroupExpense extends BaseModel {

    @ManyToOne
    private Group group;

    // Composition relation
    @OneToOne
    private Expense expense;
}
