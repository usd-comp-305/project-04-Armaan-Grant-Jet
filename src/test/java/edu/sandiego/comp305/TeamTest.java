package edu.sandiego.comp305;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TeamTest {
    @Test
    void teamHasCorrectCountryName() {
        Team team = new Team(1, "Brazil", "BRA", 2141, 100, 70, 10, 200, 80);
        assertEquals("Brazil", team.getCountryName());
    }
}
