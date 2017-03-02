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

import de.gracefulsoft.sonar.rules.NoObjectWaitRule;
import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class NoObjectWaitRuleDefinitionTest
{

    @Test
    public void noObjectWaitTest()
    {
        JavaCheckVerifier.verify("src/test/files/NoObjectWaitTemplate.java", new NoObjectWaitRule());
    }

}
