package com.example.noteappsharedpreference;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    private static final String MENU_DELETE = "DELETE";
    private static final String MENU_EDIT = "EDIT";
    ArrayList<Note> noteArrayList;

    public interface EditClickListener {
        void onEditClick(int position);
    }

    private EditClickListener editClickListener;

    public MyAdapter(Context context, ArrayList<Note> noteArrayList, EditClickListener editClickListener) {
        this.context = context;
        this.noteArrayList = noteArrayList;
        this.editClickListener = editClickListener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Note note = noteArrayList.get(position);
        holder.titleOutput.setText(note.getTitle());
        holder.descriptionOutput.setText(note.getDescription());

        holder.itemView.setOnLongClickListener(v -> {
            showPopupMenu(v, position);
            return true;
        });

// Add this click listener for the "Edit" option
        holder.itemView.setOnClickListener(v -> {
            if (editClickListener != null) {
                editClickListener.onEditClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return noteArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titleOutput;
        TextView descriptionOutput;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleOutput = itemView.findViewById(R.id.titleoutput);
            descriptionOutput = itemView.findViewById(R.id.descriptionoutput);
        }
    }

    private void showPopupMenu(View view, int position) {
        PopupMenu menu = new PopupMenu(context, view);
        menu.getMenu().add(MENU_DELETE);
        menu.getMenu().add(MENU_EDIT);
        menu.setOnMenuItemClickListener(item -> {
            if (MENU_DELETE.equals(item.getTitle())) {
                removeItem(position);
                Toast.makeText(context, "Note deleted", Toast.LENGTH_SHORT).show();
            } else if (MENU_EDIT.equals(item.getTitle())) {
                if (editClickListener != null) {
                    editClickListener.onEditClick(position);
                }
            }
            return true;
        });
        menu.show();
    }


    public void removeItem(int position) {
        noteArrayList.remove(position);
        notifyItemRemoved(position);
    }
}
