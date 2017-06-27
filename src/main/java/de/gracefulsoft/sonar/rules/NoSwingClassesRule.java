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

import java.util.List;
import com.google.common.collect.ImmutableList;;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.java.checks.helpers.ExpressionsHelper;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.ExpressionTree;
import org.sonar.plugins.java.api.tree.ImportTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.Tree.Kind;

@Rule(key = "NoSwingClassesRule",
        name = "Java Swing Framework should not be used anymore.",
        description = "Java Swing Framework should not be used anymore. Use JavaFX instead.",
        priority = Priority.MAJOR,
        tags =
        {
            "bad-practice"
        })
public class NoSwingClassesRule extends IssuableSubscriptionVisitor
{

    @Override
    public List<Kind> nodesToVisit()
    {
        return ImmutableList.of(Kind.IMPORT);
    }

    @Override
    public void visitNode(Tree tree)
    {
        ImportTree importTree = (ImportTree) tree;
        final String importStatement = Util.concatenate((ExpressionTree) importTree.qualifiedIdentifier());

        if (importStatement.startsWith("javax.swing."))
        {
            reportIssue(tree, "Java Swing Framework should not be used anymore.");
        }
    }

}
