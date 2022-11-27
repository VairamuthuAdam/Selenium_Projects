package com.selenium.project;

import org.testng.annotations.Test;

import com.selenium.baseclass.Basefile;
import com.swag.test.pom.PomForForm;

public class PracticeForm extends Basefile{
	
	@Test
	public void run() {
		openbrowser("Chrome");
		maximize();
		SiteURL("https://demoqa.com/automation-practice-form");
		
		PomForForm dr = new PomForForm(driver);
		
		sendkey(dr.getFirstname(), "Vairamuthu");
		sendkey(dr.getLastName(), "Ramar");
		sendkey(dr.getUserEmail(), "vairamuthu.ramar@gmail.com");
		Click(dr.getGender());
		sendkey(dr.getUserNumber(), "7401344181");
		Click(dr.getDateOfBirthInput());
		dropdown(dr.getMonth(), "value", "10", 0);
		dropdown(dr.getYear(), "Visible", "1997", 0);
		Click(dr.getDay());
		
	}
	
//	public static void main(String[] args) {
//		openbrowser("Chrome");
//		maximize();
//		SiteURL("https://demoqa.com/automation-practice-form");
//		
//		PomForForm dr = new PomForForm(driver);
//		
//		sendkey(dr.getFirstname(), "Vairamuthu");
//		sendkey(dr.getLastName(), "Ramar");
//		sendkey(dr.getUserEmail(), "vairamuthu.ramar@gmail.com");
//		Click(dr.getGender());
//		sendkey(dr.getUserNumber(), "7401344181");
//		Click(dr.getDateOfBirthInput());
//		dropdown(dr.getMonth(), "value", "10", 0);
//		dropdown(dr.getYear(), "Visible", "1997", 0);
//		Click(dr.getDay());
//		
//	}
}
