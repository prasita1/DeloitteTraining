package hb.demo3;

import hb.demo3.model.*;

public class Main {

	public static void main(String[] args) {
		
		HealthInsurance health= new HealthInsurance();
		TermInsurance term= new TermInsurance();
		VehicleInsurance vehicle= new VehicleInsurance();
		
		health.setId(1);
		health.setInsured("Ashish");
		health.setHealthPlan("Complete");
		health.setSumInsured(200000);
		
		term.setId(2);
		term.setInsured("Kajol");
		term.setYears(5);
		term.setSumInsured(400000);
		
		vehicle.setId(3);
		vehicle.setInsured("Rita");
		vehicle.setVehicle("Auto");
		vehicle.setSumInsured(600000);
		
		InsuranceDao iDao = new InsuranceDao();
		
		iDao.create(health);
		iDao.create(term);
		iDao.create(vehicle);
		
		InsuranceDao.shutdown();
		
		

	}

}
