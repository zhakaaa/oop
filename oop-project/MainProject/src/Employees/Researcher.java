package Employees;

import Material.ResearchPaper;
import NotEmployees.User;

import java.util.*;

public abstract class Researcher {
    private List<ResearchPaper> researchPapers = new ArrayList<>();
    private int hIndex;

    public void submitPaper(ResearchPaper paper) {
        researchPapers.add(paper);
        System.out.println("Paper submitted: " + paper);
    }

    public String viewCitations(String format) {
        StringBuilder citations = new StringBuilder();
        for (ResearchPaper paper : researchPapers) {
            citations.append(formatCitation(paper, format)).append("\n");
        }
        return citations.toString();
    }

    private String formatCitation(ResearchPaper paper, String format) {
        switch (format.toLowerCase()) {
            case "apa":
                return paper.getAuthor() + ". (" + paper.getPublicationDate() + "). " + paper.getTitle() + ".";
            case "mla":
                return paper.getAuthor() + ". \"" + paper.getTitle() + ".\" (" + paper.getPublicationDate() + ").";
            default:
                return paper.getTitle() + " by " + paper.getAuthor() + " (" + paper.getPublicationDate() + ")";
        }
    }

    public int calculateHIndex() {
        List<Integer> citations = new ArrayList<>();
        for (ResearchPaper paper : researchPapers) {
            citations.add(paper.getCitationId());
        }

        citations.sort((a, b) -> b - a);

        int h = 0;
        for (int i = 0; i < citations.size(); i++) {
            if (citations.get(i) >= i + 1) {
                h = i + 1;
            } else {
                break;
            }
        }
        hIndex = h;
        return hIndex;
    }

    public void joinProject(int projectID) {
        System.out.println("Researcher joined project with ID: " + projectID);
    }

    public void updateResearchTopic(String newTopic) {
        System.out.println("Research topic updated to: " + newTopic);
    }

    public List<ResearchPaper> getResearchPapers() {
        return new ArrayList<>(researchPapers);
    }
}