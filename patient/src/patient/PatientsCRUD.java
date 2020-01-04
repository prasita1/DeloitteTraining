package patient;

import java.util.*;
import java.util.Date;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import oracle.jdbc.*;


class DBManager {

	private String username = "hr";
	private String password = "HR";
	private String url = "jdbc:oracle:thin:@192.168.1.47:1522:xe";
	Driver driver = null;
	Connection conn = null;

public DBManager() {
	try {
		driver = new OracleDriver();
		DriverManager.registerDriver(driver);
		conn = DriverManager.getConnection(url, username, password);
}
catch(Exception e) {}
}

void addRecord(int id, String name, String email, Date dt) {
String q = "INSERT INTO PATIENTS VALUES(?,?,?,?)";
try {
	PreparedStatement p = conn.prepareStatement(q);
	p.setInt(1, id);
	p.setString(2,name);
	p.setString(3,email);
	p.setDate(4,(java.sql.Date) dt);
	int res = p.executeUpdate();
	if(res > 0)
		System.out.println("Inserted!");
	else
		System.out.println("Not inserted");
}
catch(Exception e) {System.out.println("Not inserted");}
}

void deleteRecord(int id) {
String q = "DELETE FROM PATIENTS WHERE PATIENT_ID = ?";
try {
	PreparedStatement p = conn.prepareStatement(q);
	p.setInt(1, id);
	int res = p.executeUpdate();
	if(res > 0)
		System.out.println("Deleted!");
	else
		System.out.println("Not deleted");
}
catch(Exception e) {System.out.println("Not deleted");}
}

void displayRecords() {
String q = "SELECT * FROM PATIENTS";
try {
	Statement s = conn.createStatement();
	ResultSet rs = s.executeQuery(q);
	while(rs.next())
	{
		System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"  "+rs.getString(3)+" \t "+rs.getDate(4));
	}
}
catch(Exception e) {}
}

void updateRecord(int id, String name, String email, Date dt) {
String q = "UPDATE PATIENTS SET PATIENT_ID = ?, PATIENT_NAME = ?, PATIENT_EMAIL = ?, PAT_DT = ? WHERE PATIENT_ID = ?";
try {
	PreparedStatement p = conn.prepareStatement(q);
	p.setInt(1, id);
	p.setString(2,name);
	p.setString(3,email);
	p.setDate(4,(java.sql.Date) dt);
	p.setInt(5, id);
	int res = p.executeUpdate();
	if(res > 0)
		System.out.println("Updated!");
	else
		System.out.println("Not Updated");
}
catch(Exception e) {
	System.out.println("Not Updated");
	}
}


public class PatientsCRUD{

	public void main(String[] args) {
		DBManager dm = new DBManager();
		Scanner s = new Scanner(System.in);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
		int choice;
		while(true)
		{
			System.out.println("\nChoose\n1: ADD RECORD\n2: DISPLAY RECORDS\n3: DELETE RECORD\n4: UPDATE RECORD\n5: Exit\nEnter the choice: ");
			choice = s.nextInt();
			switch(choice)
			{
				case 1: System.out.print("Add Record:\nEnter the PATIENT_ID:");
				int id = s.nextInt();
				System.out.print("Enter Patient's Name: ");
				String name = s.next();
				System.out.print("Enter Patient's Email: ");
				String email = s.next();
				System.out.print("Enter Patient's Registered Date: ");
				String dt = s.next();
				Date dte = null;
				try {
					dte = dateFormat.parse(dt);
				} catch (ParseException e1) {
					e1.printStackTrace();
				} 
				dm.addRecord(id, name, email, dte);
				break;

				case 2: System.out.println("List of Patients:\n");
				dm.displayRecords();
				break;
				
				case 3: System.out.println("Delete Record:\nEnter the PATIENT_ID");
				int b1 = s.nextInt();
				dm.deleteRecord(b1);
				break;
				
				case 4: System.out.print("Update Record:\nEnter the PATIENT_ID:");
				int id1 = s.nextInt();
				System.out.print("Enter the Patient's Name: ");
				String name1 = s.next();
				System.out.print("Enter the Patient's Email: ");
				String email1 = s.next();
				System.out.print("Enter the Patient's Registered Date: ");
				String dt1 = s.next();
				Date dte1 = null;
				try {
					dte1 = dateFormat.parse(dt1);
				} catch (ParseException e1) {
					e1.printStackTrace();
				} 
				dm.updateRecord(id1, name1, email1, dte1);
				break;
				
				case 5: System.out.println("Exit");
				s.close();
				try { dm.conn.close(); }
				catch(Exception e) {}
				System.exit(0);
				
				default: System.out.println("Invalid choice! Enter 1, 2, 3, 4 or 5!");
}
}

}
}


void addPRecord(int pId, Date pDt, int id, String mName) {
String q = "INSERT INTO PRESCRIPTION VALUES(?,?,?,?)";
try {
	PreparedStatement p = conn.prepareStatement(q);
	p.setInt(1, pId);
	p.setDate(2,(java.sql.Date) pDt);
	p.setInt(3,id);
	p.setString(4,mName);
	int res = p.executeUpdate();
	if(res > 0)
		System.out.println("Inserted!");
	else
		System.out.println("Not inserted");
}
catch(Exception e) {System.out.println("Not inserted");}
}

void deletePRecord(int pId) {
String q = "DELETE FROM PRESCRIPTION WHERE PRES_ID = ?";
try {
	PreparedStatement p = conn.prepareStatement(q);
	p.setInt(1, pId);
	int res = p.executeUpdate();
	if(res > 0)
		System.out.println("Deleted!");
	else
		System.out.println("Not deleted");
}
catch(Exception e) {System.out.println("Not deleted");}
}

void displayPRecords() {
String q = "SELECT * FROM PRESCRIPTION";
try {
	Statement s = conn.createStatement();
	ResultSet rs = s.executeQuery(q);
	while(rs.next())
	{
		System.out.println(rs.getInt(1)+"\t\t"+rs.getDate(2)+"  "+rs.getInt(3)+" \t "+rs.getString(4));
	}
}
catch(Exception e) {}
}

void updatePRecord(int pId, Date pDt, int id, String mName ) {
String q = "UPDATE PRESCRIPTION SET PRES_ID = ?, PRES_DATE = ?, PATIENT_ID = ?, MED_NAME = ? WHERE PRES_ID = ?";
try {
	PreparedStatement p = conn.prepareStatement(q);
	p.setInt(1, pId);
	p.setDate(2,(java.sql.Date) pDt);
	p.setInt(3,id);
	p.setString(4,mName);
	p.setInt(5, pId);
	int res = p.executeUpdate();
	if(res > 0)
		System.out.println("Updated!");
	else
		System.out.println("Not Updated");
}
catch(Exception e) {
	System.out.println("Not Updated");
	}
}


class PresCRUD{

	public void main(String[] args) {
		DBManager dm = new DBManager();
		Scanner s = new Scanner(System.in);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
		int choice;
		while(true)
		{
			System.out.println("\nChoose\n1: ADD RECORD\n2: DISPLAY RECORDS\n3: DELETE RECORD\n4: UPDATE RECORD\n5: Exit\nEnter the choice: ");
			choice = s.nextInt();
			switch(choice)
			{
				case 1: System.out.print("Add Record:\nEnter the PRES_ID:");
				int pId = s.nextInt();
				System.out.print("Enter Prescribed Date: ");
				String pDt = s.next();
				Date dte = null;
				try {
					dte = dateFormat.parse(pDt);
				} catch (ParseException e1) {
					e1.printStackTrace();
				} 
				System.out.print("Enter Patient's id: ");
				int id = s.nextInt();
				
				System.out.print("Enter medicine Name: ");
				String mName = s.next();
				
				dm.addPRecord(pId, dte, id, mName);
				break;

				case 2: System.out.println("Prescription Details:\n");
				dm.displayRecords();
				break;
				
				case 3: System.out.println("Delete Record:\nEnter the PRES_ID");
				int b1 = s.nextInt();
				dm.deleteRecord(b1);
				break;
				
				case 4: System.out.print("Update Record:\nEnter the PRES_ID:");
				int pId1 = s.nextInt();
				System.out.print("Enter Prescribed Date: ");
				String pDt1 = s.next();
				Date dte1 = null;
				try {
					dte1 = dateFormat.parse(pDt1);
				} catch (ParseException e1) {
					e1.printStackTrace();
				} 
				System.out.print("Enter Patient's id: ");
				int id1 = s.nextInt();
				
				System.out.print("Enter medicine Name: ");
				String mName1 = s.next();
				
				
				dm.updatePRecord(pId1, dte1, id1, mName1);
				break;
				
				case 5: System.out.println("Exit");
				s.close();
				try { dm.conn.close(); }
				catch(Exception e) {}
				System.exit(0);
				
				default: System.out.println("Invalid choice! Enter 1, 2, 3, 4 or 5!");
}
}

}
}

}