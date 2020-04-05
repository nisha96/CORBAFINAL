import java.rmi.*;
import java.util.HashMap; 
import java.util.Map; 
import java.util.ArrayList;
import java.util.List;

public interface EventOperations extends Remote {
	public String addEvent(String managerId, String eventId, String eventType, int bookingCapacity) throws RemoteException;
	public String removeEvent(String managerId, String eventID, String eventType) throws RemoteException;
	public Map<String, EventDetails> listEventAvailability(String managerId, String eventType) throws RemoteException;
	public String bookEvent(String customerID, String eventID, String eventType) throws RemoteException;
	public List<String> getBookingSchedule(String customerId) throws RemoteException;
	public String cancelEvent(String customerID, String eventID, String eventType) throws RemoteException;
	public Map<String, EventDetails> getServerEventsAvailable(String eventType) throws RemoteException;
	public String bookServerEvent(String customerId, String eventId, String eventType) throws RemoteException;
	public List<String> getServerBookingSchedule(String customerId) throws RemoteException;
	public String cancelServerEvent(String customerId, String eventId, String eventType) throws RemoteException;
}

