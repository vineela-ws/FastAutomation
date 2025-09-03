package com.QA.Fast;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DownloadFileToCustomFolder {

	public static void main(String[] args) throws InterruptedException {
		
        String downLoadFolderPath = System.getProperty("user.dir") + File.separator + "JenkinsDownloads";
        
        File jenkinsDownloadDir = new File(downLoadFolderPath);
        
        if (!jenkinsDownloadDir.exists()) {
                System.out.println("Jenkins Folder Not Present");
            if (jenkinsDownloadDir.mkdir()) {
                System.out.println("Created Jenkins Download Directory !!!");
            }
        }
        
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downLoadFolderPath);
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.directory_upgrade", true);
        prefs.put("safebrowsing.enabled", true); // important
        
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", prefs);
        
        WebDriver wd = new ChromeDriver(chromeOptions);
        wd.get("https://get.jenkins.io/war-stable/2.516.2/jenkins.war");
        
        //Check if file has been downloaded successfully
        File jenkinsFile = new File(jenkinsDownloadDir, "jenkins.war");
        while(!jenkinsFile.exists()) {
        Thread.sleep(1000);
        }
        if(jenkinsFile.exists()) {
        	System.out.println("File Downloaded Successfully");
        }
	}

}
