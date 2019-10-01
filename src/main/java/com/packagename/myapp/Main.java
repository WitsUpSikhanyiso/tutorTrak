package com.packagename.myapp;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


@Route(value = "main")
public class Main extends VerticalLayout{
	
	private static final long serialVersionUID = 1L;
//	private Database database = new Database();
	
	private VerticalLayout profile_l = new VerticalLayout();
	private Settings_view setting_view = new Settings_view();
//	private Schedule_view schedule_view = new Schedule_view();
	private Button profile_b;
//	private AbsoluteLayout mainWindow;
	private Main_View main_window = new Main_View( );
	
	private User current_user;
	
	public Main( ) {
		System.out.printf("SHOWING MAIN_PAGE\n");
		
//		this.setSizeFull(); 
		HorizontalLayout top = new HorizontalLayout();
    	
    	add(top);

    	Label label = new Label("Wits Tutor Tracker");
    	label.setWidth("100%");
    	top.add(label);

    	HorizontalLayout menuBar = new HorizontalLayout();
	    this.add(menuBar);

//	    mainWindow = new AbsoluteLayout();
	    this.add(main_window);
	    
	    Button settings_b = new Button( "Settings" );
//	    settings_b.getStyle().set("background", "white");
	    settings_b.addClickListener( e-> this.showSettings( ) );
	    
	    
	    menuBar.add(settings_b);

	    Button schedule_b = new Button("Schedule");
//	    schedule_b.getStyle().set("background-color", "white");
	    schedule_b.addClickListener(event -> this.showSchedule());
	    menuBar.add(schedule_b);
	    
	    Button history_b = new Button("History");
//	    history_b.setWidth("100px");
	    menuBar.add(history_b);
	   
	    profile_b = new Button("Profile");
//	    profile_b.setWidth("100px");
	    menuBar.add(profile_b);
	    profile_b.addClickListener( event -> this.showProfile());
	}
	
	public void change_view(){
		
	}
	
	public void showSchedule( ){
//		this.main_window.setContent(comp);
	}
	
	public void showSettings(){	
		int compCount = this.main_window.getComponentCount();
		System.out.printf("NUYMBER OF COMPONENTS IN MAIN-WINDOW : %d\n", compCount);

		this.main_window.setContent( this.setting_view );
	}
	
	public void showProfile(  ){
//		this.change_view();
		System.out.println("SHOW PROFILE");
		Session_view session_view = new Session_view( );
		this.main_window.setContent(session_view);
		
	}
	
	
//	
}
