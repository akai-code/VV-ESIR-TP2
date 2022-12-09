# TCC *vs* LCC

Explain under which circumstances *Tight Class Cohesion* (TCC) and *Loose Class Cohesion* (LCC) metrics produce the same value for a given Java class. Build an example of such as class and include the code below or find one example in an open-source project from Github and include the link to the class below. Could LCC be lower than TCC for any given class? Explain.

## Answer

The TCC and LCC metrics provide a way of measuring the cohesion of a class. The higher the TCC and LCC, the more coherent and therefore better the class.

For TCC and LCC, we only consider visible methods (a method is visible if it is not private).

Def : 

	-NP = maximum number of possible connections = N * (N - 1) / 2 where N is the number of methods
	-NDC = number of direct connections (number of edges in the connection graph)
	-NID = number of indirect connections (methods are not directly connected, but are connected via other methods)
	Example: A - B - C are direct connections. A is indirectly connected to C (via B)

Tight class cohesion TCC = NDC / NP

Loose class cohesion LCC = (NDC + NID) / NP

TCC = LCC ==> NID=0
