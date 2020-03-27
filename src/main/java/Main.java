import java.util.*;
class save 
{ 
    public int no; 
    public String name; 
    save(int no, String name) 
    { 
        this.no = no; 
        this.name = name; 
    } 
}
class Graph<T> { 

    save[] arr;
    // We use Hashmap to store the edges in the graph 
    private Map<T, List<T> > map = new HashMap<>(); 
  
    // This function adds a new vertex to the graph 
    public void addVertex(T s) 
    { 
        map.put(s, new LinkedList<T>()); 
    } 
  
    // This function adds the edge between source to destination 
    public void addEdge(T source, T destination, boolean bidirectional) 
    { 
  
        if (!map.containsKey(source)) 
            addVertex(source); 
  
        if (!map.containsKey(destination)) 
            addVertex(destination); 
  
        map.get(source).add(destination); 
        if (bidirectional == true) { 
            map.get(destination).add(source); 
        } 
    } 
  
    // This function gives the count of vertices 
    public void getVertexCount() 
    { 
        System.out.println("The graph has "+ map.keySet().size() + " vertex"); 
    } 
  
    // This function gives the count of edges 
    public void getEdgesCount(boolean bidirection) 
    { 
        int count = 0; 
        for (T v : map.keySet()) { 
            count += map.get(v).size(); 
            
        } 
        if (bidirection == true) { 
            count = count / 2; 
        } 
        System.out.println("The graph has "+ count + " edges."); 
    } 
  
    // This function gives whether a vertex is present or not. 
    public void hasVertex(T s) 
    { 
        if (map.containsKey(s)) { 
            System.out.println("The graph contains " + s + " as a vertices."); 
        } 
        else { 
            System.out.println("The graph does not contain " + s + " as a vertex."); 
        } 
    } 
  
    // This function gives whether an edge is present or not. 
    public void hasEdge(T s, T d) 
    { 
        if (map.get(s).contains(d)) { 
            System.out.println("The graph has an edge between " + s + " and " + d + "."); 
        } 
        else { 
            System.out.println("The graph has no edge between " + s + " and " + d + "."); 
        } 
    } 
  
    // This function is a helper function to initialize and fill the array. 
   
    public void count()
    {
        int count=0,i=0;
        arr = new save[map.keySet().size()];
        for (T v : map.keySet()) {
           for (T w : map.get(v)) { 
             count++;  
           } 
           arr[i] = new save(count,v.toString()); 
           count=0;
           i++;
        }
    }
	//This function Prints the graph.
    public String toString() 
    { 
        StringBuilder builder = new StringBuilder(); 
  
        for (T v : map.keySet()) { 
            builder.append(v.toString() + ": "); 
            for (T w : map.get(v)) { 
                builder.append(w.toString() + " "); 
            }
            builder.append("\n"); 
            
        } 
  
        return (builder.toString()); 
    } 
	//This function find the max vertices which has max node connected.
    void findmax()
    {
        count();
        int max=0, position=-1;
        for(int i=0;i<arr.length;i++)
        {
         if(arr[i].no>=max)
          {
            max=arr[i].no;
            position=i;
          }
        }
        frequency(position,max);
    }
	void print(int position,int max)
	{
		System.out.println();
        System.out.print("Virus should Attack vertex '"+ arr[position].name+"' Which has "+max+" node connected");
	}
	//This function finds the frequency of a number
	void frequency(int pos,int x) 
    { 
        
		int n=arr.length;
        for (int i=0; i < n; i++) 
        if (arr[i].no == x) 
		{			
			print(i,x);
		}
    } 
}

public class Main extends ReadLinesInFile{
	
		String data;
		//Contructor to initialize the file path of the data
		Main(){
			data="data.txt";
		}
     
    public static void main(String ag[])
    {	Main ob=new Main();
		String check;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the File Path [Default:data.txt]");
		check=sc.nextLine();
		if(check.equals(""))
		{
			
		}
		else
			ob.data=check;
		
        
        int c=ob.count(ob.data);
        String [][] data = new String[c][2]; 
        Graph<String> g = new Graph<String>(); 
        data=ob.read(ob.data);
        //populate the Map with data
        for(int i=0;i<c;i++)
        {
            g.addEdge(data[i][0],data[i][1] , true); 
        }
        
        // print the graph. 
        //System.out.println("Graph:\n" + g.toString()); 
  
        // gives the no of vertices in the graph. 
        g.getVertexCount(); 
  
        // gives the no of edges in the graph. 
        g.getEdgesCount(true); 
  
        // tells whether the edge is present or not. 
        //g.hasEdge("Q0085", "YBL099W"); 
  
        // tells whether vertex is present or not 
        //g.hasVertex("Q0085"); 
       
        //  for (int i = 0; i < g.arr.length; i++) 
        //     System.out.println("Element at " + i + " : " + 
        //                 g.arr[i].no +" "+ g.arr[i].name); 
        //for(int i=0;i<24743;i++)
        //System.out.println(g.arr[i]+"#");
          g.findmax();
    }
}
