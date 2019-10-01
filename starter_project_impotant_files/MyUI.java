package com.packagename.myapp;

import javax.servlet.annotation.WebServlet;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.model.Navigator;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.server.VaadinServlet;
import com.vaadin.flow.server.VaadinServletConfiguration;
import com.vaadin.flow.theme.Theme;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Route("some/path")
//@PWA(name = "Project Base for Vaadin", shortName = "Project Base")
public class MyUI extends UI {

	private Database database = new Database();
	private static final long serialVersionUID = 1L;
	private TextField email;
	private PasswordField passwordField;
	Button in = new Button( "Sign Up");
	
	 Navigator navigator;
//	 protected static final String MAINVIEW = "main";

	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	
    	getPage().setTitle("Tutor Tracker");
    	
//    	navigator 	= new Navigator();//new Navigator(this, this);//new Navigator( this, this);
//    	navigator.
    	/**
     	 * THIS CODE SHOULD BE DELETE
     	 * IT BY PASS THE LOGIN PAGE
     	 * I DID IT TO ON PURPOSE
     	 */
//     	Main main_view = new Main(navigator);
//    	this.navigator.addView("main_view", main_view);
//		this.navigator.navigateTo("main_view");  // ( new Main( ) );

		/**
		 * DE COMMMENT THE FOLLOWING CODE FOR THE 
		 * SIGN IN TO WORK FINE
		 * 
		 */
		
		// StartView start_view = new StartView( navigator );
    	// navigator.addView("start_view", start_view);
    	// navigator.navigateTo("start_view");
    	
    	
    }
    
    public boolean CheckNull() {
    	if (email.equals(" ") && passwordField.equals(" ")) {
    		return true;
    	}else if (email.equals(" ")) {
    		 return false ;
    	}else if (passwordField.equals(" ")) {
    		 return false ;
    	} else {	
    		  return true;
    	}
    }


    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {

		private static final long serialVersionUID = 1L;
    }
}
