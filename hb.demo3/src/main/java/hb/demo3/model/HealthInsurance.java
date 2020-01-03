package hb.demo3.model;
import javax.persistence.*;

@Entity
@DiscriminatorValue(value="H_I")
public class HealthInsurance extends Insurance {

	@Column (name="health_plan_name")
	private String healthPlan;
	


public HealthInsurance() {
	
}
 
public HealthInsurance(String healthPlan) {
	this.healthPlan=healthPlan;
	
}

public String getHealthPlan() {
	return healthPlan;
}

public void setHealthPlan(String healthPlan) {
	this.healthPlan = healthPlan;
}
}