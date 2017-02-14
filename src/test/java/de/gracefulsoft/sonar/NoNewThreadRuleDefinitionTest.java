package de.gracefulsoft.sonar;

import de.gracefulsoft.sonar.rules.NoNewThreadRule;
import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class NoNewThreadRuleDefinitionTest
{

    @Test
    public void noNewThreadTest()
    {
        JavaCheckVerifier.verify("src/test/files/NoNewThreadTemplate.java", new NoNewThreadRule());
    }
}
