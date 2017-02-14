package de.gracefulsoft.sonar;

import static org.fest.assertions.Assertions.assertThat;
import org.junit.Test;
import org.sonar.api.server.rule.RulesDefinition;

public class JavaCustomRulesDefinitionTest
{

    @Test
    public void registrationTest()
    {
        JavaCustomRulesDefinition definition = new JavaCustomRulesDefinition();
        RulesDefinition.Context context = new RulesDefinition.Context();
        definition.define(context);
        RulesDefinition.Repository repository = context.repository(JavaCustomRulesDefinition.REPOSITORY_KEY);

        assertThat(repository.key()).isEqualTo("just-another-sonar-ruleset");
        assertThat(repository.name()).isEqualTo("just-another-sonar-ruleset repository");
        assertThat(repository.language()).isEqualTo("java");
        assertThat(repository.rules()).hasSize(JavaCustomRulesList.getChecks().size());
    }
}
