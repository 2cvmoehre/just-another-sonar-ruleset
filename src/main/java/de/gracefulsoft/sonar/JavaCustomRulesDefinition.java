package de.gracefulsoft.sonar;

import com.google.common.collect.Iterables;
import java.util.List;
import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.api.server.rule.RulesDefinitionAnnotationLoader;
import org.sonar.plugins.java.Java;

/**
 * Declare rule metadata in server repository of rules. That allows to list the
 * rules in the page "Rules".
 */
public class JavaCustomRulesDefinition implements RulesDefinition
{

    public static final String REPOSITORY_KEY = "just-another-sonar-ruleset";

    @Override
    public void define(Context context)
    {
        NewRepository repository = context.createRepository(REPOSITORY_KEY, Java.KEY);
        repository.setName("just-another-sonar-ruleset repository");

        List<Class> checks = JavaCustomRulesList.getChecks();
        new RulesDefinitionAnnotationLoader().load(repository, Iterables.toArray(checks, Class.class));
        repository.done();
    }

}
