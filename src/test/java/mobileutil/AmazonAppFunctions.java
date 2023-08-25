package mobileutil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import step_definitions.RunCukesTest;
import utilities.GlobalUtil;
import utilities.KeywordUtil;

public class AmazonAppFunctions extends MobileKeywords2 {
	
	public static String Temp ="Add to Cart";

	// public static AndroidDriver<MobileElement> Mdriver;

	@SuppressWarnings("unchecked")
	public static AndroidDriver<MobileElement> driver1 = (AndroidDriver<MobileElement>) GlobalUtil.getMDriver();

	public static void skipSignIn(String ODevice_Name, String NDevice_Name) {
		if (ODevice_Name != NDevice_Name) {
			executionDelay(12000);
			click(AndriodConstants.Amazon.skip_sign_in_btn, AndriodConstants.Common.type_id,
					"Click on Skip Sign In Button");
		} else {
			executionDelay(5000);
			click(AndriodConstants.Amazon.skip_sign_in_btn, AndriodConstants.Common.type_id,
					"Click on Skip Sign In Button");
		}
		//GlobalUtil.mdriver.quit();
	}

	public static void skipSignIn() {
		executionDelay(5000);
		click(AndriodConstants.Amazon.skip_sign_in_btn, AndriodConstants.Common.type_id, "Click on Skip Sign In Button");
		
	}

	public static void clickShopByCategory(String ODevice_Name, String NDevice_Name) {
		if (ODevice_Name != NDevice_Name) {
			//executionDelay(5000);
			click(AndriodConstants.Amazon.shop_by_category_btn, AndriodConstants.Common.type_id, "Click on Shop By Category Button");
		} else {
			//executionDelay(5000);
			click(AndriodConstants.Amazon.shop_by_category_btn, AndriodConstants.Common.type_id,"Click on Shop By Category Button");
		}
	}

	public static void clickShopByCategory() {
		//executionDelay(9000);
		//executionDelay(6000);
		//click(AndriodConstants.Amazon.firstButtonClick, AndriodConstants.Common.type_xpath, "First Button Click for Category Select");
		executionDelay(6000);
		click(AndriodConstants.Amazon.shop_by_category_btn, AndriodConstants.Common.type_id, "Click on Shop By Category Button");
	}
	
	
	public static void SeaarchProduct() throws InterruptedException {
		executionDelay(5000);
		GlobalUtil.mdriver.findElement(By.id("in.amazon.mShop.android.shopping:id/rs_search_src_text")).click();

		executionDelay(5000);
		GlobalUtil.mdriver.findElement(By.id("in.amazon.mShop.android.shopping:id/rs_search_src_text"))
		.sendKeys("Cello Pinpoint Ball Pen (Pack of 10 pens - Blue)"+"\n");
		System.out.println("Searching the given product");
		((AndroidDriver) GlobalUtil.mdriver).pressKey(new KeyEvent(AndroidKey.ENTER));
		executionDelay(1000);
		
		try {
			
			GlobalUtil.mdriver.findElement(By.id("in.amazon.mShop.android.shopping:id/rs_results_image")).click();
			executionDelay(2000);
			GlobalUtil.mdriver.findElement(By.id("in.amazon.mShop.android.shopping:id/loc_ux_gps_enter_pincode")).click();
			executionDelay(500);
			WebElement pincode = GlobalUtil.mdriver.findElement(By.id("in.amazon.mShop.android.shopping:id/loc_ux_pin_code_text_pt1"));
			pincode.sendKeys("500025");
			System.out.println("Entered Pincode");
			WebElement apply2=GlobalUtil.mdriver.findElementByXPath("//android.widget.Button[@text='Apply']"); 
			apply2.click();
			System.out.println("After Entering Pincode, Tap on Apply button");
			executionDelay(500);
		} catch (Exception e) {
			
			   System.out.println("hello world");
			 
			    
				GlobalUtil.mdriver.findElement(By.id("in.amazon.mShop.android.shopping:id/loc_ux_gps_enter_pincode")).click();
				executionDelay(500);
				WebElement pincode = GlobalUtil.mdriver.findElement(By.id("in.amazon.mShop.android.shopping:id/loc_ux_pin_code_text_pt1"));
				pincode.sendKeys("500025");
				System.out.println("Entered Pincode");
				WebElement apply2=GlobalUtil.mdriver.findElementByXPath("//android.widget.Button[@text='Apply']"); 
				apply2.click();
				System.out.println("After Entering Pincode, Tap on Apply button");
				
				GlobalUtil.mdriver.findElement(By.id("in.amazon.mShop.android.shopping:id/rs_results_image")).click();
				executionDelay(2000);
			 
		}	

		/*
		 * if(GlobalUtil.mdriver.findElement(By.id(
		 * "in.amazon.mShop.android.shopping:id/loc_ux_gps_enter_pincode")).isDisplayed(
		 * )) { executionDelay(2000); GlobalUtil.mdriver.findElement(By.id(
		 * "in.amazon.mShop.android.shopping:id/loc_ux_gps_enter_pincode")).click();
		 * executionDelay(500);
		 * 
		 * WebElement pincode = GlobalUtil.mdriver.findElement(By.id(
		 * "in.amazon.mShop.android.shopping:id/loc_ux_pin_code_text_pt1"));
		 * 
		 * pincode.sendKeys("500025"); System.out.println("Entered Pincode");
		 * 
		 * WebElement apply2=GlobalUtil.mdriver.findElementByXPath(
		 * "//android.widget.Button[@text='Apply']"); apply2.click();
		 * System.out.println("After Entering Pincode, Tap on Apply button"); }
		 */
	    
	}
	
  public static void clickFirstCategoryExpandButton(String ODevice_Name, String NDevice_Name) {
		if (ODevice_Name != NDevice_Name) {
			executionDelay(12000);
			// click(AndriodConstants.Amazon.first_category_expand_btnIndex,
			// AndriodConstants.Common.type_xpath,"Click on the product to be selected");

			// WebElement element = (WebElement)
			// GlobalUtil.mdriver.findElements(By.className("android.view.View")).get(2);
			// element.click();
			List<MobileElement> ListElemnts = GlobalUtil.mdriver.findElements(MobileBy.xpath("//android.view.View"));
			for (int i = 1; i <= ListElemnts.size(); i++) {
				//System.out.println("Element=" + i + "=" + ListElemnts.get(i).getText());
				if (ListElemnts.get(i).getText().contains("Echo & Alexa")) {
					System.out.println("Gootcha-Echo & Alexa");
					ListElemnts.get(i).click();
					RunCukesTest.logger.log(LogStatus.PASS,
							"Click on the product to be selected" + "<-ExecutedInDevice:->" + ODevice_Name);
					// String TempText = ListElemnts.get(i).getText();
					// click(AndriodConstants.Amazon.first_category_expand_btnIndex,
					// AndriodConstants.Common.type_xpath,"Click on the product to be selected");
					break;
				}
			}
			/*
			 * System.out.println(ListElemnts.size()); if (!ListElemnts.isEmpty()) {
			 * System.out.println(ListElemnts.get(8).getText()); // print text in 9th
			 * element }
			 */
			// click(AndriodConstants.Amazon.first_category_expand_btn,
			// AndriodConstants.Common.type_xpath,"Click on the product to be selected");
		} else {
		 executionDelay(12000);
		 click(AndriodConstants.Amazon.first_category_expand_btn, AndriodConstants.Common.type_xpath,"Click on the product to be selected");
		}
		// GlobalUtil.mdriver.quit();
	}

	public static void clickFirstCategoryExpandButton() {
		//executionDelay(1200);
		executionDelay(9000);
		/*
		 * GlobalUtil.mdriver.findElement(By.xpath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[5]/android.view.View[3]\r\n"
		 * )).click(); executionDelay(500); RunCukesTest.logger.log(LogStatus.PASS,
		 * "First Category product Is selected");
		 */
		
		
		  try {
		List<MobileElement> ListElemnts =   GlobalUtil.mdriver.findElements(MobileBy.xpath("//android.view.View"));
		  
		  for (int i = 1; i <= ListElemnts.size(); i++) { System.out.println("Element="
		  + i + "=" + ListElemnts.get(i).getText()); if
		  (ListElemnts.get(i).getText().contains("Echo & Alexa")) {
		  System.out.println("Gootcha-Echo & Alexa"); ListElemnts.get(i).click();
		  KeywordUtil.delay(1000); RunCukesTest.logger.log(LogStatus.PASS,
		  "First Category option selected"); break; } } } catch (Exception e) {
		  AmazonAppFunctions.click(AndriodConstants.Amazon.first_category_expand_btn,
		  AndriodConstants.Common.type_xpath, "First Category option selected"); //
		  RunCukesTest.logger.log(LogStatus.PASS, "First Category option selected"); }
		 
	}

	public static void selectProduct(String ODevice_Name, String NDevice_Name)
			throws IOException, InterruptedException, TimeoutException {
		if (ODevice_Name != NDevice_Name) {
			executionDelay(1000);
			List<MobileElement> ListElemnts = GlobalUtil.mdriver.findElements(MobileBy.xpath("//android.view.View"));
			for (int i = 1; i <= ListElemnts.size(); i++) {
				//System.out.println("Element=" + i + "=" + ListElemnts.get(i).getText());
				if (ListElemnts.get(i).getText().contains("Echo Plus")) {
					System.out.println("Gootcha-Echo Plus");
					ListElemnts.get(i).click();
					RunCukesTest.logger.log(LogStatus.PASS,
							"Click on the product to be selected" + "<-ExecutedInDevice:->" + ODevice_Name);
					break;
				}
			}
			executionDelay(5000);
			MobileKeywords.scrollDown();
			// click(AndriodConstants.Amazon.select_product_btn,
			// AndriodConstants.Common.type_xpath, "Click on the product to be selected");
			// Scroll Dowm The PAge to Click Add to cart button

		} else {
			executionDelay(1000);
			click(AndriodConstants.Amazon.select_product_btn, AndriodConstants.Common.type_xpath,"Click on the product to be selected");
			executionDelay(5000);
			// MobileElement element = (MobileElement)
			// GlobalUtil.mdriver.findElement(By.xpath("//*[@resource-id='add-to-cart-button']"));
			MobileKeywords.scrollDown();
		}

		// executionDelay(900);
		// String StrtElem = AndriodConstants.Amazon.FirstElement;
		// String EndElem = AndriodConstants.Amazon.add_to_cart_btn1;
		// MobileBy element = (MobileBy)
		// MobileBy.xpath(AndriodConstants.Amazon.add_to_cart_btn);
		// MobileKeywords.scrollTillMobileElementDisplayed(element, 7);

		// MobileElement element =
		// GlobalUtil.mdriver..findElementByXPath("//*[@resource-id='add-to-cart-button']");

		// MobileKeywords.swipeVertical(0.8,0.4);
	}

	public static void selectProduct() {
		executionDelay(12000);
		GlobalUtil.mdriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View[5]/android.view.View[15]")).click();
		executionDelay(500);
		
		/*
		 * try { List<MobileElement> ListElemnts =
		 * GlobalUtil.mdriver.findElements(MobileBy.xpath("//android.view.View")); for
		 * (int i = 1; i <= ListElemnts.size(); i++) { System.out.println("Element=" + i
		 * + "=" + ListElemnts.get(i).getText()); //if
		 * (ListElemnts.get(i).getText().contains("Echo Plus")) { if
		 * (ListElemnts.get(i).getText().contains("Echo Studio")) {
		 * System.out.println("Gootcha-Echo Studio"); ListElemnts.get(i).click();
		 * KeywordUtil.delay(1000); break; } } } catch (Exception e) {
		 * click(AndriodConstants.Amazon.select_product_btn,
		 * AndriodConstants.Common.type_xpath, "Click on the product to be selected");
		 * //RunCukesTest.logger.log(LogStatus.PASS,
		 * "Click on the product to be selected"); }
		 */
		RunCukesTest.logger.log(LogStatus.PASS, "Click on the product to be selected");
		// click(AndriodConstants.Amazon.select_product_btn,
		// AndriodConstants.Common.type_xpath, "Click on the product to be selected");
		// Scroll Dowm The PAge to Click Add to cart button

	}

	public static void addProductToCart(String ODevice_Name, String NDevice_Name)
			throws IOException, InterruptedException {

		if (ODevice_Name != NDevice_Name) {
			executionDelay(3000);
			click(AndriodConstants.Amazon.add_to_cart_btn, AndriodConstants.Common.type_xpath,
					"Click on Add to Cart button" + "<-ExecutedInDevice:->" + ODevice_Name);
		} else {
			executionDelay(3000);
			click(AndriodConstants.Amazon.add_to_cart_btn, AndriodConstants.Common.type_xpath,
					"Click on Add to Cart button");
		}
	}

	public static void addProductToCart() throws TimeoutException, InterruptedException, IOException {
		executionDelay(1000);
		//String Temp ="Add to Cart";
	 	//MobileKeywords2.AmazonscrollAndClick(Temp);
		
		
		while (4 > 1) {

			try {

				MobileKeywords2.click(AndriodConstants.Amazon.add_to_cart_btn2, AndriodConstants.Common.type_xpath);
				System.out.println("Product added into cart");
				break;

			} catch (Exception e) {
				MobileKeywords2.scrollscroll();

			}
		}
		 
		
	 	//MobileKeywords2.scrollDown();
		//MobileKeywords2.scrollscroll();
		
		//String Temp ="Add to Cart";
	 	//MobileKeywords2.AmazonscrollAndClick(Temp);
	 	//MobileKeywords2.AmazonscrollNClick();
	 	//String id = "//*[@resource-id='add-to-cart-button']";
		//scrollToId(GlobalUtil.mdriver,  id);
		
		//MobileKeywords2.verticalSwipeUp();
		//MobileKeywords2.scrollInMobile();
		//executionDelay(1000);
		
		//executionDelay(9000);
		//MobileKeywords2.scrollInMobile();
		//executionDelay(2000);
		//click(AndriodConstants.Amazon.add_to_cart_btn, AndriodConstants.Common.type_xpath,"Click on Add to Cart button");
	 	//WebElement el= GlobalUtil.mdriver.findElement(By.xpath("//*[@resource-id='add-to-cart-button']"));
		
		}

	public static void verifyItemAddedToCart(String ODevice_Name, String NDevice_Name) {
		if (ODevice_Name != NDevice_Name) {
			executionDelay(3000);
			click(AndriodConstants.Amazon.checkout_cart_img, AndriodConstants.Common.type_id,
					"Verify Product is added to Cart" + "<-ExecutedInDevice:->" + ODevice_Name);

		} else {
			executionDelay(3000);
			click(AndriodConstants.Amazon.checkout_cart_img, AndriodConstants.Common.type_id,
					"Verify Product is added to Cart");
		}
		// GlobalUtil.mdriver.closeApp();
		GlobalUtil.mdriver.quit();
	}

	public static void verifyItemAddedToCart() {
		executionDelay(4000);
		click(AndriodConstants.Amazon.checkout_cart_img, AndriodConstants.Common.type_id, "Verify Product is added to Cart");
		executionDelay(2000);
		GlobalUtil.mdriver.quit();
	}

	public static void loginToAmazonApp(String username, String ODevice_Name, String NDevice_Name) {
		if (ODevice_Name != NDevice_Name) {

			GlobalUtil.mdriver.closeApp();
			executionDelay(1000);
			GlobalUtil.mdriver.launchApp();
			executionDelay(1000);

			List<MobileElement> ListElemnts = GlobalUtil.mdriver
					.findElements(MobileBy.xpath("//android.widget.Button"));
			for (int i = 0; i <= ListElemnts.size(); i++) {
				System.out.println("Element=" + i + "=" + ListElemnts.get(i).getText());
				if (ListElemnts.get(i).getText().contains("Sign in")) {
					System.out.println("Gootcha-Sign In");
					ListElemnts.get(i).click();
					RunCukesTest.logger.log(LogStatus.PASS,
							"Click on Sign In Button" + "<-ExecutedInDevice:->" + ODevice_Name);
					// String TempText = ListElemnts.get(i).getText();
					// click(AndriodConstants.Amazon.first_category_expand_btnIndex,
					// AndriodConstants.Common.type_xpath,"Click on the product to be selected");
					break;
				}
			}

			executionDelay(1000);
			// click(AndriodConstants.Amazon.sign_In_btn3, AndriodConstants.Common.type_id,
			// "Click on Sign In Button");

			// Enter Wrong User Name
			// writeInInput(AndriodConstants.Amazon.email_Login_txtbx,
			// AndriodConstants.Common.type_id, username, "Enter Invalid Username");

			try {
				MobileElement element = (MobileElement) GlobalUtil.mdriver
						.findElements(By.className("android.widget.Button")).get(0);
				element.sendKeys("WrongUsername");
				executionDelay(1000);
			} catch (Exception e) {

				List<MobileElement> ListElemnts1 = GlobalUtil.mdriver
						.findElements(MobileBy.xpath("//android.widget.EditText"));
				for (int i = 0; i <= ListElemnts1.size(); i++) {
					System.out.println("Element=" + i + "=" + ListElemnts1.get(i).getText());
					if (ListElemnts1.get(i).getText().contains("ap_email_login")) {
						System.out.println("Gootcha-ap_email_login");
						ListElemnts1.get(i).sendKeys("Wrong UserName");
						RunCukesTest.logger.log(LogStatus.PASS,
								"Enter UserName" + "<-ExecutedInDevice:->" + ODevice_Name);
						// String TempText = ListElemnts.get(i).getText();
						// click(AndriodConstants.Amazon.first_category_expand_btnIndex,
						// AndriodConstants.Common.type_xpath,"Click on the product to be selected");
						break;
					}
				}

			}
			executionDelay(5000);

			// Click Continue
			// click(AndriodConstants.Amazon.continue_btn, AndriodConstants.Common.type_id,
			// "Click on Continue Button");
			List<MobileElement> ListElemnts11 = GlobalUtil.mdriver
					.findElements(MobileBy.xpath("//android.widget.Button"));
			for (int i = 0; i <= ListElemnts11.size(); i++) {
				System.out.println("Element=" + i + "=" + ListElemnts11.get(i).getText());
				if (ListElemnts11.get(i).getText().contains("Continue")) {
					System.out.println("Gootcha-Continue");
					ListElemnts11.get(i).click();
					RunCukesTest.logger.log(LogStatus.PASS,
							"Click Continue Button" + "<-ExecutedInDevice:->" + ODevice_Name);
					// String TempText = ListElemnts.get(i).getText();
					// click(AndriodConstants.Amazon.first_category_expand_btnIndex,
					// AndriodConstants.Common.type_xpath,"Click on the product to be selected");
					break;
				}
			}

		} else {
			executionDelay(1000);
			click(AndriodConstants.Amazon.sign_In_btn, AndriodConstants.Common.type_id, "Click on Sign In Button");
			executionDelay(1000);
			writeInInput(AndriodConstants.Amazon.email_Login_txtbx, AndriodConstants.Common.type_id, username,
					"Enter Invalid Username");
			executionDelay(5000);
			click(AndriodConstants.Amazon.continue_btn, AndriodConstants.Common.type_id, "Click on Continue Button");
		}
	}

}
