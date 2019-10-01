package com.packagename.myapp;



import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

public class SignUp extends VerticalLayout {
	
	private Database database = new Database();
	private TextField name = new TextField( "Name" );
	private TextField surname = new TextField( "Surname" );
	private TextField email = new  TextField( "Email" );
	private TextField studentNumber = new TextField( "Student Number" );
	// private TextField phone = new  TextField(" Phone Number");
//	email.setWidth("40%");
	
	private PasswordField password = new PasswordField("Password");
	private PasswordField comfirmPassword = new PasswordField("Confirm Password");
    
    private Button save = new Button("Create");
		
	 public SignUp() {
	    	
	    	Label label = new Label("ACCOUNT REGISTRATION");
	    	add(label);
	    	
	     	name.setWidth("40%");
	    	add(name);
	    	
	    	surname.setWidth("40%");
	    	add(surname);
	    	
	    	studentNumber.setWidth("40%");
	    	add(studentNumber);
	    	
	    	add(email);
	    	
	    	password.setWidth("40%");
	    	add(password);

	    	comfirmPassword.setWidth("40%");
	    	add(this.comfirmPassword);
	    	
	     	//setting the width of the button
	    	save.setWidth("40%");
	    	add(save);
	    	
	    	this.save.addClickListener( e -> this.createUser( ) );
	        
	    }
	   
	    	
	    	
	  public void createUser() {
	    	Notification.show( "ADDING USER" );
	    	System.out.print("pressed");
	    	String name = this.name.getValue( );
	    	String surname = this.surname.getValue( );
	    	String email = this.email.getValue( );
	    	String studentnumber = this.studentNumber.getValue( );
	    	String password = this.password.getValue();
	    	
	    	User user = new User();
	    	
	    	//some prof functionality
	    	/*if( name.equals("") ) {
	    		Notification.show( String.format( "Please put your Name"));
	    	}
	    	
	    	if( surname .equals("") ) {
	    		Notification.show( String.format( "Please put your Surname"));
	    	}
	    	if( email .equals("") ) {
	    		Notification.show( String.format( "Please put your Email"));
	    	}
	    	
	    	if( !email.contains("@") ) {
	    		Notification.show( String.format( "Please put your a valid Email Address"));
	    	}
	    	
	    	if( studentnumber .equals("") ) {
	    		
	    		Notification.show( String.format( "Please put your Student Number"));
	    		
	    	}
	    	*/
	    	
	    	
	    	user.setName( name );
	    	user.setSurname( surname );
	    	user.setEmail( email );
	    	user.setStudentNumber( studentnumber );
	    	user.setPassword(password);
	    	
	    	if( this.validInputs( ) ) {
	    		this.database.addUser( user );
	    	}else {
	    		Notification.show( "INCORRECT DETAILS" );
	    	}
	    	
	    }
	    
	    
	    // METHOD TO CHECK INPUT FORMAT ARE CORRECT
	    public boolean validInputs() {
	    	boolean result = true;
	    	if( ! this.passwordMatch( ) ) {
	    		result = false;
	    	}
	    	return result;
	    }
	    
	    public boolean passwordMatch(  ) {
	    	String pass = this.password.getValue( );
	    	String comPass = this.comfirmPassword.getValue( );
	    	if( pass.equals( comPass ) ) {
	    		return true;
	    	}
	    	return false;
	  
	    }
    	
    

}
