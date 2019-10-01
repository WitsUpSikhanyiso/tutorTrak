//package com.packagename.myapp;
//
//import com.vaadin.navigator.Navigator;
//import com.vaadin.navigator.View;
//import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
//import com.vaadin.ui.Alignment;
//import com.vaadin.ui.Button;
//import com.vaadin.ui.Notification;
//import com.vaadin.ui.VerticalLayout;
//
///** A start view for navigating to the main view */
//public class Test_view extends VerticalLayout implements View {
//	
//	private static final long serialVersionUID = 1L;
//	private Navigator navigator;
//	
//    public Test_view(Navigator navigator) {
//        this.navigator = navigator;
////        this.parent_navigation_id = parent;
//        
//    	setSizeFull();
//
//        Button button = new Button("BACK");
//        button.addClickListener( event -> back_button() );
//        addComponent(button);
//        setComponentAlignment(button, Alignment.MIDDLE_CENTER);
//    }
//    
//    public void back_button(){
//    	System.out.println( "===BACK BUTTON CLICKED" );
////    	navigator.navigateTo("main");
////    	this.navigator.revertNavigation();   //.revertNavigation();
//    }
//
//    @Override
//    public void enter(ViewChangeEvent event) {
//        Notification.show("Welcome to tutor tracker");
//    }
//}