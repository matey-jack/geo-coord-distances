package percentages;

import org.junit.Test;

import static org.junit.Assert.*;

public class PercTest {
  @Test
  public void percentages() throws Exception {
    assertEquals("7.14", Perc.getPercentage("Die Käuferprovision beträgt 7,14 % inkl. MwSt."));
    assertEquals("7.14", Perc.getPercentage("Die Käuferprovision beträgt 7,14% inkl. MwSt."));
    assertEquals("7.14", Perc.getPercentage("7,14% inkl. der gesetzlich MwSt. von 19%"));
    assertEquals("7.1", Perc.getPercentage("7,1%"));
    assertEquals("7.14", Perc.getPercentage("Käuferprovision 7,14 % inkl. MwSt."));
    assertEquals("3.57", Perc.getPercentage("3,57 % inkl. MwSt. v. Kaufpreis"));
  }

  @Test
  public void absolute1() throws Exception {
    assertEquals("6000", Perc.getAbsolute("6.000,00 € inkl. MWSt vom Kaufvertrag"));
    assertEquals("7000", Perc.getAbsolute("7000,00 €"));
    assertEquals("10410", Perc.getAbsolute("10.410,12 € inkl. MwSt."));

  }
}