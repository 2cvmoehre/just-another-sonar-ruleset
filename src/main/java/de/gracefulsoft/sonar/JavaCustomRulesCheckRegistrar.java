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

import org.sonar.plugins.java.api.CheckRegistrar;

/**
 * Provide the "checks" (implementations of rules) classes that are going to be
 * executed during source code analysis.
 *
 * This class is a batch extension by implementing the
 * {@link org.sonar.plugins.java.api.CheckRegistrar} interface.
 */
public class JavaCustomRulesCheckRegistrar implements CheckRegistrar
{

    /**
     * Register the classes that will be used to instantiate checks during
     * analysis.
     */
    @Override
    public void register(RegistrarContext registrarContext)
    {
        // Call to registerClassesForRepository to associate the classes with the correct repository key
        registrarContext.registerClassesForRepository(JavaCustomRulesDefinition.REPOSITORY_KEY, JavaCustomRulesList.getJavaChecks(), JavaCustomRulesList.getJavaTestChecks());
    }
}
