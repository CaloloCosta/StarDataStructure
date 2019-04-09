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
public class Star<T> {
    ServerNode server;
    ClientNode client;
    
    public Star(){
        server = new ServerNode("SERVER","FILE-SERVER");
    }
    // print server Configurations
    public void server(){
        System.out.println("*** Server ID: "+server.getServerID());
        System.out.println("*** Server Type: "+server.getServerType());
        System.out.println("**************************************************************");
    }
    // Insert a node
    public void insertNode(String id, String nodeType){
        client = new ClientNode(id,nodeType,this.server);
        if(server.check(client.getClientID()) == -1){
            server.addNode(client);
            System.out.println(client.getClientID()+" Was added!");
        }else{
            System.out.println("The followig nodeID was added already!");
        }
            
    }
    // get a specific client
    public ClientNode getClient(T ip){
        return server.getClient(ip);
    }
    // delete nodes from the model
    public void deleteNode(ClientNode cn){
        // check first if the node exist
        int index = server.check(cn.getClientID());
        if(index != -1)
            server.removeNode(index);
    
    }
    public void clearTopology(){
        server.clearTopology();
    }
    // print nodes
    public void printNodes(){
        int n = 0;
        while(n < server.getNodesNumber()){
            System.out.println((n+1)+" "+server.getNodes(n));
            n++;
        }
    }
    
    // print topology
    public void printTopology(){
        server.printTopology();
    }
}
