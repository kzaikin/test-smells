package coffee;

public class Thermosiphon implements Pump {
  private final Heater heater;
  private final Reservoir reservoir;

  public Thermosiphon(Heater heater, Reservoir reservoir) {
    this.heater = heater;
    this.reservoir = reservoir;
  }

  @Override public void pump() {
    if (reservoir.isEmpty()) {
      throw new IllegalStateException();
    }
    if (heater.isHot()) {
      System.out.println("=> => pumping => =>");
    }
  }
}
