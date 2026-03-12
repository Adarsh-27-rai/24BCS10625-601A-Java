abstract class Animal{
    abstract void name();
    abstract void legs();
    abstract void horns();
    void eyes() { 
        System.out.println("Eyes: 2 eyes");
    }

    void ears() {
        System.out.println("Ears: 2 ears");
    }
}

class Tiger extends Animal {
    void name() {
        System.out.println("Name: Tiger");
    }

    void legs() {
        System.out.println("legs: 4 legs");
    }

    void horns() {
        System.out.println("horns: no horns");
    }
}

class Monkey extends Animal{
    void name() {
        System.out.println("Name: Monkey");
    }

    void legs() {
        System.out.println("legs: 2 legs");
    }

    void horns() {
        System.out.println("horns: no horns");
    }
}

class abstractCode{
    public static void main(String[] args) {
        Tiger t = new Tiger();
        t.name();
        t.legs();
        t.horns();
        t.eyes();
        t.ears();
        Monkey m = new Monkey();
        m.name();
        m.eyes();
        m.legs();
    }
}