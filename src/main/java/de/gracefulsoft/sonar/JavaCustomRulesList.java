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
