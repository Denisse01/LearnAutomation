package tests;

import help.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    public String emailvalue;
    public String passwordvalue;


    @Test
    public void test1 (){
// validarea pagina de Register
        String expectedpaginaderesiter =BaseTest.getvalue("registerpage");
        String actualpaginaderegister = driver.getTitle();
        Assert.assertEquals(expectedpaginaderesiter,actualpaginaderegister);

//din registerpage dam click pe home button
        WebElement homebutton = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
        homebutton.click();

// validarea Homepage
        String expectedhomepage = BaseTest.getvalue("homepage");
        String actualhomepage = driver.getTitle();
        Assert.assertEquals(expectedhomepage,actualhomepage);

//dam click pe signin button
        WebElement signinbutton = driver.findElement(By.xpath("//button[@id='btn1']"));
        signinbutton.click();

//validam pagina signin
        String expectedsigninpage = BaseTest.getvalue("Loginpagetitle");
        String actualsigninpage = driver.getTitle();
        Assert.assertEquals(expectedsigninpage,actualsigninpage);

        //parsez valorile pentru email
        emailvalue =""+ BaseTest.getvalue("emailvalues");
        passwordvalue =""+ BaseTest.getvalue("passwordvalues");
        String[] parseEmail=emailvalue.split(",");
        String[] parsePassword=passwordvalue.split(",");

        for (int index=0; index<6; index++){
            WebElement emailfield1 = driver.findElement(By.xpath("//input[@placeholder='E mail']"));
            WebElement passwordfield1 = driver.findElement(By.xpath("//input[@placeholder='Password']"));
            WebElement enterbutton1 = driver.findElement(By.xpath("//img[@id='enterbtn']"));

            //1. email si parola invalide
            if (index==0){
                emailvalue=parseEmail[0];
                passwordvalue=parsePassword[0];
                emailfield1.sendKeys(emailvalue);
                passwordfield1.sendKeys(passwordvalue);
                enterbutton1.click();
                WebElement errormessage = driver.findElement(By.xpath("//label[@id='errormsg']"));
                String expectederrormessage = BaseTest.getvalue("Errormessage");
                String actualerrormessage = errormessage.getText();
                Assert.assertEquals(expectederrormessage,actualerrormessage);
                driver.navigate().refresh();
            }
            //2. email valid si parola invalida
            if (index==1){
                emailvalue=parseEmail[1];
                passwordvalue=parsePassword[0];
                emailfield1.sendKeys(emailvalue);
                passwordfield1.sendKeys(passwordvalue);
                enterbutton1.click();
                WebElement errormessage = driver.findElement(By.xpath("//label[@id='errormsg']"));
                String expectederrormessage = BaseTest.getvalue("Errormessage");
                String actualerrormessage = errormessage.getText();
                Assert.assertEquals(expectederrormessage,actualerrormessage);
                driver.navigate().refresh();
            }
            //3. email invalid si parola valida
            if (index==2){
                emailvalue=parseEmail[0];
                passwordvalue=parsePassword[1];
                emailfield1.sendKeys(emailvalue);
                passwordfield1.sendKeys(passwordvalue);
                enterbutton1.click();
                WebElement errormessage = driver.findElement(By.xpath("//label[@id='errormsg']"));
                String expectederrormessage = BaseTest.getvalue("Errormessage");
                String actualerrormessage = errormessage.getText();
                Assert.assertEquals(expectederrormessage,actualerrormessage);
                driver.navigate().refresh();
            }


            // email si password cu spatiu
            if (index==3){
                emailvalue=parseEmail[2];
                passwordvalue=parsePassword[2];
                emailfield1.sendKeys(emailvalue);
                passwordfield1.sendKeys(passwordvalue);
                enterbutton1.click();
                WebElement errormessage = driver.findElement(By.xpath("//label[@id='errormsg']"));
                String expectederrormessage = BaseTest.getvalue("Errormessage");
                String actualerrormessage = errormessage.getText();
                Assert.assertEquals(expectederrormessage,actualerrormessage);
                driver.navigate().refresh();
            }


            //email si password inexistent
            if (index==4){
                emailvalue=parseEmail[3];
                passwordvalue=parsePassword[3];
                emailfield1.sendKeys(emailvalue);
                passwordfield1.sendKeys(passwordvalue);
                enterbutton1.click();
                WebElement errormessage = driver.findElement(By.xpath("//label[@id='errormsg']"));
                String expectederrormessage = BaseTest.getvalue("Errormessage");
                String actualerrormessage = errormessage.getText();
                Assert.assertEquals(expectederrormessage,actualerrormessage);
                driver.navigate().refresh();
            }
            if (index==5){
                emailvalue=parseEmail[4];
                passwordvalue=parsePassword[4];
                emailfield1.sendKeys(emailvalue);
                passwordfield1.sendKeys(passwordvalue);
                enterbutton1.click();
                WebElement errormessage = driver.findElement(By.xpath("//label[@id='errormsg']"));
                String expectederrormessage = BaseTest.getvalue("Errormessage");
                String actualerrormessage = errormessage.getText();
                Assert.assertEquals(expectederrormessage,actualerrormessage);
                driver.navigate().refresh();
            }
        }

    }
}
