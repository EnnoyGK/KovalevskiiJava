package entities.reportList;

import dao.ReportListIO;
import entities.task.Task;

import java.io.IOException;
import java.util.ArrayList;

public class ReportList {
    private ArrayList<Task> reportList;
    private String fileName;

    public ReportList(String fileName) throws IOException {
        this.fileName = fileName;

        ReportListIO reportListIO = new ReportListIO(this.fileName);
        this.reportList = reportListIO.getTaskList();
    }

    public ArrayList<Task> getReportList(){return this.reportList;}
    public void addNewReport(Task task){this.reportList.add(task);}
    public void deleteReport(int reportIndex){this.reportList.remove(reportIndex);}
    public void clearReportList() {this.reportList = new ArrayList<>();}
    public void writeReportList() throws IOException{
        ReportListIO reportListIO = new ReportListIO(this.fileName);
        reportListIO.writeTaskList(this.reportList);
    }

    public String getReportListAsString() throws IOException{
        String reportStr = "";
        ArrayList<Task> reports = this.getReportList();
        for(Task report : reports){
            reportStr +=
                    "Tree index: " + report.getPlantIndexInList() +
                            "\nWhat was done: " + report.getType().toString() +
                            "\n\n";
        }
        return reportStr;
    }
}
