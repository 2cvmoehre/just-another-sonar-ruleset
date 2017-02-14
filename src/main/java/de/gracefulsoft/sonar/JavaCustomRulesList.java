package de.gracefulsoft.sonar;

import com.google.common.collect.ImmutableList;
import de.gracefulsoft.sonar.rules.NoNewThreadRule;
import java.util.List;
import org.sonar.plugins.java.api.JavaCheck;

public final class JavaCustomRulesList
{

    private JavaCustomRulesList()
    {
    }

    public static List<Class> getChecks()
    {
        return ImmutableList.<Class>builder().addAll(getJavaChecks()).addAll(getJavaTestChecks()).build();
    }

    public static List<Class<? extends JavaCheck>> getJavaChecks()
    {
        return ImmutableList.<Class<? extends JavaCheck>>builder()
                // add HERE rules targeting source files
                .add(NoNewThreadRule.class)
                .build();
    }

    public static List<Class<? extends JavaCheck>> getJavaTestChecks()
    {
        return ImmutableList.<Class<? extends JavaCheck>>builder()
                // add HERE rules targeting test files
                .build();
    }
}
