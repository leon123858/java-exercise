import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CriteriaFiles {
    public String assignmentId;
    public String criterionFilePath;
    private ArrayList<String> criteriaList;

    public CriteriaFiles(String assignmentId, String criterionFilePath) {
        this.assignmentId = assignmentId;
        this.criterionFilePath = criterionFilePath;
        // read local file
        try (BufferedReader br = new BufferedReader(new FileReader(this.criterionFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\t");
                if (words.length != 3) {
                    System.out.println("Error");
                }
                String criterion = words[0];
                String level = words[1];
                String description = words[2];
                if (!CriteriaMap.containsKey(criterion)) {
                    CriteriaMap.put(criterion, new LevelMapDescription());
                    criteriaList.add(criterion);
                }
                CriteriaMap.get(criterion).put(level, description);
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public Map<String, LevelMapDescription> CriteriaMap = new HashMap<>();

    public LevelMapDescription get(String criterion) {
        return CriteriaMap.get(criterion);
    }

    public ArrayList<String> getCriteriaList() {
        return criteriaList;
    }
}
