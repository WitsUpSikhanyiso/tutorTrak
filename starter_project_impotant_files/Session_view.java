package com.packagename.myapp;

import java.awt.Panel;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Session_view extends VerticalLayout{

	private static final long serialVersionUID = 1L;
	private Database database = new Database();
	
	public Session_view(  ){

		Session session = this.database.getSession("COMS3005");
		
//		Label test_label = new Label();
//		Button button = new Button();
//		button.addC
		
		
//		VerticalLayout h_column = new VerticalLayout();
//		VerticalLayout value_column = new VerticalLayout();
//		this.addComponent( h_column, "left:0%; right:50%; top:0%; right:0%;" );
//		this.addComponent( value_column, "left:50%; right:0%; top:0%; right:0%;" );
//		
//		h_column.addComponent( new Label( "ID" ));
//		h_column.addComponent( new Label( "Course code" ));
//		h_column.addComponent( new Label( "date" ));
//		h_column.addComponent( new Label( "Start time" ));
//		h_column.addComponent( new Label( "End time" ));
//		h_column.addComponent( new Label( "Venue" ));
//		h_column.addComponent( new Label( "Notes" ));
////		Label value_id = new Label( session.getCourseCode() );		
//		
////		value_column.addComponent(h_id);
//		value_column.addComponent(new Label(Integer.toString( session.getId() ) ) );
//		value_column.addComponent(new Label(session.getCourseCode() ));
//		value_column.addComponent(new Label(session.getDate() ));
//		value_column.addComponent(new Label(session.getStartTime() ));
//		value_column.addComponent(new Label(session.getEndTime() ));
//		value_column.addComponent(new Label(session.getVenue() ));
//		value_column.addComponent(new Label(session.getNotes() ));
//		
		
//		value_column.addComponent(value_id);
		
//		TimePicker timePicker = new TimePicker();
		
	}
	
	public void addSession(Session session){
		
	}
	
	private class sessionPanel{
		
		sessionPanel(){
			Panel panel = new Panel();
			
		}
		
	}
}
