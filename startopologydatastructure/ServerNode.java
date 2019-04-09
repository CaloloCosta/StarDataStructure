/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startopologydatastructure;

import java.util.ArrayList;

/**
 *
 * @author carlos
 */
public class ServerNode<T>{
    private String serverID;
    private String serverType;
    private ArrayList<ClientNode> nodePointers = new ArrayList();
    private  int nodesNumber = 0;
    
    public ServerNode(String serverID, String serverType){
        this.serverID = serverID;  
        this.serverType = serverType;
    }
    public void clearTopology(){
        nodePointers.clear();
        nodesNumber = 0;
        System.out.println("All the nodes have been removed!");
    }
    /* getters */
    public String getServerID(){
        return this.serverID;
    }
    public String getServerType(){
        return this.serverType;
    }
    
    // adding a node to the server
    public void addNode(ClientNode cn){
        nodePointers.add(cn);
        nodesNumber++;
    }
    
    // get specific client by IP
    public ClientNode getClient(T ip){
        int i = 0;
        while(i < nodePointers.size()){
            if(nodePointers.get(i).getClientID().toString().compareTo(ip.toString()) == 0)
                return nodePointers.get(i);
            i++;
        }
        return null;    
    }
    
    
    // check if an ip was entered alredy and returns the index, else returns -1
    public int check(T ip){
        int i = 0;
        while(i < this.nodePointers.size()){
            if(nodePointers.get(i).getClientID().toString().compareTo(ip.toString()) == 0)
                return i;        
            i++;
        }
        return -1;    
    }
    // broker the message
    public void broker(ClientNode from, ClientNode dest, String message){
        if(from == null)
            System.out.println("Opps... Sender node does not exist!");
        else if(dest == null)
            System.out.println("Opps... Destination node does not exist!");
        else{
            String formatMessage = "client "+from.getClientID()+" sends \""+message+"\" to client "+dest.getClientID();
            dest.saveMessage(formatMessage);            
        }
    }
    
    // remove a node
    public void removeNode(int index){
        nodePointers.remove(index);
        this.nodesNumber--;
    
    }
    
    public ClientNode getNodes(int index){
        return this.nodePointers.get(index);
    
    }
    
    public int getNodesNumber(){
        return nodesNumber;
    }
    // print server and its nodes
    public void printTopology(){
        int n = 0;
        System.out.print("\n"+this.serverID+" points to: ");
        while(n < this.nodesNumber){
            System.out.print(this.nodePointers.get(n));
            n++;
        }
        
    
    }
    
    @Override
    public String toString(){
        return this.serverID+"";
    }
    
    

   
}
