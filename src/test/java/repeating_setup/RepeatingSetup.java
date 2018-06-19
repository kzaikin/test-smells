package repeating_setup;

import coffee.CoffeeMaker;
import coffee.Heater;
import coffee.Pump;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import sample.Bad;
import sample.Good;

import javax.print.Doc;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static utils.SystemOutMatcher.has;

public class RepeatingSetup {

    @Mock private Heater heater;
    @Mock private Pump pump;

    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private CoffeeMaker coffeeMaker;

    @Bad
    @Test public void brew_makesCoffee() {
        heater = mock(Heater.class);
        pump = mock(Pump.class);
        System.setOut(new PrintStream(output));
        CoffeeMaker coffeeMaker = new CoffeeMaker(heater, pump);
        coffeeMaker.brew();
        assertThat(output, has(CoffeeMaker.COFFEE));
    }

    @Bad
    @Test public void noBrew_noCoffee() {
        heater = mock(Heater.class);
        pump = mock(Pump.class);
        System.setOut(new PrintStream(output));
        CoffeeMaker coffeeMaker = new CoffeeMaker(heater, pump);
        assertThat(output, not(has(CoffeeMaker.COFFEE)));
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        System.setOut(new PrintStream(output));
        coffeeMaker = new CoffeeMaker(heater, pump);
    }

    @Good
    @Test public void brew_makesCoffee2() {
        coffeeMaker.brew();
        assertThat(output, has(CoffeeMaker.COFFEE));
    }

    @Good
    @Test public void noBrew_noCoffee2() {
        assertThat(output, not(has(CoffeeMaker.COFFEE)));
    }
}
