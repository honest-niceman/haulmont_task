package com.company.practice.web.screens.initiator;

import com.haulmont.cuba.gui.screen.*;
import com.company.practice.entity.Initiator;

@UiController("practice_Initiator.browse")
@UiDescriptor("initiator-browse.xml")
@LookupComponent("initiatorsTable")
@LoadDataBeforeShow
public class InitiatorBrowse extends StandardLookup<Initiator> {
}