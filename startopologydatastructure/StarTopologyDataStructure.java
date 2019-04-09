/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startopologydatastructure;

/**
 *
 * @author carlos
 */
import java.util.ArrayList;
import java.util.Scanner;
public class StarTopologyDataStructure {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        //String[] commands = new String[3];
        String menu = "";
        Star star = new Star();
        System.out.println("**************************************************************");
        System.out.println("******************* Welcome to the Network *******************");
        System.out.println("*** This a Star network topology for you to configure      ***");
        System.out.println("*** The Server (main node) was alredy configured for you   ***");
        System.out.println("*** Your task is to add the nodes                          ***");
        System.out.println("**************************************************************");
        System.out.println("*** Server Configurations                                  ***");
        star.server();
        System.out.println("*** Type help to see the commands and how to add nodes     ***");
        System.out.println("*** Type exit to exit the software                         ***");
        
        do{
            menu = in.nextLine();    
            
            if(menu.compareTo("help") == 0)
                help();
            else if(menu.compareTo("show") == 0)
                star.printNodes();
            else if(menu.compareTo("removeAll") == 0)
                star.clearTopology();
            else if(menu.compareTo("send") == 0){
                String nodeSrc, nodeDst, message;
                System.out.println("Source node: ");
                nodeSrc = in.next();
                in.nextLine();
                System.out.print("Destination node: ");
                nodeDst = in.next();
                in.nextLine();
                System.out.print("Message: ");
                message = in.nextLine();
                
                if(star.getClient(nodeSrc) == null && star.getClient(nodeDst) == null){
                     System.out.println("Opps... The nodes doe not exist!");
                }
                else if(star.getClient(nodeSrc) == null){
                    System.out.println("Opps... The source client does not exist!");
                }
                else if(star.getClient(nodeDst) == null){
                    System.out.println("Opps... The destination client does not exist!");
                }
                else{
                    star.getClient(nodeSrc).send(star.getClient(nodeDst),message);
                }
                                
            }
            else{
                String[] commands = menu.split(" ");
                if(commands[0].compareTo("addNode") == 0){
                    star.insertNode(commands[1],commands[2]);                
                }
                if(commands[0].compareTo("delNode") == 0){
                    star.deleteNode(star.getClient(commands[1])); 
                
                }
                if(commands[0].compareTo("seeMsgs") == 0){
                    if(star.getClient(commands[1]) != null)
                        star.getClient(commands[1]).receive();
                }
                
            }
            
        }while(menu.compareTo("exit") != 0);
       
        
        
        
        
        
        /*
        Star star = new Star();
        
        star.insertNode("NODE1");
        star.insertNode("NODE2");
        star.insertNode("NODE3");
        star.insertNode("NODE3");
        star.insertNode("NODE4");
        
        //System.out.println(star.getClient("NODE4"));
        // check if the sender exists before send
        star.getClient("NODE4").send(star.getClient("NODE1"),"HELLO NODE 1");
        star.getClient("NODE3").send(star.getClient("NODE2"),"HELLO NODE 2");
        star.deleteNode(star.getClient("NODE1"));
        star.getClient("NODE3").send(star.getClient("NODE1"),"HELLO NODE 1");
        //star.getClient("NODE1").send(star.getClient("NODE1"),"I do not exist");
        
        // check if the node exist before printing the message
        //star.getClient("NODE1").receive();
        star.getClient("NODE2").receive();
        //star.printNodes();*/
    }
    public static void help(){
        System.out.println("List of commands and their explanation");
        System.out.println("show: show the nodes in the topology");
        System.out.println("addNode: to add new node Eg. add nodeID nodeType");
        System.out.println("delNode: to delete a node Eg. delNode nodeID");
        System.out.println("send: prompts you to a menu to send a message");
        System.out.println("seeMsgs: shows the messages received by a node Eg. seeMsgd nodeID");
        System.out.println("removeAll: removes all the nodes from the topology");
    }
}
