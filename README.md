# just-another-sonar-ruleset
Some additional SonarQube rules you might find useful.

Since SonarQube has an issue regarding the backup of rules based on templates (SONAR-5366), you may also find implementations based on template classes - for example derived DisallowedMethodChecks.

Currently, the following additional rules are defined:
- Do not use Thread (instead use Executor Framework)
- Do not use Object.wait() (instead use Condition from java.util.concurrent.locks)
- Do not use classes from ye olde Swing Framework