import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class SpellChecker implements SpellCheckerInterface{
    
    HashSet<String> dictSet = new HashSet<String>();;
    
    public SpellChecker(String fileName){
        try{
            File file = new File(fileName);
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                String data = scan.nextLine();
                data = data.toLowerCase();
                if (data.contains("'")){
                    String[] dat = data.split("'");
                    data = dat[0] + dat[1];
                    }
                dictSet.add(data);
                }
            scan.close();
            }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }
    
    public List<String> getIncorrectWords(String fileName){
        List<String> strList = new ArrayList<String>();
        try{
            File file = new File(fileName);
            Scanner scan = new Scanner(file);
            HashSet<String> fileHSet = new HashSet<String>();
            while(scan.hasNextLine()){
                String data = scan.nextLine();
                data = data.replace("*","");
                data = data.replace(".","");
                data = data.replace("(","");
                data = data.replace(")","");
                data = data.replace("_","");
                data = data.replace("<","");
                data = data.replace(">","");
                data = data.replace("=","");
                data = data.replace("+","");
                data = data.replace("-","");
                data = data.replace("}","");
                data = data.replace("{","");
                data = data.replace("[","");
                data = data.replace("]","");
                data = data.replace(":","");
                data = data.replace(",","");
                data = data.replace("?","");
                data = data.replace("!","");
                data = data.replace("'","");
                String[] dat = data.split(" ");
                for(String st: dat){
                    int i = st.length();
                    if (i>0){
                        st = st.toLowerCase();
                        fileHSet.add(st);
                    }
                }
            }
            for(String str: fileHSet){
                if(dictSet.contains(str)){
                    continue;
                }
                else{
                    strList.add(str);
                }
            }
            return(strList);
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        return null;
    }
    
    public Set<String> getSuggestions(String word){
    Set<String> suggestions = new HashSet<String>();
    String t;
        
    List<String> letters = new ArrayList<String>();
    letters.add("a");
    letters.add("b");
    letters.add("c");
    letters.add("d");
    letters.add("e");
    letters.add("f");
    letters.add("g");
    letters.add("h");
    letters.add("i");
    letters.add("j");
    letters.add("k");
    letters.add("l");
    letters.add("m");
    letters.add("n");
    letters.add("o");
    letters.add("p");
    letters.add("q");
    letters.add("r");
    letters.add("s");
    letters.add("t");
    letters.add("u");
    letters.add("v");
    letters.add("w");
    letters.add("x");
    letters.add("y");
    letters.add("z");
        
    for(int i=0; i <=word.length(); i++){
        for(String s: letters){
            t = word.substring(0, i) + s + word.substring(i);
            if (dictSet.contains(t)){
                suggestions.add(t);
            }
        }
    }
    
    for(int i=0; i <word.length(); i++){
        t = word.substring(0,i) + word.substring(i + 1);
        if(dictSet.contains(t)){
            suggestions.add(t);
        }
        }  
    
    if (word.length()>=2){
    for(int i=0; i<word.length()-1; i++){
        String temp1 = word.substring(i,i+1);
        String temp2 = word.substring(i+1,i+2);
        t = word.substring(0, i) + temp2 + temp1 + word.substring(i+2);
        if (dictSet.contains(t)){
            suggestions.add(t);
        }
        }
    }
    
    return(suggestions);
    }
    
}