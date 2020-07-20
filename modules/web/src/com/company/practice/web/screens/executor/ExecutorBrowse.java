package com.company.practice.web.screens.executor;

import com.company.practice.entity.Bid;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.practice.entity.Executor;

import javax.inject.Inject;

@UiController("practice_Executor.browse")
@UiDescriptor("executor-browse.xml")
@LookupComponent("executorsTable")
@LoadDataBeforeShow
public class ExecutorBrowse extends StandardLookup<Executor> {

}