package com.packagename.myapp;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;



@Route("")
@PWA(name = "Project Base for Vaadin", shortName = "Project Base")
public class MainView extends VerticalLayout {


	private static final long serialVersionUID = 1L;
//	private Navigator navigator;
	private Database database = new Database();
	private TextField email;
	private PasswordField passwordField;
	
	
    public MainView( ) {
    	System.out.printf("SHOWING START_UP PAGE\n");
//    	this.navigator = navigator;
    	
    	this.setWidth("100%");
    	this.setHeight("100%");
    	
    	// THIS LAYOUT EXIT BECAUSE THE DEFAULT CLASS LAYOUT
    	// ( ABSOLUTELAYOUT ) CANNOT ADD COMPONENTS WITH
    	// SCC POSITION STYLE - MAYBE ITS BECAUSE IT IMPLEMENTS
    	// VIEW CLASS
    	// ABSOULTELAYOUT WITHOUT IMPLEMENTING VIEW CLASS CAN
    	// ADD COMPONENTS WITH CSSPOSITON
    	VerticalLayout layout = new VerticalLayout();
    	layout.setAlignItems(Alignment.CENTER);
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
     	
     	Button sign_in_button = new Button( "Sign In");
     	sign_in_button.setWidth("35%");
     	layout.add(sign_in_button);
     	sign_in_button.addClickListener(event -> this.login( ) ) ;
     	sign_in_button.addClickShortcut(Key.ENTER);
     	
     	
     	Button sign_up_button = new Button( "Sign Up");
     	sign_up_button.setWidth("35%");
     	sign_up_button.addClickListener(event-> do_sign_up() );
     	layout.add(sign_up_button);
     	

     	// funcitionaliy of the buttons
     	/*	in.addClickListener( clickEvent -> this.navigator.navigateTo("") ); 
     	up.addClickListener( clickEvent -> login( )	);	*/

 
     	/**
     	 * THIS CODE SHOULD BE DELETE
     	 * IT BY PASS THE LOGIN PAGE
     	 * I DID IT TO ON PURPOSE
     	 */
//     	Main main_view = new Main(navigator);
//    	this.navigator.addView("main_view", main_view);
//		this.navigator.navigateTo("main_view");  // ( new Main( ) );
     	
    }
    
    public void do_sign_up(){
    	System.out.print( "THIS IS THE SIGN UP METHOD\n" );
    }
    
    public void back_button(){
    	System.out.println( "BACK BUTTON CLICKED" );
//    	navigator.navigateTo("main");
//    	this.navigator.revertNavigation();   //.revertNavigation();
    }
    
    public void login(  )  {
    	
    	
    	
    	FirebaseDatabase database = FirebaseDatabase.getInstance();
		DatabaseReference ref = database.getReference();
		ref.addValueEventListener( new ValueEventListener( ) {
		  @Override
		  public void onDataChange(DataSnapshot dataSnapshot ) {
			User user = dataSnapshot.getValue(User.class);
			
		  }

		  @Override
		  public void onCancelled(DatabaseError databaseError) {
		    System.out.println("The read failed: " + databaseError.getCode());
		  }
		});
		
    	
    	
//    	this.add( new RouterLink("main", Main.class) );
    	Main main = new Main();
    	this.getUI().ifPresent( ui -> ui.navigate("main"));
     	String email = this.email.getValue( );
    	String password = this.passwordField.getValue( );
    	boolean correct = this.database.authenticateUser( email, password );
    	if( correct ) {
    		System.out.printf("SUCCESSFUL LOGIN\n");
    	
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
    
    public String hashString( String text ){
    	String res = null;
    	try{
    		MessageDigest md = MessageDigest.getInstance("SHA-256");

    	    // Change this to UTF-16 if needed
    	    md.update(text.getBytes(StandardCharsets.UTF_8));
    	    byte[] digest = md.digest();

    	    res = String.format("%064x", new BigInteger(1, digest));
//    	    System.out.println(hex);
    	}catch( Exception e ){
    		e.printStackTrace();
    	}
    	return res;	
    }
}
