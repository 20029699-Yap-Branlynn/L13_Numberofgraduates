package sg.edu.rp.c346.id20029699.l13_numberofgraduates;

public class Graduates {
    String numOfGrad;
    String course;
    int year;

    public Graduates(String numOfGrad, String course, int year) {
        this.numOfGrad = numOfGrad;
        this.course = course;
        this.year = year;
    }

    public String getNumOfGrad() {
        return numOfGrad;
    }

    public void setNumOfGrad(String numOfGrad) {
        this.numOfGrad = numOfGrad;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString(){

        String result = String.format("%s\n %s: %d\n %s: %s\n %s: %s",
                "Graduates", "Year", year, "Course", course, "Number of Graduates", numOfGrad);
        return result;
    }
}


