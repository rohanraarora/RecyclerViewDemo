package gitapp.forkthecode.com.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ralph on 08/10/17.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ExpenseViewHolder>{

    ArrayList<Expense> mExpenses;
    Context mContext;
    ExpenseClickListener mListener;


    public CustomAdapter(Context context,ArrayList<Expense> expenses,ExpenseClickListener listener){
        mExpenses = expenses;
        mContext = context;
        mListener = listener;

    }



    @Override
    public ExpenseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(mContext).inflate(R.layout.row_expense,parent,false);
        return new ExpenseViewHolder(rowView,mListener);
    }

    @Override
    public void onBindViewHolder(ExpenseViewHolder holder, int position) {

        Expense expense = mExpenses.get(position);
        holder.title.setText(expense.getTitle());
        holder.description.setText(expense.getDescription());


    }

    @Override
    public int getItemCount() {
        return mExpenses.size();
    }

    public static class ExpenseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView title;
        TextView description;
        Button delete;
        View itemView;
        ExpenseClickListener clickListener;

        public ExpenseViewHolder(View itemView, ExpenseClickListener listener) {
            super(itemView);
            this.itemView = itemView;
            clickListener = listener;
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            delete = itemView.findViewById(R.id.delete);
            delete.setOnClickListener(this);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

            int position = getAdapterPosition();

            if(view == delete){
                clickListener.onDeleteClick(position);
            }else if(view == itemView) {
                clickListener.onItemClick(position);
            }


        }
    }

    public interface ExpenseClickListener{

        void onItemClick(int position);
        void onDeleteClick(int position);

    }

}
