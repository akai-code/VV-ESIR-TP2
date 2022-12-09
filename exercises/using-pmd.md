# Using PMD

Pick a Java project from Github (see the [instructions](../sujet.md) for suggestions). Run PMD on its source code using any ruleset. Describe below an issue found by PMD that you think should be solved (true positive) and include below the changes you would add to the source code. Describe below an issue found by PMD that is not worth solving (false positive). Explain why you would not solve this issue.

## Answer

cmd line to enter :
    ./run.sh pmd -d /home/akai/Téléchargements/commons-collections-master/src/main -R rulesets/java/quickstart.xml

**A problem found by PMD that you think should be solved (true positive)**
Use equals() to compare object references

	- comparators/NullComparator.java:133:
@Override
    public int compare(final E o1, final E o2) {
133 if (o1 == o2) {
            return 0;
        }

You use operator!=or operator==when you want to check the identity of two objects [if they are in fact the same object].

You use equals()when you want to check for equality . You use equals()when you want to check for equality [if two objects are equal, as the equals()method defined them].

It's hard to know exactly what you're trying to achieve, but generally, when comparing two reference objects, we want to use equals().

//Modif provided: if (o1.equals(o2))

**A problem found by PMD that you think should not be solved (false positive)**	
Use one line for each declaration, it enhances code readability.

	- trie/analyzer/StringKeyAnalyzer.java:76:
        char k = 0, f = 0;

The point here is to be clearer in the declaration of these variables, this has no effect on compilation but makes the code clearer


//Modif provided : char k=0;
		           char f=0;
