package com.packagename.myapp;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class Settings_view extends HorizontalLayout{

	private static final long serialVersionUID = 1L;
	
	private Database database = new Database();
	
	public Settings_view( ){
	
		User current_user = new User( "name_1", "username_1", "email_1", "password_1", "studentnumber_1");

		VerticalLayout field_layout = new VerticalLayout();
		this.add(field_layout);
		VerticalLayout value_layout = new VerticalLayout();
		this.add(value_layout);
		

		field_layout.add(new Label( "Name" ));
		field_layout.add(new Label( "Surname" ));
		field_layout.add(new Label( "Email" ));
		field_layout.add(new Label( "Password" ));
		field_layout.add(new Label( "StudentNumber" ));
		
		TextField name_text_field = new TextField();
		name_text_field.setValue( current_user.getName() );
		value_layout.add( name_text_field);
		
		TextField surname_text_field = new TextField();
		surname_text_field.setValue( current_user.getSurname() );
		value_layout.add( surname_text_field);
		
		TextField email_text_field = new TextField();
		email_text_field.setValue( current_user.getEmail() );
		value_layout.add( email_text_field);
		
		TextField password_text_field = new TextField();
		password_text_field.setValue( current_user.getPassword() );
		value_layout.add( password_text_field );
		
		TextField student_number_text_field = new TextField();
		student_number_text_field.setValue( current_user.getStudentNumber() );
		value_layout.add( student_number_text_field);

		Button edit_button = new Button();
		edit_button.addClickListener( e-> this.database.firebase() );
		value_layout.add( edit_button );
		
		
//		name_text_field.setEnabled(false);
//		surname_text_field.setEnabled(false);
//		email_text_field.setEnabled(false);
//		password_text_field.setEnabled(false);
//		student_number_text_field.setEnabled(false);

				
	}
	
}
