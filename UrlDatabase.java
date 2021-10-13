import java.io.*;
import java.util.*;

class UrlDatabase{

    static Hashtable<String, Integer> registry = new Hashtable<String, Integer>();

    public static void main(String[] args){
        Console cnsl= System.console();
        while(true){
            System.out.println("Select options \nstoreurl\nget\ncount\nlist");

            String inp = cnsl.readLine("Enter your command : ");
            String[] inpSplit = inp.split("\\s+");
            
            try{
                if(inpSplit.length == 2){
                    loopQues(inpSplit[0], inpSplit[1]);
                }else if(inpSplit.length == 1){
                    loopQues2(inp);
                }
            }catch(Exception e){

            }
            System.out.println("\n\n\n\n");
        }
    }
    
    public static void loopQues(String command, String url){
        switch (command) {
            case "storeurl":
                storeurl(url);
                break;
            case "get":
                System.out.println(get(url));
                break;
            case "count":
                System.out.println(count(url));
                break;
            default:
                System.out.println("Enter Valid Command");
                break;
        }
    }

    public static void loopQues2(String command){
        switch (command) {
            case "list":
                list();
                break;
            case "exit":
                exit();
            default:
                System.out.println("Enter Valid Command");
                break;
        }
    }

    public static void storeurl(String url){
        generateShortKey(url);
    }


    public static void generateShortKey(String url){
        String[] urlSplitted = url.split("\\.");
        if(urlSplitted[0].equals("www")){
            if(!(registry.containsKey(urlSplitted[1]))){
                registry.put(urlSplitted[1], 0);
                System.out.println("Stored item succesfully");
            }
                
        }else if(urlSplitted.length == 2 && !urlSplitted[0].equals("www")){
            if(!registry.containsKey(urlSplitted[0])){
                registry.put(urlSplitted[0], 0);
                System.out.println("Stored item succesfully");
            }
        }
    }

    public static String get(String url){
        String[] urlSplitted = url.split("\\.");
        if(urlSplitted.length == 3){
            if(registry.containsKey(urlSplitted[1])){
                registry.put(urlSplitted[1], registry.get(urlSplitted[1])+1);
                return(urlSplitted[1]);
            }else{
                return("Invalid url format!");
            }
        }else if(urlSplitted.length == 2){
            if(registry.containsKey(urlSplitted[0]) && !urlSplitted[0].equals("www")){
                registry.put(urlSplitted[0], registry.get(urlSplitted[0])+1);
                return(urlSplitted[0]);
            }else{
                return("Invalid url format!");
            }
        }else{
            return("Invalid url format!");
        }
    }

    public static Integer count(String url){
        String[] urlSplitted = url.split("\\.");
        if(urlSplitted.length == 3){
            if(registry.containsKey(urlSplitted[1])){
                return(registry.get(urlSplitted[1]));
            }else{
                return(-1);
            }
        }else if(urlSplitted.length == 2){
            if(registry.containsKey(urlSplitted[0]) && !urlSplitted[0].equals("www")){
                return(registry.get(urlSplitted[0]));
            }else{
                return(-1);
            }
        }else{
            return(-1);
        }
    }

    public static void list(){
        System.out.println(registry); 
    }

    public static void exit(){
        System.exit(0);
    }

}
