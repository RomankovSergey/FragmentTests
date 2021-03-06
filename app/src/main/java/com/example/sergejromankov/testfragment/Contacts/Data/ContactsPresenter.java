package com.example.sergejromankov.testfragment.Contacts.Data;


import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.example.sergejromankov.testfragment.Contacts.ContactsAdapterOutputInterface;
import com.example.sergejromankov.testfragment.Contacts.Models.ContactsInitModel;
import com.example.sergejromankov.testfragment.Contacts.Models.ContactsModel;
import com.example.sergejromankov.testfragment.Contacts.View.ContactsFragment;
import com.example.sergejromankov.testfragment.Contacts.View.ContactsView;
import com.example.sergejromankov.testfragment.Main.BaseMainPresenter;
import com.example.sergejromankov.testfragment.Main.MainRouter;
import com.example.sergejromankov.testfragment.NameFragment;
import com.example.sergejromankov.testfragment.R;
import com.example.sergejromankov.testfragment.TapBarItemFragment;

import java.util.ArrayList;

/**
 * Created by sergejromankov on 16.12.2017.
 */

public class ContactsPresenter extends BaseMainPresenter implements ContactsPresenterInterface, ContactsAdapterOutputInterface {

    private ContactsAdapter contactsAdapter;
    private ContactsInitModel contactsModel;
    private ContactsView view;
    private ContactsInteractor contactsInteractor;
    boolean isContactFragment = false;

    private Boolean isStartFragment;

    @Override
    public void init() {
        view = (ContactsView) getView();
        contactsInteractor = new ContactsInteractor(this);
        if(this.contactsModel == null){
            throw new IllegalArgumentException("Contacts model == null)");
        }

        // Изменение цвета
        view.viewBackground(contactsModel.color);

        // Запрос на получение данных из интерактора
        contactsInteractor.fetchContacts();

    }

    @Override
    public void onStart() {
        isStartFragment = true;

        if(isContactFragment) {
            Fragment fragment = (Fragment) view;
            MainRouter mainRouter = (MainRouter) fragment.getActivity();
            ContactsInitModel model = new ContactsInitModel();
            model.color = R.color.colorPrimaryDark;
            mainRouter.addFragmentToTapBar(NameFragment.instance("test"));
            isContactFragment = false;
        }
    }

    @Override
    public void onStop() {
        isStartFragment = false;
    }

    // ContactsPresenterInterface
    @Override
    public void updateContacts(ArrayList<ContactsModel> arrayList) {
        contactsAdapter.setModels(arrayList);
        contactsAdapter.notifyDataSetChanged();
    }
    // ContactsPresenterInterface

    public void setModel(ContactsInitModel contactsModel){
        this.contactsModel = contactsModel;
    }

    public ContactsAdapter getListAdapter(){
        if(contactsAdapter == null){
            contactsAdapter = new ContactsAdapter(this);
        }
        return contactsAdapter;
    }


    // ContactsAdapterOutputInterface
    @Override
    public void onClick(int index) {

        new CountDownTimer(3000, 1000) {

            public void onTick(long millisUntilFinished) {
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {

                if(!isStart){
                    isContactFragment = true;
                    return;
                }
                Fragment fragment = (Fragment)view;
                MainRouter mainRouter = (MainRouter) fragment.getActivity();
                ContactsInitModel model = new ContactsInitModel();
                model.color = R.color.colorPrimaryDark;
                mainRouter.addFragmentToTapBar(NameFragment.instance("test"));
            }

        }.start();


    }
}
