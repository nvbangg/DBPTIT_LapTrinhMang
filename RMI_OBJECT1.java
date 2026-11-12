import java.rmi.Naming;
import RMI.ObjectService;
import RMI.TicketSla;

public class RMI_OBJECT1 {
    public static void main(String[] args) throws Exception {
        ObjectService service = (ObjectService) Naming.lookup("rmi://36.50.135.242/RMIObjectService");
        String studentCode = "B23DCCN067";
        String qCode = "xznpNIyq";

        TicketSla ticket = (TicketSla) service.requestObject(studentCode, qCode);
        String priority = ticket.getPriority();
        int hours = ticket.getOpenedHoursAgo();
        int limit = 72;
        switch (priority) {
            case "CRITICAL": limit = 2; break;
            case "HIGH": limit = 8; break;
            case "MEDIUM": limit = 24; break;
        }
        ticket.setBreached(hours > limit);
        String action = "MONITOR";
        if (ticket.isBreached()) {
            action = priority.equals("CRITICAL") || hours > 96 ? "ESCALATE_L2" : "ESCALATE_L1";
        }
        ticket.setAction(action);

        service.submitObject(studentCode, qCode, ticket);
    }
}
