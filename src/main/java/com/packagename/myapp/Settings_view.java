package com.packagename.myapp;

import java.util.Arrays;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class Settings_view extends HorizontalLayout{

	private static final long serialVersionUID = 1L;
	
	private Database database = Database.getInstance();
	
	public Settings_view( ){
	
		User current_user = new User( "name_1", "username_1", "email_1", "password_1", "studentnumber_1");

		VerticalLayout field_layout = new VerticalLayout();
		this.add(field_layout);
		VerticalLayout value_layout = new VerticalLayout();
		this.add(value_layout);
		
		Label name_label = new Label( "Name" );
		name_label.getStyle().set("width", "100%").set("height", "100%");
		field_layout.add(name_label);
		
		Label surname_label = new Label( "Surname" );
		surname_label.getStyle().set("width", "100%").set("height", "100%");
		field_layout.add( surname_label );
		
		Label email_label = new Label( "Email" );
		email_label.getStyle().set("width", "100%").set("height", "100%");
		field_layout.add(email_label);
		
		Label password_label = new Label( "Password" );
		password_label.getStyle().set("width", "100%").set("height", "100%");
		field_layout.add(password_label);
		
		Label studentNumber_label = new Label( "Student number" );
		studentNumber_label.getStyle().set("width", "100%").set("height", "100%");
		field_layout.add(studentNumber_label);
		
		TextField name_text_field = new TextField();
		name_text_field.getStyle().set("width", "100%").set("height", "100%");
		name_text_field.setValue( current_user.getName() );
		value_layout.add( name_text_field);
		
		TextField surname_text_field = new TextField();
		surname_text_field.getStyle().set("width", "100%").set("height", "100%");
		surname_text_field.setValue( current_user.getSurname() );
		value_layout.add( surname_text_field);
		
		TextField email_text_field = new TextField();
		email_text_field.getStyle().set("width", "100%").set("height", "100%");
		email_text_field.setValue( current_user.getEmail() );
		value_layout.add( email_text_field);
		
		TextField password_text_field = new TextField();
		password_text_field.getStyle().set("width", "100%").set("height", "100%");
		password_text_field.setValue( current_user.getPassword() );
		value_layout.add( password_text_field );
		
		TextField student_number_text_field = new TextField();
		student_number_text_field.getStyle().set("width", "100%").set("height", "100%");
		student_number_text_field.setValue( current_user.getStudentNumber() );
		value_layout.add( student_number_text_field);
		
		Button edit_button = new Button("firebase");
		edit_button.getStyle().set("width", "100%");
		edit_button.getStyle().set("color", "red");
		edit_button.getStyle().set("background", "green");
//		edit_button.
		edit_button.addClickListener( e-> this.database.firebase() );
		value_layout.add( edit_button );
		
		
//		
//		List<AuthUI.IdpConfig> providers = Arrays.asList(
//		        new AuthUI.IdpConfig.EmailBuilder().build(),
//		        new AuthUI.IdpConfig.PhoneBuilder().build(),
//		        new AuthUI.IdpConfig.GoogleBuilder().build(),
//		        new AuthUI.IdpConfig.FacebookBuilder().build(),
//		        new AuthUI.IdpConfig.TwitterBuilder().build());
//
//		// Create and launch sign-in intent
//		startActivityForResult(
//		        AuthUI.getInstance()
//		                .createSignInIntentBuilder()
//		                .setAvailableProviders(providers)
//		                .build(),
//		        RC_SIGN_IN);
		
//		name_text_field.setEnabled(false);
//		surname_text_field.setEnabled(false);
//		email_text_field.setEnabled(false);
//		password_text_field.setEnabled(false);
//		student_number_text_field.setEnabled(false);

				
	}
	
}
