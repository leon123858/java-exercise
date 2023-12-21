import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AssignmentFiles {
    public String ID;
    public String studentID;
    public ArrayList<String> reviewers;
    public ArrayList<String> files;
    public ArrayList<ScoreFiles> list;

    public AssignmentFiles(String ID, String studentID, ArrayList<String> reviewers, ArrayList<String> files) {
        this.list = new ArrayList<>();
        this.ID = ID;
        this.studentID = studentID;
        // Assignment should be reviewed by 3-5 students.
        if(reviewers.size() < 3 || reviewers.size() > 5) {
            System.out.println("Assignment should be reviewed by 3-5 students.");
            return;
        }
        for(int i = 0; i < reviewers.size(); i++) {
            ScoreFiles scoreFiles = new ScoreFiles();
            scoreFiles.reviewerId = reviewers.get(i);
            scoreFiles.scores = new ArrayList<>();
            // read local file
            try (BufferedReader br = new BufferedReader(new FileReader(files.get(i)))) {
                String line;
                while ((line = br.readLine()) != null) {
                    scoreFiles.scores.add(line);
                }
            } catch (Exception e) {
                System.out.println("Error");
            }
            list.add(scoreFiles);
        }
    }

    public ArrayList<ScoreFiles> getScoreList() {
        return list;
    }
}
