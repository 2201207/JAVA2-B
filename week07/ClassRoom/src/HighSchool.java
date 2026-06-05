public class HighSchool extends Student{

    public HighSchool(String studentID, String name) {
        super(studentID, name);
    }

    @Override
    public String partList() {
        String result = "";
        for (int i = 0; i < parts.size(); i++)
            result += String.format(" %3d(%s) ",
                    parts.get(i).getScore(), grade(parts.get(i).getScore()));
        return result;
    }

    private int sum() {
        int sum = 0;
        for (int i = 0; i < parts.size(); i++)
            sum += parts.get(i).getScore();
        return sum;
    }
    @Override
    public double average() {
        return sum() / (double) parts.size();
    }

    @Override
    public String grade(double score) {
        String grade = "";
        if (score >= A)
            grade = "수";
        else if (score >= B)
            grade = "우";
        else if (score >= C)
            grade = "미";
        else if (score >= D)
            grade = "양";
        else
            grade = "가";
        return grade;
    }

    @Override
    public String toString() {
        return String.format("%s %3d %6.2f(%s)",
                super.toString(), sum(), average(), grade(average()));
    }
}