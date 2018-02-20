                                                                            ASSIGNMENT 1
Name: Akshya Srinivasa Raghavan
UTA ID: 1001547268
Language: Java
Section: 5360-001


Structure of the Code:
1.	First the code traverses through the entire file to put all the source cities in a source array list, destination cities in destination array list and their corresponding distances in distance array list
2.	Now the code checks if it’s the first array to be inserted into the fringe, the source city is checked for the source array list to find its corresponding paths to other cities in the destination array list
3.	Similarly, the source city is checked for in the destination array list to find the corresponding paths to the source array list.
4.	Now the source array after expansion is added the visited array list
5.	The fringe is now sorted based on the cumulative cost in an ascending order
6.	We remove the first node and check if it is the goal state
7.	If it is the goal state, the path is traversed until the parent is null and the corresponding distance and the total distance to reach is printed on the screen
8.	If it is not the goal state, then we take the next lowest node check if this node is already visited and is present in the fringe
9.	If its already visited , then this node is not expanded and if the node is already present in the fringe, we check if this cumulative cost is less than the cumulative cost of the node being compared to. The node with the lower cost is retained in the fringe. 
10.	Else this is expanded by following steps  2 and step 3
11.	Even after these steps, if the fringe becomes empty and the state is not found, then there is no path between the source and the destination 




Compilation Steps:
1.	vi Shortest_Path.java
2.	javac Shortest_Path.java
Sample Input 1:
3.	java Shortest_Path input.txt Bremen London
Sample Output:
DISTANCE : infinity
ROUTE : None
Sample Input 2:
4.	java Shortest_Path input.txt Bremen Frankfurt
Sample Output:
*****************PATH FOUND******************
DISTANCE :455.0
ROUTE:
Frankfurt to Dortmund      221.0km
Dortmund to Bremen      234.0km                      
