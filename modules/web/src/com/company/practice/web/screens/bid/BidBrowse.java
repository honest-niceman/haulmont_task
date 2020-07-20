package com.company.practice.web.screens.bid;

import com.haulmont.cuba.gui.screen.*;
import com.company.practice.entity.Bid;

@UiController("practice_Bid.browse")
@UiDescriptor("bid-browse.xml")
@LookupComponent("bidsTable")
@LoadDataBeforeShow
public class BidBrowse extends StandardLookup<Bid> {
}