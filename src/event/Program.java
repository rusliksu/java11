package event;

public class Program {

    private static void fire(Object sender)
    {
        System.out.println("Fire");
    }
    public static void main(String[] args)
    {
        Switcher sw = new Switcher();
        Lamp lamp = new Lamp();
        Radio radio = new Radio();

        String message = "Пожар";
        //message = "Fire";

        // event subscribe
        sw.addElectricityListener(lamp);
        sw.addElectricityListener(radio);

        sw.addElectricityListener(
                new ElectricityConsumer() {
                    @Override
                    public void electricityOn(Object sender) {
                        System.out.print(message);
                        System.out.println("!!!!!");
                    }
                }
        );

        sw.addElectricityListener( sender ->
        {
            System.out.print(message);
            System.out.println("!!!!!");
        });

        sw.addElectricityListener(s -> Program.fire(s));

        sw.addElectricityListener(Program::fire);

        sw.switchOn();
        sw.switchOn();
    }
}
