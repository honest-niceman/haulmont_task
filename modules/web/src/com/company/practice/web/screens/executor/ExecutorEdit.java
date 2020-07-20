package com.company.practice.web.screens.executor;

import com.company.practice.entity.Bid;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.practice.entity.Executor;

import javax.inject.Inject;

@UiController("practice_Executor.edit")
@UiDescriptor("executor-edit.xml")
@EditedEntityContainer("executorDc")
@LoadDataBeforeShow
public class ExecutorEdit extends StandardEditor<Executor> {
    @Inject
    private Label<String> label;
    @Inject
    private CollectionLoader<Bid> bidsDl;
    @Inject
    private Table<Bid> bidsTable;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        bidsDl.setParameter("executor", getEditedEntity());
        try {
            if(getEditedEntity().getFio().isBlank());
        }
        catch (Exception e){
            label.setVisible(false);
            bidsTable.setVisible(false);
        }
        getScreenData().loadAll();
    }
}