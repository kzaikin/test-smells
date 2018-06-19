package bad_naming.tautology;

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
 * В названии метода должно указываться действие и проверяемое условие.
 * Префикс  test запутывает писателя, т.к. представляет собой действие и создаёт иллюзию,
 * что действие в названии тестового метода уже указано, и название остаётся незавершённым.
 *
 * Раньше в JUnit тестовые методы должны были начинаться с test, чтобы JUnit распознал их по соглашению.
 * В JUnit4 тестовые методы предваряются аннотацией @Test, и начинать их с префикса test не нужно
 */
@RunWith(MockitoJUnitRunner.class)
public class Tautology {
    @Mock private Heater heater;
    @Mock private Pump pump;

    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private CoffeeMaker coffeeMaker;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(output));
        coffeeMaker = new CoffeeMaker(heater, pump);
    }

    @Bad
    @Test public void testBrewMakesCoffee() {
        coffeeMaker.brew();
        assertThat(output, has(CoffeeMaker.COFFEE));
    }

    @Good
    @Test public void brew_makesCoffee() {
        coffeeMaker.brew();
        assertThat(output, has(CoffeeMaker.COFFEE));
    }
}
