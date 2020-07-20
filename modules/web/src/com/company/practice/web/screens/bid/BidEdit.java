package com.company.practice.web.screens.bid;

import com.company.practice.entity.*;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;
import java.util.Date;

@UiController("practice_Bid.edit")
@UiDescriptor("bid-edit.xml")
@EditedEntityContainer("bidDc")
@LoadDataBeforeShow
public class BidEdit extends StandardEditor<Bid> {
    @Inject
    private DateField<Date> openingDateField;
    @Inject
    private LookupPickerField<Executor> executorField;
    @Inject
    private LookupPickerField<Initiator> initiatorField;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        try{
            if(getEditedEntity().getStatus().getId().isEmpty()) {}
            else {
                openingDateField.setEditable(false);
                executorField.setEditable(false);
                initiatorField.setEditable(false);
            }
        }catch (Exception e){ }
        getScreenData().loadAll();
    }

    @Subscribe("initiatorField")
    public void onInitiatorFieldValueChange(HasValue.ValueChangeEvent<Initiator> event) {
        Initiator initiator = initiatorField.getValue();
        if(!initiator.getIsEmployee()){
            getEditedEntity().setIsApproved(true);
        }
        else getEditedEntity().setIsApproved(false);
    }

}