package org.sonar.template.java;

import org.sonar.api.Plugin;

/**
 * Entry Point of SonarQube Plugin
 */
public class JavaCustomRulesPlugin implements Plugin {

  @Override
  public void define(Context context) {

    // server extensions -> objects are instantiated during server startup
    context.addExtension(JavaCustomRulesDefinition.class);

    // batch extensions -> objects are instantiated during code analysis
    context.addExtension(JavaCustomRulesCheckRegistrar.class);

  }
}
