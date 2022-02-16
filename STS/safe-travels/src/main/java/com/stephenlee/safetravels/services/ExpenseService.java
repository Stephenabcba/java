package com.stephenlee.safetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stephenlee.safetravels.models.Expense;
import com.stephenlee.safetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
    // Option 2, can skip private final + constructor
    @Autowired
    private ExpenseRepository expenseRepo;

    // returns all the expenses
    public List<Expense> allExpenses() {
        return expenseRepo.findAll();
    }
    // creates an expense
    public Expense createExpense(Expense e) {
        return expenseRepo.save(e);
    }
    // retrieves an expense
    public Expense findExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepo.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }
}
