package utils.reports;

import com.aventstack.extentreports.ExtentReports;

import java.io.File;

public class extentReportManagement {

    private static ExtentReports extent;

    public static ExtentReports getInstance(){
        if (extent == null){

            //Borrar previamente reportes antiguos
            deleteHtmlFiles("src/output/");

            com.aventstack.extentreports.reporter.ExtentSparkReporter spark = new com.aventstack.extentreports.reporter.ExtentSparkReporter("src/output/report.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }

    private static void deleteHtmlFiles(String folderPath){
        File folder = new File(folderPath);
        if(folder.exists()){
            File[] files = folder.listFiles((dir, name) -> name.endsWith(".html"));
            if (files != null){
                for (File file:files){
                    file.delete();
                }
            }
        }
    }

}
