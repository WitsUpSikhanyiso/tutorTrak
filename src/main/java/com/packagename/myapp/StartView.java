package com.packagename.myapp;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.model.Navigator;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

/** A start view for navigating to the main view */

//@Route("")
//@PWA(name = "Project Base for Vaadin", shortName = "Project Base")
public class StartView extends VerticalLayout{
	
	private static final long serialVersionUID = 1L;
	private Navigator navigator;
	private Database database = Database.getInstance();
	private TextField email;
	private PasswordField passwordField;
	Button in = new Button( "Sign Up");
	
    public StartView(Navigator navigator ) {
    	System.out.printf("SHOWING START_UP PAGE\n");
    	this.navigator = navigator;
    	
    	this.setWidth("100%");
    	this.setHeight("100%");
    	
    	// THIS LAYOUT EXIT BECAUSE THE DEFAULT CLASS LAYOUT
    	// ( ABSOLUTELAYOUT ) CANNOT ADD COMPONENTS WITH
    	// SCC POSITION STYLE - MAYBE ITS BECAUSE IT IMPLEMENTS
    	// VIEW CLASS
    	// ABSOULTELAYOUT WITHOUT IMPLEMENTING VIEW CLASS CAN
    	// ADD COMPONENTS WITH CSSPOSITON
    	VerticalLayout layout = new VerticalLayout();
        layout.setWidth("100%"); 
        layout.setHeight("100%");
        this.add( layout );

     	Label label = new Label("ACCOUNT LOGIN");
     	layout.add(label );
     	

     	this.email = new  TextField("Student Number");
     	this.email.setWidth("35%");
     	layout.add( this.email);
     	
     	// password
     	this.passwordField = new PasswordField("Password");
     	this.passwordField.setWidth("35%");
     	layout.add( this.passwordField);
     	
     	Button up = new Button( "Sign In");
     	up.setWidth("35%");
     	layout.add(up);
     	
     	
     	in.setWidth("35%");
     	layout.add(in);

     	/**
     	 * THIS CODE SHOULD BE DELETE
     	 * IT BY PASS THE LOGIN PAGE
     	 * I DID IT TO ON PURPOSE
     	 */
//     	Main main_view = new Main(navigator);
//    	this.navigator.addView("main_view", main_view);
//		this.navigator.navigateTo("main_view");  // ( new Main( ) );
     	
    }
    
    public void back_button(){
    	System.out.println( "BACK BUTTON CLICKED" );
//    	navigator.navigateTo("main");
//    	this.navigator.revertNavigation();   //.revertNavigation();
    }
    
    public void login()  {
    	String email = this.email.getValue( );
    	String password = this.passwordField.getValue( );
    	boolean correct = this.database.authenticateUser( email, password );
    	if( correct ) {
    		System.out.printf("SUCCESSFUL LOGIN\n");
//    		Main main_view = new Main(navigator);
//        	this.navigator.addView("main_view", main_view);
//    		this.navigator.navigateTo("main_view");  // ( new Main( ) );
    	}
    	else {
    		System.out.println( "INCORRECT LOGIN" );
    		Notification.show("INCORRECT USER DETAILS");
    	}
    	//} else {
    		 //in.setDisableOnClick(true);
    		 //Notification.show("enter full crediantials");
    	//}
    }
    
}