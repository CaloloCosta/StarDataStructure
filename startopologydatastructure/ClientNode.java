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
public class ClientNode{
    private String clientID;
    private String nodeType;
    private ArrayList<String> clientMessage = new ArrayList();
    private ServerNode sn;
    
    public ClientNode(String clientID, String nodeType, ServerNode sn){
        this.clientID = clientID;
        this.nodeType = nodeType;
        this.sn = sn;
    }
    public String getClientID(){
        return clientID;
    }
    public String getNodeType(){
        return this.nodeType;
    }
    // save the messages
    public void saveMessage(String message){
        clientMessage.add(message);
    }
    
    /*
        The send( ) method is naturally a wrapper around a call to an appropriate method on
            the server node.
    */
    public void send(ClientNode receiver, String messageContent){
        sn.broker(this,receiver,messageContent);    
    }
    
    /* The receive( ) method need do nothing more than print the message and the name/id of
        the sender. It need only be sequential.
        e.g. client X sends "hello" to client Y who prints the message.
    */
    public void receive(){
        int i = 0;
        while(i < clientMessage.size()){
            System.out.println(clientMessage.get(i));
            i++;
        }
    
    }
    
    @Override
    public String toString(){
        return "ID: "+this.getClientID()+" type: "+this.getNodeType();
    }
    

    
}
