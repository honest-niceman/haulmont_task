package com.company.practice.web.screens.initiator;

import com.company.practice.entity.Bid;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.practice.entity.Initiator;

import javax.inject.Inject;

@UiController("practice_Initiator.edit")
@UiDescriptor("initiator-edit.xml")
@EditedEntityContainer("initiatorDc")
@LoadDataBeforeShow
public class InitiatorEdit extends StandardEditor<Initiator> {
    @Inject
    private CheckBox isEmployeeField;
    @Inject
    private TextField<String> emailField;
    @Inject
    private CollectionLoader<Bid> bidsDl;
    @Inject
    private TextField<String> departmentField;
    @Inject
    private Button clickButton;
    @Inject
    private Table<Bid> bidsTable;
    @Inject
    private com.haulmont.cuba.gui.components.Label<String> Label;
    @Inject
    private Button approve;


    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        bidsDl.setParameter("initiator", getEditedEntity());
        approve.setCaption("Approve selected bid");
        try {
            Label.setValue("Current Tasks");
            if (getEditedEntity().getIsEmployee()) {
                emailField.setVisible(false);
                isEmployeeField.setValue(true);
                departmentField.setVisible(true);
                approve.setVisible(true);
                clickButton.setVisible(false);
            } else if (!getEditedEntity().getIsEmployee()) {
                departmentField.setVisible(false);
                isEmployeeField.setValue(false);
                approve.setVisible(false);
                clickButton.setVisible(false);
                emailField.setVisible(true);
                bidsDl.getContainer().getItem(getEditedEntity().getId()).setIsApproved(true);
            }
        } catch (Exception e) {
            Label.setVisible(false);
            bidsTable.setVisible(false);
            isEmployeeField.setValue(true);
            emailField.setVisible(false);
            approve.setVisible(false);
            clickButton.setCaption("Click if initiator is an external client");
        }
        getScreenData().loadAll();
    }

    @Subscribe("clickButton")
    public void onClickButtonClick(Button.ClickEvent event) {
        if (emailField.isVisible()) {
            clickButton.setCaption("Click if initiator is an external client");
            emailField.setVisible(false);
            departmentField.setVisible(true);
            isEmployeeField.setValue(true);
        } else {
            clickButton.setCaption("Click if initiator is an employee");
            emailField.setVisible(true);
            departmentField.setVisible(false);
            departmentField.clear();
            isEmployeeField.setValue(false);
        }
    }

    @Subscribe("approve")
    public void onApproveClick(Button.ClickEvent event) {
        Bid bid = bidsTable.getSingleSelected();
        try {
            if (bid.getIsApproved()) {
                bidsDl.getContainer().getItem(bid.getId()).setIsApproved(false);
                approve.setCaption("Approve selected bid");
            } else {
                bidsDl.getContainer().getItem(bid.getId()).setIsApproved(true);
                approve.setCaption("Deny selected bid");
            }
        }
        catch (Exception e){
            bidsDl.getContainer().getItem(bid.getId()).setIsApproved(true);
            approve.setCaption("Deny selected bid");
        }
    }

    @Subscribe("bidsTable")
    public void onBidsTableSelection(Table.SelectionEvent<Bid> event) {
        Bid bid = bidsTable.getSingleSelected();
        try {
            if (bid.getIsApproved()) {
                approve.setCaption("Deny selected bid");
            } else {
                approve.setCaption("Approve selected bid");
            }
        }
        catch (Exception e){
            approve.setCaption("Approve selected bid");
        }
    }
}