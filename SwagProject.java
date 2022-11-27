package com.selenium.project;

import com.selenium.baseclass.Basefile;
import com.swag.test.pom.PageObjectManager;
import com.swag.test.pom.SwagBackToHomePom;
import com.swag.test.pom.SwagLoginPom;
import com.swag.test.pom.SwagMyOrdersPom;
import com.swag.test.pom.SwagOverviewPom;
import com.swag.test.pom.SwagProductPom;
import com.swag.test.pom.SwagUserDetailsPom;

public class SwagProject extends Basefile {

	// user can login the page
	// then user can add to cart some items and open my orders
	// then user can remove some item and checkout
	// enter there details and continue
	// once overview the details then click finish
	// back to home page
	// open menu to logout

	public static void main(String[] args) {
		
		openbrowser("Chrome");
		maximize();
		impwaitaSEC(30);
		SiteURL("https://www.saucedemo.com/");
		
		PageObjectManager pom = new PageObjectManager(driver);

		// login page pom selected

		sendkey(pom.getLogin().getUsername(), "standard_user");
		sendkey(pom.getLogin().getUserpassword(), "secret_sauce");
		Click(pom.getLogin().getLoginButton());

		// product page pom selected

		Click(pom.getProduct().getProduct_1());
		Click(pom.getProduct().getProduct_2());
		Click(pom.getProduct().getProduct_3());
		Click(pom.getProduct().getMyorders());

		// order page pom selected

		Click(pom.getMyOrder().getProduct_1());
		Click(pom.getMyOrder().getCheckout());

		// user detail page pom selected

		sendkey(pom.getUserDetails().getfirstname(), "vairamuthu");
		sendkey(pom.getUserDetails().getlastname(), "adam");
		sendkey(pom.getUserDetails().getpincode(), "600045");
		Click(pom.getUserDetails().getcontinuebutton());

		// overview page pom selected

		Click(pom.getOverview().getfinishbutton());

		// overview page pom selected

		Click(pom.getBackToHome().getbackbutton());

		// click menu using product page pom
		Click(pom.getProduct().getmenubutton());
		Click(pom.getProduct().getlogout());
	}

}
