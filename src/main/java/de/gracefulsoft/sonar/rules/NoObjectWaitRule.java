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
package de.gracefulsoft.sonar.rules;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.java.checks.DisallowedMethodCheck;

@Rule(key = "NoObjectWaitRule",
        name = "NoObjectWaitRule",
        description = "You should not use classic wait/notify mechanism. Instead use Java Concurrency API.",
        priority = Priority.MAJOR,
        tags =
        {
            "bad-practice"
        })
public class NoObjectWaitRule extends DisallowedMethodCheck
{

    public NoObjectWaitRule()
    {
        super.setClassName("java.lang.Object");
        super.setMethodName("wait");
        super.setAllOverloads(true);
    }

}
