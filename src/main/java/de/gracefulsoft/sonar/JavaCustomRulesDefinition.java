/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
