package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportGenerator {

    public static ExtentReports reports;
    public static ExtentTest logger;
    private static ExtentHtmlReporter htmlReporter;

    public static void setExtent() {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        htmlReporter = new ExtentHtmlReporter("test-output/myReport" + timeStamp + ".html");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Zoopla Application Testing");
        htmlReporter.config().setTheme(Theme.DARK);

        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);
        reports.setSystemInfo("HostName", "Localhost");
        reports.setSystemInfo("Environemnt", "WINDOWS");
        reports.setSystemInfo("user", "PAVAN");
    }

    public static void endReport() {
        reports.flush();
    }
}
