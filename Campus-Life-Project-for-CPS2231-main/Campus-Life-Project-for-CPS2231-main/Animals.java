public class Animals {
    String name;
    String color;
}

class Cats extends Animals{
    public Cats(String name, String color){
        this.name = name;
        this.color = color;
    }
    @Override
    public String toString(){
        return name + " in " + color + " color";
    }
}

class Dogs extends Animals{
    public Dogs (String name, String color){
        this.name = name;
        this.color = color;
    }

    @Override
    public String toString(){
        return name + " in " + color + " color";
    }
}

