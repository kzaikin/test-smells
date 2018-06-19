package coffee;

public class CoffeeMaker {

  public static final String COFFEE = " [_]P coffee! [_]P ";

  private final Heater heater; // Create a possibly costly heater only when we use it.
  private final Pump pump;

  public CoffeeMaker(Heater heater, Pump pump) {
    this.heater = heater;
    this.pump = pump;
  }

  public void brew() {
    heater.on();
    pump.pump();
    System.out.println(COFFEE);
    heater.off();
  }
}
