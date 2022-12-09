# Code of your exercise

Put here all the code created for this exercise

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

//IfStatement[ancestor::IfStatement[ancestor::IfStatement]]

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