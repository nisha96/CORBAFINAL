import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import DEMSApp.DEMS;
import DEMSApp.DEMSHelper;

public class Server {
	public static void main(String args[]) throws Exception {   
		try {
			        String[] data=new String[4];
                                data[0]=args[0];
                                data[1]=args[1];
                                data[2]=args[2];
                                data[3]=args[3];
                                

                                ORB orb = ORB.init(data, null);
						
					
				POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
				rootpoa.the_POAManager().activate();

						
				EventOperationsImpl obj1 = new EventOperationsImpl();
				obj1.setORB(orb);

				org.omg.CORBA.Object ref = rootpoa.servant_to_reference(obj1);
					
				org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
						
						
				NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

						
				NameComponent path[] = ncRef.to_name(args[4]);
				ncRef.rebind(path, ref);

				System.out.println("MTL Server is now running");




	    } catch(Exception e) {
		   System.out.println("Server not started, RETRY!!" + e.getMessage());
		}
	}

	/*public static int getPort(String location) {
		int port = 8000;
		if(location.equals(Locations.MTL)) {
			port = 8000;
		} else if(location.equals(Locations.QUE)) {
			port = 8080;
		} else if(location.equals(Locations.SHE)) {
			port = 8081;
		}
		return port;
	}*/
}