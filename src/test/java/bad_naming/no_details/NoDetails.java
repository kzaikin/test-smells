package bad_naming.no_details;

import coffee.CoffeeMaker;
import coffee.Heater;
import coffee.Pump;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import sample.Bad;
import sample.Good;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertThat;
import static utils.SystemOutMatcher.has;

/**
 * Название тестового метода должно раскрывать, что делает тест.
 * Нормальная структура теста: setup -> act -> assert -> teardown.
 * В названии теста уместно записать действия act и assert.
 */
@RunWith(MockitoJUnitRunner.class)
public class NoDetails {
    @Mock private Heater heater;
    @Mock private Pump pump;

    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private CoffeeMaker coffeeMaker;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(output));
        coffeeMaker = new CoffeeMaker(heater, pump);
    }

    /**
     * It is not clear what action is performed and what is being checked.
     */
    @Bad
    @Test public void testCoffeeMaker() {
        coffeeMaker.brew();
        assertThat(output, has(CoffeeMaker.COFFEE));
    }

    @Good
    @Test public void brew_makesCoffee() {
        coffeeMaker.brew();
        assertThat(output, has(CoffeeMaker.COFFEE));
    }

    @Good
    @Test public void shouldMakeCoffee() {
        coffeeMaker.brew();
        assertThat(output, has(CoffeeMaker.COFFEE));
    }

}
