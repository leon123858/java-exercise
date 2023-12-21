import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CommandRunner {
    public static void run(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            Status mode = Status.BEFORE;
            int studentNumber = 0;
            int assignmentNumber = 0;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                if (words.length == 0) {
                    System.out.println("Error");
                }
                switch (mode) {
                    //student [StudentID] [StudentID] …
                    //schoolStrategy [Level],[Score] [Level],[Score] …
                    case BEFORE: {
                        switch (words[0]) {
                            case "student": {
                                // min student number is 1
                                if (words.length < 2) {
                                    System.out.println("Error");
                                    System.exit(1);
                                }
                                ArrayList<String> studentIDs = new ArrayList<>();
                                for (int i = 1; i < words.length; i++) {
                                    String studentID = words[i];
                                    studentIDs.add(studentID);
                                    studentNumber++;
                                }
                                // do something with studentIDs
                                System.out.println(studentIDs);
                                break;
                            }
                            case "schoolStrategy": {
                                if (words.length < 2) {
                                    System.out.println("Error");
                                    System.exit(1);
                                }
                                System.out.println(words.length);
                                ArrayList<String> Levels = new ArrayList<>();
                                ArrayList<String> Scores = new ArrayList<>();
                                for (int i = 1; i < words.length; i++) {
                                    String[] levelAndScore = words[i].split(",");
                                    Levels.add(levelAndScore[0]);
                                    Scores.add(levelAndScore[1]);
                                }
                                // parse schoolStrategies
                                System.out.println(Levels);
                                System.out.println(Scores);
                                // set status
                                assignmentNumber = studentNumber;
                                mode = Status.ING;
                                break;
                            }
                            default: {
                                System.out.println("Error");
                                System.exit(1);
                            }
                        }
                        break;
                    }
                    //designCriterion [AssignmentID] [RubricFile]
                    //assignment [AssignmentID] [StudentID] [ReviewrID],[SampleScoreFile] [ReviewrID],[SampleScoreFile]...
                    case ING: {
                        switch (words[0]) {
                            case "designCriterion": {
                                if (words.length != 3) {
                                    System.out.println("Error");
                                    continue;
                                }
                                // parse designCriterion
                                String assignmentID = words[1];
                                String rubricFile = words[2];
                                // do something with assignmentID and rubricFile
                                System.out.println(assignmentID);
                                System.out.println(rubricFile);
                                break;
                            }
                            case "assignment": {
                                if (words.length < 4) {
                                    System.out.println("Error");
                                    continue;
                                }
                                // data
                                AssignmentFiles assignmentFiles = new AssignmentFiles();
                                assignmentFiles.reviewers = new ArrayList<>();
                                assignmentFiles.files = new ArrayList<>();
                                // parse assignment
                                assignmentFiles.ID = words[1];
                                assignmentFiles.studentID = words[2];
                                for (int i = 3; i < words.length; i++) {
                                    String[] reviewerAndFile = words[i].split(",");
                                    assignmentFiles.reviewers.add(reviewerAndFile[0]);
                                    assignmentFiles.files.add(reviewerAndFile[1]);
                                }
                                // do something with assignment
                                System.out.println(assignmentFiles.ID);
                                System.out.println(assignmentFiles.studentID);
                                System.out.println(assignmentFiles.reviewers);
                                System.out.println(assignmentFiles.files);
                                // check status
                                assignmentNumber--;
                                if (assignmentNumber == -1) {
                                    mode = Status.AFTER;
                                }
                                break;
                            }
                            default: {
                                System.out.println("Error");
                                continue;
                            }
                        }
                        break;
                    }
                    //printRubric [AssignmentID]
                    //averageCriterion [AssignmentID]
                    //calculateScore [AssignmentID] [StudentID] [RankingStrategy]
                    //findStrength [AssignmentID] [StudentID] [RankingStrategy]
                    //findWeakness [AssignmentID] [StudentID] [RankingStrategy]
                    case AFTER: {
                        if (words.length < 2) {
                            System.out.println("Error");
                            continue;
                        }
                        switch (words[0]) {
                            case "printRubric": {
                                // parse printRubric
                                String assignmentID = words[1];
                                // do something with assignmentID
                                System.out.println(assignmentID);
                                break;
                            }
                            case "averageCriterion": {
                                // parse averageCriterion
                                String assignmentID = words[1];
                                // do something with assignmentID
                                System.out.println(assignmentID);
                                break;
                            }
                            case "calculateScore": {
                                if (words.length != 4) {
                                    System.out.println("Error");
                                    continue;
                                }
                                // parse calculateScore
                                String assignmentID = words[1];
                                String studentID = words[2];
                                String rankingStrategy = words[3];
                                // do something with assignmentID, studentID and rankingStrategy
                                System.out.println(assignmentID);
                                System.out.println(studentID);
                                System.out.println(rankingStrategy);
                                break;
                            }
                            case "findStrength": {
                                if (words.length != 4) {
                                    System.out.println("Error");
                                    continue;
                                }
                                // parse findStrength
                                String assignmentID = words[1];
                                String studentID = words[2];
                                String rankingStrategy = words[3];
                                // do something with assignmentID, studentID and rankingStrategy
                                System.out.println(assignmentID);
                                System.out.println(studentID);
                                System.out.println(rankingStrategy);
                                break;
                            }
                            case "findWeakness": {
                                if (words.length != 4) {
                                    System.out.println("Error");
                                    continue;
                                }
                                // parse findWeakness
                                String assignmentID = words[1];
                                String studentID = words[2];
                                String rankingStrategy = words[3];
                                // do something with assignmentID, studentID and rankingStrategy
                                System.out.println(assignmentID);
                                System.out.println(studentID);
                                System.out.println(rankingStrategy);
                                break;
                            }
                            default: {
                                System.out.println("Error");
                                continue;
                            }
                        }
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    enum Status {
        BEFORE,
        ING,
        AFTER
    }
}