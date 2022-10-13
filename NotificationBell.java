package com.edge.application.views;


import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.annotation.security.PermitAll;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.contextmenu.ContextMenu;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PermitAll
@PageTitle("Bell View")
@Route(value = "bellView", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class BellView extends VerticalLayout {
	
	VerticalLayout layout_notification = new VerticalLayout();
	H1 header_notification = new H1("Notification");
	Icon icon_notification= new Icon(VaadinIcon.BELL);
	Button bellBtn = new Button(icon_notification);
	ContextMenu menu = new ContextMenu();
	
//	Hr hr = new Hr();
	
	
	@PostConstruct
    public void init() {
    	
    	Span numberOfNotifications = new Span("2");
        numberOfNotifications.getElement().getThemeList().addAll(
                Arrays.asList("badge", "error", "primary", "small", "pill"));
        numberOfNotifications.getStyle().set("position", "absolute")
                .set("transform", "translate(-40%, -85%)");
    	
        bellBtn.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
        bellBtn.getStyle().set("color", "black").set("font-size", "large");
        bellBtn.getElement().appendChild(numberOfNotifications.getElement());
        
        
        header_notification.getStyle().set("font-weight", "400");
        layout_notification.getStyle().set("align-items", "center")
        								.set("height", "100px")
        								.set("justify-content" ,"center");
        layout_notification.add(header_notification);
    		
        	menu.setOpenOnClick(true);
        	menu.setTarget(bellBtn);
        	menu.add(layout_notification, new Hr());
        	
        	
        	for (int i=0; i< 3; i++) {
        		test();
        	}
       
    		
    		
        
    	setSpacing(false);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
        
        add(bellBtn);
    }
    
    public void test() {
    	
    	VerticalLayout layout_img = new VerticalLayout();
    	VerticalLayout layout_content = new VerticalLayout();
    	VerticalLayout main_layout = new VerticalLayout();
    	
    	
    	
    	H3 label_main = new H3("Alarm Cleared");
    	H4 tag_name = new H4("Tag-Name: " + "this is a tag name");
    	H4 app_name = new H4("UMS");
    	H6 time = new H6("02-23-2022 23:12:23.5");
    	H6 alarm_mesasage = new H6("Alarm Message: " + "U10_P_013A fail to stop");
    	Hr hr = new Hr();
    	
    	Image img_app = new Image("images/empty-plant.png", "placeholder plant");
    	img_app.setWidth("40px");
    	img_app.getStyle().set("margin-top", "30px");
    	
    	app_name.getStyle().set("margin-top", "0px");

        time.getStyle().set("padding-left", "50%");
        app_name.getStyle().set("padding-top", "0px");
        
        
        
        tag_name.getStyle().set("margin-top", "0px").set("margin-bottom", "0px");

        label_main.getStyle().set("color", "#22ff25").set("font-weight", "bold").set("margin-top", "0px").set("margin-bottom", "0px");

        alarm_mesasage.getStyle().set("margin-top", "0px").set("margin-bottom", "0px");
        
    	//Layout-Image (child-layout-1)
    	layout_img.add(img_app, app_name);
    	layout_img.setWidth("70px");
    	layout_img.getStyle().set("display", "inline-block");
    	
    	//Layout-Component (child-layout 2)
    	layout_content.add( time, label_main, tag_name, alarm_mesasage);
    	layout_content.getStyle().set("padding", "0%");
    	
    	//Parent Layout - holds two child layout
    	main_layout.getStyle().set("display", "flex").set("flex-direction", "row")
    							.set("padding", "0px 20px 0px 20px");
    	main_layout.add(layout_img, layout_content);
    	
    	//add NOTIFICATION LAYOUT TO BUTTON USING CONTEXT MENU
    	menu.add( main_layout, hr);
    	
    }
}
