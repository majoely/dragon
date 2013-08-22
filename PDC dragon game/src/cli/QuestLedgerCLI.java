package cli;

public class QuestLedgerCLI{
    
    private QuestLedger questLog;
    
    @SuppressWarnings("empty-statement")
    public QuestLedgerCLI(QuestLedger questLog){
        this.questLog = questLog
        String[] com = {"help", "list"};
        this.commands = com;
        this.commandInterface();
    }
    
     private void commandInterface(){
        Scanner in = new Scanner(System.in);
        this.printCommands();
        String input =null;
        boolean exit = false;
        while(!exit){
            System.out.print("Quest: ");
            input = in.nextLine();
            switch(input){
                case "help" : printCommands();
                break;
                case "current" : listCurrent();
                break;
                case "completed" : listCompleted();
                break;
                default : System.out.println("invalid command");
                System.out.println("enter help to see commands");
                break;
            }
        }
    }
    
    /*
     * Method for printing all of the commands available in the Quest Ledger menu
     */
    private void printCommands(){
        System.out.print("Commands: ");
        for(int i = 0; i < this.commands.length; i++){
            System.out.print(this.commands[i] + " ");
        }
        System.out.print("\n");
    }
    
    /*
     * 
     */
    void listCurrent(){
        
    }
    
    /*
     * 
     */
    void listCompleted(){
        
    }
    
}