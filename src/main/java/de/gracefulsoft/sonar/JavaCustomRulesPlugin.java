/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.gracefulsoft.sonar;

import org.sonar.api.Plugin;

public class JavaCustomRulesPlugin implements Plugin
{

    @Override
    public void define(Context context)
    {

        // server extensions -> objects are instantiated during server startup
        context.addExtension(JavaCustomRulesDefinition.class);

        // batch extensions -> objects are instantiated during code analysis
        context.addExtension(JavaCustomRulesCheckRegistrar.class);

    }

}
