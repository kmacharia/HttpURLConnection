/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpurlconnection;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author kmacharia
 */
public class HttpURLConnection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        HttpURLConnection http = new HttpURLConnection();
        System.out.println("\nTesting - sendGet()");
        http.sendGet();
        System.out.println("\nTesting - sendPost");
        http.sendPost();
    }
    
    private void sendGet() throws Exception{
        /*below url expired 48 hours after creation
        create a new endpoint at http://requestb.in/ and paste it below
        
        Alternative find other endpoints on this article: http://www.lornajane.net/posts/2013/endpoints-for-http-testing*/        
        
        String url = "http://requestb.in/18qy8ye1";
        URL obj = new URL(url);
        java.net.HttpURLConnection con = (java.net.HttpURLConnection) obj.openConnection();
        con.setRequestProperty("User-agent", "Chrome");
        
        int responseCode = con.getResponseCode();
        System.out.println("SENDING GET request to url: "+url);
        System.out.println("RESPONSE CODE ="+responseCode);
        System.out.println("CONTENT TYPE ="+con.getContentType());
        
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while((inputLine=in.readLine())!=null){
            response.append(inputLine); 
        }
        in.close();
        System.out.println("RETURNED CONTENT:\n"+response.toString());
    }
    
    public void sendPost() throws Exception{
        String url = "yoururl";
        URL obj = new URL(url);
        java.net.HttpURLConnection con = (java.net.HttpURLConnection) obj.openConnection();        
        //default is GET, for POST you have to specify it
        con.setRequestMethod("POST");
        con.setRequestProperty("User_Agent", "Chrome");
        con.setRequestProperty("Accept-Language", "en-us,en;q=0.5");
        
        String urlParameters = "";
        
        //add reuqest header
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        
        int responseCode = con.getResponseCode();
        System.out.println("Sending Post request to URL: "+url);
        System.out.println("Post parameters: "+urlParameters);
        System.out.println("Response code: "+responseCode);
        System.out.println("CONTENT TYPE ="+con.getContentType());
        
        BufferedReader in  = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        
        while((inputLine=in.readLine())!=null){
            response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());
    }
}
