package com.example.sergejromankov.testfragment.Contacts.Data;

import com.example.sergejromankov.testfragment.Contacts.Models.ContactsModel;
import com.example.sergejromankov.testfragment.Contacts.View.ContactsView;

import java.util.ArrayList;

/**
 * Created by sergejromankov on 13.01.2018.
 */

public class ContactsInteractor {
    private ContactsPresenterInterface presenterInterface;


    public void fetchContacts(){
        ArrayList<ContactsModel> list = new ArrayList<>();
        for(int i = 0; i <= 100; i++)
        {
            ContactsModel contactsModel = new ContactsModel();
            contactsModel.index = i;
            list.add(contactsModel);
        }
        presenterInterface.updateContacts(list);
    }

    public ContactsInteractor(ContactsPresenterInterface presenterInterface) {
        this.presenterInterface = presenterInterface;
    }
}
