package Managers;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ExtentManager {
	
	private static ExtentReports extent;
	private static ExtentSparkReporter spark;
	final static File CONF = new File("extent-spark.json"); //new File("extent-spark.xml")

	public static ExtentReports getExtentReport() {
		extent = new ExtentReports();
//		spark = new ExtentSparkReporter("test-output/sparkReport.html");
		spark = new ExtentSparkReporter("test-output/sparkReport.html").
				viewConfigurer().
				viewOrder().
				as(new ViewName[] {ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY}).
				apply();
		try {
			spark.loadJSONConfig(CONF);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		extent.attachReporter(spark);
		return extent;
		
	}
	
	public static void flushExtent(ExtentReports extent) {
		extent.flush();
	}
}

//ExtentManager.configureExtent();
//extent = new ExtentReports();
//spark = new ExtentSparkReporter("test-output/sparkReport.html");
//spark = new ExtentSparkReporter("test-output/sparkReport.html").viewConfigurer().viewOrder().as(new ViewName[] {ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY}).apply();

//This is one way, how to create configurations for the extent report, we can also do that using XML or JSON config files, below.
//spark.config().setTheme(Theme.DARK);
//spark.config().setDocumentTitle("Extent-spark-report");
//spark.config().setReportName("ReporterName");

//This is other way through XML configuration, how we can configure the extent report.
//final File CONF = new File("extent-spark.xml");
//try {
//	spark.loadXMLConfig(CONF);
//} catch (IOException e1) {
//	// TODO Auto-generated catch block
//	e1.printStackTrace();
//}

//This is the third way, we can configure report using JSON configuration.
//final File CONF = new File("extent-spark.json");
//try {
//	spark.loadJSONConfig(CONF);
//} catch (IOException e1) {
//	// TODO Auto-generated catch block
//	e1.printStackTrace();
//}
//extent.attachReporter(spark);
