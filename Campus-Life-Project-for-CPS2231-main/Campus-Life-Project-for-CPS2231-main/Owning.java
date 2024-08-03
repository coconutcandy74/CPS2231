public class Owning {
    private String name;
    private String function;
    private String color;
    private int amount;

    public Owning(String name, String function, String color, int amount) {
        this.name = name;
        this.function = function;
        this.color = color;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }


    public String getName() {
        return name;
    }


    public String getFunction() {
        return function;
    }


    public String getColor() {
        return color;
    }

}

class Books extends Owning{
    private Courses course;
    public Books(String name, String function, String color, int amount, Courses course) {
        super(name, function, color, amount);
        this.course = course;
    }


    public String toString() {
        return getAmount() + " " + getName() + " in " + getColor() + " color " + "used to " + getFunction();
    }
}

class Bags extends Owning{
    Students owner;
    public Bags(String name, String function, String color, int amount, Students owner) {
        super(name, function, color, amount);
        this.owner = owner;
    }

    @Override
    public String toString() {
        return getAmount() + " " + getName() + " with " + getColor() + " color " + " used to " + getFunction();
    }
}
