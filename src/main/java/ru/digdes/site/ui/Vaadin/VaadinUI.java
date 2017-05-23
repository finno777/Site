package ru.digdes.site.ui.Vaadin;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import org.jboss.logging.LoggingClass;

/**
 * Created by Yaroslavtsev.I on 23.05.2017.
 */
@SpringUI
public class VaadinUI extends UI{
    @Override
    protected void init(VaadinRequest request){
        setContent(new Button("Click",event -> Notification.show("Hello")));
    }
}
