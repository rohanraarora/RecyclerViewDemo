package gitapp.forkthecode.com.recyclerviewdemo;

import java.util.ArrayList;

/**
 * Created by ralph on 08/10/17.
 */

public class Expense {

    private String title;
    private String description;

    public Expense(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static ArrayList<Expense> getRandomExpenses(int size){
        ArrayList<Expense> expenses = new ArrayList<>();
        for(int i = 0;i<size;i++){
            Expense expense = new Expense("Title " + i,"Description " + i);
            expenses.add(expense);
        }
        return expenses;

    }

}
