public class Event extends Task{
    private String from;
    private String to;

    //variable x stands for isDone
    public Event(String d, boolean x) {
        super(d,x);
        setFromAndTo(d);
    }

    public void setFrom(String newFrom) {
        this.from = newFrom;
    }

    public void setFromAndTo(String description) {
        String[] words = description.split(" ", 2);
        try {
            String[] splitFrom = words[1].split("/from ");
            setDescription(splitFrom[0]);
            String[] splitTo = splitFrom[1].split("/to ");
            setFrom(splitTo[0]);
            setTo(splitTo[1]);
        } catch(ArrayIndexOutOfBoundsException e) {
            //error message display is at main class
        }
    }

    public void setTo(String newTo) {
        this.to = newTo;
    }

    public String getFrom(){
        return from;
    }

    public String getTo(){
        return to;
    }

    @Override
    public String toTextFile(){
        String result = "";
        if (!getIsDone()){
            result = "[E][ ] "+ getDescription() + "(from: " + getFrom() + "to: "+ getTo() +")";
        }else {
            result = "[E][X] "+ getDescription() + "(from: " + getFrom() + "to: "+ getTo() +")";
        }
        return result;
    }

    @Override
    public void printTask(){
        if (!getIsDone()){
            System.out.println("[E][ ] "+ getDescription() + "(from: " + getFrom() + "to: "+ getTo() +")");

        }else {
            System.out.println("[E][X] "+ getDescription() + "(from: " + getFrom() + "to: "+ getTo() +")");
        }

    }
}