package com.example.sergejromankov.testfragment.Contacts.Data;

/**
 * Created by sergejromankov on 10.01.2018.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sergejromankov.testfragment.Contacts.ContactsAdapterOutputInterface;
import com.example.sergejromankov.testfragment.Contacts.Models.ContactsModel;
import com.example.sergejromankov.testfragment.R;

import java.util.ArrayList;


public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> implements View.OnClickListener {

    private ArrayList<ContactsModel> arrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ContactsAdapterOutputInterface outputInterface;

    public ContactsAdapter(ContactsAdapterOutputInterface outputInterface) {
        this.outputInterface = outputInterface;
    }


    public void setModels(ArrayList<ContactsModel> list){
        arrayList = list;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_list_item, parent, false);
        view.setOnClickListener(this);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ContactsModel contactsModel = arrayList.get(position);
        holder.textView.setText(String.valueOf(contactsModel.index));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    // OnClickListener
    @Override
    public void onClick(View v) {
        int itemPosition = recyclerView.getChildLayoutPosition(v);
        if(outputInterface != null){
            outputInterface.onClick(itemPosition);
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
