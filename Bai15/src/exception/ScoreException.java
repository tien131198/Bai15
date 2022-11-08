package exception;

/* Welcome to project
    @author: tienb
    Date: 11/8/2022
    Time: 10:23 AM
    
    ProjectName: Main.java
*/public class ScoreException extends Exception {
    private float score;

    public ScoreException(float score) {
        System.out.println("Diem so nam trong khong 0 toi 10: " + score + " khong hop le.");
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
