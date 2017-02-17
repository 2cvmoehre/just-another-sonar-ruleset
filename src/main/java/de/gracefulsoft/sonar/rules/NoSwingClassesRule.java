/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.gracefulsoft.sonar.rules;

import java.util.List;
import org.sonar.api.internal.google.common.collect.ImmutableList;
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
        description = "Java Swing Framework should not be used anymore.",
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
        final String importStatement = ExpressionsHelper.concatenate((ExpressionTree) importTree.qualifiedIdentifier());

        if (importStatement.startsWith("javax.swing."))
        {
            reportIssue(tree, "Java Swing Framework should not be used anymore.");
        }
    }

}
