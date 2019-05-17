package com.derrick.park.assignment3_contacts.activities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.derrick.park.assignment3_contacts.R;
import com.derrick.park.assignment3_contacts.models.Contact;
import com.derrick.park.assignment3_contacts.models.ContactList;

import java.util.ArrayList;

import retrofit2.Callback;


public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.WordViewHolder> {
    private final ArrayList<Contact> mContactList;
    private LayoutInflater mInflater;

    @NonNull
    @Override
    public ContactListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.contactlist_item, viewGroup, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactListAdapter.WordViewHolder wordViewHolder, int i) {
        String name = mContactList.get(i).getName().getFirst() + " " + mContactList.get(i).getName().getLast();
        String phone = mContactList.get(i).getCell();
        wordViewHolder.contactName.setText(name);
        wordViewHolder.contactPhone.setText(phone);
    }

    @Override
    public int getItemCount() {
        return mContactList.size();
    }

    public ContactListAdapter(Context context, ArrayList<Contact> mWordList) {
        mInflater = LayoutInflater.from(context);
        this.mContactList = mWordList;
    }

    class WordViewHolder extends RecyclerView.ViewHolder {
        public final TextView contactName;
        public final TextView contactPhone;

        public WordViewHolder(@NonNull View itemView, ContactListAdapter adapter) {
            super(itemView);
            contactName = itemView.findViewById(R.id.contactName);
            contactPhone = itemView.findViewById(R.id.contactPhone);
        }

    }
}

