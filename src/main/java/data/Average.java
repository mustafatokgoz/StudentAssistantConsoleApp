package data;

import java.util.ListIterator;
import java.util.Stack;

public class Average implements Comparable<Average>{
    private Stack<Lesson> lessons = new Stack<>();
    private double firstAverage = 0;
    private int firstAkts = 0;

    public void addLesson() {
        lessons.push(new Lesson());
    }
    public Lesson removeLesson(){
        return lessons.pop();
    }

    public void assignFirstAverageAndAkts(double firstAverage, int firstAkts){
        if(firstAkts > 0 && firstAverage > 0) {
            this.firstAkts = firstAkts;
            this.firstAverage = firstAverage;
        }
    }

    public void setNameLessson(String name ,int index){
        try{
            if(index < 0 || index >= lessons.size() )
                throw new IndexOutOfBoundsException();

            ListIterator iter = lessons.listIterator(index);
            Lesson tempLesson = (Lesson) iter.next();

            tempLesson.setName(name);
        }

        catch (IndexOutOfBoundsException e){
        }
    }

    public void setAktsLessson(int akts ,int index){
        try{
            if(index < 0 || index >= lessons.size() )
                throw new IndexOutOfBoundsException();

            ListIterator iter = lessons.listIterator(index);
            Lesson tempLesson = (Lesson) iter.next();

            tempLesson.setAkts(akts);
        }

        catch (IndexOutOfBoundsException e){
        }
    }

    public void setGradeLessson(String gradeLetter ,int index){
        try{
            if(index < 0 || index >= lessons.size() )
                throw new IndexOutOfBoundsException();

            ListIterator iter = lessons.listIterator(index);
            Lesson tempLesson = (Lesson) iter.next();

            tempLesson.gradeValue(gradeLetter);
        }

        catch (IndexOutOfBoundsException e){
        }
    }

    public double calculateAverage(){
        int lessonsTotalAkts = 0;
        double lessonsTotalGrade = 0;
        Lesson tempLesson = null;

        ListIterator<Lesson> iter = lessons.listIterator();

        while(iter.hasNext()){
            tempLesson = iter.next();
            lessonsTotalAkts += tempLesson.getAkts();
            lessonsTotalGrade += tempLesson.getGrade() * tempLesson.getAkts();
        }

        lessonsTotalAkts += firstAkts;
        lessonsTotalGrade += firstAkts * firstAverage;

        return lessonsTotalGrade / lessonsTotalAkts;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure
     * {@code sgn(x.compareTo(y)) == -sgn(y.compareTo(x))}
     * for all {@code x} and {@code y}.  (This
     * implies that {@code x.compareTo(y)} must throw an exception iff
     * {@code y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code x.compareTo(y)==0}
     * implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))}, for
     * all {@code z}.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
     * <i>signum</i> function, which is defined to return one of {@code -1},
     * {@code 0}, or {@code 1} according to whether the value of
     * <i>expression</i> is negative, zero, or positive, respectively.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Average o) {
        if(calculateAverage() == o.calculateAverage())
            return 0;

        else if( calculateAverage() < o.calculateAverage())
            return -1;

        else
            return 1;
    }

    private class Lesson{
        private String name;
        private int akts;
        private double grade;

        private Lesson(){
            name = "";
            akts = 0;
            grade = 0;
        }

        public int getAkts(){
            return akts;
        }

        public double getGrade(){
            return grade;
        }

        public String getName(){
            return name;
        }

        public void setAkts(int akts){
            if(akts > 0) {
                this.akts = akts;
            }
        }

        public void setName(String name) {
            this.name = name;
        }

        public void gradeValue(String gradeLetter1){
            if(gradeLetter1.equals("AA"))
                grade = 4;

            else if(gradeLetter1.equals("BA")){
                grade = 3.5;
            }

            else if(gradeLetter1.equals("BB")){
                grade = 3;
            }

            else if(gradeLetter1.equals("CB")){
                grade = 2.5;
            }

            else if(gradeLetter1.equals("CC")){
                grade = 2;
            }

            else if(gradeLetter1.equals("DC")){
                grade = 1.5;
            }

            else if(gradeLetter1.equals("DD")){
                grade = 1;
            }

            else if(gradeLetter1.equals("FF")){
                grade = 0;
            }

            else
                grade = 0;
        }
    }

    public static void main(String args[]){
        Average a = new Average();

        a.addLesson();
    }

}
