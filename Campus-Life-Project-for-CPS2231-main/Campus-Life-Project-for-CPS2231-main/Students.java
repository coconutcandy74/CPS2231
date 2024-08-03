public class Students {
    private String name;
    private String id;
    private double gpa;
    static int numberOfStudents;

    public Students(String name, String id,double gpa ){
        this.name = name;
        this. id = id;
        this. gpa = gpa;
        numberOfStudents++;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return "" + name + ", id: " + id + " with a gpa of " + gpa;
    }

    public String snap(){
        return " had snap";
    }
    public String eat(Food food){
        return " eat " + food.getName();
    }

    public String drink(Food food){
        return " drink " + food.getName();
    }
    public String study(){
        return " read the materials, and did some practice";
    }
    public String eatLunch(){
        return "eat lunch";
    }

    public String discuss(){
        return "actively discussed questions with classmates";
    }
    public String finishedClass(){
        return "finished taking class";
    }

    public String acidTest(){
        return " had a acid test";
    }
    public String takeCourse(Courses course){
        return " had a " + course.getName() + " " + course.getCode() +
                ", which teaches " + course.getContent();
    }
    public String headTo(Buildings buildings){
        return "headed to " + buildings.getName() + " to " +buildings.getFunction();
    }
    public String playWith(Animals animals){
        return "play with " + animals;
    }
    public String feed (Animals animals){
        return " feed " + animals;
    }
    public String washing (){
        return " had a washing";
    }
    public String sleep(){
        return " went to bed";
    }
}
