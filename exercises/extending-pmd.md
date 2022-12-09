# Extending PMD

Use XPath to define a new rule for PMD to prevent complex code. The rule should detect the use of three or more nested `if` statements in Java programs so it can detect patterns like the following:

```Java
if (...) {
    ...
    if (...) {
        ...
        if (...) {
            ....
        }
    }

}
```
Notice that the nested `if`s may not be direct children of the outer `if`s. They may be written, for example, inside a `for` loop or any other statement.
Write below the XML definition of your rule.

You can find more information on extending PMD in the following link: https://pmd.github.io/latest/pmd_userdocs_extending_writing_rules_intro.html, as well as help for using `pmd-designer` [here](https://github.com/selabs-ur1/VV-ESIR-TP2/blob/master/exercises/designer-help.md).

Use your rule with different projects and describe you findings below. See the [instructions](../sujet.md) for suggestions on the projects to use.

## Answer

**Rule development process**

1-Write a code snippet in the main editor that features the offending code you’re looking for

class Akai {
    public static void main () {
        int a=1;
        if ( a < 0 ) {
            System.out.println("a");
            for (int i=0 ; i<10;i++) {
                if (i=2) {
                    System.out.println("2");
                    for (int i=0 ; i<10;i++) {
                        if (i=4) {
                             System.out.println("4");
                        }
                    }
                }
            }
        }
    }
}

2-Examine the AST and determine what node the violation should be reported on

    last Ifstatement : if (i=4)

3-Write an XPath expression matching that node in the XPath editor

//IfStatement[ancestor::IfStatement[ancestor::IfStatement]]

4-Export your XPath expression to an XML rule element, and place it in your ruleset

<rule name="ComplexIfStatement"
      language="java"
      message="Complex If Statement"
      class="net.sourceforge.pmd.lang.rule.XPathRule">
   <description>
      detect the use of three or more nested if statements in
      Java programs
   </description>
   <priority>3</priority>
   <properties>
      <property name="version" value="2.0"/>
      <property name="xpath">
         <value>
<![CDATA[
//IfStatement[ancestor::IfStatement[ancestor::IfStatement]]
]]>
         </value>
      </property>
   </properties>
</rule>

