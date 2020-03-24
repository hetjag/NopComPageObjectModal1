package NopComPageObjectModal;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BrowserSelector extends Utils {
    public static LoadProp loadProp = new LoadProp();
    public static final String USERNAME = loadProp.getProperty("SAUCE_USERNAME");
    public static final String ACCESS_KEY = loadProp.getProperty("SAUCE_ACCESS_KEY");
    public static final String URl = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com/wd/hub";
    public static final boolean SAUCE_LAB = Boolean.parseBoolean(System.getProperty("Sauce"));

    public static final String browser = System.getProperty("browser");

    public void setUpBrowser() {
        // if sauce is true.............................................................................................
        if (SAUCE_LAB) {
            System.out.println("Running in SauceLab..............with browser  :" + browser);
            if (browser.equalsIgnoreCase("chrome")) {
                DesiredCapabilities caps = DesiredCapabilities.chrome();
                caps.setCapability("platform", "Windows 7");
                caps.setCapability("version", "75.0");
                try {
                    driver = new RemoteWebDriver(new URL(URl), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

            } else if (browser.equalsIgnoreCase("Firefox")) {
                DesiredCapabilities caps = DesiredCapabilities.firefox();
                caps.setCapability("platform", "Windows 7");
                caps.setCapability("version", "56");
                caps.setCapability("name", "Testing on fireFox 56 ");
                try {
                    driver = new RemoteWebDriver(new URL(URl), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

            } else if (browser.equalsIgnoreCase("IE")) {
                DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                caps.setCapability("platform", "Windows 10");
                caps.setCapability("version", "11");
                try {
                    driver = new RemoteWebDriver(new URL(URl), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else if (browser.equalsIgnoreCase("safari")) {
                DesiredCapabilities caps = DesiredCapabilities.safari();
                caps.setCapability("platform", "OS X 10.10");
                caps.setCapability("version", "8");
                try {
                    driver = new RemoteWebDriver(new URL(URl), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else if (browser.equalsIgnoreCase("edge")) {
                DesiredCapabilities caps = DesiredCapabilities.edge();
                caps.setCapability("platform", "10");
                caps.setCapability("version", "79");
                try {
                    driver = new RemoteWebDriver(new URL(URl), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Wrong browser name or empty: " + browser);
            }
        }
        // if sauce lab is false...........................................................................................
        else {
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\BrowserDriver\\chromedriver.exe");
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("credentials_enable_service", false);
                prefs.put("password_manager_enabled", false);
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                options.setExperimentalOption("useAutomationExtension", false);
                options.addArguments("disable-infobars");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-browser-side-navigation");
                options.addArguments("--incognito");
                options.addArguments("--disable-blink-features=BlockCredentialedSubresources");
//            options.addArguments("--headless");
                options.addArguments("--start-maximized");
//            DesiredCapabilities caps = DesiredCapabilities.chrome();
//            caps.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
//            caps.setCapability("chrome.switches", Arrays.asList("--incognito"));
//            caps.setCapability(ChromeOptions.CAPABILITY, options);
                driver = new ChromeDriver(options);
            } else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("weddriver.gecko.driver", "src\\test\\resources\\BrowserDriver\\geckdriver.exe");
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("ie")) {
                System.setProperty("webdriver.ie.driver", "src\\test\\resources\\BrowserDriver\\IEDriverServer.exe");
                DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
                ieCapabilities.setCapability("nativeEvents", false);
                ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
                ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
                ieCapabilities.setCapability("disable-popup-blocking", true);
                ieCapabilities.setCapability("enablePersistentHover", true);
                ieCapabilities.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
                ieCapabilities.setCapability("requireWindowFocus", false);
                driver = new InternetExplorerDriver(ieCapabilities);
            } else {
                System.out.println("browser name is wrong or empty : " + browser);

            }

        }
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void closeBrowser()
    {
        driver.quit();
    }
}



