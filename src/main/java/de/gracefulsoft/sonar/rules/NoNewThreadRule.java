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
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.NewClassTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.Tree.Kind;

@Rule(key = "NoNewThreadRule",
        name = "Thread instance should not be used directly.",
        description = "You should not create/manage Thread instances by yourself. Use Runnables with the Executor Framework (Java 1.5 onwards) instead.",
        priority = Priority.MAJOR,
        tags =
        {
            "bad-practice"
        })
public class NoNewThreadRule extends IssuableSubscriptionVisitor
{

    @Override
    public List<Kind> nodesToVisit()
    {
        return ImmutableList.of(Kind.NEW_CLASS);
    }

    @Override
    public void visitNode(Tree tree)
    {
        NewClassTree newClassTree = (NewClassTree) tree;
        if (newClassTree.symbolType().is("java.lang.Thread"))
        {
            reportIssue(tree, "Thread instance should not be used directly.");
        }
    }

}
