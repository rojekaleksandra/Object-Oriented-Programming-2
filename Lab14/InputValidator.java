import java.util.List;
import java.util.ArrayList;
import java.util.regex.*;

public class InputValidator {

    public List<String> validate (String[] args){
        List<String> list = new ArrayList<>();
        if(args.length < 4){
            list.add("Wrong number of parameters");
            return list;
        }
        try{
            Long.parseLong(args[3]);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        Pattern p1 = Pattern.compile("^(19[0-9]{2}|2[0-9]{3})-(0[1-9]|1[012])-([123]0|[012][1-9]|31)$");
        Matcher m1 = p1.matcher(args[0]);
        if(!m1.matches()){
            list.add("First argument should be date with format yyyy-MM-dd");
        }
        p1 = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9](:[0-5][0-9])?");
        m1 = p1.matcher(args[1]);
        if(!m1.matches()){
            list.add("Second argument should be time with format HH:mm:ss");
        }
        p1 = Pattern.compile("\\b[a-zA-Z]{3}\\b");
        m1 = p1.matcher(args[2]);
        if(!m1.matches()){
            list.add("Third argument should be exactly 3 letters long");
        }
        p1 = Pattern.compile("[0-9]+");
        m1 = p1.matcher(args[3]);
        if(!m1.matches()){
            list.add("Fourth argument should be a number");
        }
        return list;
    }
    
}
