package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DataService extends Remote {
    Object requestData(String studentCode, String qCode) throws RemoteException;
    void submitData(String studentCode, String qCode, Object data) throws RemoteException;
}
