package com.packagename.myapp;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.vaadin.flow.component.notification.Notification;

public class Database {
	
	private String username;
	private String password;
	private String portNumber;
	private String databaseName; 
	private Connection connection;
	
	Database( ){
		
		this.username = "l18Jt8LSkG";
		this.password = "MAXpe5qGDs";
		this.portNumber = "3306";
		this.databaseName = "l18Jt8LSkG";
		
		try{
			FileInputStream serviceAccount = new FileInputStream("cryptoportal-7b3d0-firebase-adminsdk-75hxu-c650b059cf.json");
			
			FirebaseOptions options = new FirebaseOptions.Builder()
			  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
			  .setDatabaseUrl("https://cryptoportal-7b3d0.firebaseio.com")
			  .build();
			
			FirebaseApp.initializeApp(options);
		}
		catch( Exception e ){
			e.printStackTrace();
		}
	}
	
	public boolean firease_authenticate( int userId ){
		
		boolean correct_credits = false;
		
		
		
		return correct_credits;
		
	}
	
	public void firebase_create_user( User user ){
		
	}
	
	public User firebase_get_user( int userId ){
		
		User user = new User();
		
		FirebaseDatabase database = FirebaseDatabase.getInstance();
		DatabaseReference ref = database.getReference();
		ref.addValueEventListener( new ValueEventListener( ) {
		  @Override
		  public void onDataChange(DataSnapshot dataSnapshot ) {
			User user = dataSnapshot.getValue(User.class);
			System.out.printf("USERS : /%s/\n", user);
		    Map<String, Object> td = (HashMap<String,Object>) dataSnapshot.getValue();
	        Collection<Object> values = td.values();
	        System.out.printf( "VALUES : /%s/\n", values );
		  }

		  @Override
		  public void onCancelled(DatabaseError databaseError) {
		    System.out.println("The read failed: " + databaseError.getCode());
		  }
		});
		
		return user;
	}
	
	public void firebase(){

		try{
			
			FirebaseDatabase database = FirebaseDatabase.getInstance();
			DatabaseReference ref = database.getReference();
			DatabaseReference users_ref = database.getReference( "users" );

			User user = new User("user_usernfgme_2", "user_2", "user2", "user_rd_2", "user_stu_2");
			Map<String, User> user_map = new HashMap<>();
			
//			users_ref.setValue("users", null);
			user_map.put( "user_2", user );
			users_ref.setValueAsync(user_map);
//			users.put("random", new User("reuben", "matlala", "reuben_email", "reuben_password", "reuben_studentnumber"));
			
			ref.addValueEventListener(new ValueEventListener() {
				  @Override
				  public void onDataChange(DataSnapshot dataSnapshot) {
				User user = dataSnapshot.getValue(User.class);
				System.out.printf("USERS : /%s/\n", user);
				Map<String, Object> td = (HashMap<String,Object>) dataSnapshot.getValue();
				Collection<Object> values = td.values();
				System.out.printf( "VALUES : /%s/\n", values );
				  }
				
				  @Override
				  public void onCancelled(DatabaseError databaseError) {
				    System.out.println("The read failed: " + databaseError.getCode());
				  }
			});
			
//			Map<String, User> users = new HashMap<>();
//			users.put("random", new User("reuben", "matlala", "reuben_email", "reuben_password", "reuben_studentnumber"));
//			ref.setValueAsync(users);
			
			
			
			System.out.printf( "REF KEY : %s\n", ref.getKey( ) );
			
			
			
		}catch( Exception e ){
			e.printStackTrace();
		}
	}
	
	
	public void connect() {
 	try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			this.connection = DriverManager.getConnection( "jdbc:mysql://remotemysql.com:3306/l18Jt8LSkG", "l18Jt8LSkG", "MAXpe5qGDs");  			 
		}
		catch( Exception e ){
			System.out.println( "ERROR OCCURED !!!" );
			e.printStackTrace( );
		} 
	}
	
	public void closeConnection(  ) {
		try {
			this.connection.close( );
		}catch( Exception e ) {
			e.printStackTrace( );
		}
	}
	
	// public void addTutor() {
// 		
	// }
	
	public Course getCourse(String code) {
		this.connect();
		try {
			
		}catch( Exception e ) {
			e.printStackTrace();
			return null;
		}
		
		this.closeConnection();
		return null;
	}
	
	public void addUser( User user ) {
		this.connect( );
		String name = user.getName( );
		String email = user.getEmail( );
		String password = user.getPassword( );
		String surname = user.getSurname( );
		String studentNumber = user.getStudentNumber(); 
		
		String sql = "insert into users( name, surname, email, password, studentNumber ) values( '"+name+"', '"+surname+"', '"+email+"', '"+password+"', '"+studentNumber+"' )";
				
		try {
			Statement statement = this.connection.createStatement(  );
			String[] values = { name, surname, email, password, studentNumber };
			statement.execute( sql, values);   //.executeUpdate( );
			Notification.show( String.format( "Succesful registered",user ) );
		}
		catch( Exception e ) {
			e.printStackTrace();
		}
		this.closeConnection( );
	}
	
	
	public boolean authenticateUser( String studentNumber, String password ) {
		User user = this.getUser( studentNumber );
		if( user != null ){
			String p = user.getPassword( );
			String s = user.getStudentNumber();
			if( studentNumber.equals(s) && password.equals( p ) ) {
				return true;
			}
			else if (studentNumber.equals(s) ) {
		        Notification.show( String.format( "Invalid Password!"));
		        return false;
		    } 
			else if (p.equals( password )) {
		        Notification.show( String.format( "Invalid Username "));
		        return false;
			}
			else {
				Notification.show( String.format( "Invalid Username & Password!"));
				return false;
			}
		}
		else{
			return false;
		}
	}
	
	public User getUser( String studentNumber) {
		this.connect();
		User user = null;
		try{
			String sql = "select * from users where studentNumber='"+studentNumber+"'";
			Statement statement = this.connection.createStatement();
			ResultSet results = statement.executeQuery( sql );   // execute( sql, values );
			if( results.next( ) ) {
				user = new User();
				String name = results.getString( 5 );
				String surname = results.getString( 4 ); 
				String email = results.getString( 3 );
				String password = results.getString( 2 );
				String studentnumber = results.getString( 6 );
				
				user.setName( name );
				user.setSurname( surname );
				user.setEmail( email );
				user.setStudentNumber( studentnumber );
				user.setPassword( password );
				this.closeConnection();
			}	
		}catch ( Exception e ) {
			e.printStackTrace( );
			this.closeConnection();
		}
		return user;
		
	}
	
	public Session getSession( String course_code ){
			
		Session session = null;
		this.connect();
		try{
			String sql = "select * from sessions where COURSE_CODE=?";
			PreparedStatement ps = this.connection.prepareStatement(sql);
//			Statement s = this.connection.createStatement();
			ps.setString(1, course_code);
			ResultSet rs = ps.executeQuery();   //executeUpdate();
			if( rs.next() ){
//				System.out.println( "ROWS : ");
				int id = rs.getInt(rs.getInt(1));
				String courseCode = rs.getString(2);
				String date = rs.getString(3);
				String start_time = rs.getString(4);
				String end_time = rs.getString(5);
				String venue = rs.getString(6);
				String notes = rs.getString(7);
				session = new Session( id, courseCode, date, start_time, end_time, venue, notes );
			}
			ps.close();
		}
		catch(SQLException ex){
			System.out.println(ex.getMessage());
		}catch( Exception e ){
			e.printStackTrace();
		}
		
		this.closeConnection();
		return session;
		
	}

	// TO BE IMPLEMENTED
	public String getTutor() {
		return null;
	}
 
	public String getDatabaseName() {
		return this.databaseName;
	}
	
	public String getPassword( ) {
		return this.password;
	}
	
	public String getPornNumber( ) {
		return this.portNumber;
	}
}


