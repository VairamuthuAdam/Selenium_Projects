package com.selenium.project;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.adactin.test.pom.Adactin_DetailsPOM;
import com.adactin.test.pom.Adactin_POM;
import com.adactin.test.pom.Adactin_SearchPOM;
import com.adactin.test.pom.Adactin_SelectPOM;
import com.adactin.test.pom.Adactin_loginPOM;
import com.selenium.baseclass.Basefile;

public class Adactin_Project extends Basefile{

	
	public static void main(String[] args) throws IOException {
		//driver set up and launching browser
		openbrowser("Chrome");
				
		//maximize the screen
		maximize();
				
		//give implicit wait
		impwaitaSEC(60);
				
		//enter Site URL
		SiteURL("http://adactinhotelapp.com/");
		
		
		//Page Object Manager for sub POM
		Adactin_POM pom = new Adactin_POM(driver);
		
//		Adactin_loginPOM login = new Adactin_loginPOM(driver);
//		Adactin_SearchPOM search = new Adactin_SearchPOM(driver);
//		Adactin_SelectPOM select = new Adactin_SelectPOM(driver);
//		Adactin_DetailsPOM detail = new Adactin_DetailsPOM(driver);
		
		
		//Using Login POM
		
		//Entering User name
		sendkey(pom.Login().Username(), "alivedemigod");			
		//Entering password name
		sendkey(pom.Login().Password(), "Adactin@password");
		//Click login button
		Click(pom.Login().Loginbutton());
		
		
		//Using Search POM
		
		//select Location
		dropdown(pom.Search().selectLocation(), "Value", "Paris", 0);
//		//select Hotels
//		dropdown(pom.Search().selectHotels(), "value", "Hotel Sunshine", 0);
		//select Room Type
		dropdown(pom.Search().selectRoomtype(), "index", null, 4);
		//select Number of Rooms
		dropdown(pom.Search().selectNumberofroom(), "Visible", "1 - One", 0);
		//Enter check in date
		sendkey(pom.Search().CheckInDate(), "28/11/2022");
		//Enter check out date
		sendkey(pom.Search().CheckOutDate(), "29/11/2022");
		//select Adults per Room
		dropdown(pom.Search().AdultCount(), "value", "2", 0);
		//select Children per Room
		dropdown(pom.Search().ChildCount(), "value", "2", 0);
		//click search
		Click(pom.Search().SearchButton());
		
		
		//Using select Hotel POM
		
		//select Hotels
		Click(pom.Select().Selecthotel());
		//click continue
		Click(pom.Select().ContinueButton());
		//Enter first name
		
		
		//Using Booking Details POM
		
		//Enter first name
		sendkey(pom.Detail().Firstname(), "Alive");
		//Enter last name
		sendkey(pom.Detail().Lastname(), "Demigod");
		//Enter address
		sendkey(pom.Detail().Address(), "No. 25/11, Poonamallee, Chennai, Tamilnadu, India");
		//Enter Credit Card No
		sendkey(pom.Detail().CreditCardNo(), "7401 3441 8100 0000");
		//select Credit Card Type
		dropdown(pom.Detail().CreditCardtype(), "value", "VISA", 0);
		//select expiry Date
		dropdown(pom.Detail().CreditCardmonth(), "value", "11", 0);
		dropdown(pom.Detail().CreditCardyear(), "value", "2022", 0);
		//Enter CVV Number
		sendkey(pom.Detail().CreditCardCVV(), "146");
		//Click Book now
		Click(pom.Detail().BookNow());
		
		boolean Confirmation = pom.Detail().Confirmation().isDisplayed();
		System.out.println(Confirmation);
		
		javascript(pom.Detail().Confirmation());
		
		screenShot("Confirmation");
	}
}
