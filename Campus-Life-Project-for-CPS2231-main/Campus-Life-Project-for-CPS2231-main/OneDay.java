import java.sql.Time;
import java.util.*;

public class OneDay {
    public static void main(String[] args) {
        //generate time and date
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2022, 11,1, 8, 10);
        Date date1 = calendar1.getTime();
        //generate students
        Students amy = new Students("Amy", "123333", 3.56);
        Students irene = new Students("Irene", "123222", 3.62);
        Students lynn = new Students("Lynn", "123000", 3.50);
        Students sherry = new Students("Sherry", "123111", 3.69);
        //generate Buildings
        Buildings orchidHall = new Buildings("Orchid Hall", "South Eastern Direction of the Campus" );
        //generate rooms
        Rooms room1 = new Rooms("a", 402);
        //#1 story
        System.out.println("1. " );
        System.out.println("At the time " + date1 + "， \n" + Students.numberOfStudents + " students wake up in Room "
                + room1 + " at " + orchidHall.getName() + ". \n");
        System.out.println("And they are: ");
        System.out.println(amy);
        System.out.println(irene);
        System.out.println(lynn);
        System.out.println(sherry);

        //generate owning and building and story2
        Courses ENG1430 = new Courses("English Composition", "ENG1430", "teaching how to write English composions");
        Bags bags = new Bags("bags", "holding bags", "white", 4, amy);
        Books book1 = new Books("English Books", "teach English", "yellow", 2, ENG1430);
        Buildings diningHall2 = new Buildings("Dining Hall #2 ", "North Direction of the Campus");
        diningHall2.setFunction("to eat food");
        //generate time and date
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2022, 11,1, 8, 21);
        Date date2 = calendar2.getTime();
        System.out.println("\n2.");
        System.out.println("At the time " + date2 + ",");
        System.out.println("They bring their " + bags.getName() + " with " + book1
                + ", and they head to " + diningHall2.getName() + " to " + diningHall2.getFunction());

        //generate building and story3
        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(2022, 11,1, 8, 28);
        Date date3 = calendar3.getTime();
        System.out.println("\n3.");
        System.out.println("At the time " + date3 + ",");
        Buildings GEH = new Buildings("GEH", "South Direction of the Campus");
        Rooms room2 = new Rooms("c", 401);
        System.out.println("They" + amy.headTo(GEH) + " " + room2 + " to attend " + ENG1430.getName() + " " + ENG1430.getCode());

        //generate story4 and new building
        Calendar calendar4 = Calendar.getInstance();
        calendar4.set(2022, 11,1, 9, 45);
        Date date4 = calendar4.getTime();
        System.out.println("\n4.");
        System.out.println("At the time " + date4 + ",");
        Buildings convenienceStore = new Buildings("Convenience Store", "South Direction of the Campus");
        convenienceStore.setFunction("buy some food");
        System.out.println("They" + lynn.finishedClass() + ", and then head to " +
                convenienceStore.getName() + " to " + convenienceStore.getFunction());

        //generate story5
        Calendar calendar5 = Calendar.getInstance();
        calendar5.set(2022, 11,1, 11, 15);
        Date date5 = calendar5.getTime();
        System.out.println("\n5.");
        System.out.println("At the time " + date5 + ",");
        System.out.println(sherry.getName() + " finished " + sherry.eatLunch() + sherry.snap() + ", " + sherry.study()
                + "for the class in the afternoon");

        //generate story6
        Calendar calendar6 = Calendar.getInstance();
        calendar6.set(2022, 11,1, 12, 00);
        Date date6 = calendar6.getTime();
        System.out.println("\n6.");
        System.out.println("At the time " + date6 + ",");
        Food apple = new Food("apple", "red");
        Food fish = new Food("fish", "white");
        Food meat = new Food("meat", "red");
        System.out.println(amy.getName() + " started to " + amy.eatLunch() + " including "
                + apple.getName() + ", " + fish.getName() + " and " + meat.getName());

        //generate story7
        Calendar calendar7 = Calendar.getInstance();
        calendar7.set(2022, 11,1, 12, 00);
        Date date7 = calendar7.getTime();
        System.out.println("\n7.");
        System.out.println("At the time " + date7 + ",");
        Buildings GHK = new Buildings("GHK", "North of the campus");
        GHK.setFunction("take courses");
        System.out.println(irene.getName() + " " + irene.snap() + irene.headTo(GHK));

        //generate story8
        Calendar calendar8 = Calendar.getInstance();
        calendar8.set(2022, 11,1, 13, 00);
        Date date8 = calendar8.getTime();
        System.out.println("\n8.");
        System.out.println("At the time " + date8 + ",");
        Courses CPS2231 = new Courses("Computer Programming", "CPS2231", "how to write code with Java programming language");
        System.out.println(lynn.getName() + lynn.takeCourse(CPS2231) + ", and " + lynn.discuss());

        // generate story9
        Calendar calendar9 = Calendar.getInstance();
        calendar9.set(2022, 11,1, 13, 00);
        Date date9 = calendar9.getTime();
        System.out.println("\n9.");
        System.out.println("At the time " + date9 + ",");
        System.out.println(lynn.getName() + " " + lynn.finishedClass() + ", and " + lynn.acidTest());

        // generate story10
        Calendar calendar10 = Calendar.getInstance();
        calendar10.set(2022, 11,1, 15, 00);
        Date date10 = calendar10.getTime();
        System.out.println("\n10.");
        System.out.println("At the time " + date10 + ",");
        Food juice = new Food("juice", "orange");
        System.out.println(amy.getName() + " " + amy.study() + ", and " + amy.drink(juice));

        // generate story 11
        Calendar calendar11 = Calendar.getInstance();
        calendar11.set(2022, 11,1, 16, 00);
        Date date11 = calendar11.getTime();
        System.out.println("\n11.");
        System.out.println("At the time " + date11 + ",");
        Courses MATH2995 = new Courses("Linear Algebra", "MATH2995", "Matrix and Linear Algebra");
        System.out.println(irene.getName() + irene.takeCourse(MATH2995) + " and finished several tasks in class");

        //generate story 12
        Calendar calendar12 = Calendar.getInstance();
        calendar12.set(2022, 11,1, 17, 45);
        Date date12 = calendar12.getTime();
        System.out.println("\n12.");
        System.out.println("At the time " + date12 + ",");
        System.out.println(irene.getName() +" " + irene.finishedClass() + " and " + irene.headTo(diningHall2));

        //generate story 13
        Calendar calendar13 = Calendar.getInstance();
        calendar13.set(2022, 11,1, 19, 00);
        Date date13 = calendar13.getTime();
        Animals cat1 = new Cats("cat1", "white");
        Animals dog1 = new Dogs("dog1", "yellow");
        System.out.println("\n13.");
        System.out.println("At the time " + date13 + ",");
        System.out.println(Students.numberOfStudents + " students " + amy.headTo(convenienceStore) + " and "
                + amy.playWith(cat1) + ", and " + amy.feed(dog1));

        //generate story 14
        Calendar calendar14 = Calendar.getInstance();
        calendar14.set(2022, 11,1, 19, 45);
        Date date14 = calendar14.getTime();
        System.out.println("\n14.");
        System.out.println("At the time " + date14 + ", \n" + Students.numberOfStudents + " students"
                + amy.study());

        //generate story 15
        Calendar calendar15 = Calendar.getInstance();
        calendar15.set(2022, 11,1, 22, 00);
        Date date15 = calendar14.getTime();
        System.out.println("\n15.");
        System.out.println("At the time " + date15 + ", \n" + Students.numberOfStudents + " students" + sherry.washing() + " and" + irene.sleep());
    }
}
