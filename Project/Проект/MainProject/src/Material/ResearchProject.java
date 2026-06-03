package Material;

import Employees.Employee;
import java.util.ArrayList;
import java.util.List;

public class ResearchProject {
    private String title;
    private String topic;
    private List<Employee> participants = new ArrayList<>();
    private List<ResearchPaper> publishedPapers = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<Employee> getParticipants() {
        return participants;
    }

    public List<ResearchPaper> getPublishedPapers() {
        return publishedPapers;
    }

    public void addParticipant(Employee employee) {
        if (!participants.contains(employee)) {
            participants.add(employee);
        }
    }

    public void removeParticipant(Employee employee) {
        participants.remove(employee);
    }

    public void publishPaper(ResearchPaper paper) {
        if (!publishedPapers.contains(paper)) {
            publishedPapers.add(paper);
        }
    }

    @Override
    public String toString() {
        return "ResearchProject{" +
                "title='" + title + '\'' +
                ", topic='" + topic + '\'' +
                ", participants=" + participants +
                ", publishedPapers=" + publishedPapers +
                '}';
    }
}
