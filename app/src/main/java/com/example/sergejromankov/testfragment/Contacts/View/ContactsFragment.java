package com.example.sergejromankov.testfragment.Contacts.View;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sergejromankov.testfragment.Contacts.Data.ContactsPresenter;
import com.example.sergejromankov.testfragment.Contacts.Models.ContactsInitModel;
import com.example.sergejromankov.testfragment.Main.General.BaseFragment;
import com.example.sergejromankov.testfragment.R;


/**
 * Created by sergejromankov on 16.12.2017.
 */

public class ContactsFragment extends BaseFragment implements ContactsView {

    private ContactsPresenter presenter;
    private RecyclerView recyclerView;
    private View view;
    static String CONTACTS_MODEL = "CONTACTS_MODEL";

    public static ContactsFragment instance(ContactsInitModel contactsModel){
        ContactsFragment fragment = new ContactsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(CONTACTS_MODEL, contactsModel);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ContactsPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.contacts_fragment, container, false);
        // Создания Листа
        recyclerView = (RecyclerView) view.findViewById(R.id.contacts_list);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(presenter.getListAdapter());

        // Получение аргументов
        Bundle bundle = getArguments();
        ContactsInitModel contactsModel = (ContactsInitModel) bundle.getSerializable(CONTACTS_MODEL);
        presenter.setModel(contactsModel);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.init();
    }

    @NonNull
    @Override
    protected ContactsPresenter getPresenter() {
        return presenter;
    }


    // ViewInterface
    @Override
    public void viewBackground(int color) {
        view.setBackgroundResource(color);
    }
}
