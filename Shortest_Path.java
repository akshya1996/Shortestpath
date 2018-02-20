/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.io.*; 
import static java.lang.System.exit;
import java.util.ArrayList;

/**
 *
 * @author akshya1996
 */
public class Shortest_Path {
     static class Node
    {
       String state;
       int depth;
       double cost;
       Node parent;
       Node(String name, int d, double c,Node p){
       this.state=name;
       this.depth=d;
       this.cost=c;
       this.parent=p;
       }
       public  double getcost()
       {
           return cost;
       }
        public String getstate()
       {
           return state;
       }
         public  int getdepth()
       {
           return depth;
       }
          public  Node getparent()
       {
           return parent;
       }
      
    }
    static int index=0;
    static int i=0;
    static int dislength;
    static int sourcelen;
    static int deslen;
    static int present=0;
    static ArrayList source=new ArrayList();
    static ArrayList destination=new ArrayList();
    static ArrayList distance=new ArrayList();
    static String[] parts=new String[3];
    static ArrayList<String> visited=new ArrayList<String>();   
    static ArrayList fringe=new ArrayList();
    static String destinat;
    static String dist;
    static int dis;
    static int statereached=0;
     static int depth=0;
    public static void main (String[] args) throws IOException
 {

     try {
                        Scanner scanner=new Scanner(System.in);
			File file = new File(args[0]);//getting input.txt file from command line
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			//storing the source in a source array list, destination cities in destination array list and the corresponsing distance in distance array list
			while ((line = bufferedReader.readLine()) != null) 
                        {
                              if(line.contains("END OF INPUT"))
                              {
                              }
                              else{
                          //  System.out.println(line);
                            parts=line.split(" ");
                            source.add(parts[0]);
                            destination.add(parts[1]);
                            distance.add(parts[2]);
                            i++;
                            
                                  

			}}
			fileReader.close();
			
int k,l;
  
       
     
     
      // System.out.println("Enter the source ");
       String s = args[1];//gets the source 
 
      // System.out.println("Enter the destination ");
       String d= args[2];//gets the destination
      
       int depth=0;//initially the depth is set to zero
       int first=0;//flag first checks if its the first node to be added to the fringe, if first then zero else it is 1
     //node initialization: the state is set to null, the parent is set to null, the cost is set to 0 and the depth is set to 0
	 Node so=new Node(null,0,0,null);
     int n=source.size();
     k=0;
	 //find all paths from the source to the destination from the source to destination array
     for(k=0;k<n;k++)
     {
     String name= (String)source.get(k);   
               //System.out.println(name);
               //System.out.println(s);
         if(name.equals(s) && !visited.contains(s))
         {
             //if it is the first node then set create a new node and add it to the fringe
             if(first==0)
             {
             //System.out.println("Im here");
             so=new Node(s,depth,0,null);
             first=1;
             fringe.add(index,so);
             index++;
             
            // Node killing=(Node)fringe.get(0);
            // System.out.println(killing.getstate());
             depth=depth+1;
             }
             String destinat=(String)destination.get(k);
             String dist=(String)distance.get(k);
             int dis=Integer.parseInt(dist);
             Node newn=new Node(destinat,depth,dis,so);
             fringe.add(index,newn);
             index++;
             
         }
        
     }
//     System.out.println("Fringe");
//     n=fringe.size();
//     for(k=0;k<n;k++)
//     {
//         System.out.println(k);
//         Node haha=(Node)fringe.get(k);
//         System.out.println(haha.getstate());
//     }
     
     depth=0;
	 //Similarly, find the source in the destination array and find the corresponding distance from destination to the source
     for(k=0;k<destination.size();k++)
     {
         // System.out.println(k);
         String name= (String)destination.get(k);   
        // System.out.println(name);
        // System.out.println(s);
         if(name.equals(s) && !visited.contains(s))
         {
             //System.out.println(k);
            // System.out.println("Hey");
			//if it is the first node then initialize it and add it to the fringe 
             if(first==0)
             {
             so=new Node(s,depth,0,null);
             first=1;
             fringe.add(so);
             depth=depth+1;
             }
             
             String destinat=(String)source.get(k);
             String dist=(String)distance.get(k);
             int dis=Integer.parseInt(dist);
             Node newn=new Node(destinat,depth,dis,so);
             fringe.add(newn);
            
             
         }
     }
//      System.out.println("Fringe");
//     n=fringe.size();
//     for(k=0;k<n;k++)
//     {
//         System.out.println(k);
//         Node haha=(Node)fringe.get(k);
//         System.out.println(haha.getstate());
//     }
//this is the second part of the code
visited.add(s);//once the source node is expanded , add it to the visited array
     

while(!fringe.isEmpty())
       {
           
           //sort the fringe;
           //https://stackoverflow.com/questions/20082266/how-do-you-sort-an-arraylist
        int j;
        
        Node swap;
        n = fringe.size();

        for (k = 0; k < (n - 1); k++) {
            for (j = 0; j < n - k - 1; j++) {
                Node no=(Node)fringe.get(j);
                Node no1=(Node)fringe.get(j+1);
                if (no.getcost() > no1.getcost()) {
                    swap = (Node)fringe.get(j);
                    fringe.set(j, fringe.get(j + 1));
                    fringe.set(j + 1, swap);
                }
            }
        }
//        System.out.println("!!!!!!!!!!!!!!!!!!!!!Elements in the Fringe!!!!!!!!!!!!!!!!!!!!");
//        for(k=0;k<fringe.size();k++)
//        {
//            Node please=(Node)fringe.get(k);
//            System.out.println(please.state);
//        }
//        System.out.println("!!!!!!!!!!!!!!!!!!!!!Fringe End!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//        System.out.println("!!!!!!!!!!!!!!!!!!!!!Elements in the Visited!!!!!!!!!!!!!!!!!!!!");
//        for(k=0;k<visited.size();k++)
//        {
//          
//            System.out.println(visited.get(k));
//        }
//        System.out.println("!!!!!!!!!!!!!!!!!!!!!Visited End!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        //now pull the node with the least cost
        Node least=(Node)fringe.get(0);
        //if it is the goal state
        //System.out.println(least.state);
        if((least.state).equals(d))
        {  System.out.println("*****************PATH FOUND******************");
           


   System.out.println("DISTANCE :"+least.getcost());//cost of the entire path
   System.out.println("ROUTE:");  
         statereached=1;
           double totalcost=least.getcost();
           double prevcost=totalcost;
           Node trace=least.getparent();
           System.out.print(d+" to ");
           while(trace!=null)
           {
               String name=trace.getstate();
               double tracecost=trace.getcost();
               totalcost=prevcost-tracecost;
               prevcost=tracecost;
               //System.out.println(totalcost);
               System.out.print(name+"      ");
               System.out.println(totalcost+"km");
               if(name!=s)
               System.out.print(name+" to ");
               trace=trace.getparent();
           }
           exit(0);
        }
        fringe.remove(0);
   //     System.out.println("Removed");
        depth=depth+1;
//        //now expand the first node
//        //when the node exists in the source side    
        if(!fringe.isEmpty()){
               Node newsource=(Node)fringe.get(0);//getting the first node
               double cost=newsource.getcost();//getting its cost to add to cum cost of its descendents
               String newstate=newsource.getstate();//getting the name of the node
//              System.out.println("*****************Node to be expanded******************"); 
//              System.out.println("Name:"+newstate);
//              System.out.println("Cost:"+cost);
               int presentfringe=0;
              if(!visited.contains(newstate)) 
              {
//             //niw traverse the source array list to get the names of descendents
             for(k=0;k<source.size();k++)
           {
            String saveme=(String)source.get(k);
               if(saveme.equals(newstate))
                {
                    String des=(String)destination.get(k);
                    String dist=(String)distance.get(k);
                    int dist1=Integer.parseInt(dist);
                    dist1=dist1+(int)cost;//cumulative cost
                     
                     Node newnode1=new Node(des,depth,dist1,newsource);
                     
                     for(int y=0;y<fringe.size();y++)
                     {
                         Node fringenode=(Node)fringe.get(y);
                         String checknames=fringenode.getstate();
                         double checkcosts=fringenode.getcost();
                         if(checknames.equals(des))
                         {
                             presentfringe=1;
                          }
                     
                     }
                     
//                     //now add it to the fringe
                     if(!visited.contains(des)&&(presentfringe==0))
                     fringe.add(newnode1);
                     else
                     {
                      for(int q=0;q<fringe.size();q++)
                      {
                         Node hey=(Node)fringe.get(q);
                         String checkname=hey.getstate();
                         double checkcost=hey.getcost();
                         if(checkname.equals(des))
                         {
                             if(dist1<checkcost)
                             {
                                 fringe.remove(hey);
                                 fringe.add(newnode1);
                             }
                         }
                         
                      }
                     }
                }
                }


         presentfringe=0;

            //niw traverse the destination array list to get the names of descendents
           for(k=0;k<source.size();k++)
            {
              String newstatename=(String)destination.get(k);
              if(newstatename.equals(newstate))
             {
                     String des=(String)source.get(k);
                     String dist=(String)distance.get(k);
                     int dist1=Integer.parseInt(dist);
                     dist1=dist1+(int)cost;//cumulative cost
                     Node newnode1=new Node(des,depth,dist1,newsource);
                      //now add it to the fringe
                       for(int y=0;y<fringe.size();y++)
                     {
                         Node fringenod=(Node)fringe.get(y);
                         String checknames=fringenod.getstate();
                         double checkcosts=fringenod.getcost();
                         if(checknames.equals(des))
                         {
                             presentfringe=1;
                          }
                     
                     }
                      if(!visited.contains(des)&&(presentfringe==0))
                          fringe.add(newnode1);
                       else
                     {
                      for(int q=0;q<fringe.size();q++)
                      {
                         Node fringenode=(Node)fringe.get(q);
                         String checkname=fringenode.getstate();
                         double checkcost=fringenode.getcost();
                         if(checkname.equals(des))
                         {
                             if(dist1<checkcost)
                             {
                                 fringe.remove(fringenode);
                                 fringe.add(newnode1);
                             }
                         }
                         
                      }
                     }
                 }
             }
             
             
         visited.add(newstate);
       }  } 
        
     }
       if(statereached==0)
       {
           System.out.println("DISTANCE : infinity");
           System.out.println("ROUTE : None");
       }
       
 
                        
		} 
                catch (IOException e) 
                {
			e.printStackTrace();
		}
 }//end of main 
    
    
    
    
    
    
    

  
}


