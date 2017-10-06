package assignment8_2;
import java.io.*;
import java.net.*;
public class Assignment8_2 {
    public static void main(String[] args) throws Exception{
        String sentence;
        String modifiedSentence; 
        BufferedReader inFromUser =new BufferedReader(new InputStreamReader(System.in)); 
        Socket clientSocket = new Socket("localhost", 6789); 
        while (true) 
        {
            DataOutputStream outToServer =
            new DataOutputStream(clientSocket.getOutputStream()); 
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 
            sentence = inFromUser.readLine(); 
            outToServer.writeBytes(sentence + '\n'); 
            if (sentence.equals("EXIT")) 
            {
                break;
            } 
            modifiedSentence = inFromServer.readLine(); 
            System.out.println("FROM SERVER: " + modifiedSentence);
        }
        clientSocket.close();
    }
}      

