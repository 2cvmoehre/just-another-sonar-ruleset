package de.gracefulsoft.sonar;

import de.gracefulsoft.sonar.rules.NoSwingClassesRule;
import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class NoSwingClassesRuleDefinitionTest
{

    @Test
    public void noNewThreadTest()
    {
        JavaCheckVerifier.verify("src/test/files/NoSwingClassesTest.java", new NoSwingClassesRule());
    }
}
